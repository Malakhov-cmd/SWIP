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
          Многомерные массивы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Для доступа к элементам многомерного массива применяется несколько индексов.
              Такие массивы служат для хранения таблиц и более сложных упорядоченных структур данных. Если вы не
              собираетесь пользоваться многомерными массивами в своей
              практической деятельности, можете смело пропустить этот раздел
            </p>
            <p>
              Массивом нельзя пользоваться до тех пор, пока он не инициализирован с помощью операции new. В данном
              случае инициализация двумерного массива осуществляется следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">balances = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(150, 203, 254);">double</span>[NYEARS][NRATES];
            </pre>
            <p>
              В других случаях, когда элементы массива известны заранее, можно воспользоваться сокращенной записью для
              его инициализации, не прибегая к операции new.
              Ниже приведен соответствующий тому пример.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[][] magicSquare =
                {
                        {<span class="hljs-number" style="color: rgb(255, 115, 253);">16</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">3</span>, <span class="hljs-number"
                                                                                         style="color: rgb(255, 115, 253);">2</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">13</span>},
                        {<span class="hljs-number" style="color: rgb(255, 115, 253);">5</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">10</span>, <span class="hljs-number"
                                                                                          style="color: rgb(255, 115, 253);">11</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">8</span>},
                        {<span class="hljs-number" style="color: rgb(255, 115, 253);">9</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">6</span>, <span class="hljs-number"
                                                                                         style="color: rgb(255, 115, 253);">7</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">12</span>},
                        {<span class="hljs-number" style="color: rgb(255, 115, 253);">4</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">15</span>, <span class="hljs-number"
                                                                                          style="color: rgb(255, 115, 253);">14</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1</span>}
                };
            </pre>
            <p>
              После инициализации массива к его отдельным элементам можно обращаться,
              используя две пары квадратных скобок, например balances [i] [ j ].
            </p>
            <p>
              В качестве примера рассмотрим программу, сохраняющую процентные ставки
              в одномерном массиве interest, а результаты подсчета остатка на счету ежегодно
              по каждой процентной ставке — в двумерном массиве balances. Сначала первая
              строка массива инициализируется исходной суммой следущим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> j = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; j &lt; balances[<span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>].length; j++)
     balances[<span class="hljs-number" style="color: rgb(255, 115, 253);">0</span>][j] = <span class="hljs-number"
                                                                                                style="color: rgb(255, 115, 253);">10000</span>;
            </pre>
            <p>
              Затем подсчитывается содержимое остальных строк, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; i &lt; balances.length; i++)
        {
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                            style="color: rgb(150, 203, 254);">int</span> j = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; j &lt; balances[i].length; j++)
            {
                <span class="hljs-keyword"
                      style="color: rgb(150, 203, 254);">double</span> oldBalance = balances(i - <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1</span>] [j];
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = . . .;
                balances[i][j] = oldBalance + interest;
            }
        }</pre>
            <p>
              Листинг 3.8.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-comment" style="color: rgb(124, 124, 124);">/**
 * This program shows how to store tabular data in a 2D array.
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@version</span> 1.40 2004-02-10
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(255, 255, 182);">CompoundInterest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
       class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(150, 203, 254);">void</span> <span
       class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">final</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(150, 203, 254);">double</span> STARTRATE = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">10</span>;
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">final</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(150, 203, 254);">int</span> NRATES = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">6</span>;
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">final</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(150, 203, 254);">int</span> NYEARS = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">10</span>;

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// set interest rates to 10 . . . 15%</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span>[] interestRate = <span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(150, 203, 254);">double</span>[NRATES];
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> j = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; j &lt; interestRate.length; j++)
         interestRate[j] = (STARTRATE + j) / <span class="hljs-number" style="color: rgb(255, 115, 253);">100.0</span>;

      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span>[][] balances = <span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(150, 203, 254);">double</span>[NYEARS][NRATES];

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// set initial balances to 10000</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> j = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; j &lt; balances[<span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>].length; j++)
         balances[<span class="hljs-number" style="color: rgb(255, 115, 253);">0</span>][j] = <span class="hljs-number"
                                                                                                    style="color: rgb(255, 115, 253);">10000</span>;

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// compute interest for future years</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1</span>; i &lt; balances.length; i++)
      {
         <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                         style="color: rgb(150, 203, 254);">int</span> j = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; j &lt; balances[i].length; j++)
         {
            <span class="hljs-comment"
                  style="color: rgb(124, 124, 124);">// get last year's balances from previous row</span>
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> oldBalance = balances[i - <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1</span>][j];

            <span class="hljs-comment" style="color: rgb(124, 124, 124);">// compute interest</span>
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = oldBalance * interestRate[j];

            <span class="hljs-comment" style="color: rgb(124, 124, 124);">// compute this year's balances</span>
            balances[i][j] = oldBalance + interest;
         }
      }

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// print one row of interest rates</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> j = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; j &lt; interestRate.length; j++)
         System.out.printf(<span class="hljs-string" style="color: rgb(168, 255, 96);">"%9.0f%%"</span>, <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">100</span> * interestRate[j]);

      System.out.println();

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// print balance table</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">double</span>[] row : balances)
      {
         <span class="hljs-comment" style="color: rgb(124, 124, 124);">// print table row</span>
         <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                         style="color: rgb(150, 203, 254);">double</span> b : row)
            System.out.printf(<span class="hljs-string" style="color: rgb(168, 255, 96);">"%10.2f"</span>, b);

         System.out.println();
      }
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
        int[][] a = {
          {1,2,3},
          {4,5,6},
          {7,8,9}
          };
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                temp+=a[i][j];
            }
        }

        System.out.println(temp);
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
  name: "MultidimensionalMassive",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Zero',
      options: [
        {item: 'Zero', name: '0'},
        {item: 'FiftyFive', name: '55'},
        {item: 'FortyFive', name: '45'},
        {item: 'Exception', name: 'Exception'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 37,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[36].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[36].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[36].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[36].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[36].task.answer
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
        int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                temp+=a[i][j];
            }
        }

        System.out.println(temp);
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
    //container.scrollTo(50, 5000)
  }
}
</script>

<style scoped>

</style>