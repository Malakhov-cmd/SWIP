<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Асинхронные вычисления" class="theme-level-9-chapter-right"
                    id="java-9-chapter-7-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Завершаемые Future действия"
                    path-theme="/language/java/threads/EndingFutureActions"
                    id="java-9-chapter-7-theme-1-subtheme"/>
      <theme-button theme-name="Составление завершаемых Future действий"
                    path-theme="/language/java/threads/MakingFutureEndingActions"
                    id="java-9-chapter-7-theme-2-subtheme"/>
      <theme-button theme-name="Длительные задачи в обратных вызовах из GUI"
                    path-theme="/language/java/threads/LongTaskInBackcallGUI"
                    id="java-9-chapter-7-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "AsinchronizedCalk",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter9Theme7SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-7-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme7SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-7-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter9Theme7SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-9-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-9-chapter-7-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme7SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme7SubTheme3.node);
  }
}
</script>

<style scoped>

</style>