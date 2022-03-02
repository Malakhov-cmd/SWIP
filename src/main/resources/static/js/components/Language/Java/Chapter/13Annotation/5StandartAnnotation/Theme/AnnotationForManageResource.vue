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
          Аннотации для управления ресурсами
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Аннотации @ Po s tConstruct и @ PreDestroy применяются в таких средах, которые управляют жизненным циклом
              объектов, например, в неб-контейнерах
              и серверах приложений . Методы, снабжаемые такими аннотациями, должны
              вьвываться сразу же после создания объекта или непосредственно перед его удалением.
            </p>


            <p>
              Аннотация @ Re s ource предназначена для внедрения ресурсов. Рассмотрим
              в качестве примера веб-приложение, получающее доступ к базе данных. Разумеется, сведения о получении
              доступа к базе данных не должны жестко кодироваться в таком приложении. Вместо этого у веб-контейнера
              должен быть какой-то
              пользовательский интерфейс для установки параметров подключения, а также
              имя JNDI для источника данных. Сослаться на источник данных в веб-приложении можно следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">@ Resource ( name=<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"jdbc /mydb "</span> )
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> DataSource source ; </pre>
            <p>
              При построении объекта, содержащего такое поле, веб-контейнер внедрит
              ссылку на указанный источник данных.
            </p>

            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 2.", написанной Кейем С.
              Хорстманном.
            </div>
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Для чего используются аннотации @PostConstruct?
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
          Для чего используются аннотации @PostConstruct?
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
  name: "AnnotationForManageResource",
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

      selected: 'Автоматическая генерация кода',
      options: [
        {
          item: 'Автоматическая генерация кода',
          name: 'Автоматическая генерация кода'
        },
        {
          item: 'Инициализация бинов веб приложений',
          name: 'Инициализация бинов веб приложений'
        },
        {
          item: 'Автоматическое конструирование объектов',
          name: 'Автоматическое конструирование объектов'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/elevenchapter/', {
        params: {
          numberTheme: 10,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[9].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[9].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[9].task.answer

          window.frontendData.language.chapters[10].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[9].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[9].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[9].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-5-theme-2-subtheme');

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