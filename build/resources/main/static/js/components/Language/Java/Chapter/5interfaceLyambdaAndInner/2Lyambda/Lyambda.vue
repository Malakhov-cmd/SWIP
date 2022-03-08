<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Синтаксис и причины для уподребления лямбда-выражений"
                    path-theme="/language/java/interfacesLyambdaAndInner/ReasonsForUseLyambda"
                    id="java-5-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Функциональные интерфейсы"
                    path-theme="/language/java/interfacesLyambdaAndInner/FunctionalInterfaces"
                    id="java-5-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="Ссылки на методы"
                    path-theme="/language/java/interfacesLyambdaAndInner/LinkToTheMethods"
                    id="java-5-chapter-2-theme-3-subtheme"/>

    </div>
    <chapter-button chapter-name="Лямбда-выражения" class="theme-level-5-chapter-left" id="java-5-chapter-2-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Lyambda",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter5Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromChapter5Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme2SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });


    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme2SubTheme4.node);

    let countProgressLocalTheme = 0

    for (let i = 3; i < 6; i++) {
      if (window.frontendData.language.chapters[4].listThemes[i].finished) {
        let k = i - 2
        document.getElementById("java-5-chapter-2-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 10.0;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 29) {
      document.getElementById("java-5-chapter-2-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 29)
        document.getElementById("java-5-chapter-2-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>