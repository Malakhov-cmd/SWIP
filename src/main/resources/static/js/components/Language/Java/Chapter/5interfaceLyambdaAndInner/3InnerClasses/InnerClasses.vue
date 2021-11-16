<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Доступ к состоянию объекта с помощью внутреннего класса"
                    path-theme="/language/java/interfacesLyambdaAndInner/AccessToConditionToInnerClasses"
                    id="java-5-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Специальные синтаксические правила для внутренних классов"
                    path-theme="/language/java/interfacesLyambdaAndInner/SpecialSyntaxRuleForInnerClasses"
                    id="java-5-chapter-3-theme-2-subtheme"/>
      <theme-button theme-name="Локальные внутренние классы"
                    path-theme="/language/java/interfacesLyambdaAndInner/LocalInnerClasses"
                    id="java-5-chapter-3-theme-3-subtheme"/>
      <theme-button theme-name="Доступ к конечным переменным из внешних методов"
                    path-theme="/language/java/interfacesLyambdaAndInner/AccessToEndedTempFromOutsideMethods"
                    id="java-5-chapter-3-theme-4-subtheme"/>
      <theme-button theme-name="Анонимные внутренние классы"
                    path-theme="/language/java/interfacesLyambdaAndInner/AnonimusInnerClasses"
                    id="java-5-chapter-3-theme-5-subtheme"/>
      <theme-button theme-name="Статические внутренние классы"
                    path-theme="/language/java/interfacesLyambdaAndInner/StaticInnerClasses"
                    id="java-5-chapter-3-theme-6-subtheme"/>
    </div>
    <chapter-button chapter-name="Внутренние классы" class="theme-level-5-chapter-left" id="java-5-chapter-3-theme"/>
  </div>
</template>

<script>

import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InnerClasses",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter5Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme3SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-3-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme3SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-3-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-3-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme3SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-3-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-3-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme3SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-3-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter5Theme3SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-5-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-5-chapter-3-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme3SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme3SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme3SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme3SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter5Theme3SubTheme6.node);

  }
}
</script>

<style scoped>

</style>