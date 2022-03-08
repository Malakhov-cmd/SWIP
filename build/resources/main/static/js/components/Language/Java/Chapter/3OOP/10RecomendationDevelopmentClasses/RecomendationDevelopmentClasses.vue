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
          Рекомендации по разработке классов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В завершение этой главы приведем некоторые рекомендации, которые призваны
              помочь вам в разработке классов в стиле ООП.
            </p>

            <ul>
              <li>
                <p>
                  Всегда храните данные в переменных, объявленных как p riv ate.
                  Первое и главное требование: всеми средствами избегайте нарушения инкапсуляции. Иногда приходится
                  писать методы доступа к полю или модифицирующие методы, но предоставлять доступ к полям не следует.
                  Как показывает
                  горький опыт, способ представления данных может изменяться, но порядок их
                  использования изменяется намного реже. Если данные закрыты, их представление не влияет на
                  использующий их класс, что упрощает выявление ошибок.
                </p>
              </li>
              <li>
                <p>
                  Всегда инициализируйте данные.
                  В языке Java локальные переменные не инициализируются, но поля в объектах
                  инициализируются. Не полагайтесь на действия по умолчанию, инициализируйте переменные явным образом с
                  помощью конструкторов.

                </p>
              </li>
              <li>
                <p>
                  Не употребляйте в классе слишком много простых типов.
                  Несколько связанных между собой полей простых типов следует объединять
                  в новый класс. Такие классы проще для понимания, а кроме того, их легче видоизменить. Например,
                  следующие четыре поля из класса Customer нужно
                  объединить в новый класс Address:
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String street;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String city;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String state;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">int</span> zip;
</pre>
              </li>
              <li>
                <p>
                  Не для всех полей нужно создавать методы доступа и модификации.
                  Очевидно, что при выполнении программы расчета зарплаты требуется получать сведения о зарплате
                  работника, а кроме того, ее приходится время от времени изменять. Но вряд ли придется менять дату его
                  приема на работу после
                  того, как объект сконструирован. Иными словами, существуют поля, которые
                  после создания объекта совсем не изменяются. К их числу относится, в частности, массив сокращенных
                  названий штатов США в классе Address.

                </p>
              </li>
              <li>
                <p>
                  Разбивайте на части слишком крупные классы.
                  Это, конечно, слишком общая рекомендация: то, что кажется "слишком крупным" одному программисту,
                  представляется нормальным другому. Но если
                  есть очевидная возможность разделить один сложный класс на два класса попроще, то воспользуйтесь ею.
                  (Опасайтесь, однако, другой крайности. Вряд ли
                  оправданы десять классов, в каждом из которых имеется только один метод.)
                  Ниже приведен пример неудачного составления класса.
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">CardDeck</span> // неудачная конструкция
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span>[] value;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span>[] suit;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">CardDeck</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">shuffle</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">getTopValue</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> getTopSuitO { . . . }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">draw</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
}</pre>
                <p>
                  На самом деле в этом классе реализованы два разных понятия: во-первых, карточный стол с методами
                  shuffle () (тасование) и draw () (раздача) и, во-вторых,
                  игральная карта с методами для проверки ранга и масти карты. Разумнее было бы
                  ввести класс Card, представляющий отдельную игральную карту. В итоге имелись
                  бы два класса, каждый из которых отвечал бы за свое, как показано ниже.

                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">CardDeck</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Card[] cards;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">CardDeck</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">shuffle</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Card getTopO { . . . }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">draw</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{ . . . }
}
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                      class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                                 style="color: rgb(37, 127, 173);">Card</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> value;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> suit;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Card</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(<span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> aValue, <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">int</span> aSuit)</span> </span>{ . . . }
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> getValueO { . . . }
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> getSuitO { . . . }
}</pre>
              </li>
              <li>
                <p>
                  Выбирайте для классов и методов осмысленные имена, ясно указывающие на их назначение.
                  Классы, как и переменные, следует называть именами, отражающими их назначение. (В стандартной
                  библиотеке имеются примеры, где это правило нарушается. Например, класс Date описывает время, а не
                  дату.)
                  Удобно принять следующие условные обозначения: имя класса должно
                  быть именем существительным (Order) или именем существительным, которому предшествует имя
                  прилагательное (RushOrder) или деепричастие
                  (BillingAddress).
                </p>
              </li>
              <li>
                <p>
                  Отдавайте предпочтение неизменяемым классам.
                  Класс LocalDate и прочие классы из пакета java.time являются неизменяемыми. Это означает, что они не
                  содержат методы, способные видоизменить
                  (т.е. модифицировать) состояние объекта. Вместо модификации объектов такие методы, как, например,
                  plusDays (), возвращают новые объекты с видоизмененным состоянием.

                </p>
                <p>
                  Трудность модификации состоит в том, что она может происходить параллельно, когда в нескольких
                  потоках исполнения предпринимается одновременная попытка обновить объект. Результаты такого
                  обновления непредсказуемы.
                  Если же классы являются неизменяемыми, то их объекты можно благополучно
                  разделять среди нескольких потоков исполнения.

                </p>
                <p>
                  Таким образом, классы рекомендуется делать неизменяемыми при всякой
                  удобной возможности. Это особенно просто сделать с классами, представляющими значения вроде
                  символьной строки или момента времени. А в результате вычислений просто получаются новые значения, а
                  не обновляются уже
                  существующие.

                </p>
                <p>
                  Разумеется, не все классы должны быть неизменяемыми. Было бы, например,
                  нелепо, если бы метод raiseSalaryO возвращал новый объект типа Employee,
                  когда поднимается заплата работника.
                </p>
              </li>
            </ul>

            <p>
              В этой главе были рассмотрены основы создания объектов и классов, которые делают Java объектным языком.
              Но для того чтобы быть действительно объектно-ориентированным, язык программирования должен также
              поддерживать наследование
              и полиморфизм. О реализации этих принципов ООП в Java речь пойдет в следующей главе.


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
          Что следует сделать, если в классе слишком много полей?
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
          Что следует сделать, если в классе слишком много полей?
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
  name: "RecomendationDevelopmentClasses",
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

      selected: 'Удалить класс',
      options: [
        {item: 'Удалить класс', name: 'Удалить класс'},
        {item: 'Проставить отступы и пробелы в логических частях', name: 'Проставить отступы и пробелы в логических частях'},
        {item: 'Разбить на несколько классов', name: 'Разбить на несколько классов'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 23,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[22].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[22].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[22].task.answer

          window.frontendData.language.chapters[2].listThemes[22].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[22].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[22].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[22].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[22].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[22].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[22].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-9-theme');

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