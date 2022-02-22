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
          Оператор try с ресурсами
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В версии Java SE 7 внедрена следующая удобная конструкция, упрощающая код
              обработки исключений, где требуется освобождать используемые ресурсы
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            открыть ресурс
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                использовать ресурс
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
            {
                закрыть ресурс
            }</pre>
            <p>
              Следует, однако, иметь в виду, что эта конструкция эффективна при одном условии: используемый ресурс
              принадлежит классу, реализующему интерфейс
              AutoCloseable. В этом интерфейсе имеется единственный метод, объявляемый следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">close</span><span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">()</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> Exception</span></pre>
            <p>
              В своей простейшей форме оператор try с ресурсами выглядит следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Resource res = ...)
            {
                использовать ресурс res
            }</pre>
            <p>
              Если в коде имеется блок try, то метод res.close () вызывается автоматически.
              Ниже приведен типичный пример ввода всего текста из файла и последующего его
              вывода.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Scanner in =
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Scanner(<span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">new</span> FilelnputStream(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"/usr/share/dict/words"</span>)), <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"UTF-8"</span>);
{
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (in.hasNext())
System.out.println(in.next());
}</pre>
            <p>
              Независимо от того, происходит ли выход из блока try нормально, или же в нем
              возникает исключение, метод in.close () вызывается в любом случае, как и при использовании блока finally.
              В блоке try можно также указать несколько ресурсов,
              как в приведенном ниже примере кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Scanner in =
                         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Scanner (<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FilelnputStream(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"/usr/share/dict/words"</span>)), <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"UTF-8"</span>);
            PrintWriter out = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> PrintWriter(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"out.txt"</span>))
            {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (in.hasNext())
                    out.println(in.next().toUpperCase());
            }</pre>

            <p>
              Таким образом, независимо от способа завершения блока try оба потока ввода
              и вывода благополучно закрываются. Если бы такое освобождение ресурсов пришлось программировать вручную,
              для этого пришлось бы составлять вложенные
              блоки try/finally.

            </p>
            <p>
              Как было показано ранее, трудности возникают в том случае, если исключение
              генерируется не только в блоке try, но и в методе close (). Оператор try с ресурсами предоставляет
              довольно изящный выход из столь затруднительного положения.
              Исходное исключение генерируется повторно, а любые исключения, генерируемые
              в методе close (), считаются "подавленными". Они автоматически перехватываются и добавляются к исходному
              исключению с помощью метода addSuppressed ().
              И если они представляют какой-то интерес с точки зрения обработки, то следует вызвать метод getSuppressed
              (), предоставляющий массив подавленных исключений
              из метода close ().

            </p>

            <p>
              Как было показано ранее, трудности возникают в том случае, если исключение
              генерируется не только в блоке try, но и в методе close (). Оператор try с ресурсами предоставляет
              довольно изящный выход из столь затруднительного положения.
              Исходное исключение генерируется повторно, а любые исключения, генерируемые
              в методе close (), считаются "подавленными". Они автоматически перехватываются и добавляются к исходному
              исключению с помощью метода addSuppressed ().
              И если они представляют какой-то интерес с точки зрения обработки, то следует вызвать метод getSuppressed
              (), предоставляющий массив подавленных исключений
              из метода close ().
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
          Что произойдет при запуске программы?
        </label>

        <textarea id="codeContentId" readonly>
public class Test {
    public static void main(String[] args) {
       createCustomerTable();
    }

    public static void createCustomerTable() {
        System.out.println("Create table");
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(
                     String.valueOf(Statements.valueOf("createStatement").getState())
             )
        ) {
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Ошибка исполнения запроса");
        }
    }

    public enum Statements {
        createStatement("CREATE TABLE CUSTOMER (\r\n" + "  id  int8(256) primary key,\r\n" +
                "  name varchar(128),\r\n" + "  email varchar(256)" + " );");

        private final String state;

        Statements(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
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
          Что произойдет при запуске программы?
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
  name: "OperatorTryWithResource",
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

      selected: 'Установление соединения с базой данных',
      options: [
        {item: 'Установление соединения с базой данных', name: 'Установление соединения с базой данных'},
        {item: 'Выполнение запроса по созданию и инициализации бд', name: 'Выполнение запроса по созданию и инициализации бд'},
        {item: 'Получение ошибки в связи с не закрытими ресурсами', name: 'Получение ошибки в связи с не закрытими ресурсами'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/sixthchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[5].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[5].chapterProgress += 10.0
              window.frontendData.language.chapters[5].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[5].listThemes[4].task.answer

          window.frontendData.language.chapters[5].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[5].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[5].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[5].listThemes[4].task.answer
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
       createCustomerTable();
    }

    public static void createCustomerTable() {
        System.out.println("Create table");
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(
                     String.valueOf(Statements.valueOf("createStatement").getState())
             )
        ) {
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Ошибка исполнения запроса");
        }
    }

    public enum Statements {
        createStatement("CREATE TABLE CUSTOMER (\\r\\n" + "  id  int8(256) primary key,\\r\\n" +
                "  name varchar(128),\\r\\n" + "  email varchar(256)" + " );");

        private final String state;

        Statements(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
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

    let themeToClose = document.getElementById('java-6-chapter-2-theme-2-subtheme');

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