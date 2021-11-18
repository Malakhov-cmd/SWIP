<template>
  <div class="chapter-level-2 chapter-level-2-right">
    <chapter-button chapter-name="Потоки ввода-вывода и сериализация объектов" class="theme-level-11-chapter-right"
                    id="java-11-chapter-3-theme"/>
    <div class="theme-level-2 theme-level-2-right">
      <theme-button theme-name="Сохранение и загрузка сериализируемых объектов"
                    path-theme="/language/java/inputoutput/SavingAndLoadingSerializeObject"
                    id="java-11-chapter-3-theme-1-subtheme"/>
      <theme-button theme-name="Представление о формате файлов для сериализации объектов"
                    path-theme="/language/java/inputoutput/DeclarationFormatFileForSerialization"
                    id="java-11-chapter-3-theme-2-subtheme"/>
      <theme-button theme-name="Видоизменение исходного механизма сериализации"
                    path-theme="/language/java/inputoutput/ChangingSourceMechanizmSerialization"
                    id="java-11-chapter-3-theme-3-subtheme"/>
      <theme-button theme-name="Контроль версий"
                    path-theme="/language/java/inputoutput/ControlVertions"
                    id="java-11-chapter-3-theme-4-subtheme"/>
      <theme-button theme-name="Применение сериализации для клонирования"
                    path-theme="/language/java/inputoutput/UseSerializationForClonning"
                    id="java-11-chapter-3-theme-5-subtheme"/>
    </div>
  </div>
</template>

<script>
import ThemeButton from "../../../../Blocks/ThemeButton.vue";
import ChapterButton from "../../../../Blocks/ChapterButton.vue";
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";

export default {
  name: "InputOutputStreamAndSerializable",
  components: {ChapterButton, ThemeButton},
  mounted() {
    const arrowFromChapter11Theme3SubTheme1 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-3-theme-1-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme3SubTheme2 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-3-theme-2-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme3SubTheme3 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-3-theme-3-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme3SubTheme4 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-3-theme-4-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });
    const arrowFromChapter11Theme3SubTheme5 = arrowCreate({
      from: {
        node: () => document.getElementById("java-11-chapter-3-theme"),
        direction: DIRECTION.RIGHT,
      },
      to: {
        node: () => document.getElementById("java-11-chapter-3-theme-5-subtheme"),
        direction: DIRECTION.LEFT,
        translation: [-1, 0]
      },
      head: {
        func: HEAD.VEE,
      },
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme3SubTheme1.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme3SubTheme2.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme3SubTheme3.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme3SubTheme4.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromChapter11Theme3SubTheme5.node);
  }
}
</script>

<style scoped>

</style>