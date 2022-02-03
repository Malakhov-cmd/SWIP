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
            <b-button text="Изменить" v-on:click="changeName"
                      :disabled="!checkCorrectName">Изменить</b-button>
          </b-input-group-append>
        </b-input-group>
      </div>

      <div>
        <b-input-group
            class="mb-3"
            prepend="Avatar link"
        >
          <b-form-input v-model="linkToPictureInputed"
                        :state="checkCorrectLink"></b-form-input>
          <b-input-group-append>
            <b-button text="Изменить" v-on:click="changeLink"
                      :disabled="!checkCorrectLink">Изменить</b-button>
          </b-input-group-append>
        </b-input-group>
      </div>

      <div>
        <b-input-group
            class="mb-3"
            prepend="О себе"
        >
          <b-form-input v-model="aboutSelfInputed"
                        :state="checkCorrectSelfDescription"></b-form-input>
          <b-input-group-append>
            <b-button text="Изменить" v-on:click="changeSelfDescription"
                      :disabled="!checkCorrectSelfDescription">Изменить</b-button>
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
  computed: {
    checkCorrectName() {
      return this.newNameInputed.length > 5 && this.newNameInputed.length < 128
    },
    checkCorrectLink() {
      return this.linkToPictureInputed.length > 10 && this.linkToPictureInputed.length < 4000
    },
    checkCorrectSelfDescription(){
      return this.aboutSelfInputed.length > 4 && this.aboutSelfInputed.length < 4000
    }
  },
  data() {
    return {
      profileData: null,
      wallData: null,

      newNameInputed: "",
      linkToPictureInputed: "",
      aboutSelfInputed: ""
    }
  },
  methods: {
    changeName() {
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

          if (this.profileData.name !== window.frontendData.profile.name) {

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
          } else {
            this.$toasted.error("Данные не изменены, убедитесь в корректности заполнения", {
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
          }

          clearInterval(interval)
        }
      }, 200)
    },
    changeLink() {
      axios.get('http://localhost:9000/data/change/img', {
        params: {
          userId: window.frontendData.profile.id,
          newIngLink: this.linkToPictureInputed
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

          if (this.profileData.userpic !== window.frontendData.profile.userpic) {

            this.profileData = window.frontendData.profile
            this.linkToPictureInputed = ""

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
          } else {
            this.$toasted.error("Данные не изменены, убедитесь в корректности заполнения", {
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
          }
          clearInterval(interval)
        }
      }, 200)
    },
    changeSelfDescription() {
      axios.get('http://localhost:9000/data/change/self/description', {
        params: {
          userId: window.frontendData.profile.id,
          newDescription: this.aboutSelfInputed
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

          if (this.profileData.selfDescription !== window.frontendData.profile.selfDescription) {

            this.profileData = window.frontendData.profile
            this.aboutSelfInputed = ""

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
          } else {
            this.$toasted.error("Данные не изменены, убедитесь в корректности заполнения", {
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
          }
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