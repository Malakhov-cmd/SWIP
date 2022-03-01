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
          Нисходящие коллекторы
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              Метод g roup ingBy ( ) формирует множество, :шачениями которого являются
              списки. Если требуется обработать эти списки каким-то образом, то следует предоставить нисходящий
              коллектор. Так, если вместо списков требуются множества,
              можно воспользовап,ся коллектором Co l l ectors . toSet () следующим образом:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Map&lt;String, Set &lt;Locale&gt;&gt; count ryToLocaleSet =
    locales . collect ( groupingBy (
         Locale : : getCountry, toSet ())); </pre>
            <p>
              Для сведения сгруппированных элементов к числам предоставляется ряд сле
              дующих коллекторов:
            </p>
            <ul>
              <li>
                <p>
                  counting ( ) - производит подсчет накопленных элементов. Так, в следу
                  ющем примере кода подсчитывается количество региональных настроек
                  для каждой страны:
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Map&lt;String, Set &lt;Locale&gt;&gt; count ryToLocaleSet =
    locales . collect ( groupingBy (
         Locale : : getCountry, toSet ())); </pre>
              </li>
              <li>
                <p>
                  summing ( Int 1 Long 1 DouЬle) - принимает в качестве аргумента функцию,
                  применяет ее к элементам нисходящего потока данных и получает их сумму. Так, в следующем примере кода
                  вычисляется суммарное население
                  каждого штата из потока городов:
                </p>
              </li>
              <li>
                <p>
                  summing ( Int 1 Long 1 DouЬle) - принимает в качестве аргумента функцию,
                  применяет ее к элементам нисходящего потока данных и получает их сумму. Так, в следующем примере кода
                  вычисляется суммарное население
                  каждого штата из потока городов:
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">        Map&lt;String, Int eger&gt; s t ateToCit yPopulat ion =
                cities . <span class="hljs-function">co l l <span class="hljs-title" style="color: rgb(37, 127, 173);">ect</span> <span
                      class="hljs-params" style="color: rgb(147, 92, 37);">( groupingBy ( Ci ty: : getState,
                summingint (City : : ge t Populat ion )</span> ) )</span>;</pre>
              </li>
              <li>
                <p>
                  mахВу () и minBy ( ) - принимают в качестве аргумента компаратор и получают максимальный и
                  минимальный элементы из нисходящего потока
                  данных. Так, в следующем примере кода получается самый крупный город
                  в каждом штате:
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Map&lt;String, City&gt; stat eToLarg estCity = cit ies . <span
                    class="hljs-function">co l l e <span class="hljs-title" style="color: rgb(37, 127, 173);">ct</span> <span
                    class="hljs-params" style="color: rgb(147, 92, 37);">(
groupimaxВyngBy ( City : : getSta t e ,
( Comparator . compa ring ( City: : get Populat i on )</span> )) )</span>; </pre>
              </li>
              <li>
                <p>
                  col lectingAndThen () - вводит завершающую стадию накопления. Та к,
                  если требуется выяснить, сколько имеется отдельных резул1,татов, их можно накопить сначала в
                  множестве, а затем вычислить его размер, как показано ниже.
                </p>
                <pre class="hljs"
                     style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Map&lt;Character, Integer&gt; stringCount sByStartingLetter =
s t rings . <span class="hljs-function">co l l <span class="hljs-title"
                                                     style="color: rgb(37, 127, 173);">ect</span> <span
                      class="hljs-params" style="color: rgb(147, 92, 37);">( g roupingBy (s -&gt; s . charAt (O)</span> ,
<span class="hljs-title" style="color: rgb(37, 127, 173);">collectingAndThen</span> <span class="hljs-params"
                                                                                          style="color: rgb(147, 92, 37);">(toSet ( )</span> , Set : : s i ze ) ) )</span>; </pre>
              </li>
            </ul>
            <p>
              Совсем иначе действует коллектор, реализуемый методом mapp ing (). Он
              применяет функцию к каждому накапливаемому элементу и передает полученные результаты нисходящему
              коллектору, как демонстрируется в приведенном
              ниже примере кода .
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Map&lt;Character, Set &lt;Integer&gt;&gt; stringLengthsByStart i ngLet ter
= s t rings . <span class="hljs-function">co <span class="hljs-title"
                                                   style="color: rgb(37, 127, 173);">llect</span> <span
                  class="hljs-params" style="color: rgb(147, 92, 37);">( groupi ngBy (s -&gt; s . cha rAt (O)</span> ,
<span class="hljs-title" style="color: rgb(37, 127, 173);">mapping</span> <span class="hljs-params"
                                                                                style="color: rgb(147, 92, 37);">( Stri ng : : l ength, toSet ( )</span>)))</span>; </pre>

            <p>
              Коллекторы можно эффективно сочетать вместе, но в итоге получаются весьма запутанные выражения. Поэтому
              их лучше всего использовать вместе с методом g roupingBy ( ) или parti tioningBy () для обработки
              значений, преобразуемых из нисходящего потока данных. В противном случае непосредственно
              в потоках данных применяются та кие методы, как map (), reduce ( ) , coun t ( } ,
              max ( ) или min ().
            </p>
            <div class="page-theme-author-text text-white-50">
              Приведенный материал был взят из книги "Java. Библиотека профессионала, том 2.", написанной Кейем С.
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
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, Optional<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.minBy(Comparator.comparing(Phone::getPrice))));

        phonesByCompany
                .forEach((key, value) ->
                        System.out.println(key + " " + value
                                .or(() -> Optional.of(new Phone("non", "non", 0)))
                                .get()
                                .getPrice()
                        )
                );
    }
}

class Phone{

    private String name;
    private String company;
    private int price;

    public Phone(String name, String comp, int price){
        this.name=name;
        this.company=comp;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCompany() { return company; }
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
  name: "DowingCollectors",
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
        {item: 'Google 500', name: 'Apple 450'},
        {item: 'Google 500 Apple 450', name: 'Google 500 Apple 450'},
        {item: 'Samsung 340 Google 500 Apple 450', name: ' Samsung 340 Google 500 Apple 450'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/tenthchapter/', {
        params: {
          numberTheme: 8,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[9].listThemes[7].task.answer = response.data
              window.frontendData.language.chapters[9].chapterProgress += 11.1
              window.frontendData.language.chapters[9].listThemes[7].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[9].listThemes[7].task.answer

          window.frontendData.language.chapters[9].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[9].listThemes[7].task.tryCount++
          window.frontendData.language.chapters[9].listThemes[7].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[9].listThemes[7].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[9].listThemes[7].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[9].listThemes[7].task.answer
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
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, Optional<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.minBy(Comparator.comparing(Phone::getPrice))));

        phonesByCompany
                .forEach((key, value) ->
                        System.out.println(key + " " + value
                                .or(() -> Optional.of(new Phone("non", "non", 0)))
                                .get()
                                .getPrice()
                        )
                );
    }
}

class Phone{

    private String name;
    private String company;
    private int price;

    public Phone(String name, String comp, int price){
        this.name=name;
        this.company=comp;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCompany() { return company; }
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

    let themeToClose = document.getElementById('java-10-chapter-11-theme');

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