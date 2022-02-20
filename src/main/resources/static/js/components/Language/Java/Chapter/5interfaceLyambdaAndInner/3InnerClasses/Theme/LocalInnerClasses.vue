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
          Локальные внутренние классы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Если внимательно проанализировать исходный код класса TalkingClock, то можно обнаружить, что имя класса
              Time Printer используется лишь однажды: при создании объекта данного типа в методе start (). В подобных
              случаях класс можно определить локально в отдельном методе, как выделено ниже полужирн
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">start</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">TimePrinter</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">implements</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">ActionListener</span> </span>{
            <span class="hljs-function"><span class="hljs-keyword"
                                              style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">actionPerformed</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span> </span>{
                Date now = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date();
                System.out.println(”At the tone, the time is ” + now);
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TimePrinter();
        Timer t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(interval, listener);
        t.start();
    }</pre>
            <p>
              Локальные внутренние классы никогда не объявляются с помощью модификаторов доступа (например, public и
              protected). Их область действия всегда ограничивается блоком, в котором они объявлены. У локальных
              внутренних классов имеется
              следующее большое преимущество: они полностью скрыты от внешнего кода и даже
              от остальной части класса TalkingClock. Ни одному из методов, за исключением
              start (), ничего неизвестно о классе TimePrinter.

            </p>

            <p>
              Доступ к конечным переменным из внешних методов
            </p>
            <p>
              Локальные внутренние классы выгодно отличаются от обычных внутренних классов еще и тем, что имеют доступ
              не только к полям своего внешнего класса, но и к локальным переменным! Но такие локальные переменные
              должны быть объявлены как
              действительно конечные. Это означает, что такие переменные нельзя изменить после
              их инициализации путем присваивания им первоначальных значений. Обратимся
              к характерному примеру, переместив параметры interval и beep из конструктора
              TalkingClock в метод start (), как выделено ниже полужирным.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">start</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">int</span> interval, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> beep)</span> </span>{
        <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">TimePrinter</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">implements</span> <span
            class="hljs-title" style="color: rgb(37, 127, 173);">ActionListener</span> </span>{
            <span class="hljs-function"><span class="hljs-keyword"
                                              style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">actionPerformed</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(ActionEvent event)</span> </span>{
                System, out.<span class="hljs-function">pr in <span class="hljs-title"
                                                                    style="color: rgb(37, 127, 173);">tin</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-string"
                                                                              style="color: rgb(86, 140, 59);">"At the tone, the time is "</span> + new DateO)</span></span>;
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> TimePrinter();
        Timer t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Timer(interval, listener);
        t.start();
    }</pre>

            <p>
              Обратите внимание на то, что в классе TimePrinter больше не нужно хранить переменную экземпляра beep. Он
              просто ссылается на параметр метода, содержащего
              определение данного класса. Возможно, это не так уж и неожиданно. В конце концов,
              приведенная ниже строка кода находится в теле метода start (), так почему бы не
              иметь в ней доступ к переменной beep?
            </p>

            <p>
              Локальные внутренние классы обладают рядом особенностей. Чтобы понять их,
              рассмотрим подробнее логику их управления.
            </p>
            <ul>
              <li>
                <p>
                  Вызывается метод start ().
                </p>
              </li>
              <li>
                <p>
                  При вызове конструктора внутреннего класса TimePrinter инициализируется
                  объектная переменная listener.
                </p>
              </li>
              <li>
                <p>
                  Передается ссылка listener конструктору класса Timer, запускается таймер,
                  и метод start () прекращает свою работу. В этот момент параметр beep метода start () больше не
                  существует.

                </p>
              </li>
              <li>
                <p>
                  Некоторое время спустя выполняется условный оператор if (beep) . . . в методе actionPerformed( ) .
                </p>
              </li>
            </ul>
            <p>
              Для того чтобы метод actionPerformed () выполнялся успешно, в классе
              TimePrinter должна быть создана копия поля beep до того, как оно перестанет существовать в качестве
              локальной переменной метода start (). Именно это и происходит. В данном примере компилятор синтезирует
              для локального внутреннего класса имя TalkingClock$lTimePrinter. Если применить снова программу
              ReflectionTest для анализа класса TalkingClock$lTimePrinter, то получится следующий результат:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">TalkingClock</span>$<span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">lTimePrinter</span>
