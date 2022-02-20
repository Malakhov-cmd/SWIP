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
          Клонирование объектов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Интерфейсы и абстрактные классы
            </p>

            <p>
              В этом разделе рассматривается интерфейс Cloneable, который обозначает, что
              в классе предоставляется надежный метод clone (). Клонирование объектов производится нечасто, а
              подробности данного процесса носят совершенно технический характер, поэтому вы можете не обращаться к
              материалу этого раздела до тех пор,
              пока он вам не понадобится.

            </p>

            <p>
              Чтобы понять назначение клонирования объектов, напомним, что же происходит,
              когда создается копия переменной, содержащей ссылку на объект. В этом случае оригинал и копия переменной
              содержат ссылки на один и тот же объект. Это
              означает, что изменение одной переменной повлечет за собой изменение другой
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee original = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span class="hljs-string"
                                                                                                  style="color: rgb(86, 140, 59);">"John Public"</span>, <span
                class="hljs-number" style="color: rgb(147, 92, 37);">50000</span>);
Employee copy = original;
copy.raiseSalary(<span class="hljs-number" style="color: rgb(147, 92, 37);">10</span>); <span class="hljs-comment"
                                                                                              style="color: rgb(113, 149, 168);">// Оригинал тоже изменился!</span>
</pre>
            <p>
              Если же требуется, чтобы переменная сору представляла новый объект, который
              в первый момент своего существования идентичен объекту original, но совершенно
              независим от него, в таком случае нужно воспользоваться методом clone () следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee сору = original.clone();
