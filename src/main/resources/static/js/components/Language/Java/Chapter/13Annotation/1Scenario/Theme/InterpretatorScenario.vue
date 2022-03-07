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
          Написание сценариев для платформы Java
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Язык сценариев - это такой язык программирования, который позволяет
              избегать обычного цикла операций редактирования, компиляции, ком поновки
              и выполнения благодаря интерпретации исходного текста программы во время
              выполнения. Языки сценариев обладают рядом следующих преимуществ.

            </p>

            <ul>
              <li>
                <p>
                  Быстрый цикл обработки, стимулирующий стремление к экспериментированию.
                </p>
              </li>
              <li>
                <p>
                  Возможность изменяп, поведение выполняющейся программы.
                </p>
              </li>
              <li>
                <p>
                  Возможность для пользователей специально настраивать программы.
                </p>
              </li>
            </ul>

            <p>
              С другой стороны, у большинства языков сценариев отсутствуют средства, необходимые для разработки сложных
              прикладных программ, включая строгий
              контролr, типов, инкапсуляцию и модульность.
            </p>

            <p>
              В связи с этим возникает соблазн объединить преимущества языков сценариев
              с преимуществами традиционных языков программирования. Именно это и позволяет сделать прикладной
              интерфейс API для сценариев на платформе Java. В
              частности, он предоста вляет возможность вызывать из программы на Java сценарии, написанные на
              JavaScript, Groovy, Ruby и даже таких экзотических языках,
              как Scheme и Haskell. Например, в проекте Renjin (www . renj in . org) предоставляется реализованная в
              Java возможность программировать на языке R, который
              зачастую применяется в области статистического программирования. С этой целью используется интерпретатор
              из прикладного интерфейса API для выполнения сценариев.
            </p>
            <p>
              В последующих разделах будет показано, как выбирается интерпретатор сценариев для конкретного языка, как
              выполняются сценарии и как пользоваться
              дополнительными преимуществами, которые дают некоторые интерпретаторы
              сценариев.
            </p>

            <p>
              Получение интерпретатора сценариев
            </p>
            <p>
              Интерпретатор сценариев - это, по существу, библиотека, позволяющая
              выполнять сценарии на конкретном языке. При запуске виртуальная машина обнаруживает все доступные
              интерпретаторы сценариев. Получить их перечень можно, создав объект типа ScriptE n g ineMan ager и вызвав
              метод
              ge tEngine Factories (). Далее у каждой фабрики интерпретаторов сценариев
              можно запросить сведения об именах поддерживаемых интерпретаторов, типах
              MIME и расширениях файлов.
            </p>
            <p>
              Обычно требующийся интерпретатор сценариев известен и может запрашиваться по имени, типу MIME или
              расширению, ка к показано в приведенном
              ниже примере.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ScriptEngine engine = manager . getEngineByName ( <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"nashorn"</span> );</pre>
            <p>
              В версии Java 8 внедрен интерпретатор Nashorn сценариев на языке JavaScript,
              разработанный компанией Oracle. Предоста вив необходимые архивные JАR-файлы по пути к соответствующим
              классам, можно дополнить перечень языков написания сценариев.
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
          С какой целью была введена поддержка языков сценариев в Java?
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
          С какой целью была введена поддержка языков сценариев в Java?
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
  name: "InterpretatorScenario",
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

      selected: 'Для использования преимеществ сценарных языков в некоторых частях кода',
      options: [
        {
          item: 'Для использования преимеществ сценарных языков в некоторых частях кода',
          name: 'Для использования преимеществ сценарных языков в некоторых частях кода'
        },
        {
          item: 'Для привлечения разработчиков, умеющих программировать на других языках',
          name: 'Для привлечения разработчиков, умеющих программировать на других языках'
        },
        {
          item: 'Для разгрузки JVM',
          name: 'Для разгрузки JVM'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/elevenchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[0].task.answer

          window.frontendData.language.chapters[10].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-1-theme-1-subtheme');

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