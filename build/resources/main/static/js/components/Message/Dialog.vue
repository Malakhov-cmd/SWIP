<template>
  <div class="dialog-main">
    <div class="dialog-info neomorphism" v-if="dialogData != null">
      <div class="dialog-info-users">
        <div class="dialog-info-header"
             v-for="(value) in dialogData.members">
          <div class="member-info-iterable" v-show="value.memberId !== profileData.id">
            <router-link :to="/page/ + value.memberId">
              <div class="dialog-info-header-item">
                <img class="profile-post-header-author-info-avatar-img dialog-info-header-item-avatar"
                     width="75" height="75"
                     :src="value.memberuserpic"/>
              </div>
              <div class="dialog-info-header-item-name">
                {{ value.membername }}
              </div>
            </router-link>
          </div>
        </div>
      </div>
      <div class="dialog-info-member-count">
        Участников {{ dialogData.members.length }}
      </div>
    </div>
    <div class="dialog-message-main" v-if="profileData !== null">
      <div class="profile-comments"
           v-for="(valueMessage) in dialogData.messageList">
        <div class="profile-comment-data">
          <div class="profile-comment-data-my-comment"
               v-show="!isMyMessage(valueMessage.author.memberId)">
            <div class="profile-comment-data-my-comment-img-with-message">
              <img class="profile-comment-data-my-comment-avatar-img"
                   width="35" height="35"
                   :src="valueMessage.author.memberuserpic"/>
              <div class="bubble-message theme bubble-message-left"
                   :data-time=valueMessage.timeSent>
                {{ valueMessage.text }}
              </div>
            </div>
            {{ valueMessage.author.membername }}
          </div>

          <div class="profile-comment-data-stranger-comment"
               v-show="isMyMessage(valueMessage.author.memberId)">
            <div class="bubble-message theme" :data-time=valueMessage.timeSent>
              {{ valueMessage.text }}
            </div>
          </div>

          <svg height="0" width="0">
            <defs>
              <clipPath id="svgPath">
                <path fill="#FFFFFF" d="M20,20H0V0H0A20,20,0,0,0,20,20Z"/>
              </clipPath>
            </defs>
          </svg>
        </div>
      </div>
    </div>
    <div class="dialog-input-area">
      <b-form-textarea
          id="chat-textarea textarea-no-resize"
          rows="3"
          no-resize
          v-model="messageText"
      ></b-form-textarea>
      <b-btn class="like-button profile-post-footer-icons"
             v-on:click="sendMessage()" onclick="this.blur()">
        <b-icon-arrow-right-circle-fill font-scale="3"></b-icon-arrow-right-circle-fill>
      </b-btn>
    </div>
  </div>
</template>

<script>
import axios from "axios";

let isSendedandrecived = false

export default {
  name: "Dialog",
  data() {
    return {
      profileData: null,
      dialogData: null,
      dataUpdater: null,

      messageText: "",
      messagesList: []
    }
  },
  computed: {
    chatId() {
      return this.$route.params.dialogid;
    },
    userId() {
      return this.$route.params.userid;
    },
  },
  methods: {
    sendMessage() {
      let memberId = this.dialogData.members.find(
          item => item.memberId == this.profileData.id).id

      axios.get('/dialog/send/message', {
        params: {
          userId: this.userId,
          dialogId: this.chatId,
          memberId: memberId,
          text: this.messageText
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

          this.messageText = ""

          this.profileData = window.frontendData.profile

          for (let i = 0; i < this.profileData.dialogList.length; i++) {
            if (this.profileData.dialogList[i].id == this.chatId) {
              this.dialogData = this.profileData.dialogList[i]
            }
          }

          this.sorting()
          this.scroll()

          clearInterval(interval)
        }
      }, 100)


    },
    dataUpdate() {
      this.dataUpdater = setInterval(() => {
        axios.get('/api/userinfo', {
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
            this.profileData = window.frontendData.profile

            for (let i = 0; i < this.profileData.dialogList.length; i++) {
              if (this.profileData.dialogList[i].id == this.chatId) {
                this.dialogData = this.profileData.dialogList[i]
              }
            }

            this.sorting()

            isSendedandrecived = false

            clearInterval(interval)
          }
        }, 1000)
      }, 1000)
    },
    isMyMessage(messageAuthorId) {
      return messageAuthorId === this.profileData.id
    },
    sorting() {
      this.dialogData.messageList.sort(function (a, b) {
        if (a.id > b.id) {
          return 1;
        }
        if (a.id < b.id) {
          return -1;
        }
        return 0;
      });
    },
    scroll() {
      let container = document.getElementsByClassName('dialog-message-main').item(0)

      let containerHeight = container.scrollHeight
      let isChanged = setInterval(() => {
        if (containerHeight !== container.clientHeight){
          container.scrollTop = container.scrollHeight
          clearInterval(isChanged)
        }
      }, 10)
    }
  },
  mounted() {
    axios.get('/api/userinfo', {
      params: {
        userId: this.userId
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

        for (let i = 0; i < this.profileData.dialogList.length; i++) {
          if (this.profileData.dialogList[i].id == this.chatId) {
            this.dialogData = this.profileData.dialogList[i]
          }
        }

        this.sorting()
        this.scroll()

        clearInterval(interval)
      }
    }, 100)

    this.dataUpdate()
  },
  beforeDestroy() {
    clearInterval(this.dataUpdater)
  }
}
</script>

<style scoped>

</style>