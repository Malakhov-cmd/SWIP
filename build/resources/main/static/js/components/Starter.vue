<template>
  <div class="d-flex w-100 p-3 mx-auto flex-column cover-container">
    <header class="mb-auto">
      <div class="header-cls">
        <h3 class="float-md-start mb-0">SWIP</h3>
        <nav class="nav nav-masthead justify-content-center float-md-end">
          <a class="nav-link active" aria-current="page" href="">
            <router-link to="/info" class="mainNav"> Info </router-link>
          </a>
          <a class="nav-link active" href="#">
            <router-link to="/Language" class="mainNav">Language</router-link>
          </a>
          <a class="nav-link active" href="#">
            <router-link to="/home" class="mainNav">Home</router-link>
          </a>
          <a class="nav-link active" aria-current="page" href="#">
            <router-link to="/Message" class="mainNav">Message</router-link>
          </a>
          <a class="nav-link active" href="#">
            <router-link to="/Friend" class="mainNav">Friends</router-link>
          </a>
          <a class="nav-link active">
            <router-link to="/statistic" class="mainNav">Statistic</router-link>
          </a>
          <a class="nav-link active" href="#">
            <router-link to="/Settings" class="mainNav">Settings</router-link>
          </a>
        </nav>
        <div>
               <span class="usrname navbar-text">

                               </span>
          <button class="logoutBtn btn btn-outline-success my-2 my-sm-0" onclick="document.location='/logout'" type="submit">Logout</button>
        </div>
      </div>
    </header>
    <main class="px-3 root-main">
      <b-container>
        <router-view></router-view>
      </b-container>
    </main>
    <footer class="mt-auto text-white-50 footer">
      <p>Created and developed with love, by <a
          href="https://github.com/Malakhov-cmd" class="text-white">@Malakhov-cmd</a>.</p>
    </footer>
  </div>
</template>

<script>
import Vue from 'vue'
import VueRouter from "vue-router"

Vue.use(VueRouter)

export default {
  name: "Starter"
}
</script>

<style scoped>

</style>