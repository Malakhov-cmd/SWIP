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
          Синхронизация
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В большинстве практических многопоточных приложений двум или более потокам исполнения приходится
              разделять общий доступ к одним и тем же данным. Что
              произойдет, если два потока исполнения имеют доступ к одному объекту и каждый
              из них вызывает метод, изменяющий состояние этого объекта? Нетрудно догадаться,
              что потоки исполнения станут наступать друг другу на пятки. В зависимости от порядка обращения к данным
              можно в конечном итоге получить поврежденный объект. Такая ситуация обычно называется состоянием гонок.

            </p>
            <p>
              Пример состояния гонок
            </p>
            <p>
              Чтобы избежать повреждения данных, совместно используемых многими потоками, нужно научиться
              синхронизировать доступ к ним. В этом разделе будет показано,
              что произойдет, если не применять синхронизацию. А в следующем разделе поясняется, как синхронизировать
              обращение к данным.
            </p>
            <p>
              В следующем примере тестовой программы имитируется банк со многими счетами. В ней будут случайным образом
              формироваться транзакции, переводящие деньги с одного счета на другой. Каждый счет владеет одним потоком
              исполнения. А каждая транзакция перемещает произвольную сумму денег со счета, обслуживаемого
              текущим потоком исполнения, на другой произвольно выбираемый счет.

            </p>
            <p>
              Код, имитирующий банк, достаточно прост. В нем определен класс Bank с методом transfer (). Этот метод
              перемещает некоторую сумму денег с одного счета
              на другой. (Не будем пока что обращать внимание на возможное появление отрицательных остатков на счетах.)
              Ниже приведен исходный код метода transfer () из
              класса Bank.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">transfer</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">int</span> from, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">double</span> amount)</span>
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// ВНИМАНИЕ: вызывать этот метод из </span>
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// нескольких потоков небезопасно!</span>
</span>{
System.out.print(Thread.currentThread());
accounts[from] -= amount;
System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" %10.2f from %d to %d"</span>, amount, from, to);
accounts[to] += amount;
System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" Total Balance: %10.2f%n"</span>, getTotalBalance());
}
</pre>
            <p>
              Ниже приведен исходный код для экземпляров типа Runnable. Метод run () переводит деньги с фиксированного
              банковского счета. В каждой транзакции метод run ()
              выбирает случайный целевой счет и произвольную сумму, вызывает метод transfer ()
              для объекта Bank, а затем переводит поток исполнения в состояние ожидания.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            Runnable г = () -&gt; {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
                    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">true</span>) {
                        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> toAccount = (<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span>) (bank.size() * Math.random());
                        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span>) (DELAY * Math.random()));
                    }
                } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (InterruptedException е) {
                }
            }</pre>
            <p>
              Когда выполняется данная имитация банка, неизвестно, какая именно сумма находится на любом банковском
              счете в произвольный момент времени. Но в то же
              время известно, что общая сумма денег по всем счетам должна оставаться неизменной, поскольку деньги
              только переводятся с одного счета на другой, а не снимаются
              окончательно.
            </p>
            <p>
              В конце каждой транзакции метод transfer () заново вычисляет итоговую сумму
              на счетах и выводит ее. Данная программа вообще не прекращает выполняться. Чтобы удалить ее, следует
              нажать комбинацию клавиш
              < Ctrl
              +C >. Ниже приведен типичный результат, выводимый данной программой.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Thread[Thread-<span
                class="hljs-number" style="color: rgb(147, 92, 37);">11</span>,<span class="hljs-number"
                                                                                     style="color: rgb(147, 92, 37);">5</span>,main]
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">12</span>,<span class="hljs-number"
                                                                                         style="color: rgb(147, 92, 37);">5</span>,main]
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">14</span>,<span class="hljs-number"
                                                                                         style="color: rgb(147, 92, 37);">5</span>,main]
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">13</span>,<span class="hljs-number"
                                                                                         style="color: rgb(147, 92, 37);">5</span>,main]
