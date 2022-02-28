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
          Завершаемые будущие действия
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Традиционный подход к обращению с неблокирующими вызовами заключается в том, чтобы пользоваться
              обработчиками событий, программно регистрируемых для действий, которые должны произойти по завершении
              задачи. Разумеется,
              если следующее действие также является асинхронным, то и следующее после него
              действие должно происходить в другом обработчике событий. Несмотря на то что
              программист мыслит следующими категориями: сначала сделать шаг 1, затем шаг 2
              и далее шаг 3, логика программы становится распределенной среди разных обработчиков. А добавление
              обработки ошибок только усложняет дело. Допустим, на шаге
              2 пользователь входит в систему. Этот шаг, возможно, придется повторить, поскольку пользователь может
              ввести свои учетные данные с опечатками. Реализовать такой
              поток управления в ряде обработчиков событий непросто, а еще труднее другим понять, как он был
              реализован.
            </p>
            <p>
              Совсем иной поход принят в классе CompletableFuture, внедренном в версии
              Java SE 8. В отличие от обработчиков событий, завершаемые будущие действия могут
              быть составлены. Допустим, с веб-страницы требуется извлечь все ссылки, чтобы построить поисковый робот.
              Допустим также, что для этой цели имеется следующий
              метод, получающий текст из веб-страницы, как только он становится доступным:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword"
                style="color: rgb(107, 107, 184);">void</span> CompletableFuture&lt;String&gt; <span class="hljs-title"
                                                                                                     style="color: rgb(37, 127, 173);">readPage</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(URL url)</span></span></pre>

            <p>
              Если метод
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> List&lt;URL&gt; <span
                class="hljs-title" style="color: rgb(37, 127, 173);">getLinks</span><span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">(String page)</span></span></pre>

            <p>
              получает URL на HTML-странице, то его вызов можно запланировать на момент, когда страница доступна,
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">CompletableFuture&lt;String&gt; contents = readPage(url);
CompletableFuture&lt;List&lt;URL&gt;&gt; links = contents.thenApply(Parser::getLinks);</pre>
            <p>
              В данном примере метод invokeAll () получает ряд задач и блоков до тех пор,
              пока их выполнение не будет завершено, а метод join () объединяет полученные результаты. В частности,
              метод join () вызывается для каждой подзадачи, а в итоге возвращается сумма результатов их выполнения.
            </p>
            <p>
              Весь исходный код рассматриваемого здесь примера приведен в листинге
              В самой архитектуре вилочного соединения применяется эффективный эвристический алгоритм для
              уравновешивания рабочей нагрузки на имеющиеся потоки исполнения, называемый перехватом работы. Для
              каждого рабочего потока исполнения
              организуется двухсторонняя очередь выполняемых задач. Рабочий поток исполнения
              размещает подзадачи в голове своей двухсторонней очереди, причем только один поток исполнения имеет
              доступ к голове этой очереди, благодаря чему исключается
              потребность в блокировке потоков. Когда рабочий процесс простаивает, он пытается
              перехватить задачу из хвоста другой двухсторонней очереди, но поскольку в хвосте
              очереди обычно располагаются крупные подзадачи, то потребность в перехвате задач
              возникает редко.

            </p>
            <p>
              Метод thenApply () вообще не блокируется. Он возвращает другое будущее действие. По завершении первого
              будущего действия его результат передается методу
              getLinks (), а значение, возвращаемое этим методом, становится окончательным результатом.
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
          В чем основное удобство использования CompletableFuture< T >?
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
          В чем основное удобство использования CompletableFuture< T >?
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
  name: "EndingFutureActions",
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

      selected: 'в возможности вручную не создавать потоки исполнения',
      options: [
        {
          item: 'в возможности вручную не создавать потоки исполнения',
          name: 'в возможности вручную не создавать потоки исполнения'
        },
        {
          item: 'Организация последовательного исполнения кода',
          name: 'Организация последовательного исполнения кода'
        },
        {
          item: 'Возможность просто разделять задачи на подзадачи',
          name: 'Возможность просто разделять задачи на подзадачи'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/ninthchapter/', {
        params: {
          numberTheme: 21,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[20].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 8.3
              window.frontendData.language.chapters[8].listThemes[20].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[20].task.answer

          window.frontendData.language.chapters[8].listThemes[20].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[20].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[20].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[20].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[20].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[20].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[20].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-7-theme-1-subtheme');

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