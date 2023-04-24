<script setup>
import VerticalNav from '../components/VerticalNav.vue';
import { ref, onBeforeMount } from "vue";
import CategoryService from '../services/CategoryService';
import CategoryCard from '../components/CategoryCard.vue';


// const groupService = new GroupService();
const categoryService = new CategoryService();
	let categories = ref([]);
  let academy = ref()
 	onBeforeMount(async()=>{
	await categoryService.fetchAllCategories()
    categories.value = categoryService.getCategory()
	console.log(categories.value);
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
        <h1 class="neon-text-blue">Categorias</h1>
      </div>
  </div>
<div class="container">
      <div class="blank">
      </div>
      <div class="cardsList">
            <CategoryCard v-for="category in categories" :category="category" />
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
      // align-items: center;
      .neon-text-blue {
      margin-right: 2%;
      font-family: sans-serif;
      font-size: 7em;
      color: #fff;
      text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
    }
    }
    .academy{
      display: flex;
      margin-left: 40%;
      margin-top: 2%;
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
    width: 100%;
    margin-right: 15%;
    display: grid;
    grid-template-columns: repeat(1, 0.7fr);
    grid-template-rows: repeat(5, 1fr);
    justify-content: end;
    .divCard {
      align-content: flex-end;
    }
  }
}
</style>
