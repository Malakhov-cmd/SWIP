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
          Особенности интерфейсов
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
              Если вы помните содержание раздела главы 5, посвященного абстрактным классам, то у вас могут возникнуть
              следующие резонные вопросы: зачем разработчики языка Java создали механизм интерфейсов и почему бы не
              сделать интерфейс
              Comparable абстрактным классом, например, так, как показано ниже?
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">abstract</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Comparable</span> // Почему бы и нет?
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">abstract</span> <span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">compareTo</span><span class="hljs-params"
                                                                                   style="color: rgb(147, 92, 37);">(Object other)</span></span>;
}
</pre>
            <p>
              В этом случае рассматриваемый здесь класс Employee мог бы просто расширять
              абстрактный класс и реализовывать метод compareTo () следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Comparable</span> // Почему бы и нет?
</span>{
     <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
         class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">compareTo</span><span
         class="hljs-params" style="color: rgb(147, 92, 37);">(Object other)</span> </span>{ ... }
}
</pre>
            <p>
              К сожалению, это породило бы массу проблем, связанных с использованием абстрактного базового класса для
              выражения обобщенного свойства. Ведь каждый класс
              может расширять только один класс. Допустим, класс Employee уже является подклассом какого-нибудь другого
              класса, скажем, Person. Это означает, что он уже не
              может расширять еще один класс следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Person</span>, <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">Comparable</span> // ОШИБКА</span></pre>

            <p>
              Но в то же время каждый класс может реализовывать сколько угодно интерфейсов, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Employee</span> <span class="hljs-keyword"
                                                                                           style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Person</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Conparable</span> // Верно!</span></pre>

            <p>
              В других языках программирования и, в частности, в C++ у классов может быть
              несколько суперклассов. Это языковое средство называется множественным наследованием. Создатели Java
              решили не поддерживать множественное наследование, поскольку оно делает язык слишком сложным (как C++)
              или менее эффективным (как
              Eiffel). В то же время интерфейсы обеспечивают большинство преимуществ множественного наследования, не
              усложняя язык и не снижая его эффективность.

            </p>

            <p>
              Статические методы
            </p>

            <p>
              Начиная с версии Java SE 8, в интерфейсы разрешается вводить статические методы. Формальных причин, по
              которым в интерфейсе не могли бы присутствовать
              статические методы, никогда не существовало. Но такие методы не согласовывались
              с представлением об интерфейсах как об абстрактных спецификациях.
            </p>
            <p>
              В прошлом статические методы зачастую определялись в дополнительном классе, сопутствующем интерфейсу. В
              стандартной библиотеке Java можно обнаружить
              пары интерфейсов и служебных классов, например Collection/Collections или
              Path/Paths. Такое разделение больше не требуется.
            </p>
            <p>
              Рассмотрим в качестве примера класс Paths. У него имеется пара фабричных методов для составления пути к
              файлу или каталогу из последовательности символьных
              строк, например, таким образом: Paths.get ("jdkl. 8.0", "jre", "bin"). Начиная
              с версии Java SE 8, такой метод можно было бы ввести интерфейс Path следующим
              образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Path</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Path <span class="hljs-title"
                                                                                         style="color: rgb(37, 127, 173);">get</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(String first, String... more)</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> FileSystems.getDefault().getPath(first, more);
  }
}
</pre>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Path</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> Path <span class="hljs-title"
                                                                                         style="color: rgb(37, 127, 173);">get</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(String first, String... more)</span> </span>{
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> FileSystems.getDefault().getPath(first, more);
  }
}
</pre>
            <p>
              В таком случае потребность в классе Paths просто отпадает. И, вероятнее всего,
              исходный код библиотеки Java будет реорганизован именно таким способом. Но при
              реализации собственных интерфейсов нет никаких причин предоставлять отдельный
              сопутствующий класс для служебных методов

            </p>
            <p>
              Методы по умолчанию
            </p>
            <p>
              Для любого интерфейсного метода можно предоставить реализацию по умолчанию.
              Такой метод следует пометить модификатором доступа default, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Comparable</span>&lt;<span
                class="hljs-title" style="color: rgb(37, 127, 173);">T</span>&gt;
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span class="hljs-title"
                                                                                 style="color: rgb(37, 127, 173);">compareTo</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(T other)</span> </span>{ <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">return</span> <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; }
    <span class="hljs-comment" style="color: rgb(113, 149, 168);">//по умолчанию все элементы одинаковы</span>
}</pre>
            <p>
              Безусловно, пользы от такого метода не очень много, поскольку в каждой настоящей реализации интерфейса
              Comparable этот метод будет переопределен. Но иногда
              методы по умолчанию оказываются все же полезными. Так, если требуется получить
              уведомление о событии от щелчка кнопкой мыши (подробнее об этом — в главе 11),
              то для этой цели, скорее всего, придется реализовать интерфейс с пятью методами,
              как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">MouseListener</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">mouseClicked</span><span class="hljs-params"
                                                                                      style="color: rgb(147, 92, 37);">(MouseEvent event)</span></span>;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">mousePressed</span><span class="hljs-params"
                                                                                      style="color: rgb(147, 92, 37);">(MouseEvent event)</span></span>;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">mouseReleased</span><span class="hljs-params"
                                                                                       style="color: rgb(147, 92, 37);">(MouseEvent event)</span></span>;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">mouseEntered</span><span class="hljs-params"
                                                                                      style="color: rgb(147, 92, 37);">(MouseEvent event)</span></span>;
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">mouseExited</span><span class="hljs-params"
                                                                                     style="color: rgb(147, 92, 37);">(MouseEvent event)</span></span>;
}</pre>
            <p>
              Чаще всего обрабатывать придется одно или два события от мыши. И начиная
              с версии Java SE 8, все эти методы можно объявить как ничего не делающие по умолчанию:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">MouseListener</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">mouseClicked</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(MouseEvent event)</span> </span>{}
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">mousePressed</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(MouseEvent event)</span> </span>{}
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">mouseReleased</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(MouseEvent event)</span> </span>{}
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">mouseEntered</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(MouseEvent event)</span> </span>{}
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> <span
        class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                  style="color: rgb(37, 127, 173);">mouseExited</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">(MouseEvent event)</span> </span>{}
}</pre>
            <p>
              рограммисту, реализующему такой интерфейс, нужно будет лишь переопределить приемники тех событий, которые
              они должны обрабатывать. Из методов
              по умолчанию можно вызывать другие методы. Например, в интерфейсе Collection
              можно определить служебный метод isEmptyO, как показано ниже. И тогда программисту, реализующему
              интерфейс Collection, не придется беспокоиться о реализации этого метода.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span class="hljs-title"
                                                                                               style="color: rgb(37, 127, 173);">Collection</span>
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">size</span> <span class="hljs-params"
                                                                               style="color: rgb(147, 92, 37);">()</span></span>; <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// абстрактный метод </span>
    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">default</span> <span class="hljs-keyword"
                                                                                       style="color: rgb(107, 107, 184);">boolean</span> isEmptyO
    {
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> size() == <span class="hljs-number"
                                                                                                    style="color: rgb(147, 92, 37);">0</span>;
    }
}</pre>
            <p>
              Методы по умолчанию играют важную роль в дальнейшем развитии интерфейсов.
              Рассмотрим в качестве примера интерфейс Collection, многие годы входящий в состав стандартной библиотеки
              Java. Допустим, что некогда был предоставлен следующий класс, реализующий интерфейс Collection:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                           style="color: rgb(37, 127, 173);">Bag</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">implements</span> <span class="hljs-title"
                                                                                                style="color: rgb(37, 127, 173);">Collection</span></span></pre>
            <p>
              а впоследствии, начиная с версии Java 8, в этот интерфейс был внедрен метод
              stream().
            </p>
            <p>

              Допустим также, что метод stream () не является методом по умолчанию. В таком случае класс Bag больше не
              компилируется, поскольку он не реализует новый
              метод из интерфейса Collection. Таким образом, внедрение в интерфейс метода не
              по умолчанию нарушает совместимость на уровне исходного кода.
            </p>
            <p>
              Но допустим, что этот класс не перекомпилируется и просто используется содержащий его старый архивный
              JAR-файл. Этот класс по-прежнему загружается, несмотря
              на отсутствующий в нем метод. В программах могут по-прежнему строиться экземпляры класса Bag, и ничего
              плохого не произойдет. (Внедрение метода в интерфейс совместимо на уровне двоичного кода.) Но если в
              программе делается вызов метода stream ()
              для экземпляра класса Bag, то возникает ошибка типа AbstractMethodError.
            </p>
            <p>
              Подобные затруднения можно устранить, если объявить метод stream () как
              default. И тогда класс Bag будет компилироваться снова. А если этот класс загружается без перекомпиляции
              и метод stream () вызывается для экземпляра класса Bag,
              то такой вызов происходит по ссылке Collection, stream.
            </p>
            <p>
              Разрешение конфликтов с методами по умолчанию
            </p>
            <p>
              Что, если один и тот же метод сначала определен по умолчанию в одном интерфейсе, а затем таким же образом
              в другом интерфейсе или как метод в суперклассе?
              В таких языках, как Scala и C++, действуют сложные правила разрешения подобных
              неоднозначностей. А в Java подобные правила оказываются намного более простыми
              и заключаются в следующем.
            </p>
            <ul>
              <li>
                <p>
                  В конфликте верх одерживает суперкласс. Если суперкласс предоставляет конкретный метод, то методы по
                  умолчанию с одинаковыми именами и типами
                  параметров просто игнорируются.
                </p>
              </li>
              <li>
                <p>
                  Интерфейсы вступают в конфликт. Если суперинтерфейс предоставляет метод,
                  а другой интерфейс — метод (по умолчанию или иначе) с таким же самым
                  именем и типами параметров, то для разрешения конфликта необходимо переопределить этот метод.
                </p>
              </li>
            </ul>
            <p>
              Рассмотрим второе правило. Допустим, в другом интерфейсе определен метод
              getName() следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Named</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword"
                                      style="color: rgb(107, 107, 184);">default</span> String <span class="hljs-title"
                                                                                                     style="color: rgb(37, 127, 173);">getName</span><span
        class="hljs-params" style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> getClass().getName() + +hashCodeO;
    }
}</pre>
            <p>
              Что произойдет, если сформировать приведенный ниже класс, реализующий оба
              интерфейса?
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Student</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Person</span>, <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">Named</span> </span>{
}</pre>
            <p>
              Этот класс наследует оба конфликтующих метода getName (), предоставляемых
              интерфейсами Person и Named. Вместо того чтобы выбрать один из этих методов,
              компилятор Java выдаст сообщение об ошибке, предоставив программисту самому
              разрешать возникшую неоднозначность. Для этого достаточно предоставить метод
              getName () в классе Student и выбрать в нем один из конфликтующих методов следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Student</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Person</span>, <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">Named</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> String <span
        class="hljs-title" style="color: rgb(37, 127, 173);">getName</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span> </span>{
        <span class="hljs-keyword" style="color: rgb(107, 107, 184);">return</span> Person.<span class="hljs-keyword"
                                                                                                 style="color: rgb(107, 107, 184);">super</span>.getName();
    }
}</pre>
            <p>
              А теперь допустим, что в интерфейсе Named не предоставляется реализация метода getName () по умолчанию,
              как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Named</span>
