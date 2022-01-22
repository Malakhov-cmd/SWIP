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
          Область действия блоков
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В языке Java, как и в любом другом языке программирования, в качестве логики,
              управляющей ходом выполнения программы, служат условные операторы и циклы.
              Рассмотрим сначала условные операторы, а затем перейдем к циклам. И завершим
              обсуждение управляющей логики довольно громоздким оператором sw itch, который можно применять для
              проверки многих значений одного выражени
            </p>
            <p>
              Прежде чем перейти к обсуждению конкретных языковых конструкций управляющей логики, необходимо
              рассмотреть блоки. Блок состоит из ряда операторов Java,
              заключенных в фигурные скобки. Блоки определяют область действия переменных.
              Блоки могут быть вложенными друг в друга. Ниже приведен пример одного блока,
              вложенного в другой блок в методе main ().
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(150, 203, 254);">void</span> <span
                class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> n;
    ...
    {
         <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> k;
    } <span class="hljs-comment"
            style="color: rgb(124, 124, 124);">// переменная к определена только в этом блоке</span>
}</pre>
            <p>
              В языке Java нельзя объявлять переменные с одинаковым именем в двух вложенных блоках. Например,
              приведенный ниже фрагмент кода содержит ошибку и не будет скомпилирован.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(150, 203, 254);">void</span> m a <span
                class="hljs-title" style="color: rgb(255, 255, 182);">m</span> <span class="hljs-params">(String [] args)</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> n;
    {
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> k;
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> n; <span class="hljs-comment"
                                                                                          style="color: rgb(124, 124, 124);">// ОШИБКА: переопределить переменную n</span>
        ... <span class="hljs-comment" style="color: rgb(124, 124, 124);">//во внутреннем блоке нельзя</span>
    }
}</pre>
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
       int outer = 10;

       do {
           int inner = 5;
           outer--;
       } while (outer > 1);

        System.out.println(inner);
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
          Исправьте программу чтобы она выводи "Hello, James. Im from Tennessee"
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "PlaceVisibleBlocks",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Five',
      options: [
        {item: 'Five', name: '5'},
        {item: 'Ten', name: '10'},
        {item: 'Exception', name: 'Exception'},
        {item: 'One', name: '1'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 26,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[25].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[25].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[25].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[25].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[25].task.answer
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
       int outer = 10;

       do {
           int inner = 5;
           outer--;
       } while (outer > 1);

        System.out.println(inner);
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
    //container.scrollTo(50, 5000)
  }
}
</script>

<style scoped>

</style>