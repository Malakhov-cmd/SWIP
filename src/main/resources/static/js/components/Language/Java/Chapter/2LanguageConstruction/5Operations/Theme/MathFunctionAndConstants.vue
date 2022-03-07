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
          Математические функции и константы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p> состав класса Math входит целый набор математических функций, которые нередко требуются для решения
              практических задач. В частности, чтобы извлечь квадратный корень из числа, применяется метод sqrt ():
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> х = <span class="hljs-number"
                                                                                               style="color: rgb(0, 204, 102);">4</span>;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> у = Math.sqrt(х);
System.out.println(у); <span class="hljs-comment"
                             style="color: rgb(68, 68, 68);">// выводит числовое значение 2.0</span>
</pre>
            <p>В языке Java не поддерживается операция возведения в степень. Для этого нужно вызвать метод pow() из
              класса Math. В результате выполнения приведенной ниже
              строки кода переменной у присваивается значение переменной х, возведенное в степень. Оба параметра
              метода pow(), а также возвращаемое им значение относятся к типу double.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> у = Math.pow(х ,а);
</pre>

            <p>
              Метод floorM od() предназначен для решения давней проблемы с остатками
              от целочисленного деления. Рассмотрим в качестве примера выражение п % 2. Как
              известно, если число п является четным, то результат данной операции равен О,
              а иначе — 1. Если же число п оказывается отрицательным, то результат данной операции будет равен -1.
              Почему? Когда были созданы первые компьютеры, то кем-то
              были установлены правила целочисленного деления с остатком и для отрицательных
              операндов. Оптимальное (или эвклидово) правило такого деления известно в математике уже многие сотни лет
              и состоит в следующем: остаток всегда должен быть £ 0.
              Но вместо того, чтобы обратиться к справочнику по математике, первопроходцы
              в области вычислительной техники составили правила, которые им показались вполне благоразумными, хотя на
              самом деле они неудобные.
            </p>
            <p>
              Допустим, вычисляется положение часовой стрелки на циферблате. Корректируя
              это положение, нужно нормализовать его числовое значение в пределах от 0 до 11.
              Сделать это совсем не трудно следующим образом:
              (положение + коррекция) % 12

            </p>
            <p>
              Но что если корректируемое значение окажется отрицательным? В таком случае
              отрицательным может стать и полученный результат. Следовательно, в последовательность вычислений придется
              ввести ветвление или же составить такое выражение:
              ((положение + коррекция) % 12 + 12) % 12
            </p>
            <p>
              Но и то и другое довольно хлопотно. Дело упрощается благодаря методу floorMod().
              Так, в результате следующего вызова:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);">flooгMod{положение + коррекция, <span
                class="hljs-number" style="color: rgb(0, 204, 102);">12</span>)</pre>
            <p>
              всегда получается значение в пределах от 0 до 11. (К сожалению, метод f loorMod ()
              выдает и отрицательные результаты при отрицательных делителях, хотя такое нечасто случается на практике.)
            </p>
            <p>
              В состав класса Math входят также перечисленные ниже методы для вычисления
              обычных тригонометрических функций.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);">Math.sin()
Math.cos ()
Math.tan()
Math.atanO
Math.atan2()</pre>
            <p>
              Кроме того, в него включены методы для вычисления экспоненциальной и обратной к ней логарифмической
              функции (натурального и десятичного логарифмов):
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);">Math.exp()
Math.log()
Math.loglO()</pre>
            <p>
              И наконец, в данном классе определены также следующие две константы как приближенное представление чисел п
              и е.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);">Math.PI ()
Math.E()
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
class Main
{
    public static void main(String[] args)
    {
        System.out.println(Math.sin(0) + 2);
    }
}
        </textarea>

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
          Что выведет программа?
        </label>
        <textarea id="codeContentIdAnswered"></textarea>
        <p class="page-theme-theory-text">
          Ваш ответ: 2
        </p>
      </div>

      <div class="box animate" style="" v-show="animationOn">Успех</div>

      <b-btn class="my-b-btn page-theme-btn-submit" v-on:click="Request" v-show="showInput">Отправить</b-btn>
    </b-jumbotron>
  </div>
</template>

<script>
import axios from "axios";
import * as CodeMirror from "codemirror"
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "MathFunctionAndConstants",
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

      selected: 'Zero',
      options: [
        {item: 'One', name: '1'},
        {item: 'Two', name: '2'},
        {item: 'Zero', name: '0'},
        {item: 'Exception', name: 'Exception'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/secondchapter/', {
        params: {
          numberTheme: 11,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[10].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[10].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[10].task.answer

          window.frontendData.language.chapters[1].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[10].task.tryCount + ".",{
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
      setTimeout(() => {
        $('.CodeMirror').each(function (i, el) {
          el.CodeMirror.refresh();
        });
      }, 1000)
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[10].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[10].task.answer
    }

    this.codeContent = CodeMirror.fromTextArea(document.getElementById('codeContentId'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

    this.codeAnsweredContent = CodeMirror.fromTextArea(document.getElementById('codeContentIdAnswered'), {
      mode: 'jsx',
      lineNumbers: true,
      theme: 'dracula',
    });

    this.codeAnsweredContent.setValue(
        `class Main
{
    public static void main(String[] args)
    {
        System.out.println(Math.sin(0));
    }
}
      `)

    this.timeStarted = Date.now()

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-5-them-2-subtheme');

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