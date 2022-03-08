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
          Преимущества инкапсуляции
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Рассмотрим далее очень простые методы getName (), getSalary () и getHireDay ()
              из класса Employee. Их исходный код приведен ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> String getNameO
{
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">return</span> name;
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
    class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> <span class="hljs-title"
                                                                               style="color: rgb(71, 140, 144);">getSalary</span><span
    class="hljs-params" style="color: rgb(159, 113, 60);">()</span>
</span>{
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">return</span> salary;
}
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> Date <span
    class="hljs-title" style="color: rgb(71, 140, 144);">getHireDay</span><span class="hljs-params"
                                                                                style="color: rgb(159, 113, 60);">()</span>
</span>{
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">return</span> hireDay;
}</pre>
            <p>
              Они служат характерным примером методов доступа. А поскольку они лишь возвращают значения полей
              экземпляра, то иногда их еще называют методами доступа к полям. Но не проще ли было сделать поля name,
              salary и hireDay открытыми
              для доступа (т.е. объявить их как public) и не создавать отдельные методы доступа
              к ним?
            </p>

            <p>
              Дело в том, что поле name доступно лишь для чтения. После того как значение
              этого поля будет установлено конструктором, ни один метод не сможет его изменить.
              А это дает гарантию, что данные, хранящиеся в этом поле, не будут искажены.

            </p>

            <p>
              Поле salary доступно не только для чтения, но и для записи, но изменить значение в нем способен только
              метод raiseSalaryO. И если окажется, что в поле записано неверное значение, то отладить нужно будет
              только один метод. Если бы поле
              salary было открытым, причина ошибки могла бы находиться где угодно.

            </p>

            <p>
              Иногда требуется иметь возможность читать и видоизменять содержимое поля.
              Для этого придется реализовать в составе класса следующие три компонента.

            </p>

            <ul>
              <li>
                <p>
                  Закрытое (private) поле данных.
                </p>
              </li>
              <li>
                <p>
                  Открытый (public) метод доступа.
                </p>
              </li>
              <li>
                <p>
                  Открытый (public) модифицирующий метод.
                </p>
              </li>
            </ul>

            <p>
              Конечно, сделать это намного труднее, чем просто объявить открытым единственное поле данных. Но такой
              подход дает немалые преимущества. Во-первых, внутреннюю реализацию класса можно изменять совершенно
              независимо от других классов.
              Допустим, что имя и фамилия работника хранятся отдельно:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">String firstName;
String lastName;
</pre>

            <p>
              Тогда в методе getName () возвращаемое значение должно быть сформировано
              следующим образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">firstName + <span
                class="hljs-string" style="color: rgb(72, 153, 99);">" "</span> + lastName
</pre>

            <p>
              И такое изменение оказывается совершенно незаметным для остальной части
              программы. Разумеется, методы доступа и модифицирующие методы должны быть
              переработаны, чтобы учесть новое представление данных. Но это дает еще одно преимущество: модифицирующие
              методы могут выполнять проверку ошибок, тогда как
              при непосредственном присваивании открытому полю некоторого значения ошибки
              не выявляются. Например, в методе setSalary () можно проверить, не стала ли зарплата отрицательной
              величиной.

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
        horses.setName("Luisa");
        horses.setSpeedPerKilometers(45.5);
        System.out.println(horses.getName());
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
  name: "IncapsulationBenefits",
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
        {item: 'Loe', name: 'Loe'},
        {item: 'Luisa', name: 'Luisa'},
        {item: '45.5', name: '45.5'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 10,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[9].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[9].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[9].task.answer

          window.frontendData.language.chapters[2].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[9].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[9].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[9].task.answer
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
        horses.setName("Luisa");
        horses.setSpeedPerKilometers(45.5);
        System.out.println(horses.getName());
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

    let themeToClose = document.getElementById('java-3-chapter-3-theme-4-subtheme');

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