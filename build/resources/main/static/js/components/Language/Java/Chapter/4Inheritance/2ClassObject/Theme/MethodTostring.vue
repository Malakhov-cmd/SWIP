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
          Метод toString()

        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Еще одним важным в классе Object является метод toString (), возвращающий
              значение объекта в виде символьной строки. В качестве примера можно привести метод toString () из класса
              Point, который возвращает символьную строку, подобную
              приведенной ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">java.awt.Point[x=<span
                class="hljs-number" style="color: rgb(147, 92, 37);">10</span>, y=<span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">20</span>]</pre>

            <p>
              Большая часть, но не все методы toString () возвращают символьную строку, состоящую из имени класса,
              после которого следуют значения его полей в квадратных
              скобках. Ниже приведен пример реализации метода toString () в классе Employee.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
                class="hljs-title" style="color: rgb(37, 127, 173);">toStrin</span><span class="hljs-params"
                                                                                         style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-string"
                                                                                          style="color: rgb(86, 140, 59);">"Employee[name="</span> + name
                + <span class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span> + salary
                + <span class="hljs-string" style="color: rgb(86, 140, 59);">"]"</span>;
    }</pre>
            <p>
              На самом деле этот метод можно усовершенствовать. Вместо жесткого кодирования
              имени класса в методе toString () достаточно вызвать метод getClass () . getName ()
              и получить символьную строку, содержащую имя класса, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
                class="hljs-title" style="color: rgb(37, 127, 173);">toString</span><span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">()</span>
</span>{
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> getClass().getName()
+ ’’[name=’’ + name
+ M,salary=<span class="hljs-string" style="color: rgb(86, 140, 59);">" + salary
+ "</span>,hireDay=<span class="hljs-string" style="color: rgb(86, 140, 59);">" + hireDay
+ ” ] "</span> ;
}</pre>
            <p>
              Такой метод toStringO пригоден для подклассов. Разумеется, при создании
              подкласса следует определить собственный метод toString () и добавить поля подкласса. Так, если в
              суперклассе делается вызов getClass () .getName (), то в подклассе просто вызывается метод super
              .ToString (). Ниже приведен пример реализации
              метода toString () в классе Manager,

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
<span class="hljs-title" style="color: rgb(37, 127, 173);">public</span> <span class="hljs-title"
                                                                               style="color: rgb(37, 127, 173);">String</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">toString</span>()
</span>{
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(107, 107, 184);">super</span>.toString()
+ <span class="hljs-string" style="color: rgb(86, 140, 59);">" [bonus=M + bonus
+ "</span>]<span class="hljs-string" style="color: rgb(86, 140, 59);">";
}</span></pre>
            <p>
              Теперь состояние объекта типа Manager выводится следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager[name=...,salary=...,hireDay=...][bonus=...]
</pre>
            <p>
              Метод toString () универсален. Имеется следующее веское основание для его реализации в каждом классе:
              если объект объединяется с символьной строкой с помощью операции +, компилятор Java автоматически
              вызывает метод toString (), чтобы
              получить строковое представление этого объекта:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Point р = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Point(<span class="hljs-number"
                                                                                               style="color: rgb(147, 92, 37);">10</span>, <span
                class="hljs-number" style="color: rgb(147, 92, 37);">20</span>);
String message = ’’The current position is ” + p;
</pre>
            <p>
              Если х — произвольный объект и в программе имеется следующая строка кода:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out.println(х);</pre>
            <p>
              то из метода println() будет вызван метод х.toStringO и выведена символьная
              строка результата. Метод toStringO, определенный в классе Object, выводит имя
              класса и адрес объекта. Рассмотрим следующий вызов:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out.println(System.out);</pre>
            <p>
              После выполнения метода println() отображается такая строка:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">java.io.PrintStream@<span
                class="hljs-number" style="color: rgb(147, 92, 37);">2f</span>6684
