<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Объявление списочных массивов"
                    path-theme="/language/java/inheritance/AnnouncementLinkMassive" id="java-4-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Доступ к элементам списочных массивов"
                    path-theme="/language/java/inheritance/AccessToElementLinkMassive" id="java-4-chapter-3-theme-2-subtheme"/>
      </div>
    <chapter-button chapter-name="Обобщенные списочные массивы" class="theme-level-4-chapter-left" id="java-4-chapter-3-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "ListingMassive",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter4Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-3-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter4Theme3SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-4-chapter-3-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-4-chapter-3-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter4Theme3SubTheme2.node);
  }
}
</script>

<style scoped>

</style>