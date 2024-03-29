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
          Преобразование числовых типов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Нередко возникает потребность преобразовать один числовой тип в другой. На
              рис. представлены допустимые преобразования числовых типов.
            </p>
            <img src="https://storage.googleapis.com/www.examclouds.com/primitives/primitives1.png"
                 alt='Bringing types'/>
            <p>Шесть сплошных линий со стрелками на рис. 3.1 обозначают преобразования, которые выполняются без потери
              данных, а три штриховые линии со стрелками — преобразования, при которых может произойти потеря точности.
              Например, количество цифр в длинном целом числе 123456789 превышает количество цифр, которое
              может быть представлено типом float. Число, преобразованное в тип float, имеет
              тот же порядок, но несколько меньшую точность:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> п = <span class="hljs-number"
                                                                                            style="color: rgb(0, 204, 102);">123456789</span>;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">float</span> f = n; <span class="hljs-comment"
                                                                                       style="color: rgb(68, 68, 68);">// значение переменной f равно 1.234567892Е8</span></pre>
            <p>
              <i>Если хотя бы один из операндов относится к типу double, то и второй операнд
                преобразуется в тип double.</i>
            </p>
            <p>
              <i>Иначе, если хотя бы один из операндов относится к типу float, то и второй
                операнд преобразуется в тип float.
              </i>
            </p>
            <p>
              <i>Иначе, если хотя бы один из операндов относится к типу long, то и второй
                операнд преобразуется в тип long.</i>
            </p>
            <p>
              <i>Иначе оба операнда преобразуются в тип int.</i>
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
          Каким типом следует иницилиазовать переменные, чтобы избешать преобразований?
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
          Каким типом следует иницилиазовать переменные, чтобы избешать преобразований?
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "TransformationDigitType",
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

      selected: 'int',
      options: [
        {item: 'int', name: 'int'},
        {item: 'long', name: 'long'},
        {item: 'float', name: 'float'},
        {item: 'double', name: 'double'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/secondchapter/', {
        params: {
          numberTheme: 12,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[11].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[11].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[11].task.answer

          window.frontendData.language.chapters[1].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[11].task.tryCount + ".",{
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
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[11].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[11].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-5-them-3-subtheme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if(pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>