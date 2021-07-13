<template>
  <h1>Boats for Good</h1>
  <div class="boats">
    <BoatCard v-for="boat in boats" :key="boat.id" :boat="boat" />
  </div>
</template>

<script>
import BoatCard from '@/components/BoatCard.vue'

export default {
  name: 'BoatList',
  components: {
    BoatCard
  },
  created() {
    this.$store.dispatch('fetchBoats').catch(error => {
      this.$router.push({
        name: 'ErrorDisplay',
        params: { error: error }
      })
    })
  },
  computed: {
    boats() {
      return this.$store.state.boats
    }
  }
}
</script>

<style scoped>
.boats {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
