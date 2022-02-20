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
          Приведение типов
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>
              В главе 3 был рассмотрен процесс принудительного преобразования одного типа
              в другой, называемый приведением типов. Для этой цели в Java предусмотрена специальная запись. Например,
              при выполнении следующего фрагмента кода значение переменной х преобразуется в целочисленное
              отбрасыванием дробной част
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">double</span> х = <span class="hljs-number"
                                                                                                style="color: rgb(147, 92, 37);">3.405</span>;
<span class="hljs-keyword" style="color: rgb(107, 107, 184);">int</span> nx = (<span class="hljs-keyword"
                                                                                     style="color: rgb(107, 107, 184);">int</span>) x;
</pre>
            <p>И как иногда возникает потребность в преобразовании значения с плавающей
              точкой в целочисленное, так и ссылку на объект требуется порой привести к типу
              другого класса. Для такого приведения типов служат те же самые синтаксические
              конструкции, что и для числовых выражений. С этой целью имя нужного класса следует заключить в скобки и
              поставить перед той ссылкой на объект, которую требуется привести к искомому типу. Ниже приведен
              соответствующий тому пример.
              в начале этой главы, были приняты специальные меры, чтобы избежать приведения типов. В частности,
              переменная boss была инициализирована объектом типа
              Manager, перед тем как разместить ее в массиве. Чтобы задать величину премии руководящего работника,
              нужно знать правильный тип соответствующего объекта.)
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager boss = (Manager) staff[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">0</span>];</pre>
            <p>Как известно, у каждой объектной переменной в Java имеется свой тип. Тип
              объектной переменной определяет разновидность объекта, на который ссылается
              эта переменная, а также ее функциональные возможности. Например, переменная
              staff [ 1 ] ссылается на объект типа Employee, поэтому она может ссылаться и на объект типа Manager.

            </p>
            <p>
              В процессе своей работы компилятор проверяет, не обещаете ли вы слишком
              много, сохраняя значение в переменной. Так, если вы присваиваете переменной суперкласса ссылку на объект
              подкласса, то обещаете меньше положенного, и компилятор просто разрешает вам сделать это. А если вы
              присваиваете объект суперкласса
              переменной подкласса, то обещаете больше положенного, и поэтому должны подтвердить свои обещания, указав
              в скобках имя класса для приведения типов. Таким
              образом, виртуальная машина получает возможность контролировать ваши действия
              при выполнении программы.
            </p>
            <p>
              А что произойдет, если попытаться осуществить приведение типов вниз по цепочке наследования и попробовать
              обмануть компилятор в отношении содержимого
              объекта, как в представленной ниже строке кода?
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Manager boss = (Manager) staff[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">1</span>]; <span class="hljs-comment"
                                                                                      style="color: rgb(113, 149, 168);">// ОШИБКА!</span>
</pre>
            <p>
              При выполнении программы система обнаружит несоответствие и сгенерирует
              исключение типа ClassCastException. Если его не перехватить, нормальное выполнение программы будет
              прервано. Таким образом, перед приведением типов
              следует непременно проверить его корректность. Для этой цели служит операция
              instanceof, как показано ниже.

            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(107, 107, 184);">if</span> (staff [<span class="hljs-number"
                                                                                                style="color: rgb(147, 92, 37);">1</span>] in s ta n c e o f Manager)
{
       boss = (Manager) staff[<span class="hljs-number" style="color: rgb(147, 92, 37);">1</span>];
}</pre>
            <p>
              И наконец, компилятор не позволит выполнить некорректное приведение типов,
              если для этого нет никаких оснований. Например, наличие приведенной ниже строки в исходном коде программы
              приведет к ошибке во время компиляции, поскольку
              класс String не является подклассом, производным от класса Employee.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(22, 27, 29); color: rgb(126, 162, 180); padding: 0.5em;">Date с = (String) staff[<span
                class="hljs-number" style="color: rgb(147, 92, 37);">1</span>];</pre>
            <p>
              Таким образом, можно сформулировать следующие основные правила приведения типов при наследовании.
            </p>
            <ul>
              <li>
                <p>
                  Приведение типов можно выполнять только в иерархии наследования.

                </p>
              </li>
              <li>
                <p>
                  Чтобы проверить корректность приведения суперкласса к подклассу, следует
                  выполнить операцию instanceof.
                </p>
              </li>
            </ul>
            <p>
              На самом деле приведение типов при наследовании — не самое лучшее решение.
              В данном примере выполнять преобразование объекта типа Employee в объект типа
              Manager совсем не обязательно. Метод getSalaryO вполне способен оперировать
              объектами обоих типов, поскольку при динамическом связывании правильный метод автоматически определяется
              благодаря принципу полиморфизма.
            </p>
            <p>
              Приведение типов целесообразно лишь в том случае, когда для объектов, представляющих руководителей,
              требуется вызвать особый метод, имеющийся только в классе
              Manager, например метод setBonus (). Если же по какой-нибудь причине потребуется
              вызвать метод setBonus () для объекта типа Employee, следует задать себе вопрос: не
              свидетельствует ли это о недостатках суперкласса? Возможно, имеет смысл пересмотреть структуру
              суперкласса и добавить в него метод setBonus (). Не забывайте, что
              для преждевременного завершения программы достаточно единственного неперехваченного исключения типа
              ClassCastException. А в целом при наследовании лучше
              свести к минимуму приведение типов и выполнение операции instanceof.

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
        Figura triange = new Triangle(2, 5);
        Figura square = new Square(4);

        if (triange instanceof Square){
            System.out.println("acceptable");
        } else {
            System.out.println("not acceptable");
        }
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
  name: "BringingTypes",
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
        {item: 'acceptable', name: 'acceptable'},
        {item: 'not acceptable', name: 'not acceptable'},
        {item: '\"\"', name: '\"\"'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/fourthchapter/', {
        params: {
          numberTheme: 5,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[3].listThemes[4].task.answer = response.data
              window.frontendData.language.chapters[3].chapterProgress += 6.6
              window.frontendData.language.chapters[3].listThemes[4].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[3].listThemes[4].task.answer

          window.frontendData.language.chapters[3].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[3].listThemes[4].task.tryCount++
          window.frontendData.language.chapters[3].listThemes[4].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[3].listThemes[4].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[3].listThemes[4].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[3].listThemes[4].task.answer
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
        Figura square = new Square(4);

        if (triange instanceof Square){
            System.out.println("acceptable");
        } else {
            System.out.println("not acceptable");
        }
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

    let themeToClose = document.getElementById('java-4-chapter-1-theme-5-subtheme');

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