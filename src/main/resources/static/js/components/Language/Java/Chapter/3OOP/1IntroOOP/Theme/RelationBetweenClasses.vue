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
          Отношения между классами
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Между классами существуют три общих вида отношений.
            </p>
            <ul>
              <li>
                <p>
                  Зависимость ("использует — что-то").
                </p>
              </li>
              <li>
                <p>
                  Агрегирование ("содержит — что-то").
                </p>>
              </li>
              <li>
                <p>
                  Наследование ("является — чем-то").
                </p>
              </li>
            </ul>

            <p>
              Отношение зависимости наиболее очевидное и распространенное. Например,
              в классе Order используется класс Account, поскольку объекты типа Order должны
              иметь доступ к объектам типа Account, чтобы проверить кредитоспособность заказчика. Но класс Item не зависит от класса Account, потому что объекты типа Item
              вообще не интересует состояние счета заказчика. Следовательно, один класс зависит
              от другого класса, если его методы выполняют какие-нибудь действия над экземплярами этого класса.

            </p>
            <p>Старайтесь свести к минимуму количество взаимозависимых классов. Если класс А
              не знает о существовании класса В, то он тем более ничего не знает о любых изменениях в нем! (Это означает, что любые изменения в классе В не повлияют на поведение
              объектов класса А.)

            </p>
            <p>Отношение агрегирования понять нетрудно, потому что оно конкретно. Например,
              объект типа Order может содержать объекты типа Item. Агрегирование означает, что
              объект класса А содержит объекты класса В.

            </p>

            <p>
              Наследование выражает отношение между конкретным и более общим классом.
              Например, класс RushOrder наследует от класса Order. Специализированный класс
              RushOrder содержит особые методы для обработки приоритетов и разные методы
              для вычисления стоимости доставки товаров, в то время как другие его методы, например, для заказа товаров и выписывания счетов, унаследованы от класса Order. Вообще говоря, если класс А расширяет класс В, то класс А наследует методы класса В
              и, кроме них, имеет дополнительные возможности. (Более подробно наследование
              рассматривается в следующей главе.)

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
          Зачем используется наследование?
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
          Зачем используется наследование?
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
  name: "RelationBetweenClasses",
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

      selected: 'Показать старшинство класса',
      options: [
        {item: 'Показать старшинство класса', name: 'Показать старшинство класса'},
        {item: 'Указать на более старые классы', name: 'Указать на более старые классы'},
        {item: 'Проектировать архитектуру под специальные реализации', name: 'Проектировать архитектуру под специальные реализации'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 2.7
              window.frontendData.language.chapters[2].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[3].task.answer

          window.frontendData.language.chapters[2].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[3].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-1-theme-4-subtheme');

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