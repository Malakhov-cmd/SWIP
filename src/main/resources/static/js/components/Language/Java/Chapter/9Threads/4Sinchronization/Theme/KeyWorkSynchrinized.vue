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
          Ключевое слово s y n c h r o n i z e d
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В предыдущих разделах было показано, как пользоваться объектами блокировки
              типа Lock и условиями типа Condition. Прежде чем двигаться дальше, подведем
              краткие итоги, перечислив главные особенности блокировок и условий.
            </p>
            <ul>
              <li>
                <p>
                  Блокировка защищает критические разделы кода, позволяя выполнять этот
                  код только в одном потоке в единицу времени.
                </p>
              </li>
              <li>
                <p>
                  Блокировка управляет потоками исполнения, которые пытаются войти в защищенный раздел кода.
                </p>
              </li>
              <li>
                <p>
                  Каждый объект условия управляет потоками, которые вошли в защищенный
                  раздел кода, но пока еще не в состоянии продолжить свое исполнение.
                </p>
              </li>
            </ul>

            <p>
              Интерфейсы Lock и Condition предоставляют программистам высокую степень
              контроля над блокировками. Но зачастую такой контроль не требуется, и оказывается достаточно механизма,
              встроенного в язык Java. Еще со времен версии 1.0 каждый
              объект в Java обладает встроенной блокировкой. Если метод объявлен с ключевым
              словом synchronized, то блокировка объекта защищает весь этот метод. Следовательно, поток исполнения
              должен захватить встроенную блокировку объекта, чтобы
              вызвать такой метод.

            </p>

            <p>
              Иными словами, следующий фрагмент кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> <span class="hljs-keyword"
                                                                                                  style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">method</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span>
</span>{
    тело метода
}
</pre>
            <p>
              равнозначен приведенному ниже фрагменту кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">   <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">method</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.intrinsicLock.lock();
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         тело метода
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span> { <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">this</span>.intrinsicLock.unlock(); }
   }</pre>
            <p>
              Например, вместо явной блокировки можно просто объявить метод transfer ()
              из класса Bank как synchronized. Встроенная блокировка объектов имеет единственное связанное с ней
              условие. Метод wait () вводит поток исполнения в набор ожидания, а методы notifyAll ()/notify ()
              разблокируют ожидающие потоки. Иными
              словами, вызов метода wait () или notifyAll () равнозначен следующему коду:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">встроенноеУсловие.await() ;
