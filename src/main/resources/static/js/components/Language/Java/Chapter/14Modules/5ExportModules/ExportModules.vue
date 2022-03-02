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
          Экспорт пакетов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Как было показано в предыдущем рамеле, одному модулю требуется другой
              модуль, если необходимо воспользоваться его пакетами. Но это не делает автоматически доступными все
              пакеты из требующегося модуля. С помощью ключевого
              слова exports в модуле объявляется, какие из его пакетов являются доступными.
              Так, в приведенном ниже примере кода представлена часть объявления модуля
              j ava . xml . Таким образом, в данном пакете становятся доступными одни па кеты,
              но недоступными другие (например, пакет j dk . xml . inte rna l ), поскольку они
              не экспортируются.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span> java.xml{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">exports</span> Javax.xml;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">exports</span> javax.xml.catalog;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">exports</span> javax.xml.dat atype;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">exports</span> javax.xml.namespace;
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">exports</span> javax.xml.parsers;
}</pre>
            <p>
              Когда экспорти руется па кет, его открытые (р uЫ i с) и защищенные
              (protect ed) классы, интерфейсы и их члены становятся доступными за пределами данного модуля. (Как
              обычно, защищенные классы и их члены доступны
              только в их подклассах.)
            </p>

            <p>
              Тем не менее пакет, который не экспортируется, все равно недоступен за пределами своего модуля. Это
              существенное отличие от прежних модулей в Java .
              В прошлом можно было пользоваться открытыми классами из любого пакета,
              даже если он и не входил в состав открытого прикладного интерфейса API. Обычно, например, рекомендовалось
              пользоваться такими классами, как sun . тi s c .
              BAS E 6 4 Encode r или сот . sun . rowset . CachedRowSet impl, если в открытом прикладном интерфейсе API
              не предоставлялись соответствующие функциональные
              возможности.
            </p>
            <p>
              Ныне пакеты, не экспортированные из прикладного интерфейса API на платформе Java, больше недоступны,
              поскольку все они содержатся в модулях. В итоге некоторые программы больше не будут выполняться в версии
              Java 9. Безусловно, это не должно стать неприятной неожиданностью для тех, кто и не собирался
              опираться на неоткрытые прикладные интерфейсы API.
            </p>
            <p>
              Воспользуемся операциями экспорта в простой ситуации. С этой цел1,ю подготовим модуль com . hors tтann .
              greet, в котором экспортируется пакет под тем
              же самым именем c oт . hors tтann . g reet, при условии, что модуль, предоставляющий свой код для других
              модулей, должен обозначаться по имени находящегося в нем пакета верхнего уровня. В этом модуле имеется
              также пакет сот .
              hors tтann . gre e t . inte rnal, который не экспортируется
            </p>
            <p>
              Приведенный ниже открытый интерфейс Gree ter находится в первом пакете.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com.horstmann.greet;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                                 style="color: rgb(37, 127, 173);">Greeter</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword"
                                      style="color: rgb(107, 107, 184);">static</span> Greeter <span class="hljs-title"
                                                                                                     style="color: rgb(37, 127, 173);">newlnstance</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">new</span> com.horstmann.greet.internal.Greeterimpl();
    }

    Stringgreet(String subject);
}</pre>
            <p>
              Во втором пакете находится приведенный ниже класс, в котором реализуется
              упомянутый выше интерфейс. Этот класс является открытым, поскольку он доступен в первом пакете.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com.horstmann.greet.internal;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> com.horstmann.greet.Greeter;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Greeterimpl</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                  style="color: rgb(37, 127, 173);">Greeter</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Stringgreet</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(String subject)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-string"
                                                                                          style="color: rgb(86, 140, 59);">" Hello, "</span> + subject +<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"!"</span>;
    }
}</pre>
            <p>
              Оба упомянутых выше пакета содержатся в модуле с от . hors tmann . greet, но
              экспортируется только первый из них, как показа�ю ниже. Поэтому второй пакет
              недоступен за пределами данного модуля.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span> com.horstmann.greet{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">exports</span> com.horstmann.greet;
}</pre>
            <p>
              Перенесем рассматриваемую здесь прикладную программу во второй модуль,
              где требуется первый модуль:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span> v2ch09.exportedpkg{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">requires</span> com.horstmann.greet;
}</pre>
            <p>
              Интерфейс Gree ter применяется в рассматриваемой здесь прикладной программе для получения приветствия:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> com.horstmann.hello;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> com.horstmann.greet.Greeter;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">HelloWorld</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">main</span> <span class="hljs-params"
                                                                               style="color: rgb(147, 92, 37);">( String [] args )</span>

    </span>{
        Greeter greeter = Greeter.new instance();
        System.out.println(greeter.greet(<span class="hljs-string"
                                               style="color: rgb(86, 140, 59);">" Modular World"</span>));
    }
}</pre>
            <p>
              Н иже приведена структура исходных файлов для обоих рассматриваемых
              здесь модулей.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">com.horstmann.greet
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span>-info.java
    com
        horstmann
            greet
                Greeter.java
                internal
                    Greeter impl.java


v2ch09.exportedpkg
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">module</span>-info.java
        com
            horstmann
                hello
                    HelloWorld.java </pre>


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
          Как сделать пакет вашего модуля (библиотеки) доступным для вызова из вне?
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
          Как сделать пакет вашего модуля (библиотеки) доступным для вызова из вне?
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
  name: "ExportModules",
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

      selected: 'Обявить все методы и классы как public',
      options: [
        {
          item: 'Обявить все методы и классы как public',
          name: 'Обявить все методы и классы как public'
        },
        {
          item: 'Указать import.namepacket.*',
          name: 'Указать import.namepacket.*'
        },
        {
          item: 'Добавить в файл module-info {exports com.name.*}',
          name: 'Добавить в файл module-info {exports com.name.*}'
        },
        {
          item: 'Верны ответы 1 и 3',
          name: 'Верны ответы 1 и 3'
        },
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/twelfthchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[11].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[11].chapterProgress += 9.09
              window.frontendData.language.chapters[11].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[11].listThemes[4].task.answer

          window.frontendData.language.chapters[11].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[11].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[11].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[11].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[11].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[11].listThemes[4].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-14-chapter-5-theme');

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