<span class="hljs-number" style="color: rgb(147, 92, 37);">588.48</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">11</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">44</span> Total Balance: <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100000.00</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">976.11</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">12</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">22</span> Total Balance: <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100000.00</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">521.51</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">14</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">22</span> Total Balance: <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100000.00</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">359.89</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">13</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">81</span> Total Balance: <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100000.00</span>
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">36</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">5</span>,main]
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">35</span>,<span class="hljs-number"
                                                                                         style="color: rgb(147, 92, 37);">5</span>,main]
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">37</span>,<span class="hljs-number"
                                                                                         style="color: rgb(147, 92, 37);">5</span>,main]
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">34</span>,<span class="hljs-number"
                                                                                         style="color: rgb(147, 92, 37);">5</span>,main]
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">36</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">5</span>,main]
<span class="hljs-number" style="color: rgb(147, 92, 37);">401.71</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">36</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">73</span> Total Balance: <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">99291.06</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">691.46</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">35</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">77</span> Total Balance: <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">99291.06</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">78.64</span> from <span class="hljs-number"
                                                                                   style="color: rgb(147, 92, 37);">37</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3</span> Total Balance: <span class="hljs-number"
                                                                                                     style="color: rgb(147, 92, 37);">99291.06</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">197.11</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">34</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">69</span> Total Balance: <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">99291.06</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">85.96</span> from <span class="hljs-number"
                                                                                   style="color: rgb(147, 92, 37);">36</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">4</span> Total Balance: <span class="hljs-number"
                                                                                                     style="color: rgb(147, 92, 37);">99291.06</span>
