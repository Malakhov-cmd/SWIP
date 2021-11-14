<template>
  <b-row class="language-main-row" id="language-main-row-content">
    <div class="language-main-row-content" v-on:scroll="funk()">
      <div class="chapter-left-side">
        <IntroduceInJava/>
        <LanguageConstructions/>
        <o-o-p/>
        <ThemeButton theme-name="Наследование"/>
        <ThemeButton theme-name="Интерфейсы, лямбда-выражения и внутренние классы"/>
        <ThemeButton theme-name="Исключения, утверждение и протоколирование"/>
        <ThemeButton theme-name="Обобщенное программирование"/>
        <ThemeButton theme-name="Коллекции"/>
      </div>
      <div>
        <b-btn
            id="center-btn-language-name"
            class="btn-language-name my-b-btn"
            @click="hidden = !hidden"
        >
          Java
        </b-btn>
        </div>
      <div class="chapter-right-side">
        <LanguageConstructions/>
        <ThemeButton theme-name="JavaFX"/>
        <ThemeButton theme-name="Потоки ввода вывода"/>
        <ThemeButton theme-name="XML"/>
        <ThemeButton theme-name="Работа в сети"/>
        <ThemeButton theme-name="Интернационализация"/>
        <ThemeButton theme-name="Компоненты JavaBeans"/>
        <ThemeButton theme-name="Безопасность"/>
      </div>
    </div>
  </b-row>
</template>

<script>
import ThemeButton from "../Blocks/ChapterButton.vue";
import IntroduceInJava from "./Chapter/1Introduce/IntroduceInJava.vue";
import LanguageConstructions from "./Chapter/2LanguageConstruction/LanguageConstructions.vue";
import arrowCreate, { HEAD } from "arrows-svg";
import OOP from "./Chapter/3OOP/OOP.vue";

export default {
  components: {OOP, LanguageConstructions, IntroduceInJava, ThemeButton},
  data() {
    return {
      dialog: false,
      showLogos: true
    }

  },
  methods: {
    funk() {
      var mainContainer = document.getElementsByClassName("language-main-row-content").item(0)
      var mainrowContainer = document.getElementsByClassName("language-main-row").item(0)
      if (mainContainer.scrollTop > 125) {
        this.$emit('scrolldown', false)
        mainContainer.style = 'max-height: 80vh;'
        mainrowContainer.style = 'max-height: 80vh;'
      } else {
        this.$emit('scrolldown', true)
        mainContainer.style = 'max-height: 70vh;'
        mainrowContainer.style = 'max-height: 70vh;'
      }
    }
  },
  mounted() {
    var scr = $(".language-main-row-content");
    scr.mousedown(function () {
      var startX = this.scrollLeft + event.pageX;
      var startY = this.scrollTop + event.pageY;
      scr.mousemove(function () {
        this.scrollLeft = startX - event.pageX;
        this.scrollTop = startY - event.pageY;
        return false;
      });
    });
    $(window).mouseup(function () {
      scr.off("mousemove");
    });


    /*const arrow1 = arrowCreate({
       from: document.getElementById("center-btn-language-name"),
       to: document.getElementById("chapter1"),
     });

     document.getElementById("language-main-row-content").appendChild(arrow1.node);*/

    const arrowFromCentralBtnToHeadOFFirstChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: document.getElementById("central-btn-1chapter"),
      head: {
        func: HEAD.VEE,
      }
    });

    const arrowFromCentralBtnToHeadOFSecondChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: document.getElementById("central-btn-2chapter"),
      head: {
        func: HEAD.VEE,
      }
    });

    const arrowFromCentralBtnToHeadOFThirdChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: document.getElementById("central-btn-3chapter"),
      head: {
        func: HEAD.VEE,
      }
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFFirstChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFSecondChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFThirdChapter.node);

  },
  beforeDestroy() {
    let massiveArrows = document.getElementsByClassName("arrow")
    for (let i = 0; i < massiveArrows.length; i++) {
      document.getElementById("language-main-row-content").removeChild(massiveArrows.item(i))
    }

  }
}
</script>

<style scoped>

</style>