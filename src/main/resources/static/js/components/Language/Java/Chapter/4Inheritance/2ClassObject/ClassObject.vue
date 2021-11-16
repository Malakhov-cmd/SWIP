<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Переменные типа Object"
                    path-theme="/language/java/inheritance/TempObjectType" id="java-4-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Метод equals()"
                    path-theme="/language/java/inheritance/MethodsEqual" id="java-4-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="Проверка объектов на равенство и наследование"
                    path-theme="/language/java/inheritance/ExaminationObjectOnEqualAndInheritance" id="java-4-chapter-2-theme-3-subtheme"/>
      <theme-button theme-name="Метод hashCode() "
                    path-theme="/language/java/inheritance/MethodHashCode" id="java-4-chapter-2-theme-4-subtheme"/>
      <theme-button theme-name="Метод toString()"
                    path-theme="/language/java/inheritance/MethodTostring" id="java-4-chapter-2-theme-5-subtheme"/>
     </div>
    <chapter-button chapter-name="Глобальный суперкласс Object" class="theme-level-4-chapter-left" id="java-4-chapter-2-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ClassObject",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter4Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-2-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme2SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-2-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme2SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-2-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme2SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme2SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme2SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme2SubTheme5.node);
  }
}
</script>

<style scoped>

</style>