Thread[Thread-<span class="hljs-number" style="color: rgb(147, 92, 37);">4</span>,<span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">5</span>,main]Thread[Thread-<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">33</span>, <span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">5</span>,main] <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">7.31</span> from <span class="hljs-number"
                                                                                              style="color: rgb(147, 92, 37);">31</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">32</span>
Total Balance: <span class="hljs-number" style="color: rgb(147, 92, 37);">99979.24</span>
<span class="hljs-number" style="color: rgb(147, 92, 37);">627.50</span> from <span class="hljs-number"
                                                                                    style="color: rgb(147, 92, 37);">4</span> to <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">5</span> Total Balance: <span class="hljs-number"
                                                                                                     style="color: rgb(147, 92, 37);">99979.24</span></pre>
            <p>
              Kак видите, что-то в этой программе пошло не так. В течение нескольких транзакций общий баланс в
              имитируемом банке оставался равным сумме $100000, что
              совершенно верно, поскольку первоначально было 100 счетов по $1000 на каждом.
              Но через некоторое время общий баланс немного изменился. Запустив эту программу на выполнение, вы можете
              обнаружить, что ошибка возникнет очень быстро или
              же общий баланс будет нарушен нескоро. Такая ситуация не внушает доверия, и вы
              вряд ли захотите положить свои заработанные тяжким трудом денежки в такой банк!
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> unsynch;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program shows data corruption when multiple threads access a data structure.
 * <span class="hljs-doctag">@version</span> 1.31 2015-06-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">UnsynchBankTest</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">int</span> NACCOUNTS = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100</span>;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">double</span> INITIAL_BALANCE = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">double</span> MAX_AMOUNT = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1000</span>;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">static</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">final</span> <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">int</span> DELAY = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">10</span>;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      Bank bank = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Bank(NACCOUNTS, INITIAL_BALANCE);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; NACCOUNTS; i++)
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> fromAccount = i;
         Runnable r = () -&gt; {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
               <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (<span class="hljs-keyword"
                                                                                                 style="color: rgb(107, 107, 184);">true</span>)
               {
                  <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> toAccount = (<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span>) (bank.size() * Math.random());
                  <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> amount = MAX_AMOUNT * Math.random();
                  bank.transfer(fromAccount, toAccount, amount);
                  Thread.sleep((<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span>) (DELAY * Math.random()));
               }
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (InterruptedException e)
            {
            }
         };
         Thread t = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Thread(r);
         t.start();
      }
   }
}
</pre>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> unsynch;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * A bank with a number of bank accounts.
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
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">transfer</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">int</span> from, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> to, <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">double</span> amount)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (accounts[from] &lt; amount) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span>;
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" %10.2f from %d to %d"</span>, amount, from, to);
      accounts[to] += amount;
      System.out.printf(<span class="hljs-string" style="color: rgb(86, 140, 59);">" Total Balance: %10.2f%n"</span>, getTotalBalance());
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
            <p>
              Объяснение причин, приводящих к состоянию гонок
            </p>
            <p>
              В предыдущем разделе был рассмотрен пример программы, где остатки на банковских счетах обновлялись в
              нескольких потоках исполнения. По истечении некоторого времени в ней накапливаются ошибки, а в итоге
              некоторая сумма теряется или
              появляется неизвестно откуда. Подобная ошибка возникает в том случае, если в двух
              потоках исполнения предпринимается одновременная попытка обновить один и тот
              же счет. Допустим, в двух потоках исполнения одновременно выполняется следующая операция:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">accounts[to] += amount;</pre>
            <p>
              Дело в том, что такие операции не являются атомарными. Приведенная выше операция может быть выполнена
              поэтапно следующим образом.

            </p>
            <ul>
              <li>
                <p>
                  Загрузить значение из элемента массива accounts [to] в регистр.

                </p>
              </li>
              <li>
                <p>
                  Добавить значение amount.

                </p>
              </li>
              <li>
                <p>
                  Переместить результат обратно в элемент массива accounts [to].
                </p>
              </li>
            </ul>
            <p>
              А теперь представим, что в первом потоке выполняются операции из пп. 1 и 2,
              после чего его исполнение приостанавливается. Допустим, второй поток исполнения
              выходит из состояния ожидания, и в нем обновляется тот же самый элемент массива
              accounts. Затем выходит из состояния ожидания первый поток, и в нем выполняется
              операция из п. 3. Такое действие уничтожает изменения, внесенные во втором потоке
              исполнения. В итоге общий баланс оказывается подсчитанным неверно. Такое нарушение данных обнаруживается
              в рассматриваемой здесь тестовой программе. (Разумеется, существует вероятность получить сигнал ложной
              тревоги, если поток
              исполнения будет прерван во время тестирования!)
            </p>
            <p>
              Какова вероятность повредить данные? В рассматриваемом здесь примере вероятность проявления этого
              недостатка была увеличена за счет того, что операторы вывода перемежались операторами обновления общего
              баланса. Если пропустить операторы вывода, то риск повреждения немного снизится, поскольку в каждом
              потоке
              будет выполняться настолько мало операций, прежде чем он перейдет в состояние
              ожидания, что прерывание посреди вычислений окажется маловероятным.
            </p>
            <p>
              Но и в этом случае риск повреждения данных не исключается полностью. Если
              запустить достаточно много потоков исполнения на сильно загруженной машине, то
              программа даст сбой даже при отсутствии в ней операторов вывода. Сбой произойдет через минуты, часы или
              даже дни. Вообще говоря, для программиста нет ничего
              хуже, чем ошибка в программе, которая проявляется только раз в несколько дней.

            </p>
            <p>
              Суть рассматриваемой здесь программной ошибки состоит в том, что выполнение
              метода transfer () может быть прервано на полпути к его завершению. Если удастся
              гарантировать нормальное завершение этого метода до того, как его поток утратит
              управление, то состояние объекта банковского счета вообще не будет нарушено.

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
          Что привело к изменению данных об общем количестве денег на счетах?
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
          Что привело к изменению данных об общем количестве денег на счетах?
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
  name: "ExampleRaceCondition",
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

      selected: 'Совместная запись суммы в результате перевода со счета на счет несколькими методами',
      options: [
        {
          item: 'Совместная запись суммы в результате перевода со счета на счет несколькими методами',
          name: 'Совместная запись суммы в результате перевода со счета на счет несколькими методами'
        },
        {
          item: 'Неправильная организация метода перевода денег',
          name: 'Неправильная организация метода перевода денег'
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
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[8].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[8].chapterProgress += 8.3
              window.frontendData.language.chapters[8].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[8].listThemes[7].task.answer

          window.frontendData.language.chapters[8].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[8].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[8].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[8].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[8].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[8].listThemes[7].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-9-chapter-4-theme-1-subtheme');

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