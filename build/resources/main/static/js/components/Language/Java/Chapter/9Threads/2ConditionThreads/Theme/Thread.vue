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
          Исполняемые потоки
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Как только вызывается метод start (), поток оказывается в исполняемом состоянии. Исполняемый поток может
              выполняться или не выполняться в данный момент,
              поскольку от операционной системы зависит, будет ли выделено потоку время на исполнение. (Но в
              спецификации Java это отдельное состояние не указывается. Поток
              по-прежнему находится в исполняемом состоянии.)
            </p>

            <p>
              Если поток запущен, он не обязательно продолжает исполняться. На самом деле
              даже желательно, чтобы исполняемый поток периодически приостанавливался, давая
              возможность выполниться другим потокам. Особенности планирования потоков исполнения зависят от конкретных
              служб, предоставляемых операционной системой. Системы приоритетного планирования выделяют каждому
              исполняемому потоку по кванту
              времени для выполнения его задачи. Когда этот квант времени истекает, операционная
              система выгружает поток исполнения и дает возможность выполниться другому потоку
              (рис. 14.4). Выбирая следующий поток исполнения, операционная система принимает во
              внимание приоритеты потоков исполнения, как поясняется далее в разделе
            </p>

            <p>
              Во всех современных настольных и серверных операционных системах применяется приоритетное (вытесняющее)
              планирование. Но на переносных устройствах вроде мобильных телефонов может применяться кооперативное
              планирование. В таких
              устройствах поток исполнения теряет управление только в том случае, если он вызывает метод yield (),
              заблокирован или находится в состоянии ожидания.
            </p>
            <p>
              На машинах с несколькими процессорами каждый процессор может исполнять
              поток, что позволяет иметь несколько потоков, работающих одновременно. Очевидно, что если потоков больше,
              чем процессоров, то планировщик вынужден заниматься разделением времени для их исполнения. Не следует,
              однако, забывать, что в любой момент времени исполняемый поток может выполняться или не выполняться.
              Именно поэтому рассматриваемое здесь состояние потока называется исполняемым,
              а не исполняющимся.
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
          В каком случае ОС использует квантование?
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
          В каком случае ОС использует квантование?
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
  name: "Thread",
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

      selected: 'При начале исполнения потока',
      options: [
        {
          item: 'При начале исполнения потока',
          name: 'При начале исполнения потока'
        },
        {
          item: 'При ситуации когда поток больше чем ядер в процессоврах',
          name: 'При ситуации когда поток больше чем ядер в процессоврах'
        },
        {
          item: 'При возникновернии блокировки',
          name: 'При возникновернии блокировки'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/ninthchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[2].task.answer

          window.frontendData.language.chapters[8].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[2].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-2-theme-2-subtheme');

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