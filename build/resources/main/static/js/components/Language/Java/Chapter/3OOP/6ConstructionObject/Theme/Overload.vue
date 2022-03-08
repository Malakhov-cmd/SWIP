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
          Перегрузка
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Ранее было показано, как писать простые конструкторы, определяющие начальные состояния объектов. Но
              конструирование объектов — очень важная операция,
              и поэтому в Java предусмотрены самые разные механизмы написания конструкторов.
              Все эти механизмы рассматриваются ниже.
            </p>
            <p>
              Перегрузка
            </p>
            <p>
              У некоторых классов имеется не один конструктор. Например, пустой объект типа
              StringBuilder можно сконструировать (или, проще говоря, построить) следующим
              образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">StringBuilder messages = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> StringBuilder();
</pre>
            <p>
              С другой стороны, исходную символьную строку можно указать таким образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">StringBuilder todoList = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> StringBuilder(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"To do:\n"</span>);</pre>
            <p>
              Оба способа конструирования объектов носят общее название перегрузки. О перегрузке говорят в том случае,
              если у нескольких методов (в данном случае нескольких
              конструкторов) имеются одинаковые имена, но разные параметры. Компилятор должен сам решить, какой метод
              вызвать, сравнивая типы параметров, определяемых
              при объявлении методов, с типами значений, указанных при вызове методов. Если
              ни один из методов не соответствует вызову или же если одному вызову одновременно соответствует несколько
              вариантов, возникает ошибка компиляции. (Этот процесс
              называется разрешением перегрузки.)
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
        Cube cube1 = new Cube(2, 2, 2);
        Cube cube2 = new Cube(2, 2, 2);

        cube1 = OperationClass.multyplyerSides(cube1, 3);
        cube2 = OperationClass.multyplyerSides(cube1, 3, 4, 5);

        if (cube1.getValue() > cube2.getValue()){
            System.out.println("First cube bigger");
        } else {
            System.out.println("Second cube is bigger");
        }
    }
}

class Cube {
    private int x;
    private int y;
    private int z;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public int getValue() {
        return this.x * this.y * this.z;
    }
}

class OperationClass {
    public static Cube multyplyerSides(Cube cube, int multyplyer) {
        cube.setX(cube.getX() * multyplyer);
        cube.setY(cube.getY() * multyplyer);
        cube.setZ(cube.getZ() * multyplyer);

        return cube;
    }

    public static Cube multyplyerSides(Cube cube, int multyplyerX, int multyplyerY, int multyplyerZ) {
        cube.setX(cube.getX() * multyplyerX);
        cube.setY(cube.getY() * multyplyerY);
        cube.setZ(cube.getZ() * multyplyerZ);

        return cube;
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
  name: "Overload",
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
        {item: 'First cube bigger', name: 'First cube bigger'},
        {item: 'Second cube is bigger', name: 'Second cube is bigger'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 17,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[16].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[16].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[16].task.answer

          window.frontendData.language.chapters[2].listThemes[16].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[16].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[16].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[16].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[16].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[16].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[16].task.answer
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
        Cube cube = new Cube(2, 2, 2);

        OperationClass.multyplyerSides(cube, 3);

        System.out.println(cube.getValue());
    }
}

class Cube {
    private int x;
    private int y;
    private int z;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public int getValue() {
        return this.x * this.y * this.z;
    }
}

class OperationClass {
    public static Cube multyplyerSides(Cube cube, int multyplyer) {
        cube.setX(cube.getX() * multyplyer);
        cube.setY(cube.getY() * multyplyer);
        cube.setZ(cube.getZ() * multyplyer);

        return cube;
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

    let themeToClose = document.getElementById('java-3-chapter-6-theme-1-subtheme');

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