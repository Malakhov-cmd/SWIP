<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Свойства потоков" class="theme-level-9-chapter-right"
                    id="java-9-chapter-3-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Потоковые демоны"
                    path-theme="/language/java/threads/DemonThreads"
                    id="java-9-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Обработчики необрабатываемых исключений"
                    path-theme="/language/java/threads/HandlerUnproccessException"
                    id="java-9-chapter-3-theme-2-subtheme"/>
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

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme3SubTheme2.node);

    let countProgressLocalTheme = 0

    for (let i = 4; i < 6; i++) {
      if (window.frontendData.language.chapters[8].listThemes[i].finished) {
        let k = i - 3
        document.getElementById("java-9-chapter-3-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 8.3;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 24) {
      document.getElementById("java-9-chapter-3-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 24)
        document.getElementById("java-9-chapter-3-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>