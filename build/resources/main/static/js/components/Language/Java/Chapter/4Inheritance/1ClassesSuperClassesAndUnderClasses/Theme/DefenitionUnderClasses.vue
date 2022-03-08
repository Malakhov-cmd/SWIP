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
          Классы, суперклассы и подклассы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Вернемся к примеру класса Employee, рассмотренному в предыдущей главе. Допустим, вы работаете в
              организации, где работа руководящего состава учитывается
              иначе, чем работа остальных работников. Разумеется, руководители во многих отношениях являются обычными
              наемными работниками. Руководящим и обычным работникам выплачивается заработная плата, но первые за свои
              достижения получают
              еще и премии. В таком случае для расчета зарплаты следует применять наследование. Почему? А потому, что
              нужно определить новый класс Manager, в который придется ввести новые функциональные возможности. Но в
              этот класс можно перенести
              кое-что из того, что уже запрограммировано в классе Employee, сохранив все поля,
              определенные в исходном классе. Говоря более абстрактно, между классами Manager
              и Employee существует вполне очевидное отношение "является": каждый руководитель является работником.
              Именно это отношение и служит явным признаком наследования.
            </p>
            <p> Определение подклассов</p>

            <p>Ниже показано, каким образом определяется класс Manager, производный
              от класса Employee. Для обозначения наследования в Java служит ключевое слово
              extends.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
    Дополнительные методы и поля
}
</pre>
            <p>Ключевое слово extends означает, что на основе существующего класса создается
              новый класс. Существующий класс называется суперклассом, базовым или родительским, а вновь создаваемый —
              подклассом, производным или порожденным. В среде программирующих на Java наиболее широко распространены
              термины суперкласс и подкласс, хотя некоторые из них предпочитают пользоваться терминами родительский
              и порожденный, более тесно связанными с понятием наследования.</p>

            <p>Класс Employee является суперклассом. Это не означает, что он имеет превосходство над своим подклассом
              или обладает более широкими функциональными возможностями. На самом деле все наоборот: функциональные
              возможности подкласса
              шире, чем у суперкласса. Как станет ясно в дальнейшем, класс Manager инкапсулирует больше данных и
              содержит больше методов, чем его суперкласс Employee

            </p>

            <p>Класс Manager содержит новое поле, в котором хранится величина премии, а также новый метод, позволяющий
              задавать эту величину, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">double</span> bonus;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">setBonus</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                    style="color: rgb(107, 107, 184);">double</span> b)</span>
    </span>{
        bonus = b;
    }
}</pre>
            <p>
              В этих методах и полях нет ничего особенного. Имея объект типа Manager, можно
              просто вызывать для него метод setBonus () следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager boss = . . .;
boss.setBonus(<span class="hljs-number" style="color: rgb(147, 92, 37);">5000</span>);</pre>

            <p>
              Разумеется, для объекта типа Employee вызвать метод setBonus () нельзя, поскольку его нет среди методов,
              определенных в классе Employee. Но в то же время методы
              getName () и getHireDay () можно вызывать для объектов типа Manager, поскольку они
              наследуются от суперкласса Employee, хотя и не определены в классе Manager. Поля
              name, salary и hireDay также наследуются от суперкласса. Таким образом, у каждого
              объекта типа Manager имеются четыре поля: name, salary, hireDay и bonus.
            </p>

            <p>
              Определяя подкласс посредством расширения суперкласса, достаточно указать
              лишь отличия между подклассом и суперклассом. Разрабатывая классы, следует размещать общие методы в
              суперклассе, а специальные — в подклассе. Такое выделение
              общих функциональных возможностей в отдельном суперклассе широко распространено в ООП.
            </p>

            <p>
              Переопределение методов
            </p>
            <p>
              Некоторые методы суперкласса не подходят для подкласса Manager. В частности,
              метод getSalary () должен возвращать сумму основной зарплаты и премии. Следовательно, нужно
              переопределишь метод, т.е. реализовать новый метол замещающий
              соответствующий метод из суперкласса, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">getSalary</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>{

    }
}</pre>
            <p>
              Как же реализовать такой метод? На первый взгляд, сделать это очень просто —
              нужно лишь вернуть сумму полей salary и bonus следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                            style="color: rgb(37, 127, 173);">getSalary</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> salary + bonus; <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// не сработает!</span>
    }</pre>
            <p>
              Но оказывается, что такой способ не годится. Метод getSalaryO из класса
              Manager не имеет доступа к закрытым полям суперкласса. Иными словами, метод getSalaryO из класса Manager
              не может непосредственно обратиться к полю
              salary, несмотря на то, что у каждого объекта типа Manager имеется поле с таким же
              именем. Только методы из класса Employee имеют доступ к закрытым полям суперкласса. Если же методам из
              класса Manager требуется доступ к закрытым полям, они
              должны сделать то же, что и любой другой метод: использовать открытый интерфейс
              (в данном случае метод getSalary () из класса Employee).

            </p>
            <p>
              Итак, сделаем еще одну попытку. Вместо непосредственного обращения к полю
              salary попробуем вызвать метод getSalary (), как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> <span class="hljs-title"
                                                                                            style="color: rgb(37, 127, 173);">getSalary</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> baseSalary = getSalaryO; <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// по-прежнему не сработает! </span>
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> baseSalary + bonus;
    }</pre>
            <p>
              Дело в том, что метод getSalary () вызывает сам себя, поскольку в классе Manager
              имеется одноименный метод (именно его мы и пытаемся реализовать). В итоге возникает бесконечная цепочка
              вызовов одного и того же метода, что приводит к аварийному завершению программы.

            </p>
            <p>
              Нужно найти какой-то способ явно указать, что требуется вызвать метод
              getSalaryO из суперкласса Employee, а не из текущего класса. Для этой цели служит специальное ключевое
              слово super. В приведенной ниже строке кода вызывается
              метод getSalary () именно из класса Employee.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.getSalary()
