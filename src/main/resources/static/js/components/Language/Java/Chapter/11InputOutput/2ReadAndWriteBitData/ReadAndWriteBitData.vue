<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Чтение и запись двоичных данных" class="theme-level-11-chapter-right"
                    id="java-11-chapter-2-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Интерфейсы DataInput и DataOutput"
                    path-theme="/language/java/inputoutput/InterfaceDataInputDataOutput"
                    id="java-11-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Файлы с произвольным доступом"
                    path-theme="/language/java/inputoutput/FilesRandomAccess"
                    id="java-11-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="ZIP-архивы"
                    path-theme="/language/java/inputoutput/ZIPFiles"
                    id="java-11-chapter-2-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ReadAndWriteBitData",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter11Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme2SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme2SubTheme3.node);

  }
}
</script>

<style scoped>

</style>