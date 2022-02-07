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
          Сортировка массивов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Если требуется упорядочить массив чисел, для этого достаточно вызвать метод
              sort () из класса Arrays:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] а = <span class="hljs-keyword"
                                                                                               style="color: rgb(150, 203, 254);">new</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[<span class="hljs-number"
                                                                                         style="color: rgb(255, 115, 253);">10000</span>];
Arrays.sort(a);
</pre>
            <p>
              В этом методе используется усовершенствованный вариант алгоритма быстрой
              сортировки, которая считается наиболее эффективной для большинства наборов
              данных. Класс Arrays содержит ряд удобных методов, предназначенных для работы
              с массивами. Эти методы приведены в конце раздела.
            </p>
            <p>
              Программа, исходный код которой представлен в листинге 3.7, создает массив
              и генерирует случайную комбинацию чисел для лотереи. Так, если нужно угадать
              6 чисел из 49, программа может вывести следующее сообщение:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">Bet the following combination. It ll make you rich!
(Попробуйте следующую комбинацию, чтобы разбогатеть!)
<span class="hljs-number" style="color: rgb(255, 115, 253);">4</span>
<span class="hljs-number" style="color: rgb(255, 115, 253);">7</span>
<span class="hljs-number" style="color: rgb(255, 115, 253);">8</span>
<span class="hljs-number" style="color: rgb(255, 115, 253);">19</span>
<span class="hljs-number" style="color: rgb(255, 115, 253);">30</span>
<span class="hljs-number" style="color: rgb(255, 115, 253);">44</span>
</pre>
            <p>
              Для выбора случайных чисел массив numbers сначала заполняется последовательностью чисел 1, 2,..., п, как
              показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">        <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] numbers = <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(150, 203, 254);">int</span>[n];
        <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                        style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; numbers.length; i++)
            numbers[i] = i + <span class="hljs-number" style="color: rgb(255, 115, 253);">1</span>;</pre>
            <p>
              Второй массив служит для хранения сгенерированных чисел:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] result = <span class="hljs-keyword"
                                                                                                    style="color: rgb(150, 203, 254);">new</span> <span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[k];
</pre>
            <p>
              Затем генерируется к чисел. Метод Math.random() возвращает случайное число
              с плавающей точкой, находящееся в пределах от 0 (включительно) до 1 (исключительно). Умножение результата
              на число п дает случайное число, находящееся в пределах от 0 до п-1, как показано в следующей строке
              кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> г = (<span class="hljs-keyword"
                                                                                              style="color: rgb(150, 203, 254);">int</span>)(Math.random() * n);
</pre>
            <p>
              Далее z-e число присваивается z-му элементу массива. Сначала там будет находиться результат г+1, но, как
              будет показано ниже, содержимое массива number будет
              изменяться после генерирования каждого нового числа.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">result[i] = numbers[n];
</pre>
            <p>
              Теперь следует убедиться, что ни одно число не повторится, т.е. все номера должны быть разными.
              Следовательно, нужно сохранить в элементе массива number [n]
              последнее число, содержащееся в массиве, и уменьшить п на единицу:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">numbers[n] = numbers[n - <span
                class="hljs-number" style="color: rgb(255, 115, 253);">1</span>];
n-- ;
</pre>
            <p>
              Обратите внимание на то, что всякий раз при генерировании чисел получается
              индекс, а не само число. Это индекс массива, содержащего числа, которые еще не
              были выбраны. После генерирования к номеров лотереи сформированный в итоге
              массив result сортируется, чтобы результат выглядел более изящно:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);">Arrays.sort(result);
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; result.length; i++)
    System.out.printIn(result[i]);