встроенноеУсловие.signalАll() ;
</pre>

            <p>
              Например, класс Bank можно реализовать только языковыми средствами Java следующим образом

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Bank</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> doublet]accounts;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">transfer</span><span class="hljs-params"
                                                                                  style="color: rgb(147, 92, 37);">(<span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> from, <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> to, <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> amount)</span>
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> InterruptedException </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (accounts[from] &lt; amount)
            wait(); <span class="hljs-comment"
                          style="color: rgb(113, 149, 168);">// ожидать по единственному условию </span>
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// встроенной блокировки объектов </span>
        accounts[from] -= amount;
        accounts[to] += amount;
        notifyAll(); / /уведомить все потоки,
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// ожидающие по данному условию</span>
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">double</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getTotalBalance</span><span class="hljs-params"
                                                                                         style="color: rgb(147, 92, 37);">()</span> </span>{ . . .}
}</pre>
            <p>
              Как видите, применение ключевого слова synchronized порождает намного более
              краткий код. Разумеется, чтобы понять такой код, нужно знать, что каждый объект
              обладает встроенной блокировкой и что эта блокировка имеет встроенное условие.
              Блокировка управляет потоками, которые пытаются войти в метод synchronized.
              А условие управляет потоками, вызвавшими метод wait ().
            </p>

            <p>
              Статические методы также допускается объявлять синхронизированными. Когда
              вызывается такой метод, он захватывает встроенную блокировку объекта соответствующего класса. Так, если в
              классе Bank имеется статический синхронизированный метод, при его вызове захватывается блокировка объекта
              типа Bank, class. В результате
              к этому объекту не может обратиться никакой другой поток исполнения и никакой
              другой синхронизированный статический метод того же класса.

            </p>
            <p>
              Встроенным блокировкам и условиям присущи некоторые ограничения, в том
              числе приведенные ниже.

            </p>

            <ul>
              <li>
                <p>
                  Нельзя прервать поток исполнения, который пытается захватить блокировку.
                </p>
              </li>
              <li>
                <p>
                  Нельзя указать время ожидания, пытаясь захватить блокировку.
                </p>
              </li>
              <li>
                <p>
                  Наличие единственного условия на блокировку может оказаться неэффективным.
                </p>
              </li>
            </ul>

            <p>
              Что же лучше использовать в прикладном коде: объекты типа Lock и Condition
              или синхронизированные методы? Ниже приведены некоторые рекомендации, которые дают ответ на этот вопрос.
            </p>

            <ul>
              <li>
                <p>
                  Лучше не пользоваться ни объектами типа Lock/Condition, ни ключевым
                  словом synchronized. Зачастую вместо этого можно выбрать подходящий
                  механизм из пакета java.util.concurrent, который организует блокировку
                  автоматически. Так, в разделе 14.6 далее в этой главе будет показано, как пользоваться блокирующими
                  очередями для синхронизации потоков, выполняющих общую задачу.
                </p>
              </li>
              <li>
                <p>
                  Если ключевое слово synchronized подходит в конкретной ситуации, непременно воспользуйтесь им. В этом
                  случае вам придется написать меньше кода,
                  а следовательно, допустить меньше ошибок. В листинге 14.8 приведен пример
                  очередного варианта программы, имитирующей банк и реализованной на основе синхронизированных методов.
                </p>
              </li>
              <li>
                <p>
                  Пользуйтесь объектами типа Lock/Condition, если действительно нуждаетесь
                  в дополнительных возможностях подобных конструкций.
                </p>
              </li>
            </ul>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> synch2;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * A bank with a number of bank accounts that uses synchronization primitives.
 * <span class="hljs-doctag">@version</span> 1.30 2004-08-01
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Bank</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">final</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span>[] accounts;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Constructs the bank.
    * <span class="hljs-doctag">@param</span> n the number of accounts
    * <span class="hljs-doctag">@param</span> initialBalance the initial balance for each account
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Bank</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(<span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> n, <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">double</span> initialBalance)</span>
   </span>{
      accounts = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> <span class="hljs-keyword"
                                                                                                style="color: rgb(107, 107, 184);">double</span>[n];
      Arrays.fill(accounts, initialBalance);
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Transfers money from one account to another.
    * <span class="hljs-doctag">@param</span> from the account to transfer from
    * <span class="hljs-doctag">@param</span> to the account to transfer to
    * <span class="hljs-doctag">@param</span> amount the amount to transfer
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">transfer</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(<span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> from, <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> to, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> amount)</span> <span class="hljs-keyword"
                                                                                                  style="color: rgb(107, 107, 184);">throws</span> InterruptedException
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (accounts[from] &lt; amount)
         wait();
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" %10.2f from %d to %d"</span>, amount, from, to);
      accounts[to] += amount;
      System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" Total Balance: %10.2f%n"</span>, getTotalBalance());
      notifyAll();
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Gets the sum of all account balances.
    * <span class="hljs-doctag">@return</span> the total balance
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">synchronized</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">double</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getTotalBalance</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> sum = <span class="hljs-number"
                                                                                              style="color: rgb(147, 92, 37);">0</span>;

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> a : accounts)
         sum += a;

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> sum;
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Gets the number of accounts in the bank.
    * <span class="hljs-doctag">@return</span> the number of accounts
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">size</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> accounts.length;
   }
}
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
          Что рекомендовано использовать для организации кода в критических местах с точки зрения многопоточности?
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
          Что рекомендовано использовать для организации кода в критических местах с точки зрения многопоточности?
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
  name: "KeyWorkSynchrinized",
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

      selected: 'ReentrantLock',
      options: [
        {
          item: 'ReentrantLock',
          name: 'ReentrantLock'
        },
        {
          item: 'Synchronized',
          name: 'Synchronized'
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
          numberTheme: 11,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[10].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 8.3
              window.frontendData.language.chapters[8].listThemes[10].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[10].task.answer

          window.frontendData.language.chapters[8].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[10].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[10].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[10].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-4-subtheme');

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