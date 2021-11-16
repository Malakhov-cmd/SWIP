<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Понятие интерфейса"
                    path-theme="/language/java/interfacesLyambdaAndInner/ConceptInterface"
                    id="java-5-chapter-1-theme-1-subtheme"/>
      <theme-button theme-name="Свойства интерфейсов"
                    path-theme="/language/java/interfacesLyambdaAndInner/PropertiesIntefaces"
                    id="java-5-chapter-1-theme-2-subtheme"/>
      <theme-button theme-name="Интерфейсы и абстрактные классы"
                    path-theme="/language/java/interfacesLyambdaAndInner/InterfacesAndAbstarctClasses"
                    id="java-5-chapter-1-theme-3-subtheme"/>
      <theme-button theme-name=" Статические и закрытые методы"
                    path-theme="/language/java/interfacesLyambdaAndInner/StaticAndClosenMethods"
                    id="java-5-chapter-1-theme-4-subtheme"/>
      <theme-button theme-name="Методы с реализацией по умолчанию"
                    path-theme="/language/java/interfacesLyambdaAndInner/MethodsWithRealizationByDefault"
                    id="java-5-chapter-1-theme-5-subtheme"/>
      <theme-button theme-name="Интерфейсы и обратные вызовы"
                    path-theme="/language/java/interfacesLyambdaAndInner/InterfacesAndBackcall"
                    id="java-5-chapter-1-theme-6-subtheme"/>
      <theme-button theme-name="Интерфейс Comparator"
                    path-theme="/language/java/interfacesLyambdaAndInner/InterfaceComparator"
                    id="java-5-chapter-1-theme-7-subtheme"/>
      <theme-button theme-name="Клонирование объектов"
                    path-theme="/language/java/interfacesLyambdaAndInner/ClonningObjects"
                    id="java-5-chapter-1-theme-8-subtheme"/>
    </div>
    <chapter-button chapter-name="Интерфейсы" class="theme-level-5-chapter-left" id="java-5-chapter-1-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "Interfaces",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter5Theme1SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme1SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme1SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme1SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme1SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme1SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme1SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme1SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-1-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-1-theme-8-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme1SubTheme8.node);
  }
}
</script>

<style scoped>

</style>