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
          Поля и переменные типа volatile
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Плата за синхронизацию кажется порой непомерной, когда нужно просто прочитать или записать данные в одно
              или два поля экземпляра. В конце концов, что такого страшного может при этом произойти? К сожалению,
              современные процессоры
              и компиляторы оставляют немало места для появления ошибок.
            </p>
            <ul>
              <li>
                <p>
                  Компьютеры с несколькими процессорами могут временно удерживать значения из памяти в регистрах или
                  локальных кешах. Вследствие этого в потоках,
                  исполняемых на разных процессорах, могут быть доступны разные значения
                  в одной и той же области памяти!
                </p>
              </li>
              <li>
                <p>
                  Компиляторы могут менять порядок выполнения команд для достижения максимальной производительности.
                  Они не меняют этот порядок таким образом,
                  чтобы изменился смысл кода, а лишь делают предположения, что значения
                  в памяти изменяются только явными командами в коде. Но значение в памяти
                  может быть изменено из другого потока исполнения!

                </p>
              </li>
            </ul>
            <p>
              Если вы пользуетесь блокировками для защиты кода, который может выполняться в нескольких потоках, то вряд
              ли столкнетесь с подобными затруднениями. Компиляторы обязаны соблюдать блокировки, очищая при
              необходимости локальные
              кеши и не изменяя порядок следования команд. Подробнее об этом можно узнать
              из документа Java Memory Model and Thread Specification (Спецификация модели памяти и потоков исполнения
              в Java), разработанного экспертной группой JSR 133 (www.
              jcp.org/en/jsr/detail?id=133). Большая часть этого документа довольно сложна
              и полна технических подробностей, но в нем приведен также целый ряд наглядных
              примеров. Более доступный обзор данной темы, автором которого является Брайан
              Гоетц, доступен по адресу https://www.ibm.com/developerworks/library/j-jtp02244/
            </p>

            <p>
              Ключевое слово volatile обозначает неблокирующий механизм синхронизированного доступа к полю экземпляра.
              Если поле объявляется как volatile, то компилятор и виртуальная машина принимают во внимание тот факт,
              что поле может
              быть параллельно обновлено в другом потоке исполнения.
            </p>

            <p>
              Допустим, у объекта имеется поле признака done типа boolean, который устанавливается в одном потоке
              исполнения и опрашивается в другом. Как пояснялось ранее,
              для этой цели можно организовать встроенную блокировку следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">boolean</span> done;
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
    class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">boolean</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">isDone</span><span class="hljs-params"
                                                                            style="color: rgb(147, 92, 37);">()</span> </span>{ <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> done; }
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
    class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span>  <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">void</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">setDone</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">()</span> </span>{ done = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">true</span>; }
</pre>

            <p>
              Применять встроенную блокировку объекта — вероятно, не самая лучшая идея.
              Ведь методы isDone () и setDone () могут блокироваться, если другой поток исполнения заблокировал объект.
              В таком случае можно воспользоваться отдельным объектом типа Lock только для данной переменной. Но это
              повлечет за собой немало
              хлопот. Поэтому в данном случае имеет смысл объявить поле как volatile следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">volatile</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> done;
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
    class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">isDone</span><span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ <span class="hljs-keyword"
                                                                                  style="color: rgb(107, 107, 184);">return</span> done; }
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
    class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                              style="color: rgb(37, 127, 173);">setDone</span><span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ done = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">true</span>; }
</pre>
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
          Для чего нужен тип volatile?
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
          Для чего нужен тип volatile?
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
  name: "TypeVolatile",
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

      selected: 'Чтобы компилятор перед применением значения поля опросил потоки и узнал не изменил ли его другой поток',
      options: [
        {
          item: 'Чтобы компилятор перед применением значения поля опросил потоки и узнал не изменил ли его другой поток',
          name: 'Чтобы компилятор перед применением значения поля опросил потоки и узнал не изменил ли его другой поток'
        },
        {
          item: 'Обеспечивает атомарность операций',
          name: 'Обеспечивает атомарность операций'
        },
        {
          item: 'Заменяет встроенную блокировку',
          name: 'Заменяет встроенную блокировку'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/ninthchapter/', {
        params: {
          numberTheme: 14,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[13].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[13].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[13].task.answer

          window.frontendData.language.chapters[8].listThemes[13].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[13].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[13].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[13].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[13].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[13].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[13].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-7-subtheme');

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