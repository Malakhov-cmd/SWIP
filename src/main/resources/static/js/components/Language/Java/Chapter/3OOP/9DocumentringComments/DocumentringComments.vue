<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Вставка комментариев"
                    path-theme="/language/java/oop/comments/AddingComments" id="java-3-chapter-8-theme-1-subtheme"/>
      <theme-button theme-name="Комментарии"
                    path-theme="/language/java/oop/comments/ClassComment" id="java-3-chapter-8-theme-2-subtheme"/>
      </div>
    <chapter-button chapter-name="Документирование" class="theme-level-3-chapter-left" id="java-3-chapter-8-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";

export default {
  name: "DocumentringComments",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme9SubTheme1 = arrowCreate({
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
    const arrowFromChapter3Theme9SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-8-theme"),
        direction: DIRECTION.BOTTOM,
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

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme9SubTheme2.node);

    let countProgressLocalTheme = 0

    for (let i = 20; i < 22; i++) {
      if (window.frontendData.language.chapters[2].listThemes[i].finished) {
        let k = i - 19
        document.getElementById("java-3-chapter-8-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 4.34;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 8) {
      document.getElementById("java-3-chapter-8-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 8)
        document.getElementById("java-3-chapter-8-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>