</pre>
            <p>
              Вот как выглядит правильный вариант метода getSalary () для класса Manager:
              public double getSalary()
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> baseSalary = <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>.getSalary();
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> baseSalary + bonus;
}</pre>
            <p>
              Конструкторы подклассов
            </p>
            <p>
              И в завершение рассматриваемого здесь примера снабдим класс Manager конструктором, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Manager</span><span class="hljs-params"
                                                                                         style="color: rgb(147, 92, 37);">(String n, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> s, <span class="hljs-keyword"
                                                                                               style="color: rgb(107, 107, 184);">int</span> year, <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> month, <span class="hljs-keyword"
                                                                                                style="color: rgb(107, 107, 184);">int</span> day)</span>
    </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>(n, s, year, month, day);
        bonus = <span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>;
    }</pre>
            <p>
              Здесь ключевое слово super имеет уже другой смысл. Приведенное ниже выражение означает вызов конструктора
              суперкласса Employee с параметрами n, s, year,
              month и day
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">super</span>(n, s, year, month, day);</pre>
            <p>
              Конструктор класса Manager не имеет доступа к закрытым полям класса Employee,
              поэтому он должен инициализировать их, вызывая другой конструктор с помощью
              ключевого слова super. Вызов, содержащий обращение super, должен быть первым
              оператором в конструкторе подкласса
            </p>
            <p>
              Если конструктор подкласса не вызывает явно ни одного из конструкторов суперкласса, то из этого
              суперкласса автоматически вызывается конструктор без аргументов. Если же в суперклассе отсугствует
              конструктор без ар1ументов, а конструктор
              подкласса не вызывает явно другой конструктор из суперкласса, то компилятор Java
              выдаст сообщение об ошибке
            </p>
            <p>
              После переопределения метода getSalaryO для объектов типа Manager всем
              руководящим работникам дополнительно к зарплате будет начислена премия. Обратимся к конкретному примеру,
              создав объект типа Manager и установив величину
              премии, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager boss = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Manager(<span class="hljs-string"
                                                                                                 style="color: rgb(86, 140, 59);">"Carl Cracker"</span>, <span
                class="hljs-number" style="color: rgb(147, 92, 37);">80000</span>, <span class="hljs-number"
                                                                                         style="color: rgb(147, 92, 37);">1987</span>, <span
                class="hljs-number" style="color: rgb(147, 92, 37);">12</span>, <span class="hljs-number"
                                                                                      style="color: rgb(147, 92, 37);">15</span>);
boss.setBonus(<span class="hljs-number" style="color: rgb(147, 92, 37);">5000</span>);
</pre>

            <p>
              Затем образуем массив, в котором должны храниться три объекта типа Employee:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Employee[] staff = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee[<span class="hljs-number"
                                                                                                  style="color: rgb(147, 92, 37);">3</span>];</pre>
            <p>
              Заполним его объектами типа Manager и Employee:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">staff[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = boss;
staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>] = <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry Hacker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">50000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1989</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">10</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>);
staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>] = <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Tony Tester"</span>, <span class="hljs-number"
                                                                                                   style="color: rgb(147, 92, 37);">40000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1990</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">3</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">15</span>);