</span>{
     <span class="hljs-function">String <span class="hljs-title" style="color: rgb(37, 127, 173);">getName</span><span
         class="hljs-params" style="color: rgb(147, 92, 37);">()</span></span>;
}</pre>
            <p>
              Может ли класс Student унаследовать метод по умолчанию из интерфейса
              Person? На первый взгляд это может показаться вполне обоснованным, но разработчики Java решили сделать
              выбор в пользу единообразия. Независимо от характера
              конфликта между двумя интерфейсами, хотя бы в одном из них предоставляется реализация искомого метода, а
              компилятор выдаст сообщение об ошибке, предоставив
              программисту возможность самому разрешать возникшую неоднозначность.
            </p>
            <p>
              Итак, мы рассмотрели конфликты между интерфейсами. А теперь рассмотрим
              класс, расширяющий суперкласс и реализующий интерфейс, наследуя от обоих один
              и тот же метод. Допустим, класс Student, наследующий от класса Person и реализующий интерфейс Named,
              определяется следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Student</span> <span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Person</span> <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">implements</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Named</span> </span>{ . . . }
</pre>
            <p>
              В таком случае значение имеет только метод из суперкласса, а любой метод
              по умолчанию из интерфейса просто игнорируется. В данном примере класс Student
              наследует метод getName () из класса Person, и для него совершенно не важно, предоставляет ли интерфейс
              Named такой же самый метод по умолчанию. Ведь в этом
              случае соблюдается первое упомянутое выше правило, согласно которому в конфликте верх одерживает
              суперкласс.
            </p>
            <p>
              Это правило гарантирует совместимость с версией Java SE 7. Если ввести методы
              по умолчанию в интерфейс, это никак не скажется на работоспособности прикладного кода, написанного до
              появления методов по умолчанию в интерфейсах.
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
          Что выведет программа?
        </label>

        <textarea id="codeContentId" readonly>
