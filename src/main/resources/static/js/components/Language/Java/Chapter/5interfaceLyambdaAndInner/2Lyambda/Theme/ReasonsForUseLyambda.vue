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
          Синтаксис и причины для уподребления лямбда-выражений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              А теперь можно приступить к рассмотрению лямбда-выражений — самого привлекательного изменения в языке
              Java за последние годы. В этом разделе будет показано, как пользоваться лямбда-выражениями для
              определения блоков кода с помощью лаконичного синтаксиса и как писать прикладной код, в котором
              употребляются
              лямбда-выражения.
            </p>

            <p>
              Причины для употребления лямбда-выражений

            </p>

            <p>
              Лямбда-выражение — это блок кода, который передается для последующего выполнения один или несколько раз.
              Прежде чем рассматривать синтаксис (или даже
              любопытное название) лямбда-выражений, вернемся немного назад, чтобы выяснить,
              где именно мы уже пользовались подобными блоками кода в Java.

            </p>

            <p>
              В разделе 6.2.1 было показано, как обращаться с устанавливаемыми промежутками времени. Для этого
              достаточно ввести нужные операторы в тело метода
              actionPerformed () из интерфейса ActionListener, реализуемого в конкретном
              классе:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Worker</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">ActionListener</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">actionPerformed</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span>
    </span>{
          <span class="hljs-comment" style="color: rgb(113, 149, 168);">// сделать что-нибудь</span>
    }
}</pre>

            <p>
              Когда же этот код потребуется выполнить повторно, для этого достаточно получить экземпляр класса Worker,
              а затем передать его объекту типа Timer при его построении. Но самое главное, что метод actionPerform ed
              () содержит код, который
              требуется выполнить не сразу, а впоследствии.

            </p>

            <p>
              А в разделе 6.2.2 рассматривалась сортировка с помощью специального компаратора. Так, если требуется
              отсортировать символьные строки по длине, а не в выбираемом по умолчанию лексикографическом порядке, то
              методу sort () можно передать
              объект класса, реализующего интерфейс Comparator, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">LengthComparator</span> <span class="hljs-keyword"
                                                                                                   style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Comparator</span>&lt;<span class="hljs-title"
                                                                                                style="color: rgb(37, 127, 173);">String</span>&gt; </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">compare</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(String first, String second)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> first.length() - second.length();
    }
}</pre>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Arrays.sort(strings, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LengthComparator());
</pre>
            <p>
              Метод compare () вызывается из метода so rt () не сразу, а лишь тогда, когда требуется перестроить
              элементы в нужном порядке при сортировке массива. С этой целью методу so rt () предоставляется блок кода,
              требующийся для сравнения элементов, и этот код настолько интегрирован в остальную часть логики, что о
              повторной
              его реализации можно даже не беспокоиться.

            </p>

            <p>
              У обоих рассмотренных здесь примеров имеется нечто общее: блок кода, передаваемый таймеру или методу s o
              rt (). И этот блок кода вызывается не сразу, а впоследствии. До версии Java SE 8 передать блок кода на
              выполнение было не так-то
              просто. Ведь Java — объектно-ориентированный язык программирования, и поэтому программирующим на нем
              приходится конструировать объект, принадлежащий
              определенному классу, где имеется метод с нужным кодом.

            </p>
            <p>
              В других языках программирования допускается непосредственная передача блоков кода. Но разработчики долго
              противились внедрению такой возможности в Java.
              Ведь главная сила языка Java — в его простоте и согласованности. Этот язык может
              прийти в полный беспорядок, если внедрять в него каждое средство для получения
              чуть более лаконичного кода. И хотя в других языках программирования не так просто породить поток
              исполнения или зарегистрировать обработчик событий от щелчка кнопкой мыши, тем не менее их прикладные
              программные интерфейсы API
              в основном оказываются более простыми, согласованными и эффективными. Аналогичный прикладной интерфейс
              API, принимающий объекты классов, реализующих
              конкретную функцию, можно было бы написать и на Java, но пользоваться таким
              прикладным интерфейсом API было бы неудобно.

            </p>

            <p>
              И в какой-то момент пришлось решать не столько вопрос об усовершенствовании
              Java для функционального программирования, сколько вопрос о том, как это сделать.
              На выработку проектного решения, подходящего для Java, ушло несколько лет экспериментирования. В
              следующем разделе будет показано, как обращаться с блоками
              кода в версии Java SE 8.

            </p>


            <p>
              Синтаксис лямбда-выражений
            </p>

            <p>
              Обратимся снова к примеру сортировки символьных строк из раздела 6.2.2. В этом
              примере определяется, является ли одна символьная строка короче другой. С этой
              целью вычисляется следующее выражение:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">first.length() - second.length(</pre>

            <p>
              А что обозначают ссылки first и second? Они обозначают символьные строки.
              Язык Java является строго типизированным, и поэтому приведенное выше выражение можно написать следующим
              образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">(String first, String second) -&gt; first.length() - second.length()
