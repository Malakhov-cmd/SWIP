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
          Абстрактные классы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Чем дальше вверх по иерархии наследования, тем более универсальными и абстрактными становятся классы. В
              некотором смысле родительские классы, находящиеся на верхней ступени иерархии, становятся настолько
              абстрактными, что их рассматривают как основу для разработки других классов, а не как классы, позволяющие
              создавать конкретные объекты. Например, работник — это человек, а человек может
              быть и студентом. Поэтому расширим иерархию, в которую входит класс Employee,
              добавив в нее классы Person и Student.
            </p>

            <p>А зачем вообще столь высокий уровень абстракции? Существуют определенные
              свойства, характерные для каждого человека, например имя. Ведь у работников вообще и у студентов в
              частности имеются свои имена, и поэтому при внедрении общего
              суперкласса придется перенести метод getName () на более высокий уровень в иерархии наследования
            </p>
            <p>А теперь введем новый метод getDescriptionO, предназначенный для составления краткой характеристики
              человека, например:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">an employee with a salary of $<span
                class="hljs-number" style="color: rgb(147, 92, 37);">50</span>,<span class="hljs-number"
                                                                                     style="color: rgb(147, 92, 37);">000.00</span>
(работник с годовой зарплатой <span class="hljs-number" style="color: rgb(147, 92, 37);">50</span> тыс. долларов США)
<span class="hljs-function">a student majoring in computer <span class="hljs-title" style="color: rgb(37, 127, 173);">science</span>
<span class="hljs-params"
      style="color: rgb(147, 92, 37);">(студент, изучающий вычислительную технику)</span></span></pre>
            <p>
              Для классов Employee и Student такой метод реализуется довольно просто.
              Но какие сведения о человеке следует разместить в класс Person? Ведь в нем ничего нет, кроме имени.
              Разумеется, можно было бы реализовать метод Person.
              getDescription (), возвращающий пустую строку. Но есть способ получше. От реализации этого метода в
              классе Person можно вообще отказаться, если воспользоваться ключевым словом abstract, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">abstract</span> String getDescriptionO;
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// реализация не требуется</span></pre>
            <p>
              Для большей ясности класс, содержащий один или несколько абстрактных методов, можно объявить абстрактным
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">abstract</span> <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Person</span></span>{
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
    class="hljs-keyword" style="color: rgb(107, 107, 184);">abstract</span> String <span class="hljs-title"
                                                                                         style="color: rgb(37, 127, 173);">getDescription</span><span
    class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>;
}</pre>
            <p>
              Помимо абстрактных методов, абстрактные классы могут содержать конкретные
              поля и методы. Например, в классе Person хранится имя человека и содержится конкретный метод,
              возвращающий это имя

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">abstract</span> <span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Person</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Person</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">(String name)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.name = name;
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">abstract</span> String <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">getDescription</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getName</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> name;
    }
}</pre>
            <p>
              Абстрактные методы представляют собой прототипы методов, реализованных в подклассах. Расширяя абстрактный
              класс, можно оставить некоторые или все абстрактные
              методы неопределенными. При этом подкласс также станет абстрактным. Если даже
              определить все методы, то и тогда подкласс не перестанет быть абстрактным.
            </p>

            <p>
              Определим, например, класс Student, расширяющий абстрактный класс Person
              и реализующий метод getDescription (). Ни один из методов в классе Student не
              является абстрактным, поэтому нет никакой необходимости объявлять сам класс абстрактным. Впрочем, класс
              может быть объявлен абстрактным, даже если он и не содержит ни одного абстрактного метода.

            </p>

            <p>
              Создать экземпляры абстрактного класса нельзя. Например, приведенное ниже
              выражение ошибочно. Но можно создать объекты конкретного подкласса.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Person(<span class="hljs-string"
                                                                                                style="color: rgb(86, 140, 59);">"Vince VuM);
</span></pre>
            <p>
              Следует иметь в виду, что для абстрактных классов можно создавать объектные переменные, но такие
              переменные должны ссылаться на объект неабстрактного класса.
              Рассмотрим следующую строку кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Person р = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Student(<span class="hljs-string"
                                                                                                 style="color: rgb(86, 140, 59);">"Vince Vu"</span>, <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Economics"</span>);</pre>
            <p>
              где p — переменная абстрактного типа Person, ссылающаяся на экземпляр неабстрактного подкласса Student.

            </p>
            <p>
              Определим конкретный подкласс Student, расширяющий абстрактный класс
              Person, следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Student</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Person</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String major;

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">Student</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String name, String major)</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>(name);
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.major = major;
    }

    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getDescription</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-string"
                                                                                          style="color: rgb(86, 140, 59);">"a student majoring in "</span> + major;
    }
}</pre>
            <p>
              В этом подклассе определяется метод getDescription (). Все методы из класса Student являются конкретными,
              а следовательно, класс больше не является
              абстрактным.
            </p>
            <p>
              В примере программы из листинга 5.4 определяются один абстрактный суперкласс Person (из листинга 5.5) и
              два конкретных подкласса, Employee (из листинга 5.6)
              и Student (из листинга 5.7). Сначала в этой программе массив типа Person заполняется ссылками на
              экземпляры классов Employee и Student:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Person[] people = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Person[<span class="hljs-number"
                                                                                                style="color: rgb(147, 92, 37);">2</span>];
