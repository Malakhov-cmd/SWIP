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
          Интерфейсы аннотаций
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Аннотация определяется с помощью своего интерфейса следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">модифика торы @ <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> ИмяАннотации
</span>{
    oбъявлениеЭлемента;
    объявлениеЭлемента :
}</pre>
            <p>
              Каждый элемент может быть объявлен в одной из следующих форм:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">тип имяЭлемента ( ) ; </pre>
            <p>
              или
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">тип имяЭлемента () <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> значение ;</pre>
            <p>
              На пример, приведенная ниже аннотация состоит из двух элементов: assignedTo и severity.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">puЫic @ <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">BugReport</span>
</span>{
    <span class="hljs-function">String <span class="hljs-title"
                                             style="color: rgb(37, 127, 173);">assignedTo</span> <span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                             style="color: rgb(107, 107, 184);">default</span> " [ none ] "</span>;
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">severity</span> <span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">( )</span> </span>;
}</pre>
            <p>
              Все интерфейсы аннотаций неявно расширяют и нтерфейс j а v а. 1 a n g.
              annotat ion . Annotat ion. Эго обычный интерфейс, а не интерфейс аннотаций.
              Предоставляемые им методы можно найти в конце этого раздела, где описывается
              соответствующий прикладной интерфейс API. Самостоятельно расширять интерфейсы аннотаций нельзя. Иными
              словами, все интерфейсы аннотаций могут непосредственно расширять только интерфейс j ava . l ang .
              annotation . Anno tation.
              Нельзя также предоставить классы, реализующие интерфейсы аннотаций.
            </p>
            <p>
              Методы из интерфейса аннотаций могут не иметь ни параметров, ни операторов throws. Они не могут быть
              статическими, обобщенными с параметрами
              типа или методами с реализацией по умолчанию.
            </p>
            <p>
              Элемент аннотации может принимать один из следующих типов.
            </p>
            <ul>
              <li>
                <p>
                  Примитивный тип (int, short, l o ng, byte, char, douЫe, float или
                  boo lean).
                </p>
              </li>
              <li>
                <p>
                  Строковый тип S t ring.
                </p>
              </li>
              <li>
                <p>
                  Тип Class (с каким-нибудь необязательным параметром вроде Class< ?
                  extends MyClass >).
                </p>
              </li>
              <li>
                <p>
                  Перечислимый тип enum.
                </p>
              </li>
              <li>
                <p>
                  Тип аннотации.
                </p>
              </li>
              <li>
                <p>
                  Массив перечисленных выше типов (массив массивов не является допустимым типом элемента аннотации).
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">puЫic <span
                    class="hljs-meta" style="color: rgb(147, 92, 37);">@interface</span> BugReport
{
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">enum</span> Status { UNCONFIRМED, CONFIRME D, FIXED, NOTABUG );
<span class="hljs-function">boo l ean showS t oppe <span class="hljs-title"
                                                         style="color: rgb(37, 127, 173);">r</span> <span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                         style="color: rgb(107, 107, 184);">default</span> fa lse </span>;
<span class="hljs-function">String <span class="hljs-title" style="color: rgb(37, 127, 173);">assignedTo</span> <span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span> de fault " [ none ] "</span>;
Class&lt;?&gt; testCase () de fault Void . <span class="hljs-class"><span class="hljs-keyword"
                                                                          style="color: rgb(107, 107, 184);">class</span></span>;
<span class="hljs-function">Status <span class="hljs-title" style="color: rgb(37, 127, 173);">status</span> <span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span> defaul t Status . UNCON FIRME D</span>;
<span class="hljs-function">Re fe rence <span class="hljs-title" style="color: rgb(37, 127, 173);">ref</span> <span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                         style="color: rgb(107, 107, 184);">default</span> @Refe <span
    class="hljs-title" style="color: rgb(37, 127, 173);">rence</span> <span class="hljs-params"
                                                                            style="color: rgb(147, 92, 37);">( )</span> </span>; / / тип аннотации
String [] <span class="hljs-function">report <span class="hljs-title"
                                                   style="color: rgb(37, 127, 173);">edBy</span> <span
                      class="hljs-params" style="color: rgb(147, 92, 37);">( )</span> </span>;
}</pre>
              </li>
            </ul>

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
          Для чего прикладному разработчику следует реализовать свои аннотации?
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
          Для чего прикладному разработчику следует реализовать свои аннотации?
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
  name: "InterfacesAnnotations",
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

      selected: 'Для отметки специальных мест кода',
      options: [
        {
          item: 'Для отметки специальных мест кода',
          name: 'Для отметки специальных мест кода'
        },
        {
          item: 'Для спецификации особых ситуаций в коде',
          name: 'Для спецификации особых ситуаций в коде'
        },
        {
          item: 'Создавать собственные аннотации не стоит, так как это затрудняет анализ кода другим разработчикам',
          name: 'Создавать собственные аннотации не стоит, так как это затрудняет анализ кода другим разработчикам'
        },
        {
          item: 'Вырные ответы под номером 1 и 2',
          name: 'Вырные ответы под номером 1 и 2'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/elevenchapter/', {
        params: {
          numberTheme: 6,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[5].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 4.54
              window.frontendData.language.chapters[10].listThemes[5].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[5].task.answer

          window.frontendData.language.chapters[10].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[5].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[5].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[5].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-4-theme-1-subtheme');

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