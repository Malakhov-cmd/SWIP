<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Cостояния потоков" class="theme-level-9-chapter-right"
                    id="java-9-chapter-2-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Новые потоки"
                    path-theme="/language/java/threads/NewThreads"
                    id="java-9-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Исполняемые потоки"
                    path-theme="/language/java/threads/Thread"
                    id="java-9-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="Блокированные и ожидающие потоки"
                    path-theme="/language/java/threads/BlockingAndWaitingThreads"
                    id="java-9-chapter-2-theme-3-subtheme"/>
      <theme-button theme-name="Завершенные потоки"
                    path-theme="/language/java/threads/EndedThreads"
                    id="java-9-chapter-2-theme-4-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ConditionThreads",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter9Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme2SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-2-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme2SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme2SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme2SubTheme4.node);

  }
}
</script>

<style scoped>

</style>