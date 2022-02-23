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
          Преобразование обобщенных методов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Стирание типов происходит и в обобщенных методах. Программисты обычно воспринимают обобщенные методы как
              целое семейство методов вроде следующего:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> &lt;Т extends Comparable&gt; Т min(T[] а)
</pre>
            <p>
              Но после стирания типов остается только один приведенный ниже метод. Обратите внимание на то, что
              параметр обобщенного типа Т стирается, а остается только
              ограничивающий тип Comparable,

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Comparable <span
                class="hljs-title" style="color: rgb(37, 127, 173);">min</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(Comparable[] a)</span></span></pre>


            <p>Стирание типов в обобщенных методах приводит к некоторым осложнениям. Рассмотрим следующий пример кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Datelnterval</span> <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span>&lt;<span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">LocalDate</span>&gt;
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">setSecond</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(LocalDate second)</span>
    </span>{
        <span class="hljs-keyword"
              style="color: rgb(107, 107, 184);">if</span> (second.compareTo(getFirst()) &gt;= <span class="hljs-number"
                                                                                                     style="color: rgb(147, 92, 37);">0</span>)
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.setSecond(second);
    }
}</pre>

            <p>
              В этом фрагменте кода интервал дат задается парой объектов типа LocalDate,
              и поэтому соответствующие методы требуется переопределить, чтобы второе сравниваемое значение не было
              меньше первого. В результате стирания данный класс
              преобразуется в следующий:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Datelnterval</span> <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span> // после стирания
</span>{
      <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
          class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">setSecond</span><span
          class="hljs-params" style="color: rgb(147, 92, 37);">(LocalDate second)</span> </span>{ . . . }
}</pre>
            <p>
              Как ни странно, но имеется и другой метод setSecond (), унаследованный от класса Pair, а именно:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">setSecond</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(Object second)</span></span></pre>
            <p>
              И это совершенно иной метод, поскольку он имеет параметр другого типа: Object
              вместо LocalDate. Но он не должен быть другим. Рассмотрим следующую последовательность операторов:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Datelnterval interval = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Datelnterval(. . .);
Pair&lt;LocalDate&gt; pair = interval; <span class="hljs-comment" style="color: rgb(113, 149, 168);">// допускается присваивание суперклассу </span>
pair.setSecond(aDate);
</pre>
            <p>
              Предполагается, что вызов метода setSecond () является полиморфным, и поэтому вызывается соответствующий
              метод. А поскольку переменная pair ссылается
              на объект типа Datelnterval, это должен быть вызов Datelnterval. setSecond ().
              Но дело в том, что стирание типов мешает соблюдению принципа полиморфизма. В
              качестве выхода из этого затруднительного положения компилятор формирует следующий мостовой метод в
              классе Datelnterval:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">setSecond</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(Object second)</span> </span>{ setSecond((LocalDate) second); }</pre>
            <p>
              Чтобы стал понятнее этот механизм, проанализируем выполнение приведенного
              ниже оператора.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">pair.setSecond(aDate)</pre>
            <p>
              В объявлении переменной pair указан тип Pair< LocalDate >, к которому относится только один метод под
              именем setSecond, а именно setSecond (Object).
              Виртуальная машина вызывает этот метод для того объекта, на который ссылается
              переменная pair. Этот объект относится к типу Datelnterval, и поэтому вызывается метод Datelnterval.
              setSecond (Object). Именно он и является синтезированным мостовым методом. Ведь он, в свою очередь,
              вызывает метод Datelnterval.
              setSecond (LocalDate), что, собственно говоря, и требуется.
            </p>
            <p>
              Мостовые методы могут быть еще более необычными. Допустим, метод из класса
              Datelnterval также переопределяет метод getSecondf), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Datelnterval</span> <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span>&lt;<span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">LocalDate</span>&gt;
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> LocalDate getSecondO
    { <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> (LocalDate) <span class="hljs-keyword"
                                                                                                    style="color: rgb(107, 107, 184);">super</span>.getSecond().clone(); }
}</pre>
            <p>
              В классе Datelnterval имеются следующие два метода под именем getSecond:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function">Date <span class="hljs-title"
                                                 style="color: rgb(37, 127, 173);">getSecond</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-comment"
                                                                                     style="color: rgb(113, 149, 168);">// определен в классе Datelnterval</span>
Object <span class="hljs-title" style="color: rgb(37, 127, 173);">getSecond</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span> <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// переопределяет метод из класса Pair</span>
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// для вызова первого метода</span>
</span></pre>
            <p>
              Написать такой код на Java без параметров нельзя. Ведь было бы неверно иметь
              два метода с одинаковыми типами параметров. Но в виртуальной машине типы параметров и возвращаемый тип
              определяют метод. Поэтому компилятор может сформировать байт-код для двух методов, отличающихся только
              возвращаемым типом,
              и виртуальная машина правильно ведет себя в подобной ситуации.

            </p>
            <p>
              Таким образом, о преобразовании обобщений в Java нужно запомнить следующее.
            </p>
            <ul>
              <li>
                <p>
                  Для виртуальной машины обобщений не существует, но имеются только обычные классы и методы.
                </p>
              </li>
              <li>
                <p>
                  Все параметры типа заменяются ограничивающими типами.
                </p>
              </li>
              <li>
                <p>
                  Мостовые методы синтезируются для соблюдения принципа полиморфизма.

                </p>
              </li>
              <li>
                <p>
                  Операции приведения типов вводятся по мере надобности для обеспечения
                  типовой безопасности.

                </p>
              </li>
            </ul>


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
          Что происходит при компиляции обощенных классов имеющих ограничение типа?
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
          Что происходит при компиляции обощенных классов имеющих ограничение типа?
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
  name: "TransformationGenericMethods",
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

      selected: 'Преобразование в тип T',
      options: [
        {item: 'Преобразование в тип T', name: 'Преобразование в тип T'},
        {
          item: 'Преобразование в тип указанный после ключевого слова extends',
          name: 'Преобразование в тип указанный после ключевого слова extends'
        },
        {
          item: 'Оптимизация под вызываемый тип',
          name: 'Оптимизация под вызываемый тип'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/seventhchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 16.6
              window.frontendData.language.chapters[6].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[6].task.answer

          window.frontendData.language.chapters[6].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[6].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[6].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-7-chapter-5-theme-3-subtheme');

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