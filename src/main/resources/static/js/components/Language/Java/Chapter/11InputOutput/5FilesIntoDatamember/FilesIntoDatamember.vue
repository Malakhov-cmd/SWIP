<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Файлы, отображаемые в памяти" class="theme-level-11-chapter-right"
                    id="java-11-chapter-5-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Эффективность файлов, отображаемых в памяти"
                    path-theme="/language/java/inputoutput/EffictiveFilesIntoMemory"
                    id="java-11-chapter-5-theme-1-subtheme"/>
      <theme-button theme-name="Структура буфера данных"
                    path-theme="/language/java/inputoutput/DataBufferStructure"
                    id="java-11-chapter-5-theme-2-subtheme"/>
      <theme-button theme-name="Блокирование файлов"
                    path-theme="/language/java/inputoutput/BlockingFiles"
                    id="java-11-chapter-5-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "FilesIntoDatamember",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter11Theme5SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-5-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme5SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-5-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme5SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-5-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme5SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme5SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme5SubTheme3.node);
  }
}
</script>

<style scoped>

</style>