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
          Ограничения и пределы обобщений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Параметрам типа нельзя приписывать простые типы
            </p>

            <p>
              Примитивный тип нельзя подставить вместо типа параметра. Это означает, что
              не бывает объекта типа Pair< double >, а только объект типа Pair< Double >. Причину,
              конечно, следует искать в стирании типов. После такого стирания в классе Pair отсутствуют поля типа
              Object, и поэтому их нельзя использовать для хранения значений
              типа double.

            </p>
            <p>
              И хотя такое ограничение досадно, тем не менее, он согласуется с особым положением примитивных типов в
              Java. Этот недостаток не носит фатального характера. Ведь
              существует всего восемь простых типов данных, а обработать их всегда можно с помощью отдельных классов и
              методов, когда нельзя подставить вместо них типы-оболочки
            </p>


            <p>
              Во время выполнения можно запрашивать только базовые типы
            </p>

            <p>
              В виртуальной машине объекты всегда имеют определенный необобщенный тип.
              Поэтому все запросы типов во время выполнения дают только базовый тип. Например, следующий оператор на
              самом деле только проверяет, является ли а экземпляром Pair любого типа:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (a <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">instanceof</span> Pair&lt;String&gt;) <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span></pre>
            <p>
              Это же справедливо и в отношении следующего оператора:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (a <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">instanceof</span> Pair&lt;T&gt;) <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span></pre>
            <p>
              или такого оператора приведения типов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;String&gt; р = (Pair&lt;String&gt;) а; <span
                class="hljs-comment" style="color: rgb(113, 149, 168);">// ПРЕДУПРЕЖДЕНИЕ!</span>
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// Проверить можно только принадлежность переменной а к типу Pair</span></pre>
            <p>
              Чтобы напомнить о возможной опасности, компилятор выдает ошибку (при операции instanceof) или
              предупреждение (при приведении типов) всякий раз, когда
              делается запрос, принадлежит ли объект к обобщенному типу. Аналогично метод
              getClass () всегда возвращает базовый тип, как показано в приведенном ниже примере кода. Результатом
              сравнения оказывается логическое значение true, потому что
              при обоих вызовах метода getClass () возвращается объект типа Pair. class.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;String&gt; stnngPair = . . . ;
Pair&lt;Employee&gt; employeePair = . . .;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (stringPair.getClass() == employeePair.getClass()) <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// равны!</span></pre>
            <p>
              Массивы параметризованных типов недопустимы
            </p>

            <p>
              Нельзя объявить массив параметризованных типов вроде следующего:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;String&gt;[] table = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Pair&lt;String&gt;[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">10</span>]; <span class="hljs-comment"
                                                                                       style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
</pre>
            <p>
              Что же здесь не так? После стирания типом таблицы становится Pair [ ]. Но его
              можно преобразовать в тип Object [ ] следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Object[] objarray = table;
</pre>
            <p>
              В массиве запоминается тип его элементов и генерируется исключение типа
              ArrayStoreException, если попытаться сохранить в нем элемент неверного типа, как
              показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">objarray[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = <span class="hljs-string"
                                                                                       style="color: rgb(86, 140, 59);">"Hello”; // ОШИБКА! Типом компонента является Pair</span></pre>
            <p>
              Но стирание делает этот механизм неэффективным для обобщенных типов. Приведенное ниже присваивание
              пройдет проверку на сохранение в массиве, но выдаст
              ошибку соблюдения типов. Именно поэтому массивы параметризованных типов не
              допускаются.


            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">objarray[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>] = <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">new</span> Pair&lt;Employee&gt;();
</pre>
            <p>
              Следует, однако, иметь в виду, что не допускается только создание подобных массивов. И хотя разрешается,
              например, объявить переменную типа Pair
              < String > [],
              тем не менее ее нельзя инициализировать с помощью оператора Pair< String > [10].

            </p>
            <p>
              Предупреждения о переменном числе аргументов
            </p>
            <p>
              Как было показано в предыдущем разделе, в Java не поддерживаются массивы
              обобщенных типов. А в этом разделе будет рассмотрен следующий связанный с этим
              вопрос: передача экземпляров обобщенных типов методу с переменным числом аргументов.

            </p>
            <p>
              Рассмотрим в качестве примера следующий простой метод с переменным числом
              аргументов:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> &lt;Т&gt; <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">addAll</span><span class="hljs-params"
                                                                                        style="color: rgb(147, 92, 37);">(Collection&lt;T&gt; coll, T... ts)</span>
</span>{
     <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (T t : ts) coll.add(t);
}</pre>
            <p>
              Напомним, что параметр ts на самом деле является массивом, содержащим все
              предоставляемые аргументы. А теперь рассмотрим вызов этого метода в приведенном ниже фрагменте кода.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Collection&lt;Pair&lt;String&gt;&gt; table = ...;
Pair&lt;String&gt; pairl = ...;
Pair&lt;String&gt; pair2 = ...;
addAll(table, pairl, pair2);
</pre>
            <p>
              Для вызова этого метода в виртуальной машине Java придется сформировать массив объектов типа Pair
              < String >, что не по правилам. Но эти правила были ослаблены, чтобы уведомлять в подобных случаях только
              о
              предупреждении.
            </p>
            <p>
              Подавить выдачу такого предупреждения можно двумя способами. Во-первых,
              ввести аннотацию @SuppressWarnings ("unchecked") в тело метода, содержащего
              вызов метода addAll (). И, во-вторых, начиная с версии Java SE 7, ввести аннотацию @
              SafeVarargs в тело самого метода addAll (), как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-meta" style="color: rgb(147, 92, 37);">@SafeVarargs</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(107, 107, 184);">static</span> &lt;Т&gt; <span
                  class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">addAll</span><span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">(Collection&lt;T&gt; coll, T... ts)</span>
</span></pre>
            <p>
              Теперь этот метод можно вызывать с аргументами обобщенных типов. Приведенную выше аннотацию можно ввести
              в любые методы, выбирающие элементы из
              массива параметров — наиболее характерного примера употребления переменного
              числа аргументов.
            </p>
            <p>
              Нельзя создавать экземпляры переменных типа

            </p>
            <p>
              Переменные типа нельзя использовать в выражениях вроде new Т (...), new
              Т [... ] или Т.class. Например, следующий конструктор Pair< T > недопустим:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Pair</span><span class="hljs-params"
                                                                                      style="color: rgb(147, 92, 37);">()</span> </span>{ first = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Т(); second = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> T(); } <span class="hljs-comment"
                                                                                                style="color: rgb(113, 149, 168);">// ОШИБКА!</span></pre>
            <p>
              Стирание типов может изменить обобщенный тип Т на Object, а вызывать конструктор new Object (), конечно,
              не стоит. Начиная с версии Java SE 8, можно прибегнуть к наилучшему обходному приему, предоставив в
              вызывающем коде ссылку
              на конструктор, как показано в следующем примере:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Pair&lt;String&gt; р = Pair.makePair(String: :<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span>) ;
</pre>
            <p>
              Нельзя строить обобщенные массивы
            </p>
            <p>
              Как нельзя получить единственный обобщенный экземпляр, так нельзя построить обобщенный массив. Но причина
              здесь другая: массив заполняется пустыми
              значениями null, что может показаться вполне безопасным для его построения. Но
              ведь массив относится к определенному типу, который служит в виртуальной машине для контроля значений,
              сохраняемых в массиве. А этот тип стирается. Рассмотрим
              в качестве примера следую щ ую строку кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> &lt;Т extends Comparable&gt; Т[] minmax(T[] а) { Т[] nun =
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Т [<span class="hljs-number"
                                                                                  style="color: rgb(147, 92, 37);">2</span>] ; . . . } <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
</pre>
            <p>
              Если массив используется только как закрытое поле экземпляра класса, его можно
              объявить как Object [] и прибегнуть к приведению типов при извлечении из него
              элементов. Например, класс ArrayList может быть реализован следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">ArrayList</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">E</span>&gt;
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> Object[] elements;
    <span class="hljs-meta" style="color: rgb(147, 92, 37);">@SuppressWarnings</span>(<span class="hljs-string"
                                                                                            style="color: rgb(86, 140, 59);">"unchecked"</span>) <span
                  class="hljs-function"><span class="hljs-keyword"
                                              style="color: rgb(107, 107, 184);">public</span> E <span
                  class="hljs-title" style="color: rgb(37, 127, 173);">get</span><span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">(<span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> n)</span>
    </span>{ <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> (E) elements[n]; }
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">set</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(<span class="hljs-keyword"
                                                                    style="color: rgb(107, 107, 184);">int</span> n, E e)</span> </span>{ elements[n] = e; }
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// приведение типов не требуется!</span>
}</pre>
            <p>
              Но конкретная его реализация не настолько ясна. Так, в следующем фрагменте кода
              приведение к типу Е [ ] совершенно ложно, но стирание типов делает это незаметным.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">ArrayList</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">E</span>&gt;
</span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">private</span> E[] elements;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">ArrayList</span><span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">()</span> </span>{ elements = (E [<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">3</span>) <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">new</span> Object[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">10</span>]; }
}</pre>
            <p>
              Такой прием не подходит для метода minmax (), поскольку он возвращает массив
              обобщенного типа Т [ ]. И если сделать ложное заключение о типе, то во время выполнения кода возникнет
              ошибка. Допустим, что обобщенный метод minmax () реализуется следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> &lt;Т extends Comparable&gt; Т[] minmax(T... а)
    {
        Object[] mm = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> Object[<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">2</span>];
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> (T[]) mm; <span class="hljs-comment"
                                                                                                    style="color: rgb(113, 149, 168);">// компилируется без предупреждения</span>
    }</pre>
            <p>
              Тогда приведенный ниже вызов данного метода компилируется без всяких предупреждений.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">String[] ss = minmax(<span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Tom"</span>, <span class="hljs-string"
                                                                                         style="color: rgb(86, 140, 59);">"Dick"</span>, <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Harry"</span>);
</pre>
            <p>
              Исключение типа ClassCastException возникает, когда ссылка на объект типа
              Object [ ] приводится к типу Comparable [ ] при возврате из метода. В таком случае
              лучше всего предложить пользователю предоставить ссылку на конструктор массива
              следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">String[] ss = Arr ayAlg. minmax (String[]: :<span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span>, <span class="hljs-string"
                                                                                          style="color: rgb(86, 140, 59);">"Tom"</span>, <span
                class="hljs-string" style="color: rgb(86, 140, 59);">"Dick"</span>, <span class="hljs-string"
                                                                                          style="color: rgb(86, 140, 59);">"Harry"</span>);
