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
          Проверка символьных строк на равенство
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Чтобы проверить две символьные строки на равенство, достаточно вызвать метод
              equals(). Так, выражение s.equals(t) возвращает логическое значение true, если
              символьные строки s и t равны, а иначе — логическое значение false. Следует, однако, иметь в виду, что в
              качестве s и t могут быть использованы строковые переменные
              или константы. Например, следующее выражение вполне допустимо:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-string" style="color: rgb(168, 255, 96);">"Hello!"</span>.equals(greeting);</pre>
            <p>
              А для того чтобы проверить идентичность строк, игнорируя отличия в прописных
              и строчных буквах, следует вызвать метод equalsIgnoreCase(), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-string" style="color: rgb(168, 255, 96);">"Hello"</span>.equalsIgnoreCase(<span
                class="hljs-string" style="color: rgb(168, 255, 96);">"hello"</span>);</pre>
            <p>
              Для проверки символьных строк на равенство нельзя применять операцию — . Она
              лишь определяет, хранятся ли обе строки в одной и той же области памяти. Разумеется, если обе строки
              хранятся в одном и том же месте, они должны совпадать. Но
              вполне возможна ситуация, когда одинаковые символьные строки хранятся в разных
              местах. Ниже приведен соответствующий пример
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String greeting = <span
                class="hljs-string" style="color: rgb(168, 255, 96);">"Hello”; // инициализировать переменную greeting
                                           // символьной строкой "</span>Hello<span class="hljs-string"
                                                                                    style="color: rgb(168, 255, 96);">"
if (greeting = "</span>Hello<span class="hljs-string" style="color: rgb(168, 255, 96);">") ...
       // возможно, это условие истинно
if (greeting.substring(0, 3) == "</span>Hel<span class="hljs-string" style="color: rgb(168, 255, 96);">") ...
      // возможно, это условие ложно</span></pre>
            <p>
              Если виртуальная машина всегда обеспечивает совместное использование одинаковых символьных строк, то для
              проверки их равенства можно применять операцию = .
              Но совместно использовать можно лишь константы, а не символьные строки, получающиеся в результате таких
              операций, как сцепление или извлечение подстроки методом substring (). Следовательно, лучше вообще
              отказаться от проверки символьных
              строк на равенство с помощью операции — , чтобы исключить в программе наихудшую из возможных ошибок,
              проявляющуюся лишь время от времени и практически
              не предсказуемую.
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
public class Main {
    public static void main(String[] args) {
        String str = "Hello Java";
        String strToCompare = "hello Java";

        System.out.println(str.equals(strToCompare));
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
  name: "CheckingSymbolStrOnEquality",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'true',
      options: [
        {item: 'true', name: 'true'},
        {item: 'false', name: 'false'},
        {item: 'ExceptionComparable', name: 'ExceptionComparable'},
        {item: 'SyntaxException', name: 'SyntaxException'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 22,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[21].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[21].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[21].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[21].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[21].task.answer
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
        `public class Main {
    public static void main(String[] args) {
        String str = "Hello Java";
        String strToCompare = "hello Java";

        System.out.println(str.equals(strToCompare));
    }
}
      `)

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-6-them-4-subtheme');

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