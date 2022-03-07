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
          Требования модулей
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Теперь создадим новый модуль v2 ch0 9. requiremo d, в котором находится
              класс JOp t ionPane, применяемый n рассматриваемой здесь программе для отображения приветствия " Hello,
              Modular Wo rld ! ":
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com.horstmann.hello;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> javax.swing.JOptionPane;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">HelloWorld</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(String[] args)</span> </span>{
        JOptionPane.showMessageDialog(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Hello, Modular Worldl "</span>);
    }
}</pre>
            <p>
              Ком пиляция завершится неудачно со следующим сообщением об ошибке:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">error : <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> j avax . swing is not visiЫe
( <span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> j avax . swing is decl a red in modu le j ava . de s ktop,
but <span class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span> v2ch0 <span class="hljs-number"
                                                                                            style="color: rgb(147, 92, 37);">9</span> . requiremod does not read i t )</pre>

            <p>
              Ком плект JDK модуляризирован, и теперь пакет j avax . swing содержится
              в модуле j ava . de s ktop. Таким образом, мы должны объявить свой модуль, как
              опирающийся на данный модуль.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span> v2ch09.requiremod{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">requires</span> j ava.deskt op;
}</pre>
            <p>
              Цель проектирования модульной системы в том и состоит, чтобы требования
              модулей были явно заданы, а виртуальная машина смогла удовлепюрить все
              эти требования, прежде чем :ыпустить программу на выполнение. В примерах
              из предыдущего рюдела необходимость в явном задании требований моду лей
              не возникала, поскольку мы пользовались в них только пакетами j ava . lang
              и j ava . io и:3 состава модуля j ava . base, который требуется по умолчанию.
            </p>

            <p>
              Обратите внимание на то, что в модуле v2ch0 9 . requ i r emod перечисляются только его собственные
              требования других модулей. В нем требуется модуль
              j ava . de s k top, чтобы пользоваться пакетом j avax . swing. В самом модуле j ava .
              de s k top объявляется, что ему требуются три других модуля, а и менно: j ava.
              da tatrans fer, j ava . pre fs и j ava.xml.
            </p>
            <p>
              Модуль на платформе Java состоит из следующих частей.
            </p>
            <p>
              Права досrупа не передаются автоматически от одного модуля к другому. В рассматриваемом здесь примере
              объявляется, что в модуле j ava . de s ktop требуется
              модуль j ava . p refs, а в том - модуль j ava . xrnl . Но это не дает модулю j ava .
              de s ktop права пользоваться пакетами из модуля j ava . xrnl, поскольку он должен
              быть объявлен явным образом. В математике отношение "требуется" не является
              транзитивным. В общем, такое поведение желательно, поскольку оно делает требования явными, но, как будет
              показано в разделе 9.11, его можно иногда смягчить
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
          Что следует сделать если в новом модуле используютсяпакеты из другого?
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
          Что следует сделать если в новом модуле используютсяпакеты из другого?
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
  name: "ReqirementModules",
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

      selected: 'Объявить свой модуль как опирающийся на модуль ...',
      options: [
        {
          item: 'Объявить свой модуль как опирающийся на модуль ...',
          name: 'Объявить свой модуль как опирающийся на модуль ...'
        },
        {
          item: 'Указать import.namepacket.*',
          name: 'Указать import.namepacket.*'
        },
        {
          item: 'Подключить системы сборки Gradle/maven',
          name: 'Подключить системы сборки Gradle/maven'
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
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[11].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[11].chapterProgress += 20
              window.frontendData.language.chapters[11].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[11].listThemes[3].task.answer

          window.frontendData.language.chapters[11].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[11].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[11].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[11].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[11].listThemes[3].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-14-chapter-4-theme');

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