<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Перегрузка"
                    path-theme="/language/java/oop/constructionObject/Overload"
                    id="java-3-chapter-6-theme-1-subtheme"/>

      <theme-button theme-name="Конструктор"
                    path-theme="/language/java/oop/constructionObject/ConstructorWithoutArgs"
                    id="java-3-chapter-6-theme-2-subtheme"/>

      <theme-button theme-name="Блоки инициализации"
                    path-theme="/language/java/oop/constructionObject/BlocksInitialization"
                    id="java-3-chapter-6-theme-3-subtheme"/>
    </div>
    <chapter-button chapter-name="Конструирование объектов" class="theme-level-3-chapter-left"
                    id="java-3-chapter-6-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";

export default {
  name: "ConstructionObject",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme6SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme1.node);

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme3.node);

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme7.node);

    let countProgressLocalTheme = 0
    for (let i = 16; i < 19; i++) {
      if (window.frontendData.language.chapters[2].listThemes[i].finished) {
        let k = i - 15
        document.getElementById("java-3-chapter-6-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 4.34;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 12) {
      document.getElementById("java-3-chapter-6-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 12)
        document.getElementById("java-3-chapter-6-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>