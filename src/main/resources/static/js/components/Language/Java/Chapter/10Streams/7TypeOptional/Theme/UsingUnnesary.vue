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
          Употребление необязательных значений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Как было показано в предыдущем разделе, если значение отсутствует, можно получить его альтернативный
              вариант. Другая методика обработки необязательных значений состоит в том, чтобы употребить значение
              только в том случае,
              если оно присутствует.
            </p>

            <p>
              Метод if Present ( ) принимает функцию в качестве аргумента, как показано
              ниже. Если необязательное значение существует, оно передается данной функции. В противном случае ничего
              не происходит.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">optionalValue . ifPresent (v - &gt; Обработать v ) ;</pre>
            <p>
              Так, если требуется ввести значение во множество, при условии, что оно существует, достаточно сделап,
              следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">optionalValue.ifPresent (v -&gt; results.add (v) );</pre>
            <p>
              или просто
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">optionalValue.ifPresent ( results : : add ) ; </pre>
            <p>
              Если требуется п редпринять одно действие, когда необязательное значение
              присутствует, и другое действие, когда оно отсутствует, в таком случае можно
              вы:шать метод ifPresentOrElse():
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">optionalValue.ifPresentOrElse (
v -&gt; System.out . println ( <span class="hljs-string" style="color: rgb(86, 140, 59);">" Found "</span> + v ) ,
( ) -&gt; logger . warning ( <span class="hljs-string" style="color: rgb(86, 140, 59);">" No match "</span> )); </pre>

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

       defaultinit
                .forEach(integerTask -> integerTask.getAnswer().ifPresent(
                        value -> System.out.print(value * 2 + " ")
                ));

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


    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public Optional<T> getAnswer() {
            return Optional.ofNullable(this.answer);
    }

    public Stream<Task<Integer>> defaultInit(){
        return Stream.of(
                new Task<>("4 + 4", 8),
                new Task<>("4 * 4 ", 16),
                new Task<>("2 * 2", 4),
                new Task<>("2 + 2", null)
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
  name: "UsingUnnesary",
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
        {item: '4 8 16', name: '4 8 16'},
        {item: '8 16 32', name: '8 16 32'},
        {item: '8 16 32 0', name: '8 16 32 0'},
        {item: '0 8 16 32', name: '0 8 16 32'},
        {item: '16 32 8', name: '16 32 8'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/tenthchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[9].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[9].chapterProgress += 11.1
              window.frontendData.language.chapters[9].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[9].listThemes[4].task.answer

          window.frontendData.language.chapters[9].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[9].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[9].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[9].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[9].listThemes[4].task.answer
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

       defaultinit
                .forEach(integerTask -> integerTask.getAnswer().ifPresent(
                        value -> System.out.print(value * 2 + " ")
                ));

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


    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public Optional<T> getAnswer() {
            return Optional.ofNullable(this.answer);
    }

    public Stream<Task<Integer>> defaultInit(){
        return Stream.of(
                new Task<>("4 + 4", 8),
                new Task<>("4 * 4 ", 16),
                new Task<>("2 * 2", 4),
                new Task<>("2 + 2", null)
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

    let themeToClose = document.getElementById('java-10-chapter-7-theme-2-subtheme');

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