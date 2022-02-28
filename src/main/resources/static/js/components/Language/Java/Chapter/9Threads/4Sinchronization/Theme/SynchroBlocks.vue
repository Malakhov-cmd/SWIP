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
          Синхронизированные блоки
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Как упоминалось выше, у каждого объекта в Java имеется собственная встроенная блокировка. Поток
              исполнения может захватить эту блокировку, вызвав синхронизированный метод. Но есть и другой механизм
              захвата блокировки — вхождение
              в синхронизированный блок. Когда поток исполнения входит в блок кода, объявляемый
              в приведенной ниже форме, он захватывает блокировку объекта ob j.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> (obj) <span
                class="hljs-comment"
                style="color: rgb(113, 149, 168);">// это синтаксис синхронизированного блока </span>
{
    критический раздел кода
}</pre>

            <p>
              Иногда в прикладном коде встречаются специальные блокировки вроде следующей:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Bank</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> doublet] accounts;
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Object lock = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Object ();
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">transfer</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                    style="color: rgb(107, 107, 184);">int</span> from, <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">int</span> amount)</span>
    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> (lock) <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// специальная блокировка </span>
        {
            accounts[from] -= amount;
            accounts[to] += amount;
        }
        System.out.println(. . .);
    }
}</pre>
            <p>
              Здесь объект lock создается только для использования встроенной блокировки,
              которая имеется у каждого объекта в Java. Встроенной блокировкой объекта иногда
              пользуются для реализации дополнительных атомарных операций. Такая практика
              получила название клиентской блокировки. Рассмотрим для примера класс Vector,
              который реализует список и методы которого синхронизированы. А теперь допустим, что остатки на банковских
              счетах сохранены в объекте типа Vector
              < Double >.
              Ниже приведена наивная реализация метода transfer ( ) .
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">transfer</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(
            Vector&lt;Double&gt; accounts, <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> from, <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">int</span> amount)</span> <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
    </span>{
        accounts.set(from, accounts.get(from) - amount);
        accounts.set(to, accounts.get(to) + amount);
        System.out.println(. . .);
    }</pre>
            <p>
              Методы get () и set () из класса Vector синхронизированы, но это вряд ли поможет. Вполне возможно, что
              поток исполнения будет приостановлен в методе
              transfer () по завершении первого вызова метода get (). В другом потоке исполнения может быть затем
              установлено иное значение на той же позиции. Блокировку
              можно захватить следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">transfer</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(Vector&lt;Double&gt; accounts, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> from,
                         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> amount)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> (accounts) {
            accounts.set(from, accounts.get(from) - amount);
            accounts.set(to, accounts.get(to) + amount);
        }
        System.out.println(. . .);
    }</pre>
            <p>
              Такой подход вполне работоспособен, но он полностью зависит от того факта, что
              встроенная блокировка используется в классе Vector для всех его модифицирующих
              методов. Но так ли это на самом деле? В документации на класс Vector этого не
              обещается. Поэтому следует очень тщательно проанализировать исходный код этого
              класса, надеясь, что в последующие его версии не будут внедрены несинхронизированные модифицирующие
              методы. Как видите, клиентская блокировка — весьма ненадежный прием, и поэтому он обычно не рекомендуется
              для применения.

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
          Зачем нужен объект "lock" в приведенном примере?
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
          Зачем нужен объект "lock" в приведенном примере?
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
  name: "SynchroBlocks",
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

      selected: 'Для использования блокировки, которой обладает любой объект в Java',
      options: [
        {
          item: 'Для использования блокировки, которой обладает любой объект в Java',
          name: 'Для использования блокировки, которой обладает любой объект в Java'
        },
        {
          item: 'Для того чтобы использовать блок synchronized внутри метода',
          name: 'Для того чтобы использовать блок synchronized внутри метода'
        },
        {
          item: 'Все варианты',
          name: 'Все варианты'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/ninthchapter/', {
        params: {
          numberTheme: 12,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[11].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[11].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[11].task.answer

          window.frontendData.language.chapters[8].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[11].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[11].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[11].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[11].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[11].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-5-subtheme');

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