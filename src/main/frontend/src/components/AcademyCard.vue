<script setup>
import { defineProps, onBeforeMount, ref } from 'vue';

const props = defineProps({
	academy: Object,
})
</script>


<template>
    <div class="card">
      <div class="imgAndText" >
        <img class="img" :src="'http://localhost:8080/' + academy.image" alt="">
      </div>
      <h1 class="academyName">{{ academy.name }}</h1>
      <h2 class="academyLocation">{{ academy.location }}</h2>

    </div>
</template>

<style scoped lang="scss">
.card{
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  .img{
    width: 100%;
  }
  .imgAndText {
    width: 70%;
    height: 20vh;
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
  .imgAndText:hover {
    width: 70%;
    height: 20vh;
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