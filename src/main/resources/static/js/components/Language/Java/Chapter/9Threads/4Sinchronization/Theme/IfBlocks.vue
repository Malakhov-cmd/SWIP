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
          Объекты условий
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Нередко поток входит в критический раздел кода только для того, чтобы обнаружить, что он не может
              продолжить свое исполнение до тех пор, пока не будет соблюдено определенное условие. В подобных случаях
              для управления теми потоками,
              которые захватили блокировку, но не могут выполнить полезные действия, служит
              объект условия. В этом разделе будет представлена реализация объектов условий
              в библиотеке Java (по ряду исторических причин объекты условий нередко называются условными переменными).

            </p>
            <p>
              Попробуем усовершенствовать рассматриваемую здесь программу имитации банка.
              Не будем перемещать деньги со счета, если он не содержит достаточной суммы, чтобы
              покрыть расходы на перевод. Но для этого не годится код, подобный следующему:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (bank.getBalance(from) &gt;= amount)
bank.transfer(from, to, amount)</pre>
            <p>
              Ведь вполне возможно, что текущий поток будет деактивизирован в промежутке
              между успешным выполнением проверки и вызовом метода tr a n s fe r ():
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (bank.getBalance(from) &gt;= amount)
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// поток исполнения может быть деактивирован в этом месте кода </span>
bank.transfer(from, to, amount);
</pre>
            <p>
              В тот момент, когда возобновляется исполнение потока, остаток на счете может измениться, т.е. уменьшиться
              ниже допустимого предела. Поэтому нужно каким-то образом гарантировать, что никакой другой поток не
              сможет изменить остаток на счете
              между его проверкой и переводом денег. Для этого придется защитить как проверку
              остатка на счете, так и сам перевод денег с помощью следующей блокировки:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">transfer</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">int</span> from, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">int</span> amount)</span>
    </span>{
        bankbook.lock();
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
        {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (accounts[from] &lt; amount)
            {
                <span class="hljs-comment" style="color: rgb(113, 149, 168);">// ожидать</span>
            }
                <span class="hljs-comment" style="color: rgb(113, 149, 168);">// перевести денежные средства</span>
        }
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
        {
            bankbook.unlock();
        }
    }</pre>
            <p>
              Что делать дальше, если на счете нет достаточной суммы? Ожидать до тех пор, пока
              счет не будет пополнен в каком-то другом потоке исполнения. Но ведь данный поток
              только что получил монопольный доступ к объекту bankbook, так что ни в одном другом
              потоке нет возможности пополнить счет. И здесь на помощь приходит объект условия.
            </p>
            <p>
              С объектом блокировки может быть связан один или несколько объектов условий,
              которые получены с помощью метода newCondition (). Каждому объекту условия
              можно присвоить имя, напоминающее об условии, которое он представляет. Например, объект, представляющий
              условие "достаточных денежных средств", устанавливается следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Bank</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Condition sufficientFunds;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Bank</span><span class="hljs-params"
                                                                              style="color: rgb(147, 92, 37);">()</span>
    </span>{
        sufficientFunds = bankbock.newCondition();
    }
}</pre>
            <p>
              Если в методе transfer() будет обнаружено, что средств на счете недостаточно,
              он сделает следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">sufficientFunds.await();</pre>
            <p>
              Текущий поток исполнения теперь деактивизирован и снимает блокировку. Это
              дает возможность пополнить счет в другом потоке.
            </p>

            <p>
              НИмеется существенное отличие между потоком, ожидающим возможности захватить блокировку, и потоком,
              который вызвал метод await (). Как только в потоке
              исполнения вызывается метод await О, он входит в набор ожидания, установленный
              для данного условия. Поток не становится исполняемым, когда оказывается доступной блокировка. Вместо
              этого он остается деактивизированным до тех пор, пока другой поток не вызовет метод signal АН () по тому
              же условию.

            </p>
            <p>
              Когда перевод денег будет произведен в другом потоке исполнения, в нем должен
              быть сделан следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">sufficientFunds. signalAll();</pre>
            <p>
              В результате этого вызова активизируются все потоки исполнения, ожидающие
              данного условия. Когда потоки удаляются из набора ожидания, они опять становятся
              исполняемыми, и в конечном итоге планировщик потоков активизирует их снова.
              В этот момент они попытаются повторно захватить объект блокировки. И как только он окажется доступным,
              один из этих потоков захватит блокировку и продолжит
              свое исполнение с того места, где он остановился, получив управление после вызова
              метода await ().

            </p>
            <p>
              В этот момент условие должно быть снова проверено в потоке исполнения. Но нет
              никаких гарантий, что условие теперь выполнится. Ведь метод signalAll () просто
              сигнализирует ожидающим потокам о том, что условие теперь может быть удовлетворено и что его стоит
              проверить заново.
            </p>
            <p>
              Крайне важно, чтобы в конечном итоге метод signallAllf) был вызван в каком-нибудь другом потоке
              исполнения. Когда метод await () вызывается в потоке исполнения, последний не имеет возможности повторно
              активизировать самого себя.
              И здесь он полностью полагается на другие потоки. Если ни один из них не позаботится о повторной
              активизации ожидающего потока, его выполнение никогда не
              возобновится. Это может привести к неприятной ситуации взаимной блокировки. Если
              все прочие потоки исполнения будут заблокированы, а метод await () будет вызван
              в последнем активном потоке без разблокировки какого-нибудь другого потока, этот
              поток также окажется заблокированным. И тогда не останется ни одного потока исполнения, где можно было бы
              разблокировать другие потоки, а следовательно, программа зависнет.

            </p>
            <p>
              Когда же следует вызывать метод signalAll ()? Существует эмпирическое правило: вызывать этот метод при
              таком изменении состояния объекта, которое может
              быть выгодно ожидающим потокам исполнения. Например, всякий раз, когда изменяются остатки на счетах,
              ожидающим потокам исполнения следует давать очередную возможность для проверки остатков на счетах. В
              данном примере метод
              signalAll () вызывается по завершении перевода денег, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">transfer</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">int</span> from, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">double</span> amount)</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> InterruptedException
   </span>{
      bankLock.lock();
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (accounts[from] &lt; amount)
            sufficientFunds.await();
         System.out.print(Thread.currentThread());
         accounts[from] -= amount;
         System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" %10.2f from %d to %d"</span>, amount, from, to);
         accounts[to] += amount;
         System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" Total Balance: %10.2f%n"</span>, getTotalBalance());
         sufficientFunds.signalAll();
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
      {
         bankLock.unlock();
      }
   }
