<template>
  <div class="language-main">
    <b-row class="row-header-language" v-if="isShow">
      <div class="language-header">
        <button v-on:click="chooserContainer(1)" class="java-chooser-btn language-chooser-btn">
          <svg xmlns="http://www.w3.org/2000/svg" width="155" height="155" viewBox="0 0 192.756 192.756">
            <g fill-rule="evenodd" clip-rule="evenodd">
              <path
                  d="M80.372 101.729s-4.604 2.679 3.28 3.584c9.554 1.091 14.434.934 24.959-1.057 0 0 2.771 1.735 6.639 3.236-23.601 10.113-53.413-.585-34.878-5.763zM77.487 88.532s-5.165 3.823 2.726 4.639c10.206 1.054 18.262 1.14 32.211-1.544 0 0 1.926 1.955 4.957 3.023-28.531 8.345-60.307.657-39.894-6.118z"
                  fill="#3174b9"/>
              <path
                  d="M101.797 66.143c5.818 6.697-1.525 12.72-1.525 12.72s14.766-7.621 7.984-17.168c-6.332-8.899-11.189-13.32 15.102-28.566-.001-.001-41.27 10.303-21.561 33.014z"
                  fill="#ca3132"/>
              <path
                  d="M133.01 111.491s3.408 2.81-3.754 4.983c-13.619 4.125-56.694 5.369-68.659.164-4.298-1.872 3.766-4.467 6.303-5.015 2.646-.572 4.156-.468 4.156-.468-4.783-3.368-30.916 6.615-13.272 9.479 48.112 7.801 87.704-3.512 75.226-9.143zM82.587 74.857s-21.908 5.205-7.757 7.097c5.977.799 17.883.615 28.982-.316 9.068-.761 18.17-2.389 18.17-2.389s-3.195 1.371-5.51 2.949c-22.251 5.853-65.229 3.127-52.855-2.856 10.462-5.061 18.97-4.485 18.97-4.485zM121.891 96.824c22.617-11.75 12.16-23.044 4.859-21.522-1.785.373-2.586.695-2.586.695s.666-1.042 1.932-1.49c14.441-5.075 25.545 14.972-4.656 22.911-.001 0 .347-.314.451-.594z"
                  fill="#3174b9"/>
              <path
                  d="M108.256 8.504s12.523 12.531-11.881 31.794c-19.571 15.458-4.462 24.269-.006 34.34-11.426-10.307-19.807-19.382-14.185-27.826 8.254-12.395 31.125-18.406 26.072-38.308z"
                  fill="#ca3132"/>
              <path
                  d="M84.812 128.674c21.706 1.388 55.045-.771 55.836-11.044 0 0-1.518 3.894-17.941 6.983-18.529 3.488-41.386 3.082-54.938.845 0 0 2.777 2.298 17.043 3.216z"
                  fill="#3174b9"/>
              <path
                  d="M139.645 147.096h-.66v-.37h1.781v.37h-.66v1.848h-.461v-1.848zm3.554.092h-.008l-.656 1.755h-.301l-.652-1.755h-.008v1.755h-.438v-2.218h.643l.604 1.569.604-1.569h.637v2.218h-.424v-1.755h-.001zM81.255 167.921c-2.047 1.774-4.211 2.772-6.154 2.772-2.768 0-4.27-1.663-4.27-4.324 0-2.881 1.608-4.989 8.044-4.989h2.379v6.541h.001zm5.65 6.374v-19.732c0-5.043-2.876-8.371-9.809-8.371-4.045 0-7.591.999-10.474 2.272l.83 3.495c2.271-.834 5.207-1.607 8.089-1.607 3.994 0 5.713 1.607 5.713 4.934v2.495h-1.996c-9.702 0-14.08 3.764-14.08 9.423 0 4.876 2.885 7.648 8.316 7.648 3.491 0 6.099-1.441 8.534-3.55l.443 2.993h4.434zM105.762 174.295h-7.045l-8.483-27.601h6.154l5.265 16.961 1.172 5.096c2.656-7.371 4.541-14.854 5.484-22.057h5.984c-1.602 9.088-4.488 19.066-8.531 27.601zM132.799 167.921c-2.053 1.774-4.217 2.772-6.156 2.772-2.768 0-4.268-1.663-4.268-4.324 0-2.881 1.609-4.989 8.041-4.989h2.383v6.541zm5.652 6.374v-19.732c0-5.043-2.885-8.371-9.811-8.371-4.049 0-7.594.999-10.477 2.272l.83 3.495c2.271-.834 5.213-1.607 8.096-1.607 3.988 0 5.709 1.607 5.709 4.934v2.495h-1.996c-9.703 0-14.078 3.764-14.078 9.423 0 4.876 2.879 7.648 8.311 7.648 3.494 0 6.098-1.441 8.539-3.55l.445 2.993h4.432zM58.983 178.985c-1.61 2.353-4.214 4.216-7.061 5.267l-2.79-3.286c2.169-1.113 4.027-2.91 4.892-4.582.745-1.49 1.056-3.406 1.056-7.992v-31.515h6.005v31.08c0 6.134-.49 8.613-2.102 11.028z"
                  fill="#ca3132"/>
            </g>
          </svg>
        </button>
        <button v-on:click="chooserContainer(2)" class="kotlin-chooser-btn language-chooser-btn">
          <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
               width="125" height="125">
            <linearGradient id="c" gradientTransform="rotate(-45 32051.159 -83912.245) scale(31.584)"
                            gradientUnits="userSpaceOnUse" x1="-1582" x2="-1581" y1="-1495.328" y2="-1495.328">
              <stop offset="0" stop-color="#c757bc"/>
              <stop offset=".108" stop-color="#c757bc"/>
              <stop offset=".173" stop-color="#cd5ca9"/>
              <stop offset=".492" stop-color="#e8744f"/>
              <stop offset=".716" stop-color="#f88316"/>
              <stop offset=".823" stop-color="#ff8900"/>
              <stop offset="1" stop-color="#ff8900"/>
            </linearGradient>
            <linearGradient id="a">
              <stop offset="0" stop-color="#00afff"/>
              <stop offset=".296" stop-color="#00afff"/>
              <stop offset=".694" stop-color="#5282ff"/>
              <stop offset="1" stop-color="#945dff"/>
            </linearGradient>
            <linearGradient id="d" gradientTransform="rotate(-45 15635.387 -40897.94) scale(15.3946)"
                            gradientUnits="userSpaceOnUse" x1="-1582" x2="-1581" xlink:href="#a" y1="-1494.622"
                            y2="-1494.622"/>
            <linearGradient id="e" gradientTransform="matrix(7.6364 -7.6366 7.6366 7.6364 23489.887 -665.412)"
                            gradientUnits="userSpaceOnUse" x1="-1582" x2="-1581" xlink:href="#a" y1="-1494.036"
                            y2="-1494.036"/>
            <linearGradient id="f" gradientTransform="rotate(-45 32051.159 -83912.245) scale(31.584)"
                            gradientUnits="userSpaceOnUse" x1="-1582" x2="-1581" y1="-1495.322" y2="-1495.322">
              <stop offset="0" stop-color="#ad4ca4"/>
              <stop offset=".108" stop-color="#ad4ca4"/>
              <stop offset=".173" stop-color="#b25093"/>
              <stop offset=".492" stop-color="#ca6545"/>
              <stop offset=".716" stop-color="#d87213"/>
              <stop offset=".823" stop-color="#de7700"/>
              <stop offset="1" stop-color="#de7700"/>
            </linearGradient>
            <linearGradient id="b">
              <stop offset="0" stop-color="#0098de"/>
              <stop offset=".296" stop-color="#0098de"/>
              <stop offset=".694" stop-color="#4771de"/>
              <stop offset="1" stop-color="#8151de"/>
            </linearGradient>
            <linearGradient id="g" gradientTransform="rotate(-45 15635.387 -40897.94) scale(15.3946)"
                            gradientUnits="userSpaceOnUse" x1="-1582" x2="-1581" xlink:href="#b" y1="-1494.622"
                            y2="-1494.622"/>
            <linearGradient id="h" gradientTransform="matrix(7.6364 -7.6366 7.6366 7.6364 23489.887 -665.412)"
                            gradientUnits="userSpaceOnUse" x1="-1582" x2="-1581" xlink:href="#b" y1="-1493.643"
                            y2="-1493.643"/>
            <path d="M24 0H12.05L.639 12h11.34l.053-.054z" fill="url(#c)"/>
            <path d="M24 24H0zM12.032 11.946l-.053.054h.107z" fill="url(#d)"/>
            <path d="M12.05 0H0v12.672V12h.639z" fill="url(#e)"/>
            <path d="M11.979 12H.639L0 12.672V24z" fill="url(#f)"/>
            <path d="M12.086 12h-.107L0 24h24z" fill="url(#g)"/>
            <path d="M.639 12H0v.672z" fill="url(#h)"/>
          </svg>
        </button>
        <button v-on:click="chooserContainer(3)" class="js-chooser-btn language-chooser-btn">
          <svg fill="none" height="125" width="125" xmlns="http://www.w3.org/2000/svg"
               viewBox="0 0 124 141.53199999999998">
            <path d="M10.383 126.894L0 0l124 .255-10.979 126.639-50.553 14.638z" fill="#e9ca32"/>
            <path d="M62.468 129.277V12.085l51.064.17-9.106 104.851z" fill="#ffde25"/>
            <g fill="#fff">
              <path
                  d="M57 26H43.5v78L33 102V91.5l-12.5-2V113l36.5 9.5zM67.127 26H104.5L102 40.95H81.394v24.533H102L99.5 115l-32.373 7.5V107L89 99.5 90.263 79l-23.136 3.35z"/>
            </g>
          </svg>
        </button>
      </div>
    </b-row>
    <div class="map-options">
      <div class="map-options-zoom">
        <div id="btn_zoomin" class="map-options-zoom-in" v-on:click="zoomIn">
          <div class="icon-svg" data-icon="plus" data-color="blue" data-size="14">
            <div class="svg-icon">
              <svg class="maxw-100% icon-plus" viewBox="0 0 12 12" style="fill:#00AAFF; height:14px; width:14px;">
                <g fill-rule="evenodd">
                  <rect width="2" height="12" x="5" rx="1"></rect>
                  <rect width="12" height="2" y="5" rx="1"></rect>
                </g>
              </svg>
            </div>
          </div>
        </div>
        <div id="btn_zoomout" class="map-options-zoom-out" v-on:click="zoomOut">
          <div class="icon-svg" data-icon="minus" data-color="blue" data-size="14">
            <div class="svg-icon">
              <svg class="maxw-100% icon-minus" viewBox="0 0 23 23" style="fill:#00AAFF; height:14px; width:14px;">
                <path d="M0 9.566h22.32v3.189H0z"></path>
              </svg>
            </div>
          </div>
        </div>
      </div>
      <div id="btn_recenter" class="map-option-centering" v-on:click="centered">
        <div class="icon-svg" data-icon="align-center" data-color="blue" data-size="20">
          <div class="svg-icon">
            <svg class="maxw-100% icon-align-center" viewBox="0 0 23 23" style="fill:#00AAFF; height:20px; width:20px;">
              <path fill-rule="nonzero" d="M11.5 14.95a3.45 3.45 0 10-.001-6.901 3.45 3.45 0 00.001 6.901z"></path>
              <path
                  d="M12.077 2.61c.26.016.52.043.78.082a8.904 8.904 0 012.41.73 8.996 8.996 0 014.118 3.925c.41.774.7 1.608.866 2.467.07.366.12.737.15 1.11H23v1.153h-2.608a8.836 8.836 0 01-.861 3.286 8.92 8.92 0 01-4.66 4.389c-.89.363-1.83.578-2.79.64V23h-1.15v-2.608a8.94 8.94 0 01-2.79-.64 8.977 8.977 0 01-2.78-1.802 8.89 8.89 0 01-1.88-2.587 8.795 8.795 0 01-.793-2.618c-.03-.222-.054-.445-.07-.668H0v-1.154h2.608c.024-.372.07-.743.14-1.11a8.907 8.907 0 01.867-2.466 8.991 8.991 0 014.12-3.925 8.861 8.861 0 013.188-.813V0h1.154v2.61zm-.67 1.7c-.336.007-.67.033-1.003.083-.67.103-1.326.3-1.94.59A7.238 7.238 0 005.22 7.998a7.173 7.173 0 00-.852 4.419c.093.733.3 1.45.614 2.12a7.208 7.208 0 003.72 3.587 7.182 7.182 0 002.705.565 7.29 7.29 0 002.73-.5 7.26 7.26 0 002.26-1.43 7.164 7.164 0 002.21-4.17c.12-.788.11-1.59-.03-2.37a7.132 7.132 0 00-.674-2 7.225 7.225 0 00-5.128-3.807 7.77 7.77 0 00-1.367-.112z"></path>
            </svg>
          </div>
        </div>
      </div>
    </div>
    <div class="language-container" id="language-container-id">
      <div v-if="chooser===1">
        <java-language @scrolldown="onscrollDownJava"></java-language>
      </div>
      <div v-if="chooser===2">
        <kotlin-language></kotlin-language>
      </div>
      <div v-if="chooser===3">
        <j-s-language></j-s-language>
      </div>
    </div>
  </div>
