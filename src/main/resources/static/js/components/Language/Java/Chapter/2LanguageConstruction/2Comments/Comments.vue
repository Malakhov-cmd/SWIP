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
          Комментарии
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Комментарии в Java, как и в большинстве других языков программирования, игнорируются при выполнении
              программы. Таким образом, в программу можно добавить
              столько комментариев, сколько потребуется, не опасаясь увеличить ее объем. В Java предоставляются три
              способа выделения комментариев в тексте. Чаще всего для этой цели
              используются два знака косой черты (//), а комментарий начинается сразу после знаков
              // и продолжается до конца строки. Если же требуются комментарии, состоящие из нескольких строк, каждую
              их строку следует начинать знаками // , как показано ниже.
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(40, 42, 54); color: rgb(248, 248, 242);">System.out.println(<span
                class="hljs-string" style="color: rgb(241, 250, 140);">"We will not use’Hello, World!’"</span>);
<span class="hljs-comment" style="color: rgb(98, 114, 164);">// Мы не будем пользоваться избитой фразой "Здравствуй, мир!".</span>
<span class="hljs-comment" style="color: rgb(98, 114, 164);">// Остроумно, не правда ли?</span>
</pre>
            <p>Кроме того, для создания больших блоков комментариев можно использовать
              разделители /* и */. И наконец, третьей разновидностью комментариев можно
              пользоваться для автоматического формирования документации. Эти комментарии
              начинаются знаками /** и оканчиваются знаками */, как показано в листинге 3.1.
              Подробнее об этой разновидности комментариев и автоматическом формировании
              документации речь пойдет в главе 4.
              Листинг 3.1.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; padding: 0.5em; background: rgb(40, 42, 54); color: rgb(248, 248, 242);"><span
                class="hljs-comment" style="color: rgb(98, 114, 164);">/**
 * This is the first sample program in Core Java Chapter 3
 * <span class="hljs-doctag" style="font-weight: 700;">@version</span> 1.01 1997-03-22
 * <span class="hljs-doctag" style="font-weight: 700;">@author</span> Gary Cornell
 */</span>
<span class="hljs-keyword" style="color: rgb(139, 233, 253); font-weight: 700;">public</span> <span
                  class="hljs-class"><span class="hljs-keyword" style="color: rgb(139, 233, 253); font-weight: 700;">class</span> <span
                  class="hljs-title" style="color: rgb(241, 250, 140); font-weight: 700;">FirstSample</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword"
                                     style="color: rgb(255, 121, 198); font-weight: 700;">public</span> <span
       class="hljs-keyword" style="color: rgb(255, 121, 198); font-weight: 700;">static</span> <span
       class="hljs-keyword" style="color: rgb(255, 121, 198); font-weight: 700;">void</span> <span class="hljs-title"
                                                                                                   style="color: rgb(241, 250, 140); font-weight: 700;">main</span><span
       class="hljs-params">(String[] args)</span>
   </span>{
      System.out.println(<span class="hljs-string"
                               style="color: rgb(241, 250, 140);">"We will not use 'Hello, World!'"</span>);
   }
}
</pre>
          </div>
          <div class="page-theme-author-text text-white-50">
            Приведенный материал был взят из книги "Java. Библиотека профессионала, том 1.", написанной Кейем С.
            Хорстманном.
          </div>
        </b-collapse>
      </div>

      <hr class="my-4">

      <div role="group" class="page-theme-form" v-show="showInput">
        <label class="page-theme-question-text">
          Изучите и опробуйте измение комментариев, используя следующий код
        </label>

        <textarea id="codeContentId">
/**object of Model*/
    private PostgreSQLJDBC_Model model;
    /**object of View*/
    private FileBaseView view;

    /**Source list for TableView to display data*/
    private ObservableList<Record> rec = FXCollections.observableArrayList();

    /**
     * Initialize Presenter {@link Presenter#model}, {@link Presenter#view}
     * @see Presenter
     * */
    public Presenter(PostgreSQLJDBC_Model model, FileBaseView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Flag to confirm end of add record process
     * */
    public static volatile boolean endingAdd;

    /**Log updater @see Updater */
    Updater updater = new Updater();

    /**
     * {@link IPresenter#getModel()}
     * */
    @Override
    public PostgreSQLJDBC_Model getModel() {
        return model;
    }
        </textarea>
      </div>

      <div v-show="!showInput">
        <label class="page-theme-question-text">
          Изучите и опробуйте измение комментариев, используя следующий код
        </label>
        <p class="page-theme-theory-text">
          Ваш ответ:
        </p>
        <textarea id="codeContentIdAnswered"></textarea>
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

let tempAnswer = []
let tempValue = ''
export default {
  name: "Comments",
  data() {
    return {
      showInput: true,
      answer: [],
      animationOn: false,
      codeContent: null,
      codeAnsweredContent: null
    }
  },
  methods: {
    Request() {
      console.log(tempValue)
      if (tempValue !== '') {
        axios.get('http://localhost:9000/java/secondchapter/', {
          params: {
            numberTheme: 2,
            answer: tempValue,
            userId: window.frontendData.profile.id
          }
        })
            .then(function (response) {
              if (response.data !== 'Incorrect answer') {
                window.frontendData.language.chapters[1].listThemes[1].task.answer = response.data
                window.frontendData.language.chapters[1].chapterProgress += 2.2
                window.frontendData.language.chapters[1].listThemes[1].finished = true

                tempAnswer = response.data

                isSendedandrecived = true
              }
            })
            .catch(function (error) {
              console.log(error);
            })
        const interval = setInterval(() => {
          if (isSendedandrecived) {

            this.answer = window.frontendData.language.chapters[1].listThemes[1].task.answer

            this.codeAnsweredContent.setValue(this.answer)

            this.animationOn = isSendedandrecived
            this.showInput = false

            clearInterval(interval)
          } else {
            this.$toasted.error("Неверный ответ", {
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
      } else {
        this.$toasted.error("Произвите изменения", {
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
      }
    },
  },
  mounted() {
    //TODO сделать рефактор бд
    if (window.frontendData.language.chapters[1].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[1].listThemes[1].task.answer
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

    if (this.answer.length !== 0) {
      this.codeContent.setValue(this.answer)
      this.codeAnsweredContent.setValue(this.answer)
    }

    this.codeContent.on('change', function (cm) {
      tempValue = cm.getValue();
    })

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  }
}
</script>

<style scoped>

</style>