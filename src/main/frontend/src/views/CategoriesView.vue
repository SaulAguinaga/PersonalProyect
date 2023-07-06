<script setup>
import HorizontalNav from '../components/HorizontalNav.vue';
import CategoryCard from '../components/CategoryCard.vue';
import { ref, onBeforeMount } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

const categories = ['Baby', 'Infantil', 'Duo-Infantil', 'Junior', 'Duo-Junior', 'Young', 'Duo-Young', 'Premium', 'Mega-Crew'];

const selectedCategory = ref(null);
const groups = ref([]);
const router = useRouter();
const route = useRoute();

async function showGroupList(category) {
  selectedCategory.value = category;
  router.push({ path: '/categorias', query: { category } }); // Actualiza la URL con la categoría seleccionada
  try {
    const response = await axios.get('https://t3guk01jof.execute-api.us-east-1.amazonaws.com/groups');
    groups.value = response.data.filter(group => group.category === category);
    console.log(groups.value);
  } catch (error) {
    console.error(error);
  }
}

onBeforeMount(async () => {
  const queryCategory = route.query.category;
  if (queryCategory) {
    showGroupList(queryCategory);
  }
});
</script>

<template>
  <HorizontalNav/>
  <div class="categoryHeader">
    <div class="categoryList">
      <div v-for="category in categories" :key="category" class="categoryLink">
        <CategoryCard :category="category" @click="showGroupList(category)" />
      </div>
    </div>
    <div v-if="selectedCategory" class="groupList">
      <h2>{{ selectedCategory }}</h2>
      <ul class="ul">
        <li v-for="group in groups" :key="group.id">{{ group.groupName }}</li>
      </ul>
    </div>
  </div>
</template>

<style scoped lang="scss">
h2 {
  font-size: 4em;
  color: white;
  border-bottom: 2px solid #ED54C0;

}
li{
  color: white;
  margin-top: 10px;
}
.ul{
  margin-top: 20px;
  font-size: 2em;
  text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;

}

.categoryHeader {
  display: flex;
  flex-direction: row;
  align-items: center;
}

.categoryList {
  width: 70%;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.categoryLink {
  cursor: pointer;
}

.groupList {

  width: 30%;
}
</style>
