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
          Класс Employee
        </div>
      </template>

      <div class="page-theme-theory">
        <b-button v-b-toggle.collapse-3 class="m-1 page-theme-collapse-btn">Ознакомиться с теорией</b-button>
        <b-collapse visible id="collapse-3">
          <div class="page-theme-theory-text">
            <p>Простейшая форма определения класса в Java выглядит следующим образом
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">class</span> ИмяКласса
</span>{
поле_1
поле_2
конструктор_1
конструктор_2
метод_1
метод_2
}</pre>
            <p>Рассмотрим следующую, весьма упрощенную версию класса Employee, который
              можно использовать для составления платежной ведомости:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-class"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">class</span> <span
                class="hljs-title" style="color: rgb(71, 140, 144);">Employee</span>
</span>{
<span class="hljs-comment" style="color: rgb(120, 135, 125);">// поля экземпляра </span>
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> String name;
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(85, 133, 155);">double</span> salary;
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> Date hireDay;
<span class="hljs-comment" style="color: rgb(120, 135, 125);">// конструктор</span>
<span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
    class="hljs-title" style="color: rgb(71, 140, 144);">Employee</span><span class="hljs-params"
                                                                              style="color: rgb(159, 113, 60);">(String n, <span
    class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> s, <span class="hljs-keyword"
                                                                                  style="color: rgb(85, 133, 155);">int</span> year, <span
    class="hljs-keyword" style="color: rgb(85, 133, 155);">int</span> month, <span class="hljs-keyword"
                                                                                   style="color: rgb(85, 133, 155);">int</span> day)</span>
</span>{
name = n;
salary = s;
hireDay = LocalDate.of(year, month, day);
<span class="hljs-comment" style="color: rgb(120, 135, 125);">// метод</span>
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> String getNameO
{
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">return</span> name;
}
<span class="hljs-comment" style="color: rgb(120, 135, 125);">// другие методы</span>
}
</pre>
            <p>Более подробно реализация этого класса будет проанализирована в последующих
              разделах, а сейчас рассмотрим код, приведенный в листинге 4.2 и демонстрирующий
              практическое применение класса Employee.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">import</span> java.time.*;

<span class="hljs-comment" style="color: rgb(120, 135, 125);">/**
 * This program tests the Employee class.
 * <span class="hljs-doctag">@version</span> 1.12 2015-05-08
 * <span class="hljs-doctag">@author</span> Cay Horstmann
 */</span>
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span class="hljs-class"><span
                  class="hljs-keyword" style="color: rgb(85, 133, 155);">class</span> <span class="hljs-title"
                                                                                            style="color: rgb(71, 140, 144);">EmployeeTest</span>
</span>{
   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
       class="hljs-keyword" style="color: rgb(85, 133, 155);">static</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(85, 133, 155);">void</span> <span
       class="hljs-title" style="color: rgb(71, 140, 144);">main</span><span class="hljs-params"
                                                                             style="color: rgb(159, 113, 60);">(String[] args)</span>
   </span>{
      <span class="hljs-comment"
            style="color: rgb(120, 135, 125);">// fill the staff array with three Employee objects</span>
      Employee[] staff = <span class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Employee[<span
                  class="hljs-number" style="color: rgb(159, 113, 60);">3</span>];

      staff[<span class="hljs-number" style="color: rgb(159, 113, 60);">0</span>] = <span class="hljs-keyword"
                                                                                          style="color: rgb(85, 133, 155);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(72, 153, 99);">"Carl Cracker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(159, 113, 60);">75000</span>, <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">1987</span>, <span class="hljs-number"
                                                                                           style="color: rgb(159, 113, 60);">12</span>, <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">15</span>);
      staff[<span class="hljs-number" style="color: rgb(159, 113, 60);">1</span>] = <span class="hljs-keyword"
                                                                                          style="color: rgb(85, 133, 155);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(72, 153, 99);">"Harry Hacker"</span>, <span class="hljs-number"
                                                                                                    style="color: rgb(159, 113, 60);">50000</span>, <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">1989</span>, <span class="hljs-number"
                                                                                           style="color: rgb(159, 113, 60);">10</span>, <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">1</span>);
      staff[<span class="hljs-number" style="color: rgb(159, 113, 60);">2</span>] = <span class="hljs-keyword"
                                                                                          style="color: rgb(85, 133, 155);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(72, 153, 99);">"Tony Tester"</span>, <span class="hljs-number"
                                                                                                   style="color: rgb(159, 113, 60);">40000</span>, <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">1990</span>, <span class="hljs-number"
                                                                                           style="color: rgb(159, 113, 60);">3</span>, <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">15</span>);

      <span class="hljs-comment" style="color: rgb(120, 135, 125);">// raise everyone's salary by 5%</span>
      <span class="hljs-keyword" style="color: rgb(85, 133, 155);">for</span> (Employee e : staff)
         e.raiseSalary(<span class="hljs-number" style="color: rgb(159, 113, 60);">5</span>);

      <span class="hljs-comment"
            style="color: rgb(120, 135, 125);">// print out information about all Employee objects</span>
      <span class="hljs-keyword" style="color: rgb(85, 133, 155);">for</span> (Employee e : staff)
         System.out.println(<span class="hljs-string"
                                  style="color: rgb(72, 153, 99);">"name="</span> + e.getName() + <span
                  class="hljs-string" style="color: rgb(72, 153, 99);">",salary="</span> + e.getSalary() + <span
                  class="hljs-string" style="color: rgb(72, 153, 99);">",hireDay="</span>
               + e.getHireDay());
   }
}

<span class="hljs-class"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">class</span> <span
    class="hljs-title" style="color: rgb(71, 140, 144);">Employee</span>
</span>{
   <span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> String name;
   <span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> <span class="hljs-keyword"
                                                                                     style="color: rgb(85, 133, 155);">double</span> salary;
   <span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> LocalDate hireDay;

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
       class="hljs-title" style="color: rgb(71, 140, 144);">Employee</span><span class="hljs-params"
                                                                                 style="color: rgb(159, 113, 60);">(String n, <span
       class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> s, <span class="hljs-keyword"
                                                                                     style="color: rgb(85, 133, 155);">int</span> year, <span
       class="hljs-keyword" style="color: rgb(85, 133, 155);">int</span> month, <span class="hljs-keyword"
                                                                                      style="color: rgb(85, 133, 155);">int</span> day)</span>
   </span>{
      name = n;
      salary = s;
      hireDay = LocalDate.of(year, month, day);
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> String <span
       class="hljs-title" style="color: rgb(71, 140, 144);">getName</span><span class="hljs-params"
                                                                                style="color: rgb(159, 113, 60);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(85, 133, 155);">return</span> name;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
       class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> <span class="hljs-title"
                                                                                  style="color: rgb(71, 140, 144);">getSalary</span><span
       class="hljs-params" style="color: rgb(159, 113, 60);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(85, 133, 155);">return</span> salary;
   }

   <span class="hljs-function"><span class="hljs-keyword"
                                     style="color: rgb(85, 133, 155);">public</span> LocalDate <span class="hljs-title"
                                                                                                     style="color: rgb(71, 140, 144);">getHireDay</span><span
       class="hljs-params" style="color: rgb(159, 113, 60);">()</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(85, 133, 155);">return</span> hireDay;
   }

   <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
       class="hljs-keyword" style="color: rgb(85, 133, 155);">void</span> <span class="hljs-title"
                                                                                style="color: rgb(71, 140, 144);">raiseSalary</span><span
       class="hljs-params" style="color: rgb(159, 113, 60);">(<span class="hljs-keyword"
                                                                    style="color: rgb(85, 133, 155);">double</span> byPercent)</span>
   </span>{
      <span class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> raise = salary * byPercent / <span
                  class="hljs-number" style="color: rgb(159, 113, 60);">100</span>;
      salary += raise;
   }
}</pre>
            <p> В данной программе сначала создается массив типа Employee, в который заносятся три объекта работников:
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">Employee[] staff = <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">new</span> Employee[<span class="hljs-number"
                                                                                                 style="color: rgb(159, 113, 60);">3</span>];
