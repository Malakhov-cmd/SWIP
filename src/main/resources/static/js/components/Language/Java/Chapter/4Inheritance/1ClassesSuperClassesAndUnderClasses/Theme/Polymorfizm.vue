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
          Полиморфизм
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Существует простое правило, позволяющее определить, стоит ли в конкретной
              ситуации применять наследование или нет. Если между объектами существует отношение "является", то каждый
              объект подкласса является объектом суперкласса.
              Например, каждый руководитель является работником. Следовательно, имеет смысл
              сделать класс Manager подклассом, производным от класса Employee. Естественно, обратное утверждение
              неверно — не каждый работник является руководителем.

            </p>
            <p> Отношение "является" можно выявить и по-другому, используя принцип подстановки. Этот принцип состоит в
              том, что объект подкласса можно использовать вместо
              любого объекта суперкласса. Например, объект подкласса можно присвоить переменной суперкласса следующим
              образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee е;
е = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(...); <span class="hljs-comment"
                                                                                                  style="color: rgb(113, 149, 168);">// предполагается объект класса Employee</span>
е = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Manager(...);
<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// допускается использовать также объект класса Manager</span></pre>
            <p>              В языке Java объектные переменные являются полиморфными. Переменная типа
              Employee может ссылаться как на объект класса Employee, так и на объект любого подкласса, производного от
              класса Employee (например, Manager, Executive,
              Secretary и т.п.). Применение принципа полиморфизма было продемонстрировано
              в листинге 5.1 следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager boss = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> manager(...);
Employee!] staff = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3</span>];
staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = boss;
</pre>
            <p>Здесь переменные staff [0] и boss ссылаются на один и тот же объект. Но переменная staff [0]
              рассматривается компилятором только как объект типа Employee.
              Это означает, что допускается следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">boss.setBonus(<span
                class="hljs-number" style="color: rgb(147, 92, 37);">5000</span>); <span class="hljs-comment"
                                                                                         style="color: rgb(113, 149, 168);">// Допустимо!</span>
</pre>
            <p>В то же время приведенное ниже выражение составлено неверно.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">staff[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>].setBonus(<span class="hljs-number"
                                                                                              style="color: rgb(147, 92, 37);">5000</span>); <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
</pre>
            <p>
              Дело в том, что переменная staff [0] объявлена как объект типа Employee, а метод setBonus () в этом
              классе отсутствует. Но присвоить ссылку на объект суперкласса переменной подкласса нельзя. Например,
              следующий оператор считается недопустимым:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager m = staff[i]; <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
</pre>
            <p>
              Причина очевидна: не все работники являются руководителями. Если бы это присваивание произошло и
              переменная m могла бы ссылаться на объект типа Employee,
              который не представляет руководителей, то впоследствии оказался бы возможным вызов метода m. setBonus
              (...), что привело бы к ошибке при выполнении программы.

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
        Figura triange = new Triangle(2, 5);
        Figura square = new Square(4);

        if (triange.getSquareValue() > square.getSquareValue()){
            System.out.println("Triangle bigger");
        } else {
            System.out.println("Square bigger");
        }
    }
}

abstract class Figura{
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
  name: "Polymorfizm",
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
        {item: 'Triangle bigger', name: 'Triangle bigger'},
        {item: 'Square bigger', name: 'Square bigger'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fourthchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[2].task.answer

          window.frontendData.language.chapters[3].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[2].task.answer
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
        Figura triange = new Triangle(2, 5);
        Figura square = new Square(4);

        if (triange.getSquareValue() > square.getSquareValue()){
            System.out.println("Triangle bigger");
        } else {
            System.out.println("Square bigger");
        }
    }
}

abstract class Figura{
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

    let themeToClose = document.getElementById('java-4-chapter-1-theme-3-subtheme');

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