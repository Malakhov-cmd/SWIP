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
          Вставка комментариев
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Утилита javadoc извлекает сведения о следующих компонентах программы.
            </p>
            <ul>
              <li>
                <p>
                  Пакеты.
                </p>
              </li>
              <li>
                <p>
                  Классы и интерфейсы, объявленные как public.
                </p>
              </li>
              <li>
                <p>
                  Методы, объявленные как public или protected.
                </p>
              </li>
              <li>
                <p>
                  Поля, объявленные как public или protected.
                </p>
              </li>
            </ul>

            <p>
              Защищенные компоненты программы, для объявления которых используется
              ключевое слово protected, будут рассмотрены в главе 5, а интерфейсы — в главе 6.
              Разрабатывая программу, можно (и даже нужно) комментировать каждый из перечисленных выше компонентов.
              Комментарии размещаются непосредственно перед
              тем компонентом, к которому они относятся. Комментарии начинаются знаками / * *
              и оканчиваются знаками * /. Комментарии вида / * * . . . * / содержат произвольный
              текст, после которого следует дескриптор. Дескриптор начинается со знака 0, например 0 author или 0рагаш.
            </p>
            <p>Первое предложение в тексте комментариев должно быть кратким описанием. Утилита javadoc автоматически
              формирует страницы, состоящие из кратких описаний. В
              самом тексте можно использовать элементы HTML-разметки, например, < е т > .. .< /
              ет> — для выделения текста курсивом code — для форматирования
              текста моноширинного шрифта, strong.. . /strong — для выделения текста полужирным и даже img . . . — для
              вставки рисунков. Следует, однако, избегать применения заголовков ( < М > -
              Ь6) и горизонтальных линий (
            hr
            ), поскольку они
            могут помешать нормальному форматированию документа.
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
          Как указать комментарием автора программы?
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
          Как указать комментарием автора программы?
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
  name: "AddingComments",
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

      selected: '@author',
      options: [
        {item: '@author', name: '@author'},
        {item: 'author', name: 'author'},
        {
          item: 'creator',
          name: 'creator'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 21,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[20].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[20].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[20].task.answer

          window.frontendData.language.chapters[2].listThemes[20].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[20].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[20].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[20].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[20].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[20].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[20].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-8-theme-1-subtheme');

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