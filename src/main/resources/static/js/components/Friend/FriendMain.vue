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
                           v-on:click="requestFriendAdding(value.id, index)">
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

          </div>
        </b-collapse>
      </div>


      <div class="friend-finder-input">
        <b-button class="btn-find-friend-collapsed my-b-btn"
                  v-b-toggle.collapse-2>
          Входящие заявки
        </b-button>
        <b-collapse id="collapse-2" class="mt-2">

          <div class="finded-potential-friend"
               v-show="existIncomingRequest">
            <div class="finded-potential-friend-list" id="finded-potential-friend-list-incoming-id"
                 v-for="(value, index) in existIncomingRequest?  incomeRequest: null">
              <div class="finded-potential-friend-item neomorphism">
                <div class="finded-potential-friend-item-header">
                  <div class="finded-potential-friend-item-header-personal-data">
                    <img class="profile-post-header-author-info-avatar-img"
                         width="75" height="75"
                         :src="value.frienduserpic"/>
                    <div class="finded-potential-friend-item-header-name">
                      {{ value.friendname }}
                    </div>
                  </div>
                  <div class="finded-potential-friend-item-buttons">
                    <b-btn class="like-button profile-post-footer-icons"
                           v-on:click="requestIncomesAdd(value.friendId, index)">
                      <b-icon-plus-square-fill font-scale="2"></b-icon-plus-square-fill>
                    </b-btn>
                    <b-btn class="like-button profile-post-footer-icons"
                           v-on:click="requestIncomesDelete(value.friendId, index)">
                      <b-icon-file-excel-fill font-scale="2"></b-icon-file-excel-fill>
                    </b-btn>
                  </div>
                </div>
              </div>

              <div class="pagination-to-potentional-friend">
                <b-pagination
                    v-model="currentPage"
                    :total-rows="rowsOfIncome"
                    :per-page="perPage"
                    aria-controls="finded-potential-friend-list-incoming-id"
                ></b-pagination>
              </div>
            </div>
          </div>

          <div class="no-requests-incomes" v-show="!existIncomingRequest">
            <p>У вас нет входящих заявок</p>
          </div>
        </b-collapse>
      </div>


      <div class="friend-finder-input">
        <b-button class="btn-find-friend-collapsed my-b-btn"
                  v-b-toggle.collapse-3>
          Исходящие заявки
        </b-button>
        <b-collapse id="collapse-3" class="mt-2">

          <div class="finded-potential-friend"
               v-show="existingOutgoingRequest">
            <div class="finded-potential-friend-list" id="finded-potential-friend-list-outgoing-id"
                 v-for="(value, index) in existingOutgoingRequest?  outGoingRequest: null">
              <div class="finded-potential-friend-item neomorphism">
                <div class="finded-potential-friend-item-header">
                  <div class="finded-potential-friend-item-header-personal-data">
                    <img class="profile-post-header-author-info-avatar-img"
                         width="75" height="75"
                         :src="value.frienduserpic"/>
                    <div class="finded-potential-friend-item-header-name">
                      {{ value.friendname }}
                    </div>
                  </div>
                  <div class="finded-potential-friend-item-buttons">
                    <b-btn class="like-button profile-post-footer-icons"
                           v-on:click="requestOutgoingDelete(value.friendId, index)">
                      <b-icon-file-excel-fill font-scale="2"></b-icon-file-excel-fill>
                    </b-btn>
                  </div>
                </div>
              </div>

              <div class="pagination-to-potentional-friend">
                <b-pagination
                    v-model="currentPage"
                    :total-rows="rowsOfOutgo"
                    :per-page="perPage"
                    aria-controls="finded-potential-friend-list-outgoing-id"
                ></b-pagination>
              </div>
            </div>
          </div>

          <div class="no-requests-incomes" v-show="!existingOutgoingRequest">
            <p>У вас нет исходящих заявок</p>
          </div>
        </b-collapse>
      </div>


    </div>
    <div class="my-friend-list" v-show="existingAnyFriend">
      <div class="friend-card" v-for="(value, index) in existingAnyFriend? friendList: null">
        <div>
          <b-card no-body class="overflow-hidden" style="max-width: 540px;">
            <b-row no-gutters>
              <b-col md="6">
                <b-card-img :src="value.frienduserpic" alt="Image" class="rounded-0">
                </b-card-img>
              </b-col>
              <b-col md="6">
                <b-card-body :title="value.friendname">
                  <b-card-text>
                    Software Developer
                  </b-card-text>
                </b-card-body>
              </b-col>
              <b-btn class="like-button profile-post-footer-icons"
                     v-on:click="requestDeleteExistingFriend(value.friendId, index)">
                <b-icon-file-excel-fill font-scale="2"></b-icon-file-excel-fill>
              </b-btn>
            </b-row>
          </b-card>
        </div>
      </div>
    </div>

    <div class="my-friend-list-alternative" v-show="!existingAnyFriend">
      <p>У вас пока нет друзей</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false

