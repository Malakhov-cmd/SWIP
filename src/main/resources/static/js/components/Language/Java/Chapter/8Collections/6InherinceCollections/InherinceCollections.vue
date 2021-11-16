<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Класс Hashtable"
                    path-theme="/language/java/collections/ClassHashtable"
                    id="java-8-chapter-6-theme-1-subtheme"/>
      <theme-button theme-name="Перечисления"
                    path-theme="/language/java/collections/Enums"
                    id="java-8-chapter-6-theme-2-subtheme"/>
      <theme-button theme-name="Таблицы свойств"
                    path-theme="/language/java/collections/TablesProperties"
                    id="java-8-chapter-6-theme-3-subtheme"/>
      <theme-button theme-name="Стеки"
                    path-theme="/language/java/collections/Stacks"
                    id="java-8-chapter-6-theme-4-subtheme"/>
      <theme-button theme-name="Битовые множества"
                    path-theme="/language/java/collections/BitMap"
                    id="java-8-chapter-6-theme-5-subtheme"/>
    </div>
    <chapter-button chapter-name="Унаследованные коллекции" class="theme-level-8-chapter-left"
                    id="java-8-chapter-6-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InherinceCollections",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter8Theme6SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-6-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme6SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-6-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme6SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-6-theme"),
        direction: DIRECTION.LEFT,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-6-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme6SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-6-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter8Theme6SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-8-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-8-chapter-6-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme6SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme6SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme6SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme6SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter8Theme6SubTheme5.node);

  }
}
</script>

<style scoped>

</style>