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
          Метод hashCode()
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Хеш-код — это целое число, генерируемое на основе конкретного объекта. Хеш-код
              можно рассматривать как некоторый шифр: если х и у — разные объекты, то с большой степенью вероятности
              должны различаться результаты вызовов х . hashCode ()
              и у. hashCode (). В табл. 5.1 приведено несколько примеров хеш-кодов, полученных
              в результате вызова метода hashCode () из класса String.
            </p>

            <p>
              Для вычисления хеш-кода в классе String применяется следующий алгоритм:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> hash = <span class="hljs-number"
                                                                                                style="color: rgb(147, 92, 37);">0</span>;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; lengthO; i++)
hash = <span class="hljs-number" style="color: rgb(147, 92, 37);">31</span> * hash + charAt(i);
</pre>
            <p>
              Метод hashCode () определен в классе Object. Поэтому у каждого объекта имеется хеш-код, определяемый по
              умолчанию. Этот хеш-код вычисляется по адресу памяти, занимаемой объектом. Рассмотрим следующий пример
              кода:

            </p>

            <p>
              Если переопределяется метод equals (), то следует переопределить и метод
              hashCode () для объектов, которые пользователи могут вставлять в хеш-таблицу.
              (Подробнее хеш-таблицы будут обсуждаться в главе 9.)

            </p>
            <p>
              Метод hashCode () должен возвращать целочисленное значение, которое может
              быть отрицательным. Чтобы хеш-коды разных объектов отличались, достаточно объединить хеш-коды полей
              экземпляра. Ниже приведен пример реализации метода
              hashCode в классе Employee.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">hashCode</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">7</span> * name.hashCode()
                + <span class="hljs-number" style="color: rgb(147, 92, 37);">11</span> * <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">new</span> Double(salary).hashCode()
                + <span class="hljs-number" style="color: rgb(147, 92, 37);">13</span> * hireDay.hashCode();
    }
}</pre>
            <p>
              Но то же самое можно сделать лучше. Во-первых, можно воспользоваться методом
              Objects. hashCode (), безопасно обрабатывающим пустые значения. В частности, он возвращает нуль, если его
              аргумент имеет пустое значение null, а иначе — результат вызова
              метода hashCode () для заданного аргумента. Чтобы не создавать объект Double, можно
              также вызвать статический метод Double. hashCode (), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                         style="color: rgb(37, 127, 173);">hashCode</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">7</span> * Objects.hashCode(name)
                + <span class="hljs-number" style="color: rgb(147, 92, 37);">11</span> * <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">new</span> Double(salary).hashCode()
                + <span class="hljs-number" style="color: rgb(147, 92, 37);">13</span> * Objects.hashCode(hireDay);
    }</pre>
            <p>
              И во-вторых, можно вызвать метод Objects.hashO, если требуется объединить
              несколько хеш-значений, что еще лучше. В этом случае метод Objects.hashCode ()
              будет вызван для каждого аргумента с целью объединить получаемые в итоге
              хеш-значения. В таком случае метод Employee. hashCode () реализуется очень просто:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                         style="color: rgb(37, 127, 173);">hashCode</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Objects.hash(name, salary, hireDay);
}
</pre>
            <p>
              Методы equals () и hashCode () должны быть совместимы: если в результате вызова х .equals (у)
              возвращается логическое значение true, то и результаты вызовов
              . hashCode () и у . hashCode () также должны совпадать. Так, если в методе Employee.
              equals () сравниваются идентификационные номера работников, то при вычислении
              хеш-кода методу hashCode () также потребуются идентификационные номера, но не
              имя работника и не адрес памяти, занимаемой соответствующим объектом.

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
        Triangle triangeOriginal = new Triangle(2, 5);
        Triangle triangleCopy = new Triangle(2, 5);

        if (triangeOriginal.hashCode() == triangleCopy.hashCode()){
            System.out.println("hash code is equal");
        } else {
            System.out.println("different hash");
        }
    }
}

abstract class Point {
    private int xPoint;
    private int yPoint;

    public int getxPoint() {
        return xPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }
}

abstract class Figura extends Point {
    private Point point;

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

    @Override
    public int getxPoint() {
        return super.getxPoint();
    }

    @Override
    public void setxPoint(int xPoint) {
        super.setxPoint(xPoint);
    }

    @Override
    public int getyPoint() {
        return super.getyPoint();
    }

    @Override
    public void setyPoint(int yPoint) {
        super.setyPoint(yPoint);
    }
}

class Square extends Figura {
    public Square(int x) {
        super(x);
    }

    @Override
    public double getSquareValue() {
        return getX() * getX();
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
    public double getSquareValue() {
        return 0.5 * h * getX();
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
  name: "MethodHashCode",
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
        {item: 'hash code is equal', name: 'hash code is equal'},
        {item: 'different hash', name: 'different hash'},
        {item: 'equal', name: 'equal'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/fourthchapter/', {
        params: {
          numberTheme: 10,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[9].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[9].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[9].task.answer

          window.frontendData.language.chapters[3].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[9].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[9].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[9].task.answer
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
        Triangle triangeOriginal = new Triangle(2, 5);
        Triangle triangleCopy = new Triangle(2, 5);

        if (triangeOriginal.hashCode() == triangleCopy.hashCode()){
            System.out.println("hash code is equal");
        } else {
            System.out.println("different hash");
        }
    }
}

abstract class Point {
    private int xPoint;
    private int yPoint;

    public int getxPoint() {
        return xPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }
}

abstract class Figura extends Point {
    private Point point;

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

    @Override
    public int getxPoint() {
        return super.getxPoint();
    }

    @Override
    public void setxPoint(int xPoint) {
        super.setxPoint(xPoint);
    }

    @Override
    public int getyPoint() {
        return super.getyPoint();
    }

    @Override
    public void setyPoint(int yPoint) {
        super.setyPoint(yPoint);
    }
}

class Square extends Figura {
    public Square(int x) {
        super(x);
    }

    @Override
    public double getSquareValue() {
        return getX() * getX();
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
    public double getSquareValue() {
        return 0.5 * h * getX();
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

    let themeToClose = document.getElementById('java-4-chapter-2-theme-4-subtheme');

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