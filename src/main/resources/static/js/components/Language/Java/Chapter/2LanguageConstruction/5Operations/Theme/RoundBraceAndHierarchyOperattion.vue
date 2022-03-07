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
          Круглые скобки и иерархия операций
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В табл. приведена информация о предшествовании или приоритетности операций. Если скобки не
              используются, то сначала выполняются более приоритетные
              операции. Операции, находящиеся на одном уровне иерархии, выполняются слева
              направо, за исключением операций, имеющих правую ассоциативность, как показано в табл. 3.4. Например,
              операция && приоритетнее операции | |, и поэтому выражение а && b | | с равнозначно выражению (а && b) |
              | с. Операция += ассоциируется
              справа налево, а следовательно, выражение а += b += с означает а += (Ь += с). В данном случае значение
              выражения b += с (т.е. значение переменной b после прибавления к нему значения переменной с) прибавляется
              к значению переменной а.
            </p>
            <div>
              <b-table :bordered="true" hover :items="items" class="page-theme-theory-text" caption-top></b-table>
            </div>
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
        int a = 2;
        int b = (15-(++a*3))*4;

        if(b >= 20) {
            System.out.println("more");
        } else {
            System.out.println("less");
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
          Ваш ответ: more
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
  name: "RoundBraceAndHierarchyOperattion",
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

      items: [
        {
          Операции: "[ ] . () (вызов метода)",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "! ** ++ — + (унарная) - (унарная) () (приведение) new",
          Ассоциативность: "Справа налево",
        },
        {
          Операции: "* / %",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "+-",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "<< >> >>>",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "< < = > > = instanceof",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "== !=",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "&",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "^",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "|",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "&&",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "||",
          Ассоциативность: "Слева направо",
        },
        {
          Операции: "?:",
          Ассоциативность: "Справа налево",
        },
        {
          Операции: "= += - = * = /= % = | = ^= << = >> = >>> ==",
          Ассоциативность: "Справа налево",
        },
      ],
      selected: 'More',
      options: [
        {item: 'More', name: 'more'},
        {item: 'Less', name: 'less'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/secondchapter/', {
        params: {
          numberTheme: 18,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[17].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[17].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[17].task.answer

          window.frontendData.language.chapters[1].listThemes[17].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[17].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[17].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[17].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[17].task.tryCount + ".",{
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
    if (window.frontendData.language.chapters[1].listThemes[17].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[17].task.answer
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
        int a = 2;
        int b = a << 2;

        System.out.println(b);
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

    let themeToClose = document.getElementById('java-2-chapter-5-them-9-subtheme');

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