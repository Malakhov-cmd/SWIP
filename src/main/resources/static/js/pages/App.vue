<template>
  <div id="app">
    <Started/>
  </div>
</template>

<script>
//import axios from "axios";
import Vuetify from "vuetify";
import Started from "../components/Starter.vue";
import axios from "axios";

export default {
  name: 'App',
  vuetify: new Vuetify(),
  data() {
    return {
      data: null
    }
  },
  components: {
    Started
  },
  mounted() {
    console.log("first")



    axios.get('http://localhost:9000/api/userinfo', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          console.log(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
  }
}
</script>

<style scoped>
#app{
  min-height: 100vh;
}
</style>