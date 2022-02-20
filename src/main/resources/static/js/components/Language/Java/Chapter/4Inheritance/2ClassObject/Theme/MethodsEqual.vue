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
          Метод equals()
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В методе equals () из класса Object проверяется, равны ли два объекта. А поскольку метод equals ()
              реализован в классе Object, то в нем определяется только
              следующее: ссылаются ли переменные на один и тот же объект. В качестве проверки по умолчанию эти действия
              вполне оправданы: всякий объект равен самому себе.
              Для некоторых классов большего и не требуется. Например, вряд ли кому-то потребуется анализировать два
              объекта типа PrintStream и выяснять, отличаются ли они
              чем-нибудь. Но в ряде случаев равными должны считаться объекты одного типа, находящиеся в одном и том же
              состоянии.

            </p>

            <p>
              Рассмотрим в качестве примера объекты, описывающие работников. Очевидно,
              что они одинаковы, если совпадают имена, размеры заработной платы и даты их
              приема на работу. (Строго говоря, в настоящих системах учета данных о работниках
              более оправдано сравнение идентификационных номеров. А здесь лишь демонстрируются принципы реализации
              метода equals () в коде, как показано ниже.)

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title"
                                                                                     style="color: rgb(37, 127, 173);">equals</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(Object otherObject)</span> </span>{
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// быстро проверить объекты на идентичность </span>
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (<span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">this</span> == otherObject) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">true</span>;
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// возвратить логическое значение f a l s e ,</span>
    <span class="hljs-comment"
          style="color: rgb(113, 149, 168);">// если явный параметр имеет пустое значение n u l l</span>
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (otherObject == <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>) <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">false</span>;
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// если классы не совпадают, они не равны </span>
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (getClass() != otherObject.getClass()) {

            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">false</span>;
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Теперь известно, что объект otherObject</span>
    <span class="hljs-comment"
          style="color: rgb(113, 149, 168);">// относится к типу Employee и не является пустым </span>
            Employee other = (Employee) otherObject;
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">// проверить, хранятся ли в полях объектов одинаковые значения </span>
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> name.equals(other.name)
                    &amp;&amp; salary = other.salary
                    &amp;&amp; hireDay.equals(other.hireDay);
        }
    }</pre>
            <p>
              Метод getClass () возвращает класс объекта. Этот метод будет подробно обсуждаться далее в главе. Для того
              чтобы объекты можно было считать равными, они как
              минимум должны быть объектами одного и того же класса.
            </p>

            <p>
              Определяя метод equ als () для подкласса, сначала следует вызывать одноименный метод из суперкласса. Если
              проверка даст отрицательный результат, объекты
              нельзя считать равными. Если же поля суперкласса совпадают, можно приступать
              к сравнению полей подкласса, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title"
                                                                                     style="color: rgb(37, 127, 173);">equals</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(Object otherObject)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (!<span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">super</span>.equals(otherObject)) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">false</span>;
        <span class="hljs-comment"
              style="color: rgb(113, 149, 168);">// При вызове метода super .equals () проверяется,</span>
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// принадлежит ли объект otherObject тому же самому классу </span>
        Manager other = (Manager) otherObject;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> bonus == other.bonus;
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
        Triangle triangeOriginal = new Triangle(2, 5);
        Triangle triangleCopy = new Triangle(2, 5);

        System.out.println(triangeOriginal.equals(triangleCopy));
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
        if (this == obj){
            return true;
        }
        if (this == null){
            return false;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        Triangle triangleObj = (Triangle) obj;

        return getX() == triangleObj.getX()
                && this.h == triangleObj.h;
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
  name: "MethodsEqual",
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

      selected: 'Cast Exception',
      options: [
        {item: 'Cast Exception', name: 'Cast Exception'},
        {item: 'true', name: 'true'},
        {item: 'false', name: 'false'},
        {item: 'equal', name: 'equal'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fourthchapter/', {
        params: {
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[7].task.answer

          window.frontendData.language.chapters[3].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[7].task.answer
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

        System.out.println(triangeOriginal.equals(triangleCopy));
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
        if (this == obj){
            return true;
        }
        if (this == null){
            return false;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        Triangle triangleObj = (Triangle) obj;

        return getX() == triangleObj.getX()
                && this.h == triangleObj.h;
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

    let themeToClose = document.getElementById('java-4-chapter-2-theme-2-subtheme');

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