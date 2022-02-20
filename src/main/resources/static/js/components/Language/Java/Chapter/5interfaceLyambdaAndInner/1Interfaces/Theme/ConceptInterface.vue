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
          Общее представление об интерфейсах
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В последующих разделах поясняется, что собой представляют интерфейсы и как
              ими пользоваться. Кроме того, в этих разделах будет показано, насколько была повышена эффективность
              интерфейсов в версии Java SE 8.
            </p>

            <p>
              Общее представление об интерфейсах
            </p>

            <p>
              Интерфейс в Java не является классом. Он представляет собой ряд требований, предъявляемых к классу,
              который должен соответствовать интерфейсу. Как правило, один
              разработчик, собирающийся воспользоваться трудами другого разработчика для решения конкретной задачи,
              заявляет: "Если ваш класс будет соответствовать определенному
              интерфейсу, я смогу решить свою задачу". Обратимся к конкретному примеру. Метод
              sort () из класса Array позволяет упорядочить массив объектов при одном условии:
              объекты должны принадлежать классам, реализующим интерфейс Comparable.
              Этот интерфейс определяется следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Comparable</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">compareTo</span><span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">(Object other)</span></span>;
}</pre>
            <p>
              Это означает, что любой класс, реализующий интерфейс Comparable, должен содержать метод compareTo (),
              получающий параметр типа Object и возвращающий
              целое значение.

            </p>
            <p>
              Все методы интерфейса автоматически считаются открытыми, поэтому, объявляя
              метод в интерфейсе, указывать модификатор доступа public необязательно. Разумеется, существует и неявное
              требование: метод сошрагеТо () должен на самом деле
              быть способным сравнивать два объекта и возвращать признак того, что один из них
              больше другого. В таком случае этот метод должен возвращать отрицательное числовое значение, если объект
              х меньше объекта у, нулевое значение — если они равны,
              а иначе —• положительное числовое значение.

            </p>

            <p>
              иначе —• положительное числовое значение.
              Данный конкретный интерфейс имеет единственный метод, а у некоторых интерфейсов может быть больше одного
              метода. Как станет ясно в дальнейшем, с помощью интерфейсов можно также объявлять константы. Но важнее не
              это, а то, что
              интерфейсы не могут предоставить. В частности, у них отсутствуют поля экземпляра.
              До версии Java SE 8 в интерфейсах нельзя было реализовывать методы, но теперь
              они могут предоставлять простые методы, как поясняется далее, в разделе 6.1.4. Разумеется, в этих методах
              нельзя ссылаться на поля экземпляра, поскольку они просто
              отсутствуют в интерфейсах.

            </p>

            <p>
              Предоставлять поля экземпляра и оперирующие ими методы — обязанность
              классов, реализующих соответствующий интерфейс. Таким образом, интерфейс можно рассматривать как
              абстрактный класс, лишенный всяких полей экземпляра. Но
              у этих двух понятий имеется существенное отличие, которое будет подробнее проанализировано далее в главе.


            </p>

            <p>
              Допустим теперь, что требуется воспользоваться методом sort () из класса Array
              для сортировки объектов типа Employee. В этом случае класс Employee должен реализовать интерфейс
              Comparable.


            </p>
            <p>
              Для того чтобы класс реализовал интерфейс, нужно выполнить следующие действия.

            </p>
            <ul>
              <li>
                <p>
                  Объявить, что класс реализует интерфейс.

                </p>
              </li>
              <li>
                <p>
                  Определить в классе все методы, указанные в интерфейсе.

                </p>
              </li>
            </ul>

            <p>
              Для объявления реализации интерфейса в классе служит ключевое слово
              implements, как показано ниже
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Comparable</span></span></pre>

            <p>
              Разумеется, теперь нужно реализовать метод сошрагеТо (), например, для сравнения зарплаты сотрудников.
              Ниже приведен код, реализующий метод сошрагеТо ()
              в классе Employee.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">int</span> соmраrеТо(Object otherObject)
{
    Employee other = (Employee) otherObject;
    returnDouble.compare(salary, other.salary) ;
}
</pre>
            <p>
              В этом коде вызывается статический метод Double. compare (), возвращающий отрицательное числовое
              значение, если первый его аргумент меньше второго; нулевое
              значение, если аргументы равны; а иначе — положительное числовое значение.
            </p>
            <p>
              Начиная с версии Java SE 5.0, можно принять более изящное решение, реализовав
              обобщенный интерфейс Comparable и снабдив его параметром типа, как показано
              ниже. Как видите, теперь тип Object не приходится приводить к требуемому типу.

            </p>
            <p>
              Теперь вам должно быть ясно, что для сортировки объектов достаточно реализовать в классе метод compareTo
              (). И такой подход вполне оправдан. Ведь должен же
              существовать какой-то способ воспользоваться методом sort () для сравнения объектов. Но почему бы просто
              не предусмотреть в классе Employee метод compareTo (), не
              реализуя интерфейс Comparable?
            </p>
            <p>
              Дело в том, что Java — строго типизированный язык программирования. При вызове какого-нибудь метода
              компилятор должен убедиться, что этот метод действительно существует. В теле метода sort () могут
              находиться операторы, аналогичные
              следующим:

            </p>
            <p>
              Компилятору должно быть известно, что у объекта а [ i ] действительно имеется
              метод compareTo (). Если переменная а содержит массив объектов, реализующих интерфейс Comparable, то
              существование такого метода гарантируется, поскольку каждый класс, реализующий данный интерфейс, по
              определению должен предоставлять
              метод compareTo ().
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> interfaces;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the use of the Comparable interface.
 * <span class="hljs-doctag">@version</span> 1.30 2004-02-27
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">EmployeeSortTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      Employee[] staff = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3</span>];

      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry Hacker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">35000</span>);
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Carl Cracker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">75000</span>);
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Tony Tester"</span>, <span class="hljs-number"
                                                                                                   style="color: rgb(147, 92, 37);">38000</span>);

      Arrays.sort(staff);

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// print out information about all Employee objects</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Employee e : staff)
         System.out.println(<span class="hljs-string"
                                  style="color: rgb(86, 140, 59);">"name="</span> + e.getName() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span> + e.getSalary());
   }
}</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> interfaces;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Employee</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                  style="color: rgb(37, 127, 173);">Comparable</span>&lt;<span
                  class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>&gt;
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> salary;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String name, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> salary)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.name = name;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.salary = salary;
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
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">raiseSalary</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">double</span> byPercent)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> raise = salary * byPercent / <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100</span>;
      salary += raise;
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Compares employees by salary
    * <span class="hljs-doctag">@param</span> other another Employee object
    * <span class="hljs-doctag">@return</span> a negative value if this employee has a lower salary than
    * otherObject, 0 if the salaries are the same, a positive value otherwise
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">compareTo</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(Employee other)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Double.compare(salary, other.salary);
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
public class Test {
    public static void main(String[] args) {
        Triangle first = new Triangle(5, 10);
        Triangle second = new Triangle(4, 12);

        if (first.compareTo(second) > 0){
            System.out.println("bigger");
        } else {
            System.out.println("less");
        }
    }
}


