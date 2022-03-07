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
          Определение простого обобщенного класса
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Обобщенным называется класс с одной или несколькими переменными типа. В этой
              главе в качестве примера рассматривается простой обобщенный класс Pair. Этот класс
              выбран для примера потому, что он позволяет сосредоточить основное внимание на механизме обобщений, не
              вдаваясь в подробности сохранения данных. Ниже приведен исходный код обобщенного класса Pair.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Pair</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">T</span>&gt;
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> T first;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> T second;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">()</span> </span>{ first = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>; second = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>; }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">(T first, T second)</span>
    </span>{ <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.first = first; <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.second = second; }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> T <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getFirst</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">()</span> </span>{ <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> first; }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> T <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getSecond</span><span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">()</span> </span>{ <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> second; }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">setFirst</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(T newValue)</span> </span>{ first = newValue; }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">setSecond</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(T newValue)</span> </span>{ second = newValue; }
}</pre>

            <p>
              В классе Pair вводится переменная типа Т, заключенная в угловые скобки (О )
              после имени самого класса. У обобщенного класса может быть больше одной переменной типа. Например, класс
              Pair можно было бы определить с разными типами
              для первого и второго поля следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Pair</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">T</span>, <span class="hljs-title"
                                                                                     style="color: rgb(37, 127, 173);">U</span>&gt; </span>{ . . . }
</pre>
            <p>
              Переменные типа используются повсюду в определении класса для обозначения типов, возвращаемых методами, а
              также типов полей и локальных переменных.
              Ниже приведен пример объявления переменной типа.

            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Т first; <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// использовать переменную типа</span>
</pre>

            <p>
              Экземпляр обобщенного типа создается путем подстановки имени типа вместо переменной типа следующим
              образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;String&gt;</pre>
            <p>
              Результат такой подстановки следует рассматривать как обычный класс с конструкторами:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;String&gt;()
Pair&lt;String&gt;(String, String)</pre>
            <p>
              и методами:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function">String <span class="hljs-title"
                                                   style="color: rgb(37, 127, 173);">getFirst</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
String <span class="hljs-title" style="color: rgb(37, 127, 173);">getSecond</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">setFirst</span><span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(String)</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">setSecond</span><span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(String)</span></span></pre>
            <p>
              Иными словами, обобщенный класс действует как фабрика обычных классов.
              В примере программы из листинга 8.1 применяется класс Pair. В статическом методе
              mi птах () осуществляется перебор элементов массива с одновременным вычислением
              минимального и максимального значений. Для возврата обоих значений используется объект типа Pair.
              Напомним, что в методе compareTo () сравниваются две строки и возвращается нулевое значение, если
              символьные строки одинаковы; отрицательное числовое значение — если первая символьная строка следует
              прежде второй
              в лексикографическом порядке; а иначе — положительное числовое значение.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> pair1;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * <span class="hljs-doctag">@version</span> 1.01 2012-01-26
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">PairTest1</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      String[] words = { <span class="hljs-string" style="color: rgb(86, 140, 59);">"Mary"</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"had"</span>, <span class="hljs-string"
                                                                                           style="color: rgb(86, 140, 59);">"a"</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"little"</span>, <span class="hljs-string"
                                                                                              style="color: rgb(86, 140, 59);">"lamb"</span> };
      Pair&lt;String&gt; mm = ArrayAlg.minmax(words);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"min = "</span> + mm.getFirst());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"max = "</span> + mm.getSecond());
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">ArrayAlg</span>
</span>{
   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Gets the minimum and maximum of an array of strings.
    * <span class="hljs-doctag">@param</span> a an array of strings
    * <span class="hljs-doctag">@return</span> a pair with the min and max value, or null if a is null or empty
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Pair&lt;String&gt; <span class="hljs-title"
                                                                                                      style="color: rgb(37, 127, 173);">minmax</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(String[] a)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (a == <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">null</span> || a.length == <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>) <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>;
      String min = a[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>];
      String max = a[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>];
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
        Task<Integer> task = new Task<>("4 * 4", 16);

        System.out.println(task.getAnswer());
    }
}

class Task<T> {
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
  name: "DeclarationSimpleGenericClass",
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

      selected: 'CastException',
      options: [
        {item: 'CastException', name: 'CastException'},
        {item: '16', name: '16'},
        {item: '12', name: '12'},
        {item: 'UnderfindedTypeOfProperty', name: 'UnderfindedTypeOfProperty'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/seventhchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 11.1
              window.frontendData.language.chapters[6].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[1].task.answer

          window.frontendData.language.chapters[6].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[1].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[6].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[1].task.answer
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
        Task<Integer> task = new Task<>("4 * 4", 16);

        System.out.println(task.getAnswer());
    }
}

class Task<T> {
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

    let themeToClose = document.getElementById('java-7-chapter-2-theme');

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