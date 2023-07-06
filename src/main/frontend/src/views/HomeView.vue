<template>
    <div>
      <HorizontalNav />
      <div class="videoContainer">
        <div id="youtubePlayer"></div>
      </div>
    </div>
  </template>
  
  <script setup>
  import HorizontalNav from '../components/HorizontalNav.vue';
  
  // Función para cargar la API de YouTube
  function loadYouTubeAPI() {
    const tag = document.createElement('script');
    tag.src = 'https://www.youtube.com/iframe_api';
    const firstScriptTag = document.getElementsByTagName('script')[0];
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
  }
  
  // Variables globales
  let player;
  
  // Función que se ejecuta cuando la API de YouTube está lista
  window.onYouTubeIframeAPIReady = function() {
    player = new YT.Player('youtubePlayer', {
      videoId: 'U50ICRSLWfU',
      width: '100%',
      height: '100%',
      playerVars: {
        autoplay: 1,
        controls: 0,
        modestbranding: 1,
        loop: 1,
        playlist: 'U50ICRSLWfU',
        rel: 0,
        showinfo: 0,
        fs: 1
      },
      events: {
        onReady: onPlayerReady
      }
    });
  }
  
  // Función que se ejecuta cuando el reproductor está listo
  function onPlayerReady(event) {
    event.target.playVideo();
    event.target.setSize(window.innerWidth, window.innerHeight); // Ajustar el tamaño del reproductor al tamaño de la ventana
    window.addEventListener('resize', () => {
      event.target.setSize(window.innerWidth, window.innerHeight); // Actualizar el tamaño del reproductor al cambiar el tamaño de la ventana
    });
  }
  
  // Cargar la API de YouTube al montar el componente
  loadYouTubeAPI();
  </script>
  
  <style>
  .videoContainer {
    width: 100%;
    height: calc(100vh - 60px); /* Ajustar la altura para excluir la altura del HorizontalNav */
  }
  </style>
  