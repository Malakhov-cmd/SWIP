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
          Методы filter() , map() и flatмap()
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В результате преобразования потока данных получается другой поток данных,
              элементы которого являются производными от элементов исходного потока. Ранее демонстрировалось
              преобразование методом fil ter (), в результате которого получается новый поток данных с элементами,
              удовлетворяющими определенному условию. В приведенном ниже примере кода поток символьных строк
              преобразуется в другой поток, содержащий только длинные слова . В качестве аргумента метода fil ter ()
              указывается объект типа Predica te
              < T >, т.е. функция,
                преобразующая тип Тв логический тип boo lean.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        List&lt;String&gt; words = ... ;
        Stream&lt;String&gt; longWords =
                words.stream().filter (w -&gt; w . length () &gt; <span class="hljs-number"
                                                                        style="color: rgb(147, 92, 37);">12</span> ) ;</pre>
            <p>
              Нередко значения в потоке данных требуется каким-то образом преобразовать. Для этой цели можно
              воспользоваться методом map (), передав ему функцию, которая и выполняет нужное преобразование. Например,
              буквы во всех
              словах можно сделать строчными следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Stream&lt;String&gt; lowercaseWords =
     words . stream() . map ( String : : toLowerCase );
</pre>
            <p>
              В данном примере методу map () была передана ссылка на метод. Но вместо
              нее нередко передается лямбда-выражение, как показано ниже. Получающийся
              в итоге поток данных содержит первую букву каждого слова.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Stream&lt;String&gt; firstLetters =
    words.stream().map (s -&gt; s.substring (<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span> ) ); </pre>
            <p>
              При вызове метода map () передаваемая ему функция применяется к каждому элементу потока данных, в
              результате чего образуется новый поток данных
              с полученными результатами. А теперь допустим, что имеется метод, возвращающий не одно значение, а поток
              значений. В качестве примера ниже приведен
              метод, преобразующий символьную строку в поток символьных строк, а точнее - отдельных кодовых точек.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Stream&lt;String&gt; <span
                class="hljs-title" style="color: rgb(37, 127, 173);">codePoints</span><span class="hljs-params"
                                                                                            style="color: rgb(147, 92, 37);">( Strings)</span>
    </span>{
        var result = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ArrayList&lt;String&gt; ( ) ;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> i = О;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (i &lt; s . length ( ) )
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> j = s.offsetByCodePoints(i, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span> ) ;
        result . add(s. substring (i, j ) );
        i = j;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> result . stream() ;

    }</pre>
            <p>
              Данный метод правильно обрабатывает символы в Юникоде, требующие
              двух значений типа char, поскольку именно так это и следует делать. Хотя вникап в такие подробности
              совсем не обязательно. Например, в результате вызова
              code Po ints ( "boat " ) образуется поток данных [ "Ь " , " о "
              ,
              " а
              "
              , "t" J .
            </p>
            <p>
              А теперь допустим, что метод codePo ints () передается методу map () для преобразования потока символьных
              сrрок следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Stream&lt;Stream&lt;String&gt;&gt; result =
       words.stream() . map (w -&gt; codePoints ( w )); </pre>
            <p>
              В итоге получится поток потоков вроде [ ... [ " у "
              , "о" , "u" , " r " ] , [ " Ь ",
              " о ", " а
              "
              , " t " ] , ... ] . Чтобы свесrи его к потоку букв [ . . .
              "
              у
              "
              , "о" , "u" , "r" ,
              "Ь ", " о " ,
              " а
              "
              , "t" , . . . ] , вместо метода map () следует вызвать метод f latMap ()
              таким образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">S t ream&lt;St ring&gt; flat Result =
words . <span class="hljs-function">s t <span class="hljs-title" style="color: rgb(37, 127, 173);">ream</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">()</span> . f l <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">atMap</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(w -&gt; code Point s (w)</span> )
11 Вызывает метод code Point <span class="hljs-title" style="color: rgb(37, 127, 173);">s</span> <span
                    class="hljs-params" style="color: rgb(147, 92, 37);">()</span> для каждого слова
11 и сводит ре зультаты </span></pre>

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
        Task<Integer> task = new Task<Integer>(" 4 * 4 ", 16);
        Stream<Task<Integer>> defaultinit = task.defaultInit();

        System.out.println(defaultinit
                .map(item -> item.getAnswer() - 5)
                .filter(it -> it > 5)
                .count()
        );
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

    public Stream<Task<Integer>> defaultInit(){
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
  name: "MethodsFilterMapFlatMap",
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

      axios.get('/java/tenthchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[9].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[9].chapterProgress += 11.1
              window.frontendData.language.chapters[9].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[9].listThemes[2].task.answer

          window.frontendData.language.chapters[9].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[9].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[9].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[9].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[9].listThemes[2].task.answer
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
        Task<Integer> task = new Task<Integer>(" 4 * 4 ", 16);
        Stream<Task<Integer>> defaultinit = task.defaultInit();

        System.out.println(defaultinit
                .map(item -> item.getAnswer() - 5)
                .filter(it -> it > 5)
                .count()
        );
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

    public Stream<Task<Integer>> defaultInit(){
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

    let themeToClose = document.getElementById('java-10-chapter-3-theme');

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