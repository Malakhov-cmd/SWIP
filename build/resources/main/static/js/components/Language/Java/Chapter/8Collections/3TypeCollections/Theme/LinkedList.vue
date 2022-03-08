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
          Связные списки
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Во многих примерах программ, приведенных ранее в этой книге, уже не раз использовались массивы и
              родственный им класс A r r a y L i s t динамического списочного массива. Но обычные и списочные массивы
              страдают существенным недостатком.
              Удаление элемента из середины массива обходится дорого с точки зрения потребляемых вычислительных
              ресурсов, потому что все элементы, следующие за удаляемым,
              приходится перемещать к началу массива. Это же справедливо и для ввода
              элементов в середине массива. Этот недостаток позволяет устранить другая широко известная структура
              данных — связный список. Если ссылки на объекты из массива хранятся в последовательных областях памяти,
              то каждый объект из связного списка — в отдельной
              связке. В языке программирования Java все связные списки на самом деле являются
              двунаправленными, т.е. в каждой связке хранится ссылка на ее предшественника
              (рис. 9.7). Удаление элемента из середины связного списка — недорогая операция
              с точки зрения потребляемых вычислительных ресурсов, поскольку в этом случае достаточно обновить лишь
              связки, соседние с удаляемым элементом.

            </p>
            <p>
              Если вы когда-нибудь изучали структуры данных и реализацию связных списков,
              то, возможно, еще помните, насколько хлопотно соединять связки при вводе или удалении элементов связного
              списка. В таком случае вы будете приятно удивлены, узнав,
              что в библиотеке коллекций Java для этой цели предусмотрен готовый к вашим услугам класс LinkedList. В
              приведенном ниже примере кода в связный список сначала
              вводятся три элемента, а затем удаляется второй из них.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        List&lt;String&gt; staff = <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LinkedList&lt;&gt;();
        <span class="hljs-comment" style="color: rgb(113, 149, 168);">// Объект типа LinkedList, реализующий связный список </span>
        staff.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Ашу"</span>);
        staff.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Bob"</span>);
        staff.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Carl"</span>);

        Iterator&lt;String&gt; iter = staff.iterator();
        String first = iter.next();
        String second = iter.next();
        iter.remove();</pre>
            <p>
              Но связные списки существенно отличаются от обобщенных коллекций. Связный
              список — это упорядоченная коллекция, в которой имеет значение расположение объектов. Метод L i n k e d L
              i s t . ad d () вводит объект в конце списка. Но объекты зачастую
              требуется вводить где-то в середине списка.


            </p>
            <p>
              За этот метод ad d (), зависящий от расположения элементов в связном списке, отвечает итератор, поскольку
              в итераторе описывается расположение элементов в коллекции. Применение итераторов для ввода элементов
              имеет смысл только для коллекций, имеющих естественный порядок расположения. Например, коллекция типа
              множества, о которой пойдет речь в следующем разделе, не предполагает никакого
              порядка расположения элементов. Поэтому в интерфейсе I t e r a t o r отсутствует метод add (). Вместо
              него в библиотеке коллекций предусмотрен следующий подчиненный интерфейс Listlterator, содержащий метод
              ad d ():

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">interface</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">L</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">i</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">s</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">t</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">I</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">t</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">e</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">r</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">a</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">t</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">o</span> <span class="hljs-title"
                                                                                    style="color: rgb(37, 127, 173);">r</span> &lt; <span
                class="hljs-title" style="color: rgb(37, 127, 173);">E</span> &gt; <span class="hljs-keyword"
                                                                                         style="color: rgb(107, 107, 184);">extends</span> <span
                class="hljs-title" style="color: rgb(37, 127, 173);">Iterator</span>&lt;<span class="hljs-title"
                                                                                              style="color: rgb(37, 127, 173);">E</span>&gt;
