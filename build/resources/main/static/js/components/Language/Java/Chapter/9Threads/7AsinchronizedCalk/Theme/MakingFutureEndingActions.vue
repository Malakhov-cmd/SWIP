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
          Завершаемые будущие действия. Операции
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Применяя завершаемые будущие действия, достаточно указать, что и в каком порядке требуется сделать.
              Безусловно, все это происходит не сразу, но самое главное,
              что весь код оказывается в одном месте.

            </p>
            <p>
              Принципиально класс CompletableFuture является простым прикладным программным интерфейсом API, но для
              составления завершаемых будущих действий имеется немало вариантов его методов. Рассмотрим сначала те из
              них, которые обращаются с единственным будущим действием. Для каждого метода, перечисленного в табл.
              14.3, имеются еще два варианта типа Async, которые в этой таблице не представлены.
              В одном из этих вариантов используется общий объект типа ForkJoinPool, а в другом
              имеется параметр типа Executor. Кроме того, употребляется следующее
              сокращенное обозначение громоздких функциональных интерфейсов: Т -> и вместо
              Function< ? super Т, U >. Обозначения Т и U, разумеется, не имеют никакого отношения к конкретным типам
              данных в Java.
            </p>

            <p>
              Метод thenApply () уже был представлен выше. Так, в результате следующих вызовов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">CompletableFuture&lt;U&gt; future.thenApply(f);
CompletableFuture&lt;U&gt; future.thenApplyAsync(f);
</pre>

            <p>
              возвращается будущее действие, применяющее функцию f к результату будущего действия fu tu re, как только
              он станет доступным. А в результате второго вызова
              функция f выполняется еще в одном потоке.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">CompletableFuture&lt;String&gt; contents = readPage(url);
CompletableFuture&lt;List&lt;URL&gt;&gt; links = contents.thenApply(Parser::getLinks);</pre>
            <p>
              Вместо функции Т -> U метод thenCompose () принимает функцию Т -> Comp
              letableFuture< U >. На первый взгляд это кажется довольно абстрактным, тем не менее, может быть вполне
              естественным. Рассмотрим действие чтения веб-страницы
              по заданному URL. Вместо того чтобы вызывать следующий метод:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
                class="hljs-title" style="color: rgb(37, 127, 173);">blockingReadPage</span><span class="hljs-params"
                                                                                                  style="color: rgb(147, 92, 37);">(URL url)</span></span></pre>

            <p>
              изящнее возвратить из метода будущее действие следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> CompletableFuture&lt;String&gt; <span
                class="hljs-title" style="color: rgb(37, 127, 173);">readPage</span><span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">(URL url)</span>
</span></pre>
            <p>
              А теперь допустим, что имеется еще один, приведенный ниже метод, получающий URL из вводимых пользователем
              данных, возможно, в диалоговом окне, где ответ не появляется до тех пор, пока пользователь не щелкнет на
              экранной кнопке ОК.
              И это считается событием в будущем действии.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> CompletableFuture&lt;URL&gt; <span
                class="hljs-title" style="color: rgb(37, 127, 173);">getURLInput</span><span class="hljs-params"
                                                                                             style="color: rgb(147, 92, 37);">(String prompt)</span></span></pre>
            <p>
              В данном случае имеются две функции: Т -> C om pletableFuture< U > и U ->
              CompletableFuture< V >. Очевидно, что они составляют функцию Т ->
              CompletableFuture< V >, если вызывается вторая функция, когда завершается первая.
              Именно это и делается в методе thenCompose ().

            </p>
            <p>
              Метод сосредоточен на отказе — другом, игнорировавшемся до сих пор аспекте. Когда генерируется исключение
              типа Com pletableFuture,
              оно перехватывается и заключается в оболочку непроверяемого исключения типа
              ExecutionException при вызове метода get (). Но возможно, метод get () не будет
              вызван вообще. Чтобы обработать это исключение, следует вызвать метод handle ().
              Предоставляемая ему функция вызывается с результатом (а в его отсутствие — с пустым значением null) и
              исключением (а в его отсутствие — с пустым значением
              n u ll), что имеет смысл в данном случае. Остальные методы возвращают результат
              типа void и, как правило, применяются в конце конвейера обработки.

            </p>
            <p>
              А теперь рассмотрим методы, объединяющие несколько будущих действий
              . Три первых метода выполняют действия типа CompletableFuture< T >
              и CompletableFuture< U > параллельно и объединяют полученные результаты.

            </p>
            <p>
              Следующие три метода выполняют два действия типа CompletableFuture
              < T > параллельно. Как только одно из них завершается, передается его результат, а результат
              другого действия игнорируется.
            </p>
            <p>
              И наконец, статические методы allOf () и anyOf () принимают переменное количество завершаемых будущих
              действий и получают завершаемое действие типа
              CompletableFuture
              < Void >, которое завершается, когда завершаются все они или
              одно из них. В таком случае результаты не распространяются дальше.
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
          Для чего используется функция thenApplyAsync(f)?
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
          Для чего используется функция thenApplyAsync(f)?
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
  name: "MakingFutureEndingActions",
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

      selected: 'Для вызова функции f в другом потоке',
      options: [
        {
          item: 'Для вызова функции f в другом потоке',
          name: 'Для вызова функции f в другом потоке'
        },
        {
          item: 'Организация последовательного исполнения кода',
          name: 'Организация последовательного исполнения кода'
        },
        {
          item: 'Для примения других видов функциональных интерфейсов',
          name: 'Для примения других видов функциональных интерфейсов'
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
          numberTheme: 22,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[21].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[21].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[21].task.answer

          window.frontendData.language.chapters[8].listThemes[21].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[21].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[21].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[21].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[21].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[21].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[21].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-7-theme-2-subtheme');

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