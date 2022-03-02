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
          Вызов функций и методов из сценариев
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              При наличии многих интерпретаторов сценариев функция может вызываться
              на языке сценариев и без вычисления конкретного кода сценария. Это удобно,
              если пользователям разрешается реали:ювывать службу на избранном ими языке
              сценариев.
            </p>

            <p>
              Те интерпретаторы сценариев, которые предоставляют подобные функциональные возможности, реализуют
              интерфейс I nvocaЫe. В частности, этот интерфейс реализуется интерпретатором сценариев Nashom. Чтобы
              вызвать функцию из сценария, достаточно обратиться к методу invoke Fun ction (), ука зав
              в нем имя и параметры требуемой функции:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment"
                style="color: rgb(113, 149, 168);">// определить функцию приветствия в JavaScript </span>
engine . eval ( <span class="hljs-string" style="color: rgb(86, 140, 59);">" funct ion greet ( how , whom)
{ return how + ' , ' + whom + ' 1 ' } "</span> ) ;
<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// вызвать эту функцию с аргумен тами " Hello" , "World" </span>
result = ( ( I nvocaЬle ) engine ) . <span class="hljs-function">i nvoke Funct i <span class="hljs-title"
                                                                                       style="color: rgb(37, 127, 173);">on</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">"greet "</span>,
<span class="hljs-string" style="color: rgb(86, 140, 59);">" Hell o "</span> , <span class="hljs-string"
                                                                                     style="color: rgb(86, 140, 59);">"Wor ld"</span> )</span></span>;</pre>
            <p>
              Если же язык сценариев является объектно-ориентированным, можно вызвать
              метод invo keMe thod ( ) следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment"
                style="color: rgb(113, 149, 168);">// определить класс Greeter в JavaScr ipt : </span>
engine . <span class="hljs-function">eva <span class="hljs-title" style="color: rgb(37, 127, 173);">l</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">" funct i on Greeter ( how ) { this . how how } "</span> )</span> </span>;
engine . eval ( <span class="hljs-string" style="color: rgb(86, 140, 59);">"Greeter . prototype . we l come ="</span>
+ <span class="hljs-string" style="color: rgb(86, 140, 59);">" funct ion ( whom) "</span>
+ <span class="hljs-string" style="color: rgb(86, 140, 59);">" { return this . how + ' , ' + whom + '1' 1"</span>) ;
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// получить экземпляр : </span>
Obj ect уо = engine . eval ( <span class="hljs-string"
                                   style="color: rgb(86, 140, 59);">" new Greeter ( ' Yo ' ) "</span> );
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// вызвать ме т од приветствия для экземпляр а : </span>
result = ( ( I nvocaЬle ) engine ) . <span class="hljs-function">i nvokeMe <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">thod</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( yo,
<span class="hljs-string" style="color: rgb(86, 140, 59);">" we l come "</span> , <span class="hljs-string"
                                                                                        style="color: rgb(86, 140, 59);">" Wo r ld"</span> )</span></span>; </pre>

            <p>
              Можно пойти еще дальше и запросить интерпретатор сценариев реализовать
              интерфейс Java . В этом случае появится возможность вызывать функции и методы из сценариев, используя
              синта ксис Java для вызова методов. И хотя это зависит от конкретного интерпретатора сценариев, как
              правило, для каждого метода
              из и нтерфейса достаточно предоставить соответствующую функцию. Рассмотрим в качестве примера следующий и
              нтерфейс Java:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">puЬlic interfa ce Greet er
{
      <span class="hljs-function">S t ring <span class="hljs-title" style="color: rgb(37, 127, 173);">greet</span> <span
          class="hljs-params" style="color: rgb(147, 92, 37);">( S tring whom )</span> </span>;
}</pre>

            <p>
              Если определить глобальную функцию с тем же именем в Nashom, ее можно
              вызвать через следующий интерфейс:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// определить функцию приветствия в JavaScrip t : </span>
engine . eval ( <span class="hljs-string" style="color: rgb(86, 140, 59);">" funct ion welcome ( whom ) "</span>
+ <span class="hljs-string" style="color: rgb(86, 140, 59);">" { return ' Hello, ' + whom + ' ! ' 1"</span>) ;
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// получить объект Java и вызвать метод Java : </span>
Greeter g = ( ( I nvocaЬle ) engine ) . getinterface ( Greeter . clas s ) ;
result = g.<span class="hljs-function">we l <span class="hljs-title" style="color: rgb(37, 127, 173);">come</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">"World"</span> )</span></span>; </pre>

            <p>
              В объектно-ориентированном языке сценариев доступ к классу из сценария
              можно получить через соответствующий интерфейс Java. В следующем примере кода демонстрируется, каким
              образом объект класса S impleGree ter из языка
              JavaScript вызывается в синтаксисе языка Java:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Greet er g = ( ( I nvocaЬle ) engine )
. <span class="hljs-function">ge t i <span class="hljs-title" style="color: rgb(37, 127, 173);">nterface</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( yo, Greet e r . c las s )</span> </span>;
result = g.<span class="hljs-function">we l <span class="hljs-title" style="color: rgb(37, 127, 173);">come</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( <span class="hljs-string"
                                                                               style="color: rgb(86, 140, 59);">" Wor ld"</span> )</span></span>; </pre>
            <p>
              Та ким образом, и нтерфейс I nvocaЫe оказывается удобным в том случае,
              если требуется вызвап, код сценария из кода Java, не особенно разбираясь в синтаксисе языка сценариев.
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
          Как вызвать функцию написанную на JS?
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
          Как вызвать функцию написанную на JS?
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
  name: "CallFuncktionAndMethodsFromScenario",
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

      selected: 'C помощью invoke(FuncName, args...)',
      options: [
        {
          item: 'C помощью invoke(FuncName, args...)',
          name: 'C помощью invoke(FuncName, args...)'
        },
        {
          item: 'C помощью invokeFunction(FuncName, args...)',
          name: 'C помощью invokeFunction(FuncName, args...)'
        },
        {
          item: 'C помощью invokeMethod(FuncName, args...)',
          name: 'C помощью invokeMethod(FuncName, args...)'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/elevenchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[3].task.answer

          window.frontendData.language.chapters[10].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[3].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-1-theme-4-subtheme');

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