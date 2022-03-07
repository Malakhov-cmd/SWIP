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
          Обобщенные методы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В предыдущем разделе было показано, как определяется обобщенный класс. Имеется также возможность
              определить отдельный метод с параметрами (или переменными) типа следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">ArrayAlg</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">static</span> &lt;T&gt; <span
                  class="hljs-function">T <span class="hljs-title"
                                                style="color: rgb(37, 127, 173);">getMiddle</span><span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(Т... а)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> a[a.length / <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">2</span>];
    }
}</pre>

            <p>
              Этот метод определен в обычном, а не в обобщенном классе. Тем не менее это
              обобщенный метод, на что указывают угловые скобки и переменная типа. Обратите
              внимание на то, что переменная типа вводится после модификаторов доступа (в данном случае public static)
              и перед возвращаемым типом.
            </p>

            <p>
              Обобщенные методы можно определять как в обычных, так и в обобщенных классах. Когда вызывается обобщенный
              метод, ему можно передать конкретные типы
              данных, заключая их в угловые скобки перед именем метода, как показано ниже.

            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">String middle = ArrayAlg.&lt;String&gt;getMiddle(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"John"</span>, <span class="hljs-string"
                                                                                          style="color: rgb(86, 140, 59);">"Q."</span>, <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Public"</span>);
</pre>

            <p>
              В данном случае (как и вообще) при вызове метода можно пропустить параметр
              типа String. У компилятора имеется достаточно информации, чтобы вывести из такого обобщения именно тот
              метод, который требуется вызвать. Он сравнивает тип
              параметра метода (т.е. String [ ] с обобщенным типом Т [ ]) и приходит к выводу, что
              вместо обобщенного типа Т следует подставить тип String, что равнозначно следующему вызову:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">String middle = ArrayAlg.getMiddle(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"John"</span>, <span class="hljs-string"
                                                                                          style="color: rgb(86, 140, 59);">"Q."</span>, <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Public"</span>);
</pre>
            <p>
              Выводимость типов в обобщенных методах практически всегда действует исправно. Но иногда компилятор
              ошибается, и тогда приходится разбираться в тех ошибках, о которых он сообщает. Рассмотрим в качестве
              примера следующую строку кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> middle = ArrayAlg.getMiddle(<span
                class="hljs-number" style="color: rgb(147, 92, 37);">3.14</span>, <span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">1729</span>, <span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>);
</pre>
            <p>
              При выполнении этой строки кода компилятор выведет сообщение об ошибке загадочного содержания, но суть
              его в том, что данный код можно интерпретировать
              двояко и в обоих случаях — правильно. По существу, компилятор выполняет автоупаковку параметра в один
              объект типа Double и два объекта типа Integer, а затем
              пытается найти для них общий супертип. И таких супретипов два: класс Number и интерфейс Comparable,
              который сам является обобщенным. В этом случае для устранения ошибки методу следует передать все
              параметры со значениями типа double.

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
public class Test {
    public static void main(String[] args) {
        Task<Integer> taskInt = new Task<>("4 * 4", 16);
        Task<String> taskString = new Task<>("William Sheakspear is", "Writer");
        Task<Task> taskTask = new Task<>("First task is ", taskInt);

        System.out.println(taskTask.getAnswer().getQuestion());

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
  name: "GenericMethods",
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
        {item: 'UnderfindedTypeOfProperty', name: 'UnderfindedTypeOfProperty'},
        {item: '16', name: '16'},
        {item: '12', name: '12'},
        {item: 'William Sheakspear is', name: 'William Sheakspear is'},
        {item: '4 * 4', name: '4 * 4'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/seventhchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 11.1
              window.frontendData.language.chapters[6].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[2].task.answer

          window.frontendData.language.chapters[6].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[6].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[2].task.answer
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
        Task<String> taskString = new Task<>("William Sheakspear is", "Writer");
        Task<Task> taskTask = new Task<>("First task is ", taskInt);

        System.out.println(taskTask.getAnswer().getQuestion());

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

    let themeToClose = document.getElementById('java-7-chapter-3-theme');

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