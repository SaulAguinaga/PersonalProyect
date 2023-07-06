<script setup>
import { reactive, ref, onBeforeMount } from "vue";
import axios from "axios";
import { useRoute } from 'vue-router';

import HorizontalNav from '../components/HorizontalNav.vue';
import GroupForm from '../components/GroupForm.vue';
import GroupCard from '../components/GroupCard.vue';

const groups = ref([]);
const route = useRoute();
const phoneNumber = route.params.academyId;
const academy = ref([]);

onBeforeMount(async () => {
  try {
    const responseAcademy = await axios.get('https://apj87rep7g.execute-api.us-east-1.amazonaws.com/academies');
    if(phoneNumber == responseAcademy.data.phoneNumber){
    academy.value = responseAcademy.data;
    }
    console.log(academy.value);
    console.log(phoneNumber);
    const response = await axios.get('https://t3guk01jof.execute-api.us-east-1.amazonaws.com/groups');
    if(phoneNumber==null){
      groups.value = response.data;
    }
    else{
      groups.value = response.data.filter(group => group.phoneNumber == phoneNumber);
      console.log(groups.value);
    }
  } catch (error) {
    console.error(error);
  }
});
</script>

<template>
  <HorizontalNav/>
  <div class="cardsList">
        <router-link v-for="academy in academies" :key="academy.phoneNumber" :to="'/grupos/' + academy.phoneNumber" class="cardLink">
          <AcademyCard :academy="academy" />
        </router-link>
      </div>
  <div class="groupHeader">
    <div class="groupList">
      <router-link v-for="group in groups" :key="group.id" :to="`/groups/${group.id}`" class="groupLink">
        <GroupCard :group="group" />
      </router-link>
    </div>
      
    <template v-if="phoneNumber">
      <div class="groupForm">
        <GroupForm/>
        <ImageSubmit/>
      </div>
    </template>
  </div>
</template>

<style scoped lang="scss">
.groupHeader {
  display: flex;
  width: 100%;
  .groupList {
    width: 75%;
    display: flex;
    flex-wrap: wrap; /* Añade esta propiedad */
  .groupLink{
    width: 15%;
  }
  }
  .groupForm {
    display: flex;
    width: 25%;
  }
}
</style>
