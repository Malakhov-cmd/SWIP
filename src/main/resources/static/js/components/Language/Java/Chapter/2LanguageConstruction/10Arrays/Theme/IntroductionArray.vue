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
          Массивы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Массив — это структура данных, в которой хранятся величины одинакового типа.
              Доступ к отдельному элементу массива осуществляется по целочисленному индексу.
              Так, если а — массив целых чисел, то а [ i ] — z-e целое число в массиве. Массив объявляется следующим
              образом: сначала указывается тип массива, т.е. тип элементов,
              содержащихся в нем, затем следует пара пустых квадратных скобок, а после них —
              имя переменной. Ниже приведено объявление массива, состоящего из целых чисел.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] а;</pre>
            <p>
              Но этот оператор лишь объявляет переменную а, не инициализируя ее. Чтобы
              создать массив, нужно выполнить операцию new, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] а = <span class="hljs-keyword"
                                                                                               style="color: rgb(150, 203, 254);">new</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[<span class="hljs-number"
                                                                                         style="color: rgb(255, 115, 253);">100</span>];
</pre>
            <p>
              В этой строке кода создается массив, состоящий из 1 0 0 целых чисел. Длина массива не обязательно должна
              быть постоянной. Так, операция new in t [п] создает массив длиной п.
            </p>
            <p>
              Элементы сформированного выше массива нумеруются от 0 до 99 (а не от 1
              до 100). После создания массива его можно заполнить конкретными значениями.
              B частности, это можно делать в цикле:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] а = <span class="hljs-keyword"
                                                                                               style="color: rgb(150, 203, 254);">new</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[<span class="hljs-number"
                                                                                         style="color: rgb(255, 115, 253);">100</span>];
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                        style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; <span class="hljs-number"
                                                                                                style="color: rgb(255, 115, 253);">100</span>; i++)
            a[i] = i; <span class="hljs-comment" style="color: rgb(124, 124, 124);">// заполнить массив числами от 0 до 99</span></pre>
            <p>
              При создании массива чисел все его элементы инициализируются нулями. Массивы значений типа boolean
              инициализируются логическим значением false, а массивы объектов — пустым значением null, указывающим на
              то, что массив пока еще не содержит ни одного объекта. Для начинающих это может показаться неожиданным.
              Так, в приведенной ниже строке кода создается массив из десяти символьных строк,
              причем все они нулевые, т.е. имеют пустое значение null.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String[] names = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> String[<span class="hljs-number"
                                                                                                style="color: rgb(255, 115, 253);">10</span>];</pre>
            <p>
              Если же требуется создать массив из пустых символьных строк, его придется
              специально заполнить пустыми строками, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; <span class="hljs-number"
                                                                                              style="color: rgb(255, 115, 253);">10</span>; i++) names[i] = <span
                class="hljs-string" style="color: rgb(168, 255, 96);">""</span>;</pre>
            <p>
              Для определения количества элементов в массиве служит свойство имя массива .length. Например, в
              следующем фрагменте кода свойство length используется для вывода элементов массива:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; a.length; i++)
    System.out.println(a[i]);
</pre>
            <p>
              После создания массива изменить его размер нельзя (хотя можно, конечно, изменять его отдельные элементы).
              Если в ходе выполнения программы требуется часго
              изменять размер массива, то для этой цели лучше использовать другую структуру
              данных, называемую списочным массивом.
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
        int[] array = new int[10];
        int oper = 2;

        for (int i = 0; i < array.length; i++) {
            array[i]*=oper;
        }

        System.out.println(array[10]);
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
  name: "IntroductionArray",
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
        {item: 'Ten', name: '10'},
        {item: 'Hundred', name: '100'},
        {item: 'Exception', name: 'Exception'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 33,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[32].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[32].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[32].task.answer

          window.frontendData.language.chapters[1].listThemes[32].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[32].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[32].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[32].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[32].task.tryCount + ".",{
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
    if (window.frontendData.language.chapters[1].listThemes[32].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[32].task.answer
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
        int[] array = new int[10];
        int oper = 2;

        for (int i = 0; i < array.length; i++) {
            array[i]*=oper;
        }

        System.out.println(array[10]);
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

    let themeToClose = document.getElementById('java-2-chapter-10-them-1-subtheme');

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