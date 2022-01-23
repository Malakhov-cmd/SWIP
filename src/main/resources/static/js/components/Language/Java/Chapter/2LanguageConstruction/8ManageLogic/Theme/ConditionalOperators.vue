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
          Условные операторы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Условный оператор if в Java имеет приведенную ниже форму. Условие должно
              быть заключено в скобки.
            </p>
            <p>
              if (условие) оператор

            </p>
            <p>
              В программах на Java, как и на большинстве других языков программирования,
              часто приходится выполнять много операторов в зависимости от истинности одного
              условия. В этом случае применяется оператор задания блока, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">{
    Оператор<span class="hljs-number" style="color: rgb(255, 115, 253);">1</span>;
    Оператор<span class="hljs-number" style="color: rgb(255, 115, 253);">2</span>;
}</pre>
            <p>
              Рассмотрим в качестве примера следующий фрагмент кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (yourSales &gt;= target)
{
    performance = <span class="hljs-string" style="color: rgb(168, 255, 96);">"Satisfactory"</span>;
    bonus = <span class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
}</pre>
            <p>
              Ниже приведена более общая форма условного оператора i f в Java. А принцип
              его действия в данной форме наглядно показан в приведенном далее
              примере.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (yourSales &gt;= target)
{
   performance = <span class="hljs-string" style="color: rgb(168, 255, 96);">"Satisfactory"</span>;
   bonus = <span class="hljs-number" style="color: rgb(255, 115, 253);">100</span> + <span class="hljs-number"
                                                                                           style="color: rgb(255, 115, 253);">0.01</span> * (yourSales - target);
}
   <span class="hljs-keyword" style="color: rgb(150, 203, 254);">else</span>
{
   performance = <span class="hljs-string" style="color: rgb(168, 255, 96);">"Unsatisfactory"</span>;
   bonus = <span class="hljs-number" style="color: rgb(255, 115, 253);">0</span>;
}
</pre>
            <p>
              Часть else данного оператора не является обязательной. Она объединяется с ближайшим условным оператором i
              f . Таким образом, в следующей строке кода оператор else относится ко второму оператору if:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (х &lt;= <span class="hljs-number"
                                                                                                 style="color: rgb(255, 115, 253);">0</span>) <span
                class="hljs-function">i <span class="hljs-title" style="color: rgb(255, 255, 182);">f</span> <span
                class="hljs-params">(х == <span class="hljs-number" style="color: rgb(255, 115, 253);">0</span>)</span> sign </span>= <span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; <span class="hljs-keyword"
                                                                                       style="color: rgb(150, 203, 254);">else</span> sign = -<span
                class="hljs-number" style="color: rgb(255, 115, 253);">1</span>;</pre>
            <p>
              Разумеется, для повышения удобочитаемости такого кода следует воспользоваться
              фигурными скобками, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (х &lt;= <span class="hljs-number"
                                                                                                 style="color: rgb(255, 115, 253);">0</span>) { <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (х == <span class="hljs-number"
                                                                                              style="color: rgb(255, 115, 253);">0</span>) sign = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; <span class="hljs-keyword"
                                                                                       style="color: rgb(150, 203, 254);">else</span> sign = -<span
                class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; }</pre>
            <p>
              В программах на Java часто встречаются также повторяющиеся условные операторы i f ... else if ... .
              Ниже приведен пример применения такой языковой конструкции непосредственно в коде.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (yourSales &gt;= <span
                class="hljs-number" style="color: rgb(255, 115, 253);">2</span> * target) {
            performance = <span class="hljs-string" style="color: rgb(168, 255, 96);">"Excellent"</span>;
            bonus = <span class="hljs-number" style="color: rgb(255, 115, 253);">1000</span>;
        } <span class="hljs-keyword" style="color: rgb(150, 203, 254);">else</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">if</span> (yourSales &gt;= <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1.5</span> * target) {
            performance = <span class="hljs-string" style="color: rgb(168, 255, 96);">"Fine"</span>;
            bonus = <span class="hljs-number" style="color: rgb(255, 115, 253);">500</span>;

        } <span class="hljs-keyword" style="color: rgb(150, 203, 254);">else</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">if</span> (yourSales &gt;= target) {
            performance = <span class="hljs-string" style="color: rgb(168, 255, 96);">"Satisfactory"</span>;
            bonus = <span class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
        } <span class="hljs-keyword" style="color: rgb(150, 203, 254);">else</span> {
            System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"You're fired"</span>);
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
        int a = 9;
        int b = 16;

        if (a > b){
            a = (int) Math.sqrt(b);
            if (a < b) {
                System.out.println("less");
            }
        } else {
            b = (int) Math.pow(a, 3);
            if (a < b){
                System.out.println("more");
            }
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
  name: "ConditionalOperators",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'less',
      options: [
        {item: 'less', name: 'less'},
        {item: 'more', name: 'more'},
        {item: 'Exception', name: 'Exception'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 27,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[26].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[26].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[26].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[26].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[26].task.answer
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
        int a = 9;
        int b = 16;

        if (a > b){
            a = (int) Math.sqrt(b);
            if (a < b) {
                System.out.println("less");
            }
        } else {
            b = (int) Math.pow(a, 3);
            if (a < b){
                System.out.println("more");
            }
        }
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

    let themeToClose = document.getElementById('java-2-chapter-8-them-2-subtheme');

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