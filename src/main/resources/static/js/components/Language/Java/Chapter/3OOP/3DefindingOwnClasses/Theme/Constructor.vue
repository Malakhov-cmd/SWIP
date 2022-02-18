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
          Первые действия с конструкторами
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Рассмотрим следующий конструктор класса Employee:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
                class="hljs-title" style="color: rgb(71, 140, 144);">Employee</span><span class="hljs-params"
                                                                                          style="color: rgb(159, 113, 60);">(String n, <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> s, <span class="hljs-keyword"
                                                                                              style="color: rgb(85, 133, 155);">int</span> year, <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">int</span> month, <span class="hljs-keyword"
                                                                                               style="color: rgb(85, 133, 155);">int</span> day)</span>
</span>{
name = n;
salary = s;
GregorianCalendar calendar =
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> GregorianCalendar(year, month - <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">1</span>, day);
hireDay = calendar. getTimeO;
}</pre>
            <p>Как видите, имя конструктора совпадает с именем класса. Этот конструктор выполняется при создании
              объекта типа Employee, заполняя поля экземпляра заданными значениями. Например, при создании экземпляра
              класса Employee с помощью
              оператора
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Employee(<span class="hljs-string"
                                                                                                 style="color: rgb(72, 153, 99);">"James Bond"</span>, <span
                class="hljs-number" style="color: rgb(159, 113, 60);">100000</span>, <span class="hljs-number"
                                                                                           style="color: rgb(159, 113, 60);">1950</span>, <span
                class="hljs-number" style="color: rgb(159, 113, 60);">1</span>, <span class="hljs-number"
                                                                                      style="color: rgb(159, 113, 60);">1</span>) ;
</pre>
            <p>
              поля экземпляра заполняются следующими значениями:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">name = <span
                class="hljs-string" style="color: rgb(72, 153, 99);">"James Bond"</span>;
salary = <span class="hljs-number" style="color: rgb(159, 113, 60);">100000</span>;
hireDay = January <span class="hljs-number" style="color: rgb(159, 113, 60);">1</span>, <span class="hljs-number"
                                                                                              style="color: rgb(159, 113, 60);">1950</span>;</pre>

            <p>
              У конструкторов имеется существенное отличие от других методов: конструктор
              можно вызывать только в сочетании с операцией new. Конструктор нельзя применить
              к существующему объекту, чтобы изменить информацию в его полях. Например,
              приведенный ниже вызов приведет к ошибке во время компиляции.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">james.Employee(<span
                class="hljs-string" style="color: rgb(72, 153, 99);">"James Bond"</span>, <span class="hljs-number"
                                                                                                style="color: rgb(159, 113, 60);">250000</span>, <span
                class="hljs-number" style="color: rgb(159, 113, 60);">1950</span>, <span class="hljs-number"
                                                                                         style="color: rgb(159, 113, 60);">1</span>, <span
                class="hljs-number" style="color: rgb(159, 113, 60);">1</span>); <span class="hljs-comment"
                                                                                       style="color: rgb(120, 135, 125);">// ОШИБКА!</span>
</pre>
            <p>
              Мы еще вернемся в этой главе к конструкторам. А до тех пор запомните следующее.
            </p>

            <ul>
              <li>
                <p>
                  Имя конструктора совпадает с именем класса.
                </p>
              </li>
              <li>
                <p>
                  Класс может иметь несколько конструкторов.
                </p>
              </li>
              <li>
                <p>
                  Конструктор может иметь один или несколько параметров или же вообще их
                  не иметь.
                </p>
              </li>
              <li>
                <p>
                  Конструктор не возвращает никакого значения.
                </p>
              </li>
              <li>
                <p>
                  Конструктор всегда вызывается совместно с операцией new.
                </p>
              </li>
            </ul>

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

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers*2;
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
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 45.0);
        System.out.println(horses.getSpeedPerKilometers());
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
  name: "Constructor",
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

      selected: 'LoeLoe',
      options: [
        {item: 'LoeLoe', name: 'LoeLoe'},
        {item: '90', name: '90'},
        {item: '45', name: '45'},
        {item: '2', name: '2'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[7].task.answer

          window.frontendData.language.chapters[2].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[7].task.answer
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

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers*2;
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
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 45.0);
        System.out.println(horses.getSpeedPerKilometers());
    }
}  `)

    this.timeStarted = Date.now()

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-3-theme-2-subtheme');

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