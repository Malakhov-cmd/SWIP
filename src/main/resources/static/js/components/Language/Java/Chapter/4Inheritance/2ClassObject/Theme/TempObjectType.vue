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
          Глобальный суперкласс object
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Класс Object является исходным предшественником всех остальных классов, поэтому каждый класс в Java
              расширяет класс Object. Но явно отражать этот факт, как
              в приведенной ниже строке кода, совсем не обязательно.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Employee</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Object</span>
</span></pre>
            <p>
              Если суперкласс явно не указан, им считается класс Object. А поскольку каждый
              класс в Java расширяет класс Object, то очень важно знать, какими средствами обладает сам класс Object. В
              этой главе делается беглый обзор самых основных из них,
              прочие средства класса Object будут рассмотрены в других главах, а остальные сведения о них можно найти в
              соответствующей документации. (Некоторые методы и класса Object целесообразно рассматривать лишь вместе с
              потоками исполнения,
              которые обсуждаются в главе 14.)

            </p>
            <p>Переменную типа Object можно использовать в качестве ссылки на объект любого типа следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Object obj = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string"
                                                                                                  style="color: rgb(86, 140, 59);">"Harry Hacker"</span>, <span
                class="hljs-number" style="color: rgb(147, 92, 37);">35000</span>);
</pre>
            <p>
              Разумеется, переменная этого класса полезна лишь как средство для хранения
              значений произвольного типа. Чтобы сделать с этим значением что-то конкретное,
              нужно знать его исходный тип, а затем выполнить приведение типов, как показано
              ниже. В языке Java объектами не являются только примитивные типы: числа, символы
              и логические значения.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee е = (Employee) obj;</pre>
            <p>
              Все массивы относятся к типам объектов тех классов, которые расширяют класс
              Object, независимо от того, содержатся ли в элементах массива объекты или примитивные типы:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee[] staff = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee[<span class="hljs-number"
                                                                                                  style="color: rgb(147, 92, 37);">10</span>];
obj = staff; <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Допустимо!</span>
obj = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">int</span>[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">10</span>]; <span class="hljs-comment"
                                                                                         style="color: rgb(113, 149, 168);">// Допустимо!</span></pre>


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
        Object objTriange = new Triangle(2, 5);;

        Triangle triangle = (Triangle) objTriange;

        System.out.println(triangle.getSquareValue());
    }
}

abstract class Point{
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

abstract class Figura extends Point{
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
        return getX()*getX();
    }
}

class Triangle extends Figura{
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public double getSquareValue() {
        return 0.5*h*getX();
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
  name: "TempObjectType",
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
        {item: 'null', name: 'null'},
        {item: '5', name: '5'},
        {item: 'NaN', name: 'NaN'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fourthchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[6].task.answer

          window.frontendData.language.chapters[3].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[6].task.answer
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
        Object objTriange = new Triangle(2, 5);;

        Triangle triangle = (Triangle) objTriange;

        System.out.println(triangle.getSquareValue());
    }
}

abstract class Point{
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

abstract class Figura extends Point{
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
        return getX()*getX();
    }
}

class Triangle extends Figura{
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public double getSquareValue() {
        return 0.5*h*getX();
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

    let themeToClose = document.getElementById('java-4-chapter-2-theme-1-subtheme');

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