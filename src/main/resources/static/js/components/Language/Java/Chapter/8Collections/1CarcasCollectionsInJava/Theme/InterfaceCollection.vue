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
          Интерфейс Collection
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Основополагающим для классов коллекций в библиотеке Java является интерфейс
              Collection. В его состав входят два основных метода:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Collection</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">E</span>&gt;
    </span>{
        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">add</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(E element)</span></span>;
        <span class="hljs-function">Iterator&lt;E&gt; <span class="hljs-title" style="color: rgb(37, 127, 173);">iterator</span><span
            class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>;
    }</pre>
            <p>
              В дополнение к ним имеется еще несколько методов, обсуждаемых далее в этой
              главе. Метод add () добавляет элемент в коллекцию. Он возвращает логическое
              значение true, если добавление элемента в действительности изменило коллекцию,
              а если коллекция осталась без изменения — логическое значение false. Так, если попытаться добавить объект
              в коллекцию, где такой объект уже имеется, вызов метода
              add () не даст желаемого результата, поскольку коллекция не допускает дублирование объектов. А метод
              iterator () возвращает объект класса, реализующего интерфейс Iterator. Объект итератора можно выбрать для
              обращения ко всем элементам
              коллекции по очереди. Подробнее итераторы обсуждаются в следующем разделе.
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
          Чем является интерфейс Collection?
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
          Чем является интерфейс Collection?
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

let isSendedandrecived = false

export default {
  name: "InterfaceCollection",
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

      selected: 'Главным интерфейсом',
      options: [
        {
          item: 'Главным интерфейсом',
          name: 'Главным интерфейсом'
        },
        {
          item: 'Декларацией базовых принципов коллекций',
          name: 'Декларацией базовых принципов коллекций'
        },
        {
          item: 'Обязательным интерфейсом при реализации собственных коллекций',
          name: 'Обязательным интерфейсом при реализации собственных коллекций'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/eighthchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 8.3
              window.frontendData.language.chapters[7].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[1].task.answer

          window.frontendData.language.chapters[7].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[1].task.tryCount + ".", {
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
    }
  },
  mounted() {
    if (window.frontendData.language.chapters[7].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[1].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-8-chapter-1-theme-2-subtheme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if (pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>