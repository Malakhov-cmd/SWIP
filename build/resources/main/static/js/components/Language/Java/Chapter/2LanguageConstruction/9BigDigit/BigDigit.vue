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
          Большие числа
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Если для решения задачи недостаточно точности основных типов, чтобы пред*
              ставить целые и вещественные числа, то можно обратиться к классам Biglnteger
              и BigDecimal из пакета java.math. Эти классы предназначены для выполнения
              действий с числами, состоящими из произвольного количества цифр. В классах
              Biglnteger и BigDecimal реализуются арифметические операции произвольной
              точности соответственно для целых и вещественных чисел.
            </p>
            <p>
              Для преобразования обычного числа в число с произвольной точностью (называемое также большим числом)
              служит статический метод valueOf():
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">Biglnteger а = Biglnteger.valueof(<span
                class="hljs-number" style="color: rgb(255, 115, 253);">100</span>);
</pre>
            <p>
              К сожалению, над большими числами нельзя выполнять обычные математические операции вроде + или *. Вместо
              этого следует применять методы add ()
              и multiply () из классов соответствующих типов больших чисел, как в приведенном
              ниже примере кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">BigInteger с = a.add(b); <span
                class="hljs-comment" style="color: rgb(124, 124, 124);">// с = а + b </span>
        BigInteger d = с.multiply(b.add(Biglnteger.value.Of(<span class="hljs-number"
                                                                  style="color: rgb(255, 115, 253);">2</span>))); <span
                  class="hljs-comment" style="color: rgb(124, 124, 124);">// d = c * (b + 2)</span>
    </pre>
            <p>
              В листинге 3.6 приведен видоизмененный вариант программы из листинга 3.5
              для подсчета шансов на выигрыш в лотерее. Теперь эта программа может оперировать большими числами. Так,
              если вам предложат сыграть в лотерее, в которой
              нужно угадать 60 чисел из 490 возможных, эта программа сообщит, что ваши шансы
              на выигрыш составляют 1 из 7 1 6 3 9 5 8 4 3 4 6 1 9 9 5 5 5 7 4 1 5 1 1 6 2 2 2 5 4 0 0 9 2 9 3 3 4 1 1 7
              1 7 6 1 2 7 8
              9 2 6 3 4 9 3 4 9 3 3 5 1 0 1 3 4 5 9 4 8 1 1 0 4 6 6 8 8 4 8 . Желаем удачи!

            </p>
            <p>
              Листинг 3.6.
            </p>
            <
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.math.*;
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(124, 124, 124);">/**
 * This program uses big numbers to compute the odds of winning the grand prize in a lottery.
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@version</span> 1.20 2004-02-10
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(255, 255, 182);">BigIntegerTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
       class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(150, 203, 254);">void</span> <span
       class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span>
   </span>{
      Scanner in = <span class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"How many numbers do you need to draw? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> k = in.nextInt();

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"What is the highest number you can draw? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> n = in.nextInt();

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">/*
       * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
       */</span>

      BigInteger lotteryOdds = BigInteger.valueOf(<span class="hljs-number" style="color: rgb(255, 115, 253);">1</span>);

      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; i &lt;= k; i++)
         lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + <span class="hljs-number"
                                                                             style="color: rgb(255, 115, 253);">1</span>)).divide(
               BigInteger.valueOf(i));

      System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Your odds are 1 in "</span> + lotteryOdds + <span
                  class="hljs-string" style="color: rgb(168, 255, 96);">". Good luck!"</span>);
   }
}
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
          Какова цель создания данных классов?
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
          Какова цель создания данных классов?
        </label>
        <p class="page-theme-theory-text">
          Ваш ответ: Сбережение примитивных типов от лишних нагрузок
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
  name: "BigDigit",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,

      timeStarted: 0,
      timeEndeded: 0,
      timeSpended: 0,

      selected: 'One',
      options: [
        {item: 'One', name: 'Работа с большими числами'},
        {item: 'Two', name: 'Сбережение примитивных типов от лишних нагрузок'},
        {item: 'Three', name: 'Работа с разными порядками чисел'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/secondchapter/', {
        params: {
          numberTheme: 32,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[31].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[31].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[31].task.answer

          window.frontendData.language.chapters[1].listThemes[31].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[31].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[31].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[31].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[31].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[1].listThemes[31].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[31].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-9-theme');

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