</pre>
            <p>
              Собственно говоря, это и есть лямбда-выражение. Такое выражение представляет
              собой блок кода вместе с указанием любых переменных, которые должны быть переданы коду.

            </p>
            <p>
              А почему оно так называется? Много лет назад, задолго до появления компьютеров, математик и логик Алонсо
              Черч (Alonzo Church) формализовал, что же должно означать эффективное выполнение математической функции.
              (Любопытно, что
              имеются такие функции, о существовании которых известно, но никто не знает, как
              вычислить их значения.) Он употребил греческую букву лямбда (X) для обозначения
              параметров функции аналогично следующему:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">lfirst. lsecond. first.length() - second.length()</pre>
            <p>
              Выше была приведена одна из форм лямбда-выражений в Java. Она состоит из
              параметров, знака стрелки -> и вычисляемого выражения. Если же в теле лямбда-выражения должно быть
              выполнено вычисление, которое не вписывается в одно выражение, его можно написать точно так же, как и
              тело метода, заключив в фигурные
              скобки {} и явно указав операторы return, как в следующем примере кода
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">(String first,String second)-&gt;
        {
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span>(first.length()&lt;second.length())<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span>-<span class="hljs-number"
                                                                                              style="color: rgb(147, 92, 37);">1</span>;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">if</span>(first.length()&gt;second.length())<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-number"
                                                                                              style="color: rgb(147, 92, 37);">1</span>;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">else</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
        }
        );</pre>
            <p>
              В отсутствие параметров у лямбда-выражения следует указать пустые круглые
              скобки, как при объявлении метода без параметров:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">() -&gt; { <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">int</span> i = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">100</span>; i &gt;= <span class="hljs-number"
                                                                                               style="color: rgb(147, 92, 37);">0</span>; i--) System.out.println(i); }
