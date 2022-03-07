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
          Обобщенный код и виртуальная машина
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Виртуальная машина не оперирует объектами обобщенных типов — все объекты
              принадлежат обычным классам. В первоначальных вариантах реализации обобщений можно было даже
              компилировать программу с обобщениями в файлы классов,
              которые способна исполнять виртуальная машина версии 1.0! В последующих разделах будет показано, каким
              образом компилятор "стирает" параметры типа, а также
              пояснены последствия этого процесса для программирующих на Java.
            </p>

            <p>
              Стирание типов
            </p>

            <p>Всякий раз, когда определяется обобщенный тип, автоматически создается соответствующий ему базовый (так
              называемый "сырой") тип. Имя этого типа совпадает с именем обобщенного типа с удаленными параметрами
              типа. Переменные
              типа стираются и заменяются ограничивающими типами (или типом O bject, если
              переменная не имеет ограничений). Например, базовый тип для обобщенного типа
              Pair< T > выглядит следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Pair</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Object first;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Object second;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(Object first, Object second)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.first = first;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.second = second;
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Object <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getFirst</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">()</span>

    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> first;
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Object <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getSecond</span><span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">()</span>

    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> second;
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">setFirst</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(Object newValue)</span> </span>{
        first = newValue;
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">setSecond</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(Object newValue)</span> </span>{
        second = newValue;
    }
}
</pre>
            <p>Если T — неограниченная переменная типа, то ее тип просто заменяется
              на Object. В итоге получается обычный класс вроде тех, что реализовывались до появления обобщений в Java.
              Прикладные программы могут содержать разные варианты
              обобщенного класса Pair, в том числе Pair< String > или Pair< GregorianCalendar >,
              но в результате стирания все они приводятся к базовым типам Pair.


            </p>
            <p>
              Базовый тип заменяет тип переменных первым накладываемым на них ограничением или же типом O b j e c t ,
              если никаких ограничений не предусмотрено. Например, у переменной типа в обобщенном классе Pair
              < T > отсутствуют явные ограничения, и поэтому базовый тип заменяет обобщенный тип Т на O b j e c t .
              Допустим,
              однако, что объявлен несколько иной обобщенный тип:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Interval</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">T</span> <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Comparable</span> &amp; <span class="hljs-title"
                                                                                                   style="color: rgb(37, 127, 173);">Serializable</span>&gt; <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                style="color: rgb(37, 127, 173);">Serializable</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> T lower;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> T upper;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Interval</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">(T first, T second)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (first.compareTo(second) &lt;= <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>) {
            lower = first;
            upper = second;
        } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span> {
            lower = second;
            upper = first;
        }

    }
}</pre>
            <p>
              Соответствующий ему базовый тип выглядит следующим образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Interval</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                style="color: rgb(37, 127, 173);">Serializable</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Comparable lower;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Comparable upper;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Interval</span> <span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">(Comparable first, Comparable second)</span> </span>{ . . . }
}</pre>

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
          Что такое 'стирание'?
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
          Что такое 'стирание'?
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
  name: "ClearingTypes",
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

      selected: 'Процесс замены < T > на объект типа инициализации (new)',
      options: [
        {item: 'Процесс замены < T > на объект типа инициализации (new)', name: 'Процесс замены < T > на объект типа инициализации (new)'},
        {item: 'Процесс замены < T > на тип Object', name: 'Процесс замены < T > на тип Object'},
        {
          item: 'Процесс удаление всех объектов типа < T > при компиляции',
          name: 'Процесс удаление всех объектов типа < T > при компиляции'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/seventhchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 11.1
              window.frontendData.language.chapters[6].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[4].task.answer

          window.frontendData.language.chapters[6].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[6].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[4].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-7-chapter-5-theme-1-subtheme');

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