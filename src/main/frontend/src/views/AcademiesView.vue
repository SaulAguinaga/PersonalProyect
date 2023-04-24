<script setup>
import VerticalNav from '../components/VerticalNav.vue';
import Title from '../components/Title.vue';
import AcademyCard from '../components/AcademyCard.vue';
import AcademyService from '../services/AcademyService';
import { ref, onBeforeMount } from "vue";


const academyService = new AcademyService();
	let academies = ref([]);
 	onBeforeMount(async()=>{
	await academyService.fetchAllAcademies()
	academies.value = academyService.getAcademy()
	console.log(academies.value);
	});


</script>
<template>
  <div class="header">
    <div class="logoDanceStyle">
      <div class="logoAndVerticalNav">
        <img class="imageLogo" src="../assets/images/danceStyleLogo.png" alt="Logo" />
        <VerticalNav/>
      </div>
      <div class="pointsUp">
        <img class="imagePointsUp" src="../assets/images/puntos.png" alt="Points Up" />
      </div>
    </div>
    <div class="section">
        <h1 class="neon-text-blue">Academias</h1>
      </div>
  </div>
<div class="container">
      <div class="blank">
      </div>
      <div class="cardsList">
        <router-link
            v-for="academy in academies"
            :key="academy.id"
            :to="'/grupos/' + academy.id"
            >
            <AcademyCard :academy="academy" />
        </router-link>
</div>
</div>
</template>
<style scoped lang="scss">
.header {
  padding: 1%;
  width: 100%;
  height: 20vh;
  display: flex;
  flex-direction: row;
  justify-content: left;
  // z-index: 0;
  .logoDanceStyle {
    width: 30%;
    display: flex;
      .logoAndVerticalNav{
        width: 40%;
        display: flex;
        flex-direction: column;
        align-items: center;
        .imageLogo {
          width: 100%;
          object-fit: contain;
        }
      }
      .pointsUp {
        display: flex;
        margin-left: 15%;
          .imagePointsUp {
            height: 30vw;
          }
        }
    }
    .section{
      display: flex;
      justify-content: center;
      .neon-text-blue {
      margin-right: 2%;
      font-family: sans-serif;
      font-size: 7em;
      color: #fff;
      text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
    }
    }
}

.container{
  width: 100%;
  display: flex;
  flex-direction: row;
  .blank{
    width: 30%;
  }
  .cardsList {
    width: 70%;
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    grid-template-rows: repeat(2, 1fr);
    justify-content: end;
    .divCard {
      align-content: flex-end;
    }
  }
}
</style>
