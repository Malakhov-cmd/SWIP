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
          Блоки инициализации
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Ранее мы рассмотрели два способа инициализации поля:
            </p>
            <ul>
              <li>
                <p>
                  установка его значения в конструкторе;
                </p>
              </li>
              <li>
                <p>
                  присваивание значения при объявлении.
                </p>
              </li>
            </ul>
            <p>
              На самом деле в Java существует еще и третий механизм: использование блока
              инициализации. Такой блок выполняется всякий раз, когда создается объект данного
              класса. Рассмотрим следующий пример кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> nextld;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> id;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">double</span> salary;
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// блок инициализации </span>
    {
        id = nextld;
        nextld++;
    }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">(String n, <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> s)</span>
    </span>{
        name = n;
        salary = s;
    }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">()</span>
    </span>{
        name = ;
        salary = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
    }
}</pre>
            <p>
              В этом примере начальное значение поля id задается в блоке инициализации объекта, причем неважно, какой
              именно конструктор используется для создания экземпляра
              класса. Блок инициализации выполняется первым, а вслед за ним — тело конструктора.
              Этот механизм совершенно не обязателен и обычно не применяется. Намного чаще применяются более понятные
              способы задания начальных значений полей.

            </p>

            <p>
              При таком многообразии способов инициализации полей данных довольно трудно отследить все возможные пути
              процесса конструирования объектов. Поэтому рассмотрим подробнее те действия, которые происходят при
              вызове конструктора.

            </p>
            <ul>
              <li>
                <p>
                  Все поля инициализируются значениями, предусмотренными по умолчанию
                  (О, false или null).

                </p>
              </li>
              <li>
                <p>
                  Инициализаторы всех полей и блоки инициализации выполняются в порядке
                  их следования в объявлении класса.
                </p>>
              </li>
              <li>
                <p>
                  Если в первой строке кода одного конструктора вызывается другой конструктор, то выполняется
                  вызываемый конструктор.
                </p>
              </li>
              <li>
                <p>
                  Выполняется тело конструктора.
                </p>
              </li>
            </ul>

            <p>
              Естественно, что код, отвечающий за инициализацию полей, нужно организовать
              так, чтобы в нем было легко разобраться. Например, было бы странным, если бы вызов конструкторов класса
              зависел от порядка объявления полей. Такой подход чреват
              ошибками.
            </p>

            <p>
              Инициализировать статическое поле следует, задавая его начальное значение или
              используя статический блок инициализации. Первый механизм уже рассматривался
              ранее, а его пример приведен ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">int</span> nextld = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">1</span>;</pre>
            <p>
              Если для инициализации статических полей класса требуется сложный код, то
              удобнее использовать статический блок инициализации. Для этого следует разместить код в блоке и пометить
              его ключевым словом s t a t ic . Допустим, идентификационные номера работников должны начинаться со
              случайного числа, не превышающего 10000. Соответствующий блок инициализации будет выглядеть следующим
              образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// Статический блок инициализации </span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span>
{
Random generator = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> RandomO;
nextld = generator.nextlnt(<span class="hljs-number" style="color: rgb(147, 92, 37);">10000</span>);
}</pre>


            <p>
              Статическая инициализация выполняется в том случае, если класс загружается
              впервые. Аналогично полям экземпляра, статические поля принимают значения 0,
              false или null, если не задать другие значения явным образом. Все операторы, задающие начальные значения
              статических полей, а также статические блоки инициализации выполняются в порядке их перечисления в
              объявлении класса.
            </p>
            <p>
              В программе, приведенной в листинге 4.5, наглядно демонстрируются многие языковые средства Java,
              обсуждавшиеся в этом разделе, включая следующие.
            </p>
            <ul>
              <li>
                <p>
                  Перегрузка конструкторов.
                </p>
              </li>
              <li>
                <p>
                  Вызов одного конструктора из другого по ссылке this (...).
                </p>
              </li>
              <li>
                <p>
                  Применение конструктора без аргументов.
                </p>
              </li>
              <li>
                <p>
                  Применение блока инициализации.
                </p>
              </li>
              <li>
                <p>
                  Применение статической инициализации.
                </p>
              </li>
              <li>
                <p>
                  Инициализация полей экземпляра.
                </p>
              </li>
            </ul>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates object construction.
 * <span class="hljs-doctag">@version</span> 1.01 2004-02-19
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">ConstructorTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// fill the staff array with three Employee objects</span>
      Employee[] staff = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3</span>];

      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry"</span>, <span class="hljs-number"
                                                                                             style="color: rgb(147, 92, 37);">40000</span>);
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">60000</span>);
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee();

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// print out information about all Employee objects</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Employee e : staff)
         System.out.println(<span class="hljs-string"
                                  style="color: rgb(86, 140, 59);">"name="</span> + e.getName() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",id="</span> + e.getId() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span>
               + e.getSalary());
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> nextId;

   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> id;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name = <span class="hljs-string"
                                                                                                    style="color: rgb(86, 140, 59);">""</span>; <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// instance field initialization</span>
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> salary;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">// static initialization block</span>
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span>
   {
      Random generator = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Random();
      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// set nextId to a random number between 0 and 9999</span>
      nextId = generator.nextInt(<span class="hljs-number" style="color: rgb(147, 92, 37);">10000</span>);
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">// object initialization block</span>
   {
      id = nextId;
      nextId++;
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">// three overloaded constructors</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String n, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> s)</span>
   </span>{
      name = n;
      salary = s;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(<span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> s)</span>
   </span>{
      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// calls the Employee(String, double) constructor</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>(<span class="hljs-string"
                                                                                      style="color: rgb(86, 140, 59);">"Employee #"</span> + nextId, s);
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">// the default constructor</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// name initialized to ""--see above</span>
      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// salary not explicitly set--initialized to 0</span>
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// id initialized in initialization block</span>
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getName</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> name;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                   style="color: rgb(37, 127, 173);">getSalary</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> salary;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">getId</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> id;
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
    public static void main(String[] args) {
        Cube cube = new Cube();

        System.out.println(cube.getFigureName());
    }
}

class Cube {
    private int x;
    private int y;
    private int z;

    private String figureName = "";

    {
        figureName = "Cube initial";
    }

    public Cube(){
        this(2,2,2);
    }

    public Cube(int x, int y, int z) {
        this(x, y,z,"Cube");
    }

    public Cube(int x, int y, int z, String figureName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.figureName = figureName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public int getValue() {
        return this.x * this.y * this.z;
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
  name: "BlocksInitialization",
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
        {item: 'Cube', name: 'Cube'},
        {item: 'null', name: 'null'},
        {item: 'Cube initial', name: 'Cube initial'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 19,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[18].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[18].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[18].task.answer

          window.frontendData.language.chapters[2].listThemes[18].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[18].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[18].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[18].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[18].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[18].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[18].task.answer
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
        Cube cube = new Cube();

        System.out.println(cube.getFigureName());
    }
}

class Cube {
    private int x;
    private int y;
    private int z;

    private String figureName = "";

    {
        figureName = "Cube initial";
    }

    public Cube(){
        this(2,2,2);
    }

    public Cube(int x, int y, int z) {
        this(x, y,z,"Cube");
    }

    public Cube(int x, int y, int z, String figureName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.figureName = figureName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public int getValue() {
        return this.x * this.y * this.z;
    }
}`)

    this.timeStarted = Date.now()

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-6-theme-3-subtheme');

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