</pre>
            <p>
              Как видите, разработчики класса PrintStream не позаботились о переопределении метода toString ().

            </p>
            <p>
              Метод toString () отлично подходит для регистрации и протоколирования. Он
              определен во многих классах из стандартной библиотеки Java, что позволяет получать полезные сведения о
              состоянии объекта. Так, например, для регистрации сообщений можно применить следующее выражение:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out.println(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Current position = "</span> + position);</pre>
            <p>
              Как будет показано в главе 7, существует решение и получше: воспользоваться
              объектом класса Logger и сделать следующий вызов:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Logger.global.info(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Current position = "</span> + position);</pre>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> equals;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates the equals method.
 * <span class="hljs-doctag">@version</span> 1.12 2012-01-26
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">EqualsTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      Employee alice1 = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Alice Adams"</span>, <span class="hljs-number"
                                                                                                   style="color: rgb(147, 92, 37);">75000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1987</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">12</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">15</span>);
      Employee alice2 = alice1;
      Employee alice3 = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Alice Adams"</span>, <span class="hljs-number"
                                                                                                   style="color: rgb(147, 92, 37);">75000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1987</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">12</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">15</span>);
      Employee bob = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Bob Brandson"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">50000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1989</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">10</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>);

      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"alice1 == alice2: "</span> + (alice1 == alice2));

      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"alice1 == alice3: "</span> + (alice1 == alice3));

      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"alice1.equals(alice3): "</span> + alice1.equals(alice3));

      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"alice1.equals(bob): "</span> + alice1.equals(bob));

      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"bob.toString(): "</span> + bob);

      Manager carl = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Manager(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Carl Cracker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">80000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1987</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">12</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">15</span>);
      Manager boss = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Manager(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Carl Cracker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">80000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1987</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">12</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">15</span>);
      boss.setBonus(<span class="hljs-number" style="color: rgb(147, 92, 37);">5000</span>);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"boss.toString(): "</span> + boss);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"carl.equals(boss): "</span> + carl.equals(boss));
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"alice1.hashCode(): "</span> + alice1.hashCode());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"alice3.hashCode(): "</span> + alice3.hashCode());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"bob.hashCode(): "</span> + bob.hashCode());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"carl.hashCode(): "</span> + carl.hashCode());
   }
}</pre>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> equals;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.*;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.Objects;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> salary;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> LocalDate hireDay;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String name, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> salary, <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">int</span> year, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> month, <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> day)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.name = name;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.salary = salary;
      hireDay = LocalDate.of(year, month, day);
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getName</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> name;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                   style="color: rgb(37, 127, 173);">getSalary</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> salary;
   }

   <span class="hljs-function"><span class="hljs-keyword"
                                     style="color: rgb(107, 107, 184);">public</span> LocalDate <span class="hljs-title"
                                                                                                      style="color: rgb(37, 127, 173);">getHireDay</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> hireDay;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">raiseSalary</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">double</span> byPercent)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> raise = salary * byPercent / <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">100</span>;
      salary += raise;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">equals</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(Object otherObject)</span>
   </span>{
      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// a quick test to see if the objects are identical</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (<span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">this</span> == otherObject) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">true</span>;

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// must return false if the explicit parameter is null</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (otherObject == <span class="hljs-keyword"
                                                                                                    style="color: rgb(107, 107, 184);">null</span>) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">false</span>;

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// if the classes don't match, they can't be equal</span>
      <span class="hljs-keyword"
            style="color: rgb(107, 107, 184);">if</span> (getClass() != otherObject.getClass()) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">false</span>;

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// now we know otherObject is a non-null Employee</span>
      Employee other = (Employee) otherObject;

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// test whether the fields have identical values</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Objects.equals(name, other.name) &amp;&amp; salary == other.salary &amp;&amp; Objects.equals(hireDay, other.hireDay);
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">hashCode</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Objects.hash(name, salary, hireDay);
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">toString</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> getClass().getName() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"[name="</span> + name + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span> + salary + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",hireDay="</span> + hireDay
            + <span class="hljs-string" style="color: rgb(86, 140, 59);">"]"</span>;
   }
}
</pre>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> equals;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Manager</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> bonus;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">(String name, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> salary, <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">int</span> year, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> month, <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> day)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>(name, salary, year, month, day);
      bonus = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                   style="color: rgb(37, 127, 173);">getSalary</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> baseSalary = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.getSalary();
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> baseSalary + bonus;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">setBonus</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">double</span> bonus)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.bonus = bonus;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">equals</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(Object otherObject)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (!<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">super</span>.equals(otherObject)) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">false</span>;
      Manager other = (Manager) otherObject;
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// super.equals checked that this and other belong to the same class</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> bonus == other.bonus;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                style="color: rgb(37, 127, 173);">hashCode</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> java.util.Objects.hash(<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.hashCode(), bonus);
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">toString</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                        style="color: rgb(107, 107, 184);">super</span>.toString() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"[bonus="</span> + bonus + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"]"</span>;
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>

