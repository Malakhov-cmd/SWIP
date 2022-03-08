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
          Параметры методов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Рассмотрим термины, которые употребляются для описания способа передачи
              параметров методам (или функциям) в языках программирования. Термин вызов
              по значению означает, что метод получает значение, переданное ему из вызывающей
              части программы. Вызов по ссылке означает, что метод получает из вызывающей части
              программы местоположение переменной. Таким образом, метод может модифицировать (т.е. видоизменить)
              значение переменной, передаваемой по ссылке, но не переменной, передаваемой по значению. Фраза "вызов
              по..." относится к стандартной
              компьютерной терминологии, описывающей способ передачи параметров в различных языках программирования, а
              не только в Java. (На самом деле существует еще
              и третий способ передачи параметров — вызов по имени, представляющий в основном
              исторический интерес, поскольку он был применен в языке Algol, который относится
              к числу самых старых языков программирования высокого уровня.)
            </p>
            <p>
              В языке Java всегда используется только вызов по значению. Это означает, что
              метод получает копии значений всех своих параметров. По этой причине метод не
              может видоизменить содержимое ни одной из переменных, передаваемых ему в качестве параметров.

            </p>
            <p>
              Рассмотрим для примера следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> percent = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">10</span>;
harry.raiseSalary(percent) ;</pre>


            <p>
              Каким бы образом ни был реализован метод, после его вызова значение переменной p ercent все равно
              останется равным 10.

            </p>
            <p>
              Проанализируем эту ситуацию подробнее. Допустим, в методе предпринимается
              попытка утроить значение параметра, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">   <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">tripleValue</span><span class="hljs-params"
                                                                                             style="color: rgb(147, 92, 37);">(<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> x)</span></span>; <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// не сработает!</span>
   {
      x = <span class="hljs-number" style="color: rgb(147, 92, 37);">3</span> * x;
   }</pre>
            <p>
              }
              Если вызвать этот метод следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> percent = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">10</span>;
tripleValue(percent) </pre>

            <p>
              такой прием не сработает. После вызова метода значение переменной percent
              по-прежнему остается равным 10. В данном случае происходит следующее.
            </p>


            <ul>
              <li>
                <p>Переменная х инициализируется копией значения параметра percent
                  (т.е. числом 10)
                </p>
              </li>
              <li>
                <p>
                  Значение переменной х утраивается, и теперь оно равно 30. Но значение переменной p ercent по-прежнему
                  остается равным 10
                </p>>
              </li>
              <li>
                <p>
                  Метод завершает свою работу, и его переменный параметр х больше не используется
                </p>
              </li>
            </ul>

            <p>
              Но существуют два следующих типа параметров методов.

            </p>

            <ul>
              <li>
                <p>Примитивные типы (т.е. числовые и логические значения).
                </p>
              </li>
              <li>
                <p>
                  Ссылки на объекты
                </p>
              </li>
            </ul>


            <p>
              Как было показано выше, методы не могут видоизменить параметры примитивных типов. Совсем иначе дело
              обстоит с объектами. Нетрудно реализовать метод,
              утраивающий зарплату работников, следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">   <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">tripleSalary</span><span class="hljs-params"
                                                                                              style="color: rgb(147, 92, 37);">(Employee x)</span> <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// сработает!</span>
   </span>{
      x.raiseSalary(<span class="hljs-number" style="color: rgb(147, 92, 37);">200</span>);
   }</pre>
            <p>
              При выполнении следующего фрагмента кода происходят перечисленные ниже
              действия.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">harry = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(...);
