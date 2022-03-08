<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name=" Стирание типов"
                    path-theme="/language/java/generics/ClearingTypes"
                    id="java-7-chapter-5-theme-1-subtheme"/>
      <theme-button theme-name="Преобразование обобщенных выражений"
                    path-theme="/language/java/generics/TransformationGenericExpression"
                    id="java-7-chapter-5-theme-2-subtheme"/>
      <theme-button theme-name="Преобразование обобщенных методов"
                    path-theme="/language/java/generics/TransformationGenericMethods"
                    id="java-7-chapter-5-theme-3-subtheme"/>
    </div>
    <chapter-button chapter-name="Обобщенный код и виртуальная машина"
                    class="theme-level-7-chapter-left"
                    id="java-7-chapter-5-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "GenericCodeAndVirtualMachine",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter7Theme5SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter7Theme5SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter7Theme5SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter7Theme5SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter7Theme5SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter7Theme5SubTheme3.node);

    let countProgressLocalTheme = 0

    for (let i = 4; i < 7; i++) {
      if (window.frontendData.language.chapters[6].listThemes[i].finished) {
        let k = i - 3
        document.getElementById("java-7-chapter-5-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 11.1;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 32) {
      document.getElementById("java-7-chapter-5-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 32)
        document.getElementById("java-7-chapter-5-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>