<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Назначение обобщенных алгоритмов "
                    path-theme="/language/java/collections/PerfomanceGenricAlgorithms"
                    id="java-8-chapter-5-theme-1-subtheme"/>
      <theme-button theme-name="Сортировка и перетасовка"
                    path-theme="/language/java/collections/SortingAndReplacement"
                    id="java-8-chapter-5-theme-2-subtheme"/>
      <theme-button theme-name="Двоичный поиск"
                    path-theme="/language/java/collections/BinarySearch"
                    id="java-8-chapter-5-theme-3-subtheme"/>
      <theme-button theme-name="Простые алгоритмы"
                    path-theme="/language/java/collections/SimpleAlgorithm"
                    id="java-8-chapter-5-theme-4-subtheme"/>
      <theme-button theme-name="Групповые операции"
                    path-theme="/language/java/collections/GroupOperations"
                    id="java-8-chapter-5-theme-5-subtheme"/>
      <theme-button theme-name="Взаимное преобразование коллекций и массивов"
                    path-theme="/language/java/collections/RelativePerfomanceCollectionsAndArrays"
                    id="java-8-chapter-5-theme-6-subtheme"/>
      <theme-button theme-name="Написание собственных алгоритмов"
                    path-theme="/language/java/collections/WriteOwnAlgorithm"
                    id="java-8-chapter-5-theme-7-subtheme"/>
    </div>
    <chapter-button chapter-name="Алгоритмы" class="theme-level-8-chapter-left"
                    id="java-8-chapter-5-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Algorithms",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter8Theme5SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-5-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme5SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-5-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme5SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-5-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme5SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-5-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-5-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme5SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-5-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme5SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-5-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme5SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-5-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme5SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme5SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme5SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme5SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme5SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme5SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme5SubTheme7.node);

  }
}
</script>

<style scoped>

</style>