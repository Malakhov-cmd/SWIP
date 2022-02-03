<template>
<div class="settings-main">
  <div class="settings-header">
    <p>
      Изменение ваших данных
    </p>
  </div>
  <div class="settings-change">
    <div>
      <b-input-group
          class="mb-3"
          prepend="Username"
      >
        <b-form-input v-model="newNameInputed"
                      :state="checkCorrectName"></b-form-input>
        <b-input-group-append>
          <b-button text="Изменить" v-on:click="changeName" :disabled="!checkCorrectName">Изменить</b-button>
        </b-input-group-append>
      </b-input-group>
    </div>
  </div>

  <div class="settings-privat-info">

  </div>
</div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false

export default {
  name: "SettingsMain",
  computed:{
    checkCorrectName(){
      return this.newNameInputed.length > 5
    }
  },
  data() {
    return {
      profileData: null,
      wallData: null,

      newNameInputed: ""
    }
  },
  methods: {
    changeName(){
      axios.get('http://localhost:9000/data/change/name', {
        params: {
          userId: window.frontendData.profile.id,
          newName: this.newNameInputed
        }
      })
          .then(function (response) {
            window.frontendData.profile = response.data

            isSendedandrecived = true
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {
          isSendedandrecived = false

          this.profileData = window.frontendData.profile
          this.newNameInputed = ""

          this.$toasted.success("Данные успешно изменены", {
            theme: "toasted-primary",
            position: 'top-right',
            duration: 5000,
            fullWidth: false,
            action: {
              text: 'Cancel',
              onClick: (e, toastObject) => {
                toastObject.goAway(0);
              }
            },
          })

          clearInterval(interval)
        }
      }, 200)

    }
  },
  mounted() {
    axios.get('http://localhost:9000/api/userinfo', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          window.frontendData.profile = response.data

          isSendedandrecived = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval = setInterval(() => {
      if (isSendedandrecived) {
        isSendedandrecived = false

        this.profileData = window.frontendData.profile

        clearInterval(interval)
      }
    }, 200)

    axios.get('http://localhost:9000/api/userinfo/wall', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          window.frontendData.wall = response.data

          isSendedandrecived = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const intervalWall = setInterval(() => {
      if (isSendedandrecived) {
        isSendedandrecived = false

        this.wallData = window.frontendData.wall

        clearInterval(intervalWall)
      }
    }, 1000)
  }

}
</script>

<style scoped>

</style>