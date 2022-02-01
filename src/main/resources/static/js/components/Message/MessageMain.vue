<template>
  <div class="message-main">
    <div class="creation-chat">
      <div class="creation-chat-find-people">
        <div class="friend-finder-input">
          <b-button class="btn-find-friend-collapsed my-b-btn"
                    v-b-toggle.collapse-1>
            Поиск пользователей
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

                <b-btn class="my-b-btn" v-on:click="requestFindUsersByName()">
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

              <b-btn class="my-b-btn" v-on:click="requestFindUserById()">
                Поиск по id
              </b-btn>
            </div>

            <div class="finded-potential-friend"
                 v-show="potentialFriendFinded">
              <div class="finded-potential-friend-list" id="finded-potential-friend-list-id"
                   v-for="(value, index) in potentialFriendFinded? findedUser: null">
                <div class="finded-potential-friend-item neomorphism">
                  <div class="finded-potential-friend-item-header">
                    <div class="finded-potential-friend-item-header-personal-data">
                      <img class="profile-post-header-author-info-avatar-img"
                           width="75" height="75"
                           :srcset="value.userpic"/>
                      <div class="finded-potential-friend-item-header-name">
                        {{ value.name }}
                      </div>
                    </div>
                    <div class="finded-potential-friend-item-buttons">
                      <b-btn class="like-button profile-post-footer-icons"
                             v-on:click="addToGroupChatFromSearch(value.id)">
                        <b-icon-plus-square-fill font-scale="2"></b-icon-plus-square-fill>
                      </b-btn>
                    </div>
                  </div>
                </div>

                <div class="pagination-to-potentional-friend">
                  <b-pagination
                      v-model="currentPage"
                      :total-rows="rows"
                      :per-page="perPage"
                      aria-controls="finded-potential-friend-list-id"
                  ></b-pagination>
                </div>
              </div>

              <div class="dialog-finded-user-added-list">
                <b-btn class="my-b-btn"
                       v-on:click="requestCreateChat()">
                  Создать чат <b-badge variant="light">{{addedToCreationGroupChat.length}}</b-badge>
                </b-btn>
              </div>

            </div>
          </b-collapse>
        </div>
      </div>

      <div class="creation-chat-find-people">
        <div class="friend-finder-input">
          <b-button class="btn-find-friend-collapsed my-b-btn"
                    v-b-toggle.collapse-2>
            Список друзей
          </b-button>
          <b-collapse id="collapse-2" class="mt-2">

            <div class="finded-potential-friend"
                 v-show="myFriends.length> 0">
              <div class="finded-potential-friend-list" id="friend-list-id"
                   v-for="(value, index) in myFriends.length> 0? myFriends: null">
                <div class="finded-potential-friend-item neomorphism">
                  <div class="finded-potential-friend-item-header">
                    <div class="finded-potential-friend-item-header-personal-data">
                      <img class="profile-post-header-author-info-avatar-img"
                           width="75" height="75"
                           :srcset="value.frienduserpic"/>
                      <div class="finded-potential-friend-item-header-name">
                        {{ value.friendname }}
                      </div>
                    </div>
                    <div class="finded-potential-friend-item-buttons">
                      <b-btn class="like-button profile-post-footer-icons"
                             v-on:click="addToGroupChatFromFriendList(value.friendId)">
                        <b-icon-plus-square-fill font-scale="2"></b-icon-plus-square-fill>
                      </b-btn>
                    </div>
                  </div>
                </div>

                <div class="pagination-to-potentional-friend">
                  <b-pagination
                      v-model="currentPage"
                      :total-rows="rowsFriendList"
                      :per-page="perPage"
                      aria-controls="friend-list-id"
                  ></b-pagination>
                </div>
              </div>

            </div>
            <div class="no-friends-exist" v-show="myFriends.length === 0">
              <p v-show="addedToCreationGroupChat.length === 0">У вас пока нет друзей</p>
              <p v-show="addedToCreationGroupChat.length > 0">Вы добавли всех друзей</p>
            </div>

            <div class="dialog-finded-user-added-list">
              <b-btn class="my-b-btn"
                     v-on:click="requestCreateChat()">
                Создать чат <b-badge variant="light">{{addedToCreationGroupChat.length}}</b-badge>
              </b-btn>
            </div>
          </b-collapse>
        </div>
      </div>

    </div>
    <div class="chats">

    </div>
  </div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false

//массивы для потоковой обработки
let potentialFriend = []

export default {
  name: "MessageMain",
  computed: {
    nameState() {
      return this.nameFeatureFriend.length > 0
    },
    idState() {
      return this.nameFeatureFriend.length > 0
    },
    rows() {
      return this.findedUser.length
    },
    rowsFriendList() {
      return this.myFriends.length
    }
  },
  data() {
    return {
      profileData: null,

      nameFeatureFriend: '',
      idFeatureFriend: '',

      perPage: 5,
      currentPage: 1,
      findedUser: [],
      myFriends: [],
      addedToCreationGroupChat: [],

      potentialFriendFinded: false
    }
  },
  methods: {
    requestFindUsersByName() {
      this.potentialFriendFinded = false
      axios.get('http://localhost:9000/dialog/find/name', {
        params: {
          userId: window.frontendData.profile.id,
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

          this.findedUser = potentialFriend

          if (this.findedUser.length > 0) {
            this.potentialFriendFinded = true
          }

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestFindUserById() {
      this.potentialFriendFinded = false
      axios.get('http://localhost:9000/dialog/find/id', {
        params: {
          userId: window.frontendData.profile.id,
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
          this.findedUser = potentialFriend

          if (this.findedUser.length > 0) {
            this.potentialFriendFinded = true
          }

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestCreateChat() {
      this.potentialFriendFinded = false

      axios.get('http://localhost:9000/dialog/create', {
        params: {
          userId: window.frontendData.profile.id,
          members: this.addedToCreationGroupChat.toString()
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
          this.profileData = window.frontendData.profile

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    addToGroupChatFromSearch(userId) {
      if (this.addedToCreationGroupChat.length > 0) {
        this.addedToCreationGroupChat[this.addedToCreationGroupChat.length] = userId
      } else {
        this.addedToCreationGroupChat[0] = userId
      }

      let tmpFindedUser = []
      let counter = 0

      for (let i = 0; i < this.findedUser.length; i++) {
        if (this.findedUser[i].id !== userId){
          tmpFindedUser[counter] = this.findedUser[i]
          counter++
        }
      }

      this.findedUser = tmpFindedUser

      console.log(this.addedToCreationGroupChat)
    },
    addToGroupChatFromFriendList(userId) {
      if (this.addedToCreationGroupChat.length > 0) {
        this.addedToCreationGroupChat[this.addedToCreationGroupChat.length] = userId
      } else {
        this.addedToCreationGroupChat[0] = userId
      }

      let tmpFindedUser = []
      let counter = 0

      for (let i = 0; i < this.myFriends.length; i++) {
        if (this.myFriends[i].friendId !== userId){
          tmpFindedUser[counter] = this.myFriends[i]
          counter++
        }
      }

      this.myFriends = tmpFindedUser

      console.log(this.addedToCreationGroupChat)
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
        this.myFriends = window.frontendData.profile.friendList

        clearInterval(interval)
      }
    }, 200)
  }
}
</script>

<style scoped>

</style>