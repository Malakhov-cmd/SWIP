<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <classes-super-classes-and-under-classes/>
      <class-object/>
      <listing-massive/>
      <theme-button theme-name="Объектные оболочки и автоупаковка"
                   path-theme="/language/java/inheritance/ObjectShellAndAutoPacking" id="java-4-chapter-4-theme"/>
      <theme-button theme-name="Методы с переменным числом параметров"
                    path-theme="/language/java/inheritance/TempCountParamethersOfMethod" id="java-4-chapter-5-theme"/>
      <theme-button theme-name="Классы перечислений "
                    path-theme="/language/java/inheritance/EnumClasses" id="java-4-chapter-6-theme"/>

      <reflection/>
      <ThemeButton theme-name="Рекомендации по применению наследования"
                   path-theme="/language/java/inheritance/RecomendationUseInheritance" id="java-4-chapter-8-theme"/>
    </div>
    <chapter-button chapter-name="Наследование" class="theme-level-1-chapter-left" id="central-btn-4chapter"/>
  </div>
</template>

<script>
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import ClassesSuperClassesAndUnderClasses
  from "./1ClassesSuperClassesAndUnderClasses/ClassesSuperClassesAndUnderClasses.vue";
import ClassObject from "./2ClassObject/ClassObject.vue";
import ListingMassive from "./3ListingMassive/ListingMassive.vue";
import Reflection from "./7Reflection/Reflection.vue";

export default {
  name: "Inheritance",
  components: {Reflection, ListingMassive, ClassObject, ClassesSuperClassesAndUnderClasses, ThemeButton, ChapterButton},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo8Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-4chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-8-theme"),
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo8Theme.node);

    /*
    * Проверка решания глав где всего одна тема
    *
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
    }*/

    if (window.frontendData.language.chapters[3].chapterProgress > 0 &&
        window.frontendData.language.chapters[3].chapterProgress < 99) {
      document.getElementById("central-btn-4chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[3].chapterProgress >= 99) {
        document.getElementById("central-btn-4chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }

    //Отображение общей информации в popover
    $(document).ready(function () {
      let progress = window.frontendData.language.chapters[3].chapterProgress
      let dataPopover
      if (progress > 99) {
        dataPopover = 'Процент завершения ' + 100
      } else {
        dataPopover = 'Процент завершения ' + Math.round(progress)
      }
      $("#central-btn-3chapter").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Глава 4</div></h4>',
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