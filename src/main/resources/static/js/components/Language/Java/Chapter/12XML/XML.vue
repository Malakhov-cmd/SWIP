<template>
  <div class="chapter-level-1">
    <chapter-button chapter-name="XML" class="theme-level-12-chapter-right"
                    id="central-btn-12chapter"/>
    <div class="theme-level-1 theme-level-1-right">
      <theme-button theme-name="Введение в XML"
                    path-theme="/language/java/xml/IntroductionToXML"
                    id="java-12-chapter-1-theme"/>
      <theme-button theme-name="Структура XML-документа"
                    path-theme="/language/java/xml/StructureXML"
                    id="java-12-chapter-2-theme"/>
      <theme-button theme-name="Синтаксический анализ XML-документов"
                    path-theme="/language/java/xml/SyntaxAnalizeXMLDoc"
                    id="java-12-chapter-3-theme"/>
      <checking-trust-x-m-l-doc/>
      <theme-button theme-name="Поиск информации средствами XPath"
                    path-theme="/language/java/streams/AccumulationResults"
                    id="java-12-chapter-5-theme"/>
      <theme-button theme-name="Использование пространств имен"
                    path-theme="/language/java/streams/AccumulationInReflection"
                    id="java-12-chapter-6-theme"/>
     <stream-syntax-analizator/>
      <forming-x-m-l-doc/>
      <theme-button theme-name="Преобразование XML-документов языковыми средствами XSLT"
                    path-theme="/language/java/streams/ParallelStreamsData"
                    id="java-12-chapter-9-theme"/>
    </div>
  </div>
</template>

<script>
import CheckingTrustXMLDoc from "./4CheckingTrustXMLDoc/CheckingTrustXMLDoc.vue";
import StreamSyntaxAnalizator from "./7StreamSyntaxAnalizator/StreamSyntaxAnalizator.vue";
import FormingXMLDoc from "./8FormingXMLDoc/FormingXMLDoc.vue";
import ThemeButton from "../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "XML",
  components: {ChapterButton, ThemeButton, FormingXMLDoc,
    StreamSyntaxAnalizator, CheckingTrustXMLDoc},
  mounted() {
    const arrowFromCentralBtnChapterTo1Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-1-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo2Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-2-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo3Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-3-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo4Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-4-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo5Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-5-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo6Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-6-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo7Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-7-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo8Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-8-theme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromCentralBtnChapterTo9Theme = arrowCreate({
      from: {
        node: () => document.getElementById("central-btn-12chapter"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-12-chapter-9-theme"),
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
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo6Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo7Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo8Theme.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnChapterTo9Theme.node);

  }
}
</script>

<style scoped>

</style>