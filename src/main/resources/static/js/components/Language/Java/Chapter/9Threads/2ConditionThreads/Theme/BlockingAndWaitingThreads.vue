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
          Блокированные и ожидающие потоки исполнения
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Когда поток исполнения находится в состоянии блокировки или ожидания, он
              временно не активен. Он не выполняет никакого кода и потребляет минимум ресурсов. На планировщике потоков
              лежит обязанность повторно активизировать его.
              Подробности зависят от того, как было достигнуто неактивное состояние.

            </p>
            <ul>
              <li>
                <p>
                  Когда поток исполнения пытается получить встроенную блокировку объектов
                  (но не объект типа Lock из библиотеки java.util.concurrent), которая в настоящий момент захвачена
                  другим потоком исполнения, он становится блокированным. (Блокировки из библиотеки java.util.
                  concurrent будут обсуждаться в разделе 14.5.3, а встроенные блокировки объектов — в разделе 14.5.5.)
                  Поток исполнения разблокируется, когда все остальные потоки освобождают
                  блокировку и планировщик потоков позволяет данному потоку захватить ее.

                </p>
              </li>
              <li>
                <p>
                  Когда поток исполнения ожидает от другого потока уведомления планировщика о наступлении некоторого
                  условия, он входит в состояние ожидания. Эти
                  условия рассматриваются ниже, в разделе 14.5.4. Переход в состояние ожидания происходит при вызове
                  метода Object.wait () или Thread, join () либо
                  в ожидании объекта типа Lock или Condition из библиотеки java.util,
                  concurrent. Но на практике отличия состояний блокировки и ожидания не
                  существенны.

                </p>
              </li>
              <li>
                <p>
                  Несколько методов принимают в качестве параметра время ожидания. Их вызов
                  вводит поток исполнения в состояние временного ожидания. Это состояние сохраняется до тех пор, пока
                  не истечет заданное время ожидания или не будет получено
                  соответствующее уведомление. К числу методов со временем ожидания относятся
                  Obje c t . w a it(), Thread. jo i n (), Lock. tryL ock() и C ondition. aw ait()
                </p>
              </li>
            </ul>
            <p>
              На рис. показаны состояния, в которых может находиться поток исполнения,
              а также возможные переходы между ними. Когда поток исполнения находится в состоянии блокировки или
              ожидания (и, конечно, когда он завершается), к запуску планируется другой поток. А когда поток исполнения
              активизируется повторно (например, по истечении времени ожидания или в том случае, если ему удается
              захватить
              блокировку), планировщик потоков сравнивает его приоритет с приоритетом выполняющихся в данный момент
              потоков. Если приоритет данного потока исполнения
              ниже, он приостанавливается и запускается новый поток.
            </p>

            <p>
              <img src="http://espressocode.top/images/dioconsbeatakethai671089.jpg"
                   alt="schema" style="max-width: 80%;"/>
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
          В каких случаях поток становится блокированным?
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
          В каких случаях поток становится блокированным?
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
  name: "BlockingAndWaitingThreads",
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

      selected: 'При попытке задержать выполнение на квант',
      options: [
        {
          item: 'При попытке задержать выполнение на квант',
          name: 'При попытке задержать выполнение на квант'
        },
        {
          item: 'При инициализации',
          name: 'При инициализации'
        },
        {
          item: 'При попытке получить блокировку у объекта, занятого другим потоком',
          name: 'При попытке получить блокировку у объекта, занятого другим потоком'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/ninthchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[3].task.answer

          window.frontendData.language.chapters[8].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[3].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-2-theme-3-subtheme');

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