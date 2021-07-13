<template>
  <h1>Create an boat</h1>
  <div class="form-container">
    <form @submit.prevent="onSubmit">

      <h3>Name & describe your boat</h3>

      <label>Title</label>
      <input v-model="boat.boatName" type="text" placeholder="Title" />

      <label>Description</label>
      <input
        v-model="boat.description"
        type="text"
        placeholder="Description"
      />

      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>

export default {
  data() {
    return {
      boat: this.freshBoatObject()
    }
  },
  methods: {
    onSubmit() {
      this.$store
        .dispatch('createBoat', this.boat)
        .then(() => {
          this.freshBoatObject() // correct placement?
          this.$router.push({
            name: 'BoatList'
            //arams: { id: this.boat.id }
          })
        })
        .catch(error => {
          this.$router.push({
            name: 'ErrorDisplay',
            params: { error: error }
          })
        })
    },
    freshBoatObject() {

      return {
        id: undefined,
        boatName: '',
        description: ''
      }
    }
  }
}
</script>
