import { createRouter, createWebHistory } from 'vue-router'
import AcademiesView from '../views/AcademiesView.vue'
import GroupsView from '../views/GroupsView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/academias',
      name: 'academies',
      component: AcademiesView
    },
    {
      path: '/grupos',
      name: 'groups',
      component: () => import('../views/GroupsView.vue')
    },
    {
      path: '/grupos/:academyId',
      name: 'grupos',
      component: GroupsView
    },
    {
      path: '/videos',
      name: 'videos',
      component: () => import('../views/VideosView.vue')
    },
    {
      path: '/categorias',
      name: 'categories',
      component: () => import('../views/CategoriesView.vue')
    }
  ]
})

export default router
