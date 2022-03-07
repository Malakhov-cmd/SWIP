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
          От итерации к потоковым операциям
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Для обработки коллекции обычно требуется перебрать ее элементы и выполнить над ними некоторую операцию.
              Допустим, требуется подсчитать все длинные слова в книге. Сначала организуем их вывод списком следующим
              обра зом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">var cont ent s = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> String (Files.readAllBytes (
Paths.get(<span class="hljs-string" style="color: rgb(86, 140, 59);">"alice.t xt"</span>) ), StandardCharsets.UTF8) ;
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// прочитать текст из файла в символьную строку </span>
List&lt;Str ing&gt; words = Arrays.asList(contents.split ( <span class="hljs-string" style="color: rgb(86, 140, 59);">" \\PL + "</span>) ) ;
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// разбить полученную символьную строку на слова ; </span>
<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// небуквенные символы считаются разделителями </span></pre>
            <p>
              А теперь можно перебрать слова таким образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> count = О;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> ( String w : words )
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (w.length () &gt; <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">12</span>) count ++ ;</pre>
            <p>
              Ниже показано, как аналогичная операция осуществляется с помощью потоков данных.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">long</span> count = words.stream()
                . filter (w -&gt; w.length () &gt; <span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>)
                . count () ;</pre>
            <p>
              В последнем случае не нужно искать в цикле наглядного подтверждения операций фильтрации и подсчета слов.
              Сами имена методов свидетельствуют о том,
              что именно предполагается сделать в коде. Более того, если в цикле во всех подробностях предписывается
              порядок выполнения операций, то в потоке данных
              операции можно планировать как угодно, при условии, что будет достигнут правилы1ый результат.
            </p>
            <p>
              Достаточно заменить метод s t ream ( ) на метод para llelStream ( ) , чтобы организовать средствами
              библиотеки потоков данных параллельное выполнение
              операций фильтрации и подсчета слов, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">long</span> count = words. parallelStream ()
   . filter (w -&gt; w . length () &gt; <span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>)
   . count ( ) ;</pre>
            <p>
              Потоки данных действуют по принципу "что, а не как делать". В рассматриваемом здес1, примере кода мы
              описываем, что нужно сделать: получить длинные
              слова и подсчитап, их. При этом мы не указываем, в каком порядке или потоке
              исполнения это должно произойти. Напротив, в упомянутом выше цикле точно указывается порядок организации
              вычислений, а следовательно, исключается
              всякая возможност1, для оптимизации.
            </p>
            <p>
              На первый взгляд поток данных похож на коллекцию, поскольку он позволяет
              преобразовывап, и извлекать данные. Но у потока данных имеются следующие
              существенные отличия.
            </p>
            <ul>
              <li>
                <p>
                  Поток данных не сохраняет свои элементы. Они могуг храниться в основной
                  коллекции или формироваться по требованию.
                </p>
              </li>
              <li>
                <p>
                  Потоковые операции не изменяют их источник. Например, метод fil ter ()
                  не удаляет элементы из нового потока данных, но выдает новый поток, в котором они отсутствуют.
                </p>
              </li>
              <li>
                <p>
                  Потоковые операции выполняются по требованию, когда это возможно. Это
                  означает, что они не выполняются до тех пор, пока не потребуется их результат. Так, если требуется
                  подсчитать только пять дли1шых слов вместо
                  всех слов, метод fil te r () прекратит фильтрацию после пятого совпадения. Следовательно, потоки
                  данных могуг быть бесконечными!
                </p>
              </li>
            </ul>
            <p>
              Вернемся к предыдущему примеру, чтобы рассмотреть его подробнее. Методы stream () и parallelStream ()
              выдают поток данных для списка слов wo rds.
              А метод fil ter () возвращает другой поток данных, содержащий только те слова, длина которых больше 12
              букв. И, наконец, метод coun t ( ) сводит этот поток
              данных в конечный результат.
            </p>
            <p>
              Такая последовательность операций весьма характерна для манипулирования
              потоками данных. Конвейер операций организуется в следующие три стадии.
            </p>
            <ul>
              <li>
                <p>
                  Создание потока данных.
                </p>
              </li>
              <li>
                <p>
                  Указание про.межуточных операций для преобра:ювавия исходного потока
                  данных в другие потоки - возможно, в несколько этапов.
                </p>
              </li>
              <li>
                <p>
                  Выполнение оконечной операции для получения результата . Эта операция
                  принуждает к выполнению по требованию тех операций, которые ей предшествуют. А впоследствии поток
                  данных может больше не понадобиться.
                </p>
              </li>
            </ul>
            <p>
              В примере кода из листинга 1 .1 поток данных создается методом str e am()
              или parallelStream (). Метод fil te r () преобразует его, а метод count () выполняет оконечную операцию.
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> streams;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.io.IOException;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.nio.charset.StandardCharsets;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.nio.file.Files;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.nio.file.Paths;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.Arrays;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.List;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">CountLongWords</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> IOException
   </span>{
      String contents = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> String(Files.readAllBytes(
            Paths.get(<span class="hljs-string" style="color: rgb(86, 140, 59);">"../gutenberg/alice30.txt"</span>)), StandardCharsets.UTF_8);
      List&lt;String&gt; words = Arrays.asList(contents.split(<span class="hljs-string"
                                                                    style="color: rgb(86, 140, 59);">"\\PL+"</span>));

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">long</span> count = <span class="hljs-number"
                                                                                              style="color: rgb(147, 92, 37);">0</span>;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (String w : words)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (w.length() &gt; <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">12</span>) count++;
      }
      System.out.println(count);

      count = words.stream().filter(w -&gt; w.length() &gt; <span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>).count();
      System.out.println(count);

      count = words.parallelStream().filter(w -&gt; w.length() &gt; <span class="hljs-number"
                                                                          style="color: rgb(147, 92, 37);">12</span>).count();
      System.out.println(count);
   }
}</pre>


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
        List<Task<Integer>> listAnswers = new ArrayList<>(
                Arrays.asList(
                        new Task<>("4 + 4", 8),
                        new Task<>("4 * 4 ", 16),
                        new Task<>("2 * 2", 4)
                )
        );

        System.out.println(listAnswers
                .stream()
                .filter(item -> item.getAnswer() >5)
                .collect(Collectors.toList())
                .size()
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
  name: "FromInterationToStreams",
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
        {item: '8', name: '8'},
        {item: '16', name: '16'},
        {item: '2', name: '2'},
        {item: '1', name: '1'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/tenthchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[9].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[9].chapterProgress += 11.1
              window.frontendData.language.chapters[9].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[9].listThemes[0].task.answer

          window.frontendData.language.chapters[9].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[9].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[9].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[9].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[9].listThemes[0].task.answer
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
        List<Task<Integer>> listAnswers = new ArrayList<>(
                Arrays.asList(
                        new Task<>("4 + 4", 8),
                        new Task<>("4 * 4 ", 16),
                        new Task<>("2 * 2", 4)
                )
        );

        System.out.println(listAnswers
                .stream()
                .filter(item -> item.getAnswer() >5)
                .collect(Collectors.toList())
                .size()
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

    let themeToClose = document.getElementById('java-10-chapter-1-theme');

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