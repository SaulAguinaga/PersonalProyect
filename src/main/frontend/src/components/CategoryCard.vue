<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  category: String,
});
</script>

<template>
  <div class="categoryCard">
    <div class="categoryImgContainer">
      <img class="img" :src="'https://dancecrew-category-icons.s3.amazonaws.com/' + category + '.png'" alt="">
    </div>
    <div class="categoryText">
      <h1 class="categoryName">{{ category }}</h1>
    </div>
  </div>
</template>

<style scoped lang="scss">
.categoryCard {
  text-align: center;
  display: flex;
  flex-direction: column;
  margin-top: 30px;
  margin-left: 30px;
  color: #fff;
}

.categoryImgContainer {
  width: 10vw;
  background-color: #fff;
  box-shadow: 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0;
  border-radius: 5px;
  outline-offset: 5px;
}

.categoryImgContainer:hover {
  width: 10vw;
  background-color: #fff;
    box-shadow: 0 0 2px #00F6FF, 0 0 5px #00F6FF, 0 0 7px #00F6FF, 0 0 10px #00F6FF, 0 0 17px #00F6FF, 0 0 20px #00F6FF, 0 0 25px #00F6FF, 0 0 37px #00F6FF;
  border-radius: 5px;
  outline-offset: 5px;
}
.categoryImgContainer img {
  width: 100%;
}

.categoryText {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 10px;
  text-align: center;
  height: 100%; /* Añade esta propiedad para ocupar todo el espacio vertical */
}

.categoryName {
  font-size: x-large;
  font-weight: bold;
  margin: 0;
  max-width: 100%;
  overflow: hidden;
  word-wrap: break-word;
  align-self: center; /* Centra verticalmente el texto */
}
</style>
