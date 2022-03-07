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
          Статические поля и методы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              При объявлении метода main () во всех рассматривавшихся до сих пор примерах
              программ использовался модификатор static. Рассмотрим назначение этого модификатора доступа.

            </p>
            <p>
              Статические поля
            </p>

            <p>
              Поле с модификатором доступа static существует в одном экземпляре для всего класса. Но если поле не
              статическое, то каждый объект содержит его копию. Допустим, требуется присвоить уникальный идентификацион
              работнику. Для этого достаточно добавить в класс Employee поле id и статическое
              поле next Id, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">int</span> id;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> nextld = <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">1</span>;
}</pre>

            <p>
              Теперь у каждого объекта типа Employee имеется свое поле id, а также поле
              nextld, которое одновременно принадлежит всем экземплярам данного класса. Иными словами, если существует
              тысяча объектов типа Employee, то в них есть тысяча
              полей id: по одному на каждый объект. В то же время существует только один экземпляр статического поля
              nextld. Даже если не создано ни одного объекта типа
              Employee, статическое поле nextld все равно существует. Оно принадлежит классу,
              а не конкретному объекту.
            </p>
            <p>
              Реализуем следующий простой метод:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">setld</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
    </span>{
        id = nextld;
        nextld++;
    }</pre>

            <p>
              Допустим, требуется задать идентификационный номер объекта harry следующим образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">harry.setld();</pre>
            <p>
              Затем устанавливается текущее значение в поле id объекта harry, а значение статического поля nextld
              увеличивается на единицу, как пока
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">harry, id = Employee, nextld;
Employee.nextld++;
</pre>
            <p>
              Статические константы
            </p>
            <p>
              Статические переменные используются довольно редко. В то же время статические константы применяются
              намного чаще. Например, статическая константа, задающая число я, определяется в классе Math следующим
              образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Math</span>
    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">double</span> PI = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3.14159265358979323846</span>;
    }</pre>
            <p>
              Обратиться к этой константе в программе можно с помощью выражения Math.
              PI. Если бы ключевое слово static было пропущено, константа PI была бы обычным
              полем экземпляра класса Math. Это означает, что для доступа к такой константе нужно было бы создать
              объект типа Math, причем каждый такой объект имел бы свою
              копию константы PI.

            </p>
            <p>
              Еще одной часто употребляемой является статическая константа System, out. Она
              объявляется в классе System следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">System</span>
    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> PrintStream out = ...;
    }
</pre>
            <p>
              Как уже упоминалось не раз, делать поля открытыми в коде не рекомендуется,
              поскольку любой объект сможет изменить их значения. Но открытыми константами
              (т.е. полями, объявленными с ключевым словом final) можно пользоваться смело.
              Так, если поле out объявлено как final, ему нельзя присвоить другой поток вывода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> PrintStream(...); <span
                class="hljs-comment"
                style="color: rgb(113, 149, 168);">// ОШИБКА: поле out изменить нельзя!</span></pre>
            <p>
              Статические методы
            </p>
            <p>
              Статическими называют методы, которые не оперируют объектами. Например,
              метод pow () из класса Math является статическим. При вызове метода Math. pow (х, а)
              вычисляется степень числа ха. При выполнении этого метода не используется ни
              один из экземпляров класса Math. Иными словами, у него нет неявного параметра this. Это означает, что в
              статических методах не используется текущий объект
              по ссылке this. (А в нестатических методах неявный параметр this ссылается на текущий объект; см. раздел
              4.3.5 ранее в этой главе.)

            </p>
            <p>
              Статическому методу из класса Employee недоступно поле экземпляра id, поскольку он не оперирует объектом.
              Но статические методы имеют доступ к статическим полям класса. Ниже приведен пример статического метода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> getNextldO
{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> nextld; <span class="hljs-comment"
                                                                                                  style="color: rgb(113, 149, 168);">// возвратить статическое поле</span>
}
</pre>
            <p>
              Чтобы вызвать этот метол нужно указать имя класса следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> n = Employee.getNextld();</pre>
            <p>              Можно ли пропустить ключевое слово static при обращении к этому методу?
              Можно, но тогда для его вызова потребуется ссылка на объект типа Employee.
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
        System.out.println(calculateService.getMultiplayerValue(5));
    }
}

class calculateService{
    private static double multiplayer = 1.78;

    public static double getMultiplayerValue(double x){
        return x * multiplayer;
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
  name: "StaticField",
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
        {item: '5', name: '5'},
        {item: '10', name: '10'},
        {item: '8.9', name: '8.9'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 13,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[12].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[12].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[12].task.answer

          window.frontendData.language.chapters[2].listThemes[12].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[12].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[12].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[12].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[12].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[12].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[12].task.answer
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
        System.out.println(calculateService.getMultiplayerValue(5));
    }
}

class calculateService{
    private static double multiplayer = 1.78;

    public static double getMultiplayerValue(double x){
        return x * multiplayer;
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

    let themeToClose = document.getElementById('java-3-chapter-4-theme-1-subtheme');

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