</span>{
    <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span
        class="hljs-title" style="color: rgb(37, 127, 173);">add</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(E element)</span></span>;
}</pre>
            <p>
              В отличие от метода C o l l e c t i o n . a d d (), этот метод не возвращает логическое значение типа
              boolean. Предполагается, что операция ввода элемента в список всегда
              видоизменяет его. Кроме того, в интерфейсе L i s t l t e r a t o r имеются следующие два
              метода, которые можно использовать для обхода списка в обратном направлении:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Е previous ()
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">boolean</span> <span
    class="hljs-title" style="color: rgb(37, 127, 173);">hasPrevious</span><span class="hljs-params"
                                                                                 style="color: rgb(147, 92, 37);">()</span></span></pre>
            <p>
              Как и метод n e x t (), метод p r e v i o u s () возвращает объект, который он прошел.
              А метод l i s t l t e r a t o r () из класса L i n k e d L i s t возвращает объект итератора,
              реализующего интерфейс Listlterator, как показано ниже.


            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Iterator&lt;String&gt; iter = staff.listIterator();</pre>

            <p>
              Метод a d d () вводит новый элемент до текущей позиции итератора. Например,
              в приведенном ниже фрагменте кода пропускается первый элемент связного списка
              и вводится элемент ” Juliet" перед вторым его элементом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        List&lt;String&gt; staff= <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LinkedList&lt;&gt;();
        staff.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Amy"</span>);
        staff.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Bob"</span>);
        staff.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Carl"</span>);
        ListIterator&lt;String&gt; iter = staff.listIterator();
        iter.next();<span class="hljs-comment" style="color: rgb(113, 149, 168);">//      и п е р в ы й э л е м е н т с п и с к а</span>
        iter.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Juliet"</span>);</pre>
            <p>
              Если вызвать метод a d d () несколько раз, элементы будут просто вводиться в список в том порядке, в
              каком они предоставляются. Все они вводятся по очереди до текущей позиции итератора.

            </p>
            <p>
              Когда выполняется операция ввода элемента с помощью итератора, только что
              возвращенного методом l i s t l t e r a t o r () и указывающего на начало связного списка, вводимый
              элемент располагается в начале списка. Когда же итератор достигает
              последнего элемента списка (т.е. метод h a s N e x t () возвращает логическое значение
              false), вводимый элемент располагается в конце списка. Если связный список содержит п элементов, тогда
              для ввода нового элемента в нем имеется п + 1 доступных
              мест. Эти места соответствуют п + 1 возможным позициям итератора. Так, если связный список содержит три
              элемента, А, В и С, для ввода нового элемента в нем имеются четыре возможные позиции, обозначенные ниже
              знаком курсора |.

            </p>
            <p>А В С </p>
            <p>А | В C </p>
            <p>АВ| С </p>
            <p>А В С |</p>

            <p>
              И, наконец, метод s e t () заменяет новым элементом последний элемент, возвращаемый при вызове метода
              next () или previous (). Например, в следующем фрагменте кода первый элемент списка заменяется новым
              значением:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">ListIterator&lt;String&gt; iter = list.listlterator();
String oldValue = iter.next(); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// возвращает первый элемент списка </span>
iter.set(newValue);
<span class="hljs-comment"
      style="color: rgb(113, 149, 168);">// устанавливает в первом элементе новое значение newValue</span></pre>
            <p>
              Нетрудно догадаться, что, если один итератор обходит коллекцию в то время,
              когда другой итератор модифицирует ее, могут возникнуть конфликтные ситуации.
              Допустим, итератор установлен до элемента, который только что удален другим итератором. Теперь этот
              итератор недействителен и не должен больше использоваться.
              Итераторы связного списка способны обнаруживать такие видоизменения. Если итератор обнаруживает, что
              коллекция была модифицирована другим итератором или
              же методом самой коллекции, он генерирует исключение типа ConcurrentModif ic a
              tionException. Рассмотрим в качестве примера следующий фрагмент кода:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">List&lt;String&gt; list = . . .;