</pre>
            <p>
              Следует, однако, иметь в виду, что вызов метода s i g n a l A l l () не влечет за собой
              немедленной активизации ожидающего потока исполнения. Он лишь разблокирует
              ожидающие потоки, чтобы они могли соперничать за объект блокировки после того,
              как текущий поток снимет блокировку.
            </p>
            <p>
              Другой метод, signal (), разблокирует только один поток из набора ожидания,
              выбирая его случайным образом. Это более эффективно, чем разблокировать все
              потоки, хотя здесь существует определенная опасность. Если случайно выбранный
              поток обнаружит, что еще не может продолжить свое исполнение, он вновь заблокируется. И если никакой
              другой поток не вызовет снова метод signal (), то система
              перейдет в состояние взаимной блокировки.
            </p>
            <p>
              Запустив на выполнение видоизмененный вариант имитирующей банк программы из листинга 14.7, вы обнаружите,
              что теперь она работает правильно. Общий баланс в $100000 сохраняется неизменным, и ни на одном из счетов
              нет отрицательного остатка. (Но для того чтобы прервать выполнение этой программы, вам снова
              придется нажать комбинацию клавиш < Ctrl+C >.) Вы можете также заметить, что программа работает немного
              медленнее — это та цена, которую приходится платить за
              дополнительные служебные операции, связанные с механизмом синхронизации.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> synch;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.concurrent.locks.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * A bank with a number of bank accounts that uses locks for serializing access.
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
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Lock bankLock;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Condition sufficientFunds;

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
      bankLock = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ReentrantLock();
      sufficientFunds = bankLock.newCondition();
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Transfers money from one account to another.
    * <span class="hljs-doctag">@param</span> from the account to transfer from
    * <span class="hljs-doctag">@param</span> to the account to transfer to
    * <span class="hljs-doctag">@param</span> amount the amount to transfer
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">transfer</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">int</span> from, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">double</span> amount)</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> InterruptedException
   </span>{
      bankLock.lock();
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (accounts[from] &lt; amount)
            sufficientFunds.await();
         System.out.print(Thread.currentThread());
         accounts[from] -= amount;
         System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" %10.2f from %d to %d"</span>, amount, from, to);
         accounts[to] += amount;
         System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" Total Balance: %10.2f%n"</span>, getTotalBalance());
         sufficientFunds.signalAll();
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
      {
         bankLock.unlock();
      }
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Gets the sum of all account balances.
    * <span class="hljs-doctag">@return</span> the total balance
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                   style="color: rgb(37, 127, 173);">getTotalBalance</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      bankLock.lock();
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> sum = <span class="hljs-number"
                                                                                                 style="color: rgb(147, 92, 37);">0</span>;

         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">double</span> a : accounts)
            sum += a;

         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> sum;
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
      {
         bankLock.unlock();
      }
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
          Что следует предпринимать если после захвата объекта дальнейшее исполнение зависит от выполнения условия?
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
          Что следует предпринимать если после захвата объекта дальнейшее исполнение зависит от выполнения условия?
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
  name: "IfBlocks",
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

      selected: 'Снять блокировку',
      options: [
        {
          item: 'Снять блокировку',
          name: 'Снять блокировку'
        },
        {
          item: 'Установить дополнительный reentrantlock',
          name: 'Установить дополнительный reentrantlock'
        },
        {
          item: 'Дать возможность на захват объекта ожидающим потокам с помощью метода await()',
          name: 'Дать возможность на захват объекта ожидающим потокам с помощью метода await()'
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
          numberTheme: 10,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[9].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 4.54
              window.frontendData.language.chapters[8].listThemes[9].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[9].task.answer

          window.frontendData.language.chapters[8].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[9].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[9].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[9].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[9].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[9].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-3-subtheme');

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