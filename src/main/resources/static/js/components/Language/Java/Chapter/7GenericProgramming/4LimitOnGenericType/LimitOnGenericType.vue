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
          Ограничения на переменные типа
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Иногда класс или метод нуждается в наложении ограничений на переменные
              типа. Приведем характерный тому пример, в котором требуется вычислить наименьший элемент массива
              следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">ArrayAlg</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">static</span> &lt;T&gt; <span
                  class="hljs-function">T <span class="hljs-title" style="color: rgb(37, 127, 173);">min</span><span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(T[] а)</span> <span class="hljs-comment"
                                                                                            style="color: rgb(113, 149, 168);">// почти верно </span>
    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (а == <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">null</span> || a.length == <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>) <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>;
        Т smallest = а[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>];
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>; i &lt; a.length; i++)
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (smallest.compareTo(a[i]) &gt; <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>) smallest = a[i];
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> smallest;
    }
}</pre>

            <p>
              Но здесь возникает затруднение. Обратите внимание на тело метода min (). Переменная smallest относится к
              типу Т, а это означает, что она может быть объектом
              произвольного класса. Но откуда известно, имеется ли метод compareTo () в том классе, к которому
              относится тип Т?

            </p>

            <p>
              Выход из этого затруднительного положения состоит в том, чтобы наложить
              ограничение на тип Т и вместо него подставлять только класс, реализующий
              Comparable — стандартный интерфейс с единственным методом сошрагеТо (). Для
              этого достаточно наложить ограничение на переменную типа Т следующим образом:

            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> &lt;Т extends Comparable&gt; Т min(T[] а) . . .</pre>

            <p>
              В действительности интерфейс Comparable сам является обобщенным. Но мы не
              будем пока что принимать во внимание это обстоятельство и соответствующие предупреждения компилятора. В
              разделе 8.8 далее в этой главе мы обсудим, как правильно пользоваться параметрами типа вместе с
              интерфейсом Comparable.
            </p>

            <p>
              Теперь обобщенный метод min () может вызываться только с массивами классов,
              реализующих интерфейс Comparable, в том числе String, Date и т.п. А вызов min ()
              с массивом типа Rectangle приведет к ошибке во время компиляции, поскольку
              класс Rectangle не реализует интерфейс Comparable.
            </p>

            <p>
              Вас может удивить, почему здесь используется ключевое слово extends вместо
              implements, ведь Comparable — это интерфейс? Так, обозначение

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">&lt;Т extends ограничивающий_тип&gt;</pre>
            <p>
              означает, что тип Т должен быть подтипом ограничивающего типа, причем к типу Т
              и ограничивающему типу может относиться как интерфейс, так и класс. Ключевое
              слово extends выбрано потому, что это вполне благоразумное приближение понятия подтипа, и создатели Java
              не сочли нужным вместо этого вводить в язык новое
              ключевое слово.

            </p>
            <p>
              Переменная типа или подстановка может иметь несколько ограничений, как показано в приведенном ниже
              примере кода. Ограничивающие типы разделяются знаком &, потому что запятые служат для разделения
              переменных типа.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Т extends Comparable &amp; Serializable</pre>
            <p>
              Как и в механизме наследования в Java, у интерфейсов может быть сколько угодно
              супертипов, но только один из ограничивающих типов может быть классом. Если
              для ограничения служит класс, он должен быть первым в списке накладываемых
              ограничений.

            </p>
            <p>

              В следующем примере программы из листинга 8.2 метод minmaxO переделан
              на обобщенный. В этом методе вычисляется минимальное и максимальное значения
              в обобщенном массиве и возвращается объект обобщенного типа Pair< T >.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> pair2;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * <span class="hljs-doctag">@version</span> 1.02 2015-06-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">PairTest2</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      LocalDate[] birthdays =
         {
            LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1906</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">9</span>), <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// G. Hopper</span>
            LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1815</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">10</span>), <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// A. Lovelace</span>
            LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1903</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">3</span>), <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// J. von Neumann</span>
            LocalDate.of(<span class="hljs-number" style="color: rgb(147, 92, 37);">1910</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">6</span>, <span class="hljs-number"
                                                                                       style="color: rgb(147, 92, 37);">22</span>), <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// K. Zuse</span>
         };
      Pair&lt;LocalDate&gt; mm = ArrayAlg.minmax(birthdays);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"min = "</span> + mm.getFirst());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"max = "</span> + mm.getSecond());
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">ArrayAlg</span>
</span>{
   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
      Gets the minimum and maximum of an array of objects of type T.
      <span class="hljs-doctag">@param</span> a an array of objects of type T
      <span class="hljs-doctag">@return</span> a pair with the min and max value, or null if a is
      null or empty
   */</span>
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">static</span> &lt;T extends Comparable&gt; <span
                  class="hljs-function">Pair&lt;T&gt; <span class="hljs-title"
                                                            style="color: rgb(37, 127, 173);">minmax</span><span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(T[] a)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (a == <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">null</span> || a.length == <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>) <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>;
      T min = a[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>];
      T max = a[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>];
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>; i &lt; a.length; i++)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (min.compareTo(a[i]) &gt; <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>) min = a[i];
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (max.compareTo(a[i]) &lt; <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>) max = a[i];
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">new</span> Pair&lt;&gt;(min, max);
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
public class Test {
    public static void main(String[] args) {
        Task<Integer> taskInt = new Task<>("4 * 4", 16);
        Task<Double> taskDouble = new Task<>("3.3 * 3", 9.9);

        System.out.println(taskDouble.getAnswer());

    }
}

class Task<T extends Number> {
    private String question;
    private T answer;

    public Task(String question, T answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
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
  name: "LimitOnGenericType",
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

      selected: '4 * 4',
      options: [
        {item: '4 * 4', name: '4 * 4'},
        {item: 'UnderfindedTypeOfProperty', name: 'UnderfindedTypeOfProperty'},
        {item: '16', name: '16'},
        {item: '9.9', name: '9.9'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/seventhchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 11.1
              window.frontendData.language.chapters[6].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[3].task.answer

          window.frontendData.language.chapters[6].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[3].task.tryCount + ".", {
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
    }
  },
  mounted() {
    if (window.frontendData.language.chapters[6].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[3].task.answer
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
        `public class Test {
    public static void main(String[] args) {
        Task<Integer> taskInt = new Task<>("4 * 4", 16);
        Task<Double> taskDouble = new Task<>("3.3 * 3", 9.9);

        System.out.println(taskDouble.getAnswer());

    }
}

class Task<T extends Number> {
    private String question;
    private T answer;

    public Task(String question, T answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
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

    let themeToClose = document.getElementById('java-7-chapter-4-theme');

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