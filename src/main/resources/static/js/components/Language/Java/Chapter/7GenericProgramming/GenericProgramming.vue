<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <theme-button theme-name="Назначение обобщенного программирования"
                    path-theme="/language/java/generics/DeclarationGeneric"
                    id="java-7-chapter-1-theme"/>
      <theme-button theme-name="Определение простого обобщенного класса"
                    path-theme="/language/java/generics/DeclarationSimpleGenericClass"
                    id="java-7-chapter-2-theme"/>
      <theme-button theme-name="Обобщенные методы"
                    path-theme="/language/java/generics/GenericMethods"
                    id="java-7-chapter-3-theme"/>
      <theme-button theme-name="Ограничения на переменные типа"
                    path-theme="/language/java/generics/LimitOnGenericType"
                    id="java-7-chapter-4-theme"/>
      <generic-code-and-virtual-machine/>
      <theme-button theme-name="Ограничения и пределы обобщений"
                    path-theme="/language/java/generics/TransformationGenericMethods"
                    id="java-7-chapter-6-theme"/>
      <theme-button theme-name="Правила наследования обобщенных типов"
                    path-theme="/language/java/generics/RuleInhiretenceGenericType"
                    id="java-7-chapter-7-theme"/>
    </div>
    <chapter-button chapter-name="Обобщенное программирование" class="theme-level-1-chapter-left"
                    id="central-btn-7chapter"/>
  </div>
</template>

<script>
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import GenericCodeAndVirtualMachine from "./5GenericCodeAndVirtualMachine/GenericCodeAndVirtualMachine.vue";

export default {
  name: "GenericProgramming",
  components: {GenericCodeAndVirtualMachine, ChapterButton, ThemeButton},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-7chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-7chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-7chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-7chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-7chapter"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-7chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-7chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-7-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo6Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo7Theme.node);


    if (window.frontendData.language.chapters[6].listThemes[0].finished) {
      document.getElementById("java-7-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[6].listThemes[1].finished) {
      document.getElementById("java-7-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[6].listThemes[2].finished) {
      document.getElementById("java-7-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[6].listThemes[3].finished) {
      document.getElementById("java-7-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[6].listThemes[7].finished) {
      document.getElementById("java-7-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[6].listThemes[8].finished) {
      document.getElementById("java-7-chapter-3-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[6].chapterProgress > 0 &&
        window.frontendData.language.chapters[6].chapterProgress < 98) {
      document.getElementById("central-btn-7chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[6].chapterProgress >= 98) {
        document.getElementById("central-btn-7chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[6].chapterProgress
      let dataPopover
      if (progress > 98) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-7chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 7</div></h4>',
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