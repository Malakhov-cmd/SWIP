<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Перехват одного исключения"
                    path-theme="/language/java/exeption/InterceptionOneExeption"
                    id="java-6-chapter-2-theme-1-subtheme"/>
      <theme-button theme-name="Перехват нескольких исключений"
                    path-theme="/language/java/exeption/InterceptionSomeExeption"
                    id="java-6-chapter-2-theme-2-subtheme"/>
      <theme-button theme-name="Повторное генерирование и связывание исключений в цепочку"
                    path-theme="/language/java/exeption/RegenerationAndLinkExeptionInChain"
                    id="java-6-chapter-2-theme-3-subtheme"/>
      <theme-button theme-name="Блок оператора finally"
                    path-theme="/language/java/exeption/BlockFinaly"
                    id="java-6-chapter-2-theme-4-subtheme"/>
      <theme-button theme-name="Оператор try с ресурсами"
                    path-theme="/language/java/exeption/OperatorTryWithResource"
                    id="java-6-chapter-2-theme-5-subtheme"/>
      <theme-button theme-name="Анализ элементов трассировки стека"
                    path-theme="/language/java/exeption/AnalizeElementsTracestack"
                    id="java-6-chapter-2-theme-6-subtheme"/>
    </div>
    <chapter-button chapter-name="Перехват исключений" class="theme-level-6-chapter-left" id="java-6-chapter-2-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InterceptionExeption",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter6Theme2SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme2SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme2SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme2SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme2SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter6Theme2SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-6-chapter-2-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-6-chapter-2-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter6Theme2SubTheme6.node);
  }
}
</script>

<style scoped>

</style>