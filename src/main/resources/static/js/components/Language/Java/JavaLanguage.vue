<template>
  <div>
    <div>
      <b-button v-b-modal.modal-1>Launch demo modal</b-button>
      <b-modal id="modal-1" title="BootstrapVue">
        <p class="my-4">Hello from modal!</p>
      </b-modal>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      dialog: false,
    }
  },
}
</script>

<style scoped>

</style>