people[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">new</span> Employee(. . .);
people[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>] = <span class="hljs-keyword"
                                                                                    style="color: rgb(107, 107, 184);">new</span> Student(. . .);
</pre>
            <p>
              Затем имена и описания сотрудников, представленных этими объектами, выводятся следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Person р : people)
System.out.println(p.getName() + <span class="hljs-string" style="color: rgb(86, 140, 59);">", "</span> + p.getDescription());
</pre>
            <p>
              Некоторых читателей присутствие вызова р.getDescription() в приведенной
              выше строке кода может озадачить. Не относится ли он к неопределенному методу?
              Следует иметь в виду, что переменная р вообще не ссылается ни на один из объектов абстрактного класса
              Person, поскольку создать такой объект просто невозможно.
              Переменная р ссылается на объект конкретного подкласса, например Employee или
              Student. А для этих объектов метод getDescriprion () определен.

            </p>
            <p>
              Можно ли пропустить в классе Person все абстрактные методы и определить метод
              getDescription () в подклассах Employee и Student? Это не будет ошибкой, но тогда
              метод getDescription () нельзя будет вызвать с помощью переменной р. Компилятор
              гарантирует, что вызываются только те методы, которые определены в классе
            </p>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> abstractClasses;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates abstract classes.
 * <span class="hljs-doctag">@version</span> 1.01 2004-02-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">PersonTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      Person[] people = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Person[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">2</span>];

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// fill the people array with Student and Employee objects</span>
      people[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry Hacker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">50000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1989</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">10</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>);
      people[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>] = <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">new</span> Student(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Maria Morris"</span>, <span class="hljs-string"
                                                                                                    style="color: rgb(86, 140, 59);">"computer science"</span>);

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// print out names and descriptions of all Person objects</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Person p : people)
         System.out.println(p.getName() + <span class="hljs-string" style="color: rgb(86, 140, 59);">", "</span> + p.getDescription());
   }
}</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> abstractClasses;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(107, 107, 184);">abstract</span> <span
                  class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">Person</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">abstract</span> String <span class="hljs-title"
                                                                                            style="color: rgb(37, 127, 173);">getDescription</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Person</span><span class="hljs-params"
                                                                               style="color: rgb(147, 92, 37);">(String name)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.name = name;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getName</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> name;
   }
}
</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> abstractClasses;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.*;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Employee</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Person</span>
</span>{
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
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>(name);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.salary = salary;
      hireDay = LocalDate.of(year, month, day);
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

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getDescription</span><span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> String.format(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"an employee with a salary of $%.2f"</span>, salary);
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

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> abstractClasses;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Student</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Person</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String major;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * <span class="hljs-doctag">@param</span> nama the student's name
    * <span class="hljs-doctag">@param</span> major the student's major
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Student</span><span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">(String name, String major)</span>
   </span>{
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// pass n to superclass constructor</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>(name);
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.major = major;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">getDescription</span><span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-string"
                                                                                        style="color: rgb(86, 140, 59);">"a student majoring in "</span> + major;
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
        Figura triange = new Triangle(2, 5);

        triange.setxPoint(8);
        triange.setyPoint(4);

        System.out.println(triange.getxPoint() + " " + triange.getyPoint());
    }
}

abstract class Point{
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

abstract class Figura extends Point{
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
        return getX()*getX();
    }
}

class Triangle extends Figura{
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public double getSquareValue() {
        return 0.5*h*getX();
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
  name: "AbstractClasses",
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
        {item: '8 4', name: '8 4'},
        {item: '4 8', name: '4 8'},
        {item: '\"\"', name: '\"\"'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/fourthchapter/', {
        params: {
          numberTheme: 6,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[5].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[5].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[5].task.answer

          window.frontendData.language.chapters[3].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[5].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[5].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[5].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[5].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[5].task.answer
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
        Figura triange = new Triangle(2, 5);

        triange.setxPoint(8);
        triange.setyPoint(4);

        System.out.println(triange.getxPoint() + " " + triange.getyPoint());
    }
}

abstract class Point{
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

abstract class Figura extends Point{
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
        return getX()*getX();
    }
}

class Triangle extends Figura{
    private int h;

    public Triangle(int x, int h) {
        super(x);
        this.h = h;
    }

    @Override
    public double getSquareValue() {
        return 0.5*h*getX();
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

    let themeToClose = document.getElementById('java-4-chapter-1-theme-6-subtheme');

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