</pre>
            <p>
              Если же типы параметров лямбда-выражения могут быть выведены, их можно
              опустить, как в следующем примере кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    Comparator&lt;String&gt; comp
            = (first, second) <span class="hljs-comment" style="color: rgb(113, 149, 168);">// To же, что и (String first, String second)</span>
            -&gt; first.length() - second.length();</pre>
            <p>
              В данном примере компилятор может сделать вывод, что ссылки first и second
              должны обозначать символьные строки, поскольку результат вычисления лямбда-выражения присваивается
              компаратору символьных строк. (Эту операцию присваивания мы рассмотрим более подробно в следующем
              разделе.)
            </p>
            <p>
              Если у метода имеется единственный параметр выводимого типа, то можно даже
              опустить круглые скобки, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    ActionListener listener = event -&gt;
            System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"The time is "</span> + <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date()<span class="hljs-string"
                                                                                                 style="color: rgb(86, 140, 59);">");
                // Вместо выражения (event) -&gt; или (ActionEvent event) -&gt; . . .</span></pre>
            <p>
              Результат вычисления лямбда-выражения вообще не указывается. Тем не менее
              компилятор выводит его из тела лямбда-выражения и проверяет, соответствует ли он
              ожидаемому результату. Например, выражение
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">String first, String second) -&gt; first.length() - second.length() </pre>
            <p>
              может быть использовано в контексте, где ожидается результат типа int.
            </p>


            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> lambda;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> javax.swing.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> javax.swing.Timer;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the use of lambda expressions.
 * <span class="hljs-doctag">@version</span> 1.0 2015-05-12
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">LambdaTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      String[] planets = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> String[] { <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Mercury"</span>, <span class="hljs-string"
                                                                                               style="color: rgb(86, 140, 59);">"Venus"</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Earth"</span>, <span class="hljs-string"
                                                                                             style="color: rgb(86, 140, 59);">"Mars"</span>,
            <span class="hljs-string" style="color: rgb(86, 140, 59);">"Jupiter"</span>, <span class="hljs-string"
                                                                                               style="color: rgb(86, 140, 59);">"Saturn"</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Uranus"</span>, <span class="hljs-string"
                                                                                              style="color: rgb(86, 140, 59);">"Neptune"</span> };
      System.out.println(Arrays.toString(planets));
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Sorted in dictionary order:"</span>);
      Arrays.sort(planets);
      System.out.println(Arrays.toString(planets));
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Sorted by length:"</span>);
      Arrays.sort(planets, (first, second) -&gt; first.length() - second.length());
      System.out.println(Arrays.toString(planets));

      Timer t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(<span class="hljs-number"
                                                                                                     style="color: rgb(147, 92, 37);">1000</span>, event -&gt;
         System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"The time is "</span> + <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date()));
      t.start();

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// keep program running until user selects "Ok"</span>
      JOptionPane.showMessageDialog(<span class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>, <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Quit program?"</span>);
      System.exit(<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>);
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
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Square> figuresList = new ArrayList<>(Arrays.asList(
                new Square(1),
                new Square(2),
                new Square(3),
                new Square(2),
                new Square(4)
        ));

        figuresList.removeIf(item -> (item.getX() == 2));

        figuresList.forEach(item -> System.out.print(item.toString() + " "));
    }
}

interface Figure{
    int getX();

    int getValue();

    default String getDescription() {
        return "Instanse of Figure interface";
    }
}

class Square implements Figure {
    private int x;

    public Square(int x) {
        this.x = x;
    }

    @Override
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getValue() {
        return (int) Math.pow(x, 2);
    }

    @Override
    public String toString() {
        return "x=" + x;
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
  name: "ReasonsForUseLyambda",
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

      selected: 'x=1 x=3 x=4',
      options: [
        {item: 'x=1 x=3 x=4', name: 'x=1 x=3 x=4'},
        {item: 'x=1 x=2 x=3 x=4', name: 'x=1 x=2 x=3 x=4'},
        {item: 'x=1 x=2 x=3 x=2 x=4', name: 'x=1 x=2 x=3 x=2 x=4'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[3].task.answer

          window.frontendData.language.chapters[4].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[3].task.answer
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
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Square> figuresList = new ArrayList<>(Arrays.asList(
                new Square(1),
                new Square(2),
                new Square(3),
                new Square(2),
                new Square(4)
        ));

        figuresList.removeIf(item -> (item.getX() == 2));

        figuresList.forEach(item -> System.out.print(item.toString() + " "));
    }
}

interface Figure{
    int getX();

    int getValue();

    default String getDescription() {
        return "Instanse of Figure interface";
    }
}

class Square implements Figure {
    private int x;

    public Square(int x) {
        this.x = x;
    }

    @Override
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getValue() {
        return (int) Math.pow(x, 2);
    }

    @Override
    public String toString() {
        return "x=" + x;
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

    let themeToClose = document.getElementById('java-5-chapter-2-theme-1-subtheme');

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