tripleSalary(harry);</pre>
            <ul>
              <li>
                <p>Переменная x инициализируется копией значения переменной harry, т.е.
                  ссылкой на объект.
                </p>
              </li>
              <li>
                <p>
                  Метод raiseSalary () применяется к объекту по этой ссылке. В частности,
                  объект типа Employee, доступный по ссылкам х и harry, получает сумму зарплаты работников, увеличенную
                  на 2
                </p>
              </li>
              <li>
                <p>
                  Метод завершает свою работу, и его параметр х больше не используется. Разумеется, переменная harry
                  продолжает ссылаться на объект, где зарплата увеличена втрое
                </p>
              </li>
            </ul>
            <p>
              Как видите, реализовать метод, изменяющий состояние объекта, передаваемого
              как параметр, совсем не трудно. В действительности такие изменения вносятся очень
              часто по следующей простой причине: метод получает копию ссылки на объект, поэтому копия и оригинал
              ссылки указывают на один и тот же объект.
            </p>
            <p>
              Во многих языках программирования (в частности, C++ и Pascal) предусмотрены
              два способа передачи параметров: вызов по значению и вызов по ссылке. Некоторые
              программисты (и, к сожалению, даже авторы некоторых книг) утверждают, что в Java
              при передаче объектов используется вызов по ссылке. Но это совсем не так. Для того
              чтобы развеять это бытующее заблуждение, обратимся к конкретному примеру.
              Ниже приведен метод, выполняющий обмен двух объектов типа Employee.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">   <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">swap</span><span class="hljs-params"
                                                                                      style="color: rgb(147, 92, 37);">(Employee x, Employee у)</span> <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// не сработает!</span>
   </span>{
      Employee temp = x;
      x = y;
   }</pre>
            <p>
              Если бы в Java для передачи объектов в качестве параметров использовался вызов
              по ссылке, этот метод действовал бы следующим образом:
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee а = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string"
                                                                                                  style="color: rgb(86, 140, 59);">"Alice"</span>, . . .);
Employee b = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string"
                                                                                                     style="color: rgb(86, 140, 59);">"Bob"</span>, . . .);
swap(a, b);
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// ссылается ли теперь переменная а на Bob, а переменная b - на Alice?</span></pre>

            <p>
              Но на самом деле этот метод не меняет местами ссылки на объекты, хранящиеся
              в переменных а и Ь. Сначала параметры х и у метода swap () инициализируются
              копиями этих ссылок, а затем эти копии меняются местами в данном методе, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// переменная х ссылается на Alice, а переменная у - на Bob</span>
Employee temp = х;
х = у;
у = temp;
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// теперь переменная х ссылается на Bob, а переменная у - на Alice</span></pre>
            <p>
              В конце концов, следует признать, что все было напрасно. По завершении работы
              данного метода переменные х и у уничтожаются, а исходные переменные а и b продолжают ссылаться на прежние
              объекты
            </p>
            <p>
              Таким образом, в Java для передачи объектов не применяется вызов по ссылке.
              Вместо этого ссылки на объекты передаются по значению. Ниже поясняется, что может и чего он не может
              метод делать со своими параметрами.
            </p>
            <ul>
              <li>
                <p>Метод не может изменять параметры примитивных типов (т.е. числовые и логические значения).
                </p>
              </li>
              <li>
                <p>
                  Метод может изменять состояние объекта, передаваемого в качестве параметра. </p>
              </li>
              <li>
                <p>
                  Метод не может делать в своих параметрах ссылки на новые объекты.</p>
              </li>
            </ul>
            <p>
              Все эти положения демонстрируются в примере программы из листингa. Сначала в ней предпринимается
              безуспешная попытка утроить значение числового параметра.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Testing tripleValue:
(Тестирование метода tripleValue())
Before: percent=<span class="hljs-number" style="color: rgb(147, 92, 37);">10.0</span>
(До выполнения)
End of method: x=<span class="hljs-number" style="color: rgb(147, 92, 37);">30.0</span>
(В конце метода)
After: percent=<span class="hljs-number" style="color: rgb(147, 92, 37);">10.0</span>
(После выполнения)
</pre>
            <p>
              Затем в программе успешно утраивается зарплата работника.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Testing tripleSalary:
