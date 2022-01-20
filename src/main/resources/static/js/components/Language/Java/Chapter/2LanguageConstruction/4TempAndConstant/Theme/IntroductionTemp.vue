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
          Объявление переменных
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В языке Java каждая переменная имеет свой тип. При объявлении переменной
              сначала указывается ее тип, а затем имя. Ниже приведен ряд примеров объявления
              переменных.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);">
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> salary;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> vacationDays;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">long</span> earthPopulation;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">char</span> yesChar;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">boolean</span> done;
            </pre>
            <p>Обратите внимание на точку с запятой в конце каждого объявления. Она необходима, поскольку объявление в
              языке Java считается полным оператором, а все операторы в Java завершаются точкой с запятой.
            </p>
            <p>Имя переменной должно начинаться с буквы и представлять собой сочетание букв
              и цифр. Термины буквы и цифры в Java имеют более широкое значение, чем в большинстве других языков
              программирования. Буквами считаются символы 'А' - ' Z ', 'а' - ' z ',
              '_ ', ' $ ' и любой другой символ кодировки в Юникоде, соответствующий букве. Например, немецкие
              пользователи в именах переменных могут использовать букву ' а ', а греческие пользователи - букву 'п'.
              Аналогично цифрами считаются как обычные десятичные цифры, ' О ' - ' 9 ', так и любые символы кодировки в
              Юникоде, использующиеся
              для обозначения цифры в конкретном языке. Символы вроде ' + ' или '©', а также пробел нельзя использовать
              в именах переменных. Все символы в имени переменной важны,
              причем регистр букв также учитывается. Длина имени переменной не ограничивается.
            </p>
            <p>
              В качестве имен переменных нельзя использовать и зарезервированные слова Java.
              Начиная с версии Java 9, единственный знак подчеркивания _ нельзя употреблять
              в качестве имени переменной. А в последующих версиях Java он может найти применение в качестве
              метасимвола.
            </p>
            <p>
              В одной строке программы можно разместить несколько объявлений переменных:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> i,j; <span class="hljs-comment"
                                                                                             style="color: rgb(68, 68, 68);">// обе переменные - целочисленные </span></pre>
            <p>
              Но придерживаться такого стиля программирования все же не рекомендуется.
              Ведь если объявить каждую переменную в отдельной строке, то читать исходный код
              программы будет намного легче.
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
          Чем является 'int' в этим примере?
        </label>

        <textarea id="codeContentId" readonly>
public class Test {
    public static void main(String[] args) {
        int a = 1;
        boolean _int = false;
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
          Чем является 'int' в этим примере?
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
  name: "IntroductionTemp",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Temp',
      options: [
        {item: 'Temp', name: 'Переменная'},
        {item: 'Type', name: 'Примитивный тип'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[6].task.answer

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          this.$toasted.error("Неверный ответ", {
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
    if (window.frontendData.language.chapters[1].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[6].task.answer
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
        `public class Test {
    public static void main(String[] args) {
        int a = 1;
        boolean _int = false;
    }
}
      `)

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  }
}
</script>

<style scoped>

</style>