ListIterator&lt;String&gt; iterl = list.listlterator();
ListIterator&lt;Stnng&gt; iter2 = list. listlterator () ;
iter1.next ();
iterl.remove();
iter2 .next () ; <span class="hljs-comment" style="color: rgb(113, 149, 168);">// генерирует исключение ConcurrentModificationException</span></pre>
            <p>
              При вызове метода iter2. next () генерируется исключение типа ConcurrentModi
              f icationException, поскольку итератор iter2 обнаруживает, что список был внешне видоизменен. Чтобы
              избежать исключений в связи с попытками одновременной
              модификации, достаточно придерживаться следующего простого правила: к коллекции допускается присоединять
              сколько угодно итераторов, при условии, что все они
              служат только для чтения, но присоединить только один итератор, который служит
              как для чтения, так и для записи.

            </p>
            <p>
              Обнаружение одновременной модификации достигается простым способом. В коллекции отслеживается количество
              изменяющих ее операций (например, ввода и удаления элементов). Каждый итератор хранит отдельный счетчик
              операций модификации,
              вызванных им самим. В начале каждого своего метода итератор сравнивает значение
              собственного счетчика модификаций со значением счетчика модификаций в коллекции. Если эти значения не
              равны, генерируется исключение типа ConcurrentModif ic
              ationException.

            </p>
            <p>
              Итак, мы рассмотрели основные методы из класса LinkedList. А интерфейс
              Listlterator служит как для обхода элементов связного списка в любом направлении, так и для ввода и
              удаления элементов из списка.

            </p>
            <p>
              Как было показано в предыдущем разделе, в интерфейсе Collection объявлено
              немало других полезных методов для операций со связными списками. Они реализованы главным образом в
              суперклассе AbstractCollection класса LinkedList. Например, метод toString () вызывает одноименный метод
              для всех элементов списка
              и формирует одну длинную строку в формате [А, В, С], что удобно для отладки.
              А метод contains () удобен для проверки наличия конкретного элемента в связном
              списке. Так, в результате вызова staff .contains ("Harry”) возвращается логическое
              значение true, если связный список уже содержит символьную строку "Harry".

            </p>
            <p>
              В библиотеке коллекций предусмотрен также ряд методов, которые с теоретической точки зрения кажутся
              избыточными. Ведь в связных списках не поддерживается
              быстрый произвольный доступ. Если требуется проанализировать и-й элемент связного списка, то начинать
              придется с самого начала и перебрать первые п - 1 элементов списка, причем без всяких пропусков. Именно
              по этой причине программисты
              обычно не применяют связные списки в тех случаях, когда к элементам требуется
              обращаться по целочисленному индексу. Тем не менее в классе LinkedList предусмотрен метод get (), который
              позволяет обратиться к определенному элементу
              следующим образом:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">LinkedList&lt;String&gt; list = . . . ;
String obj = list.get(n);
</pre>
            <p>
              Безусловно, этот метод не очень эффективен. И если он все же применяется,
              то, скорее всего, к неподходящей для этого структуре данных. Столь обманчивый
              произвольный доступ не годится для обращения к элементам связного списка. Например, приведенный ниже
              фрагмент кода совершенно неэффективен.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                          style="color: rgb(107, 107, 184);">int</span> i = <span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>; i &lt; list.size (); i++)
    сделать что-нибудь с результатом вызова list.get(i);
</pre>
            <p>
              Всякий раз, когда требуется обратиться к другому элементу с помощью метода get (),
              поиск начинается с самого начала списка. В объекте типа LinkedList не предпринимается никаких попыток
              буферизовать данные о расположении элементов в списке.
            </p>
            <p>
              В интерфейсе итератора списка имеется также метод, предоставляющий индекс
              текущей позиции в списке. Но поскольку итераторы в Java устроены таким образом,
              что обозначают позицию между элементами коллекции, то таких методов на самом
              деле два. Так, метод nextlndex () возвращает целочисленный индекс того элемента,
              который должен быть возвращен при последующем вызове метода next (). А метод
              previous Index () возвращает индекс того элемента, который был бы возвращен при
              последующем вызове метода previous (). И этот индекс будет, конечно, на единицу
              меньше, чем nextlndex. Оба метода действуют эффективно, поскольку в итераторе
              запоминается текущая позиция. И, наконец, если имеется целочисленный индекс п,
              в результате вызова метода list. listlterator (п) будет возвращен итератор, установленный до элемента с
              индексом п. Это означает, при вызове метода next () получается тот же самый элемент, что и при вызове
              метода list. get (n). Следовательно,
              получение такого итератора малоэффективно.

            </p>
            <p>
              Если связный список содержит немного элементов, то вряд ли стоит беспокоиться
              об издержках, связанных с применением методов set () и get (). Но в таком случае
              зачем вообще пользоваться связным списком? Единственная причина для его применения — минимизация издержек
              на ввод и удаление в середине списка. Если в коллекции предполагается лишь несколько элементов, то для ее
              составления лучше воспользоваться списочным массивом типа ArrayList.

            </p>
            <p>
              Рекомендуется держаться подальше от всех методов, в которых целочисленный
              индекс служит для обозначения позиции в связном списке. Если требуется произвольный доступ к коллекции,
              лучше воспользоваться обычным или списочным массивом типа ArrayList, а не связным списком.

            </p>
            <p>
              В примере программы из листинга 9.1 демонстрируется практическое применение связного списка. В этой
              программе сначала составляются два списка, затем они
              объединяются, и далее удаляется каждый второй элемент из второго списка, а в завершение проверяется метод
              removeAll (). Рекомендуется тщательно проанализировать порядок выполнения операций в этой программе,
              уделив особое внимание итераторам. Для этого, возможно, будет полезно составить схематическое
              представление
              позиций итератора аналогично следующему:
            </p>
            <p>
              |АСЕ |BDFG
            </p>
            <p>
              A | CE |BDFG
            </p>
            <p>
              AB| CE В|DFG

            </p>
            <p>
              Следует иметь в виду, что в результате приведенного ниже вызова выводятся все
              элементы связного списка. Для этой цели вызывается метод toStringO из класса
              AbstractCollection.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">System.out.println(a);
