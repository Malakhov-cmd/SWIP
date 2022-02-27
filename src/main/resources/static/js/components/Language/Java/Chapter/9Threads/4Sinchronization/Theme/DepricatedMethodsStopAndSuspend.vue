<template>
  <div class="page-theme">
    <b-jumbotron>

      <template #header>
        <router-link to="/Language" class="back-redirect-router-link"
                     v-on:click="this.$eventBus.$emit('redirectToJavaRoad')">
          <div class="cl-btn-redirectToLanguage">
          </div>
        </router-link>
        <div class="page-theme-name">
          Причины, по которым методы stop()
          и suspend () не рекомендованы к применению
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В первоначальной версии Java был определен метод stop(), который просто останавливал поток исполнения, а
              также метод suspend(), который блокировал поток
              исполнения до тех пор, пока другой поток не вызывал метод resume (). У методов
              stop () и suspend () имеется нечто общее: оба пытаются контролировать поведение
              данного потока исполнения без учета взаимодействия потоков.
            </p>
            <p>
              Методы stop (), suspend () и resume () не рекомендованы больше к применению.
              Метод stop(), по существу, небезопасен, а что касается метода suspend(), то, как
              показывает опыт, он часто приводит к взаимным блокировкам. В этом разделе поясняется, почему применение
              этих методов проблематично и что нужно делать, чтобы
              избежать проблем, которые они вызывают.

            </p>

            <p>
              Обратимся сначала к методу stop (). Он прекращает выполнение любых незавершенных методов, включая и run
              (). Когда поток исполнения останавливается, данный
              метод немедленно снимает блокировки со всех объектов, которые он блокировал. Это
              может привести к тому, что объекты останутся в несогласованном состоянии. Допустим, метод TransferThread
              () остановлен посредине перевода денежных средств
              с одного счета на другой: после снятия денежных средств с одного счета, но перед
              их переносом на другой счет. В этом случае объект имитируемого банка оказывается
              поврежденным. А поскольку блокировка снята, этот поврежденный объект будет доступен и другим потокам
              исполнения, которые не были остановлены.
            </p>

            <p>
              Когда одному потоку исполнения требуется остановить другой поток исполнения,
              он никоим образом не может знать, когда вызов метода stop () безопасен, а когда он
              может привести к повреждению объектов. Поэтому данный метод был объявлен не
              рекомендованным к применению. Когда требуется остановить поток исполнения, его
              нужно прервать. Прерванный поток может затем остановиться сам, когда это можно
              будет сделать безопасно.


            </p>
            <p>
              А теперь рассмотрим, что же не так делает метод suspend (). В отличие от метода stop(), метод suspend()
              не повреждает объекты. Но если приостановить поток исполнения, владеющий блокировкой, то эта блокировка
              останется недоступной
              до тех пор, пока поток не будет возобновлен. Если поток исполнения, вызвавший метод suspend (),
              попытается захватить ту же самую блокировку, программа перейде в состояние взаимной блокировки:
              приостановленный поток ожидает, когда его возобновят, а поток, который приостановил его, ожидает снятия
              блокировки.
            </p>

            <p>
              Подобная ситуация часто возникает в ГПИ. Допустим, имеется графический имитатор банка. Кнопка Pause
              приостанавливает потоки денежных переводов, а кнопка
              Resume возобновляет их, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        pauseButton.addActionListener(event -&gt; {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; threads.length; i++)
                threads[i].suspend(); <span class="hljs-comment"
                                            style="color: rgb(113, 149, 168);">//He делайте этого!</span>
        } ) ;
        resumeButton.addActionListener(event -&gt; {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; threads.length; i++)
                threads[i].resume();
        }</pre>
            <p>
              допустим также, что метод pa int Component () рисует график каждого счета, вызывая метод getBalances ()
              для получения массива остатков на счетах. Как поясняется далее, действия обеих кнопок и
              перерисовка происходят в одном
              и том же потоке исполнения, называемом потоком диспетчеризации событий. Рассмотрим следующий сценарий.

            </p>
            <ul>
              <li>
                <p>
                  Один из потоков исполнения, производящих денежные переводы, захватывает
                  блокировку объекта bank.

                </p>
              </li>
              <li>
                <p>
                  Пользователь щелкает на кнопке Pause
                </p>
              </li>
              <li>
                <p>
                  Все потоки исполнения денежных переводов приостанавливаются, но один из
                  них продолжает удерживать блокировку для объекта bank.
                </p>
              </li>
              <li>
                <p>
                  По той же причине график счета должен быть перерисован.
                </p>
              </li>
              <li>
                <p>
                  Метод paint Component () вызывает метод getBalance ( ).

                </p>
              </li>
              <li>
                <p>
                  Этот метод пытается захватить блокировку объекта bank.
                </p>
              </li>
            </ul>
            <p>
              В итоге программа зависает. Поток диспетчеризации событий не может продолжить свое выполнение, поскольку
              блокировкой владеет один из приостановленных
              потоков исполнения. Поэтому пользователь не может активизировать кнопку Resume,
              чтобы возобновить исполнение потоков.

            </p>
            <p>
              Если требуется безопасно приостановить поток исполнения, следует ввести переменную suspendRequested и
              проверить ее в безопасном месте метода run (), т.е. там,
              где данный поток не блокирует объекты, необходимые другим потокам. Когда в данном потоке исполнения
              обнаружится, что переменная suspendRequested установлена, ему придется подождать до тех пор, пока она
              станет вновь доступной.
            </p>

            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 1.", написанной Кейем С.
              Хорстманном.
            </div>
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Почему не следует использовать метод stop()?
        </label>

        <div class="answers-input-option">
          <b-form-radio-group
              v-model="selected"
              :options="options"
              class="mb-3"
              value-field="item"
              text-field="name"
              disabled-field="notEnabled"
          ></b-form-radio-group>
        </div>

        <!-- This is a form text block (formerly known as help block) -->
        <b-form-text id="input-live-help">Выберите один из вариантов ответа</b-form-text>
      </div>

      <div v-show="!showInput">
        <label class="page-theme-question-text">
          Почему не следует использовать метод stop()?
        </label>
        <p class="page-theme-theory-text">
          Ваш ответ: {{ answer }}
        </p>
      </div>

      <div class="box animate" style="" v-show="animationOn">Успех</div>

      <b-btn class="my-b-btn page-theme-btn-submit" v-on:click="Request" v-show="showInput">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false

