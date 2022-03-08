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
              Хеш-множества
            </p>
            <p>
              Связные списки и массивы позволяют указывать порядок, в котором должны следовать элементы. Но если вам
              нужно найти конкретный элемент, а вы не помните
              его позицию в коллекции, то придется перебирать все элементы до тех пор, пока
              не будет обнаружено совпадение по критерию поиска. На это может потребоваться некоторое время, если
              коллекция содержит достаточно много элементов. Если же
              порядок расположения элементов не имеет особого значения, то для подобных случаев предусмотрены структуры
              данных, которые позволяют намного быстрее находить элементы в коллекции. Но недостаток таких структур
              данных заключается в том,
              что они не обеспечивают никакого контроля над порядком расположения элементов
              в коллекции. Эти структуры данных организуют элементы в том порядке, который
              удобен для их собственных целей.

            </p>
            <p>
              К числу широко известных структур данных для быстрого нахождения объектов
              относится так называемая хеш-таблица, которая вычисляет для каждого объекта целочисленное значение,
              называемое хеги-кодом. Хеш-код — это целочисленное значение,
              которое выводится определенным образом из данных в полях экземпляра объекта,
              причем предполагается, что объекты с разными данными порождают разные хеш-коды.
            </p>
            <p>
              Если вы определяете свои собственные классы, то на вас ложится ответственность
              за самостоятельную реализацию метода hashCode () (подробнее об этом см. в главе 5). Ваша реализация
              данного метода должна быть совместима с методом equals ().
              Так, если в результате вызова a.equals (b) возвращается логическое значение true,
              то объекты а и b должны иметь одинаковые хеш-коды. Но самое главное, чтобы
              хеш-коды вычислялись быстро, а вычисление зависело только от состояния хешируемого объекта, а не от
              других объектов в хеш-таблице.

            </p>
            <p>
              В Java хеш-таблицы реализованы в виде массивов связных списков. Чтобы найти место объекта в таблице,
              вычисляется его хеш-код и уменьшается его модуль до общего количества групп. Полученное
              в итоге числовое значение и будет индексом группы, содержащей искомый элемент.
              Так, если хеш-код объекта равен 76268, а всего имеется 128 групп, объект должен
              быть размещен в группе под номером 108 (поскольку остаток от целочисленного деления 76268 на 128 равен
              108). Если повезет, то в этой группе не окажется других
              элементов, и тогда элемент просто вводится в группу. Безусловно, рано или поздно встретится непустая
              группа. Такое явление называется хеш-конфликтом. В таком
              случае новый объект сравнивается со всеми объектами в группе, чтобы проверить,
              находится ли он уже в группе. Если учесть сравнительно равномерное распределение
              хеш-кодов при достаточно большом количестве групп, то в конечном итоге потребуется лишь несколько
              сравнений.

            </p>
            <p>
              Если требуется более полный контроль над производительностью хеш-таблицы,
              то можно указать первоначальное количество групп. Оно определяет количество
              групп, используемых для накопления объектов с одинаковыми хеш-значениями.
              Если же в хеш-таблицу вводится слишком много элементов, количество конфликтов
              возрастает, что отрицательно сказывается на производительности извлечения элементов из хеш-таблицы.

            </p>
            <p>
              Если приблизительно известно, сколько элементов в конечном итоге окажется
              в хеш-таблице, можно установить количество групп. Обычно это количество устанавливается в пределах от 75
              до 150% от ожидаемого числа элементов. Некоторые исследователи полагают, что количество групп должно быть
              выражено простым числом,
              чтобы предотвратить группирование ключей. Но на этот счет нет общего мнения.
              В стандартной библиотеке используются количества групп, выражаемые числом, являющимся степенью 2, по
              умолчанию — 16. (Любое указываемое значение размеров
              хеш-таблицы автоматически округляется до следующей степени 2.)

            </p>
            <p>
              Безусловно, далеко не всегда известно, сколько элементов придется хранить
              в хеш-таблице, а кроме того, первоначально предполагаемое их количество может
              оказаться заниженным. Если хеш-таблица становится чрезмерно заполненной, ее следует хешировать повторно.
              Для повторного хеширования создается новая хеш-таблица с большим количеством групп, все элементы старой
              таблицы вводятся в новую,
              а старая хеш-таблица отвергается. Коэффициент загрузки определяет момент повторного хеширования
              хеш-таблицы. Так, если коэффициент загрузки равен 0,75 (по
              умолчанию), а хеш-таблица заполнена более чем на 75%, она автоматически хешируется повторно с увеличенным
              вдвое количеством групп. Для большинства приложений целесообразно оставить коэффициент загрузки равным
              0,75
            </p>
            <p>
              Хеш-таблицы можно использовать для реализации ряда важных структур данных.
              Простейшая из них относится к типу множества. Множество — это совокупность элементов, не содержащая
              дубликатов. Так, метод add () сначала пытается найти вводимый объект и вводит его только в том случае,
              если он отсутствует в множестве.
            </p>
            <p>
              В библиотеке коллекций Java предоставляется класс HashSet, реализующий
              множество на основе хеш-таблицы. Элементы вводятся в такое множество методом
              add (). А метод contains () переопределяется, чтобы осуществлять быстрый поиск
              элементов в множестве. Он проверяет элементы только одной группы, а не все элементы коллекции.

            </p>
            <p>
              Итератор хеш-множества перебирает все группы по очереди. В результате хеширования элементы распределяются
              по таблице, и создается впечатление, будто обращение к ним происходит в случайном порядке. Поэтому
              классом HashSet следует
              пользоваться только в том случае, если порядок расположения элементов в коллекции не имеет особого
              значения.
            </p>
            <p>
              В примере программы из листинга 9.2 отдельные слова текста вводятся из стандартного потока System, in в
              хеш-множество, а затем выводятся из него. Например,
              данной программе можно направить англоязычный текст книги "Алиса в стране чудес" (доступный по адресу
              http://www.gutenberg.net), запустив ее из командной
              строки следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">}ava SetTest &lt; alice30.txt</pre>
            <p>
              Программа введет все слова из стандартного потока ввода в хеш-множество, а затем переберет все
              неповторяющиеся слова в хеш-множестве и выведет их количество. (Так, текст книги "Алиса в стране чудес"
              содержит 5909 неповторяющихся слов,
              включая уведомление об авторском праве в самом начале.) Слова извлекаются из
              хеш-множества в случайном порядке.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">package</span> set;

<span class="hljs-keyword" style="color: rgb(107, 107, 184);">import</span> java.util.*;

<span class="hljs-comment" style="color: rgb(113, 149, 168);">/**
 * This program uses a set to print all unique words in System.in.
 * <span class="hljs-doctag">@version</span> 1.12 2015-06-21
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(107, 107, 184);">class</span> <span class="hljs-title"
                                                                                             style="color: rgb(37, 127, 173);">SetTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(107, 107, 184);">public</span> <span
       class="hljs-keyword" style="color: rgb(107, 107, 184);">static</span> <span class="hljs-keyword"
                                                                                   style="color: rgb(107, 107, 184);">void</span> <span
       class="hljs-title" style="color: rgb(37, 127, 173);">main</span><span class="hljs-params"
                                                                             style="color: rgb(147, 92, 37);">(String[] args)</span>
   </span>{
      Set&lt;String&gt; words = <span class="hljs-keyword" style="color: rgb(107, 107, 184);">new</span> HashSet&lt;&gt;(); <span
                  class="hljs-comment" style="color: rgb(113, 149, 168);">// HashSet implements Set</span>
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">long</span> totalTime = <span class="hljs-number"
                                                                                                  style="color: rgb(147, 92, 37);">0</span>;

      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">try</span> (Scanner in = <span class="hljs-keyword"
                                                                                                   style="color: rgb(107, 107, 184);">new</span> Scanner(System.in))
      {
         <span class="hljs-keyword" style="color: rgb(107, 107, 184);">while</span> (in.hasNext())
         {
            String word = in.next();
            <span class="hljs-keyword" style="color: rgb(107, 107, 184);">long</span> callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
         }
      }

      Iterator&lt;String&gt; iter = words.iterator();
      <span class="hljs-keyword" style="color: rgb(107, 107, 184);">for</span> (<span class="hljs-keyword"
                                                                                      style="color: rgb(107, 107, 184);">int</span> i = <span
                  class="hljs-number" style="color: rgb(147, 92, 37);">1</span>; i &lt;= <span class="hljs-number"
                                                                                               style="color: rgb(147, 92, 37);">20</span> &amp;&amp; iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(<span class="hljs-string" style="color: rgb(86, 140, 59);">". . ."</span>);
      System.out.println(words.size() + <span class="hljs-string"
                                              style="color: rgb(86, 140, 59);">" distinct words. "</span> + totalTime + <span
                  class="hljs-string" style="color: rgb(86, 140, 59);">" milliseconds."</span>);
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
        Set<Task<String>> taskSet = new HashSet<>(
                Arrays.asList(
                        new Task<>("4 * 4", "16")
                )
        );

        Task<String> task = new Task<>("4 + 4", "8");

        taskSet.add(task);
        taskSet.add(task);

        taskSet.forEach( taskItem -> {
            System.out.print(taskItem.getAnswer() + " ");
        });

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
  name: "HashMap",
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
        {item: '16 8', name: '16 8'},
        {item: '16 8 8', name: '16 8 8'},
        {item: '8 16', name: '8 16'},
        {item: '8 16 16', name: '8 16 16'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('/java/eighthchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[7].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[7].chapterProgress += 8.3
              window.frontendData.language.chapters[7].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[7].listThemes[6].task.answer

          window.frontendData.language.chapters[7].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[7].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[7].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[7].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[7].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[7].listThemes[6].task.answer
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
        Set<Task<String>> taskSet = new HashSet<>(
                Arrays.asList(
                        new Task<>("4 * 4", "16")
                )
        );

        Task<String> task = new Task<>("4 + 4", "8");

        taskSet.add(task);
        taskSet.add(task);

        taskSet.forEach( taskItem -> {
            System.out.print(taskItem.getAnswer() + " ");
        });

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

    let themeToClose = document.getElementById('java-8-chapter-3-theme-3-subtheme');

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