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
          Операции инкрементирования и декрементирования
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Программисты, конечно, знают, что одной из самых распространенных операций
              с числовыми переменными является добавление или вычитание единицы. В языке
              Java, как и в языках С и C++, для этой цели предусмотрены операции инкрементирования и декрементирования.
              Так, в результате операции п++ к текущему значению
              переменной п прибавляется единица, а в результате операции п— значение переменной п уменьшается на
              единицу. После выполнения приведенного ниже фрагмента
              кода значение переменной п становится равным 13.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> n = <span class="hljs-number"
                                                                                            style="color: rgb(0, 204, 102);">12</span>;
n++;
</pre>
            <p>
              Операции ++ и — изменяют значение переменной, и поэтому их нельзя применять к самим числам. Например,
              выражение 4++ считается недопустимым.
            </p>
            <p>
              Существуют два вида операций инкрементирования и декрементирования. Выше
              продемонстрирована постфиксная форма, в которой символы операции размещаются
              после операнда. Но есть и префиксная форма: ++п. Обе эти операции изменяют значение переменной на
              единицу. Их отличие проявляется только тогда, когда эти операции присутствуют в выражениях. В префиксной
              форме сначала изменяется значение переменной, и для дальнейших вычислений уже используется новое
              значение, а в
              постфиксной форме используется прежнее значение этой переменной, и лишь после
              данной операции оно изменяется, как показано в приведенных ниже примерах кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(34, 34, 34); color: rgb(170, 170, 170);"><span
                class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> m = <span class="hljs-number"
                                                                                            style="color: rgb(0, 204, 102);">7</span>;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> n = <span class="hljs-number"
                                                                                  style="color: rgb(0, 204, 102);">7</span>;
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> a = <span class="hljs-number"
                                                                                  style="color: rgb(0, 204, 102);">2</span> * ++m; <span
                  class="hljs-comment"
                  style="color: rgb(68, 68, 68);">// теперь значение а равно 1 6 , a m равно 8</span>
<span class="hljs-keyword" style="color: rgb(102, 68, 170);">int</span> b = <span class="hljs-number"
                                                                                  style="color: rgb(0, 204, 102);">2</span> * n++; <span
                  class="hljs-comment"
                  style="color: rgb(68, 68, 68);">// теперь значение b равно 1 4 , a n равно 8</span>
</pre>
            <p>
              Пользоваться операциями инкрементирования и декрементирования в выражениях не рекомендуется, поскольку
              это зачастую запутывает код и приводит к досадным ошибкам.
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

        int a = 10;
        a*=10;

        int b = a*2 - ++a;
        System.out.println(b);
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
  name: "IncrementAndDecrement",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'One',
      options: [
        {item: 'One', name: '198'},
        {item: 'Two', name: '202'},
        {item: 'Three', name: '101'},
        {item: 'Four', name: '99'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 15,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[14].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[14].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[14].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[14].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[14].task.answer
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

        int a = 10;
        a*=10;

        int b = a*2 - ++a;
        System.out.println(b);
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