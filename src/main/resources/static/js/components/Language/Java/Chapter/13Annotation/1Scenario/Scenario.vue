<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Написание сценариев для платформы Java" class="theme-level-13-chapter-right"
                    id="java-13-chapter-1-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Получение интерпретатора сценариев"
                    path-theme="/language/java/scenarioandannotation/InterpretatorScenario"
                    id="java-13-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Выполнение сценариев и привязки"
                    path-theme="/language/java/scenarioandannotation/ExeScenario"
                    id="java-13-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Переадресация ввода-вывода"
                    path-theme="/language/java/scenarioandannotation/RedirectInputOutput"
                    id="java-13-chapter-1-theme-3-subtheme"/>
      <theme-button theme-name="Вызов функций и методов из сценариев"
                    path-theme="/language/java/scenarioandannotation/CallFuncktionAndMethodsFromScenario"
                    id="java-13-chapter-1-theme-4-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Scenario",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter13Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme1SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-1-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme1SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-1-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter13Theme1SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-13-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-1-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme1SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme1SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter13Theme1SubTheme4.node);

    let countProgressLocalTheme = 0

    for (let i = 0; i < 4; i++) {
      if (window.frontendData.language.chapters[10].listThemes[i].finished) {
        let k = i + 1
        document.getElementById("java-13-chapter-1-theme-" + k + "-subtheme")
            .setAttribute("style", "background: #28a745; border: green;");
        countProgressLocalTheme = countProgressLocalTheme + 11.1;
      }
    }

    if (countProgressLocalTheme > 1 &&
        countProgressLocalTheme < 30) {
      document.getElementById("java-13-chapter-1-theme").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (countProgressLocalTheme > 30)
        document.getElementById("java-13-chapter-1-theme").setAttribute("style", "background: #28a745; border: green;")
    }
  }
}
</script>

<style scoped>

</style>