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
          Группирование и разделение
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В предыдущем разделе было показано, как накапливаются все языки заданной
              страны. Но этот процесс оказался несколько трудоемким, поскольку для каждого значения из отображения
              пришлое�, сначала сформировать одноэлементное
              множество, а затем указать порядок объединения существующего и нового значений. Нередко из значений с
              одинаковыми характеристиками образуются группы,
              и этот процесс непосредственно поддерживается методом groupingBy ().
            </p>

            <p>
              Рассмотрим задачу группирования региональных настроек по странам. Сначала образуется следующее
              отображение:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        Map&lt;String , List &lt;Locale&gt;&gt; countryToLocales =
        locales.collect( Collectors.groupingBy (
                Locale :: getCountry) );</pre>
            <p>
              Функция Locale : : getCountr y () исполняет роль классификатора группирования. Затем все региональные
              настройки можно отыскать по заданному коду
              страны, как показано в следующем примере кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        List &lt;Locale&gt; swissLocales = countryToLocales.get( <span
                class="hljs-string" style="color: rgb(86, 140, 59);">" CH "</span> );
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// получить региональ ные настройки [ it_CH , de_CH , fr_СН ]</span></pre>

            <p>
              Когда функция классификатора оказывается предикатной (т.е. функцией, возвращающей логическое значение
              типа boolean), элементы потока данных разделяются на основной список с элементами, для которых функция
              возвращает
              логическое значение t rue, и дополнительный список. В данном случае эффективнее воспользоваться методом
              partitioningBy (),чем методом groupingBy ().
              Так, в следующем примере кода все региональные настройки разделяются на те,
              которые описывают английский язык, и все остальные:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        Map&lt;Boolean , List &lt;Locale&gt;&gt; englishAndOtherLocales =
                locales . collect ( Collectors . partitioningBy (
                l -&gt; <span class="hljs-number"
                              style="color: rgb(147, 92, 37);">1</span>. getLanguage () . equals ( <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"en "</span> ) ));
        List &lt;Locale&gt;&gt; englishLocales =
                englishAndOtherLocales . get ( <span class="hljs-keyword" style="color: rgb(107, 107, 184);">true</span> ) ;</pre>


            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 2.", написанной Кейем С.
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
        Task<Integer> task = new Task<Integer>(" 4 * 4 ", 16);
        Stream<Task<Integer>> defaultinit = task.defaultInit();

        Map<Boolean, List<Task<Integer>>> sortedTask = defaultinit.collect(
                Collectors.groupingBy(
                        (part) -> part.getQuestion().startsWith("4")
                )
        );

        sortedTask.get(true).forEach(item -> System.out.println(item.getQuestion()));
    }
}

class Task<T> {
    private String question;
    private T answer;

    public Task(String question, T answer) {

        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public Optional<T> getAnswer() {
        return Optional.ofNullable(this.answer);
    }

    public Stream<Task<Integer>> defaultInit() {
        return Stream.of(
                new Task<>("4 + 4", 8),
                new Task<>("4 * 4 ", 16),
                new Task<>("2 * 2", 4),
                new Task<>("2 + 2", null)
        );
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
  name: "GroupingAndRegrouping",
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
        {item: '4 * 4', name: '4 * 4'},
        {item: '4 + 4', name: '4 + 4'},
        {item: '4 + 4 4 * 4', name: '4 + 4 4 * 4'},
        {item: '2 * 2 4 + 4 4 * 4', name: '2 * 2 4 + 4 4 * 4'},
        {item: '2 + 2 2 * 2 4 + 4 4 * 4', name: '2 + 2 2 * 2 4 + 4 4 * 4'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/tenthchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[9].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[9].chapterProgress += 8.3
              window.frontendData.language.chapters[9].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[9].listThemes[6].task.answer

          window.frontendData.language.chapters[9].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[9].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[9].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[9].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[9].listThemes[6].task.answer
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
        Task<Integer> task = new Task<Integer>(" 4 * 4 ", 16);
        Stream<Task<Integer>> defaultinit = task.defaultInit();

        Map<Boolean, List<Task<Integer>>> sortedTask = defaultinit.collect(
                Collectors.groupingBy(
                        (part) -> part.getQuestion().startsWith("4")
                )
        );

        sortedTask.get(true).forEach(item -> System.out.println(item.getQuestion()));
    }
}

class Task<T> {
    private String question;
    private T answer;

    public Task(String question, T answer) {

        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public Optional<T> getAnswer() {
        return Optional.ofNullable(this.answer);
    }

    public Stream<Task<Integer>> defaultInit() {
        return Stream.of(
                new Task<>("4 + 4", 8),
                new Task<>("4 * 4 ", 16),
                new Task<>("2 * 2", 4),
                new Task<>("2 + 2", null)
        );
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

    let themeToClose = document.getElementById('java-10-chapter-10');

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