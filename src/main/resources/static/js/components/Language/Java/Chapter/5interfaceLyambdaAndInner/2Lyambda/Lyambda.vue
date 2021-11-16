<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Причины для употребления лямбда-выражений"
                    path-theme="/language/java/interfacesLyambdaAndInner/ReasonsForUseLyambda" id="java-5-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Синтаксис лямбда-выражений"
                    path-theme="/language/java/interfacesLyambdaAndInner/SyntaxLyambda" id="java-5-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="Функциональные интерфейсы"
                    path-theme="/language/java/interfacesLyambdaAndInner/FunctionalInterfaces" id="java-5-chapter-2-theme-3-subtheme"/>
      <theme-button theme-name="Ссылки на методы"
                    path-theme="/language/java/interfacesLyambdaAndInner/LinkToTheMethods" id="java-5-chapter-2-theme-4-subtheme"/>
      <theme-button theme-name="Ссылки на конструкторы"
                    path-theme="/language/java/interfacesLyambdaAndInner/LinkToTheConstructors" id="java-5-chapter-2-theme-5-subtheme"/>
      <theme-button theme-name="Область видимости переменных"
                    path-theme="/language/java/interfacesLyambdaAndInner/AreaOfVizabylityTemps" id="java-5-chapter-2-theme-6-subtheme"/>
      <theme-button theme-name="Обработка лямбда-выражений"
                    path-theme="/language/java/interfacesLyambdaAndInner/ProcessingLyambda" id="java-5-chapter-2-theme-7-subtheme"/>
       </div>
    <chapter-button chapter-name="Лямбда-выражения" class="theme-level-5-chapter-left" id="java-5-chapter-2-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Lyambda",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter5Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme2SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme2SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme2SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme2SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme7.node);
  }
}
</script>

<style scoped>

</style>