export default {
  name: "DepricatedMethodsStopAndSuspend",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,

      timeStarted: 0,
      timeEndeded: 0,
      timeSpended: 0,

      selected: 'Он оставляет объекты в несогласованном состоянии',
      options: [
        {
          item: 'Он оставляет объекты в несогласованном состоянии',
          name: 'Он оставляет объекты в несогласованном состоянии'
        },
        {
          item: 'Он тратит слишком много ресурсов на закрытие потока',
          name: 'Он тратит слишком много ресурсов на закрытие потока'
        },
        {
          item: 'Он может не выполнить закрытие потока',
          name: 'Он может не выполнить закрытие потока'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/ninthchapter/', {
        params: {
          numberTheme: 16,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[15].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 8.3
              window.frontendData.language.chapters[8].listThemes[15].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[15].task.answer

          window.frontendData.language.chapters[8].listThemes[15].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[15].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[15].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[15].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[15].task.tryCount + ".", {
            theme: "toasted-primary",
            position: 'top-right',
            duration: 5000,
            fullWidth: false,
            action: {
              text: 'Cancel',
              onClick: (e, toastObject) => {
                toastObject.goAway(0);
              }
            },
          })
          clearInterval(interval)
        }
      }, 1000)
    }
  },
  mounted() {
    if (window.frontendData.language.chapters[8].listThemes[15].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[15].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-9-subtheme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if (pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>