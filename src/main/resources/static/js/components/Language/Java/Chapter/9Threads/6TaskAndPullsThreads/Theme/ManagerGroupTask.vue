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
          Управление группами задач
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Ранее было показано, как пользоваться службой исполнителей в виде пула потоков для повышения эффективности
              исполнения задач. Но иногда исполнитель применяется скорее по причинам тактического характера только для
              управления группами взаимосвязанных задач. Например, все задачи можно прервать в исполнителе,
              вызвав его метод shutdownNow ().

            </p>
            <p>
              Метод invokeAnyO передает исполнителю все объекты типа Callable из коллекции и возвращает результат
              выполненной задачи. Но заранее неизвестно, к какой
              именно задаче относится возвращаемый результат. Можно лишь предположить, что
              это будет результат выполнения задачи, которая завершилась быстрее всех. Поэтому
              данный метод вызывается для поиска любого приемлемого решения поставленной
              задачи. Допустим, требуется разложить на множители большие целые числа — вычисление, необходимое для
              взлома шифра RSA. С этой целью можно запустить целый ряд задач, в каждой из которых будет предпринята
              попытка найти множители
              в отдельном диапазоне чисел. Как только в одной из задач будет найдено решение,
              все остальные вычисления можно прекратить.
            </p>

            <p>
              Метод invokeAll () запускает все объекты типа Callable из коллекции и возвращает список объектов типа
              Future, представляющих результаты выполнения всех
              задач. Обработку этих результатов можно организовать по мере их готовности следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">List&lt;Callable&lt;T&gt;&gt; tasks = . . .;
List&lt;Future&lt;T&gt;&gt; results = executor.invokeAll(tasks);
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Future&lt;T&gt; result : results)
processFurther(result.get());
</pre>
            <p>
              Недостаток такого подхода состоит в том, что ждать, возможно, придется слишком долго, если на выполнение
              первой задачи уйдет довольно много времени. Поэтому целесообразнее получать результаты по мере их
              готовности. Это можно сделать
              с помощью класса ExecutorCompletionService.

            </p>
            <p>
              С этой целью запускается исполнитель, полученный обычным способом. Затем получается объект типа
              ExecutorCompletionService. Далее полученному экземпляру
              службы исполнителей передаются исполняемые задачи. Эта служба управляет блокирующей очередью объектов типа
              Future, содержащих результаты переданных на выполнение задач, причем очередь заполняется по мере
              готовности результатов. Таким
              образом, вычисления можно организовать более эффективно, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ExecutorCompletionService service = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ExecutorCompletionService(executor);
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Callable&lt;T&gt; task : tasks) service.submit(task);
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; tasks.size(); i++)
processFurther(service.take().get());
</pre>
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
          По какой из перечисленных причин следовало бы использовать методы управления группами задач?
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
          По какой из перечисленных причин следовало бы использовать методы управления группами задач?
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
  name: "ManagerGroupTask",
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

      selected: 'Сложные вычисление, разбиваемые по частям',
      options: [
        {
          item: 'Сложные вычисление, разбиваемые по частям',
          name: 'Сложные вычисление, разбиваемые по частям'
        },
        {
          item: 'Любые вычисление',
          name: 'Любые вычисление'
        },
        {
          item: 'Вычисление где не важен порядок а важен первый результат',
          name: 'Вычисление где не важен порядок а важен первый результат'
        },
        {
          item: 'Математические вычисления',
          name: 'Математические вычисления'
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
          numberTheme: 19,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[18].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 8.3
              window.frontendData.language.chapters[8].listThemes[18].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[18].task.answer

          window.frontendData.language.chapters[8].listThemes[18].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[18].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[18].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[18].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[18].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[18].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[18].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-6-theme-3-subtheme');

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