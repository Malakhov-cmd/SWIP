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
          Обработчики необрабатываемых исключений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Метод run () потока исполнения не может генерировать никаких проверяемых
              исключений, но может быть прерван непроверяемым исключением. В этом случае
              поток исполнения уничтожается. Но такой конструкции catch, куда может распространиться исключение, не
              существует. Вместо этого, перед тем, как поток исполнения прекратит свое существование, исключение
              передается обработчику необрабатываемых исключений. Такой обработчик должен относиться к классу,
              реализующему
              интерфейс Thread.UncaughtExceptionHandler. У этого интерфейса имеется единственный метод:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">uncaughtException</span><span class="hljs-params"
                                                                                                   style="color: rgb(147, 92, 37);">(Thread t, Throwable e)</span>
</span></pre>

            <p>
              Этот обработчик можно установить в любом потоке исполнения с помощью метода setUncaughtExceptionHandler
              (). Кроме того, можно установить обработчик
              по умолчанию для всех потоков с помощью статического метода setDefaultUncaugh
              tExceptionHandler () из класса Thread. В заменяющем обработчике может использоваться прикладной
              программный интерфейс API протоколирования для отправки
              отчетов о необрабатываемых исключениях в файл протокола.
            </p>
            <p>
              Если не установить обработчик по умолчанию, то такой обработчик оказывается
              пустым (null). Но если не установить обработчик для отдельного потока исполнения,
              то им становится объект потока типа ThreadGroup.

            </p>
            <p>
              Класс ThreadGroup реализует интерфейс Thread.UncaughtExceptionHandler. Его
              метод uncaughtExcept ion () выполняет следующие действия
            </p>
            <ul>
              <li>
                <p>
                  Если у группы потоков имеется родительская группа, то из нее вызывается метод uncaughtException().

                </p>
              </li>
              <li>
                <p>
                  Иначе, если метод Thread.getDefaultExceptionHandler () возвращает непустой обработчик (т.е. не null),
                  то вызывается именно этот обработчик.

                </p>
              </li>
              <li>
                <p>
                  Иначе, если объект типа Throwable является экземпляром класса ThreadDeath,
                  то ничего не происходит.

                </p>
              </li>
              <li>
                <p>
                  Иначе имя потока исполнения и трассировка стека объекта типа Throwable
                  выводятся в стандартный поток сообщений об ошибках System.err.
                </p>
              </li>
            </ul>
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
          Зачем нужны обработчики необрабатываемых событий при использовании многопоточного пподхода?
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
          Зачем нужны обработчики необрабатываемых событий при использовании многопоточного пподхода?
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
  name: "Handler unproccess exception",
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

      selected: 'Формирование специальных блоков catch',
      options: [
        {
          item: 'Формирование специальных блоков catch',
          name: 'Формирование специальных блоков catch'
        },
        {
          item: 'Формирование сообщений или выпорлнение других операций перед завершением потока',
          name: 'Формирование сообщений или выпорлнение других операций перед завершением потока'
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
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 8.3
              window.frontendData.language.chapters[8].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[6].task.answer

          window.frontendData.language.chapters[8].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[6].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-3-theme-2-subtheme');

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