<script setup>
import HorizontalNav from '../components/HorizontalNav.vue';

// Lista de videos obtenidos desde el bucket (simulado)
const videos = [
  'https://d15sekg2clh4kp.cloudfront.net/1.mp4',
  'https://d15sekg2clh4kp.cloudfront.net/2.mp4',
  'https://d15sekg2clh4kp.cloudfront.net/3.mp4',
  'https://d15sekg2clh4kp.cloudfront.net/4.mp4',
  'https://d15sekg2clh4kp.cloudfront.net/5.mp4'
];

</script>
<template>
  <HorizontalNav/>
  <div class="header"></div>

  <div class="video-container">
    <div class="video" v-for="video in videos" :key="video">
      <video width="400" height="225" controls>
        <source :src="video" type="video/mp4" />
      </video>
    </div>
  </div>
</template>
<style scoped lang="scss">
.header {
  display: flex;
  width: 100%;
}

.video-container {
  display: flex;
  flex-wrap: wrap;
  // justify-content: center;
  justify-content: space-around;
}

.video {
  width: 25%; /* Ajusta el ancho según tus necesidades */
  margin: 30px;
}
</style>