//массивы для потоковой обработки
let potentialFriend = []

export default {
  name: "FriendMain",
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
    rowsOfIncome() {
      return this.incomeRequest.length
    },
    rowsOfOutgo() {
      return this.outGoingRequest.length
    }
  },
  data() {
    return {
      currentUser: null,
      nameFeatureFriend: '',
      idFeatureFriend: '',
      findedUser: [],
      incomeRequest: [],
      outGoingRequest: [],
      friendList: [],

      perPage: 5,
      currentPage: 1,

      potentialFriendFinded: false,
      existIncomingRequest: false,
      existingOutgoingRequest: false,
      existingAnyFriend: false
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
    requestFriendAdding(friendId, index) {
      axios.get('http://localhost:9000/home/friend/add', {
        params: {
          userId: window.frontendData.profile.id,
          friendId: friendId
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
          this.dataUpdate()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestOutgoingDelete(friendId, index) {
      axios.get('http://localhost:9000/home/friend/delete', {
        params: {
          userId: window.frontendData.profile.id,
          friendId: friendId
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
          this.dataUpdate()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestIncomesDelete(friendId, index) {
      axios.get('http://localhost:9000/home/friend/delete/from/incomes', {
        params: {
          userId: window.frontendData.profile.id,
          friendId: friendId
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
          this.dataUpdate()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestIncomesAdd(friendId, index) {
      axios.get('http://localhost:9000/home/friend/add/incomes', {
        params: {
          userId: window.frontendData.profile.id,
          friendId: friendId
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
          this.dataUpdate()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    requestDeleteExistingFriend(friendId, index) {
      axios.get('http://localhost:9000/home/friend/delete/from/friendlist', {
        params: {
          userId: window.frontendData.profile.id,
          friendId: friendId
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
          this.dataUpdate()

          isSendedandrecived = false
          clearInterval(interval)
        }
      }, 500)
    },
    filterFriend() {
      let index = 0
      for (let i = 0; i < potentialFriend.length; i++) {
        if (potentialFriend[i].id !== window.frontendData.profile.id) {
          this.findedUser[index] = potentialFriend[i]
          index++
        }
      }
      this.potentialFriendFinded = this.findedUser.length > 0;
    },
    dataUpdate() {
      this.currentUser = window.frontendData.profile

      this.potentialFriendFinded = false

      if (this.currentUser.friendIncomingRequestList.length > 0) {
        this.incomeRequest = this.currentUser.friendIncomingRequestList
        this.existIncomingRequest = true
      }

      if (this.currentUser.friendOutgoingRequestList.length > 0) {
        this.outGoingRequest = this.currentUser.friendOutgoingRequestList
        this.existingOutgoingRequest = true
      }

      if (this.currentUser.friendList.length > 0) {
        this.friendList = this.currentUser.friendList
        this.existingAnyFriend = true
      }
    }
  },
  mounted() {
    /*this.currentUser = window.frontendData.profile

    this.potentialFriendFinded = false

    if (this.currentUser.friendIncomingRequestList.length > 0) {
      this.incomeRequest = this.currentUser.friendIncomingRequestList
      this.existIncomingRequest = true
    }

    if (this.currentUser.friendOutgoingRequestList.length > 0) {
      this.outGoingRequest = this.currentUser.friendOutgoingRequestList
      this.existingOutgoingRequest = true
    }

    if (this.currentUser.friendList.length > 0){
      this.friendList = this.currentUser.friendList
      this.existingAnyFriend = true
    }*/

    this.dataUpdate()
  },
  beforeDestroy() {
    this.potentialFriendFinded = false
  }
}
</script>

<style scoped>

</style>