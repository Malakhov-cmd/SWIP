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
          Операторы прерывания логики управления программой
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Несмотря на то что создатели Java сохранили зарезервированное слово goto, они
              решили не включать его в состав языка. В принципе применение операторов goto
              считается признаком плохого стиля программирования. Некоторые программисты
              считают, что борьба с использованием оператора goto ведется недостаточно активно
              (см., например, известную статью Дональда Кнута "Структурное программирование
              с помощью операторов goto" (Structured Programming with goto statements; http: / /
              cs. sjsu.edu/~mak/CS185C/KnuthStructuredProgrammingGoTo.pdf). Они считают,
              что применение операторов goto может приводить к ошибкам. Но в некоторых случаях нужно выполнять
              преждевременный выход из цикла. Создатели Java согласились с их аргументами и даже добавили в язык новый
              оператор для поддержки такого стиля программирования. Им стал оператор break с меткой.

            </p>
            <p>
              Рассмотрим сначала обычный оператор break без метки. Для выхода из цикла
              можно применять тот же самый оператор break, что и для выхода из оператора
              switch. Ниже приведен пример применения оператора break без метки
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (years &lt;= <span
                class="hljs-number" style="color: rgb(255, 115, 253);">100</span>)
        {
            balance += payment;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = balance * interestRate / <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
            balance += interest;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (balance &gt;= goal) <span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span>;
            years++;
        }</pre>
            <p>
              В данном фрагменте кода выход из цикла осуществляется при выполнении одного
              из двух условий: years > 100 в начале цикла или balance >= goal в теле цикла. Разумеется, то же самое
              значение переменной years можно было бы вычислить и без
              применения оператора break, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (years &lt;= <span
                class="hljs-number" style="color: rgb(255, 115, 253);">100</span> &amp;&amp; balance &lt; goal)
        {
            balance += payment;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">double</span> interest = balance * interestRate / <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">100</span>;
            balance += interest;
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (balance &lt; goal)
                years++;
        }</pre>
            <p>
              Следует, однако, иметь в виду, что проверка условия balance < goal в данном варианте кода повторяется
              дважды. Этого позволяет избежать оператор break.
            </p>
            <p>
              В отличие от C++, в Java поддерживается оператор break с меткой, обеспечивающий
              выход из вложенных циклов. С его помощью можно организовать прерывание глубоко
              вложенных циклов при нарушении логики управления программой. А задавать дополнительные условия для
              проверки каждого вложенного цикла попросту неудобно.
            </p>
            <p>
              Ниже приведен пример, демонстрирующий применение оператора break с меткой
              в коде. Следует иметь в виду, что метка должна предшествовать тому внешнему циклу,
              из которого требуется выйти. Кроме того, метка должна оканчиваться двоеточием.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        Scanner in = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> n;
        read_data:
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (...) <span class="hljs-comment"
                                                                                               style="color: rgb(124, 124, 124);">// Этот цикл помечен меткой</span>
        {
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (...) <span class="hljs-comment"
                                                                                                 style="color: rgb(124, 124, 124);">// Этот цикл не помечен</span>
            {
                System.out.print(<span class="hljs-string"
                                       style="color: rgb(168, 255, 96);">"Enter a number &gt;= 0: "</span>);
                        n = in.nextlnt();
                <span class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (n &lt; <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>) <span class="hljs-comment"
                                                                                         style="color: rgb(124, 124, 124);">// условие для прерывания цикла</span>
                    <span class="hljs-keyword" style="color: rgb(150, 203, 254);">break</span> read_data;
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">// прервать цикл</span>
            }
        }
        <span class="hljs-comment" style="color: rgb(124, 124, 124);">// этот оператор выполняется сразу же после</span>
        <span class="hljs-comment" style="color: rgb(124, 124, 124);">// оператора breakс меткой</span>
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (п &lt; <span class="hljs-number"
                                                                                              style="color: rgb(255, 115, 253);">0</span>) <span
                  class="hljs-comment"
                  style="color: rgb(124, 124, 124);">// поверить наличие недопустимой ситуации</span>
        {
            <span class="hljs-comment"
                  style="color: rgb(124, 124, 124);">// принять меры против недопустимой ситуации</span>
        } <span class="hljs-keyword" style="color: rgb(150, 203, 254);">else</span> {
            <span class="hljs-comment" style="color: rgb(124, 124, 124);">// выполнить действия при нормальном ходе выполнения программы</span>
        }</pre>
            <p>
              Если было введено неверное число, оператор break с меткой выполнит переход в конец помеченного блока. В
              этом случае необходимо проверить, нормально ли осуществлен выход из цикла, или он произошел в результате
              выполнения оператора break.
            </p>
            <p>
              Существует также оператор continue, который, подобно оператору break, прерывает нормальный ход выполнения
              программы. Оператор continue передает
              управление в начало текущего вложенного цикла. Ниже приведен характерный пример применения данного
              оператора.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        Scanner in = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">while</span> (sum &lt; goal)
        {
            System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Enter a number: "</span>);
            n = in.nextlnt();
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (n &lt; <span class="hljs-number"
                                                                                                  style="color: rgb(255, 115, 253);">0</span>) c o n tin u e ;
            sum += n; <span class="hljs-comment"
                            style="color: rgb(124, 124, 124);">// не выполняется, если n &lt; 0</span>
        }</pre>
            <p>
              Если n < 0, то оператор continue выполняет переход в начало цикла, пропуская
              оставшуюся часть текущего шага цикла. Если же оператор continue применяется
              в цикле for, он передает управление оператору увеличения счетчика цикла. В качестве примера рассмотрим
              следующий цикл:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (count = <span class="hljs-number"
                                                                                                  style="color: rgb(255, 115, 253);">1</span>; count &lt;= <span
                class="hljs-number" style="color: rgb(255, 115, 253);">100</span>; count++)
        {
            System.out.print(<span class="hljs-string"
                                   style="color: rgb(168, 255, 96);">"Enter a number, -1 to quit: "</span>);
            n = in.nextlnt();
            <span class="hljs-keyword" style="color: rgb(150, 203, 254);">if</span> (n &lt; <span class="hljs-number"
                                                                                                  style="color: rgb(255, 115, 253);">0</span>) c o n tin u e ;
            sum += n; <span class="hljs-comment"
                            style="color: rgb(124, 124, 124);">//не выполняется, если n &lt; О</span>
        }</pre>
            <p>
              Если п < 0, оператор continue осуществит переход к оператору count++. В языке
              Java имеется также оператор continue с меткой, передающий управление заголовку
              оператора цикла, помеченного соответствующей меткой
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
public class Main {
    public static void main(String[] args) {
        int wanted = 6;
        int stepCounter = 0;

        for (int i = 0; i < 10; i++) {
            stepCounter = i;
            if (i == wanted) break;
        }
        System.out.println(stepCounter);
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
  name: "BreaksOperations",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Ten',
      options: [
        {item: 'Ten', name: '10'},
        {item: 'Zero', name: '0'},
        {item: 'Five', name: '5'},
        {item: 'Six', name: '6'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 31,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[30].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[30].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[30].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[30].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[30].task.answer
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
        int wanted = 6;
        int stepCounter = 0;

        for (int i = 0; i < 10; i++) {
            stepCounter = i;
            if (i == wanted) break;
        }
        System.out.println(stepCounter);
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