public class Test {
    public static void main(String[] args) {
        Figure square = new Square(4);
        int value = square.getValue();

        System.out.println("value " + value + " " + square.getDescription());
    }
}

interface Figure {
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

    @Override
    public int getValue() {
        return (int) Math.pow(x, 2);
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
  name: "InterfacesAndAbstarctClasses",
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

      selected: 'Instanse of Figure interface',
      options: [
        {item: 'Instanse of Figure interface', name: 'Instanse of Figure interface'},
        {item: 'Instanse of Figure interface value 16', name: 'Instanse of Figure interface value 16'},
        {item: '16 Instanse of Figure interface', name: '16 Instanse of Figure interface'},
        {item: 'value 16 Instanse of Figure interface', name: 'value 16 Instanse of Figure interface'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fifthchapter/', {
        params: {
          numberTheme: 2,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[4].listThemes[1].task.answer = response.data
              window.frontendData.language.chapters[4].chapterProgress += 6.6
              window.frontendData.language.chapters[4].listThemes[1].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[4].listThemes[1].task.answer

          window.frontendData.language.chapters[4].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[4].listThemes[1].task.tryCount++
          window.frontendData.language.chapters[4].listThemes[1].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[1].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[4].listThemes[1].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[4].listThemes[1].task.answer
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
        Figure square = new Square(4);
        int value = square.getValue();

        System.out.println("value " + value + " " + square.getDescription());
    }
}

interface Figure {
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

    @Override
    public int getValue() {
        return (int) Math.pow(x, 2);
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

    let themeToClose = document.getElementById('java-5-chapter-1-theme-2-subtheme');

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