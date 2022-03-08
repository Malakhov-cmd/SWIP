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
          Программная платформа Java
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Java никогда не был только языком.
              Хорошие языки — не редкость, а появление некоторых из них вызвало в свое время
              настоящую сенсацию в области вычислительной техники. В отличие от них, Java —
              это программная платформа, включающая в себя мощную библиотеку, большой объем кода, пригодного для
              повторного использования, а также среду для выполнения
              программ, которая обеспечивает безопасность, независимость от операционной системы и автоматическую сборку
              "мусора".</p>
            <p>Программистам нужны языки с четкими синтаксическими правилами и понятной
              семантикой (т.е. определенно не C++). Такому требованию, помимо Java, отвечают
              десятки языков. Некоторые из них даже обеспечивают переносимость и "сборку мусора", но их библиотеки
              оставляют желать много лучшего. В итоге программисты вынуждены самостоятельно реализовывать графические
              операции, доступ к сети и базе
              данных и другие часто встречающиеся процедуры. Java объединяет в себе прекрасный язык, высококачественную
              среду выполнения программ и обширную библиотеку. В результате многие программисты остановили свой выбор
              именно на Java</p>
          </div>
          <div class="page-theme-author-text text-white-50">
            Приведенный материал был взят из книги "Java. Библиотека профессионала, том 1.", написанной Кейем С.
            Хорстманном.
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label for="input-live" class="page-theme-question-text">Что думаете об этом языке?:</label>
        <b-form-input
            id="input-live"
            v-model="name"
            :state="nameState"
            aria-describedby="input-live-help input-live-feedback"
            placeholder="Введите ваше мнение"
            trim
        ></b-form-input>

        <!-- This will only be shown if the preceding input has an invalid state -->
        <b-form-invalid-feedback id="input-live-feedback">
          Enter at least 3 letters
        </b-form-invalid-feedback>

        <!-- This is a form text block (formerly known as help block) -->
        <b-form-text id="input-live-help">Введите ваше мнение</b-form-text>
      </div>

      <div v-show="!showInput">
        <p class="page-theme-theory-text">
          Ваш ответ: "{{ answer }}"
        </p>
      </div>

      <div class="box animate" style="" v-show="animationOn">Успех</div>

      <b-btn class="my-b-btn page-theme-btn-submit" v-on:click="Request" v-show="showInput">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from "axios";

let tempAnswer = []
let isSendedandrecived = false
export default {
  name: "ProgramPlatform",
  computed: {
    nameState() {
      if (this.name.length > 2) {
        const answerPattern = /([A-Za-zА-Яа-я 1-9]{1})*/;

        if (this.name.match(answerPattern)[0].length === this.name.length) {
          this.allowSend = true
          return true
        }
      }
      return false
    }
  },
  data() {
    return {
      name: '',
      showInput: true,
      answer: [],
      allowSend: false,
      animationOn: false,

      timeStarted: 0,
      timeEndeded: 0,
      timeSpended: 0
    }
  },
  methods: {
    Request() {
      if (this.allowSend === true) {
        this.timeEndeded = Date.now()
        this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

        axios.get('/java/firstchapter/', {
          params: {
            numberTheme: 1,
            answer: this.name,
            userId: window.frontendData.profile.id,
            timeSpend: this.timeSpended
          }
        })
            .then(function (response) {
              window.frontendData.language.chapters[0].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[0].chapterProgress += 33.3
              window.frontendData.language.chapters[0].listThemes[0].finished = true

              tempAnswer = response.data

              isSendedandrecived = true
            })
            .catch(function (error) {
              console.log(error);
            })
        const interval = setInterval(() => {
          if (isSendedandrecived) {
            this.answer = window.frontendData.language.chapters[0].listThemes[0].task.answer

            window.frontendData.language.chapters[0].listThemes[0].task.tryCount++
            window.frontendData.language.chapters[0].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

            this.animationOn = isSendedandrecived
            this.showInput = false

            clearInterval(interval)
          }
        }, 100);
      } else {
        window.frontendData.language.chapters[0].listThemes[0].task.tryCount++
        window.frontendData.language.chapters[0].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

        this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
            " c. Номер попытки: " + window.frontendData.language.chapters[0].listThemes[0].task.tryCount + ".", {
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
        });
      }
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[0].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[0].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-1-chapter-1-theme');

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