staff[<span class="hljs-number" style="color: rgb(159, 113, 60);">0</span>] = <span class="hljs-keyword"
                                                                                    style="color: rgb(85, 133, 155);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(72, 153, 99);">"Carl Cracker"</span>, . . .);
staff[<span class="hljs-number" style="color: rgb(159, 113, 60);">1</span>] = <span class="hljs-keyword"
                                                                                    style="color: rgb(85, 133, 155);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(72, 153, 99);">"Harry Hacker"</span>, . . .);
staff[<span class="hljs-number" style="color: rgb(159, 113, 60);">2</span>] = <span class="hljs-keyword"
                                                                                    style="color: rgb(85, 133, 155);">new</span> Employee(<span
                  class="hljs-string" style="color: rgb(72, 153, 99);">"Tony Tester"</span>, . . .);
</pre>
            <p>
              Затем вызывается метод raiseSalary () из класса Employee, чтобы поднять зарплату каждого работника на 5%,
              как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">for</span> (Employee е : staff)
е.raiseSalary(<span class="hljs-number" style="color: rgb(159, 113, 60);">5</span>);
</pre>
            <p>И наконец, с помощью методов getNameO, getSalaryO и getHireDayO выводятся данные о каждом рабо
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">for</span> (Employee е : staff)
System.out.println(<span class="hljs-string" style="color: rgb(72, 153, 99);">"name="</span> + e.getNameO
+ <span class="hljs-string" style="color: rgb(72, 153, 99);">",salary="</span> + e .getSalary()
+ <span class="hljs-string" style="color: rgb(72, 153, 99);">",hireDay="</span> + e .getHireDay());</pre>

            <p>Следует заметить, что данный пример программы состоит из двух классов:
              Employee и EmployeeTest, причем последний объявлен открытым с модификатором
              доступа public. Метод main () с описанными выше операторами содержится в классе
              EmployeeTest. Исходный код данной программы содержится в файле EmployeeTest.
              j ava, поскольку его имя должно совпадать с именем открытого класса. В исходном
              файле может быть только один класс, объявленный как public, а также любое количество классов, в
              объявлении которых данное ключевое слово отсутствует.
            </p>

            <p>При компиляции исходного кода данной программы создаются два файла классов: EmployeeTest. class и
              Employee. class. Затем начинается выполнение программы, для чего интерпретатору байт-кода указывается имя
              класса, содержащего основной метод main () данной программы:</p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;">java EmployeeTest</pre>
            <p>
              Интерпретатор начинает обрабатывать метод main() из класса EmployeeTest.
              В результате выполнения кода создаются три новых объекта типа Employee и отображается их состояние.
            </p>
            <p>
              Рассмотренная выше программа из листинга 4.2 состоит из двух классов в одном
              исходном файле. Многие программирующие на Java предпочитают размещать каждый класс в отдельном файле.
              Например, класс Employee можно разместить в файле
              Employee, java, а класс EmployeeTest — в файле EmployeeTest. java.
            </p>
            <p>
              Проанализируем класс Employee, начав с его методов. Изучая исходный код, нетрудно заметить, что в классе
              Employee реализованы один конструктор и четыре метода, перечисляемые ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-function"><span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span
                class="hljs-title" style="color: rgb(71, 140, 144);">Employee</span><span class="hljs-params"
                                                                                          style="color: rgb(159, 113, 60);">(String n, <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> s,<span class="hljs-keyword"
                                                                                             style="color: rgb(85, 133, 155);">int</span> year, <span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">int</span> month, <span class="hljs-keyword"
                                                                                               style="color: rgb(85, 133, 155);">int</span> day)</span>
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> String getNameO
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span class="hljs-keyword"
                                                                                 style="color: rgb(85, 133, 155);">double</span> getSalaryO
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> Date getHireDayO
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">public</span> <span class="hljs-keyword"
                                                                                 style="color: rgb(85, 133, 155);">void</span> <span
                  class="hljs-title" style="color: rgb(71, 140, 144);">raiseSalary</span><span class="hljs-params"
                                                                                               style="color: rgb(159, 113, 60);">(<span
                  class="hljs-keyword" style="color: rgb(85, 133, 155);">double</span> byPercent)</span></span></pre>
            <p>
              Все методы этого класса объявлены как public, т.е. обращение к этим методам
              может осуществляться из любого класса. (Существуют четыре возможных уровня доступа. Все они
              рассматриваются в этой и следующей главах.)
            </p>
            <p>
              Далее следует заметить, что в классе имеются три поля экземпляра для хранения
              данных, обрабатываемых в объекте типа Employee, как показано ниже.
            </p>
            <pre class="hljs"
                 style="display: block; overflow-x: auto; background: rgb(23, 28, 25); color: rgb(135, 146, 138); padding: 0.5em;"><span
                class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> String name;
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> <span class="hljs-keyword"
                                                                                  style="color: rgb(85, 133, 155);">double</span> salary;
