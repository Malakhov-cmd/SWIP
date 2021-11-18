<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Свойства потоков" class="theme-level-9-chapter-right"
                    id="java-9-chapter-3-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Прерывание потоков"
                    path-theme="/language/java/threads/InterruptedThreads"
                    id="java-9-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Потоковые демоны"
                    path-theme="/language/java/threads/DemonThreads"
                    id="java-9-chapter-3-theme-2-subtheme"/>
      <theme-button theme-name="Именование потоков"
                    path-theme="/language/java/threads/NamingThreads"
                    id="java-9-chapter-3-theme-3-subtheme"/>
      <theme-button theme-name="Обработчики необрабатываемых исключений"
                    path-theme="/language/java/threads/HandlerUnproccessException"
                    id="java-9-chapter-3-theme-4-subtheme"/>
      <theme-button theme-name="Приоритеты потоков"
                    path-theme="/language/java/threads/PriorityThreads"
                    id="java-9-chapter-3-theme-5-subtheme"/>
    </div>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "PropertiesThread",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter9Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme3SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-3-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme3SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-3-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme3SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-3-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme3SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-3-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme3SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme3SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme3SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme3SubTheme5.node);
  }
}
</script>

<style scoped>

</style>