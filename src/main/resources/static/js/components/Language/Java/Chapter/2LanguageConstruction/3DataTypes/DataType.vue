<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <ThemeButton class="themes-lvl-2" theme-name="Целочисленные типы данных"
                   path-theme="/language/java/languageconstruction/datatype/int" id="java-2-chapter-3-them-1-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Числовые типы данных с плавающей точкой"
                   path-theme="/language/java/languageconstruction/datatype/float"
                   id="java-2-chapter-3-them-2-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Тип данных char"
                   path-theme="/language/java/languageconstruction/datatype/char"
                   id="java-2-chapter-3-them-3-subtheme"/>
      <ThemeButton class="themes-lvl-2" theme-name="Тип данных boolean"
                   path-theme="/language/java/languageconstruction/datatype/boolean"
                   id="java-2-chapter-3-them-4-subtheme"/>
    </div>
    <ChapterButton chapter-name="Типы данных" class="theme-level-2-chapter-left" id="java-2-chapter-3-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "DataType",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter2Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-3-them-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme3SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-3-them-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme3SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-3-them-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter2Theme3SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-2-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-3-them-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme3SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme3SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter2Theme3SubTheme4.node);
  }

}
</script>

<style scoped>

</style>