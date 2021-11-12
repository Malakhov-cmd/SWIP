<template>
  <b-row class="language-main-row">
    <div class="language-main-row-content">
      <v-fab-transition>
        <router-link to="/language/kotlin/1" class="btn-language-chapter" tag="button" v-show="!hidden">
          <b-btn class="my-b-btn">Function
            <v-icon>mdi-plus</v-icon>
          </b-btn>
        </router-link>
      </v-fab-transition>
      <b-btn
          class="btn-language-name my-b-btn"
          @click="hidden = !hidden"
      >
        Kotlin
      </b-btn>
      <v-fab-transition>
        <b-btn class="my-b-btn"
            v-show="!hidden"
        >
          Operands
          <v-icon>mdi-plus</v-icon>
        </b-btn>
      </v-fab-transition>
    </div>
  </b-row>
</template>

<script>
export default {
  data: () => ({
    hidden: false,
  }),
  mounted() {
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
  }
}
</script>

<style scoped>

</style>