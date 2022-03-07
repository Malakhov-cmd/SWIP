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
          Идентификация классов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В традиционной процедурной программе выполнение начинается сверху, т.е.
              с функции main (). При проектировании объектно-ориентированной системы понятия "верха" как такового не
              существует, и поэтому начинающие осваивать ООП часто
              интересуются, с чего же следует начинать. Ответ таков: сначала нужно идентифицировать классы, а затем
              добавить методы в каждый класс.
            </p>
            <p>Простое эмпирическое правило для идентификации классов состоит в том, чтобы
              выделить для них имена существительные при анализе проблемной области. С другой
              стороны, методы соответствуют глаголам, обозначающим действие. Например, при описании системы обработки
              заказов используются следующие имена существительные.</p>
            <ul>
              <li>
                <p>Товар.

                </p>
              </li>
              <li>
                <p>
                  Заказ.
                </p>
              </li>
              <li>
                <p>
                  Адрес доставки.
                </p>
              </li>
              <li>
                <p>
                  Оплата.
                </p>
              </li>
              <li>
                <p>
                  Счет.
                </p>
              </li>
            </ul>

            <p>
              Этим именам соответствуют классы Item, Order и т.д.
            </p>
            <p>Далее выбираются глаголы. Изделия вводятся в заказы. Заказы выполняются или
              отменяются. Оплата заказа осуществляется. Используя эти глаголы, можно определить объект, выполняющий
              такие действия. Так, если поступил новый заказ, ответственность за его обработку должен нести объект
              Order (Заказ), поскольку именно
              в нем содержится информация о способе хранения и сортировке заказываемых товоров. Следовательно, в классе
              Order должен существовать метод add () — добавить,
              получающий объект Item (Товар) в качестве параметра.
            </p>
            <p>Разумеется, упомянутое выше правило выбора имен существительных и глаголов
              является не более чем рекомендацией. И только опыт может помочь программисту
              решить, какие именно существительные и глаголы следует выбрать при создании
              класса и его методов.
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
          Для каких частей класса стоит использовать глаголы?
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
          Для каких частей класса стоит использовать глаголы?
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
  name: "IdentificationClasses",
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

      selected: 'Поля',
      options: [
        {item: 'Поля', name: 'Поля'},
        {item: 'Методы', name: 'Методы'},
        {item: 'Объекты', name: 'Объекты'},
        {item: 'Классы', name: 'Классы'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[2].task.answer

          window.frontendData.language.chapters[2].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[2].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-1-theme-3-subtheme');

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