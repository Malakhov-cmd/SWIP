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
          Операции отношения и логические операции
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В состав Java входит полный набор операций отношения. Для проверки на равенство служат знаки ==.
              Например, выражение 3 == 7 дает в результате логическое
              значение fa ls e . Для проверки на неравенство служат знаки !=. Так, выражение 3 ! =
              7 дает в результате логическое значение tru e. Кроме того, в Java поддерживаются
              обычные операции сравнения: < (меньше), > (больше), <= (меньше или равно) и =>
              (больше или равно).
            </p>
            <p>
              В языке Java, как и в C++, знаки && служат для обозначения логической операции И, а знаки | | — для
              обозначения логической операции ИЛИ. Как обычно, знак
              восклицания (!) означает логическую операцию отрицания. Операции && и | | задают порядок вычисления по
              сокращенной схеме: если первый операнд определя значение всего выражения, то остальные операнды не
              вычисляются. Рассмотрим
              для примера два выражения, объединенных логической операцией &&
            </p>
            <p>
              выражение_1 && выражение_2
            </p>
            <p>
              Если первое выражение ложно, то вся конструкция не может быть истинной. Поэтому второе выражение
              вычислять не имеет смысла. Например, в приведенном ниже
              выражении вторая часть не вычисляется, если значение переменной х равно нулю.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);">х != <span
                class="hljs-number" style="color: rgb(0, 204, 102);">0</span> &amp;&amp; <span class="hljs-number"
                                                                                               style="color: rgb(0, 204, 102);">1</span>/х &gt; х+у <span
                class="hljs-comment" style="color: rgb(68, 68, 68);">// не делить на нуль</span></pre>
            <p>
              Таким образом, деление на нуль не происходит. Аналогично значение выражение! | I выражение_2 оказывается
              истинным, если истинным является значение первого выражения. В этом случае вычислять второе выражение нет
              нужды.
            </p>
            <p>
              В языке Java имеется также тернарная операция ? :, которая иногда оказывается
              полезной. Ниже приведена ее общая форма.
            </p>
            <p>
              условие ? выражение_1 : выражение_2
            </p>
            <p>
              Если у сл о ви е истинно, то вычисляется первое выражение, а если оно ложно —
              второе выражение. Например, вычисление выражения х < у ? х : у дает в результате
              меньшее из значений переменных х и у.
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
class Main
{
    public static void main(String[] args)
    {
        int a = 10;
        double b = 10.0;

        if (a == b){
            System.out.println("equal");
        } else {
            System.out.println("different");
        }
    }
}
        </textarea>

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
          Что выведет программа?
        </label>
        <textarea id="codeContentIdAnswered"></textarea>
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
import * as CodeMirror from "codemirror"
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "RelashionshipOperationAndBoolean",
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

      selected: 'Equal',
      options: [
        {item: 'Equal', name: 'Equal'},
        {item: 'Different', name: 'Different'},
        {item: 'CastException', name: 'CastException'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/secondchapter/', {
        params: {
          numberTheme: 16,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[15].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[15].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[15].task.answer

          window.frontendData.language.chapters[1].listThemes[15].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[15].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[15].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[15].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[15].task.tryCount + ".",{
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
      setTimeout(() => {
        $('.CodeMirror').each(function (i, el) {
          el.CodeMirror.refresh();
        });
      }, 1000)
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[15].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[15].task.answer
    }

    this.codeContent = CodeMirror.fromTextArea(document.getElementById('codeContentId'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

    this.codeAnsweredContent = CodeMirror.fromTextArea(document.getElementById('codeContentIdAnswered'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

    this.codeAnsweredContent.setValue(
        `class Main
{
    public static void main(String[] args)
    {
        int a = 10;
        double b = 10.0;

        if (a == b){
            System.out.println("equal");
        } else {
            System.out.println("different");
        }
    }
}
      `)

    this.timeStarted = Date.now()

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-5-them-7-subtheme');

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