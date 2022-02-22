<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Классификация исключений"
                    path-theme="/language/java/exeption/ClassificationExeption"
                    id="java-6-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Объявление проверяемых исключений"
                    path-theme="/language/java/exeption/DeclarationProvedExeption"
                    id="java-6-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Создание классов исключений"
                    path-theme="/language/java/exeption/CreationClassesExeption"
                    id="java-6-chapter-1-theme-3-subtheme"/>
    </div>
    <chapter-button chapter-name="Обработка ошибок" class="theme-level-6-chapter-left" id="java-6-chapter-1-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "WorkingWithExeption",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter6Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme1SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-1-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-1-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme1SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-1-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme1SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme1SubTheme4.node);

    let countProgressLocalTheme = 0

    for (let i = 0; i < 3; i++) {
      if (window.frontendData.language.chapters[5].listThemes[i].finished) {
        let k = i + 1
        document.getElementById("java-6-chapter-1-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 16.6;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 49) {
      document.getElementById("java-6-chapter-1-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 49)
        document.getElementById("java-6-chapter-1-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>