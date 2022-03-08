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
          Правила наследования обобщенных типов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Для правильного обращения с обобщенными классами необходимо усвоить ряд
              правил, касающихся наследования и подтипов. Начнем с ситуации, которую многие
              программисты считают интуитивно понятной. Рассмотрим в качестве примера класс
              Employee и подкласс Manager. Является ли обобщенный класс Pair< Manager > подклассом, производным от
              обобщенного класса Pair
              < Employee >? Как ни странно, не
              является. Например, следующий код не подлежит компиляции:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager[] topHonchos = . .
Pair&lt;Employee&gt; result = ArrayAlg.mmmax(topHonchos); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
</pre>
            <p>
              Метод minmax () возвращает объект типа Pair< Manager >, но не тип
              Pair< Employee >, а присваивать их друг другу недопустимо. В общем случае между
              классами Pair< S > и Pair< T > нет никаких отношений наследования, как бы ни соотносились друг с другом
              обобщенные типы S и Т
            </p>
            <p>
              Такое ограничение может показаться слишком строгим, но оно необходимо
              для соблюдения типовой безопасности. Допустим, объект класса Pair< Manager >
              все-таки разрешается преобразовать в объект класса Pair< Employee >, как показано
              в приведенном ниже фрагменте кода.

            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;Manager&gt; managerBuddies = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Pairo(ceo, cfo) ;
Pair&lt;Employee&gt; employeeBuddies =
managerBuddies; <span class="hljs-comment" style="color: rgb(113, 149, 168);">// недопустимо, но предположим, что разрешено </span>
employeeBuddies.setFirst(lowlyEmployee);</pre>
            <p>
              Даже если последний оператор и допустим, переменные employeeBuddies
              и managerBuddies все равно ссылаются на один и тот же объект. В итоге получается,
              что высшее руководство организации приравнивается к рядовым сотрудникам, что
              недопустимо для класса Pair< Manager >.

            </p>

            <p>
              Параметризованный тип можно всегда преобразовать в базовый тип. Например,
              Pair< Employee > — это подтип базового типа Pair. Такое преобразование необходимо для взаимодействия с
              унаследованным кодом. А можно ли преобразовать базовый
              тип и тем самым вызвать ошибку соблюдения типов? К сожалению, да. Рассмотрим
              следующий пример кода:


            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;Manager&gt; managerBuddies = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Pair&lt;&gt;(ceo, cfo);
Pair rawBuddies = managerBuddies; <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Допустимо! </span>
rawBuddies.setFirst(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> File(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">". .
// допускается, но только с предупреждением во время компиляции</span></pre>
            <p>
              Такой код, откровенно говоря, настораживает. Но в этом отношении ситуация
              оказывается не хуже, чем в прежних версиях Java. Защита виртуальной машины не
              безгранична. Когда внешний объект извлекается методом get First () и присваивается переменной типа
              Manager, генерируется исключение типа ClassCastException,
              как и в старые добрые времена. Но, в этом случае код лишается дополнительной защиты, которую обычно
              предоставляет обобщенное программирование.
            </p>
            <p>
              И, наконец, одни обобщенные классы могут расширять или реализовывать другие обобщенные классы. В этом
              отношении они ничем не отличаются от обычных
              классов. Например, обобщенный класс ArrayList
              < T> реализует обобщенный интерфейс List
              < T>. Это означает, что объект типа ArrayList
              < Manager> может быть
              преобразован в объект типа List
              < Manager>. Но как было показано выше, объект
              типа ArrayList
              < Manager> — это не объект типа ArrayList
              < Employee> или
              List
              < Employee>.
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
          Как следует наследовать обощенные классы?
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
          Как следует наследовать обощенные классы?
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
  name: "7RuleInhiretenceGenericType",
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

      selected: 'Не следует',
      options: [
        {item: 'Не следует', name: 'Не следует'},
        {
          item: 'По степени наследования между типами используемых в обощении',
          name: 'По степени наследования между типами используемых в обощении'
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
          numberTheme: 9,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[8].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 11.1
              window.frontendData.language.chapters[6].listThemes[8].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[8].task.answer

          window.frontendData.language.chapters[6].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[8].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[6].listThemes[8].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[8].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-7-chapter-7-theme');

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