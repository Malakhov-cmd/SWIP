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
          Ссылки на методы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Иногда уже имеется метод, выполняющий именно то действие, которое требуется
              передать какому-нибудь другому коду. Допустим, требуется просто выводить объект
              события от таймера всякий раз, когда это событие наступает. Безусловно, для этого
              можно было бы сделать следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Timer t = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(<span class="hljs-number"
                                                                                               style="color: rgb(147, 92, 37);">1000</span>, event -&gt; System.out.println(event));</pre>
            <p>
              Но было бы лучше просто передать метод println () конструктору класса Timer.
              И сделать это можно следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Timer t = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer (<span class="hljs-number"
                                                                                                style="color: rgb(147, 92, 37);">1000</span>, System.out::println) </pre>
            <p>
              Выражение System, out: : println обозначает ссылку на метод, которая равнозначна лямбда-выражению х ->
              System, out. println (х). В качестве еще одного примера допустим, что требуется отсортировать символьные
              строки независимо от регистра букв. Этому методу можно передать следующее выражение:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Arrays.sort(strings, String::compareToIgnoreCase)
</pre>
            <p>
              Как следует из приведенных выше примеров, операция :: отделяет имя метода
              от имени класса или объекта. Ниже приведены три разновидности этой операции.

            </p>
            <ul>
              <li>
                <p>
                  Объект: :МетодЭкземпляра
                </p>
              </li>
              <li>
                <p>
                  Класс:: СтатическийМетод
                </p>
              </li>
              <li>
                <p>
                  Класс: :МетодЭкземпляра
                </p>
              </li>
            </ul>

            <p>
              В первых двух случаях ссылка на метод равнозначна лямбда-выражению, снабжающему метод параметрами. Как
              упоминалось выше, ссылка на метод System,
              out: : println равнозначна лямбда-выражению х -> System.out.println (х). Аналогично ссылка на метод Math:
              :pow равнозначна лямбда-выражению (х, у) ->
              Math.pow(x, у).
            </p>

            <p>
              А в третьем случае первый параметр становится целевым для метода. Например,
              ссылка на метод String: : compareToIgnoreCase равнозначна лямбда-выражению
              (х, у) -> х.compareToIgnoreCase(у ).

            </p>

            <p>
              В ссылке на метод допускается указывать ссылку this. Например, ссылка на метод
              this:: equals равнозначна лямбда-выражению х -> this. equals (х). Это же относится и к ссылке super. Так,
              в следующей ссылке на метод:
              . super::МетодЗкземпляра
              ссылка super является целевой и вызывает вариант заданного метода экземпляра из
              суперкласса. Ниже приведен искусственный пример, который, впрочем, наглядно демонстрирует подобный
              механизм ссылок.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Greeter</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">greet</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Hello, world!"</span>);
        <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">TimedGreeter</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">extends</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">Greeter</span> </span>{
            <span class="hljs-function"><span class="hljs-keyword"
                                              style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">greet</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
                Timer t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>, <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">super</span>::greet );
                t.start();
            }
        }
    }
}</pre>
            <p>
              При вызове метода TimedGreeter. greet () конструируется объект типа Timer, делающий ссылку на метод
              super::greet каждый такт работы таймера. В теле этого
              метода вызывается метод greet () из суперкласса
            </p>
            <p>
              Ссылки на конструкторы

            </p>

            <p>
              Ссылки на конструкторы действуют таким же образом, как и ссылки на методы,
              за исключением того, что вместо имени метода указывается операция new. Например, ссылка Person: :new
              делается на конструктор класса Person. Если же у класса
              имеется несколько конструкторов, то конкретный конструктор выбирается по ссылке
              в зависимости от контекста

            </p>


            <p>
              Рассмотрим пример, демонстрирующий применение ссылки на конструктор. Допустим, имеется список символьных
              строк. Его можно преобразовать в массив объектов класса Person, вызывая конструктор этого класса для
              каждой символьной строки
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ArrayList&lt;String&gt; names = . . .;
Stream&lt;Person&gt; stream = names . stream() .map (Person: :<span class="hljs-keyword"
                                                                    style="color: rgb(107, 107, 184);">new</span>) ;
List&lt;Person&gt; people = stream.collect(Collectors.toList());</pre>
            <p>
              Более подробно методы stream (), map () и collect () будут рассматриваться в главе 1 второго тома
              настоящего издания, а до тех пор достаточно сказать, что для каждого элемента списка в методе тар ()
              вызывается конструктор Person (String). Если
              же у класса Person имеется несколько конструкторов, компилятор выбирает среди
              них конструктор с параметром типа String, поскольку он заключает из контекста,
              что конструктор должен вызываться с символьной строкой

            </p>
            <p>
              Ссылки на конструкторы можно формировать вместе с типами массивов. Например, ссылка на конструктор int [
              ] : :new делается с одним параметром длины массива. Она равнозначна лямбда-выражению х -> new int [х ].

            </p>

            <p>
              Ссылки на конструкторы массивов удобны для преодоления следующего ограничения: в Java нельзя построить
              массив обобщенного типа Т. Так, выражение new Т [п]
              ошибочно, поскольку оно будет приведено путем стирания типов к выражению new
              Object [n]. У создателей библиотек это вызывает определенные затруднения. Допустим, требуется создать
              массив из объектов типа Person. В интерфейсе Stream имеется метод toArray (), возвращающий массив типа
              Object, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Object[] people = stream.toArray();</pre>
            <p>
              Но этого явно недостаточно. Пользователю требуется массив ссылок на объекты
              типа Person, а не на объекты типа Object. В библиотеке потоков данных это затруднение разрешается с
              помощью ссылок на конструкторы. Достаточно передать методу
              toArray () следующую ссылку на конструктор Person [ ] : : new:


            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Person [] people = stream. toArray (Person[] : :<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span>) ;
</pre>
            <p>
              чтобы вызвать этот конструктор в методе toArray () и получить в итоге массив нужного типа. Этот массив
              будет далее заполнен объектами типа Person и возвращен
              вызывающей части программы.

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
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Square> figuresList = new ArrayList<>(Arrays.asList(
                new Square(1),
                new Square(2),
                new Square(3),
                new Square(2),
                new Square(4)
        ));

        figuresList.forEach(System.out::print);
    }
}

interface Figure {
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
  name: "LinkToTheMethods",
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
        {item: 'Exception', name: 'Exception'},
        {item: 'x=1x=2x=3x=2x=4', name: 'x=1x=2x=3x=2x=4'},
        {item: 'x=1 x=2 x=3 x=2 x=4', name: 'x=1 x=2 x=3 x=2 x=4'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/fifthchapter/', {
        params: {
          numberTheme: 6,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[5].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[5].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[5].task.answer

          window.frontendData.language.chapters[4].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[5].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[5].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[5].task.answer
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

        figuresList.forEach(System.out::print);
    }
}

interface Figure {
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

    let themeToClose = document.getElementById('java-5-chapter-2-theme-3-subtheme');

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