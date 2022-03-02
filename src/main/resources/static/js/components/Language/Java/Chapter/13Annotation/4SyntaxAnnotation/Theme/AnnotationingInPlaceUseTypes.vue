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
          Аннотирование в местах употребления типов данных
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Аннотация в объявлении предоставляет некоторые сведения об объявляемом
              элементе кода . Так, в следующем примере кода аннотацией утверждается, что
              параметр userid объявляемого метода не является пустым:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">puЫ <span
                class="hljs-function">ic User getUse <span class="hljs-title" style="color: rgb(37, 127, 173);">r</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( @ NonNull Str ing us erid)</span></span></pre>

            <p>
              Tеперь допустим, что имеется параметр типа List< St r ing > и требуется каким-то образом указать, что все
              символьные строки не являются пустыми. Именно здесь и пригодятся аннотации в местах употребления типов
              данных. Такую
              аннотацию достаточно указать перед аргументом типа следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">List&lt; <span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@NonNull</span> String&gt;</pre>

            <p>
              Подобные аннотации можно указывать в следующих местах употребления типов данных.
            </p>
            <ul>
              <li>
                <p>
                  Bместе с аргументами обобщенного типа: List< @ N onN ull Stri ng>,
                  Compa rator . < @NonNull String> reve r s eOrde r ().
                </p>
              </li>
              <li>
                <p>
                  В л юбом месте массива : @ NonNu ll Stri ng [] [] wo rds (элемент массива
                  wo rds [ i ] [ j] не является пустым), S t ring @NonNu ll [] [] wo rds (массив
                  words не является пустым), String [} @NonNu ll [] wo rds (элемент массива wo rds [ i] не является
                  пустым).
                </p>
              </li>
              <li>
                <p>
                  В суперклассах и реализуемых интерфейсах: class Wa rning exte nds
                  @ Localized Me s s age .
                </p>
              </li>
              <li>
                <p>
                  В вызовах конструкторов: new @Loca1ized S t r ing ( . . . ) .
                </p>
              </li>
              <li>
                <p>
                  Во вложенных типах: Мар . @Localized Ent ry.
                </p>
              </li>
              <li>
                <p>
                  В операции приведения и проверки типов ins tan ceof: ( @ L o c ali zed
                  String ) text, if ( t ext ins tanceof @Loc alized Strin g ) . (Аннотации
                  служат для употребления только внешними инструментальными средствами и не оказывают никакого влияния
                  на поведение операции приведения
                  и проверки типов ins tanceo f.)
                </p>
              </li>
              <li>
                <p>
                  В местах укюа11ия искл ючений: puЫic String read () th rows @Localized
                  I OException.
                </p>
              </li>
              <li>
                <p>
                  Вместе с метасимволами подстановки и ограничениями типов: List<
                  @ Localized ? extends Me s s age>, List< ? Ext ends @Loca1ized Me ssage >.
                </p>
              </li>
              <li>
                <p>
                  В ссылках на методы и конструкторы: @Localized Me s s age : : getTex t.

                </p>
              </li>
            </ul>

            <p>
              Однако имеются некоторые места употребления типов данных, где аннотации
              не допускаются. Ниже приведены характерные примеры.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">@ NoпNull Str iпg . <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> / / ОШИБКА : литерал кла сса не
// подлежит аннотирова нию !
<span class="hljs-title" style="color: rgb(37, 127, 173);">import</span> <span class="hljs-title"
                                                                               style="color: rgb(37, 127, 173);">j</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">ava</span> . <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">l</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">a</span>п<span class="hljs-title"
                                                                                      style="color: rgb(37, 127, 173);">g</span> . @<span
                  class="hljs-title" style="color: rgb(37, 127, 173);">No</span>п<span class="hljs-title"
                                                                                       style="color: rgb(37, 127, 173);">Null</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">Stri</span>п<span class="hljs-title"
                                                                                         style="color: rgb(37, 127, 173);">g</span></span>; / / ОШИБКА : импорт не
/ / подлежит аннотированию <span class="hljs-number" style="color: rgb(147, 92, 37);">1</span> </pre>

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
          C какой целью была внедрена почти повсеметсная поддержка аннотаций?
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
          C какой целью была внедрена почти повсеметсная поддержка аннотаций?
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
  name: "AnnotationingInPlaceUseTypes",
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

      selected: 'Для обеспечения повсеместной возможности их внедрения и последующей интерпритацией спец. средствами',
      options: [
        {
          item: 'Для обеспечения повсеместной возможности их внедрения и последующей интерпритацией спец. средствами',
          name: 'Для обеспечения повсеместной возможности их внедрения и последующей интерпритацией спец. средствами'
        },
        {
          item: 'Для возможности создания различных пользовательских аннотаций',
          name: 'Для возможности создания различных пользовательских аннотаций'
        },
        {
          item: 'По историсческим причинам',
          name: 'По историсческим причинам'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/elevenchapter/', {
        params: {
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[10].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[10].chapterProgress += 9.09
              window.frontendData.language.chapters[10].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[10].listThemes[7].task.answer

          window.frontendData.language.chapters[10].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[10].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[10].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[10].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[10].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[10].listThemes[7].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-13-chapter-4-theme-3-subtheme');

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