<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <intro-o-o-p/>
      <tenp-remake-class/>
      <definding-own-classes/>
      <static-field-and-method/>
      <ThemeButton theme-name="Параметры методов"
                   path-theme="/language/java/oop/paramethrMethods" id="java-3-chapter-5-theme"/>
      <construction-object/>
      <ThemeButton theme-name="Пакеты"
                   path-theme="/language/java/oop/pocket/packets" id="java-3-chapter-7-theme"/>
      <documentring-comments/>
      <ThemeButton theme-name="Рекомендация по разработке"
                   path-theme="/language/java/oop/RecomendationDevelopmentClasses" id="java-3-chapter-9-theme"/>
    </div>
    <chapter-button chapter-name="ООП" class="theme-level-1-chapter-left" id="central-btn-3chapter"/>
  </div>
</template>

<script>
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import IntroOOP from "./1IntroOOP/IntroOOP.vue";
import TenpRemakeClass from "./2TempRemakeClass/TempRemakeClass.vue";
import DefindingOwnClasses from "./3DefindingOwnClasses/DefindingOwnClasses.vue";
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import StaticFieldAndMethod from "./4StaticFieldAndMethod/StaticFieldAndMethod.vue";
import ConstructionObject from "./6ConstructionObject/ConstructionObject.vue";
import Packets from "./7Packets/Packets.vue";
import DocumentringComments from "./9DocumentringComments/DocumentringComments.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";

export default {
  name: "OOP",
  components: {
    ChapterButton,
    DocumentringComments,
    Packets,
    ConstructionObject,
    StaticFieldAndMethod,
    ThemeButton,
    DefindingOwnClasses,
    TenpRemakeClass,
    IntroOOP
  },
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo9Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    const arrowFromCentralBtnChapterTo10Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-3chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-9-theme"),
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo9Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo10Theme.node);

    /*
    * Проверка решания глав где всего одна тема
    * */
    if (window.frontendData.language.chapters[2].listThemes[15].finished) {
      document.getElementById("java-3-chapter-5-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[2].listThemes[19].finished) {
      document.getElementById("java-3-chapter-7-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }
    if (window.frontendData.language.chapters[2].listThemes[22].finished) {
      document.getElementById("java-3-chapter-9-theme")
          .setAttribute("style", "background: #28a745; border: green;");
    }

    if (window.frontendData.language.chapters[2].chapterProgress > 0 &&
        window.frontendData.language.chapters[2].chapterProgress < 99) {
      document.getElementById("central-btn-3chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[2].chapterProgress >= 99) {
        document.getElementById("central-btn-3chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[2].chapterProgress
      let dataPopover
      if (progress > 99) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-3chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 3</div></h4>',
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