</pre>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> linkedList;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program demonstrates operations on linked lists.
 * <span class="hljs-doctag">@version</span> 1.11 2012-01-26
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">LinkedListTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      List&lt;String&gt; a = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LinkedList&lt;&gt;();
      a.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Amy"</span>);
      a.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Carl"</span>);
      a.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Erica"</span>);

      List&lt;String&gt; b = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> LinkedList&lt;&gt;();
      b.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Bob"</span>);
      b.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Doug"</span>);
      b.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Frances"</span>);
      b.add(<span class="hljs-string" style="color: rgb(86, 140, 59);">"Gloria"</span>);

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// merge the words from b into a</span>

      ListIterator&lt;String&gt; aIter = a.listIterator();
      Iterator&lt;String&gt; bIter = b.iterator();

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (bIter.hasNext())
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (aIter.hasNext()) aIter.next();
         aIter.add(bIter.next());
      }

      System.out.println(a);

      <span class="hljs-comment" style="color: rgb(113, 149, 168);">// remove every second word from b</span>

      bIter = b.iterator();
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (bIter.hasNext())
      {
         bIter.next(); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// skip one element</span>
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (bIter.hasNext())
         {
            bIter.next(); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// skip next element</span>
            bIter.remove(); <span class="hljs-comment" style="color: rgb(113, 149, 168);">// remove that element</span>
         }
      }

      System.out.println(b);

      <span class="hljs-comment"
            style="color: rgb(113, 149, 168);">// bulk operation: remove all words in b from a</span>

      a.removeAll(b);

      System.out.println(a);
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
        List<Task<String>> taskList = new LinkedList<>(
                Arrays.asList(
                        new Task<>("4 * 4", "16"),
                        new Task<>("4 + 4", "8")
                )
        );

        ListIterator<Task<String>> taskIterator = taskList.listIterator();

        System.out.println(taskIterator.next().getQuestion());

    }
}

class Task<T> {
    private String question;
    private T answer;

    public Task(String question, T answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
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
  name: "LinkedList",
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

      selected: 'CastException',
      options: [
        {item: 'CastException', name: 'CastException'},
        {item: 'UnderfindedTypeOfProperty', name: 'UnderfindedTypeOfProperty'},
        {item: '16', name: '16'},
        {item: '12', name: '12'},
        {item: '4 + 4', name: '4 + 4'},
        {item: '4 * 4', name: '4 * 4'},
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/eighthchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 8.3
              window.frontendData.language.chapters[7].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[4].task.answer

          window.frontendData.language.chapters[7].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[4].task.answer
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
        List< Task < String > > taskList = new LinkedList<>(
                Arrays.asList(
                        new Task<>("4 * 4", "16"),
                        new Task<>("4 + 4", "8")
                )
        );

        ListIterator< Task < String > > taskIterator = taskList.listIterator();

        System.out.println(taskIterator.next().getQuestion());

    }
}

class Task< T > {
    private String question;
    private T answer;

    public Task(String question, T answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
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

    let themeToClose = document.getElementById('java-8-chapter-3-theme-1-subtheme');

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