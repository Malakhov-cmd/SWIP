<template>
  <div id="app" class="h-100">
    <Started/>
  </div>
</template>

<script>
//import axios from "axios";
import Vuetify from "vuetify";
import Started from "../components/Starter.vue";

export default {
  name: 'App',
  vuetify: new Vuetify(),
  components: {
    Started
  }
}
</script>

<style scoped>
#app{
  min-height: 100%;
}
</style>