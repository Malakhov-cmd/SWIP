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
          Объекты
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В ООП определены следующие ключевые свойства объектов.
            </p>
            <ul>
              <li>
                <p>Поведение объекта — что с ним можно делать и какие методы к нему можно
                  применять.
                </p>
              </li>
              <li>
                <p>
                  Состояние объекта — как этот объект реагирует на применение методов.
                </p>>
              </li>
              <li>
                <p>
                  Идентичность объекта — чем данный объект отличается от других, характеризующихся таким же поведением
                  и
                  состоянием.
                </p>
              </li>
            </ul>

            <p>Все объекты, являющиеся экземплярами одного и того же класса, ведут себя одинаково. Поведение объекта
              определяется методами, которые можно вызвать. Каждый
              объект сохраняет информацию о своем состоянии. Со временем состояние объекта
              может измениться, но спонтанно это произойти не может. Состояние объекта может
              изменяться только в результате вызовов методов. (Если состояние объекта изменилось вследствие иных
              причин, значит, принцип инкапсуляции не соблюден.)
            </p>
            <p>Состояние объекта не полностью описывает его, поскольку каждый объект имеет
              свою собственную идентичность. Например, в системе обработки заказов два заказа
              могут отличаться друг от друга, даже если они относятся к одним и тем же товарам.
              Заметим, что индивидуальные объекты, представляющие собой экземпляры класса,
              всегда отличаются своей идентичностью и, как правило, — своим состоянием.
            </p>
            <p>Эти основные свойства объектов могут оказывать взаимное влияние. Например,
              состояние объекта может оказывать влияние на его поведение. (Если заказ выполнен
              или оплачен, объект может отказаться вызвать метод, требующий добавить или удалить товар. И наоборот,
              если заказ пуст, т.е. ни одна единица товара не была заказана, он не может быть выполнен.)
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
          Что такое объекты в программировании?
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
          Что такое объекты в программировании?
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
  name: "Objects",
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

      selected: 'Описанные классы',
      options: [
        {item: 'Описанные классы', name: 'Описанные классы'},
        {item: 'Код класса описанный в другом месте', name: 'Код класса описанный в другом месте'},
        {item: 'Экземпляр класса', name: 'Экземпляр класса'},
        {item: 'Файл класса', name: 'Файл класса'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 2.7
              window.frontendData.language.chapters[2].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[1].task.answer

          window.frontendData.language.chapters[2].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[1].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[1].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-1-theme-2-subtheme');

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