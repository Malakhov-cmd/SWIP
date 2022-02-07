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
          Числовые типы данных с плавающей точкой
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Типы данных с плавающей точкой представляют числа с дробной частью. В языке
              Java имеются два числовых типа данных с плавающей точкой. Они приведены в табл.
            </p>
            <div>
              <b-table :bordered="true" hover :items="items" class="page-theme-theory-text" caption-top></b-table>
            </div>
            <p>Название double означает, что точность таких чисел вдвое превышает точность
              чисел типа float. (Некоторые называют их числами с двойной точностью.) Для большинства приложений тип
              douЫe считается более удобным, а ограниченной точности чисел типа f 1 оа t во многих случаях оказывается
              совершенно недостаточно. Числовыми значениями типа float следует пользоваться лишь в работе с
              библиотекой,
              где они непременно требуются, или же в том случае, если такие значения приходится
              хранить в большом количестве.
            </p>
            <p>
              Числовые значения типа float указываются с суффиксом F, например З .14F.
              А числовые значения с плавающей точкой, указываемые без суффикса F (например, З .14), всегда
              рассматриваются как относящиеся к типу douЬle. Для их представления можно (но не обязательно)
              использовать суффикс D, например З .14D.
            </p>
            <p>
              Все операции над числами с плавающей точкой производятся по стандарту
              IEEE 754. В частности, в Java имеются три специальных значения с плавающей точкой.
            </p>
            <p>
              <i>Положительная бесконечность. </i>
              <i>Отрицательная бесконечность.</i>
              <i>Не число (NaN). </i>
            </p>
            <p>
              Например, результат деления положительного числа на О равен положительной
              бесконечности. А вычисление выражения О/ О или извлечение квадратного корня из
              отрицательного числа дает нечисловой результат NaN.
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
public class Main
{
	public static void main(String[] args) {
		float a = 123.45F;
		double b = 0F;

		System.out.println(a/b);
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
import * as CodeMirror from "codemirror"
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "FloatType",
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

      items: [
        {
          Тип: "float",
          Требуемый_объем_памяти_в_байтах: 4,
          Диапазон_опустимых_значений: 'Приблизительно ±3, 40282347E+38F 16-7 значащих \n' +
              'десятичных цифр! \n'
        },
        {
          Тип: "double",
          Требуемый_объем_памяти_в_байтах: 8,
          Диапазон_опустимых_значений: 'Приблизительно ±1, 7976931348623157E+308F \n' +
              '115 значащих десятичных цифр! \n'
        }
      ],
      selected: 'ArithmeticException',
      options: [
        {item: 'ArithmeticException', name: 'ArithmeticException'},
        {item: '+0', name: '+0'},
        {item: 'NaN', name: 'Nan'},
        {item: 'Infinity', name: 'Infinity'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[3].task.answer

          window.frontendData.language.chapters[1].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[1].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[3].task.answer
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
        `public class Main
{
\tpublic static void main(String[] args) {
\t\tfloat a = 123.45F;
\t\tdouble b = 0F;
\t\t
\t\tSystem.out.println(a/b);
\t}
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

    let themeToClose = document.getElementById('java-2-chapter-3-them-2-subtheme');

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