</pre>
            <p>
              Листинг 3.7
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(0, 0, 0); color: rgb(248, 248, 248);"><span
                class="hljs-keyword" style="color: rgb(150, 203, 254);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(124, 124, 124);">/**
 * This program demonstrates array manipulation.
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@version</span> 1.20 2004-02-10
 * <span class="hljs-doctag" style="color: rgb(255, 255, 182);">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(255, 255, 182);">LotteryDrawing</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(150, 203, 254);">public</span> <span
       class="hljs-keyword" style="color: rgb(150, 203, 254);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(150, 203, 254);">void</span> <span
       class="hljs-title" style="color: rgb(255, 255, 182);">main</span><span class="hljs-params">(String[] args)</span>
   </span>{
      Scanner in = <span class="hljs-keyword" style="color: rgb(150, 203, 254);">new</span> Scanner(System.in);

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"How many numbers do you need to draw? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> k = in.nextInt();

      System.out.print(<span class="hljs-string" style="color: rgb(168, 255, 96);">"What is the highest number you can draw? "</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> n = in.nextInt();

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// fill an array with numbers 1 2 3 . . . n</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] numbers = <span class="hljs-keyword"
                                                                                                 style="color: rgb(150, 203, 254);">new</span> <span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[n];
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; numbers.length; i++)
         numbers[i] = i + <span class="hljs-number" style="color: rgb(255, 115, 253);">1</span>;

      <span class="hljs-comment"
            style="color: rgb(124, 124, 124);">// draw k numbers and put them into a second array</span>
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[] result = <span class="hljs-keyword"
                                                                                                style="color: rgb(150, 203, 254);">new</span> <span
                  class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span>[k];
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> i = <span
                  class="hljs-number" style="color: rgb(255, 115, 253);">0</span>; i &lt; result.length; i++)
      {
         <span class="hljs-comment" style="color: rgb(124, 124, 124);">// make a random index between 0 and n - 1</span>
         <span class="hljs-keyword" style="color: rgb(150, 203, 254);">int</span> r = (<span class="hljs-keyword"
                                                                                             style="color: rgb(150, 203, 254);">int</span>) (Math.random() * n);

         <span class="hljs-comment" style="color: rgb(124, 124, 124);">// pick the element at the random location</span>
         result[i] = numbers[r];

         <span class="hljs-comment"
               style="color: rgb(124, 124, 124);">// move the last element into the random location</span>
         numbers[r] = numbers[n - <span class="hljs-number" style="color: rgb(255, 115, 253);">1</span>];
         n--;
      }

      <span class="hljs-comment" style="color: rgb(124, 124, 124);">// print the sorted array</span>
      Arrays.sort(result);
      System.out.println(<span class="hljs-string" style="color: rgb(168, 255, 96);">"Bet the following combination. It'll make you rich!"</span>);
      <span class="hljs-keyword" style="color: rgb(150, 203, 254);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(150, 203, 254);">int</span> r : result)
         System.out.println(r);
   }
}
</pre>
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
        int[] a = {4, 5, 0, 5, 16, 8, 20, 1, 5, 14};
        Arrays.sort(a);

        int[] b = Arrays.copyOf(a, 10);
        System.out.println(b[9]);
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
          Ваш ответ: 20
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
  name: "SortingMassive",
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

      selected: 'Zero',
      options: [
        {item: 'Zero', name: '0'},
        {item: 'Twenty', name: '20'},
        {item: 'Exception', name: 'Exception'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/secondchapter/', {
        params: {
          numberTheme: 36,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[1].listThemes[35].task.answer = response.data
              window.frontendData.language.chapters[1].chapterProgress += 2.7
              window.frontendData.language.chapters[1].listThemes[35].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[1].listThemes[35].task.answer

          window.frontendData.language.chapters[1].listThemes[35].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[35].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[1].listThemes[35].task.tryCount++
          window.frontendData.language.chapters[1].listThemes[35].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[1].listThemes[35].task.tryCount + ".",{
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
    if (window.frontendData.language.chapters[1].listThemes[35].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[35].task.answer
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
        int[] a = {4, 5, 0, 5, 16, 8, 20, 1, 5, 14};
        Arrays.sort(a);

        int[] b = Arrays.copyOf(a, 10);
        System.out.println(b[9]);
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

    let themeToClose = document.getElementById('java-2-chapter-10-them-4-subtheme');

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