import { createStore } from 'vuex'
import BoatService from '@/services/BoatService'

export default createStore({
  state: {
    user: 'Abdel ',
    boats: [],
    boat: null
  },
  mutations: {
    ADD_BOAT(state, boat) {
      state.boats.push(boat)
    },
    SET_BOATS(state, boats) {
      state.boats = boats
    },
    SET_BOAT(state, boat) {
      state.boat = boat
    }
  },
  actions: {
    createBoat({ commit }, boat) {
      boat.id = undefined;
      return BoatService.postBoat(boat)
        .then(response => {
          commit('ADD_BOAT', response.data)
          commit('SET_BOAT', response.data)
        })
        .catch(error => {
          throw error
        })
    },
    updateBoat({ commit }, boat) {
      return BoatService.updateBoat(boat, boat.id)
        .then(response => {
          commit('SET_BOAT', response.data)
        })
        .catch(error => {
          throw error
        })
    },
    fetchBoats({ commit }) {
      return BoatService.getBoats()
        .then(response => {
          commit('SET_BOATS', response.data)
        })
        .catch(error => {
          throw error
        })
    },
    fetchBoat({ commit }, id) {
      const boat = this.state.boats.find(boat => boat.id === id)
      if (boat) {
        commit('SET_BOAT', boat)
      } else {
        return BoatService.getBoat(id)
          .then(response => {
            commit('SET_BOAT', response.data)
          })
          .catch(error => {
            throw error
          })
      }
    },
    deleteBoat({ commit }, id) {

      return BoatService.deleteBoat(id)
        .then(() => {
          commit('SET_BOAT', undefined)
        })
        .catch(error => {
          throw error
        })  
    }
  }
})