(Тестирование метода tripleSalary())
B e f o r e : s a l a r y = <span class="hljs-number" style="color: rgb(147, 92, 37);">5</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span> <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">0</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span> <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">0</span> .О
E n d of m e t h o d : s a l a r y = <span class="hljs-number" style="color: rgb(147, 92, 37);">1</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">5</span> <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">0</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span> <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">0</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span> .О
A f t e r : s a l a r y = <span class="hljs-number" style="color: rgb(147, 92, 37);">1</span> <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">5</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span> <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">0</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span> <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">0</span> . <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span></pre>
            <p>
              После выполнения метода состояние объекта, на который ссылается переменная
              harry, изменяется. Ничего невероятного здесь нет, поскольку в данном методе состояние объекта было
              модифицировано по копии ссылки на него. И наконец, в программе демонстрируется безрезультатность работы
              метода swap ().

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Testing swap:
(Тестирование метода swapO)
B e f o r e : a = A l i c e
B e f o r e : b = B o b
E n d o f m e t h o d : x = B o b
E n d of m e t h o d : y = A l i c e
A f t e r : a = A l i c e
A f t e r : b = B o b</pre>
            <p>
              Как видите, переменные параметры х и у меняются местами, но исходные переменные а и b остаются без
              изменения.
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates parameter passing in Java.
 * <span class="hljs-doctag">@version</span> 1.00 2000-01-27
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">ParamTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">/*
       * Test 1: Methods can't modify numeric parameters
       */</span>
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Testing tripleValue:"</span>);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> percent = <span class="hljs-number"
                                                                                                  style="color: rgb(147, 92, 37);">10</span>;
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Before: percent="</span> + percent);
      tripleValue(percent);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"After: percent="</span> + percent);

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">/*
       * Test 2: Methods can change the state of object parameters
       */</span>
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"\nTesting tripleSalary:"</span>);
      Employee harry = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry"</span>, <span class="hljs-number"
                                                                                             style="color: rgb(147, 92, 37);">50000</span>);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Before: salary="</span> + harry.getSalary());
      tripleSalary(harry);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"After: salary="</span> + harry.getSalary());

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">/*
       * Test 3: Methods can't attach new objects to object parameters
       */</span>
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"\nTesting swap:"</span>);
      Employee a = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Alice"</span>, <span class="hljs-number"
                                                                                             style="color: rgb(147, 92, 37);">70000</span>);
      Employee b = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Bob"</span>, <span class="hljs-number"
                                                                                           style="color: rgb(147, 92, 37);">60000</span>);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Before: a="</span> + a.getName());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Before: b="</span> + b.getName());
      swap(a, b);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"After: a="</span> + a.getName());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"After: b="</span> + b.getName());
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">tripleValue</span><span class="hljs-params"
                                                                                    style="color: rgb(147, 92, 37);">(<span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> x)</span> <span class="hljs-comment"
                                                                                             style="color: rgb(113, 149, 168);">// doesn't work</span>
   </span>{
      x = <span class="hljs-number" style="color: rgb(147, 92, 37);">3</span> * x;
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"End of method: x="</span> + x);
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">tripleSalary</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(Employee x)</span> <span
       class="hljs-comment" style="color: rgb(113, 149, 168);">// works</span>
   </span>{
      x.raiseSalary(<span class="hljs-number" style="color: rgb(147, 92, 37);">200</span>);
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"End of method: salary="</span> + x.getSalary());
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">swap</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(Employee x, Employee y)</span>
   </span>{
      Employee temp = x;
      x = y;
      y = temp;
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"End of method: x="</span> + x.getName());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"End of method: y="</span> + y.getName());
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> // <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">simplified</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> <span class="hljs-title"
                                                                               style="color: rgb(37, 127, 173);">class</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> salary;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String n, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> s)</span>
   </span>{
      name = n;
      salary = s;
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
        Cube cube = new Cube(2, 2, 2);

        OperationClass.multyplyerSides(cube, 3);

        System.out.println(cube.getValue());
    }
}

class Cube {
    private int x;
    private int y;
    private int z;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getValue() {
        return this.x * this.y * this.z;
    }
}

class OperationClass {
    public static Cube multyplyerSides(Cube cube, int multyplyer) {
        cube.setX(cube.getX() * multyplyer);
        cube.setY(cube.getY() * multyplyer);
        cube.setZ(cube.getZ() * multyplyer);

        return cube;
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
  name: "ParamethrMethods",
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
        {item: '196', name: '196'},
        {item: '36', name: '36'},
        {item: '216', name: '216'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/thirdchapter/', {
        params: {
          numberTheme: 16,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[15].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[15].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[15].task.answer

          window.frontendData.language.chapters[2].listThemes[15].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[15].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[15].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[15].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[15].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[15].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[15].task.answer
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
        Cube cube = new Cube(2, 2, 2);

        OperationClass.multyplyerSides(cube, 3);

        System.out.println(cube.getValue());
    }
}

class Cube {
    private int x;
    private int y;
    private int z;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getValue() {
        return this.x * this.y * this.z;
    }
}

class OperationClass {
    public static Cube multyplyerSides(Cube cube, int multyplyer) {
        cube.setX(cube.getX() * multyplyer);
        cube.setY(cube.getY() * multyplyer);
        cube.setZ(cube.getZ() * multyplyer);

        return cube;
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

    let themeToClose = document.getElementById('java-3-chapter-5-theme');

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