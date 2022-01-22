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
          Неопределенные циклы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Цикл while обеспечивает выполнение выражения (или группы операторов, составляющих блок) до тех пор, пока
              условие истинно, т.е. оно имеет логическое значение true. Ниже приведена общая форма объявления этого
              цикла.
            </p>
            <p>
              while (условие) оператор
            </p>
            <p>
              Цикл while не будет выполнен ни разу, если его условие изначально ложно,
              т.е. имеет логическое значение fa ls e
            </p>
            <p>
              Приведен пример программы, подсчитывающей, сколько лет нужно вносить деньги на счет, чтобы
              накопить определенную сумму на заслуженный отдых. Считается, что каждый год вносится одна и та же сумма и
              процентная ставка
              не меняется. В теле цикла из данного примера увеличивается счетчик и обновляется
              сумма, накопленная на текущий момент. И так происходит до тех пор, пока итоговая
              сумма не превысит заданную величину:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span>(balance &lt; goal)
        {
            balance += payment;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = balance * interestRate / <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
            balance += interest;
            years++;
        }
        System.out.println(years + <span class="hljs-string" style="color: rgb(168, 255, 96);">" years.”);</span></pre>
            <p>
              Условие цикла while проверяется в самом начале. Следовательно, возможна ситуация, когда код, содержащийся
              в блоке, образующем тело цикла, вообще не будет
              выполнен. Если же требуется, чтобы блок выполнялся хотя бы один раз, проверку
              условия следует перенести в конец. Это можно сделать с помощью цикла do-while,
              общая форма объявления которого приведена ниже,
            </p>
            <p>
              do оператор while (условие);
            </p>
            <p>
              Условие проверяется лишь после выполнения оператора, а зачастую блока операторов, в теле данного цикла.
              Затем цикл повторяется, снова проверяет условие и т.д.
              Например, программа, исходный код которой приведен, вычисляет
              новый остаток на пенсионном счету работника, а затем запрашивает, не собирается
              ли он на заслуженный отдых:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        do
        {
            balance += payment;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = balance * interestRate / <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
            balance += interest;
            year++;
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">// вывести текущий остаток на счету</span>
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">// запросить готовность работника выйти на пенсию и получить ответ</span>
        }
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (input.equals(<span
                  class="hljs-string" style="color: rgb(168, 255, 96);">"N"</span>) );</pre>
            <p>
              Цикл повторяется до тех пор, пока не будет получен положительный ответ "Y"
              . Эта программа служит характерным примером применения циклов,
              которые нужно выполнить хотя бы один раз, поскольку ее пользователь должен увидеть остаток на своем
              пенсионном счету, прежде чем решать, хватит ли ему средств
              на жизнь после выхода на пенсию.
            </p>
            <p>
              Листинг3.3. Исходный код из файла Retirement/Retirement.java
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(124, 124, 124);">/**
 * This program demonstrates a &lt;code&gt;while&lt;/code&gt; loop.
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@version</span> 1.20 2004-02-10
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(255, 255, 182);">Retirement</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
       class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(150, 203, 254);">void</span> <span
       class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span>
   </span>{
      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// read inputs</span>
      Scanner in = <span class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"How much money do you need to retire? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> goal = in.nextDouble();

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"How much money will you contribute every year? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> payment = in.nextDouble();

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Interest rate in %: "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interestRate = in.nextDouble();

      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> balance = <span class="hljs-number"
                                                                                                  style="color: rgb(255, 115, 253);">0</span>;
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> years = <span class="hljs-number"
                                                                                             style="color: rgb(255, 115, 253);">0</span>;

      <span class="hljs-comment"
            style="color: rgb(124, 124, 124);">// update account balance while goal isn't reached</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (balance &lt; goal)
      {
         <span class="hljs-comment" style="color: rgb(124, 124, 124);">// add this year's payment and interest</span>
         balance += payment;
         <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = balance * interestRate / <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
         balance += interest;
         years++;
      }

      System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"You can retire in "</span> + years + <span
                  class="hljs-string" style="color: rgb(168, 255, 96);">" years."</span>);
   }
}</pre>
            <p>
              Листинг 3.4. Исходный код из файла Retirement2/Retirement2.java
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(124, 124, 124);">/**
 * This program demonstrates a &lt;code&gt;do/while&lt;/code&gt; loop.
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@version</span> 1.20 2004-02-10
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(255, 255, 182);">Retirement2</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
       class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(150, 203, 254);">void</span> <span
       class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span>
   </span>{
      Scanner in = <span class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"How much money will you contribute every year? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> payment = in.nextDouble();

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Interest rate in %: "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interestRate = in.nextDouble();

      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> balance = <span class="hljs-number"
                                                                                                  style="color: rgb(255, 115, 253);">0</span>;
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> year = <span class="hljs-number"
                                                                                            style="color: rgb(255, 115, 253);">0</span>;

      String input;

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// update account balance while user isn't ready to retire</span>
      do
      {
         <span class="hljs-comment" style="color: rgb(124, 124, 124);">// add this year's payment and interest</span>
         balance += payment;
         <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = balance * interestRate / <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
         balance += interest;

         year++;

         <span class="hljs-comment" style="color: rgb(124, 124, 124);">// print current balance</span>
         System.out.printf(<span class="hljs-string" style="color: rgb(168, 255, 96);">"After year %d, your balance is %,.2f%n"</span>, year, balance);

         <span class="hljs-comment" style="color: rgb(124, 124, 124);">// ask if ready to retire and get input</span>
         System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Ready to retire? (Y/N) "</span>);
         input = in.next();
      }
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (input.equals(<span class="hljs-string"
                                                                                                     style="color: rgb(168, 255, 96);">"N"</span>));
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
        int money = 5;
        int spentTimes = 0;

        do {
            money-=1;
            spentTimes++;
        } while (money > 0);

        System.out.println(spentTimes);
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "UndefindedCycle",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Five',
      options: [
        {item: 'Five', name: '5'},
        {item: 'Zero', name: '0'},
        {item: 'Exception', name: 'Exception'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 28,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[27].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[27].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[27].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[27].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[27].task.answer
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
        int money = 5;
        int spentTimes = 0;

        do {
            money-=1;
            spentTimes++;
        } while (money > 0);

        System.out.println(spentTimes);
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