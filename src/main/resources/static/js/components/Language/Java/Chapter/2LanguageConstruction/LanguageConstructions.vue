<template>
  <div class="chapter-level-1">
    <div class="theme-level-1">
      <ThemeButton theme-name="Пример простой программы" path-theme="/language/java/languageconstruction/simpleprogramexample"/>
      <ThemeButton theme-name="Комментарии" path-theme="/language/java/languageconstruction/comments"/>
      <DataType/>
      <TempAndConstant/>
      <Operation/>
      <SymbolStr/>
      <InputAndOutput/>
      <ManageLogic/>
      <theme-button theme-name="Большие числа " path-theme="/language/java/languageconstruction/bigdigit"/>
      <Arrays/>
    </div>
    <ChapterButton chapter-name="Языковые конструкции" class="theme-level-1-chapter-left"/>
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

export default {
  name: "LanguageConstructions",
  components: {
    Arrays,
    ManageLogic, InputAndOutput, SymbolStr, Operation, TempAndConstant, ChapterButton, DataType, ThemeButton},

}
</script>

<style scoped>

</style>