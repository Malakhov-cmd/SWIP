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
          Пример модульной программы
          "Hello , Modular World!"
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Попробуем перенести в модуль традиционную программу, выводящую приветствие "Hello , Modular World ! "
              (Здравствуй, модульный мир!). Для этого нам, прежде всего, понадобится разместить соответствующий класс
              в пакете, поскольку безымянный пакет не может содержаться в модуле. Ниже показано, как это делается.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com.horstmann.hello;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">HelloWorld</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(String[] args)</span> </span>{
        System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">" Hello, Modular World!"</span>);
    }
}</pre>
            <p>
              До сих пор никаких особых изменений не произошло. Чтобы создать модуль
              v2 ch0 9. he l l omod, содержащий данный пакет, придется ввести его объявление.
              Этот модуль размещается в файле module- info . j ava, расположенном в базовом
              каталоге, т.е. там же, где и каталог сот. Базовый каталог принято именовать таким же образом, как и
              модуль, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">v2ch09.hellomod/
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span>-info.java
            com/
            horstmann/
                hello/
                    HelloWorld.java </pre>
            <p>
              В файле module- info . j ava содержится приведенное ниже объявление модуля. Объявление данного модуля
              оказывается пустым потому, что он не только
              ничего не предоставляет всем остальным модулям, но и ничего не требует от них.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">modulev2ch09.hellomod{}</pre>

            <p>
              Теперь выполним компиляцию, как обычно:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        javac v2ch09.hellomod/<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span>-info.java \
            v2ch09.hellomod/com/horstmann/hello/HelloWorld.j ava</pre>
            <p>
              Файл modu le- info . j ava не похож на исходный файл Java и, естественно, не
              может быть класса с именем module-i n fo, поскольку имена классов не должны
              содержать дефиса. Ключевое слово modu le, а также ключевые слова require s ,
              e xp o rts и т.д., употребляемые в приведенных далее примерах кода, относятся
              к так называемым "ограниченным" ключевым словам, имеющим специальное
              назначение только в объявлениях модулей. Данный файл компилируется в файл
              класса module-info . clas s, содержащий определение модуля в двоичной форме.
              Чтобы выполнить рассматриваемую здесь программу в виде модульного приложения, следует указать путь к
              .модулю аналогично пути к классу, только он
              должен содержать модули. Кроме того, главный класс должен быть указан в форме имя_ модуля/имя_ кла сса,
              как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        java --<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span>-path v2ch09.hellomod -<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span> \
            v2ch09.hellomod/com.horstmann.hello.HelloWorld</pre>
            <p>
              Вместо параметров - -module-path и -modu le в данной команде можно указать их однобуквенные аналоги -р и
              -m:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        java -р v2ch09.hellomod \
        -m v2ch09.hellomod/com.horstmann.hello.HelloWorld </pre>
            <p>
              Но в любом случае приветствие "Hel lo, Modular Wo rld ! " появится на экране. Тем самым демонстрируется,
              что первое наше приложение успешно модуляризировано.
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
          Что следует сделать для того, чтобы обычный пакет(ы) объявить отдельным модулем?
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
          Что следует сделать для того, чтобы обычный пакет(ы) объявить отдельным модулем?
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
  name: "ExampleModuleHelloWorld",
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

      selected: 'Создать соответсвующий артефакт',
      options: [
        {
          item: 'Создать соответсвующий артефакт',
          name: 'Создать соответсвующий артефакт'
        },
        {
          item: 'Произвести build всего приложения',
          name: 'Произвести build всего приложения'
        },
        {
          item: 'Добавить пакет в module-info.java',
          name: 'Добавить пакет в module-info.java'
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
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[11].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[11].chapterProgress += 20
              window.frontendData.language.chapters[11].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[11].listThemes[2].task.answer

          window.frontendData.language.chapters[11].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[11].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[11].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[11].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[11].listThemes[2].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-14-chapter-3-theme');

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