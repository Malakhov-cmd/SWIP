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
          Приведение типов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Как пояснялось выше, значения типа int при необходимости автоматически преобразуются в значения типа
              double. С другой стороны, в ряде ситуаций числовое значение типа double должно рассматриваться как целое.
              Преобразования числовых типов
              в Java возможны, но они могут, конечно, сопровождаться потерей данных. Такие преобразования называются
              приведением типов. Синтаксически приведение типов задается
              парой скобок, в которых указывается желательный тип, а затем имя переменной:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> х = <span class="hljs-number"
                                                                                               style="color: rgb(0, 204, 102);">9.997</span>;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> nx = (<span class="hljs-keyword"
                                                                                    style="color: rgb(102, 68, 170);">int</span>)x;</pre>
            <p> В результате приведения к целому типу числового значения с плавающей точкой,
              хранящегося в переменной х, значение переменной пх становится равным 9, поскольку дробная часть числа
              при этом отбрасывается. Если же требуется округлить число
              с плавающей точкой до ближайшего целого числа (что во многих случаях намного
              полезнее), то для этой цели служит метод Math, round (), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">double</span> х = <span class="hljs-number"
                                                                                               style="color: rgb(0, 204, 102);">9.997</span>;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> nx = (<span class="hljs-keyword"
                                                                                    style="color: rgb(102, 68, 170);">int</span>)Math.round(х);
</pre>
            <p>
              Теперь значение переменной nx становится равным 10. При вызове метода
              round() по-прежнему требуется выполнять приведение типов (int). Дело в том, что
              значение, возвращаемое методом round(), относится к типу long, и поэтому оно может быть присвоено
              переменной типа int только с явным приведением. Иначе существует вероятность потери данных.
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
class Main
{
    public static void main(String[] args)
    {
        double a = 0.9;
        int b = (int) a;

        int c = (int) Math.round(a);

        if (b > c ){
            System.out.println("more");
        } else {
            System.out.println("less");
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
import "codemirror/lib/codemirror.css"
import "codemirror/theme/dracula.css"
import "codemirror/mode/jsx/jsx.js"

let isSendedandrecived = false

export default {
  name: "BringingType",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'more',
      options: [
        {item: 'more', name: 'more'},
        {item: 'less', name: 'less'},
        {item: 'CastException', name: 'CastException'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 13,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[12].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.2
              window.frontendData.language.chapters[1].listThemes[12].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[12].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[12].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[12].task.answer
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
        `class Main
{
    public static void main(String[] args)
    {
        double a = 0.9;
        int b = (int) a;

        int c = (int) Math.round(a);

        if (b > c ){
            System.out.println("more");
        } else {
            System.out.println("less");
        }
    }
}
      `)

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  }
}
</script>

<style scoped>

</style>