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
          Перехват исключений
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Теперь вы знаете, как генерировать исключения. Как видите, ничего сложного
              в этом нет: сгенерировав исключение, о нем можно попросту забыть. Разумеется, должен существовать кол
              позволяющий перехватить и обработать исключение. Именно
              об этом и пойдет речь в последующих разделах.
            </p>
            <p>
              Перехват одного исключения
            </p>

            <p>
              Если исключение возникает и нигде не перехватывается, то программа прекращает
              работу, выводя на консоль сообщение о типе исключения и содержимое стека. Программы с ГПИ (аплеты и
              приложения) перехватывают исключения и выводят аналогичное сообщение, возвращаясь затем в цикл обработки
              событий в пользовательском
              интерфейсе. (Отлаживая программы с ГПИ, лучше не сворачивать консольное окно
              на экране.)
            </p>
            <p>
              Перехват исключения осуществляется в блоке операторов try /ca tch . В простейшем случае этот блок имеет
              следующий вид:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                код
                дополнительный код
                дополнительный код
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> ( ТипИсключения е )
            {
                обработчик исключений данного типа
            }</pre>
            <p>
              Если фрагмент кода в блоке tr y генерирует исключение типа, указанного в заголовке блока catch, то
              происходит следующее.
            </p>
            <ul>
              <li>
                <p>
                  Программа пропускает оставшуюся часть кода в блоке try.
                </p>
              </li>
              <li>
                <p>
                  Программа выполняет код обработчика в блоке catch.
                </p>
              </li>
            </ul>
            <p>
              Если код в блоке tr y не генерирует исключение, то программа пропускает блок
              catch. А если какой-нибудь из операторов блока tr y сгенерирует исключение, отличающееся от типа,
              указанного в блоке catch, то выполнение данной части программы (в частности, вызываемого метода)
              немедленно прекращается. (Остается только
              надеяться, что в вызывающей части программы все же предусмотрен перехват исключения данного типа.
            </p>
            <p>
              Чтобы продемонстрировать, как все описанное выше действует на практике, рассмотрим следующий типичный код
              для ввода данных:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">read</span> <span
                class="hljs-params" style="color: rgb(147, 92, 37);">( String filename)</span>
        </span>{
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
                InputStream in = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FileInputStream(filename);
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> b;
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> ((b = in.read()) != -<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>) {
                    обработать введенные данные;
                }
            }  <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException e) {
                e.printStackTrace();
            }
        }</pre>
            <p>
              Обратите внимание на то, что большая часть кода в блоке try выполняет простейшие действия: вводит и
              обрабатывает данные отдельными байтами до тех пор,
              пока не будет достигнут конец файла. Как указано в документации на прикладной
              программный интерфейс API, существует вероятность того, что метод read () сгенерирует исключение
              IOException. В таком случае пропускается весь остальной цикл
              while, происходит непосредственный переход к блоку catch и генерируется трассировка стека. Для небольших
              программ это вполне благоразумный способ обработки
              исключений. А какие еще существуют возможности?

            </p>
            ключений. А какие еще существуют возможности?
            Зачастую лучше вообще ничего не делать, а просто передать исключение вызывающей части программы. Если в
            методе read () возникнет ошибка ввода, ответственность
            за обработку этой исключительной ситуации следует возложить на вызывающую часть
            программы! Придерживаясь такого подхода, достаточно указать, что метод read () может генерировать
            исключение типа IOException следующим образом:
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        <span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">read</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">(String filename)</span> <span class="hljs-keyword"
                                                                                                    style="color: rgb(107, 107, 184);">throws</span> IOException
        </span>{
            InputStream in = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> FilelnputStream(filename);
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> b;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> ( (b = in.read()) != -<span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>)
                обработать введенные данные
        }</pre>

            <p>
              Напомним, что компилятор строго следит за спецификаторами throws. Вызывая
              метод, генерирующий проверяемое исключение, следует обработать его самостоятельно в этом методе или
              делегировать его обработку вызывающей части программы. Что же лучше? Как правило, следует перехватывать
              лишь те исключения, которые можно обработать самостоятельно, а остальные передавать дальше. Передавая
              исключение, следует непременно добавить спецификатор throws, чтобы предупредить об этом вызывающую часть
              программы.
            </p>
            <p>
              Просматривая документацию на прикладной программный интерфейс API, обратите внимание на методы, которые
              способны генерировать исключения. А затем
              решите, следует ли обрабатывать исключение самостоятельно или включить его
              в список спецификатора throws. В последнем варианте нет ничего постыдного: лучше предоставить обработку
              исключения более компетентному обработчику, чем пытаться организовать ее самостоятельно.

            </p>
            <p>
              Как упоминалось ранее, из этого правила имеется одно исключение. Если создается метод, переопределяющий
              метод суперкласса, но не генерирующий ни одного исключения (например, метод paintComponent () из класса
              JComponent), каждое
              проверяемое исключение следует непременно перехватывать в теле этого метода самостоятельно. В этот метод
              из подкласса нельзя добавить спецификатор throws, отсутствующий в переопределяемом методе из суперкласса.
            </p>
            <p>
              Перехват нескольких исключений

            </p>
            <p>
              блоке tr y можно перехватить несколько исключений, обработав их по отдельности. Для каждого типа
              исключения следует предусмотреть свой блок catch следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                код, способный генерировать исключения
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (FileNotFoundException е)
            {
                чрезвычайные действия, если отсутствуют нужные файлы
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (UnknownHostException е)
            {
                чрезвычайные действия, если хосты неизвестны
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException е)
            {
                чрезвычайные действия во всех остальных
                случаях появления ошибок ввода-вывода
            }</pre>
            <p>
              Объект исключения содержит сведения о нем. Для того чтобы получить дополнительные сведения об этом
              объекте из подробного сообщения об ошибке, достаточно
              сделать вызов e.getM essage (), а для того чтобы получить конкретный тип объекта
              исключения, — вызов е . getC lass () . getName ().

            </p>
            <p>
              Начиная с версии Java SE7, разнотипные исключения можно перехватывать в одном и том же блоке catch .
              Допустим, чрезвычайные действия, если нужные файлы
              отсутствуют или хосты неизвестны, одинаковы. В таком случае блоки catch перехвата
              обоих исключений можно объединить, как показано ниже. К такому способу перехвата исключений следует
              прибегать лишь в тех случаях, когда перехватываемые исключения не являются подклассами друг для друга.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> {
                код, способный генерировать исключения
            } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (FileNotFoundException | UnknownHostException е) {
                чрезвычайные действия, если нужные файлы отсутствуют
                или неизвестны хосты
            } <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException е) {
                чрезвычайные действия во всех остальных
                случаях появления ошибок ввода -вывода
            }</pre>
            <p>
              Повторное генерирование и связывание исключений в цепочку
            </p>
            <p>
              Исключение можно генерировать и в блоке catch, образуя тем самым цепочку
              исключений. Обычно это делается для того, чтобы изменить тип исключения. Так,
              если разрабатывается подсистема для применения другими разработчиками, то
              имеет смысл генерировать такие исключения, которые давали бы возможность сразу
              определить, что ошибка возникла именно в этой подсистеме. В качестве характерного
              примера можно привести исключение типа ServletException. Вполне возможно,
              что в коде, где выполняется сервлет, совсем не обязательно иметь подробные сведения о том, какая именно
              возникла ошибка, а важно лишь знать, что сервлет работает
              некорректно. В приведенном ниже фрагменте кода показано, каким образом перехватывается и повторно
              генерируется исключение.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                получить доступ к базе данных
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (SQLException е)
            {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">throw</span> <span class="hljs-keyword"
                                                                                                 style="color: rgb(107, 107, 184);">new</span> ServletException(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"database error: "</span> + e .getMessage());
            }</pre>
            <p>
              В данном случае текст сообщения об исключении формируется в конструкторе
              класса ServletException. Но предыдущее исключение лучше сделать причиной, т.е.
              источником последующего исключения, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                получить доступ к базе данных
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (SQLException е)
            {
                Throwable se = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> ServletException(<span
                  class="hljs-string" style="color: rgb(86, 140, 59);">"database error"</span>);
                se.initCause(e);
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">throw</span> se;
            }</pre>
            <p>
              Теперь при перехвате последующего исключения предыдущее исключение можно извлечь следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Throwable е = se.getCause();</pre>
            <p>
              Настоятельно рекомендуется именно такой способ заключения исключений в оболочку. Ведь он позволяет
              генерировать исключения более высокого уровня, не теряя
              подробных сведений об исходном исключении
            </p>
            <p>
              Иногда требуется зарегисгрировать исключение и сгенерировать его повторно без
              всяких изменений:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                получить доступ к базе данных
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (Exception е)
            {
                logger.log(level, message, e);
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">throw</span> e;
            }</pre>
            <p>
              До версии Java SE 7 такому подходу был присущ существенный недостаток. Допустим, в теле метода имеется
              следующая строка кода:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">void</span> <span class="hljs-title"
                                                                                          style="color: rgb(37, 127, 173);">updateRecord</span><span
                class="hljs-params" style="color: rgb(147, 92, 37);">()</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">throws</span> SQLException</span></pre>
            <p>
              Раньше компилятор анализировал оператор throw в блоке catch, а затем тип
              переменной е и выдавал предупреждение, что данный метод может сгенерировать
              любое исключение типа Exception, а не только типа SQLException. Этот недостаток
              был устранен в версии Java SE 7. Теперь компилятор проверяет только тот факт, что
              переменная е происходит из блока try. Если в данном блоке экземплярами класса
              SQLException являются только проверяемые исключения и содержимое переменной
              е не изменяется в блоке catch, то в объявлении объемлющего метода можно с полным основанием указать
              генерирование исключения следующим образом: throws
              SQLException.

            </p>
            <p>
              Блок finally
            </p>
            <p>
              Когда в методе генерируется исключение, оставшиеся в нем операторы не выполняются. Если же в методе
              задействованы какие-нибудь локальные ресурсы, о которых
              известно лишь ему, то освободить их уже нельзя. Можно, конечно, перехватить и повторно сгенерировать все
              исключения, но это не совсем удачное решение, поскольку
              ресурсы нужно освобождать в двух местах: в обычном коде и в коде исключения.
            </p>
            <p>
              В языке Java принято лучшее решение — организовать блок finally. Рассмотрим
              применение этого блока на примере того, как правильно закрывать файл. Работая
              с базами данных, можно применять тот же самый подход, чтобы правильно разорвать соединение с базой
              данных. Как будет показано в главе 4 второго тома настоящего издания, разрывать соединение с базой данных
              необходимо даже в том случае,
              если при выполнении программы возникло исключение.
            </p>
            <p>
              Код в блоке finally выполняется независимо от того, возникло исключение или
              нет. Так, в приведенном ниже примере кода графический контекст освобождается
              при любых условиях.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            <span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// 1</span>
                код, способный генерировать исключения
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// 2</span>
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (IOException е)
            {
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// 3</span>
                вывести сообщение об ошибке
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// 4</span>
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
            {
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// 5</span>
                in.close();
            }
<span class="hljs-comment" style="color: rgb(113, 149, 168);">// б</span></pre>
            <p>
              Рассмотрим три возможных ситуации, в которых программа выполняет блок
              finally.

            </p>
            <ul>
              <li>
                <p>
                  Код не генерирует никаких исключений. В этом случае программа сначала
                  полностью выполняет блок try, а затем блок finally. Иными словами, выполнение программы
                  последовательно проходит через точки 1, 2, 5 и 6.

                </p>
              </li>
              <li>
                <p>
                  Код генерирует исключение, которое перехватывается в блоке catch (в данном примере это исключение
                  типа IOException). В этом случае программа
                  сначала выполняет блок try до той точки, в которой возникает исключение,
                  а остальная часть блока try пропускается. Затем программа выполняет код из
                  соответствующего блока catch и, наконец, код из блока finally.

                </p>
                <p>
                  Если в блоке catch исключения не генерируются, то выполнение программы
                  продолжается с первой строки, следующей после блока try. Таким образом,
                  выполнение программы последовательно проходит через точки 1, 3, 4, 5 и 6.
                  Если же исключение генерируется в блоке catch, то управление передается вызывающей части программы и
                  выполнение программы проходит только через
                  точки 1, 3 и 5.

                </p>
              </li>
              <li>
                <p>
                  Код генерирует исключение, которое не обрабатывается в блоке catch. В этом
                  случае программа выполняет блок try вплоть до той точки, в которой генерируется исключение, а
                  оставшаяся часть блока try пропускается. Затем программа выполняет код из блока finally и передает
                  исключение обратно вызывающей части программы. Таким образом, выполнение программы проходит
                  только через точки 1 и 5
                </p>
              </li>
            </ul>
            <p>
              Блок finally можно использовать и без блока catch. Рассмотрим следующий
              пример кода:

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">InputStream in = ...;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
{
код, способный генерировать исключения
}
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
{
in.close();
}
</pre>
            <p>
              Оператор in. close () из блока finally выполняется независимо от того, возникает ли исключение в блоке
              try. Разумеется, если исключение возникает, он
              будет перехвачено в очередном блоке catch. Как рекомендуется ниже, конструкцию
              f i n a l l y на самом деле следует применять всякий раз, когда требуется освободить
              используемый ресурс.

            </p>
            <p>
              Иногда блок f in a lly приводит программирующих на Java в полное отчаяние, например, в тех случаях, когда
              методы очистки памяти генерируют исключения. Предположим, что при возникновении исключения требуется
              закрыть поток ввода, как
              показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            InputStream in = ...;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                код, способный генерировать исключения
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
            {
                in.close();
            }</pre>
            <p>
              Допустим также, что код в блоке try генерирует некоторое исключение, не относящееся к классу IOException.
              И в этом случае выполняется блок finally, в котором
              вызывается метод close (), способный сгенерировать исключение типа IOException!
              В итоге исходное исключение будет потеряно, а вместо него будет сгенерировано исключение в методе close
              ().

            </p>
            <p>
              Таким образом, при обработке исключений возникает затруднительное положение в связи с тем, что первое из
              упомянутых выше исключений представляет намного
              больший интерес. Для того чтобы исправить это положение, придется повторно сгенерировать исходное
              исключение, усложнив в конечном итоге исходный код. Ниже
              показано, как лучше всего выйти из столь затруднительного положения.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">            InputStream in = ...;
            Exception ex = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>;
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
            {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
                {
                    код, способный генерировать исключения
                }
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (Exception e)
                {
                    ex = e;
                    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">throw</span> e;
                }
            }
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">finally</span>
            {
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span>
                {
                    in.close();
                }
                <span class="hljs-keyword" style="color: rgb(107, 107, 184);">catch</span> (Exception e)
                {
                    <span class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (ex == <span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">null</span>) <span class="hljs-keyword"
                                                                                             style="color: rgb(107, 107, 184);">throw</span> e;
                }
            }</pre>

            <p>
              Правда, в версии Java SE 7 внедрено языковое средство, намного упрощающее задачу освобождения
              используемых ресурсов. Это средство мы обсудим в следующем
              разделе.
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
        List<Task> taskList = new ArrayList<>(
                Arrays.asList(
                        new Task("2 + 2", "4"),
                        new Task("3 * 4", "12")
                )
        );

        //допустим пользователь ввел вот такой ответ
        String userAnswer = null;

        try {
            taskList.get(1).checkAnswer(userAnswer);
            System.out.println("Success task complete");
        } catch (NullPointerException exception) {
            System.out.println("null value");
        }
        catch (TaskException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("request is proccessed");
        }
    }


    static class Task {
        private String question;
        private String answer;

        public Task(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public boolean checkAnswer(String userAnswer) throws NullPointerException, TaskException {
            if (userAnswer == null){
                throw new NullPointerException("null answer");
            }
            if (getAnswer().equals(userAnswer)) {
                throw new TaskException("wrong answer");
            }
            return userAnswer.equals(getAnswer());
        }
    }

    static class TaskException extends IOException {
        public TaskException() {
        }

        public TaskException(String message) {
            super(message);
        }
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
  name: "InterceptionOneExeption",
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

      selected: 'null value\n' +
          'request is proccessed',
      options: [
        {item: 'null value\n' +
              'request is proccessed', name: 'null value\n' +
              'request is proccessed'},
        {item: 'wrong answer\n' +
              'request is proccessed', name: 'wrong answer\n' +
              'request is proccessed'},
        {item: 'Success task complete', name: 'Success task complete'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/sixthchapter/', {
        params: {
          numberTheme: 4,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[5].listThemes[3].task.answer = response.data
              window.frontendData.language.chapters[5].chapterProgress += 16.6
              window.frontendData.language.chapters[5].listThemes[3].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[5].listThemes[3].task.answer

          window.frontendData.language.chapters[5].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[5].listThemes[3].task.tryCount++
          window.frontendData.language.chapters[5].listThemes[3].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[4].listThemes[3].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[5].listThemes[3].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[5].listThemes[3].task.answer
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
        List<Task> taskList = new ArrayList<>(
                Arrays.asList(
                        new Task("2 + 2", "4"),
                        new Task("3 * 4", "12")
                )
        );

        //допустим пользователь ввел вот такой ответ
        String userAnswer = null;

        try {
            taskList.get(1).checkAnswer(userAnswer);
            System.out.println("Success task complete");
        } catch (NullPointerException exception) {
            System.out.println("null value");
        }
        catch (TaskException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("request is proccessed");
        }
    }


    static class Task {
        private String question;
        private String answer;

        public Task(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public boolean checkAnswer(String userAnswer) throws NullPointerException, TaskException {
            if (userAnswer == null){
                throw new NullPointerException("null answer");
            }
            if (getAnswer().equals(userAnswer)) {
                throw new TaskException("wrong answer");
            }
            return userAnswer.equals(getAnswer());
        }
    }

    static class TaskException extends IOException {
        public TaskException() {
        }

        public TaskException(String message) {
            super(message);
        }
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

    let themeToClose = document.getElementById('java-6-chapter-2-theme-1-subtheme');

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