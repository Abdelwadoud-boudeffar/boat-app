<template>
  <router-link
    class="boat-link"
    :to="{ name: 'BoatDetails', params: { id: boat.id } }"
  >
    <div class="boat-card">
      <span>{{ boat.description }}</span>
      <h4>{{ boat.boatName }}</h4> 
    </div>
  </router-link>
</template>

<script>
export default {
  props: {
    boat: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
.boat-card {
  padding: 20px;
  width: 250px;
  cursor: pointer;
  border: 1px solid #39495c;
  margin-bottom: 18px;
}

.boat-card:hover {
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}

.boat-link {
  color: #2c3e50;
  text-decoration: none;
}
</style>
