<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Определение подклассов"
                    path-theme="/language/java/inheritance/DefenitionUnderClasses" id="java-4-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Иерархии наследования"
                    path-theme="/language/java/inheritance/HierarchyInheritance" id="java-4-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Полиморфизм"
                    path-theme="/language/java/inheritance/Polymorfizm" id="java-4-chapter-1-theme-3-subtheme"/>

      <theme-button theme-name="Предотвращение наследования: конечные классы и методы"
                    path-theme="/language/java/inheritance/PreventionInheritance" id="java-4-chapter-1-theme-4-subtheme"/>
      <theme-button theme-name="Приведение типов "
                    path-theme="/language/java/inheritance/BringingTypes" id="java-4-chapter-1-theme-5-subtheme"/>
      <theme-button theme-name="Абстрактные классы"
                    path-theme="/language/java/inheritance/AbstractClasses" id="java-4-chapter-1-theme-6-subtheme"/>

    </div>
    <chapter-button chapter-name="Классы, суперклассы и подклассы" class="theme-level-4-chapter-left" id="java-4-chapter-1-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ClassesSuperClassesAndUnderClasses",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter4Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromChapter4Theme1SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-1-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme1SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-1-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-1-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme1SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-1-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme1SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-1-theme-8-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme1SubTheme9 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-1-theme-9-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });


    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme1SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme1SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme1SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme1SubTheme8.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme1SubTheme9.node);


    let countProgressLocalTheme = 0

    for (let i = 0; i < 7; i++) {
      if (window.frontendData.language.chapters[3].listThemes[i].finished) {
        let k = i + 1
        document.getElementById("java-4-chapter-1-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 4.34;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 17) {
      document.getElementById("java-4-chapter-1-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 17)
        document.getElementById("java-4-chapter-1-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>