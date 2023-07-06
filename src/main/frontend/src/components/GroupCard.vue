<script setup>
import { defineProps, onBeforeMount, ref } from 'vue';

const props = defineProps({
  group: Object,
})
</script>

<template>
  <div class="groupCard">
    <div class="groupImgContainer">
      <img class="img" :src="'https://dancecrew-category-icons.s3.amazonaws.com/' + group.category + '.png'" alt="">
    </div>
    <div class="groupText">
      <h1 class="groupName">{{ group.groupName }}</h1>
      <h2 class="groupCategory">{{ group.category }}</h2>
    </div>
  </div>
</template>

<style scoped lang="scss">
.groupCard {
  display: flex;
  flex-direction: column;
  margin-top: 30px;
  margin-left: 30px;
  color: #fff;

}

.groupImgContainer {
  width: 10vw;
  background-color: #fff;
  box-shadow: 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0;
  border-radius: 5px;
  outline-offset: 5px;
}

.groupImgContainer img {
  width: 100%;
}

.groupText {
  display: flex;
  flex-direction: column;
  justify-content: center;
  text-align: center;
  padding: 10px;
}

.groupName {
  font-size: x-large; 
  font-weight: bold;
  margin: 0;
  max-width: 100%;
  overflow: hidden;
  word-wrap: break-word; /* Añade esta propiedad */
}

.groupCategory {
  font-weight: lighter;
  margin: 0;
}
</style>
