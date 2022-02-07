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
          Оператор switch для многовариантного выбор
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Языковая конструкция i f / e ls e может оказаться неудобной, если требуется организовать в коде выбор
              одного из многих вариантов. Для этой цели в Java имеется
              оператор sw itch, полностью соответствующий одноименному оператору в С и C++
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        Scanner in = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);
        System.out.print(<span class="hljs-string"
                               style="color: rgb(168, 255, 96);">"Select an option (1, 2, 3, 4) "</span>);
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> choice = in.nextlnt();
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">switch</span> (choice) {
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">case</span> <span class="hljs-number"
                                                                                            style="color: rgb(255, 115, 253);">1</span>:
                <span class="hljs-comment" style="color: rgb(124, 124, 124);">//...</span>
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span>;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">case</span> <span class="hljs-number"
                                                                                            style="color: rgb(255, 115, 253);">2</span>:
                <span class="hljs-comment" style="color: rgb(124, 124, 124);">//...</span>
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span>;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">case</span> <span class="hljs-number"
                                                                                            style="color: rgb(255, 115, 253);">3</span>:
                <span class="hljs-comment" style="color: rgb(124, 124, 124);">//...</span>
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span>;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">case</span> <span class="hljs-number"
                                                                                            style="color: rgb(255, 115, 253);">4</span>:
                <span class="hljs-comment" style="color: rgb(124, 124, 124);">//...</span>
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span>;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">default</span>:
                <span class="hljs-comment" style="color: rgb(124, 124, 124);">// неверный ввод </span>
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span>;
        }</pre>
            <p>
              В качестве метки ветви case может быть указано следующее.
            </p>
            <p>
              <i>Константное выражение типа char, byte, short или int.</i>
            </p>
            <p>
              <i>Константа перечислимого типа</i>
            </p>
            <p>
              <i>Строковый литерал, начиная с версии Java SE 7.</i>
            </p>
            <p>
              Так, в приведенном ниже фрагменте кода указан строковый литерал в ветви case.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        String input = ...;
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">switch</span> (input.toLowerCase())
        {
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">case</span> <span class="hljs-string"
                                                                                            style="color: rgb(168, 255, 96);">"yes"</span>: <span
                  class="hljs-comment"
                  style="color: rgb(124, 124, 124);">// допустимо, начиная с версии Java SE 7 </span>
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span>;
        }</pre>
            <p>
              Когда оператор switch употребляется в коде с константами перечислимого типа,
              указывать имя перечисления в метке каждой ветви не нужно, поскольку оно выводится из значения переменной
              оператора switch.
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
    enum country {Russia, USA, Uzbekistan, China}

    public static void main(String[] args) {
        String country = String.valueOf(Main.country.values()[2]);

        switch (country){
            case "Russia": {
                System.out.println("Rus");
                break;
            }
            case "USA": {
                System.out.println("USA");
                break;
            }
            case "Uzbekistan": {
                System.out.println("UZB");
                break;
            }
            default: {
                System.out.println("Chn");
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
  name: "Switch",
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

      selected: 'Rus',
      options: [
        {item: 'Rus', name: 'Rus'},
        {item: 'USA', name: 'USA'},
        {item: 'UZB', name: 'UZB'},
        {item: 'Chn', name: 'Chn'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 30,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[29].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[29].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[29].task.answer

          window.frontendData.language.chapters[1].listThemes[29].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[29].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[29].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[29].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[29].task.tryCount + ".",{
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
    if (window.frontendData.language.chapters[1].listThemes[29].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[29].task.answer
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
    enum country {Russia, USA, Uzbekistan, China}

    public static void main(String[] args) {
        String country = String.valueOf(Main.country.values()[2]);

        switch (country){
            case "Russia": {
                System.out.println("Rus");
                break;
            }
            case "USA": {
                System.out.println("USA");
                break;
            }
            case "Uzbekistan": {
                System.out.println("UZB");
                break;
            }
            default: {
                System.out.println("Chn");
            }
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

    let themeToClose = document.getElementById('java-2-chapter-8-them-5-subtheme');

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