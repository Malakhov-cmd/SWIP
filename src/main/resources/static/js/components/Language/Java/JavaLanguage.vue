<template>
  <b-row class="language-main-row">
    <div class="language-main-row-content">
      <div class="chapter-left-side">
        <IntroduceInJava/>
        <LanguageConstructions/>
        <ThemeButton theme-name="Наследование"/>
        <ThemeButton theme-name="Интерфейсы, лямбда-выражения и внутренние классы"/>
        <ThemeButton theme-name="Исключения, утверждение и протоколирование"/>
        <ThemeButton theme-name="Обобщенное программирование"/>
        <ThemeButton theme-name="Коллекции"/>
      </div>
      <div>


      <b-btn
          class="btn-language-name my-b-btn"
          @click="hidden = !hidden"

      >
        Java
      </b-btn>
      <svg viewBox="0 0 224 224" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
        <path style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); stroke-linecap: round; opacity: 1;" fill="#e9ca32" stroke="#e9ca32" d="M4997,2997Q5032,2858,5172,2858" stroke-width="2" stroke-linecap="round" opacity="1" class="tk_line root"></path>
      </svg>
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

export default {
  components: {LanguageConstructions, IntroduceInJava, ThemeButton},
  data() {
    return {
      dialog: false,
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
  }
}
</script>

<style scoped>

</style>