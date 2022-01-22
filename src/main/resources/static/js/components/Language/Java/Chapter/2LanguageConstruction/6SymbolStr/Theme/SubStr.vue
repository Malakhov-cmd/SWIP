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
          Подстроки
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>По существу, символьная строка Java представляет собой последовательность символов в Юникоде. Например,
              строка " Java\u2122" состоит из пяти символов: букв J,
              a, v, а и знака ™. В языке Java отсутствует встроенный тип для символьных строк. Вместо этого в
              стандартной библиотеке Java содержится класс String. Каждая символьная строка, заключенная в кавычки,
              представляет собой экземпляр класса String:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String е = <span
                class="hljs-string" style="color: rgb(168, 255, 96);">""</span>; <span class="hljs-comment"
                                                                                       style="color: rgb(124, 124, 124);">// пустая строка </span>
String greeting = <span class="hljs-string" style="color: rgb(168, 255, 96);">"Hello"</span>;
</pre>
            <p>
              С помощью метода substring () из класса String можно выделить подстроку из
              отдельной символьной строки. Например, в результате выполнения приведенного
              ниже фрагмента кода формируется подстрока "Hel".
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String greeting = <span
                class="hljs-string" style="color: rgb(168, 255, 96);">"Hello"</span>;
String s = greeting.substring(<span class="hljs-number" style="color: rgb(255, 115, 253);">0</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">3</span>);
</pre>
            <p>
              Второй параметр метода substring () обозначает позицию символа, который не
              следует включать в состав подстроки. В данном примере требуется скопировать символы на трех позициях 0, 1
              и 2 (т.е. от позиции 0 до позиции 2 включительно), поэтому
              при вызове метода su b strin g () указываются значения 0 и 3, обозначающие копируемые символы от позиции
              0 и до позиции 2 включительно, но исключая позицию
            </p>
            <p>
              Описанный способ вызова метода substring () имеет следующую положительную особенность: вычисление длины
              подстроки осуществляется исключительно просто. Строка s. substring (а, Ь) всегда имеет длину b - а
              символов. Так, сформированная выше подстрока "Hel" имеет длину 3-0 = 3.
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

        System.out.println(str.substring(5));
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "SubStr",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Hello_Java',
      options: [
        {item: 'Hello_Java', name: 'Hello Java'},
        {item: 'Hell', name: 'Hell'},
        {item: 'Java', name: 'Java'},
        {item: 'spaceJava', name: '(space)Java'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 19,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[18].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[18].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[18].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[18].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[18].task.answer
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

        System.out.println(str.substring(5));
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