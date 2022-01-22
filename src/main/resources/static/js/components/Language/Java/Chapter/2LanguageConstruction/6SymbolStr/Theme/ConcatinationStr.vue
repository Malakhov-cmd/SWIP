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
          Сцепление строк
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В языке Java, как и в большинстве других языков программирования, предоставляется возможность объединить
              две символьные строки, используя знак + операции
              сцепления.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String expletive = <span
                class="hljs-string" style="color: rgb(168, 255, 96);">"Expletive"</span>;
String PG13 = <span class="hljs-string" style="color: rgb(168, 255, 96);">"deleted"</span>;
String message = expletive + PG13;</pre>
            <p>
              В приведенном выше фрагменте кода переменной message присваивается символьная строка "Expletivedeleted",
              сцепленная из двух исходных строк. (Обратите внимание на отсутствие пробела между словами в этой строке.
              Знак + операции сцепления соединяет две строки точно в том порядке, в каком они были заданы в качестве
              операндов.)
            </p>
            <p>
              При сцеплении символьной строки со значением, не являющимся строковым, это
              значение преобразуется в строковое. (Как станет ясно из главы 5, каждый объект в Java
              может бьггь преобразован в символьную строку.) В приведенном ниже примере переменной rating присваивается
              символьная строка "PG13", полученная путем сцепления
              символьной строки с числовым значением, автоматически преобразуемым в строковое,
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> age = <span class="hljs-number"
                                                                                               style="color: rgb(255, 115, 253);">13</span>;
String rating = <span class="hljs-string" style="color: rgb(168, 255, 96);">"PG"</span> + age;
</pre>
            <p>
              Такая возможность широко используется в операторах вывода. Например, приведенная ниже строка кода вполне
              допустима для вывода результата в нужном формате, т.е. с пробелом между сцепляемыми строками.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">System.out.println(<span
                class="hljs-string" style="color: rgb(168, 255, 96);">"The answer is "</span> + answer);</pre>
            <p>
              Если требуется соединить вместе две символьные строки, разделяемые каким-нибудь
              знаком, для этой цели можно воспользоваться методом join (), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String all = String.join(<span
                class="hljs-string" style="color: rgb(168, 255, 96);">" / "</span>, <span class="hljs-string"
                                                                                          style="color: rgb(168, 255, 96);">"S"</span>, <span
                class="hljs-string" style="color: rgb(168, 255, 96);">"M"</span>, <span class="hljs-string"
                                                                                        style="color: rgb(168, 255, 96);">"L"</span>, <span
                class="hljs-string" style="color: rgb(168, 255, 96);">"XL"</span>);
<span class="hljs-comment"
      style="color: rgb(124, 124, 124);">// в итоге переменная all содержит строку "S / М / L / XL"</span></pre>
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
public class Main {
    public static void main(String[] args) {
        String str = "Hello Java";

        System.out.println(str.concat(" is Hard way"));
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "ConcatinationStr",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'is_Hard_way',
      options: [
        {item: 'is_Hard_way', name: 'is Hard way'},
        {item: 'Hello_Java', name: 'Hello Java'},
        {item: 'Hello_Java_is_Hard_way', name: 'Hello Java is Hard way'},
        {item: 'Hello_Java_is_Hard_way_', name: 'Hello Java is Hard way(space)'},
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 20,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[19].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[19].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[19].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[19].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[19].task.answer
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
        String str = "Hello Java";

        System.out.println(str.concat(" is Hard way"));
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