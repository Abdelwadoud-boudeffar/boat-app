import axios from 'axios'

const apiClient = axios.create({
  baseURL: 'http://192.168.1.24:8088/api/v1',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
})

export default {
  getBoats() {
    return apiClient.get('/boat')
  },
  getBoat(id) {
    return apiClient.get('/boat/' + id)
  },
  postBoat(boat) {
    return apiClient.post('/boat', boat)
  },
  deleteBoat(id) {
    return apiClient.delete('/boat/' + id)
  },
  updateBoat(boat, id) {
    return apiClient.put('/boat/' + id, boat)
  }
}
