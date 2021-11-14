<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Статические поля"
                    path-theme="/language/java/oop/staticField/StaticField" id="java-3-chapter-4-theme-1-subtheme"/>
      <theme-button theme-name="Статические константы"
                    path-theme="/language/java/oop/staticField/StaticConst" id="java-3-chapter-4-theme-2-subtheme"/>
      <theme-button theme-name="Статические методы"
                    path-theme="/language/java/oop/staticField/StaticMethods" id="java-3-chapter-4-theme-3-subtheme"/>
      <theme-button theme-name="Фабричные методы"
                    path-theme="/language/java/oop/staticField/FabricMethods" id="java-3-chapter-4-theme-4-subtheme"/>
      <theme-button theme-name="Метод main()"
                    path-theme="/language/java/oop/staticField/MethodMain" id="java-3-chapter-4-theme-5-subtheme"/>
    </div>
    <chapter-button chapter-name="Статические элементы" class="theme-level-3-chapter-left" id="java-3-chapter-4-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";
export default {
  name: "StaticFieldAndMethod",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme4SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-4-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-4-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme4SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-4-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-4-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme4SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-4-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-4-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme4SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-4-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme4SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-4-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme4SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme4SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme4SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme4SubTheme5.node);
  }
}
</script>

<style scoped>

</style>