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
          Функциональные интерфейсы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Как было показано ранее, в Java имеется немало интерфейсов, инкапсулирующих
              блоки кода, в том числе ActionListener и Comparator. Лямбда-выражения совместимы с этими интерфейсами.
              Лямбда-выражение можно предоставить всякий раз,
              когда ожидается объект класса, реализующего интерфейс с единственным абстрактным методом. Такой интерфейс
              называется функциональным.

            </p>

            <p>
              тобы продемонстрировать преобразование в функциональный интерфейс, рассмотрим снова метод Arrays. sort
              (). В качестве второго параметра ему требуется
              экземпляр типа Comparator — интерфейса с единственным методом. Вместо него достаточно предоставить
              лямбда-выражение следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Arrays.sort(words,
        (first, second) -&gt; first.length() - second.length());</pre>
            <p>Подспудно метод Arrays. sort () принимает объект некоторого класса, реализующего интерфейс Comparator. В
              результате вызова метода compare () для этого объекта выполняется тело лямбда-выражения. Управление
              такими объектами и классами
              полностью зависит от конкретной реализации и может быть намного более эффективным, чем применение
              традиционных внутренних классов. Поэтому лямбда-выражение лучше всего рассматривать как функцию, а не
              объект, приняв к сведению, что
              оно может быть передано функциональному интерфейсу.


            </p>
            <p>Именно такое преобразование в функциональные интерфейсы и делает столь
              привлекательными лямбда-выражения. Их синтаксис прост и лаконичен. Рассмотрим
              еще один пример употребления лямбда-выражения. Приведенный ниже код намного легче читать, чем его
              альтернативный вариант с классом, реализующим интерфейс
              ActionListener.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    Timer t = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(<span class="hljs-number"
                                                                                               style="color: rgb(147, 92, 37);">1000</span>, event -&gt;
    {
        System.out.printing(<span class="hljs-string"
                                  style="color: rgb(86, 140, 59);">"At the tone, the time is "</span> + <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date());
        Toolkit.getDefaultToolkit().beep();
    });</pre>
            <p>
              В действительности единственное, что можно сделать с лямбда-выражением
              в Java, — преобразовать его в функциональный интерфейс. В других языках программирования, поддерживающих
              функциональные литералы, можно объявлять типы
              функций вроде (String, String) -> int, объявлять переменные подобных типов,
              присваивать этим переменным функции и вызывать их. Но разработчики Java решили придерживаться знакомого
              им понятия интерфейсов вместо того, чтобы вводить
              в язык функциональные типы
            </p>
            <p>
              В стандартной библиотеке Java предоставляется целый ряд весьма универсальных функциональных интерфейсов,
              входящих в пакет java.util, function. К их
              числу относится функциональный интерфейс BiFunction
              < T , U, R >, описывающий
              функции с помощью параметров типа Т и U и возвращаемого типа R. В частности,
              лямбда-выражение для сравнения символьных строк можно сохранить в переменной
              этого типа следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    BiFunction&lt;String, String, Integer&gt; comp
            = (first, second) -&gt; first.length() - second.length();</pre>
            <p>
              = (first, second) -> first.length() - second.length();
              Тем не менее это никак не помогает при сортировке, поскольку отсутствует такой метод Arrays. sort (),
              которому требовался бы параметр типа BiFunction. Если
              у вас имеется прежний опыт функционального программирования, такая ситуация
              может показаться вам необычной. Но для программирующих на Java она вполне
              естественна. У такого интерфейса, как Comparator, имеется конкретное назначение,
              а не только метод с заданными типами параметров и возвращаемого значения. И подобный подход сохраняется в
              версии Java SE 8. Так, если требуется сделать что-нибудь
              с лямбда-выражением, нужно по-прежнему учитывать его назначение, имея для него
              конкретный функциональный интерфейс.
            </p>
            <p>
              Особенно удобным оказывается функциональный интерфейс Predicate из пакета
              java.util. function. Он определяется следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Predicate</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">T</span>&gt; </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">test</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(T t)</span></span>;
<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// Дополнительные методы по умолчанию и статические методы</span>
}</pre>
            <p>
              В классе ArrayList имеется метод removelf () с параметром типа Predicate.
              Этот метод специально предназначен для передачи ему лямбда-выражения. Например, в следующем выражении из
              списочного массива удаляются все пустые (null)
              значения:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">list.removelf(е -&gt; е == <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>);
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
          Чем функциональный интерфейс отличается от обычного?
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
          Чем функциональный интерфейс отличается от обычного?
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
  name: "FunctionalInterfaces",
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

      selected: 'ФИ не имеет расширений',
      options: [
        {item: 'ФИ не имеет расширений', name: 'ФИ не имеет расширений'},
        {item: 'ФИ не имеет дефолтных методов', name: 'ФИ не имеет дефолтных методов'},
        {
          item: 'ФИ объявляет один единственный метод',
          name: 'ФИ объявляет один единственный метод'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[4].task.answer

          window.frontendData.language.chapters[4].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[4].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-5-chapter-2-theme-2-subtheme');

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