<template>
  <b-row class="language-main-row" id="language-main-row-content">
    <b-overlay :show="show" rounded="sm">

      <div class="language-main-row-content" v-on:scroll="funk()" :aria-hidden="show ? 'true' : null">
        <div class="chapter-left-side" id="java-left-side-roadmap">
          <IntroduceInJava/>
          <LanguageConstructions/>
          <o-o-p/>
          <inheritance/>
          <interface-lyambda-and-inner/>
          <exeption/>
          <generic-programming/>
          <collections/>
        </div>
        <div>
          <b-btn
              id="center-btn-language-name"
              class="btn-language-name my-b-btn"
              data-toggle="popover"
          >
            Java
          </b-btn>
        </div>
        <div class="chapter-right-side">
          <threads/>
          <streams/>
          <annotation/>
          <modules/>
        </div>
      </div>

      <template #overlay>
        <div class="text-center">
          <b-icon icon="stopwatch" font-scale="3" animation="cylon"></b-icon>
          <p>Подождите...</p>
          <p>Происходит оптимизация roadmap под размеры вашего экрана.</p>
        </div>
      </template>

    </b-overlay>

  </b-row>
</template>

<script>
import arrowCreate, {HEAD, DIRECTION} from "arrows-svg";
import ThemeButton from "../Blocks/ChapterButton.vue";
import IntroduceInJava from "./Chapter/1Introduce/IntroduceInJava.vue";
import LanguageConstructions from "./Chapter/2LanguageConstruction/LanguageConstructions.vue";
import OOP from "./Chapter/3OOP/OOP.vue";
import Inheritance from "./Chapter/4Inheritance/Inheritance.vue";
import InterfaceLyambdaAndInner from "./Chapter/5interfaceLyambdaAndInner/InterfaceLyambdaAndInner.vue";
import Exeption from "./Chapter/6Exeption/Exeption.vue";
import GenericProgramming from "./Chapter/7GenericProgramming/GenericProgramming.vue";
import Collections from "./Chapter/8Collections/Collections.vue";
import Threads from "./Chapter/9Threads/Threads.vue";
import Streams from "./Chapter/10Streams/Streams.vue";
import Annotation from "./Chapter/13Annotation/Annotation.vue";
import Modules from "./Chapter/14Modules/Modules.vue";

export default {
  components: {
    Modules,
    Annotation,
    Streams,
    Threads,
    Collections,
    GenericProgramming,
    Exeption,
    InterfaceLyambdaAndInner,
    Inheritance,
    OOP,
    LanguageConstructions,
    IntroduceInJava,
    ThemeButton
  },
  data() {
    return {
      dialog: false,
      showLogos: true,
      show: true
    }

  },
  methods: {
    funk() {
      var mainContainer = document.getElementsByClassName("language-main-row-content").item(0)
      var mainrowContainer = document.getElementsByClassName("language-main-row").item(0)
      if (mainContainer.scrollTop > 125) {
        this.$emit('scrolldown', false)
        mainContainer.style = 'max-height: 80vh;'
        mainrowContainer.style = 'max-height: 80vh;'
      } else {
        this.$emit('scrolldown', true)
        mainContainer.style = 'max-height: 70vh;'
        mainrowContainer.style = 'max-height: 70vh;'
      }
    }
  },
  mounted() {
    setTimeout(() => {
      this.show = false

      let container = document.getElementsByClassName('language-main-row-content').item(0)
      if (container != null)
        container.scrollBy(1, 1)
    }, 4000)

    var scr = $(".language-main-row-content");
    scr.mousedown(function () {
      var startX = this.scrollLeft + event.pageX;
      var startY = this.scrollTop + event.pageY;
      scr.mousemove(function () {
        this.scrollLeft = startX - event.pageX;
        this.scrollTop = startY - event.pageY;
        return false;
      });
    });
    $(window).mouseup(function () {
      scr.off("mousemove");
    });

    const arrowFromCentralBtnToHeadOFFirstChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-1chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });

    const arrowFromCentralBtnToHeadOFSecondChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-2chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });

    const arrowFromCentralBtnToHeadOFThirdChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-3chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });

    const arrowFromCentralBtnToHeadOFFourthChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-4chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFFifthChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-5chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFSixChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-6chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFSevenChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-7chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFEightChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-8chapter"),
        translation: [1, 0],
        direction: DIRECTION.RIGHT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFNineChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-9chapter"),
        translation: [-1, 0],
        direction: DIRECTION.LEFT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFTenChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-10chapter"),
        translation: [-1, 0],
        direction: DIRECTION.LEFT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFThirtinChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-13chapter"),
        translation: [-1, 0],
        direction: DIRECTION.LEFT,
      },
      head: {
        func: HEAD.VEE,
      }
    });
    const arrowFromCentralBtnToHeadOFFourtinChapter = arrowCreate({
      from: document.getElementById("center-btn-language-name"),
      to: {
        node: () => document.getElementById("central-btn-14chapter"),
        translation: [-1, 0],
        direction: DIRECTION.LEFT,
      },
      head: {
        func: HEAD.VEE,
      }
    });

    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFFirstChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFSecondChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFThirdChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFFourthChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFFifthChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFSixChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFSevenChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFEightChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFNineChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFTenChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFThirtinChapter.node);
    document.getElementById("language-main-row-content").appendChild(arrowFromCentralBtnToHeadOFFourtinChapter.node);

    //Отображение общей информации в popover
    $(document).ready(function () {
      let dataPopover = `С уэтого места начинается ваш путь, удачи`
      $("#center-btn-language-name").popover({
        title: '<h4 class="custom-title"><div class="popover-head-text">Приветствие</div></h4>',
        content: '<div class="popover-body"><div class="popover-body-text">' + dataPopover + '</div></div>',
        trigger: 'hover',
        placement: 'right',
        html: true
      });
    });
  },
  beforeDestroy() {
    let massiveArrows = document.getElementsByClassName("arrow")
    for (let i = 0; i < massiveArrows.length; i++) {
      document.getElementById("language-main-row-content").removeChild(massiveArrows.item(i))
    }

  }
}
</script>

<style scoped>

</style>