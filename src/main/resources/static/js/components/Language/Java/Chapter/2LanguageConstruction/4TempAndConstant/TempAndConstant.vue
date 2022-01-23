<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton class="themes-lvl-2" theme-name="Объявление переменных"
                   path-theme="/language/java/languageconstruction/themeandconstant/introductiontemp"
                   id="java-2-chapter-4-them-1-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Инициализация переменных"
                   path-theme="/language/java/languageconstruction/themeandconstant/initializetemp"
                   id="java-2-chapter-4-them-2-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Константы"
                   path-theme="/language/java/languageconstruction/themeandconstant/constants"
                   id="java-2-chapter-4-them-3-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Перечислимые типы"
                   path-theme="/language/java/languageconstruction/themeandconstant/enum"
                   id="java-2-chapter-4-them-4-subtheme"/>
    </div>
    <ChapterButton chapter-name="Переменные и константы" class="theme-level-2-chapter-left"
                   id="java-2-chapter-4-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "TempAndConstant",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter2Theme4SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-4-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-4-them-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme4SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-4-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-4-them-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme4SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-4-them-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme4SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-4-them-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme4SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme4SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme4SubTheme4.node);

    let countProgressLocalTheme = 0

    for (let i = 6; i < 10; i++) {
      if (window.frontendData.language.chapters[1].listThemes[i].finished) {
        let k = i - 5
        document.getElementById("java-2-chapter-4-them-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 2.7;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 10) {
      document.getElementById("java-2-chapter-4-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 10)
        document.getElementById("java-2-chapter-4-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>