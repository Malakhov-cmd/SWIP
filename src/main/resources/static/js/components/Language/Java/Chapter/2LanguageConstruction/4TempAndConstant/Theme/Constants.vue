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
          Константы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В языке Java для обозначения констант служит ключевое слово fin a l, как показано в приведенном ниже
              фрагменте кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">class</span> <span class="hljs-title"
                                                                                          style="color: rgb(187, 17, 102);">Constants</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(102, 68, 170);">public</span> <span
        class="hljs-keyword" style="color: rgb(102, 68, 170);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(102, 68, 170);">void</span> <span
        class="hljs-title" style="color: rgb(187, 17, 102);">main</span><span class="hljs-params">(String[] args)</span>
    </span>{
        <span class="hljs-keyword" style="color: rgb(102, 68, 170);">final</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(102, 68, 170);">double</span> CM_PER_INCH = <span
                  class="hljs-number" style="color: rgb(0, 204, 102);">2.54</span>;
        <span class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> paperWidth = <span
                  class="hljs-number" style="color: rgb(0, 204, 102);">8.5</span>;
        <span class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> PaperHeight = <span
                  class="hljs-number" style="color: rgb(0, 204, 102);">11</span>;
        System.out.println(<span class="hljs-string"
                                 style="color: rgb(255, 204, 51);">"Paper size in centimeters: "</span>
                + paperWidth * CM_PER_INCH + <span class="hljs-string" style="color: rgb(255, 204, 51);">"by"</span> + PaperHeight * CM_PER_INCH);
    }
}</pre>
            <p>Ключевое слово final означает, что присвоить данной переменной какое-нибудь
              значение можно лишь один раз, после чего изменить его уже нельзя. Использовать
              в именах констант только прописные буквы необязательно, но такой стиль способствует удобочитаемости кода.
            </p>
            <p>
              В программах на Java часто возникает потребность в константах, доступных нескольким методам в одном
              классе. Обычно они называются константами класса. Константы класса объявляются с помощью ключевых слов
              static final. Ниже приведен
              пример применения константы класса в коде.
            </p>
            <
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">class</span> <span class="hljs-title"
                                                                                          style="color: rgb(187, 17, 102);">Constants2</span> </span>{

    <span class="hljs-keyword" style="color: rgb(102, 68, 170);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(102, 68, 170);">static</span> <span
                  class="hljs-keyword" style="color: rgb(102, 68, 170);">final</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(102, 68, 170);">double</span> CM_PER_INCH = <span
                  class="hljs-number" style="color: rgb(0, 204, 102);">2.54</span>;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(102, 68, 170);">public</span> <span
        class="hljs-keyword" style="color: rgb(102, 68, 170);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(102, 68, 170);">void</span> <span
        class="hljs-title" style="color: rgb(187, 17, 102);">main</span><span class="hljs-params">(String[] args)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> paperWidth = <span
                  class="hljs-number" style="color: rgb(0, 204, 102);">8.5</span>;
        <span class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> paperHeight = <span
                  class="hljs-number" style="color: rgb(0, 204, 102);">11</span>;
        System.out.println(<span class="hljs-string"
                                 style="color: rgb(255, 204, 51);">"Paper size in centimeters: "</span>
                + paperWidth * CM_PER_INCH + <span class="hljs-string" style="color: rgb(255, 204, 51);">" by "</span>
                + paperHeight * CM_PER_INCH);
    }
}</pre>
            <p>
              Обратите внимание на то, что константа класса задается за пределами метода
              main (), поэтому ее можно использовать в других методах того же класса. Более того,
              если константа объявлена как public, методы из других классов также могут получить к ней доступ. В данном
              примере это можно сделать с помощью выражения
              Constants2.CM PER INCH.

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
          Для чего в коде используются константы?
        </label>

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
          Для чего в коде используются константы?
        </label>
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
  name: "Constants",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'One',
      options: [
        {item: 'One', name: 'Для обозначения значений неизменяемых величин'},
        {item: 'Two', name: 'Для значенй не часто переписываемых'},
        {item: 'Three', name: 'Для привлечения внимания'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 9,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[8].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[8].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[8].task.answer

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
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[8].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[8].task.answer
    }
  }
}
</script>

<style scoped>

</style>