</span>{
    TalkingClock$lTimePrinter(TalkingClock, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span>);
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">actionPerformed</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(java.awt.event.ActionEvent)</span></span>;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">boolean</span> val$beep;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> TalkingClock <span class="hljs-keyword"
                                                                                                  style="color: rgb(107, 107, 184);">this</span>$<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
}</pre>
            <p>
              Обратите внимание на параметр конструктора, имеющий тип boolean, а также
              переменную экземпляра val$beep. При создании объекта переменная beep передается конструктору и
              размещается в поле val$beep. Чтобы это стало возможным,
              разработчикам компилятора пришлось немало потрудиться. Компилятор должен
              обнаруживать доступ к локальным переменным, создавать для каждой из них соответствующие поля, а затем
              копировать локальные переменные в конструкторе таким
              образом, чтобы поля данных инициализировались копиями локальных переменных.

            </p>
            <p>
              С точки зрения разработчика прикладных программ доступ к локальным переменным выглядит привлекательно.
              Благодаря такой возможности вложенные классы
              становятся проще и уменьшается количество полей, которые должны программироваться явным образом.
            </p>

            <p>
              Как упоминалось выше, методы локального класса могут ссылаться только на локальные переменные,
              объявленные как final. По этой причине параметр beep в рассматриваемом здесь примере был объявлен
              конечным (т.е. final). Конечная локальная
              переменная не может быть видоизменена. Этим гарантируется, что локальная переменная и ее копия, созданная
              в локальном классе, всегда имеют одно и то же значение.

            </p>


            <p>
              Ограничение на действительную конечность переменных не совсем удобно. Допустим, требуется обновить
              счетчик в объемлющей области действия, чтобы подсчитать, насколько часто во время сортировки вызывается
              метод compareTo ():

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> counter = <span class="hljs-number"
                                                                                                   style="color: rgb(147, 92, 37);">0</span>;
        Date[] dates = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100</span>];
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span>(<span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> i=<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;i&lt;dates.length;i++)
            dates[i]=<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date()
            {
                <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">compareTo</span><span
                    class="hljs-params" style="color: rgb(147, 92, 37);">(Date other)</span>
                </span>{
                    counter++; <span class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
                    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.compareTo(other);
                }
            };
        Arrays.sort(dates);
        System.out.println(counter+<span class="hljs-string"
                                         style="color: rgb(86, 140, 59);">" comparisons."</span>);</pre>
            <p>
              Объявить переменную counter как final нельзя. Ведь совершенно очевидно, что
              ее придется обновлять. Ее тип нельзя заменить и на Integer, поскольку объекты типа
              Integer неизменяемы. В качестве выхода из этого положения можно воспользоваться
              массивом длиной в 1 элемент, как выделено ниже полужирным.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">int</span>[] counter = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">int</span>[l];
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; dates.length; i++)
            dates[i] = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date()
            {
                <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                    class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">compareTo</span><span
                    class="hljs-params" style="color: rgb(147, 92, 37);">(Date other)</span>
                </span>{
                    counter[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>]++;
                    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.compareTo(other);
                };</pre>
            <p>
              Когда впервые были внедрены внутренние классы, в прототипной версии компилятора подобное преобразование
              автоматически выполнялось для всех локальных
              переменных, модифицировавшихся во внутреннем классе. Но это правило в дальнейшем было отменено из
              соображений безопасности. Так, если код внутренн
              одновременно выполняется в нескольких потоках, то параллельные обновления переменных могут привести к
              состоянию гонок (подробнее об этом — в главе 14).
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
        Square square = new Square();

        System.out.println(square.valueSquare());
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

    public Square() {

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

    public int valueSquare() {
        class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        List<Point> pointsList = new ArrayList<>(
                Arrays.asList(
                        new Point(0, 0),
                        new Point(2, 0),
                        new Point(0, 2),
                        new Point(2, 2)

                )
        );

        int xLine = pointsList.get(1).x - pointsList.get(0).x;
        int yline = pointsList.get(2).y - pointsList.get(1).y;

        return xLine * yline;
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
  name: "LocalInnerClasses",
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
        {item: '0', name: '0'},
        {item: '2', name: '2'},
        {item: '4', name: '4'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[7].task.answer

          window.frontendData.language.chapters[4].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[7].task.answer
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
        Square square = new Square();

        System.out.println(square.valueSquare());
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

    public Square() {

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

    public int valueSquare() {
        class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        List<Point> pointsList = new ArrayList<>(
                Arrays.asList(
                        new Point(0, 0),
                        new Point(2, 0),
                        new Point(0, 2),
                        new Point(2, 2)

                )
        );

        int xLine = pointsList.get(1).x - pointsList.get(0).x;
        int yline = pointsList.get(2).y - pointsList.get(1).y;

        return xLine * yline;
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

    let themeToClose = document.getElementById('java-5-chapter-3-theme-2-subtheme');

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