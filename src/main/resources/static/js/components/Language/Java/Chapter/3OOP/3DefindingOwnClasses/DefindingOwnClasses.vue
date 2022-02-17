<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Пример класса"
                    path-theme="/language/java/oop/defindingownclasses/classyemployee"
                    id="java-3-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Знакомство с конструкторами"
                    path-theme="/language/java/oop/defindingownclasses/constructor"
                    id="java-3-chapter-3-theme-4-subtheme"/>
      <theme-button theme-name="Явные и неявные параметры"
                    path-theme="/language/java/oop/defindingownclasses/ExplicitAndUnexplicitParamethers"
                    id="java-3-chapter-3-theme-7-subtheme"/>
      <theme-button theme-name="Преимущества инкапсуляции"
                    path-theme="/language/java/oop/defindingownclasses/incapsulationBenefits"
                    id="java-3-chapter-3-theme-8-subtheme"/>
      <theme-button theme-name="Закрытые методы"
                    path-theme="/language/java/oop/defindingownclasses/closedMethods"
                    id="java-3-chapter-3-theme-10-subtheme"/>
      <theme-button theme-name="Конечные поля экземпляра"
                    path-theme="/language/java/oop/defindingownclasses/EndedField"
                    id="java-3-chapter-3-theme-11-subtheme"/>

    </div>
    <chapter-button chapter-name="Определение собственных классов" class="theme-level-3-chapter-left"
                    id="java-3-chapter-3-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";

export default {
  name: "DefindingOwnClasses",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme3SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-3-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme3SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-3-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme3SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-3-theme-8-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme3SubTheme10 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-3-theme-10-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme3SubTheme11 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-3-theme-11-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme3SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme3SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme3SubTheme8.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme3SubTheme10.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme3SubTheme11.node);

    let countProgressLocalTheme = 0
//TODO здесь будут проблемы с индексами
    for (let i = 7; i < 13; i++) {
      if (window.frontendData.language.chapters[2].listThemes[i].finished) {
        let k = i -6
        document.getElementById("java-3-chapter-2-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 2.7;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 10) {
      document.getElementById("java-3-chapter-2-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 10)
        document.getElementById("java-3-chapter-2-theme").setAttribute("style", "background: #28a745; border: green;")
    }

  }
}
</script>

<style scoped>

</style>