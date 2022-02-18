<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Объекты и объектные переменные"
                    path-theme="/language/java/oop/tempremake/objectsandobjectstemp"
                    id="java-3-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="LocalDate"
                    path-theme="/language/java/oop/tempremake/localdate" id="java-3-chapter-2-theme-2-subtheme"/>
    </div>
    <chapter-button chapter-name="Применение предопределенных классов" class="theme-level-3-chapter-left"
                    id="java-3-chapter-2-theme"/>
  </div>
</template>

<script>
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "TenpRemakeClass",
  components: {ThemeButton, ChapterButton},
  mounted() {
    const arrowFromChapter3Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme2SubTheme2.node);

    let countProgressLocalTheme = 0

    for (let i = 4; i < 6; i++) {
      if (window.frontendData.language.chapters[2].listThemes[i].finished) {
        let k = i - 3
        document.getElementById("java-3-chapter-2-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 4.34;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 8) {
      document.getElementById("java-3-chapter-2-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 8)
        document.getElementById("java-3-chapter-2-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>