abstract class Figura implements Comparable<Figura> {

    private int x;

    public Figura(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    abstract public double getSquareValue();
}

class Square extends Figura {
    public Square(int x) {
        super(x);
    }

    @Override
    public double getSquareValue() {
        return getX() * getX();
    }


    @Override
    public int compareTo(Figura o) {
        return Integer.compare(getX(), o.getX());
    }
}

class Triangle extends Figura {
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Triangle triangleObj = (Triangle) obj;

        return getX() == triangleObj.getX()
                && this.h == triangleObj.h;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash * getX();
        hash = 31 * hash * h;

        return hash;
    }

    @Override
    public String toString() {
        return "x value is " + getX() + " h value is " + h;
    }

    @Override
    public double getSquareValue() {
        return 0.5 * h * getX();
    }

    @Override
    public int compareTo(Figura o) {
        return Integer.compare(getX(), o.getX());
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
  name: "ConceptInterface",
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
        {item: 'bigger', name: 'bigger'},
        {item: 'less', name: 'less'},
        {item: 'equal', name: 'equal'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[0].task.answer

          window.frontendData.language.chapters[4].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[0].task.answer
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
        `
public class Test {
    public static void main(String[] args) {
        Triangle first = new Triangle(5, 10);
        Triangle second = new Triangle(4, 12);

        if (first.compareTo(second) > 0){
            System.out.println("bigger");
        } else {
            System.out.println("less");
        }
    }
}


abstract class Figura implements Comparable<Figura> {

    private int x;

    public Figura(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    abstract public double getSquareValue();
}

class Square extends Figura {
    public Square(int x) {
        super(x);
    }

    @Override
    public double getSquareValue() {
        return getX() * getX();
    }


    @Override
    public int compareTo(Figura o) {
        return Integer.compare(getX(), o.getX());
    }
}

class Triangle extends Figura {
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Triangle triangleObj = (Triangle) obj;

        return getX() == triangleObj.getX()
                && this.h == triangleObj.h;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash * getX();
        hash = 31 * hash * h;

        return hash;
    }

    @Override
    public String toString() {
        return "x value is " + getX() + " h value is " + h;
    }

    @Override
    public double getSquareValue() {
        return 0.5 * h * getX();
    }

    @Override
    public int compareTo(Figura o) {
        return Integer.compare(getX(), o.getX());
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

    let themeToClose = document.getElementById('java-5-chapter-1-theme-1-subtheme');

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