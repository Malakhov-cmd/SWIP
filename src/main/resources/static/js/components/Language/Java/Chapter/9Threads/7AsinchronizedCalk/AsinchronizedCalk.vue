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

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter9Theme7SubTheme2.node);

    let countProgressLocalTheme = 0

    for (let i = 19; i < 21; i++) {
      if (window.frontendData.language.chapters[8].listThemes[i].finished) {
        let k = i - 18
        document.getElementById("java-9-chapter-7-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 8.3;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 24) {
      document.getElementById("java-9-chapter-7-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 24)
        document.getElementById("java-9-chapter-7-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>