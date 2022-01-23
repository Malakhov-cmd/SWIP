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
          Цикл в стиле foreach
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>В языке Java имеется эффективная разновидность цикла, позволяющая перебирать все элементы массива (а
              также любого другого набора данных), не применяя
              счетчик. Эта усовершенствованная разновидность цикла for записывается следующим образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (переменная : коллекция) оператор
</pre>
            <p>
              При выполнении этого цикла его переменной последовательно присваивается
              каждый элемент заданной коллекции, после чего выполняется указанный оператор
              (или блок). В качестве коллекции может быть задан массив или экземпляр класса,
              реализующего интерфейс Iterable, например ArrayList.
            </p>
            <p>
              В приведенном ниже примере кода рассматриваемый здесь цикл организуется
              для вывода каждого элемента массива а в отдельной строке
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (mt element : a)
    System, out .println (element) </pre>
            <p>
              Действие этого цикла можно кратко описать как обработку каждого элемента из
              массива а. Создатели Java рассматривали возможность применения ключевых слов
              for each и in для обозначения данного типа цикла. Но такой тип цикла появился
              намного позже основных языковых средств Java, и введение нового ключевого слова
              привело бы к необходимости изменять исходный код некоторых уже существовавших
              приложений, содержащих переменные или методы с подобными именами, как, например, System.in.
            </p>
            <p>
              Безусловно, действия, выполняемые с помощью этой разновидности цикла, можно произвести и средствами
              традиционного цикла for:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(150, 203, 254);">int</span> i = <span
                class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; a.length; i++)
    System.out.println(a[i]);</pre>
            <p>
              При создании массива чисел все его элементы инициализируются нулями. Массивы значений типа boolean
              инициализируются логическим значением false, а массивы объектов — пустым значением null, указывающим на
              то, что массив пока еще не содержит ни одного объекта. Для начинающих это может показаться неожиданным.
              Так, в приведенной ниже строке кода создается массив из десяти символьных строк,
              причем все они нулевые, т.е. имеют пустое значение null.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">String[] names = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> String[<span class="hljs-number"
                                                                                                style="color: rgb(255, 115, 253);">10</span>];</pre>
            <p>
              Но при использовании цикла в стиле for each запись получается более краткой,
              поскольку отпадает необходимость в начальном выражении и условии завершения
              цикла. Да и вероятность ошибок при написании кода уменьшается.
            </p>
            <p>
              Несмотря на появление усовершенствованного цикла в стиле for each, упрощающего во многих случаях
              составление программ, традиционный цикл for совсем не
              устарел. Без него нельзя обойтись, например, в тех случаях, когда требуется обработать не всю коллекцию,
              а лишь ее часть, или тогда, когда счетчик явно используется
              в теле цикла.
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
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];

        for (int element:
             array) {
            element+=10;
        }

        System.out.println(array[9]);
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
  name: "ForEachStyle",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null,
      selected: 'Zero',
      options: [
        {item: 'Zero', name: '0'},
        {item: 'Ten', name: '10'},
        {item: 'Hundred', name: '100'},
        {item: 'Exception', name: 'Exception'}
      ]
    }
  },
  methods: {
    Request() {
      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 34,
          answer: this.selected,
          userId: window.frontendData.profile.id
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[33].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[33].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[33].task.answer

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
    if (window.frontendData.language.chapters[1].listThemes[33].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[33].task.answer
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
        int[] array = new int[10];

        for (int element:
             array) {
            element+=10;
        }

        System.out.println(array[9]);
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