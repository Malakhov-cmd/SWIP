<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Понятие интерфейса"
                    path-theme="/language/java/interfacesLyambdaAndInner/ConceptInterface"
                    id="java-5-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Особенности интерфейсов"
                    path-theme="/language/java/interfacesLyambdaAndInner/InterfacesAndAbstarctClasses"
                    id="java-5-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Клонирование объектов"
                    path-theme="/language/java/interfacesLyambdaAndInner/ClonningObjects"
                    id="java-5-chapter-1-theme-3-subtheme"/>
    </div>
    <chapter-button chapter-name="Интерфейсы"
                    class="theme-level-5-chapter-left"
                    id="java-5-chapter-1-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Interfaces",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter5Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromChapter5Theme1SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });


    const arrowFromChapter5Theme1SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme8.node);

    let countProgressLocalTheme = 0

    for (let i = 0; i < 3; i++) {
      if (window.frontendData.language.chapters[4].listThemes[i].finished) {
        let k = i + 1
        document.getElementById("java-5-chapter-1-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 10.0;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 29) {
      document.getElementById("java-5-chapter-1-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 29)
        document.getElementById("java-5-chapter-1-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>