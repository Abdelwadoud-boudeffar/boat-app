<template>
  <div v-if="boat" class="form-container">

      <label>Title</label>
      <input class="boat-input" v-model="boat.boatName" type="text"/>

      <label>Description</label>
      <input
        class="boat-input"
        v-model="boat.description"
        type="text"
        placeholder="Description"
      />
    <div class="btn-group">
      <button  class="boat-button" v-on:click="update(boat)"> Update</button>
      <button v-on:click="remove"> Delete</button>
    </div>
  </div>
</template>

<script>
export default {
  props: ['id'],
  created() {
    this.$store.dispatch('fetchBoat', this.id).catch(error => {
      this.$router.push({
        name: 'ErrorDisplay',
        params: { error: error }
      })
    })
  },
  computed: {
    boat() {
      return this.$store.state.boat
    }
  },
  methods: {
    update: function(boat) {
      this.$store
        .dispatch('updateBoat', boat)
        .then(() => {
          this.$router.push({
            name: 'BoatList'
          })
        })
        .catch(error => {
          this.$router.push({
            name: 'ErrorDisplay',
            params: { error: error }
          })
        })
    },
    remove: function() {
      this.$store
        .dispatch('deleteBoat', this.id)
        .then(() => {
          this.$router.push({
            name: 'BoatList'
          })
        })
        .catch(error => {
          this.$router.push({
            name: 'ErrorDisplay',
            params: { error: error }
          })
        })
    }
  }
}
</script>

<style scoped>
.boat-input {
  width: 50%;
}
.boat-button {
  margin-right: 10px;
}
</style>
