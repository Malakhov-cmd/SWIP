<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <ThemeButton class="themes-lvl-2"
                   theme-name="Пример простой программы"
                   path-theme="/language/java/languageconstruction/simpleprogramexample" id="java-2-chapter-1-theme"/>
      <ThemeButton class="themes-lvl-2"
                   theme-name="Комментарии" path-theme="/language/java/languageconstruction/comments"
                   id="java-2-chapter-2-theme"/>
      <DataType/>
      <TempAndConstant/>
      <Operation/>
      <SymbolStr/>
      <InputAndOutput/>
      <ManageLogic/>
      <theme-button class="themes-lvl-2" theme-name="Большие числа " path-theme="/language/java/languageconstruction/bigdigit"
                    id="java-2-chapter-9-theme"/>
      <Arrays/>
    </div>
    <ChapterButton chapter-name="Языковые конструкции" class="theme-level-1-chapter-left" id="central-btn-2chapter"/>
  </div>
</template>

<script>
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import DataType from "./3DataTypes/DataType.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import TempAndConstant from "./4TempAndConstant/TempAndConstant.vue";
import Operation from "./5Operations/Operation.vue";
import SymbolStr from "./6SymbolStr/SymbolStr.vue";
import InputAndOutput from "./7InputAndOutput/InputAndOutput.vue";
import ManageLogic from "./8ManageLogic/ManageLogic.vue";
import Arrays from "./10Arrays/Arrays.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "LanguageConstructions",
  components: {
    Arrays,
    ManageLogic, InputAndOutput, SymbolStr, Operation, TempAndConstant, ChapterButton, DataType, ThemeButton
  },
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-1-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-2-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-4-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-5-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-6-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-7-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo8Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-8-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo9Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-9-theme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo10Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-2chapter"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-2-chapter-10-theme"),
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo9Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo10Theme.node);

    let listTheme = document.getElementsByClassName("themes-lvl-2")
    for (let i = 0; i < listTheme.length; i++) {
      if (window.frontendData.language.chapters[1].listThemes[i].finished) {
        listTheme.item(i).setAttribute("style", "background: #28a745; border: green;");
      }
    }

    if (window.frontendData.language.chapters[1].chapterProgress > 0 &&
        window.frontendData.language.chapters[1].chapterProgress < 99) {
      document.getElementById("central-btn-2chapter").setAttribute("style", " background: #dbcc16; border: green;")
    } else {
      if (window.frontendData.language.chapters[1].chapterProgress >= 99) {
        document.getElementById("central-btn-2chapter").setAttribute("style", "background: #28a745; border: green;")
      }
    }
  }

}
</script>

<style scoped>

</style>