<span class="hljs-keyword" style="color: rgb(85, 133, 155);">private</span> Date hireDay;
</pre>
            <p>Ключевое слово private означает, что к данным полям имеют доступ только методы самого класса Employee.
              Ни
              один внешний метод не может читать или записывать данные в эти поля.
            </p>

            <p>
              И наконец, следует обратить внимание на то, что два из трех полей экземпляра
              сами являются объектами. В частности, поля name и hireDay являются ссылками
              на экземпляры классов String и Date. В ООП это довольно распространенное явление: одни классы часто
              содержат поля с экземплярами других классов.

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
class Main
{
    static class Horses{
        private long id;
        private String name;
        private Double speedPerKilometers;

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSpeedPerKilometers() {
            return speedPerKilometers;
        }

        public void setSpeedPerKilometers(Double speedPerKilometers) {
            this.speedPerKilometers = speedPerKilometers;
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 45.0);
        System.out.println(horses.getName());
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
  name: "ClassEmployee",
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

      selected: 'Loe',
      options: [
        {item: 'Loe', name: 'Loe'},
        {item: '1', name: '1'},
        {item: '45', name: '45'}
      ]
    }
  },
  methods: {
    Request() {
      this.timeEndeded = Date.now()
      this.timeSpended = Math.round((this.timeEndeded - this.timeStarted) / 1000)

      axios.get('http://localhost:9000/java/thirdchapter/', {
        params: {
          numberTheme: 7,
          answer: this.selected,
          userId: window.frontendData.profile.id,
          timeSpend: this.timeSpended
        }
      })
          .then(function (response) {
            if (response.data !== 'Incorrect answer') {
              window.frontendData.language.chapters[2].listThemes[6].task.answer = response.data
              window.frontendData.language.chapters[2].chapterProgress += 4.34
              window.frontendData.language.chapters[2].listThemes[6].finished = true

              isSendedandrecived = true
            }
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {

          this.answer = window.frontendData.language.chapters[2].listThemes[6].task.answer

          window.frontendData.language.chapters[2].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.animationOn = isSendedandrecived
          this.showInput = false

          clearInterval(interval)
        } else {
          window.frontendData.language.chapters[2].listThemes[6].task.tryCount++
          window.frontendData.language.chapters[2].listThemes[6].task.timeOnSolutionInSeconds += this.timeSpended

          this.$toasted.error("Некоректные данные! Время на решение: " + this.timeSpended +
              " c. Номер попытки: " + window.frontendData.language.chapters[2].listThemes[6].task.tryCount + ".", {
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
    if (window.frontendData.language.chapters[2].listThemes[6].finished) {
      this.showInput = false
      this.answer = window.frontendData.language.chapters[2].listThemes[6].task.answer
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
        `class Main
{
    static class Horses{
        private long id;
        private String name;
        private Double speedPerKilometers;

        public Horses(long id, String name, Double speedPerKilometers) {
            this.id = id;
            this.name = name;
            this.speedPerKilometers = speedPerKilometers;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSpeedPerKilometers() {
            return speedPerKilometers;
        }

        public void setSpeedPerKilometers(Double speedPerKilometers) {
            this.speedPerKilometers = speedPerKilometers;
        }
    }

    public static void main(String[] args)
    {
        Horses horses = new Horses(1L, "Loe", 45.0);
        System.out.println(horses.getName());
    }
}  `)

    this.timeStarted = Date.now()

    setTimeout(() => {
      $('.CodeMirror').each(function (i, el) {
        el.CodeMirror.refresh();
      });
    }, 1000)
  },
  beforeDestroy() {
    let container = document.getElementsByClassName('language-main-row-content').item(0)

    let themeToClose = document.getElementById('java-3-chapter-3-theme-1-subtheme');

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