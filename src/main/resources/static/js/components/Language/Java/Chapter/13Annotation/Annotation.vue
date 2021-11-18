<template>
  <div class="chapter-level-1">
    <chapter-button chapter-name="Написание сценариев, компиляция и обработка аннотаций" class="theme-level-13-chapter-right"
                    id="central-btn-13chapter"/>
    <div class="theme-level-1 theme-level-1-right">
<scenario/>
      <interface-a-p-i-for-compiler/>
      <use-annotation/>
      <syntax-annotation/>
      <standart-annotation/>
    </div>
  </div>
</template>

<script>
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import Scenario from "./1Scenario/Scenario.vue";
import InterfaceAPIForCompiler from "./2InterfaceAPIForCompiler/InterfaceAPIForCompiler.vue";
import UseAnnotation from "./3UseAnnotation/UseAnnotation.vue";
import SyntaxAnnotation from "./4SyntaxAnnotation/SyntaxAnnotation.vue";
import StandartAnnotation from "./5StandartAnnotation/StandartAnnotation.vue";

export default {
  name: "Annotation",
  components: {
    StandartAnnotation, SyntaxAnnotation, UseAnnotation, InterfaceAPIForCompiler, Scenario, ChapterButton},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-13chapter"),
        direction: DIRECTION.RIGHT,
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
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-13chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-2-theme"),
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
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-13-chapter-3-theme"),
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
        direction: DIRECTION.RIGHT,
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
        direction: DIRECTION.RIGHT,
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo2Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo3Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo4Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo5Theme.node);

  }
}
</script>

<style scoped>

</style>