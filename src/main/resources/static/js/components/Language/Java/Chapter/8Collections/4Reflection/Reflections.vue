<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Основные операции над отображениями"
                    path-theme="/language/java/collections/OperationOnReflection"
                    id="java-8-chapter-4-theme-1-subtheme"/>
      <theme-button theme-name="Обновление записей в отображении"
                    path-theme="/language/java/collections/UpdateRowInReflection"
                    id="java-8-chapter-4-theme-2-subtheme"/>
      <theme-button theme-name="Представления отображений"
                    path-theme="/language/java/collections/PerfomanceReflection"
                    id="java-8-chapter-4-theme-3-subtheme"/>
      <theme-button theme-name="Слабые хеш-отображения "
                    path-theme="/language/java/collections/WeakReflection"
                    id="java-8-chapter-4-theme-4-subtheme"/>
      <theme-button theme-name="Связные хеш-множества и отображения"
                    path-theme="/language/java/collections/LinkHashmapAndReflection"
                    id="java-8-chapter-4-theme-5-subtheme"/>
      <theme-button theme-name="Перечислимые множества и отображения"
                    path-theme="/language/java/collections/EnumCollectionsAndReflection"
                    id="java-8-chapter-4-theme-6-subtheme"/>
    </div>
    <chapter-button chapter-name="Отображения" class="theme-level-8-chapter-left"
                    id="java-8-chapter-4-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Reflections",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter8Theme4SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-4-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme4SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-4-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme4SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-4-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme4SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-4-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme4SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-4-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme4SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-4-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme6.node);

  }
}
</script>

<style scoped>

</style>