copy.raiseSalary(<span class="hljs-number" style="color: rgb(147, 92, 37);">10</span>); <span class="hljs-comment"
                                                                                              style="color: rgb(113, 149, 168);">// Теперь оригинал не изменился!</span></pre>

            <p>
              Но не все так просто. Метод clone () является защищенным (protected) в классе
              Object, т.е. его нельзя вызвать непосредственно. И только класс Employee может клонировать объекты своего
              класса. Для этого ограничения имеется своя веская причина.
              Проанализируем, каким образом класс Object может реализовать метод clone (). Ему
              вообще ничего не известно об объекте, поэтому он может копировать лишь поля. Если
              все поля класса являются числовыми или имеют другой основной тип, их копирование
              выполняется нормально. Но если объект содержит ссылку на подобъект, то оригинал
              и клонированные объекты будут совместно использовать одни и те же данные.
            </p>

            <p>
              Чтобы проиллюстрировать это явление, рассмотрим класс Employee, которым, начиная с главы 4, мы пользуемся
              для демонстрации различных особенностей работы с объектами. На рис. 6.2 показано, что происходит, когда
              метод clone () из класса Object
              применяется для клонирования объекта типа Employee. Как видите, операция клонирования по умолчанию
              является "неполной" — она не клонирует объекты, на которые
              имеются ссылки в других объектах.

            </p>

            <p>
              Так ли уж плохо неполное копирование? Все зависит от конкретной ситуации.
              Если подобъект, используемый совместно как оригиналом, так и неполным клоном,
              является неизменяемым, это вполне безопасно. Такое случается, если подобъект является экземпляром
              неизменяемого класса, например String. С другой стороны,
              подобъект может оставаться постоянным на протяжении всего срока действия того
              объекта, который его содержит, не подвергаясь воздействию модифицирующих методов или методов, вычисляющих
              ссылку на него.
            </p>

            <p>
              Но подобъекты зачастую подвергаются изменениям, поэтому приходится переопределять метод clone (), чтобы
              выполнить полное копирование, которое позволяет
              клонировать подобъекты наряду с содержащими их объектами. В данном примере
              поле hireDay ссылается на экземпляр изменяемого класса Date, и поэтому он должен
              быть также клонирован. (Здесь используется поле типа Date, а не типа LocalDate
              именно для того, чтобы продемонстрировать особенности процесса клонирования.
              Если бы поле hireDay ссылалось на экземпляр неизменяемого класса LocalDate, то
              никаких дополнительных действий не потребовалось бы.)

            </p>
            <p>
              Для каждого класса нужно принять следующие решения.

            </p>
            <ul>
              <li>
                <p>
                  Достаточно ли метода clone (), предоставляемого по умолчанию?
                </p>
              </li>
              <li>
                <p>
                  Можно ли доработать предоставляемый по умолчанию метод clone () таким
                  образом, чтобы вызывать его для изменяемых объектов?
                </p>
              </li>
              <li>
                <p>
                  Следует ли вообще отказаться от применения метода clone() ?
                </p>
              </li>
            </ul>
            <p>
              По умолчанию принимается последнее решение. А для принятия первого и второго решения класс должен
              удовлетворять следующим требованиям.
            </p>

            <ul>
              <li>
                <p>
                  Реализация интерфейса Cloneable.
                </p>
              </li>
              <li>
                <p>
                  Переопределение метода clone () с модификатором доступа public.

                </p>
              </li>
            </ul>

            <p>
              В данном случае интерфейс Cloneable используется не совсем обычным образом.
              В частности, метод clone () не объявляется в нем, а наследуется от класса Object.
              Интерфейс служит меткой, указывающей на то, что в данном случае разработчик
              класса понимает, как выполняется процесс клонирования. В языке Java наблюдается настолько настороженное
              отношение к клонированию объектов, что если объект
              требует выполнения данной операции, но не реализует интерфейс Cloneable, то генерируется исключение.

            </p>
            <p>
              Даже если реализация метода clone () по умолчанию (неполное копирование) вполне подходит, все равно нужно
              реализовать также интерфейс Cloneable
              переопределить метод clone () как открытый и сделать вызов super. clone (), как
              показано в следующем примере кода:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Cloneable</span> </span>{
    <span class="hljs-comment"
          style="color: rgb(113, 149, 168);">// сделать метод открытым, изменить возвращаемый тип </span>
    <span class="hljs-function"><span class="hljs-keyword"
                                      style="color: rgb(107, 107, 184);">public</span> Employee <span class="hljs-title"
                                                                                                      style="color: rgb(37, 127, 173);">clone</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                             style="color: rgb(107, 107, 184);">throws</span> CloneNotSupportedException </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> (Employee) <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.clone();
    }
}</pre>
            <p>
              Рассмотренный выше метод clone () не добавляет никаких новых функциональных возможностей к методу Object.
              clone (), реализующему неполное копирование.
              Чтобы реализовать полное копирование, придется приложить дополнительные усилия и организовать
              клонирование изменяемых полей экземпляра. Ниже приведен
              пример реализации метода clone (), выполняющего полное копирование

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Cloneable</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword"
                                      style="color: rgb(107, 107, 184);">public</span> Employee <span class="hljs-title"
                                                                                                      style="color: rgb(37, 127, 173);">clone</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                             style="color: rgb(107, 107, 184);">throws</span> CloneNotSupportedException </span>{
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// вызвать метод Object.clone()</span>
        Employee cloned = (Employee) <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.clone();
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// клонировать изменяемые поля </span>
        cloned.hireDay = (Date) hireDay.clone();
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> cloned;
    }
}</pre>
            <p>
              Метод clone () из класса Object может генерировать исключение типа
              CloneNotSupportedException. Это происходит в том случае, если метод clone () вызывается для объекта, не
              реализующего интерфейс Cloneable. Но поскольку классы
              Employee и Date реализуют этот интерфейс, то исключение не генерируется. Впрочем, компилятору об этом
              ничего неизвестно, и поэтому о возможном исключении
              приходится объявлять следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Employee <span
                class="hljs-title" style="color: rgb(37, 127, 173);">clone</span> <span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">()</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">throws</span> CloneNotSupportedException</span></pre>

            <p>
              He лучше ли было бы вместо этого предусмотреть обработку исключения, как показано ниже
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> Employee <span
                class="hljs-title" style="color: rgb(37, 127, 173);">clone</span><span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                              style="color: rgb(107, 107, 184);">super</span>.clone();
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span>(CloneNotSupportedException e){
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-keyword"
                                                                                                  style="color: rgb(107, 107, 184);">null</span>;
            }
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Этого не поизойдет, так как данный класс</span>

        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// реализует интерфейс Cloneable</span>
        }
    }</pre>
            <p>
              Такое решение вполне подходит для конечных классов, объявляемых как
              final. А в остальном уместнее прибегнуть к помощи ключевого слова throws.
              В этом случае у подкласса останется возможность сгенерировать исключение типа
              CloneNotSupportedException, если он не в состоянии поддерживать клонирование.
            </p>

            <p>
              Методы по умолчанию играют важную роль в дальнейшем развитии интерфейсов.
              Рассмотрим в качестве примера интерфейс Collection, многие годы входящий в состав стандартной библиотеки
              Java. Допустим, что некогда был предоставлен следующий класс, реализующий интерфейс Collection:
            </p>

            <p>
              Клонируя объекты подклассов, следует соблюдать особую осторожность. Так,
              если вы определите метод clone () в классе Employee, другие смогут воспользоваться
              им для клонирования объектов типа Manager. Сможет ли метод clone () из класса
              Employee справиться с подобной задачей? Это зависит от набора полей, объявленных
              в классе Manager. В данном случае никаких затруднений не возникнет, поскольку поле
              bonus относится к примитивному типу. Но ведь в класс Manager может быть введено
              поле, требующее полного копирования или вообще не допускающее клонирование.
              Нет никакой гарантии, что в подклассе реализован метод clone (), корректно решающий поставленную задачу.
              Именно поэтому метод clone () объявлен в классе Object
              как protected. Но если вы хотите, чтобы пользователи ваших классов могли вызывать метод clone О, то
              подобная "роскошь" остается для вас недоступной.

            </p>
            <p>
              Следует ли реализовывать метод clone () в своих классах? Если пользователям
              требуется полное копирование, то ответ, конечно, должен быть положительным.
              Некоторые специалисты считают, что от метода clone () нужно вообще отказаться
              и реализовать вместо него другой метод, решающий аналогичную задачу. Можно,
              конечно, согласиться с тем, что метод clone () — не совсем удачное решение, но если
              вы передадите его функции другому методу, то столкнетесь с теми же трудностями.
              Как бы то ни было, клонирование применяется нечасто. Достаточно сказать, что метод clone () реализован
              менее чем в 5 процентах классов из стандартной библиотеки.
            </p>
            <p>
              программе, исходный код которой приведен в листинге 6.4, сначала клонируются объекты класса Employee (из
              листинга 6.5), затем вызываются два модифицирующих метода. Метод raiseSalary () изменяет значение в поле
              salary, а метод
              setHireDay () — состояние в поле hireDay. Ни один из модифицирующих методов
              не воздействует на исходный объект, поскольку метод clone () переопределен и осуществляет полное
              копирование.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> clone;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates cloning.
 * <span class="hljs-doctag">@version</span> 1.10 2002-07-01
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">CloneTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
      {
         Employee original = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"John Q. Public"</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">50000</span>);
         original.setHireDay(<span class="hljs-number" style="color: rgb(147, 92, 37);">2000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>, <span class="hljs-number"
                                                                                       style="color: rgb(147, 92, 37);">1</span>);
         Employee copy = original.clone();
         copy.raiseSalary(<span class="hljs-number" style="color: rgb(147, 92, 37);">10</span>);
         copy.setHireDay(<span class="hljs-number" style="color: rgb(147, 92, 37);">2002</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number"
                                                                                        style="color: rgb(147, 92, 37);">31</span>);
         System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"original="</span> + original);
         System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">"copy="</span> + copy);
      }
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (CloneNotSupportedException e)
      {
         e.printStackTrace();
      }
   }
}</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> clone;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.Date;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.GregorianCalendar;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Employee</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                  style="color: rgb(37, 127, 173);">Cloneable</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> salary;
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Date hireDay;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">(String name, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> salary)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.name = name;
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">this</span>.salary = salary;
      hireDay = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Date();
   }

   <span class="hljs-function"><span class="hljs-keyword"
                                     style="color: rgb(107, 107, 184);">public</span> Employee <span class="hljs-title"
                                                                                                     style="color: rgb(37, 127, 173);">clone</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                            style="color: rgb(107, 107, 184);">throws</span> CloneNotSupportedException
   </span>{
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// call Object.clone()</span>
      Employee cloned = (Employee) <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.clone();

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// clone mutable fields</span>
      cloned.hireDay = (Date) hireDay.clone();

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> cloned;
   }

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * Set the hire day to a given date.
    * <span class="hljs-doctag">@param</span> year the year of the hire day
    * <span class="hljs-doctag">@param</span> month the month of the hire day
    * <span class="hljs-doctag">@param</span> day the day of the hire day
    */</span>
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">setHireDay</span><span
       class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                   style="color: rgb(107, 107, 184);">int</span> year, <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> month, <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">int</span> day)</span>
   </span>{
      Date newHireDay = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> GregorianCalendar(year, month - <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>, day).getTime();

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Example of instance field mutation</span>
      hireDay.setTime(newHireDay.getTime());
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

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
       class="hljs-title" style="color: rgb(37, 127, 173);">toString</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> <span class="hljs-string"
                                                                                        style="color: rgb(86, 140, 59);">"Employee[name="</span> + name + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span> + salary + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",hireDay="</span> + hireDay + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"]"</span>;
   }
}</pre>


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
    public static void main(String[] args) throws CloneNotSupportedException {
        Square square = new Square(4);
        Square copyedSquare = square.clone();

        if (square.getX() == copyedSquare.getX()) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }
}

