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
          Копирование массивов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>При необходимости одну переменную массива можно скопировать в другую, но
              в этом случае обе переменные будут ссылаться на один и mom же массив:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] luckyNumbers = smallPrimes;
luckyNumbers [<span class="hljs-number" style="color: rgb(255, 115, 253);">5</span>] = <span class="hljs-number"
                                                                                             style="color: rgb(255, 115, 253);">12</span>; <span
                  class="hljs-comment" style="color: rgb(124, 124, 124);">// теперь элемент smallPrimes[5] также равен 12</span>
    </pre>
            <p>
              Если требуется скопировать все элементы одного массива в другой, для этого следует вызвать метод соруТо
              () из класса Arrays, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);</pre>
            <p>
              В качестве второго параметра метода соруТо () указывается длина нового массива.
              Обычно этот метод применяется для увеличения размера массива следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">luckyNumbers = Arrays.copyOf(luckyNumbers, <span
                class="hljs-number" style="color: rgb(255, 115, 253);">2</span> * luckyNumbers.length);
</pre>
            <p>
              Дополнительные элементы заполняются нулями, если массив содержит числа,
              либо логическими значениями false, если это значения типа boolean. С другой стороны, если длина нового
              массива меньше длины исходного массива, то копируются
              только начальные элементы.
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
        int[] a =  {1,2,3,4,5,6,7,8,9,10};

        int[] b = Arrays.copyOf(a, 10);
        int total = 0;

        for (int element:
             b) {
            total+=element;
        }

        System.out.println(total);
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
          Ваш ответ: 55
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
  name: "CopyingMassive",
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

      selected: 'Zero',
      options: [
        {item: 'Zero', name: '0'},
        {item: 'Fifty', name: '50'},
        {item: 'FiftyFive', name: '55'},
        {item: 'Exception', name: 'Exception'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/secondchapter/', {
        params: {
          numberTheme: 35,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[34].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[34].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[34].task.answer

          window.frontendData.language.chapters[1].listThemes[34].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[34].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[34].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[34].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[34].task.tryCount + ".",{
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
    if (window.frontendData.language.chapters[1].listThemes[34].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[34].task.answer
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
        int[] a =  {1,2,3,4,5,6,7,8,9,10};

        int[] b = Arrays.copyOf(a, 10);
        int total = 0;

        for (int element:
             b) {
            total+=element;
        }

        System.out.println(total);
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

    let themeToClose = document.getElementById('java-2-chapter-10-them-3-subtheme');

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