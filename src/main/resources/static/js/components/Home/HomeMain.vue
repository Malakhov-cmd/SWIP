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
      <div class="col-4 info-nav-panel">
        <div class="list-group" id="list-tab" role="tablist">
          <button class="btn btn-outline-success list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-home" role="tab" aria-controls="list-home">Home</button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-language-list" data-bs-toggle="list" href="#list-language" role="tab" aria-controls="list-language">Language</button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-smart-training-list" data-bs-toggle="list" href="#list-smart-training" role="tab" aria-controls="list-smart-training">Smart training</button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-message-list" data-bs-toggle="list" href="#list-message" role="tab" aria-controls="list-message">Message</button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-friend-list" data-bs-toggle="list" href="#list-friend" role="tab" aria-controls="list-friend">Friend</button>
          <button class="btn btn-outline-success list-group-item list-group-item-action" id="list-setting-list" data-bs-toggle="list" href="#list-setting" role="tab" aria-controls="list-setting">Setting</button>
        </div>
      </div>
      <div class="col-8 info-content-panel">
        <div class="tab-content" id="nav-tabContent">
          <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">dfbfgbfbfg bdffffffff fffffffffff fffffffff</div>
          <div class="tab-pane fade" id="list-language" role="tabpanel" aria-labelledby="list-language-list">Some text about language</div>
          <div class="tab-pane fade" id="list-smart-training" role="tabpanel" aria-labelledby="list-smart-training-list">Some text about smart training</div>
          <div class="tab-pane fade" id="list-message" role="tabpanel" aria-labelledby="list-message-list">Some text about messaging</div>
          <div class="tab-pane fade" id="list-friend" role="tabpanel" aria-labelledby="list-friend-list">Some text about friend relations</div>
          <div class="tab-pane fade" id="list-setting" role="tabpanel" aria-labelledby="list-setting-list">Mau be settings</div>
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