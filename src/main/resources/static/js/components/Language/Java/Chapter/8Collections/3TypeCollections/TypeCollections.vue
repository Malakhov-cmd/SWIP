<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Связные списки"
                    path-theme="/language/java/collections/LinkedList"
                    id="java-8-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Списочные массивы"
                    path-theme="/language/java/collections/ListMassive"
                    id="java-8-chapter-3-theme-2-subtheme"/>
      <theme-button theme-name="Хеш-множества"
                    path-theme="/language/java/collections/HashMap"
                    id="java-8-chapter-3-theme-3-subtheme"/>
      <theme-button theme-name="Древовидные множества"
                    path-theme="/language/java/collections/TreeMap"
                    id="java-8-chapter-3-theme-4-subtheme"/>
      <theme-button theme-name="Одно-и двухсторонние очереди "
                    path-theme="/language/java/collections/OneAndTwoQuequ"
                    id="java-8-chapter-3-theme-5-subtheme"/>
      <theme-button theme-name="Очереди по приоритету"
                    path-theme="/language/java/collections/QuequOnPriority"
                    id="java-8-chapter-3-theme-6-subtheme"/>
    </div>
    <chapter-button chapter-name="Конкретные коллекции" class="theme-level-8-chapter-left"
                    id="java-8-chapter-3-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "TypeCollections",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter8Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme3SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-3-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme3SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-3-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-3-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme3SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-3-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-3-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme3SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-3-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme3SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-3-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme3SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme3SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme3SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme3SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme3SubTheme6.node);

    let countProgressLocalTheme = 0

    for (let i = 4; i < 10; i++) {
      if (window.frontendData.language.chapters[7].listThemes[i].finished) {
        let k = i - 3
        document.getElementById("java-8-chapter-3-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 8.3;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 49) {
      document.getElementById("java-8-chapter-3-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 49)
        document.getElementById("java-8-chapter-3-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>