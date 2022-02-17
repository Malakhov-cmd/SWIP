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
          Объекты и объектные переменные
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Чтобы работать с объектами, их нужно сначала создать и задать их исходное
              состояние. Затем к этим объектам можно применять методы. Для создания новых
              экземпляров в Java служат конструкторы. Конструктор — это специальный метод,
              предназначенный для создания и инициализации экземпляра класса. В качестве примера можно привести класс
              Date, входящий в состав стандартной библиотеки Java.
              С помощью объектов этого класса можно описать текущий или любой другой момент времени, например "December
              31, 1999, 23:59:59 GMT".
            </p>
            <p>Имя конструктора всегда совпадает с именем класса. Следовательно, конструктор
              класса Date называется Date (). Чтобы создать объект типа Date, конструктор следует
              объединить с операцией new, как показано ниже, где создается новый объект, который инициализируется
              текущими датой и временем.</p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Date()</pre>

            <p>При желании объект можно передать методу, как показано ниже.</p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">System.out.printin(<span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Date());
</pre>

            <p>И наоборот, можно вызвать метод для вновь созданного объекта. Среди методов
              класса Date имеется метод toString (), позволяющий представить дату в виде символьной строки. Он
              вызывается следующим образом:</p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">String = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Date().toString();

</pre>

            <p>В этих двух примерах созданный объект использовался только один раз. Но,
              как правило, объектом приходится пользоваться неоднократно. Чтобы это стало
              возможным, необходимо связать объект с некоторым идентификатором, иными словами, присвоить объект
              переменной, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">Date birthday = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Date();

</pre>
            <p>У объектов и объектных переменных имеется существенное отличие. Например,
              в приведенной ниже строке кода определяется объектная переменная deadline, которая может ссылаться на
              объекты типа Date.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">Date deadline; <span
                class="hljs-comment" style="color: rgb(120, 135, 125);">// переменная deadline не ссылается ни на один из объектов</span>
</pre>
            <p>Важно понимать, что на данном этапе сама переменная deadline объектом не
              является и даже не ссылается ни на один из объектов. Поэтому ни один из методов класса Date пока еще
              нельзя вызывать по этой переменной. Попытка сделать это
              приведет к появлению сообщения об ошибке:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">s = deadline.toString(); <span
                class="hljs-comment" style="color: rgb(120, 135, 125);">// вызывать метод еще рано!</span>
</pre>
            <p>Сначала нужно инициализировать переменную deadline. Для этого имеются две
              возможности. Прежде всего, переменную можно инициализировать вновь созданным
              объектом</p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">deadline = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Date();</pre>
            <p>
              Кроме того, переменной можно присвоить ссылку на существующий объект, как
              показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">deadline = birthday;</pre>
            <p>
              Теперь переменные deadline и birthday ссылаются на один и тот же объект
            </p>
            <p>
              Важно понять, что объектная переменная фактически не содержит никакого объекта. Она лишь ссылается на
              него. Значение любой объектной переменной в Java
              представляет собой ссылку на объект, размещенный в другом месте. Операция new
              также возвращает ссылку. Например, приведенная ниже строка кода состоит из двух
              частей: в операции new Date () создается объект типа Date, а переменной deadline
              присваивается ссылка на вновь созданный объект.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">Date deadline = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Date();
</pre>
            <p>
              Объектной переменной можно явно присвоить пустое значение null, чтобы указать на то, что она пока не
              ссылается ни на один из объектов:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">deadline = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">null</span>;
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">if</span>(deadline != <span class="hljs-keyword"
                                                                                         style="color: rgb(85, 133, 155);">null</span>)
System.out.println(deadline);
</pre>

            <p>
              Если попытаться вызвать метод по ссылке на переменную с пустым значением
              null, то при выполнении программы возникнет ошибка, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">birthday = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">null</span>;
String s = birthday.toString(); <span class="hljs-comment"
                                      style="color: rgb(120, 135, 125);">// Ошибка при выполнении!</span></pre>

            <p>
              Локальные переменные не инициализируются автоматически пустым значением
              null. Программирующий должен сам инициализировать переменную, выполнив
              операцию new или присвоив пустое значение null.
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
        double a = 10;
        int b = 15;
        a = b;
        b = (int) a;
        a = 1;
        a= b;
        System.out.println(a);
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
  name: "ObjectsAndObjectsTemp",
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

      selected: '10',
      options: [
        {item: '10', name: '10'},
        {item: '15', name: '15'},
        {item: '1', name: '1'},
        {item: 'CastException', name: 'CastException'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 2.7
              window.frontendData.language.chapters[2].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[4].task.answer

          window.frontendData.language.chapters[2].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[4].task.tryCount + ".",{
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
    if (window.frontendData.language.chapters[2].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[4].task.answer
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
        double a = 10;
        int b = 15;
        a = b;
        b = (int) a;
        a = 1;
        a= b;
        System.out.println(a);
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

    let themeToClose = document.getElementById('java-3-chapter-2-theme-1-subtheme');

    let topPosOfClosingElement = themeToClose.offsetTop;
    let leftPosOfClosingElement = themeToClose.offsetLeft;

    const pageWidth = document.documentElement.scrollWidth
    const pageHeight = document.documentElement.scrollHeight

    if(pageWidth > leftPosOfClosingElement) {
      container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
    } else {
      container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
    }
  }
}
</script>

<style scoped>

</style>