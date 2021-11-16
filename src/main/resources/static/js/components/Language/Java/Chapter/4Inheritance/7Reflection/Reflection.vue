<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Класс Class"
                    path-theme="/language/java/inheritance/ClassClass" id="java-4-chapter-7-theme-1-subtheme"/>
      <theme-button theme-name="Основы обработки исключений"
                    path-theme="/language/java/inheritance/BasementProccessException" id="java-4-chapter-7-theme-2-subtheme"/>
      <theme-button theme-name="Ресурсы"
                    path-theme="/language/java/inheritance/Resource" id="java-4-chapter-7-theme-3-subtheme"/>
      <theme-button theme-name="Анализ функциональных возможностей классов с помощью рефлексии"
                    path-theme="/language/java/inheritance/AnalyzeFunctionalOprrtunityOfReflection" id="java-4-chapter-7-theme-4-subtheme"/>
      <theme-button theme-name="Анализ объектов во время выполнения с помощью рефлексии"
                    path-theme="/language/java/inheritance/AnalyzeObjectOnProcessingByReflection" id="java-4-chapter-7-theme-5-subtheme"/>
      <theme-button theme-name="Вызов произвольных методов и конструкторов"
                    path-theme="/language/java/inheritance/CallingMethodsAndConstructors" id="java-4-chapter-7-theme-6-subtheme"/>

    </div>
    <chapter-button chapter-name="Рефлексия" class="theme-level-4-chapter-left" id="java-4-chapter-7-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Reflection",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter4Theme7SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-7-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-7-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme7SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-7-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-7-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme7SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-7-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-7-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme7SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-7-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-7-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme7SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-7-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-7-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme7SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-7-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-7-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme7SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme7SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme7SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme7SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme7SubTheme6.node);
  }
}
</script>

<style scoped>

</style>