</pre>
            <p>
              И наконец, выведем зарплату каждого работника:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Employee е : staff)
     System.out.println(e.getName() + <span class="hljs-string" style="color: rgb(86, 140, 59);">" "</span> + e .getSalary());
</pre>
            <p>
              В результате выполнения приведенного выше цикла выводятся следующие строки:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Carl Cracker <span
                class="hljs-number" style="color: rgb(147, 92, 37);">85000.0</span>
Harry Hacker <span class="hljs-number" style="color: rgb(147, 92, 37);">50000.0</span>
Tommy Tester <span class="hljs-number" style="color: rgb(147, 92, 37);">40000.0</span>
</pre>
            <p>
              Из элементов массива staff [1] и staff [2] выводятся основные зарплаты обычных работников, поскольку они
              представлены объектами типа Employee. Но объект из элемента массива staff [0] относится к классу Manager,
              и поэтому в методе
              getSalary () из этого класса к основной зарплате прибавляется премия. Обратите
              особое внимание на следующий вызов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">е.getSalary()
</pre>
            <p>
              Здесь вызывается именно тот метод getSalary (), который необходим в данном
              случае. Обратите также внимание на то, что объявленным типом переменной е является Employee, но
              фактическим типом объекта, на который может ссылаться переменная е, может быть как Employee, так и
              Manager.

            </p>
            <p>
              Когда переменная е ссылается на объект типа Employee, при обращении
              е. getSalary () вызывается метод getSalary () из класса Employee. Но если переменная е ссылается на
              объект типа Manager, то вызывается метод getSalary () из класса
              Manager. Виртуальной машине известен фактический тип объекта, на который ссылается переменная е, поэтому
              с вызовом метода никаких затруднений не возникает.
            </p>
            <p>
              Способность переменной (например, е) ссылаться на объекты, имеющие разные
              фактические типы, называется полиморфизмом. Автоматический выбор нужного метода во время выполнения
              программы называется динамическим связыванием. Оба эти
              понятия будут подробнее обсуждаться далее в главе.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> inheritance;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates inheritance.
 * <span class="hljs-doctag">@version</span> 1.21 2004-02-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">ManagerTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// construct a Manager object</span>
      Manager boss = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Manager(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Carl Cracker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">80000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1987</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">12</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">15</span>);
      boss.setBonus(<span class="hljs-number" style="color: rgb(147, 92, 37);">5000</span>);

      Employee[] staff = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Employee[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3</span>];

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// fill the staff array with Manager and Employee objects</span>

      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = boss;
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Harry Hacker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">50000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1989</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">10</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>);
      staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>] = <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"Tommy Tester"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">40000</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1990</span>, <span class="hljs-number"
                                                                                          style="color: rgb(147, 92, 37);">3</span>, <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">15</span>);

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// print out information about all Employee objects</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (Employee e : staff)
         System.out.println(<span class="hljs-string"
                                  style="color: rgb(86, 140, 59);">"name="</span> + e.getName() + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">",salary="</span> + e.getSalary());
   }
}</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> inheritance;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.time.*;

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
}
</pre>

            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> inheritance;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">Manager</span> <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">extends</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">double</span> bonus;

   <span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
    * <span class="hljs-doctag">@param</span> name the employee's name
    * <span class="hljs-doctag">@param</span> salary the salary
    * <span class="hljs-doctag">@param</span> year the hire year
    * <span class="hljs-doctag">@param</span> month the hire month
    * <span class="hljs-doctag">@param</span> day the hire day
    */</span>
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
                                                                   style="color: rgb(107, 107, 184);">double</span> b)</span>
   </span>{
      bonus = b;
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
    public static void main(String[] args) {
        Square square = new Square(4);
        System.out.println(square.getSquareValue());
    }
}

abstract class Figura{
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
  name: "DefenitionUnderClasses",
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
        {item: 'null', name: 'null'},
        {item: '4', name: '4'},
        {item: '16', name: '16'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/fourthchapter/', {
        params: {
          numberTheme: 1,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[0].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[0].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[0].task.answer

          window.frontendData.language.chapters[3].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[0].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[0].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[0].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[0].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[0].task.answer
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
        Square square = new Square(4);
        System.out.println(square.getSquareValue());
    }
}

abstract class Figura{
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
}

class Square extends Figura {
    public Square(int x) {
        super(x);
    }

    @Override
    public double getSquareValue() {
        return getX()*getX();
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

    let themeToClose = document.getElementById('java-4-chapter-1-theme-1-subtheme');

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