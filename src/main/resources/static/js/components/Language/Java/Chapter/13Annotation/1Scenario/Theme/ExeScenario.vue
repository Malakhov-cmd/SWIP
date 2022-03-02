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
          Выполнение сценариев и привязки
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Получив интерпретатор, можно приступить к вызову сценария:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Obj e ct result = eng ine . eval ( scriptString ) ; </pre>

            <p>
              Если сценарий хранится в файле, необходимо открыть поток чтения типа Reader и сделать следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Obj e ct result = engine . eval ( reader) ;</pre>
            <p>
              С помощью одного и того же интерпретатора можно вызвать целый ряд сценариев. Если какой-нибудь из
              сценариев содержит определения переменных,
              функций или классов, большинство интерпретаторов сценариев будет сохранять
              их для последующего использования. Так, в приведенном ниже примере кода
              возвращается значение 1729.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">engine . eval ( <span
                class="hljs-string" style="color: rgb(86, 140, 59);">" n = 172 8"</span>) ;
Obj ect result = engine . <span class="hljs-function">eva <span class="hljs-title"
                                                                style="color: rgb(37, 127, 173);">l</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">" n + l"</span>)</span> </span>;</pre>

            <p>
              Интерпретатор сценариев нередко требуется дополнят, привязками переменных. Каждая привязка состоит из
              имени и связываемого объекта Java . Рассмотрим в качестве примера следующие операторы:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">eng i ne . put ( k , <span
                class="hljs-number" style="color: rgb(147, 92, 37);">172</span> <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">8</span> ) ;
Obj e ct result = engine . <span class="hljs-function">eva <span class="hljs-title"
                                                                 style="color: rgb(37, 127, 173);">l</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">" k + 1"</span>)</span> </span>;</pre>

            <p>
              Код сценария читает определение объекта k из привязок в области видимости
              интерпретатора . И это очень важно, так ка к почти все языки сценариев могут
              получать доступ к объектам Java и зачастую посредством более простого, чем
              у Java, синтаксиса . Например:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">eng i ne . put (b, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> JButton () );
eng ine . <span class="hljs-function">eva <span class="hljs-title" style="color: rgb(37, 127, 173);">l</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">" b . t ext = ' Ok ' "</span> )</span> </span>;</pre>

            <p>
              С другой стороны, можно извлекать значения переменных, привя:ынных операторами сценария, как показано
              ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">engine . <span
                class="hljs-function">eva <span class="hljs-title" style="color: rgb(37, 127, 173);">l</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                             style="color: rgb(86, 140, 59);">" n = 1728"</span> )</span></span>;
Obj ect result = engine . <span class="hljs-function">ge <span class="hljs-title"
                                                               style="color: rgb(37, 127, 173);">t</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">" n "</span> )</span> </span>; </pre>
            <p>
              Кроме области видимости интерпретатора сценариев, существует и глобальная область видимости. /lюбые
              привязки, которые вводятся в объект типа Scr ipt
              EngineManager, становятся видимыми для всех и1rrерпретаторов сценариев.
            </p>

            <p>
              Вместо того чтобы вводить привязки в глобальную область видимости или
              в область видимости интерпретатора сценариев, их можно накапливать в объекте типа B i nding s и
              передавать методу e val (), как пока:ыно ниже. Это очень
              удобно, если набор привязок не требуется сохранять для последующих вы:ювов
              метода eva l ().
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">метода <span
                class="hljs-function">eva <span class="hljs-title" style="color: rgb(37, 127, 173);">l</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span>.
Bindings s cope </span>= engine . <span class="hljs-function">c <span class="hljs-title"
                                                                      style="color: rgb(37, 127, 173);">reateBindings</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( )</span> </span>;
s cope . put (b, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> <span class="hljs-function">JBut t <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">on</span> <span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">()</span> )</span>;
eng i ne . eval ( scriptSt ring, scope ) ;</pre>

            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 2.", написанной Кейем С.
              Хорстманном.
            </div>
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Что можно сделать с помощью метода eval(...)?
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
          Что можно сделать с помощью метода eval(...)?
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
  name: "ExeScenario",
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

      selected: 'Инициализовать сценарий',
      options: [
        {
          item: 'Инициализовать сценарий',
          name: 'Инициализовать сценарий'
        },
        {
          item: 'Выполнить сценарий',
          name: 'Выполнить сценарий'
        },
        {
          item: 'Выполнить сценарий и получить результат',
          name: 'Выполнить сценарий и получить результат'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/elevenchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 4.54
              window.frontendData.language.chapters[10].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[1].task.answer

          window.frontendData.language.chapters[10].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[1].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[1].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-1-theme-2-subtheme');

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