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
          Принцип монитора
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Блокировки и условия — эффективные инструментальные средства синхронизации
              потоков исполнения, но они не слишком объектно-ориентированы. В течение многих
              лет исследователи искали способы обеспечения безопасности многопоточной обработки, чтобы избавить
              программистов от необходимости думать о явных блокировках.
              Одно из наиболее успешных решений — принцип монитора, который был впервые
              предложен Пером Бринчем Хансеном (Per Brinch Hansen) и Тони Хоаром (Топу Ноаге)
              в 1970-х годах. В терминологии Java монитор обладает следующими свойствами
            </p>
            <ul>
              <li>
                <p>
                  Монитор — это класс, имеющий только закрытые поля.
                </p>
              </li>
              <li>
                <p>
                  У каждого объекта такого класса имеется связанная с ним блокировка.
                </p>
              </li>
              <li>
                <p>
                  Все методы блокируются этой блокировкой. Иными словами, если клиент вызывает метод obj .method(),
                  блокировка объекта obj автоматически захватывается в начале этого метода и снимается по его
                  завершении. А поскольку все
                  поля класса монитора закрытые, то такой подход гарантирует, что к ним нельзя будет обратиться ни в
                  одном из потоков исполнения до тех пор, пока ими
                  манипулирует какой-то другой поток.
                </p>
              </li>
              <li>
                <p>
                  У блокировки может быть любое количество связанных с ней условий.

                </p>
              </li>
            </ul>
            <p>
              В первоначальных версиях мониторов имелось единственное условие с довольно
              изящным синтаксисом. Так, можно было просто сделать вызов await accounts [from]
              >= balance, не указывая явную условную переменную. Но исследования показали,
              что неразборчивая повторная проверка условий может оказаться неэффективной.
              Проблема была решена благодаря применению явных условных переменных, каждая
              из которых управляет отдельным рядом потоков исполнения.
            </p>

            <p>
              Создатели Java вольно адаптировали принцип монитора. Каждый объект в Java обладает встроенной блокировкой
              и встроенным условием. Если метод объявлен с ключевым словом synchronized, он действует как метод
              монитора. А переменная условия доступна через вызовы методов wait (), notifyAll (), notify ( ).
            </p>

            <p>
              Но объекты в Java отличаются от мониторов в следующих трех важных отношениях, нарушающих безопасность
              потоков исполнения.


            </p>

            <ul>
              <li>
                <p>
                  Поля не обязательно должны быть закрытыми (private).

                </p>
              </li>
              <li>
                <p>
                  Методы не обязаны быть синхронизированными (synchronized).
                </p>
              </li>
              <li>
                <p>
                  ВВстроенная блокировка доступна клиентам
                </p>
              </li>
            </ul>
            <p>
              Это — явное пренебрежение требованиями безопасности, изложенными Пером
              Бринчем Хансеном. В уничижительном обозрении, посвященном примитивам многозадачной обработки в Java, он
              пишет: "Для меня является непостижимым тот факт, что
              небезопасный параллелизм столь серьезно принят сообществом программистов, и это
              спустя четверть века после изобретения мониторов и языка Concurrent Pascal. Этому
              нет оправданий". [Java's Insecure Parallelism, ACM SIGPLAN Notices 34:38-45, April 1999].
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
          Какая из идей заложена в концепции монитора?
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
          Какая из идей заложена в концепции монитора?
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
  name: "MonitorPrincep",
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

      selected: 'Исользование await в каждом методе',
      options: [
        {
          item: 'Исользование await в каждом методе',
          name: 'Исользование await в каждом методе'
        },
        {
          item: 'Установление расширения synchronized на класс',
          name: 'Установление расширения synchronized на класс'
        },
        {
          item: 'Установление всех полей с доступом private для ограничения доступа к данным другим потоков',
          name: 'Установление всех полей с доступом private для ограничения доступа к данным другим потоков'
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
          numberTheme: 13,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[12].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[12].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[12].task.answer

          window.frontendData.language.chapters[8].listThemes[12].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[12].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[12].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[12].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[12].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[12].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[12].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-6-subtheme');

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