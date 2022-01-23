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
          Определенные циклы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Цикл for является весьма распространенной языковой конструкцией. В нем количество повторений находится
              под управлением переменной, выполняющей роль
              счетчика и обновляемой на каждом шаге цикла. В приведенном ниже примере цикла
              for на экран выводятся числа от 1 до 10
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; i &lt;= <span class="hljs-number"
                                                                                               style="color: rgb(255, 115, 253);">10</span>; i++)
    System.out.println(i);</pre>
            <p>
              В первой части оператора for обычно выполняется инициализация счетчика, во
              второй его части задается условие выполнения тела цикла, а в третьей — порядок
              обновления счетчика.

            </p>
            <p>
              Несмотря на то что в Java, как и в C++, отдельными частями оператора цикла for
              могут быть практически любые выражения, существуют неписаные правила, согласно которым все три части
              оператора цикла for должны только инициализировать,
              проверять и обновлять один и тот же счетчик. Если не придерживаться этих правил,
              полученный код станет неудобным, а то и вообще непригодным для чтения.
            </p>
            <p>
              Подобные правила не слишком сковывают инициативу программирующего.
              Даже если придерживаться их, с помощью оператора for можно сделать немало,
              например, реализовать цикл с обратным отсчетом шагов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">    <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span>( <span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">10</span>; i &gt;<span class="hljs-number"
                                                                                              style="color: rgb(255, 115, 253);">0</span>; i— )
    {
        System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Counting down . . . "</span> + i);
        System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Blastoff!"</span>);
    }</pre>
            <p>
              При объявлении переменной в первой части оператора fo r ее область действия
              простирается до конца тела цикла, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; i &lt;= <span class="hljs-number"
                                                                                               style="color: rgb(255, 115, 253);">10</span>; i++) {
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">//...</span>
        }
        <span class="hljs-comment"
              style="color: rgb(124, 124, 124);">// здесь переменная i уже не определена  </span></pre>
            <p>
              В частности, если переменная определена в операторе цикла for, ее нельзя использовать за пределами этого
              цикла. Следовательно, если требуется использовать
              конечное значение счетчика за пределами цикла for, соответствующую переменную
              следует объявить до начала цикла! Ниже показано, как это делается.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> i;
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (i = <span class="hljs-number"
                                                                                            style="color: rgb(255, 115, 253);">1</span>; i &lt;= <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">10</span>; i++)
        {
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">//..</span>
        }
        <span class="hljs-comment" style="color: rgb(124, 124, 124);">// здесь переменная i по-прежнему доступна</span>
   </pre>
            <p>
              С другой стороны, можно объявлять переменные, имеющие одинаковое имя
              в разных циклах for, как следует из приведенного ниже примера кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; i &lt;= <span class="hljs-number"
                                                                                               style="color: rgb(255, 115, 253);">10</span>; i++) {
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">//...</span>
        }

        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                        style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">11</span>; i &lt;= <span class="hljs-number"
                                                                                                  style="color: rgb(255, 115, 253);">20</span>; i++)
            <span class="hljs-comment"
                  style="color: rgb(124, 124, 124);">// переопределение переменной i допустимо</span>
        {
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">//...</span>
        }</pre>
            <p>
              Цикл fo r является сокращенным и более удобным вариантом цикла while. Например, следующий фрагмент
              кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">10</span>; i &gt; <span class="hljs-number"
                                                                                               style="color: rgb(255, 115, 253);">0</span>; i--)
            System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Counting down . . . "</span> + i);</pre>
            <p>
              можно переписать так, как показано ниже. И оба фрагмента кода будут равнозначны.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> i = <span class="hljs-number"
                                                                                             style="color: rgb(255, 115, 253);">10</span>;
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (i &gt; <span class="hljs-number"
                                                                                                 style="color: rgb(255, 115, 253);">0</span>)
        {
            System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Counting down . . . "</span> + i) ;
            i--;
        }</pre>
            <p>
              ипичный пример применения оператора цикла fo r непосредственно в коде
              приведен в листинге 3.5. Данная программа вычисляет вероятность выигрыша в лотерее. Так, если нужно
              угадать б номеров из 50, количество возможных вариантов будет
              равно (50x49x48x47x46x45)/ (1х2хЗх4х5хб), поэтому шансы на выигрыш равны 1
              из 15890700
            </p>
            <p>
              Листинг3.5. Исходный код из файла LotteryOdds/LotteryOdds.java
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(124, 124, 124);">/**
 * This program demonstrates a &lt;code&gt;for&lt;/code&gt; loop.
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@version</span> 1.20 2004-02-10
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(255, 255, 182);">LotteryOdds</span>
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

      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> lotteryOdds = <span class="hljs-number"
                                                                                                   style="color: rgb(255, 115, 253);">1</span>;
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; i &lt;= k; i++)
         lotteryOdds = lotteryOdds * (n - i + <span class="hljs-number" style="color: rgb(255, 115, 253);">1</span>) / i;

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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
public class Main {
    public static void main(String[] args) {
        int money = 100;
        int rndWasteMoneyCounter = 0;

        for (int i = 0; i < money; i++) {
            money-= new Random().nextInt(20);
            rndWasteMoneyCounter++;
        }

        System.out.println(rndWasteMoneyCounter);
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
          Ваш ответ: at least 5
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
  name: "Cycle",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Five',
      options: [
        {item: 'Five', name: 'at least 5'},
        {item: 'Ten', name: 'at least 10'},
        {item: 'Exception', name: 'Невозможно предсказать'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 29,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[28].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[28].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[28].task.answer

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          this.$toasted.error("Неверный ответ", {
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
    if (window.frontendData.language.chapters[1].listThemes[28].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[28].task.answer
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
        `public class Main {
    public static void main(String[] args) {
        int money = 100;
        int rndWasteMoneyCounter = 0;

        for (int i = 0; i < money; i++) {
            money-= new Random().nextInt(20);
            rndWasteMoneyCounter++;
        }

        System.out.println(rndWasteMoneyCounter);
    }
}
      `)

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-2-chapter-8-them-4-subtheme');

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