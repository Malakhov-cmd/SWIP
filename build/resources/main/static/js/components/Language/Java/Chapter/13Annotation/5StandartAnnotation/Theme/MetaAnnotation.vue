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
          Мета-аннотации
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              ета-аннотация @Target применяется к аннотации, ограничивая те элементы, которые должны быть снабжены
              данной аннотацией, как показано в приведенном ниже примере.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@Target</span> ( { E l ementType . TY PE, Eleme nt T ype . METHOD ) )
puЫ ic @ <span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">BugReport</span></span></pre>

            <p>
              Аннотацией без ограничений, накладываемых мета-аннотацией @ Target, можно
              снабдить любой элемент кода. Компилятор проверяет, чтобы аннотацией снабжался только разрешенный элемент
              кода. Так, если снабдить аннотацией @ BugReport
              поле, компилятор выдаст во время компиляции соответствующую ошибку.
            </p>

            <p>
              Мета-аннотация @ Retent ion обозначает, насколько долго должна сохраняться
              аннотация
            </p>
            <p>
              Мета-аннотация @ Do cumented выдает подсказку о средствах документирования в формате Javadoc.
              Документируемые аннотации следует рассматривать
              в целях докуме1 1тирования таким же обра:юм, как и другие модификаторы, подобные protec ted или static. О
              применении остальных аннотаций в документации не упоминается. Допустим, а11нотация @Act ionLis tenerFor
              объявляется
              как документируемая следующим обра:юм:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">@ Do cumented
<span class="hljs-meta" style="color: rgb(147, 92, 37);">@Ta</span> rget (ElementType . METHOD )
@ <span class="hljs-function">Retent <span class="hljs-title" style="color: rgb(37, 127, 173);">ion</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( Retent i on Po l icy . RUNT IME )</span>
puЫ ic @interface Act ionList enerFor</span></pre>
            <p>
              Мета-аннотация @In h e r i ted применяется только к аннотациям классов.
              Когда в класс вводится наследуемая аннотация, все его подклассы автоматически снабжаются точно такой же
              ашютацией. Это позволяет легко со3давать аннотации, действующие та ким же обра:юм, ка к и маркерные
              интерфейсы вроде
              Seriali zaЫe.

            </p>
            <p>
              На самом деле аннотация @ Seriali zaЫe будет более уместной, чем маркерный
              интерфейс Seriali zaЬle без единого метода. Класс является сериализируемым изза наличия во время
              выполнения поддержки для чтения и записи его полей, а не
              из-за каких-то принципов объектно-орие1пированного проектирования. Аннотация
              описывает данное обстоятельство намного лучше, чем наследование и1перфейсов,
              ведь интерфейс Se riali zaЬle появился еще в версии JDK 1.1, т.е. намного раньше,
              чем аннотации.
            </p>
            <p>
              Допустим, для указания на то, что объекты класса могут сохраняп,ся в базе
              данных, определяется наследуемая аннотация @ Pe rsist ent. В таком случае все
              подклассы этого класса будут автоматически аннотироваться как сохраняемые:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@Inherited</span> <span class="hljs-meta"
                                                                                           style="color: rgb(147, 92, 37);">@interface</span> Pe rsi stent
<span class="hljs-meta" style="color: rgb(147, 92, 37);">@Persistent</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Emp</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">l</span> <span class="hljs-title"
                                                                                      style="color: rgb(37, 127, 173);">oyee</span> </span>{ . }
<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span> <span class="hljs-keyword"
                                                                              style="color: rgb(107, 107, 184);">extends</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">Emp</span> <span class="hljs-title"
                                                                          style="color: rgb(37, 127, 173);">l</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">oyee</span> </span>{ . }
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// также @ Persistent </span></pre>
            <p>
              При поиске объектов, сохраняемых в базе данных, механизм сохраняемости
              будет обнаруживать как объекты типа Emp loyee, так и объекты типа Manager.
            </p>
            <p>
              Начиная с версии Java 8 допускается неоднократное применение аннотации
              одного и того же типа к отдельному элементу. Ради обратной совместимости
              разработчикам повторяющейся аннотации пришлое, предоставить контей нерную аннотацию, содержащую
              повторяющиеся аннотации в массиве. Ниже показа1ю, каким образом определяются аннотация @Tes tCa se и ее
              контейнер.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">@ RepeataЬ<span
                class="hljs-function">l <span class="hljs-title" style="color: rgb(37, 127, 173);">e</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( TestCases . c lass )</span>
@interface TestCase </span>{
<span class="hljs-function">String pa <span class="hljs-title" style="color: rgb(37, 127, 173);">rams</span> <span
    class="hljs-params" style="color: rgb(147, 92, 37);">( )</span> </span>;
<span class="hljs-function">String expe <span class="hljs-title" style="color: rgb(37, 127, 173);">cted</span> <span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>;
@ i nt erface TestCases {
TestCase [] <span class="hljs-function">va l <span class="hljs-title" style="color: rgb(37, 127, 173);">ue</span><span
                  class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>;
}</pre>
            <p>
              Всякий раз, когда пользователь предоставляет две или более а ннотации
              @TestCase, они автоматически заключаются в оболочку аннотации @ TestCases
            </p>

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
          Для чего используются мета-аннотации?
        </label>

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
          Для чего используются мета-аннотации?
        </label>
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

let isSendedandrecived = false

export default {
  name: "MetaAnnotation",
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

      selected: 'Автоматическая генерация кода',
      options: [
        {
          item: 'Автоматическая генерация кода',
          name: 'Автоматическая генерация кода'
        },
        {
          item: 'Генерация других аннотаций',
          name: 'Генерация других аннотаций'
        },
        {
          item: 'Генерация других аннотаций и указания информации о других аннотациях',
          name: 'Генерация других аннотаций и указания информации о других аннотациях'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/elevenchapter/', {
        params: {
          numberTheme: 11,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[10].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[10].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[10].task.answer

          window.frontendData.language.chapters[10].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[10].task.tryCount + ".", {
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
    }
  },
  mounted() {
    if (window.frontendData.language.chapters[10].listThemes[10].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[10].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-5-theme-3-subtheme');

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