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
          Принцип постоянства символьных строк
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В классе String отсутствуют методы, которые позволяли бы изменять символы
              в существующей строке. Так, если требуется заменить символьную строку в переменной greeting с "Hello” на
              "Help!", этого нельзя добиться одной лишь заменой двух последних символов. Программирующим на С это
              покажется, по меньшей
              мере, странным. "Как же видоизменить строку?" — спросят они. В языке Java можно
              внести необходимые изменения в строку, выполнив сцепление подстроки, которую
              требуется сохранить, с заменяющими символами, как показано ниже. В итоге переменной greeting
              присваивается символьная строка "Help! "
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">greeting = greeting.substring(<span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>, <span class="hljs-number"
                                                                                       style="color: rgb(255, 115, 253);">3</span>) + <span
                class="hljs-string" style="color: rgb(168, 255, 96);">"p!"</span>;</pre>
            <p>
              Программируя на Java, нельзя изменять отдельные символы в строке, поэтому в документации на этот язык
              объекты типа String называются неизменяемыми, т.е. постоянными. Как число 3 всегда равно 3, так и строка
              "Hello" всегда состоит из последовательности кодовых единиц символов 'Н', V, '1', '1' и 'o’.Изменить ее
              состав нельзя.
              Но, как мы только что убедились, можно изменить содержимое строковой переменной
              greeting и заставить ее ссылаться на другую символьную строку подобно тому, как
              числовой переменной, в которой хранится число 3, можно присвоить число 4.
            </p>
            <p>
              Не приводит ли это к снижению эффективности кода? Казалось бы, намного проще изменять символы, чем
              создавать новую строку заново. Возможно, это и так. В самом деле, неэффективно создавать новую строку
              путем сцепления символьных строк
              "Неl" и "р! ". Но у неизменяемых строк имеется одно существенное преимущество:
              компилятор может сделать строки совместно используемыми.
            </p>
              Чтобы стал понятнее принцип постоянства символьных строк, представьте, что
              в общем пуле находятся разные символьные строки. Строковые переменные указывают
              на объекты в этом пуле. При копировании строковой переменной оригинал и копия
              содержат одну и ту же общую последовательность символов. Одним словом, создатели
              языка Java решили, что эффективность совместного использования памяти перевешивает неэффективность
              редактирования строк путем выделения и сцепления подстрок.
            <p>
              Посмотрите на свои программы. Чаще всего вы скорее сравниваете символьные строки, а не изменяете их.
              Разумеется, бывают случаи, когда непосредсвеные манипуляции символьными строками оказываются более
              эффективными. Одна из
              таких ситуаций возникает, когда нужно составить строку из отдельных символов, поступающих из файла или
              вводимых с клавиатуры. Для подобных ситуаций в языке
              Java предусмотрен отдельный класс StringBuffer, рассматриваемый далее, в разделе
              3.6.9, а в остальном достаточно средств, предоставляемых в классе String.
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
          По какой причине строки сделали неизменяемыми?
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
          По какой причине строки сделали неизменяемыми?
        </label>
        <p class="page-theme-theory-text">
          Ваш ответ: Единсво адресного пространства оригинала и копии
        </p>
      </div>

      <div class="box animate" style="" v-show="animationOn">Успех</div>

      <b-btn class="my-b-btn page-theme-btn-submit" v-on:click="Request" v-show="showInput">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from "axios";
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false


export default {
  name: "ConstantlySymbolStr",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,

      timeStarted: 0,
      timeEndeded: 0,
      timeSpended: 0,

      selected: 'History',
      options: [
        {item: 'History', name: 'Историческая причина'},
        {item: 'Create', name: 'Создаем чаще, чем редактируем'},
        {item: 'Refactor', name: 'Редактируем чаще чем создаем'},
        {item: 'UniteAddressSpace', name: 'Единсво адресного пространства оригинала и копии'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 21,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[20].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[20].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[20].task.answer

          window.frontendData.language.chapters[1].listThemes[20].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[20].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[20].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[20].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[20].task.tryCount + ".",{
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
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[20].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[20].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-6-them-3-subtheme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if(pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>