<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Классы"
                    path-theme="/language/java/oop/intro/classes" id="java-3-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Объекты"
                    path-theme="/language/java/oop/intro/objects" id="java-3-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Идентификация классов"
                    path-theme="/language/java/oop/intro/identificationClasses" id="java-3-chapter-1-theme-3-subtheme"/>
      <theme-button theme-name="Отношения между классами"
                    path-theme="/language/java/oop/intro/relationclasses" id="java-3-chapter-1-theme-4-subtheme"/>
    </div>
    <chapter-button chapter-name="Введение в ООП" class="theme-level-3-chapter-left" id="java-3-chapter-1-theme"/>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
export default {
  name: "IntroOOP",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter3Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme1SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-1-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme1SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-1-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme1SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-1-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme1SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme1SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme1SubTheme4.node);

  }
}
</script>

<style scoped>

</style>