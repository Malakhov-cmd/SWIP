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
          Стандартные аннотации
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В пакетах j ava . l ang, j ava . l ang . annotat ion и j ava x . annotation определен
              целый ряд интерфейсов аннотаций. Четыре из них определяют мета-аннотации,
              описывающие поведение интерфейсов аннотаций, а остальные - обычные аннотации, которые разработчики могут
              применять для аннотирования элементов
              в своем исходном коде.
            </p>

            <ul>
              <li>
                <p>
                  Оverride - Проверяет, переопределяет ли
                  данный метод соответствующий
                  метод из суперкласса
                </p>
              </li>
              <li>
                <p>
                  Functionalinterface - Обозначает интерфейс как
                  функциональный с елинственным
                  абсграктным методом
                </p>
              </li>
              <li>
                <p>
                  PostConstruct,
                  PreDestroy - Обозначает, что аннотированный
                  метод должен вызываться сразу же
                  после создания или непосредсrвенно
                  перел удалением
                </p>
              </li>
              <li>
                <p>
                  Resource - Если это класс или интерфейс,
                  то аннотирует его как ресурс
                  для применения в каком-нибул,
                  другом месте. Если это метол или
                  поле, то аннотирует его как ресурс
                  для внедрения
                </p>
              </li>
              <li>
                <p>
                  Resources
                  Generated - Аннотирует массив ресурсов
                  Аннотирует элемент как исхолный
                  код, сгенерированный каким-нибуд�,
                  и нструментал,ным средством
                </p>
              </li>
              <li>
                <p>
                  Target - Обозначает элементы, к которым
                  может быт, применена данная
                  аннотация
                </p>
              </li>
              <li>
                <p>
                  Retention - Обозначает, как долго должна
                </p>
              </li>
              <li>
                <p>
                  Documented - Обозначает, что данная
                  аннотация должна быть включена
                  в документацию на аннотируемые
                  элементы кода
                </p>
              </li>
              <li>
                <p>
                  Inherited - Обозначает, что если данная
                  аннотация применяется к классу,
                  то она будет автоматически
                </p>
              </li>
              <li>
                <p>
                  RepeataЬle - Обозначает, что данную аннотацию
                  можно неолнократно нрименяп,
                  к одному и тому же элементу
                </p>
              </li>
            </ul>

            <p>
              Аннотации для КОМПИЛЯЦИИ
            </p>
            <p>
              Аннотация @ Depre cated может присоединяться к любым элементам, применение которых впред1, не
              рекомендуется . В таком случае компилятор будет выдавать соответствующее предупреждение, если
              нерекомендуемый элемент все-таки
              применяется в исходном коде. Эта аннотация имеет такое же назначение, как
              и дескриптор @ dep recated в документирующих комментариях формата Javadoc.
            </p>
            <p>
              Аннотация @ S uppre s s Warnings указывает компилятору подавлять предупреждения определенного типа, как
              показано в приведенной ниже строке кода
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">@ SuppressWarnings ( <span
                class="hljs-string" style="color: rgb(86, 140, 59);">" unchecked "</span>) </pre>
            <p>
              Аннотация @ Ove rride применяется только к методам. Компилятор проверяет, чтобы метод с такой аннотацией
              действительно переопределял соответствующий метод из суперкласса . Так, если сделать приведенное ниже
              объявление,
              компилятор выдаст ошибку, поскольку метод equa ls () не переопределяет аналогичный метод equa ls () из
              класса Ob j e ct. Этот метод имеет параметр типа
              Obj ect, а не MyClass.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">puЫ ic MyClass
{
     @ Ove rride puЫ <span class="hljs-function">ic <span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> e <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">quals</span> <span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">(MyClass othe r )</span> </span>;
}</pre>
            <p>
              Аннотация @ Generated предназначена для использования инструментальными средствами генерирования кода .
              Любой генерируемый исходный код может
              снабжаться аннотациями, чтобы отличаться от кода, предоставляемого программистом. Например, редактор кода
              может скрывать сгенерированный код, а генератор кода - удалять более старые версии сгенерированного кода.
              Каждая такая
              аннотация должна содержать одно:шачный идентификатор для генератора кода.
              Символьные строки с датами (в формате ISO 8601) и комментариями указывать
              необязательно. Ниже приведен характерный пример аннотации для генерирования кода .
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@Generated</span> ( <span class="hljs-string"
                                                                                             style="color: rgb(86, 140, 59);">" com . hors tmann . beanprope rty"</span> ,
<span class="hljs-string" style="color: rgb(86, 140, 59);">"20 08-01-04Т12 : 0 8:5 6 . 2 35-0 700"</span> ); </pre>

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
          Каким образом следует использовать стандартные аннотации?
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
          Каким образом следует использовать стандартные аннотации?
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
  name: "AnnotationForCompiling",
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

      selected: 'Использовать все, обращая внимание на место размещения',
      options: [
        {
          item: 'Использовать все, обращая внимание на место размещения',
          name: 'Использовать все, обращая внимание на место размещения'
        },
        {
          item: 'Некоторые из стандартных аннотаций не следует использовать никогда, так как их применение пораждает скрытые ошибки',
          name: 'Некоторые из стандартных аннотаций не следует использовать никогда, так как их применение пораждает скрытые ошибки'
        },
        {
          item: 'Не следует использовать более 2-х аннатаций над сущностью',
          name: 'Не следует использовать более 2-х аннатаций над сущностью'
        },
        {
          item: 'Все вышеперечисленные ответы верны',
          name: 'Все вышеперечисленные ответы верны'
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
          numberTheme: 9,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[8].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 4.54
              window.frontendData.language.chapters[10].listThemes[8].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[8].task.answer

          window.frontendData.language.chapters[10].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[8].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[8].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[8].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-5-theme-1-subtheme');

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