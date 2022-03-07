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
          Комментарии
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Комментарии к классу должны размещаться после операторов import, непосредственно перед определе
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 *Объект класса {<span class="hljs-doctag">@code</span> Card} имитирует игральную карту,
 *например даму червей. Карта имеет масть и ранг
 *(1=туз, 2...10, 11=валет, 12=дама, 13=король).
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Card</span></span>{
    ...
}</pre>

            <p>
              Комментарии к методам
            </p>
            <p>
              Комментарии должны непосредственно предшествовать методу, который они
              описывают. Кроме дескрипторов общего назначения, можно использовать перечисленные ниже специальные
              дескрипторы.
            </p>

            <ul>
              <li>
                <p>
                  @раram описание переменной
                </p>
                <p>
                  Добавляет в описание метода раздел параметров. Раздел параметров можно развернуть на несколько строк.
                  Кроме того, можно использовать элементы HTML-разметки. Все дескрипторы брагат, относящиеся к одному
                  методу,
                  должны быть сгруппированы вместе.
                </p>
              </li>
              <li>
                <p>
                  @return описание
                </p>
                <p>
                  Добавляет в описание метода раздел возвращаемого значения. Этот раздел также может занимать несколько
                  строк и допускает форматирование с помощью
                  дескрипторов HTML-разметки.
                </p>
              </li>
              <li>
                <p>
                  @throws описание класса
                </p>
                <p>
                  Указывает на то, что метод способен генерировать исключение. Исключения
                  будут рассмотрены в главе 10
                </p>
              </li>
            </ul>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">/**
     * Увеличивает зарплату работников
     * <span class="hljs-doctag">@param</span> Переменная byPercent содержит величину
     * в процентах, на которую повышается зарплата
     * (например, 10 = 10%) .
     * <span class="hljs-doctag">@return</span> Величина, на которую повышается зарплата
     */</span>
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">raiseSalary</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                    style="color: rgb(107, 107, 184);">double</span> byPercent)</span>
    </span>{
        <span class="hljs-keyword"
              style="color: rgb(107, 107, 184);">double</span> raise = salary &amp;* byPercent / <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100</span>;
        salary &amp;* raise;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> raise;
    }</pre>
            <p>
              Комментарии к полям
            </p>
            <p>
              Документировать нужно лишь открытые поля. Они, как правило, являются статическими константами. Ниже
              приведен пример комментария к полю.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment" style="color: rgb(113, 149, 168);">/*
* Масть черви
*/</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">int</span> HEARTS = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>;</pre>
            <p>
              Комментарии общего характера
            </p>
            <p>
              В комментариях к классам можно использовать следующие дескрипторы.
            </p>
            <ul>
              <li>
                <p>
                  @author имя
                </p>
                <p>
                  Создает раздел автора программы. В комментариях может быть несколько таких дескрипторов — по одному
                  на каждого автора.
                </p>
              </li>
              <li>
                <p>
                  @version текст
                </p>
                <p>
                  Создает раздел версии программы. В данном случае текст означает произвольное описание текущей версии
                  программы.
                </p>
              </li>
            </ul>
            <p>
              При написании любых комментариев, предназначенных для составления документации, можно также использовать
              следующие дескрипторы.
            </p>
            <ul>
              <li>
                <p>
                  @since текст
                </p>
                <p>
                  Создает раздел начальной точки отсчета. Здесь текст означает описание версии программы, в которой
                  впервые был внедрен данный компонент. Например, @sin ce version 1.7.1.
                </p>
              </li>
              <li>
                <p>
                  @deprecated текст
                </p>
                <p>
                  Добавляет сообщение о том, что класс, метод или переменная не рекомендуется к применению.
                  Подразумевается, что после дескриптора @deprecated следует некоторое выражение. Наприме
                </p>
              </li>
            </ul>
            <p>
              С помощью дескрипторов @see и @link можно указывать гипертекстовые ссылки
              на соответствующие внешние документы или на отдельную часть того же документа,
              сформированного с помощью утилиты javadoc.
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
          Можно ли использовать hmtl теги при формировании документации?
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
          Можно ли использовать hmtl теги при формировании документации?
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
  name: "ClassComment",
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

      selected: 'Да',
      options: [
        {item: 'Да', name: 'Да'},
        {item: 'Нет', name: 'Нет'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 22,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[21].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[21].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[21].task.answer

          window.frontendData.language.chapters[2].listThemes[21].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[21].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[21].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[21].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[21].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[21].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[21].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-8-theme-2-subtheme');

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