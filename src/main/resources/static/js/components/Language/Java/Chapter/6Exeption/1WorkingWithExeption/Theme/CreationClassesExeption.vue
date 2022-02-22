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
          Создание классов исключений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В прикладной программе может возникнуть ситуация, не предусмотренная ни
              в одном из стандартных классов исключений. В этом случае нетрудно создать свой
              собственный класс исключения. Очевидно, что он должен быть подклассом, производным от класса Exception
              или одного из его подклассов, например, IOException,
              как показано ниже. Этот класс можно снабдить конструктором по умолчанию и конструктором, содержащим
              подробное сообщение. (Это сообщение, возвращаемое методом toString ке программы.)
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">FileFormatException</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">IOException</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">FileFormatException</span><span class="hljs-params"
                                                                                             style="color: rgb(147, 92, 37);">()</span> </span>{
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">FileFormatException</span><span class="hljs-params"
                                                                                             style="color: rgb(147, 92, 37);">(String gripe)</span></span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>(gripe);
    }
}</pre>

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

        //допустим пользователь ввел вот такой ответ
        String userAnswer = "8";

        try {
            taskList.get(1).checkAnswer(userAnswer);
            System.out.println("Success task complete");
        } catch (TaskException e) {
            e.printStackTrace();
        }
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

        public void checkAnswer(String userAnswer) throws TaskException {
            if (!getAnswer().equals(userAnswer)){
                throw new TaskException("Wrong answer");
            }
        }
    }

    static class TaskException extends IOException{
        public TaskException() {
        }

        public TaskException(String message) {
            super(message);
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
  name: "CreationClassesExeption",
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

      selected: '... Wrong answer ...',
      options: [
        {item: '... Wrong answer ...', name: '... Wrong answer ...'},
        {item: '8', name: '8'},
        {item: '12', name: '12'},
        {item: 'Success task complete', name: 'Success task complete'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/sixthchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[5].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[5].chapterProgress += 16.6
              window.frontendData.language.chapters[5].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[5].listThemes[2].task.answer

          window.frontendData.language.chapters[5].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[5].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[5].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[5].listThemes[2].task.answer
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

        //допустим пользователь ввел вот такой ответ
        String userAnswer = "8";

        try {
            taskList.get(1).checkAnswer(userAnswer);
            System.out.println("Success task complete");
        } catch (TaskException e) {
            e.printStackTrace();
        }
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

        public void checkAnswer(String userAnswer) throws TaskException {
            if (!getAnswer().equals(userAnswer)){
                throw new TaskException("Wrong answer");
            }
        }
    }

    static class TaskException extends IOException{
        public TaskException() {
        }

        public TaskException(String message) {
            super(message);
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

    let themeToClose = document.getElementById('java-6-chapter-1-theme-3-subtheme');

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