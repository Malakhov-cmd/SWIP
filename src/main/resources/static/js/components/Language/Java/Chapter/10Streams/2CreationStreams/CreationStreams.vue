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
          Создание потока данных
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Как было пока:ыно выше, любую коллекцию можно преобразовать в поток
              данных методом s t ream () из интерфейса Co l l ection. Если же вместо коллекции имеется массив, то для
              этой цели служит метод S t ream. of ():
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        Stream&lt;String&gt; words = Stream.of(contents.split ( <span
                class="hljs-string" style="color: rgb(86, 140, 59);">" \\PL+"</span> ));
                <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Метод split() во звращает массив типа Striпg[]</span></pre>
            <p>
              У метода о f ( ) имеются аргументы переменной длины, и поэтому поток данных можно построить из любого
              количества аргументов, как показано
              ниже. А для созда11ия потока данных из части массива служит метод Arrays .
              s t ream ( array, from, to ) .
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        Stream&lt;String&gt; song = Stream.of( <span
                class="hljs-string" style="color: rgb(86, 140, 59);">" ge ntly"</span> , <span class="hljs-string"
                                                                                               style="color: rgb(86, 140, 59);">" down "</span> ,
                <span class="hljs-string" style="color: rgb(86, 140, 59);">" the 11"</span>, <span class="hljs-string"
                                                                                                   style="color: rgb(86, 140, 59);">"s t ream"</span> ); </pre>
            <p>
              Чтобы создап, поток данных без элементов, достаточно вызвать статический
              метод Str eam. empty ( ) следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        Stream&lt;String&gt; s1lence = Stream.empty ( ) ;
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Обобщенный тип &lt;String&gt; выводит ся а в тома тиче с ки ;</span>
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// с1то равнозначно вызо ву S t r eam . &lt;String &gt;empt y ()</span></pre>
            <p>
              Для создания бесконечных потоков данных в интерфейсе S t ream имеются два
              статических метода . В частности, метод gene rate ( ) принимает функцию без аргументов (а формально -
              объект функционального интерфейса Supplier
              < T > ) . Всякий раз, когда требуется потоковое :шачение, эта функция вызывается для получения данного
              значения. Например, поток постоянных значений можно получить
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">St ream&lt;String&gt; echos = <span
                class="hljs-function">Stream  <span class="hljs-title" style="color: rgb(37, 127, 173);">enerate</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( ()</span> -&gt; " Echo " )</span>;</pre>

            <p>
              а поток случайных чисел таким обра:юм:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">St ream&lt; Double&gt; randoms = Stream . <span
                class="hljs-function">generat <span class="hljs-title" style="color: rgb(37, 127, 173);">e</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( Math : : random )</span> </span>;</pre>
            <p>
              Для получения бесконечных последовательностей вроде О 1 2 3 . .. служит
              метод iterate 1). Этот метод принимает началыюе значение и функцию (а формально - объект функционал1,ного
              интерфейса Una ryOpe ra t.o r
              <T>) и повторно применяет функцию к предыдущему результату, как пока:ыно в следующем
                примере кода :
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Stream&lt;Biglnteger&gt; integers = Stream.iterate (
Biglnteger. ZERO, n - &gt; n . add (Biglnteger.ONE)); </pre>
            <p>
              Первым элементом такой последовательности является начальное значение Bigin tege r . ZERO; вторым ее
              элементом - :шачение, получаемое в результате вы:юва функции f ( see d ) , или 1 (как крупное
              целочисленное значение);
              следующим элементом - значение, получаемое в результате вызова функци и
              f ( f ( seed ) ) , или 2 и т.д., где seed - начальное значение.
            </p>

            <p>
              А для того чтобы создать конечный поток данных, достаточно ввести предикат, в котором указывается момент,
              когда должна быть завершена итерация, как
              выделено ниже полужирным. Поток данных завершится, как только предикат отклонит итеративно формируемое
              :шачение.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        var limit = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Biglnteger ( <span
                class="hljs-string" style="color: rgb(86, 140, 59);">" lOOOOOO O"</span>) ;
        Stream&lt;Biglnteger&gt; integers = Stream.iterate (
                Biglnteger.ZERO,
                n -&gt; n . compareTo ( limit) &lt; О,
                n -&gt; n.add ( Biglntege r . ONE));</pre>
            <p>
              И, наконец, метод Stream. o fNu llaЫe () создает очень короткий поток данных из объекта . Та кой поток
              имеет нулевую длину, если исходный объект оказывается пустым (nu l l), а иначе - единичную длину, т.е.
              011 содержит лиш1, данный объект. Этим методом удобнее всего пользоваться вместе с методом
              flatMap (), как демонстрируется в примере
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> streams;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.io.IOException;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.math.BigInteger;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.nio.charset.StandardCharsets;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.nio.file.Files;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.nio.file.Path;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.nio.file.Paths;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.List;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.regex.Pattern;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.stream.Collectors;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.stream.Stream;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">CreatingStreams</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">static</span> &lt;T&gt; <span
                  class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">show</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">(String title, Stream&lt;T&gt; stream)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> SIZE = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">10</span>;
      List&lt;T&gt; firstElements = stream
            .limit(SIZE + <span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>)
            .collect(Collectors.toList());
      System.out.print(title + <span class="hljs-string" style="color: rgb(86, 140, 59);">": "</span>);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; firstElements.size(); i++)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (i &gt; <span class="hljs-number"
                                                                                               style="color: rgb(147, 92, 37);">0</span>) System.out.print(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">", "</span>);
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (i &lt; SIZE) System.out.print(firstElements.get(i));
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span> System.out.print(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"..."</span>);
      }
      System.out.println();
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> IOException
   </span>{
      Path path = Paths.get(<span class="hljs-string" style="color: rgb(86, 140, 59);">"../gutenberg/alice30.txt"</span>);
      String contents = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> String(Files.readAllBytes(path),
            StandardCharsets.UTF_8);

      Stream&lt;String&gt; words = Stream.of(contents.split(<span class="hljs-string" style="color: rgb(86, 140, 59);">"\\PL+"</span>));
      show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"words"</span>, words);
      Stream&lt;String&gt; song = Stream.of(<span class="hljs-string" style="color: rgb(86, 140, 59);">"gently"</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"down"</span>, <span class="hljs-string"
                                                                                            style="color: rgb(86, 140, 59);">"the"</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"stream"</span>);
      show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"song"</span>, song);
      Stream&lt;String&gt; silence = Stream.empty();
      show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"silence"</span>, silence);

      Stream&lt;String&gt; echos = Stream.generate(() -&gt; <span class="hljs-string" style="color: rgb(86, 140, 59);">"Echo"</span>);
      show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"echos"</span>, echos);

      Stream&lt;Double&gt; randoms = Stream.generate(Math::random);
      show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"randoms"</span>, randoms);

      Stream&lt;BigInteger&gt; integers = Stream.iterate(BigInteger.ONE,
            n -&gt; n.add(BigInteger.ONE));
      show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"integers"</span>, integers);

      Stream&lt;String&gt; wordsAnotherWay = Pattern.compile(<span class="hljs-string" style="color: rgb(86, 140, 59);">"\\PL+"</span>).splitAsStream(
            contents);
      show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"wordsAnotherWay"</span>, wordsAnotherWay);

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Stream&lt;String&gt; lines = Files.lines(path, StandardCharsets.UTF_8))
      {
         show(<span class="hljs-string" style="color: rgb(86, 140, 59);">"lines"</span>, lines);
      }
   }
}
</pre>

            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 2.", написанной Кейем С.
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
        Stream<Task<Integer>> defaultinit = Task.defaultInit();

        System.out.println(defaultinit.count());
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

    public static Stream<Task<Integer>> defaultInit(){
        return Stream.of(
                new Task<>("4 + 4", 8),
                new Task<>("4 * 4 ", 16),
                new Task<>("2 * 2", 4)
        );
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
  name: "CreationStreams",
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
        {item: '8', name: '8'},
        {item: '1', name: '1'},
        {item: '2', name: '2'},
        {item: '3', name: '3'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/tenthchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[9].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[9].chapterProgress += 8.3
              window.frontendData.language.chapters[9].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[9].listThemes[1].task.answer

          window.frontendData.language.chapters[9].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[9].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[9].listThemes[1].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[9].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[9].listThemes[1].task.answer
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
        Stream<Task<Integer>> defaultinit = Task.defaultInit();

        System.out.println(defaultinit.count());
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

    public static Stream<Task<Integer>> defaultInit(){
        return Stream.of(
                new Task<>("4 + 4", 8),
                new Task<>("4 * 4 ", 16),
                new Task<>("2 * 2", 4)
        );
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

    let themeToClose = document.getElementById('java-10-chapter-2-theme');

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