public class Test {
    public static void main(String[] args) {
        Triangle triangeOriginal = new Triangle(2, 5);

        System.out.println(triangeOriginal.toString());
    }
}

abstract class Point {
    private int xPoint;
    private int yPoint;

    public int getxPoint() {
        return xPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }
}

abstract class Figura extends Point {
    private Point point;

    private int x;

    public Figura(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    abstract public double getSquareValue();

    @Override
    public int getxPoint() {
        return super.getxPoint();
    }

    @Override
    public void setxPoint(int xPoint) {
        super.setxPoint(xPoint);
    }

    @Override
    public int getyPoint() {
        return super.getyPoint();
    }

    @Override
    public void setyPoint(int yPoint) {
        super.setyPoint(yPoint);
    }
}

class Square extends Figura {
    public Square(int x) {
        super(x);
    }

    @Override
    public double getSquareValue() {
        return getX() * getX();
    }
}

class Triangle extends Figura {
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Triangle triangleObj = (Triangle) obj;

        return getX() == triangleObj.getX()
                && this.h == triangleObj.h;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash * getX();
        hash = 31 * hash * h;

        return hash;
    }

    @Override
    public String toString() {
        return "x value is " + getX() + " h value is " + h;
    }

    @Override
    public double getSquareValue() {
        return 0.5 * h * getX();
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
  name: "MethodTostring",
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
        {item: 'x value is 2 h value is 5', name: 'x value is 2 h value is 5'},
        {item: 'x h value is 5 value is 2', name: 'x h value is 5 value is 2'},
        {item: 'Triangle x = 2, y = 5', name: 'Triangle x = 2, y = 5'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/fourthchapter/', {
        params: {
          numberTheme: 11,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[10].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[10].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[10].task.answer

          window.frontendData.language.chapters[3].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[10].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[10].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[10].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[10].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[10].task.answer
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
        `
public class Test {
    public static void main(String[] args) {
        Triangle triangeOriginal = new Triangle(2, 5);

        System.out.println(triangeOriginal.toString());
    }
}

abstract class Point {
    private int xPoint;
    private int yPoint;

    public int getxPoint() {
        return xPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }
}

abstract class Figura extends Point {
    private Point point;

    private int x;

    public Figura(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    abstract public double getSquareValue();

    @Override
    public int getxPoint() {
        return super.getxPoint();
    }

    @Override
    public void setxPoint(int xPoint) {
        super.setxPoint(xPoint);
    }

    @Override
    public int getyPoint() {
        return super.getyPoint();
    }

    @Override
    public void setyPoint(int yPoint) {
        super.setyPoint(yPoint);
    }
}

class Square extends Figura {
    public Square(int x) {
        super(x);
    }

    @Override
    public double getSquareValue() {
        return getX() * getX();
    }
}

class Triangle extends Figura {
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Triangle triangleObj = (Triangle) obj;

        return getX() == triangleObj.getX()
                && this.h == triangleObj.h;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash * getX();
        hash = 31 * hash * h;

        return hash;
    }

    @Override
    public String toString() {
        return "x value is " + getX() + " h value is " + h;
    }

    @Override
    public double getSquareValue() {
        return 0.5 * h * getX();
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

    let themeToClose = document.getElementById('java-4-chapter-2-theme-5-subtheme');

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