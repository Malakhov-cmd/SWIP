<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Создание jar-файлов"
                    path-theme="/language/java/oop/archiveJARFiles/CreatingJARFiles" id="java-3-chapter-8-theme-1-subtheme"/>
      <theme-button theme-name="Файл манифеста"
                    path-theme="/language/java/oop/archiveJARFiles/ManifestFile" id="java-3-chapter-8-theme-2-subtheme"/>
      <theme-button theme-name="Исполняемые jar-файлы"
                    path-theme="/language/java/oop/archiveJARFiles/ExetableJAR" id="java-3-chapter-8-theme-3-subtheme"/>
      <theme-button theme-name="Многовекторные архивные jar-файлы"
                    path-theme="/language/java/oop/archiveJARFiles/ManyVertionArchiveFiles" id="java-3-chapter-8-theme-4-subtheme"/>
       </div>
    <chapter-button chapter-name="Архивные JAR-файлы" class="theme-level-3-chapter-left" id="java-3-chapter-8-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";
export default {
  name: "ArchiveJARFiles",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme8SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-8-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-8-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme8SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-8-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-8-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme8SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-8-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-8-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme8SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-8-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-8-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme8SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme8SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme8SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme8SubTheme4.node);
  }
}
</script>

<style scoped>

</style>