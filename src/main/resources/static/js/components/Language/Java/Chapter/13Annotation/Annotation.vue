<template>
  <div class="chapter-level-1">
    <chapter-button chapter-name="Написание сценариев, компиляция и обработка аннотаций"
                    class="theme-level-13-chapter-right"
                    id="central-btn-13chapter"/>
    <div class="theme-level-1 theme-level-1-right">
      <scenario/>
      <theme-button theme-name="Введение в аннотации"
                    path-theme="/language/java/scenarioandannotation/IntroInAnnotation"
                    id="java-13-chapter-3-theme-1-subtheme"/>
      <syntax-annotation/>
      <standart-annotation/>
    </div>
  </div>
</template>

<script>
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import Scenario from "./1Scenario/Scenario.vue";
import SyntaxAnnotation from "./4SyntaxAnnotation/SyntaxAnnotation.vue";
import StandartAnnotation from "./5StandartAnnotation/StandartAnnotation.vue";
import ThemeButton from "../../../Blocks/ThemeButton.vue";

export default {
  name: "Annotation",
  components: {
    ThemeButton,
    StandartAnnotation, SyntaxAnnotation, Scenario, ChapterButton
  },
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-13chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-1-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-13chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-13chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-4-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-13chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-5-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo1Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo3Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo4Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo5Theme.node);

    if (window.frontendData.language.chapters[10].listThemes[4].finished) {
      document.getElementById("java-13-chapter-3-theme-1-subtheme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[10].chapterProgress > 0 &&
        window.frontendData.language.chapters[10].chapterProgress < 99) {
      document.getElementById("central-btn-13chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[10].chapterProgress >= 99) {
        document.getElementById("central-btn-13chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[10].chapterProgress
      let dataPopover
      if (progress > 99) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-13chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 11</div></h4>',
        content: '<div class="popover-body"><div class="popover-body-text">' + dataPopover + '</div></div>',
        trigger: 'hover',
        placement: 'right',
        html: true
      });
    });
  }
}
</script>

<style scoped>

</style>