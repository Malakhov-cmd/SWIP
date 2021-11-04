<template>
  <div id="home-container">
    <div class="Iam">

      <p>SWIP is</p>
      <b class="Iam-b">
        <div class="innerIam">
          simply than you think<br/>
          faster than you expected<br/>
          the best you deserve
        </div>
      </b>
    </div>

    <div class="row home-instruction">
      <div class="col-4">
        <div class="list-group" id="list-tab" role="tablist">
          <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-home" role="tab" aria-controls="list-home">Home</a>
          <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#list-profile" role="tab" aria-controls="list-profile">Profile</a>
          <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list" href="#list-messages" role="tab" aria-controls="list-messages">Messages</a>
          <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list" href="#list-settings" role="tab" aria-controls="list-settings">Settings</a>
        </div>
      </div>
      <div class="col-8">
        <div class="tab-content" id="nav-tabContent">
          <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">dfbfgbfbfg bdffffffff fffffffffff fffffffff</div>
          <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">...</div>
          <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">...</div>
          <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">...</div>
        </div>
      </div>
    </div>
    <div class="row home-instruction">
      <div class="col-4">
        <div class="list-group" id="list-tab" role="tablist">
          <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-home" role="tab" aria-controls="list-home">Home</a>
          <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#list-profile" role="tab" aria-controls="list-profile">Profile</a>
          <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list" href="#list-messages" role="tab" aria-controls="list-messages">Messages</a>
          <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list" href="#list-settings" role="tab" aria-controls="list-settings">Settings</a>
        </div>
      </div>
      <div class="col-8">
        <div class="tab-content" id="nav-tabContent">
          <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">dfbfgbfbfg bdffffffff fffffffffff fffffffff</div>
          <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">...</div>
          <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">...</div>
          <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">...</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeMain",
  data() {
    return {
      text: `
          Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
          richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
          brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
          tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
          assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore
          wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
          vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic
          synth nesciunt you probably haven't heard of them accusamus labore VHS.
        `
    }
  },
  methods: {
    animationText() {
      //TODO
    }
  },
  mounted() {
    console.log("heheheh")
  }
}
</script>

<style scoped>
</style>