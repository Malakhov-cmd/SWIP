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
          Переадресация ввода-вывода
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Стандартный ввод-вывод можно переадресовывать в сценарии, вызывая метод
              setReader () или s e tWr i ter () соответственно в контексте сценария, как показано в приведенном ниже
              примере кода, где любые данные, выводимые с помощью таких функций JavaScript, как print () или println (
              ) , направляются объекту writer.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">var writer = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> <span class="hljs-function">StringWr <span
                class="hljs-title" style="color: rgb(37, 127, 173);">iter</span> <span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">( )</span> </span>;
engine . getContext () . <span class="hljs-function">s etWr <span class="hljs-title" style="color: rgb(37, 127, 173);">iter</span> <span
                  class="hljs-params"
                  style="color: rgb(147, 92, 37);">( new PrintWri ter ( writer , t rue )</span> )</span>;
</pre>
            <p>
              Методы setReader () и setWri ter () воздейсrвуют только на стандартные исrочники ввода-вывода данных в
              интерпретаторе сценариев. Например, при выполнении приведенного ниже кода в сценарии JavaScript
              перенаправлен будет только
              первый вывод. Интерпретатору сценариев Nashom ничего неизвестно о стандартном
              исrочнике ввода данных, поэтому вызов метода setReader () ничего не даст.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function">print <span class="hljs-title" style="color: rgb(37, 127, 173);">ln</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                             style="color: rgb(86, 140, 59);">"Hel lo"</span> )</span> </span>;
j ava . l ang . System . out . println ( <span class="hljs-string"
                                               style="color: rgb(86, 140, 59);">"World"</span> );</pre>


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
          С какой целью следует перенаправлять потоки ввода-вывода при работе со сценариями?
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
          С какой целью следует перенаправлять потоки ввода-вывода при работе со сценариями?
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
  name: "RedirectInputOutput",
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

      selected: 'Это нерекомендуемая операция',
      options: [
        {
          item: 'Это нерекомендуемая операция',
          name: 'Это нерекомендуемая операция'
        },
        {
          item: 'Получение информации непосредственно при выполнении сценария',
          name: 'Получение информации непосредственно при выполнении сценария'
        },
        {
          item: 'Получение значений переменных, использующихся в скрипте',
          name: 'Получение значений переменных, использующихся в скрипте'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/elevenchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[2].task.answer

          window.frontendData.language.chapters[10].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[2].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-1-theme-3-subtheme');

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