<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Процессы" class="theme-level-9-chapter-right"
                    id="java-9-chapter-8-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Построение процесса"
                    path-theme="language/java/threads/BuildingProccess"
                    id="java-9-chapter-8-theme-1-subtheme"/>
      <theme-button theme-name="Выполнение процесса"
                    path-theme="/language/java/threads/ExecutionProccess"
                    id="java-9-chapter-8-theme-2-subtheme"/>
      <theme-button theme-name="Дескрипторы процессов"
                    path-theme="/language/java/threads/DescriptorsProccess"
                    id="java-9-chapter-8-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Processes",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter9Theme8SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-8-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme8SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-8-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme8SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-8-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme8SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme8SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme8SubTheme3.node);
  }
}
</script>

<style scoped>

</style>