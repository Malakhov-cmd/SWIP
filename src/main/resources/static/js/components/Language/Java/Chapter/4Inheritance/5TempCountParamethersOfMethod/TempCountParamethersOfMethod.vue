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
          Методы с переменным числом параметров
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Теперь в Java имеется возможность создавать методы, позволяющие при разных вызовах задавать различное
              количество параметров. С одним из таких методов,
              printf О, вы уже знакомы. Ниже представлены два примера обращения к нему.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out.printfn);
System.out.printf(”%d %s<span class="hljs-string" style="color: rgb(86, 140, 59);">", n, "</span>widgets<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">");</span></pre>

            <p>
              В обеих приведенных выше строках кода вызывается один и тот же метод, но
              в первом случае этому методу передаются два параметра, а во втором — три. Метод
              printf () определяется в общей форме следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">PrintStream</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> PrintStream <span
        class="hljs-title" style="color: rgb(37, 127, 173);">printf</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">(String fmt, Object... args)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> format(fmt, args);
    }
}</pre>
            <p>
              Здесь многоточием (...) обозначается часть кода Java. Оно указывает на то, что
              в дополнение к параметру fmt можно указывать любое количество объектов. По существу, метод printf ()
              получает два параметра: форматирующую строку и массив
              типа Object [ ], в котором хранятся все остальные параметры. (Если этому методу передаются целочисленные
              значения или же значения одного из примитивных типов
              то они преобразуются в объекты путем автоупаковки.) После этого метод решает непростую задачу разбора
              форматирующей строки fmt и связывания спецификаторов
              формата со значениями параметров args[i]. Иными словами, в методе printf О
              тип параметра Object... означает то же самое, что и Object [ ].

            </p>

            <p>
              Компилятор при обработке исходного кода выявляет каждое обращение к методу
              printf (), размещает параметры в массиве и, если требуется, выполняет автоупаковку:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out.printf(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"%d %s"</span>, <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">new</span> Object[] { <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Integer(n), <span class="hljs-string"
                                                                                                     style="color: rgb(86, 140, 59);">"widgets"</span> } );
</pre>
            <p>
              При необходимости можно создать собственные методы с переменным числом параметров, указав любые типы
              параметров, в том числе и примитивные типы. Ниже
              приведен пример простого метода, в котором вычисляется и возвращается максимальное из произвольного
              количества значений.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">double</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">max</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>... values)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> largest = Double.MIN_VALUE;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">double</span> v : values) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (v &gt; largest) largest = v;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> largest;
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
          На какой позиции следует располагать параметр метода?
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
          На какой позиции следует располагать параметр метода?
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
  name: "TempCountParamethersOfMethod",
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

      selected: 'Последнем',
      options: [
        {
          item: 'Последнем',
          name: 'Последнем'
        },
        {
          item: 'Первом',
          name: 'Первом'
        },
        {
          item: 'Любом',
          name: 'Любом'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/fourthchapter/', {
        params: {
          numberTheme: 13,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[12].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[12].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[12].task.answer

          window.frontendData.language.chapters[3].listThemes[12].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[12].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[12].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[12].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[12].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[12].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[12].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-4-chapter-5-theme');

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