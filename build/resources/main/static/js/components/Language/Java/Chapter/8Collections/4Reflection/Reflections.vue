<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Основные операции над отображениями"
                    path-theme="/language/java/collections/OperationOnReflection"
                    id="java-8-chapter-4-theme-1-subtheme"/>
      <theme-button theme-name="Перечислимые множества и отображения"
                    path-theme="/language/java/collections/EnumCollectionsAndReflection"
                    id="java-8-chapter-4-theme-2-subtheme"/>
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
    const arrowFromChapter8Theme4SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-4-theme"),
        direction: DIRECTION.BOTTOM,
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

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme4SubTheme6.node);

    let countProgressLocalTheme = 0

    for (let i = 10; i < 12; i++) {
      if (window.frontendData.language.chapters[7].listThemes[i].finished) {
        let k = i - 9
        document.getElementById("java-8-chapter-4-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 8.3;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 16) {
      document.getElementById("java-8-chapter-4-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 16)
        document.getElementById("java-8-chapter-4-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>