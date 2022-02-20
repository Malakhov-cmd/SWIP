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
          Статические внутренние классы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Иногда внутренний класс требуется лишь для того, чтобы скрыть его в другом
              классе, тогда как ссылка на объект внешнего класса не нужна. Подавить формирование такой ссылки можно,
              объявив внутренний класс статическим (т.е. static).
            </p>

            <p>
              Допустим, в массиве требуется найти максимальное и минимальное числа. Конечно, для этого можно было бы
              написать два метода: один — для нахождения максимального числа, а другой — для нахождения минимального
              числа. Но при вызове
              обоих методов массив просматривается дважды. Было бы намного эффективнее просматривать массив только один
              раз, одновременно определяя в нем как максимальное, так и минимальное число следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> min = Double.MAX_VALUE;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> max = Double.MIN_VALUE;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">double</span> v : values)
        {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (min &gt; v) min = v;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (max &lt; v) max = v;
        }</pre>
            <p>
              Но в таком случае метод должен возвращать два значения. Сделать это можно,
              определив класс Pair с двумя полями для хранения числовых значений:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span>
    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">double</span> first;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">double</span> second;
        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">(<span
            class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> f, <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">double</span> s)</span>
        </span>{
            first = f;
            second = s;
        }
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">double</span> getFirstO { <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> first; }
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">double</span> getSecondO { <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> second; }
    }</pre>
            <p>
              Тогда метод minmax () сможет возвратить объект типа Pair следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">ArrayAlg</span> </span>{
        <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
            class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Pair <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">minmax</span><span
            class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                        style="color: rgb(107, 107, 184);">double</span>[] values)</span> </span>{
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">new</span> Pair(min, max);
        }
    }</pre>
            <p>
              Таким образом, для получения максимального и минимального числовых значений достаточно вызвать методы
              getFirst () и getSecond ():

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair р = ArrayAlg.ininmax (d);
System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"min = "</span> + p .getFirst());
System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"max = "</span> + p.getSecond());</pre>
            <p>
              Разумеется, имя Pair слишком широко распространено, и при выполнении крупного проекта у другого
              программиста может возникнуть такая же блестящая идея,
              вот только класс Pair у него будет содержать не числовые, а строковые поля. Это
              вполне вероятное затруднение можно разрешить, сделав класс Pair внутренним
              и определенным в классе ArrayAlg. Тогда подлинным именем этого класса будет не
              Pair, a ArrayAlg. Pair:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ArrayAlg.Pair p = ArrayAlg .minmax (d) ;</pre>
            <p>
              Но, в отличие от внутренних классов, применявшихся в предыдущих примерах,
              ссылка на другой объект в классе Pair не требуется. Ее можно подавить, объявив внутренний класс
              статическим
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">ArrayAlg</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span> </span>{
        }
    }</pre>
            <p>
              Разумеется, только внутренние классы можно объявлять статическими. Статический внутренний класс ничем не
              отличается от любого другого внутреннего класса, за
              исключением того, что его объект не содержит ссылку на создавший его объект внешнего класса. В данном
              примере следует применять статический внутренний класс, поскольку объект внутреннего класса создается в
              теле статического метода, как показано
              ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Pair <span class="hljs-title"
                                                                                                 style="color: rgb(37, 127, 173);">minmax</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">double</span>[] d)</span>
</span>{
     <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">new</span> Pair(min, max);
}</pre>
            <p>
              Если бы класс Pair не был объявлен статическим, компилятор сообщил бы, что
              при инициализации объекта внутреннего класса объект типа ArrayAlg недоступен.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> staticInnerClass;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the use of static inner classes.
 * <span class="hljs-doctag">@version</span> 1.02 2015-05-12
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">StaticInnerClassTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>[] d = <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">new</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>[<span class="hljs-number"
                                                                                              style="color: rgb(147, 92, 37);">20</span>];
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; d.length; i++)
         d[i] = <span class="hljs-number" style="color: rgb(147, 92, 37);">100</span> * Math.random();
      ArrayAlg.Pair p = ArrayAlg.minmax(d);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"min = "</span> + p.getFirst());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"max = "</span> + p.getSecond());
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">ArrayAlg</span>
</span>{
   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * A pair of floating-point numbers
    */</span>
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">double</span> first;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">double</span> second;

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
       * Constructs a pair from two floating-point numbers
       * <span class="hljs-doctag">@param</span> f the first number
       * <span class="hljs-doctag">@param</span> s the second number
       */</span>
      <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
          class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">(<span
          class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> f, <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">double</span> s)</span>
      </span>{
         first = f;
         second = s;
      }

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
       * Returns the first number of the pair
       * <span class="hljs-doctag">@return</span> the first number
       */</span>
      <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
          class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                      style="color: rgb(37, 127, 173);">getFirst</span><span
          class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
      </span>{
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> first;
      }

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
       * Returns the second number of the pair
       * <span class="hljs-doctag">@return</span> the second number
       */</span>
      <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
          class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                      style="color: rgb(37, 127, 173);">getSecond</span><span
          class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
      </span>{
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> second;
      }
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Computes both the minimum and the maximum of an array
    * <span class="hljs-doctag">@param</span> values an array of floating-point numbers
    * <span class="hljs-doctag">@return</span> a pair whose first element is the minimum and whose second element
    * is the maximum
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Pair <span class="hljs-title"
                                                                                        style="color: rgb(37, 127, 173);">minmax</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">double</span>[] values)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> min = Double.POSITIVE_INFINITY;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> max = Double.NEGATIVE_INFINITY;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> v : values)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (min &gt; v) min = v;
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (max &lt; v) max = v;
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">new</span> Pair(min, max);
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
        List<Task> taskList = new ArrayList<>(
                Arrays.asList(
                        new Task("2 + 2", "4"),
                        new Task("3 * 4", "12")
                )
        );

        System.out.println(taskList.get(1).answer);
    }

    static class Task {
        private String question;
        private String answer;

        public Task(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
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
  name: "StaticInnerClasses",
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

      selected: 'Exception',
      options: [
        {item: 'Exception', name: 'Exception'},
        {item: '4', name: '4'},
        {item: '8 ', name: '8 '},
        {
          item: '12',
          name: '12'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 10,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[9].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[9].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[9].task.answer

          window.frontendData.language.chapters[4].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[9].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[9].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[9].task.answer
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
        List<Task> taskList = new ArrayList<>(
                Arrays.asList(
                        new Task("2 + 2", "4"),
                        new Task("3 * 4", "12")
                )
        );

        System.out.println(taskList.get(1).answer);
    }

    static class Task {
        private String question;
        private String answer;

        public Task(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
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

    let themeToClose = document.getElementById('java-5-chapter-3-theme-4-subtheme');

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