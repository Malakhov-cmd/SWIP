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
          Объектные оболочки и автоупаковка
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Иногда переменные примитивных типов вроде int приходится преобразовывать
              в объекты. У всех примитивных типов имеются аналоги в виде классов. Например, существует класс Integer,
              соответствующий типу int. Такие классы принято называть
              объектными оболочками. Они имеют вполне очевидные имена: Integer, Long, Float,
              Double, Short, Byte, Character и Boolean. (У первых шести классов имеется общий суперкласс Number.)
              Классы объектных оболочек являются неизменяемыми. Эго означает,
              что изменить значение, хранящееся в объектной оболочке после ее создания, нельзя.
            </p>
            <p>
              Допустим, в списочном массиве требуется хранить целые числа. К сожалению,
              с помощью параметра типа в угловых скобках нельзя задать примитивный тип, например, выражение ArrayList
              типа int недопустимо. И здесь приходит на помощь
              класс объектной оболочки Integer. В частности, списочный массив, предназначенный для хранения объектов
              типа Integer, можно объявить следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ArrayList&lt;Integer&gt; list = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ArrayList&lt;Integer&gt; () ;</pre>

            <p>
              Правда, в Java имеется удобное языковое средство, позволяющее добавлять и извлекать элементы из массива.
              Рассмотрим следующую стро
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">list.add(<span
                class="hljs-number" style="color: rgb(147, 92, 37);">3</span>);
</pre>
            <p>
              Она автоматически преобразуется в приведенную ниже строку кода. Подобное автоматическое преобразование
              называется автоупаковкой.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">list.add(<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Integer(<span class="hljs-number"
                                                                                                 style="color: rgb(147, 92, 37);">3</span>)) ;</pre>

            <p>
              С другой стороны, если присвоить объект типа Integer переменной типа int,
              целочисленное значение будет автоматически извлечено из объекта, т.е. распаковано.
              Иными словами, компилятор преобразует следующую строку кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> n = list.get(i);
</pre>
            <p>
              в приведенную ниже строку кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> n = list.get(i).intValue();</pre>

            <p>
              Автоматическая упаковка и распаковка примитивных типов может выполняться
              и при вычислении арифметических выражений. Например, операцию инкремента
              можно применить к переменной, содержащей ссылку на объект типа Integer, как
              показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Integer n = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">3</span>;
n++;
</pre>
            <p>
              Компилятор автоматически распакует целочисленное значение из объекта, увеличит его на единицу и снова
              упакует в объект.
            </p>

            <p>
              На первый взгляд может показаться, что примитивные типы и их объектные оболочки — одно и то же. Их
              отличие становится очевидным при выполнении операции
              проверки на равенство. Как вам должно быть уже известно, при выполнении операции == над объектом
              проверяется, ссылаются ли сравниваемые переменные на один
              и тот же адрес памяти, где находится объект. Ниже приведен пример, где, несмотря
              на равенство целочисленных значений, проверка на равенство, вероятнее всего, даст
              отрицательный результат.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Integer а = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>;
Integer b = <span class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>;
<span class="hljs-function">i <span class="hljs-title" style="color: rgb(37, 127, 173);">f</span> <span
    class="hljs-params" style="color: rgb(147, 92, 37);">(а == Ь)</span> . . .
</span></pre>
            <p>
              Но реализация Java может, если пожелает, заключить часто встречающиеся значения в оболочки одинаковых
              объектов, и тогда сравнение даст положительный результат. Хотя такая неоднозначность результатов мало
              кому нужна. В качестве выхода
              из этого положения можно воспользоваться методом equals () при сравнении объектов-оболочек.

            </p>

            <p>
              У автоупаковки и распаковки имеются и другие особенности. Прежде всего, при
              автораспаковке может быть сгенерировано исключение, если ссылки на класс оболочки окажутся пустыми
              (null), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">NullPointerException :
Integer n = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>;
System.out.println(<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>*n) ;</pre>
            <p>
              А если в условном выражении употребляются типы Integer и Double, то значение типа Integer
              распаковывается, продвигается к типу Double и снова упаковывается, как демонстрируется в следующем
              фрагмент

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Integern = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">1</span>
Double х = <span class="hljs-number" style="color: rgb(147, 92, 37);">2.0</span>;
System.out.println(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">true</span> ? n : x ) ; <span
                  class="hljs-comment"
                  style="color: rgb(113, 149, 168);">// в ы в о д и т с я з н а ч е н и е 1 .0</span></pre>

            <p>
              И наконец, следует заметить, что за упаковку и распаковку отвечает не виртуальная машина, а компилятор.
              Он включает в программу необходимые вызовы, а виртуальная машина лишь выполняет байт-ко
            </p>

            <p>
              Объектные оболочки числовых значений находят широкое распространение еще
              и по другой причине. Создатели Java решили, что в составе классов объектных оболочек удобно было бы
              реализовать методы для преобразования символьных строк
              в числа. Чтобы преобразовать символьную строку в целое число, можно воспользоваться выражением, подобным
              приведенному ниже.

            </p>
            <p>
              Обратите внимание на то, что создавать объект типа Integer в этом случае совсем не обязательно, так как
              метод parselnt () является статическим. И тем не менее
              класс Integer — подходящее для этого место.
            </p>

            <p>
              Ниже описаны наиболее употребительные методы из класса Integer. Аналогичные методы имеются и в других
              классах объектных оболочек для значений примитивных типов.

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
          Для чего созданы оболочки?
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
          Для чего созданы оболочки?
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
  name: "ObjectShellAndAutoPacking",
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

      selected: 'Для удобства',
      options: [
        {
          item: 'Для удобства',
          name: 'Для удобства'
        },
        {item: 'Для использования примитивных типов в качестве объектов', name: 'Для использования примитивных типов в качестве объектов'},
        {
          item: 'Для использования методов класса Object',
          name: 'Для использования методов класса Object'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fourthchapter/', {
        params: {
          numberTheme: 12,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[11].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[11].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[11].task.answer

          window.frontendData.language.chapters[3].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[11].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[11].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[11].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-4-chapter-4-theme');

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