interface Figure extends Cloneable {
    int getX();

    int getValue();

    default String getDescription() {
        return "Instanse of Figure interface";
    }
}

class Square implements Figure {
    private int x;

    public Square(int x) {
        this.x = x;
    }

    @Override
    public int getX() {
        return 0;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getValue() {
        return (int) Math.pow(x, 2);
    }

    @Override
    public Square clone() throws CloneNotSupportedException {
        Square copyed = (Square) super.clone();
        copyed.setX(getX());

        return copyed;
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
  name: "ClonningObjects",
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

      selected: 'CloneNotSupportedException',
      options: [
        {item: 'CloneNotSupportedException', name: 'CloneNotSupportedException'},
        {item: 'Equal', name: 'Equal'},
        {item: 'Not equal', name: 'Not equal'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 3,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[2].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 10.0
              window.frontendData.language.chapters[4].listThemes[2].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[2].task.answer

          window.frontendData.language.chapters[4].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[2].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[2].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[2].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[2].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[2].task.answer
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
    public static void main(String[] args) throws CloneNotSupportedException {
        Square square = new Square(4);
        Square copyedSquare = square.clone();

        if (square.getX() == copyedSquare.getX()) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }
}

interface Figure extends Cloneable {
    int getX();

    int getValue();

    default String getDescription() {
        return "Instanse of Figure interface";
    }
}

class Square implements Figure {
    private int x;

    public Square(int x) {
        this.x = x;
    }

    @Override
    public int getX() {
        return 0;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getValue() {
        return (int) Math.pow(x, 2);
    }

    @Override
    public Square clone() throws CloneNotSupportedException {
        Square copyed = (Square) super.clone();
        copyed.setX(getX());

        return copyed;
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

    let themeToClose = document.getElementById('java-5-chapter-1-theme-3-subtheme');

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