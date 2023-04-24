<script setup>
import { defineProps, onBeforeMount, ref } from 'vue';

const props = defineProps({
	category: Object,
})
</script>


<template>
    <div class="card">
      <div class="imgAndText" >
          <h1 class="groupName">{{ category.age }}</h1>
          <h1 class="groupName">{{ category.name }}</h1>

      </div>

    </div>
</template>

<style scoped lang="scss">
.card{
    margin-top: 3%;
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  
  .imgAndText {
    width: 100%;
    display: flex;
    justify-content: space-between;
    margin: 20px;
    border-radius: 5px;
    padding-left: 2%;
    padding-right: 2%;
    border: none;
    outline: none;
    color: white;
    box-shadow: 0px 8px 10px -5px #ED54C0;
    outline-offset: 5px;
  }
  .imgAndText:hover {
    width: 100%;
    justify-content: space-between;
    display: flex;
    margin: 20px;
    border-radius: 5px;
    border: none;
    outline: none;
    color: white;
    box-shadow: 0px 8px 10px -5px #00F6FF;
    outline-offset: 5px;
    cursor: pointer;
  }
  .groupName{
    font-size: 2rem;
    font-weight: bold;
    text-decoration: none;
  }
  .categoryName{
    font-size: 2rem;
    font-weight: lighter;
    text-decoration: none;

  }
}
</style>