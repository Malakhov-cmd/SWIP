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
          Чтение вводимых данных
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Как вам должно быть уже известно, информацию можно легко направить в стандартный поток вывода (т.е. в
              консольное окно), вызвав метод System, out .printIn ().
              А вот организовать чтение из стандартного потока ввода System, in (т.е. с консоли)
              не так-то просто. Для этого придется создать объект типа Scanner и связать его со
              стандартным потоком ввода System, in, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">Scanner in = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);</pre>
            <p>
              Сделав это, можно получить в свое распоряжение многочисленные методы из
              класса Scanner, предназначенные для чтения вводимых данных. Например, метод
              nextLine () осуществляет чтение вводимой строки, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">System.out.print(<span
                class="hljs-string" style="color: rgb(168, 255, 96);">"What is your name? "</span>);
String name = in.nextLine();</pre>
            <p>
              В данном случае метод nextLine () был применен, потому что вводимая строка
              может содержать пробелы. А для того чтобы прочитать одно слово, отделяемое пробелами, можно сделать
              следующий вызов
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String firstName = in.next();
</pre>
            <p>
              Для чтения целочисленного значения служит приведенный ниже метод
              nextInt(). Нетрудно догадаться, метод nextDouble() осуществляет чтение очередного числового значения в
              формате с плавающей точкой.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">System.out.print(<span
                class="hljs-string" style="color: rgb(168, 255, 96);">"How old are you? "</span>);
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> age = in.nextlnt();
</pre>
            <p>
              В примере программы, исходный код которой представлен в листинге 3.2, сначала
              запрашивается имя пользователя и его возраст, а затем выводится сообщение, аналогичное следующему:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">Hello, Cay. Next year, you’ll be <span
                class="hljs-number" style="color: rgb(255, 115, 253);">57</span>
(Здравствуйте, Кей. В следующем году вам будет <span class="hljs-number"
                                                     style="color: rgb(255, 115, 253);">57</span>)</pre>
            <p>
              Исходный код этой программы начинается со следующей строки:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.util.*;
</pre>
            <p>
              Класс Scanner относится к пакету java.util. Если вы собираетесь использовать
              в своей программе класс, отсутствующий в базовом пакете java.lang, вам придется
              включить в ее исходный код оператор import.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(124, 124, 124);">/**
 * This program demonstrates console input.
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@version</span> 1.10 2004-02-10
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(255, 255, 182);">InputTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
       class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(150, 203, 254);">void</span> <span
       class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span>
   </span>{
      Scanner in = <span class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// get first input</span>
      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"What is your name? "</span>);
      String name = in.nextLine();

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// get second input</span>
      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"How old are you? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> age = in.nextInt();

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// display output on console</span>
      System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Hello, "</span> + name + <span
                  class="hljs-string" style="color: rgb(168, 255, 96);">". Next year, you'll be "</span> + (age + <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">1</span>));
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
          Что выведет программа при вводе "James\\n fine"
        </label>

        <textarea id="codeContentId" readonly>
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.print("How are you? ");
        String filling = in.nextLine();

        // display output on console
        System.out.println("Hello, " + name + ". You are " + filling);
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
          Исправьте программу чтобы она выводи "Hello, James. Im from Tennessee"
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "ReadInputData",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Hello_James',
      options: [
        {item: 'Hello_James', name: 'Hello, James'},
        {item: 'Hello_James_You_are_fine', name: 'Hello James You are fine'},
        {item: 'You_are_fine', name: 'You are fine'},
        {item: 'Awesome', name: 'Hello, James. You are fine'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 24,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[23].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[23].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[23].task.answer

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          this.$toasted.error("Неверный ответ", {
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
    },
  },
  mounted() {
    if (window.frontendData.language.chapters[1].listThemes[23].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[23].task.answer
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
        `public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.print("How are you? ");
        String filling = in.nextLine();

        // display output on console
        System.out.println("Hello, " + name + ". You are " + filling);
    }
}
      `)

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)
    //container.scrollTo(50, 5000)
  }
}
</script>

<style scoped>

</style>