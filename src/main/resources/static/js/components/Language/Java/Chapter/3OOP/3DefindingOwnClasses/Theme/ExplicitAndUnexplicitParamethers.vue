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
          Явные и неявные параметры
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Методы объекта имеют доступ ко всем его полям. Рассмотрим следующий метод:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">void</span> <span class="hljs-title"
                                                                                         style="color: rgb(71, 140, 144);">raiseSalary</span><span
                class="hljs-params" style="color: rgb(159, 113, 60);">(<span class="hljs-keyword"
                                                                             style="color: rgb(85, 133, 155);">double</span> byPercent)</span>
</span>{
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> raise = salary * byPercent / <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">100</span>;
salary += raise;
}</pre>
            <p>
              В этом методе устанавливается новое значение в поле salary того объекта, для которого вызывается этот
              метод. Например, следующий вызов данного метода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">number007.raiseSalary(<span
                class="hljs-number" style="color: rgb(159, 113, 60);">5</span>);</pre>

            <p>
              приведет к увеличению на 5% значения в поле number007. salary объекта number007.
              Строго говоря, вызов данного метода приводит к выполнению следующих двух операторов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> raise = number007. salary * <span
                class="hljs-number" style="color: rgb(159, 113, 60);">5</span> / <span class="hljs-number"
                                                                                       style="color: rgb(159, 113, 60);">100</span>;
number007. salary += raise;
</pre>
            <p>
              У метода raiseSalary () имеются два параметра. Первый параметр, называемый
              неявным, представляет собой ссылку на объект типа Employee, который указывается
              перед именем метода. А второй параметр называется явным и указывается как число
              в скобках после имени данного метода.

            </p>

            <p>
              Нетрудно заметить, что явные параметры перечисляются в объявлении метода,
              например double byPercent. Неявный параметр в объявлении метода не приводится. В каждом методе ключевое
              слово this обозначает неявный параметр. По желанию метод raiseSalary () можно было бы переписать
              следующим образом:

            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">void</span> <span class="hljs-title"
                                                                                         style="color: rgb(71, 140, 144);">raiseSalary</span><span
                class="hljs-params" style="color: rgb(159, 113, 60);">(<span class="hljs-keyword"
                                                                             style="color: rgb(85, 133, 155);">double</span> byPercent)</span>
</span>{
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> raise = <span class="hljs-keyword"
                                                                                         style="color: rgb(85, 133, 155);">this</span>.salary * byPercent / <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">100</span>;
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">this</span>.salary += raise;
}</pre>
            <p>
              Некоторые предпочитают именно такой стиль программирования, поскольку
              в нем более отчетливо различаются поля экземпляра и локальные переменные.
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
class Main
{
    static class Horses{
        private long id;
        private String name;
        private Double speedPerKilometers;
        private Double speedPerMiles;


        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers*2;

            this.speedPerMiles = this.speedPerKilometers / 1.6;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSpeedPerKilometers() {
            return speedPerKilometers;
        }

        public void setSpeedPerKilometers(Double speedPerKilometers) {
            this.speedPerKilometers = speedPerKilometers;
        }

        public Double getSpeedPerMiles() {
            return speedPerMiles;
        }

        public void setSpeedPerMiles(Double speedPerMiles) {
            this.speedPerMiles = speedPerMiles;
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 45.0);
        System.out.println(horses.getSpeedPerMiles());
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
  name: "ExplicitAndUnexplicitParamethers",
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
        {item: '90', name: '90'},
        {item: '45', name: '45'},
        {item: '56', name: '56'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 9,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[8].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 2.7
              window.frontendData.language.chapters[2].listThemes[8].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[8].task.answer

          window.frontendData.language.chapters[2].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[8].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[8].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[8].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[8].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[8].task.answer
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
        `class Main
{
    static class Horses{
        private long id;
        private String name;
        private Double speedPerKilometers;
        private Double speedPerMiles;


        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers*2;

            this.speedPerMiles = this.speedPerKilometers / 1.6;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSpeedPerKilometers() {
            return speedPerKilometers;
        }

        public void setSpeedPerKilometers(Double speedPerKilometers) {
            this.speedPerKilometers = speedPerKilometers;
        }

        public Double getSpeedPerMiles() {
            return speedPerMiles;
        }

        public void setSpeedPerMiles(Double speedPerMiles) {
            this.speedPerMiles = speedPerMiles;
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 45.0);
        System.out.println(horses.getSpeedPerMiles());
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

    let themeToClose = document.getElementById('java-3-chapter-3-theme-7-subtheme');

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