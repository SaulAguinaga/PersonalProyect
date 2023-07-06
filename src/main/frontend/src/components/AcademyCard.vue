<script setup>
import { defineProps, onBeforeMount, ref } from 'vue';

const props = defineProps({
	academy: Object,
})
</script>


<template>
  <div class="academyCard">
    <div class="imgAndText">
      <div class="imgContainer">
        <img class="img" :src="'https://dancecrew-images.s3.amazonaws.com/' + academy.phoneNumber + '.png'" alt="">
      </div>
    </div>
    <h1 class="academyName">{{ academy.academyName }}</h1>
    <h2 class="academyLocation">{{ academy.location }}</h2>
    <h2 class="academyLocation">{{ academy.phoneNumber }}</h2>
  </div>
</template>

<style scoped lang="scss">
.academyCard {
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  
  .imgAndText {
    width: 100%;
    display: flex;
    margin: 20px;
    background-color: white;
    border-radius: 5px;
    border: none;
    outline: none;
    color: white;
    box-shadow: 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0;
    outline-offset: 5px;
  }

  .imgContainer {
    width: 100%;
    padding-top: 100%; /* Mantén el aspecto cuadrado */
    position: relative;
    overflow: hidden;
  }

  .imgContainer img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover; /* Ajusta la imagen para que cubra el contenedor sin distorsión */
  }
  .imgAndText:hover {
    width: 100%;
    display: flex;
    margin: 20px;
    background-color: white;
    border-radius: 5px;
    border: none;
    outline: none;
    color: white;
    box-shadow: 0 0 2px #00F6FF, 0 0 5px #00F6FF, 0 0 7px #00F6FF, 0 0 10px #00F6FF, 0 0 17px #00F6FF, 0 0 20px #00F6FF, 0 0 25px #00F6FF, 0 0 37px #00F6FF;
    outline-offset: 5px;
    cursor: pointer;
  }
  .academyName{
    font-size: x-large;
    font-weight: bold;
    text-decoration: none;
  }
  .academyLocation{
    font-weight: lighter;
    text-decoration: none;

  }
}
</style>