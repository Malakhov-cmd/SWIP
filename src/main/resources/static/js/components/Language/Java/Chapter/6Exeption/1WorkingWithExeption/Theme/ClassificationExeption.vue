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
          Классификация исключений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              языке Java объект исключения всегда является экземпляром класса, производного от класса Throwable. Как
              станет ясно в дальнейшем, если стандартных классов
              недостаточно, можно создавать и свои собственные классы исключений.
            </p>

            <p>
              <img src="https://cdn.javarush.ru/images/article/5c5a8939-dd12-4c70-aeda-00cb2909d340/1080.webp"
                   alt="schema" style="max-width: 80%;"/>
            </p>

            <p>Обратите внимание на то, что иерархия наследования исключений сразу же разделяется на две ветви: Error и
              Exception, хотя общим предшественником для всех
              исключений является класс Throwable. Иерархия класса Error описывает внутренние ошибки и ситуации,
              возникающие в связи с нехваткой ресурсов в исполняющей
              системе Java. Ни один объект этого класса нельзя сгенерировать самостоятельно.
              При возникновении внутренней ошибки в такой системе возможности разработчика
              прикладной программы крайне ограничены. Можно лишь уведомить пользователя
              и попытаться аккуратно прервать выполнение программы, хотя такие ситуации достаточно редки.


            </p>
            <p>При программировании на Java основное внимание следует уделять иерархии
              класса Exception. Эта иерархия также разделяется на две ветви: исключения, производные от класса
              RuntimeException, и остальные. Исключения типа RuntimeException
              возникают вследствие ошибок программирования. Все другие виды исключений являются следствием
              непредвиденного стечения обстоятельств, например, ошибок ввода-вывода, возникающих при выполнении вполне
              корректных программ
            </p>
            <p>
              Исключения, производные от класса RuntimeException, связаны со следующими
              программными ошибками.
            </p>
            <ul>
              <li>
                <p>
                  Неверное приведение типов.
                </p>
              </li>
              <li>
                <p>
                  Выход за пределы массива.

                </p>
              </li>
              <li>
                <p>
                  Попытка обратиться к объекту по пустой ссылке null.

                </p>
              </li>
            </ul>
            <p>
              Остальные исключения возникают в следующих случаях.
            </p>
            <ul>
              <li>
                <p>
                  Попытка чтения по достижении конца файла.
                </p>
              </li>
              <li>
                <p>
                  Попытка чтения по достижении конца файла.
                </p>
              </li>
              <li>
                <p>
                  Попытка получить объект типа Class, если в символьной строке указан несуществующий класс.

                </p>
              </li>
            </ul>
            <p>
              Исключения типа RuntimeException практически всегда возникают по вине программиста. Так, исключения типа
              ArraylndexOutBoundsException можно избежать,
              если всегда проверять индексы массива. А исключение NullPointerException никогда не возникнет, если перед
              тем, как воспользоваться переменной, проверить, не
              содержит ли она пустое значение null.

            </p>

            <p>
              как быть, если файл не существует? Нельзя ли сначала проверить, существует
              ли он вообще? Дело в том, что файл может быть удален сразу же после проверки
              его существования. Следовательно, понятие существования файла зависит от среды
              исполнения, а не от кода программы.
            </p>
            <p>
              как быть, если файл не существует? Нельзя ли сначала проверить, существует
              ли он вообще? Дело в том, что файл может быть удален сразу же после проверки
              его существования. Следовательно, понятие существования файла зависит от среды
              исполнения, а не от кода программы.
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
          Что может относиться к ошибкам типа IOException?
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
          Что может относиться к ошибкам типа IOException?
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
  name: "ClassificationExeption",
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

      selected: 'Выход за пределы массива',
      options: [
        {item: 'Выход за пределы массива', name: 'Выход за пределы массива'},
        {item: 'Деление на ноль', name: 'Деление на ноль'},
        {
          item: 'Получение подключения к базе данных',
          name: 'Получение подключения к базе данных'
        },
        {
          item: 'Вызов несуществующего метода',
          name: 'Вызов несуществующего метода'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/sixthchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[5].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[5].chapterProgress += 16.6
              window.frontendData.language.chapters[5].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[5].listThemes[0].task.answer

          window.frontendData.language.chapters[5].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[5].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[5].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[5].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[5].listThemes[0].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-6-chapter-1-theme-1-subtheme');

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