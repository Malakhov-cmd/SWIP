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
          Конструктор
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Многие классы содержат конструктор без аргументов, создающий объект, состояние которого устанавливается
              соответствующим образом по умолчанию. В качестве
              примера ниже приведен конструктор без аргументов для класса Employee.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">()</span>
    </span>{
        name = <span class="hljs-string" style="color: rgb(86, 140, 59);">""</span>;
        salary = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
        hireDay = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date();
    }</pre>
            <p>
              Если в классе совсем не определены конструкторы, то автоматически создается
              конструктор без аргументов. В этом конструкторе всем полям экземпляра присваиваются их значения,
              предусмотренные по умолчанию. Так, все числовые значения,
              содержащиеся в полях экземпляра, окажутся равными нулю, логические переменные — false, объектные
              переменные — null.
            </p>
            <p>
              Если же в классе есть хотя бы один конструктор и явно не определен конструктор
              без аргументов, то создавать объекты, не предоставляя аргументы, нельзя. Например,
              у класса Employee из листинга 4.2 имеется один следующий конструктор:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee(String name, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> salary, <span class="hljs-keyword"
                                                                                                    style="color: rgb(107, 107, 184);">int</span> y, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> m, <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">int</span> d)</pre>
            <p>
              В этой версии данного класса нельзя создать объект, поля которого принимали
              бы значения по умолчанию. Иными словами, следующий вызов приведет к ошибке:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">е = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee();
</pre>
            <p>
              Вызов одного конструктора из другого
            </p>


            <p>
              Ключевым словом this обозначается неявный параметр метода. Но у этого
              слова имеется еще одно назначение. Если первый оператор конструктора имеет вид
              this (...), то вызывается другой конструктор этого же класса. Ниже приведен характерный тому пример.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">(<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> s)</span> </span>{
        <span class="hljs-comment"
              style="color: rgb(113, 149, 168);">// вызвать конструктор Employee (String, double)</span>
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>(<span class="hljs-string"
                                                                                        style="color: rgb(86, 140, 59);">"Employee "</span> + nextld, s);
        nextld++;
    }</pre>
            <p>
              Если выполняется операция new Employee (60000), то конструктор Employee
              (double) вызывает конструктор Employee (String, double). Применять ключевое
              слово this для вызова другого конструктора очень удобно — нужно лишь один раз
              написать общий код для конструирования объекта.
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
        Cube cube = new Cube();

        System.out.println(cube.getFigureName());
    }
}

class Cube {
    private int x;
    private int y;
    private int z;

    private String figureName = "";

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
  name: "ConstructorWithoutArgs",
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
        {item: '\"\"', name: '\"\"'},
        {item: 'null', name: 'null'},
        {item: 'Cube', name: 'Cube'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 18,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[17].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[17].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[17].task.answer

          window.frontendData.language.chapters[2].listThemes[17].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[17].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[17].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[17].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[17].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[17].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[17].task.answer
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

    let themeToClose = document.getElementById('java-3-chapter-6-theme-2-subtheme');

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