</template>

<script>
import JavaLanguage from "./Java/JavaLanguage.vue";
import KotlinLanguage from "./Kotlin/KotlinLanguage.vue";
import JSLanguage from "./JS/JSLanguage.vue";

export default {
  name: "LanguageMain",
  components: {JavaLanguage, KotlinLanguage, JSLanguage},
  data: function () {
    return {
      chooser: 1,
      isShow: true,
      scale: 1,
      margining: 50
    }
  },
  methods: {
    chooserContainer(a) {
      if (a === 1) {
        this.chooser = 1
      }
      if (a === 2) this.chooser = 2
      if (a === 3) this.chooser = 3
    },
    onscrollDownJava(value) {
      this.isShow = value !== false;
    },
    zoomIn() {
      if (this.margining < 300) {
        this.scale < 1 ? this.scale = 1 : this.scale += 0.5
        this.margining += 50
        let chapterBtns = document.getElementsByClassName('my-b-btn')
        for (let i = 0; i < chapterBtns.length; i++) {
          let oldStyles = chapterBtns.item(i).getAttribute('style')
          chapterBtns.item(i).setAttribute("style", oldStyles + "transform: scale(" + this.scale + ");" +
              "margin: " + this.margining + "px;");
        }
      }
    },
    zoomOut() {
      if (this.scale > 1) {
        this.scale -= 0.5
        this.margining -= 50
        let chapterBtns = document.getElementsByClassName('my-b-btn')
        for (let i = 0; i < chapterBtns.length; i++) {
          let oldStyles = chapterBtns.item(i).getAttribute('style')
          chapterBtns.item(i).setAttribute("style", oldStyles + "transform: scale(" + this.scale + ");" +
              "margin: " + this.margining + "px;");
        }
      } else {
        if (this.scale > 0.3) {
          this.scale -= 0.2
          this.margining > 0 ? this.margining -= 20 : this.margining = 0
          let chapterBtns = document.getElementsByClassName('my-b-btn')
          for (let i = 0; i < chapterBtns.length; i++) {
            let oldStyles = chapterBtns.item(i).getAttribute('style')
            chapterBtns.item(i).setAttribute("style", oldStyles + "transform: scale(" + this.scale + ");" +
                "margin: " + this.margining + "px;");
          }
        }
      }
    },
    centered() {
      let container = document.getElementsByClassName('language-main-row-content').item(0)

      let themeToClose = document.getElementById('center-btn-language-name');

      let topPosOfClosingElement = themeToClose.offsetTop;
      let leftPosOfClosingElement = themeToClose.offsetLeft;

      const pageWidth = document.documentElement.scrollWidth
      const pageHeight = document.documentElement.scrollHeight

      if(pageWidth > leftPosOfClosingElement) {
        container.scrollTo(0, topPosOfClosingElement - pageHeight / 2)
      } else {
        container.scrollTo(leftPosOfClosingElement - pageWidth, topPosOfClosingElement - pageHeight / 2)
      }
    }
  },
  mounted() {
    this.$eventBus.$on('redirectToJavaRoad', this.chooserContainer(1))
  },
  beforeCreate() {
    window.frontendData.language.chapters.sort(function (a, b) {
      if (a.numberChapter > b.numberChapter) {
        return 1;
      }
      if (a.numberChapter < b.numberChapter) {
        return -1;
      }
      return 0;
    });

    for (let i = 0; i < 8; i++) {
      window.frontendData.language.chapters[i].listThemes.sort(function (a, b) {
        if (a.number > b.number) {
          return 1;
        }
        if (a.number < b.number) {
          return -1;
        }
        return 0;
      });
    }
  }
}
</script>

<style scoped>

</style>