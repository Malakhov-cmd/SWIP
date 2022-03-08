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
          Именование модулей
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Модуль - это коллекция па кетов. Имена пакетов в модуле не должны быть
              взаимосвяза 11ы. В соста в модуля j а va . sql могут, например, входить па кеты
              j а va . s ql, j а vax . sql и j avax . t r ansact ion . ха. Ка к следует из этого примера,
              вполне допустимо, чтобы совпадал и имева модулей и входящих в них пакетов
            </p>

            <p>
              Аналогично имени па кета, имя модуля состоит из букв, цифр, зна ков подчеркивания и точки. Кроме того,
              между модулями, ка к и па кетами, не должно бып,
              иерархической взаимосвязи. Так, если имеется один модуль под именем com .
              hors tmann, а другой - под именем c om . ho rstmann . corej a va, то в модульной
              системе они не должны быть связаны вместе.
            </p>

            <p>
              При создании модуля, предназначенного для применения в других модулях,
              очень важно, чтобы его имя было глобально однозначным. При этом предполагается, что имена большинства
              модулей должны отвечать условным обозначениям в обратном порядке следования и мен доменов, как это
              делается в пакетах.
            </p>
            <p>
              Модуль проще всего обозначать по имени пакета верхнего уровня, предоставляемого в данном модуле.
              Например, в фасаде за грузки SLF4J имеется модуль
              o rg . slf4j с пакетами o rg . slf4j, o rg . slf4j . spi, o r g . slf4j . eve nt и org .
              slf4j . helpers.

            </p>

            <p>
              Та кое условное обозначение предотвращает конфликты имен па кетов в модулях. Любой заданный пакет может
              быть размещен только в одном модуле. Если
              имена модулей однозначны, а имена па кетов начинаются с имени модуля, то
              и имена пакетов будут однозначны.
            </p>
            <p>
              Для обозначения модулей можно употреблять более короткие имена, не
              предна:шаченные для применения другими программистами, например, в модуле, содержащем прикладную програм
              му. Именно такой способ именования
              модулей и демонстрируется в этой главе. Например, модули, которые могут
              содержать библиотечный код, должны именоваться как com . ho r s tmann . u t i 1,
              а модули, содержащие прикладные программы с классом, в котором имеется
              метод ma in (), - более запоминающимися именами вроде v2ch0 9. he llomod.
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
          Как следует обозначать модули?
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
          Как следует обозначать модули?
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
  name: "NamingModules",
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

      selected: 'Обозначать по имени главного класса с методом main(...)',
      options: [
        {
          item: 'Обозначать по имени главного класса с методом main(...)',
          name: 'Обозначать по имени главного класса с методом main(...)'
        },
        {
          item: 'Не имеет значения',
          name: 'Не имеет значения'
        },
        {
          item: 'Обозначать по имени пакета верхнего уровня',
          name: 'Обозначать по имени пакета верхнего уровня'
        },
        {
          item: 'Все вышеперечисленное',
          name: 'Все вышеперечисленное'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/twelfthchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[11].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[11].chapterProgress += 20
              window.frontendData.language.chapters[11].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[11].listThemes[1].task.answer

          window.frontendData.language.chapters[11].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[11].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[11].listThemes[1].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[11].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[11].listThemes[1].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-14-chapter-2-theme');

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