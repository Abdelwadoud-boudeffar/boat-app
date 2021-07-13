import { createRouter, createWebHistory } from 'vue-router'
import BoatList from '../views/BoatList.vue'
import BoatDetails from '../views/BoatDetails.vue'
import BoatCreate from '../views/BoatCreate.vue'
import ErrorDisplay from '../views/ErrorDisplay.vue'
import About from '../views/About.vue'

const routes = [
  {
    path: '/',
    name: 'BoatList',
    component: BoatList
  },
  {
    path: '/boat/:id',
    name: 'BoatDetails',
    props: true,
    component: BoatDetails
  },
  {
    path: '/boat/create',
    name: 'BoatCreate',
    component: BoatCreate
  },
  {
    path: '/error/:error',
    name: 'ErrorDisplay',
    props: true,
    component: ErrorDisplay
  },
  {
    path: '/about',
    name: 'About',
    component: About
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
