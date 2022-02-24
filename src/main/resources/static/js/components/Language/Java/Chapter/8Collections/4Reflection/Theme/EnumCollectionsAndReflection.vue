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
          Перечислимые множества и отображения
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В классе EnumSet эффективнно реализуется множество элементов, относящихся
              к перечислимому типу. А поскольку у перечислимого типа ограниченное количество
              экземпляров, то класс EnumSet реализован внутренним образом в виде битовой последовательности. В каждом бите устанавливается 1, если соответствующее значение
              перечисления присутствует в множестве. У класса EnumSet отсутствуют открытые
              конструкторы. Для конструирования перечислимого множества используется статический фабричный метол как показано ниже. А для видоизменения перечислимого
              множества типа EnumSet можно использовать обычные методы из интерфейса Set.

            </p>
            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">enum</span> Weekday
{ MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY };
EnumSet&lt;Weekday&gt; always = EnumSet.allOf(Weekday.class) ;
EnumSet&lt;Weekday&gt; never = EnumSet.noneOf(Weekday.class);
EnumSet&lt;Weekday&gt; workday =
EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
EnumSet&lt;Weekday&gt; mwf =
EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
</pre>
            <p>
              Класс EnumMap реализует отображение с ключами, относящимися к перечислимому типу. Такое отображение реализуется просто и эффективно в виде массива значений. Для этого достаточно указать тип ключа в конструкторе следующим образом:
            </p>
            <pre class="hljs" style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">EnumMap&lt;Weekday, Employee&gt; personlnCharge = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> EnumMapo(Weekday.class);
</pre>


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
        EnumSet<States> statesEnumSet = EnumSet.allOf(States.class);

        for (States state:
             statesEnumSet) {
            System.out.print(state.getState() + " ");
        }
    }
}

public enum States {
    Cal("California"),
    Tex("Texas"),
    Alb("Alabama");

    private String state;

    States(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
  name: "EnumCollectionsAndReflection",
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
        {item: 'California', name: 'California'},
        {item: 'California Texas', name: 'California Texas'},
        {item: 'California Texas Alabama ', name: 'California Texas Alabama '},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/seventhchapter/', {
        params: {
          numberTheme: 12,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[11].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 11.1
              window.frontendData.language.chapters[7].listThemes[11].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[11].task.answer

          window.frontendData.language.chapters[7].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[11].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[11].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[11].task.answer
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
        EnumSet<States> statesEnumSet = EnumSet.allOf(States.class);

        for (States state:
             statesEnumSet) {
            System.out.print(state.getState() + " ");
        }
    }
}

public enum States {
    Cal("California"),
    Tex("Texas"),
    Alb("Alabama");

    private String state;

    States(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    let themeToClose = document.getElementById('java-8-chapter-4-theme-2-subtheme');

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