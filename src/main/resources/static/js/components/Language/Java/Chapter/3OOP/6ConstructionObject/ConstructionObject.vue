<template>
  <div class="chapter-level-2">
    <div class="theme-level-2">
      <theme-button theme-name="Перегрузка"
                    path-theme="/language/java/oop/constructionObject/Overload" id="java-3-chapter-6-theme-1-subtheme"/>
      <theme-button theme-name="Инициализация полей по умолчанию"
                    path-theme="/language/java/oop/constructionObject/InitializingFieldByDefoult" id="java-3-chapter-6-theme-2-subtheme"/>
      <theme-button theme-name="Конструктор без аргументов"
                    path-theme="/language/java/oop/constructionObject/ConstructorWithoutArgs" id="java-3-chapter-6-theme-3-subtheme"/>
      <theme-button theme-name="Явная инициализация полей"
                    path-theme="/language/java/oop/constructionObject/ExplicitInitialization" id="java-3-chapter-6-theme-4-subtheme"/>
      <theme-button theme-name="Имена параметров"
                    path-theme="/language/java/oop/constructionObject/NameParamethers" id="java-3-chapter-6-theme-5-subtheme"/>
      <theme-button theme-name="Вызов одного конструктора из другого"
                    path-theme="/language/java/oop/constructionObject/Call1ConstructorFromAnother" id="java-3-chapter-6-theme-6-subtheme"/>
      <theme-button theme-name="Блоки инициализации"
                    path-theme="/language/java/oop/constructionObject/BlocksInitialization" id="java-3-chapter-6-theme-7-subtheme"/>
      <theme-button theme-name="Уничтожение объектов и метод finalize()"
                    path-theme="/language/java/oop/constructionObject/DestroyObjectsAndMethodFinalize" id="java-3-chapter-6-theme-8-subtheme"/>
    </div>
    <chapter-button chapter-name="Конструирование объектов" class="theme-level-3-chapter-left" id="java-3-chapter-6-theme"/>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {DIRECTION, HEAD} from "arrows-svg";

export default {
  name: "ConstructionObject",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter3Theme6SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-1-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-2-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-3-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.TOP,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-4-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-5-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme6 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-6-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme7 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-7-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter3Theme6SubTheme8 = arrowCreate({
      from: {
        node: () => document.getElementById("java-3-chapter-6-theme"),
        direction: DIRECTION.BOTTOM,
      },
      to: {
        node: () => document.getElementById("java-3-chapter-6-theme-8-subtheme"),
        direction: DIRECTION.RIGHT,
        translation: [1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme5.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme6.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme7.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter3Theme6SubTheme8.node);
  }
}
</script>

<style scoped>

</style>