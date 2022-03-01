<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Тип Optional" class="theme-level-10-chapter-right"
                    id="java-10-chapter-7-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Получение необязательных значений"
                    path-theme="/language/java/streams/GettingUnnesaryResults"
                    id="java-10-chapter-7-theme-1-subtheme"/>
      <theme-button theme-name="Употребление необязательных значений"
                    path-theme="/language/java/streams/UsingUnnesary"
                    id="java-10-chapter-7-theme-2-subtheme"/>
      <theme-button theme-name="Конвейеризация необязательных значений"
                    path-theme="/language/java/streams/FactoryUnnessary"
                    id="java-10-chapter-7-theme-3-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "TypeOptional",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter10Theme7SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter10Theme7SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter10Theme7SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-10-chapter-7-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-10-chapter-7-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter10Theme7SubTheme3.node);

    let countProgressLocalTheme = 0

    for (let i = 3; i < 6; i++) {
      if (window.frontendData.language.chapters[9].listThemes[i].finished) {
        let k = i - 2
        document.getElementById("java-10-chapter-7-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 11.1;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 30) {
      document.getElementById("java-10-chapter-7-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 30)
        document.getElementById("java-10-chapter-7-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>