</pre>
            <p>
              Ссылка на конструктор String: :new обозначает функцию для построения массива типа String заданной длины.
              Она служит в качестве параметра метода для получения массива нужного типа, как показано ниже,
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">    <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> &lt;Т extends Comparable&gt; Т[] minmax(
            IntFunction&lt;T[]&gt; constr, T... a)
    {
        Т [] mm = constr.apply(<span class="hljs-number" style="color: rgb(147, 92, 37);">2</span>);
    }</pre>
            <p>
              Более традиционный способ состоит в том, чтобы воспользоваться рефлексией
              и сделать вызов A r r a y . n e w l n s t a n c e () следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-keyword"
                                                                                            style="color: rgb(107, 107, 184);">static</span> &lt;Т extends Comparable&gt; Т[] minmax(T... а)
{
     Т [] mm = (Т []) Array.newlnstance(a.getClass().getComponentType(), <span class="hljs-number"
                                                                               style="color: rgb(147, 92, 37);">2</span>);
}</pre>
            <p>
              Методу t o A r r a y () из класса A r r a y L i s t повезло в меньшей степени. Ему нужно
              построить массив типа Т [ ], но у него нет типа элементов. Поэтому возможны два
              варианта:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Object[] toArray()
Т [] toArray(Т[] result)
</pre>
            <p>
              Второй метод принимает параметр в виде массива. Если этот массив достаточно
              велик, то он используется. В противном случае создается новый массив подходящего
              размера с элементами типа result.
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
          Что разрешено делать?
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
          Что разрешено делать?
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
  name: "RestrictionAndLimitGeneric",
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

      selected: 'Создавать экземпляры переменных типа',
      options: [
        {
          item: 'Создавать экземпляры переменных типа',
          name: 'Создавать экземпляры переменных типа'
        },
        {
          item: 'Инициализовать массивы параметрезированного типа',
          name: 'Инициализовать массивы параметрезированного типа'
        },
        {
          item: 'Создавать ограничение по типу \"снизу\"',
          name: 'Создавать ограничение по типу \"снизу\"'
        }
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/seventhchapter/', {
        params: {
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[6].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[6].chapterProgress += 11.1
              window.frontendData.language.chapters[6].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[6].listThemes[7].task.answer

          window.frontendData.language.chapters[6].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[6].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[6].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[6].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[6].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[6].listThemes[7].task.answer
    }

    this.timeStarted = Date.now()
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-7-chapter-6-theme');

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