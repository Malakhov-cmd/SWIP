<template>
  <div class="friend-main">
    <div class="friend-finder">
      <div class="friend-finder-input">
        <b-button class="btn-find-friend-collapsed my-b-btn"
                  v-b-toggle.collapse-1>
          Поиск друзей
        </b-button>
        <b-collapse id="collapse-1" class="mt-2">
          <div class="neomorphism friend-finder-input-neo">
            <div class="friend-finder-by-name">
              <b-form-input
                  class="friend-finder-input"
                  id="input-live-name"
                  v-model="nameFeatureFriend"
                  :state="nameState"
                  aria-describedby="input-live-feedback-name"
                  placeholder="Введите имя друга"
                  trim
              ></b-form-input>

              <!-- This will only be shown if the preceding input has an invalid state -->
              <b-form-invalid-feedback id="input-live-feedback-name">
                Имя не может быть пустым
              </b-form-invalid-feedback>

              <b-btn class="my-b-btn" v-on:click="requestFindFriendByName()">
                Поиск по имени
              </b-btn>
            </div>
            <div class="friend-finder-by-name">
              <b-form-input
                  class="friend-finder-input"
                  id="input-live-id"
                  v-model="idFeatureFriend"
                  :state="idState"
                  aria-describedby="input-live-feedback-id"
                  placeholder="Введите google id друга"
                  trim
              ></b-form-input>

              <!-- This will only be shown if the preceding input has an invalid state -->
              <b-form-invalid-feedback id="input-live-feedback-id">
                Идентификатор не может быть пустым
              </b-form-invalid-feedback>
            </div>

            <b-btn class="my-b-btn" v-on:click="requestFindFriendById()">
              Поиск по id
            </b-btn>
          </div>
        </b-collapse>
      </div>
      <div class="finded-potential-friend"
      v-show="potentialFriendFinded">
       {{findedUser}}
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false
let potentialFriend = []

export default {
  name: "FriendMain",
  computed: {
    nameState() {
      return this.nameFeatureFriend.length > 0
    },
    idState() {
      return this.nameFeatureFriend.length > 0
    }
  },
  data() {
    return {
      nameFeatureFriend: '',
      idFeatureFriend: '',
      findedUser: [],

      potentialFriendFinded: false
    }
  },
  methods: {
    requestFindFriendByName() {
      axios.get('http://localhost:9000/home/friend/find/name', {
        params: {
          friendName: this.nameFeatureFriend
        }
      })
          .then(function (response) {
            potentialFriend = response.data
            isSendedandrecived = true
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {
          console.log(potentialFriend)

          this.potentialFriendFinded = potentialFriend

          this.filterFriend()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestFindFriendById() {
      axios.get('http://localhost:9000/home/friend/find/id', {
        params: {
          friendId: this.idFeatureFriend
        }
      })
          .then(function (response) {
            potentialFriend = response.data
            isSendedandrecived = true
          })
          .catch(function (error) {
            console.log(error);
          })
      const interval = setInterval(() => {
        if (isSendedandrecived) {
          console.log(potentialFriend)

          this.potentialFriendFinded = potentialFriend

          this.filterFriend()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    filterFriend(){
      for (let i = 0; i < potentialFriend.length; i++) {
        if (potentialFriend[i].id !== window.frontendData.profile.id){
          this.findedUser[i] = potentialFriend[i]
        }
      }
      if (this.findedUser.length > 0){
        this.potentialFriendFinded = true
      }
    }
  },
  mounted() {

  }
}
</script>

<style scoped>

</style>