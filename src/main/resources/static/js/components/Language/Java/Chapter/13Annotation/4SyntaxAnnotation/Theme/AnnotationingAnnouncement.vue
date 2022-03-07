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
          Аннотирование объявлений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Аннотации моrут встречаться и во многих других местах прикладного кода. Эги
              места можно разделить на две категории: объяв.лен ия и J,tecтa употребления типов
              данных. Аннотации моrут появляться в объявлениях следующих элементов кода.
            </p>

            <ul>
              <li>
                <p>
                  Пакеты.
                </p>
              </li>
              <li>
                <p>
                  Классы (включая и перечисления).
                </p>
              </li>
              <li>
                <p>
                  Методы.
                </p>
              </li>
              <li>
                <p>
                  Конструкторы.
                </p>
              </li>
              <li>
                <p>
                  Переменные экземпляра (включая и константы перечислимого типа).
                </p>
              </li>
              <li>
                <p>
                  Локальные переменные.
                </p>
              </li>
              <li>
                <p>
                  Переменные параметров.
                </p>
              </li>
              <li>
                <p>
                  Параметры типа.
                </p>
              </li>
            </ul>

            <p>
              В объявлениях классов и интерфейсов аннотации указываются перед ключевым словом class или inter face
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@Entity</span> puЫ<span class="hljs-function">ic class <span
                class="hljs-title" style="color: rgb(37, 127, 173);">User</span> <span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">( . . . )</span></span></pre>

            <p>
              В объявлениях переменных аннотации указываются перед типом переменной
              таким образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">@ <span
                class="hljs-function">SuppressWarning <span class="hljs-title"
                                                            style="color: rgb(37, 127, 173);">s</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                             style="color: rgb(86, 140, 59);">" unche c ked "</span>)</span> List&lt;User&gt; users </span>= ... ;
puЫ<span class="hljs-function">ic User <span class="hljs-title" style="color: rgb(37, 127, 173);">getUser</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( @ Param(<span class="hljs-string"
                                                                                       style="color: rgb(86, 140, 59);">"id "</span> )</span> String userid)</span></pre>

            <p>
              Параметр типа в обобщенном классе или методе может быть аннотирован так:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">puЫ ic <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Cache</span>&lt;@ <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Immut</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">a</span>Ы<span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">e</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">V</span>&gt; ( ... }</span></pre>

            <p>
              Пакет аннотируется в отдельном файле pac kage-info . j ava, который содержит только операторы объявления
              и импорта пакета с предшествующими аннотациями, как показано ниже. Оnратите внимание на то, что оператор
              import
              следует после оператора pac kage, в котором объявляется пакет.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">/ **
Документирующий комментарий на уровне па кета
* /
<span class="hljs-meta" style="color: rgb(147, 92, 37);">@GPL</span> ( version=<span class="hljs-string"
                                                                                     style="color: rgb(86, 140, 59);">"3"</span> )
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com . horstmann . corej ava ;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> org . gnu . GPL; </pre>
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
          Как вы думаете, есть ли места кода, где примение аннотации невозможно?
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
          Как вы думаете, есть ли места кода, где примение аннотации невозможно?
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
  name: "AnnotationingAnnouncement",
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

      selected: 'Да, перед вызовом типа: ClassName.class',
      options: [
        {
          item: 'Да, перед вызовом типа: ClassName.class',
          name: 'Да, перед вызовом типа: ClassName.class'
        },
        {
          item: 'Нет, механизм аннотаций поддерживается на всех уровнях видимости кода',
          name: 'Нет, механизм аннотаций поддерживается на всех уровнях видимости кода'
        },
        {
          item: 'Нет, можно создать свою аннотацию под конкретную ситуацию',
          name: 'Нет, можно создать свою аннотацию под конкретную ситуацию'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/elevenchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[6].task.answer

          window.frontendData.language.chapters[10].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[6].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-4-theme-2-subtheme');

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