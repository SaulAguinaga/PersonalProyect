<script setup>
import HorizontalNav from '../components/HorizontalNav.vue';
import AcademyForm from '../components/AcademyForm.vue';
import AcademyCard from '../components/AcademyCard.vue';
import { ref, onBeforeMount } from "vue";
import axios from "axios";

const academies = ref([]);

onBeforeMount(async () => {
  try {
    const response = await axios.get('https://apj87rep7g.execute-api.us-east-1.amazonaws.com/academies');
    academies.value = response.data;
    console.log(academies.value);
  } catch (error) {
    console.error(error);
  }
});
</script>

<template>
  <HorizontalNav/>
  <div class="header">
      <div class="cardsList">
        <router-link v-for="academy in academies" :key="academy.phoneNumber" :to="'/grupos/' + academy.phoneNumber" class="cardLink">
          <AcademyCard :academy="academy" />
        </router-link>
      </div>
      
      <div class="form">
        <AcademyForm/>
        <ImageSubmit/>
      </div>
  </div>
</template>

<style scoped lang="scss">
.header {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.cardsList {
  display: flex;
  flex-wrap: wrap;
}

.cardLink {
  padding: 0 10px;
  margin: 5px;
  width: 15%; /* Asegura que todas las tarjetas tengan el mismo ancho */
}
.form{
  display: flex;
  width: 30%;
  margin-right: 10px;

}
</style>



