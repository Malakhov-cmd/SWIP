<template>
  <div>
    <div>
      <b-navbar toggleable="lg" type="dark" variant="dark">
        <b-navbar-brand href="#">
          <router-link to="/Home" class="mainNav"> Started </router-link>
        </b-navbar-brand>
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav class="mr-auto">
            <b-nav-item href="#">
              <router-link to="/Language" class="mainNav">Language</router-link>
            </b-nav-item>
            <b-nav-item href="#">
              <router-link to="/IntellectTraining" class="mainNav">Smart training</router-link>
            </b-nav-item>
            <b-nav-item href="#">
              <router-link to="/Message" class="mainNav">Message</router-link>
            </b-nav-item>
            <b-nav-item href="#">
              <router-link to="/Friend" class="mainNav">Friend</router-link>
            </b-nav-item>
            <b-nav-item href="#">
              <router-link to="/Settings" class="mainNav">Settings</router-link>
            </b-nav-item>
          </b-navbar-nav>
          <b-navbar-nav class="ml-auto">
            <b-nav-item href="#">
              <router-link to="/Login" class="mainNav">
                <b-button size="sm" class="my-2 my-sm-0">
                  Login
                </b-button>
              </router-link>
            </b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <b-container>
      <router-view></router-view>
    </b-container>
  </div>
  <div>
    <div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>
    <div v-else>
      <div>{{ profile.name }}&nbsp;<a href="/logout">Выйти</a></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      profile: frontendData.profile
    }
  }
}
</script>

<style scoped>

</style>