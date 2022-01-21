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
          Тип данных char
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Первоначально тип char предназначался для описания отдельных символов, но
              теперь это уже не так. Ныне одни символы в Юникоде могут быть описаны единственным значением типа char, а
              для описания других требуются два значения типа
              сhаr.,Подробнее об этом речь пойдет в следующем разделе.

            </p>
            <p>ЛИтеральные значения типа char должны быть заключены в одиночные кавычки.
              Например, литеральное значение 'А' является символьной константой, которой соответствует числовое
              значение 65. Не следует путать символ 'А' со строкой "А", состоящей из одного символа. Кодовые единицы
              Юникода могут быть представлены
              шестнадцатеричными числами в пределах от \uOOOO до \uFFFF. Например, значение\
              u2122 соответствует знаку торговой марки(™), а значение \uОЗСО - греческой букве п.
            </p>
            <p>Кроме префикса \u, который предваряет кодовую единицу в Юникоде, существует также несколько специальных
              управляющих последовательностей символов,
              приведенных табл. 3.3. Эги управляющие последовательности можно вводить в символьные константы или
              строки, например '\u2122' или "Hello\n". Управляющие
              последовательности, начинающиеся с префикса \u (и никакие другие), можно даже
              указывать за пределами символьных констант или строк, заключаемых в кавычки.
              Приведенная ниже строка кода вполне допустима, потому что последовательности \
              u005B и \u005D соответствуют кодировке знаков [ и ] .
            </p>
            <p>
              pubic static void main(String\u005B\u005D args)
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
public class Main
{
	public static void main(String[] args) {
		String s = "Hello!";

    char firstChar = s.charAt(1);
    System.out.println(firstChar);
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
  name: "CharType",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      items: [
        {
          Управляющая_поспедоватепьность : "\\b",
          Назначение : "Возврат на одну позицию",
          Значение_в_Юникоде : '\\u0008'
        },
        {
          Управляющая_поспедоватепьность : "\\t ",
          Назначение : "Табуляция ",
          Значение_в_Юникоде: '\\u0009'
        },
        {
          Управляющая_поспедоватепьность : "\\n ",
          Назначение : "Переход на новую строку ",
          Значение_в_Юникоде: '\\uOOOa'
        },
        {
          Управляющая_поспедоватепьность : "\\r ",
          Назначение : "Возврат каретки ",
          Значение_в_Юникоде: '\\uOOOd'
        },
        {
          Управляющая_поспедоватепьность : "\"",
          Назначение : "Двойная кавычка",
          Значение_в_Юникоде: '\\u0022'
        },
        {
          Управляющая_поспедоватепьность : "\\' ",
          Назначение : "Одинарная кавычка",
          Значение_в_Юникоде: '\\u0027'
        },
        {
          Управляющая_поспедоватепьность : "\\\\",
          Назначение : "Обратная косая черта ",
          Значение_в_Юникоде: '\\uOOSc'
        }

      ],
      selected: 'e',
      options: [
        {item: 'e', name: 'e'},
        {item: 'H', name: 'H'},
        {item: 'NaN', name: 'Nan'},
        {item: 'Exception', name: 'Exception'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[4].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[4].task.answer
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
        `public class Main
{
\tpublic static void main(String[] args) {
\t\tString s = "Hello!";

    char firstChar = s.charAt(1);
    System.out.println(firstChar);
\t}
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