<script>
export default {
  data() {
    return {
      buttons: [
        { id: 1, label: 'ACADEMIAS' },
        { id: 2, label: 'GRUPOS' },
        { id: 3, label: 'CATEGORIAS' },
        { id: 4, label: 'CAMERINOS' },
        { id: 5, label: 'ORDEN ACTUACIONES' },
        { id: 6, label: 'PUNTUACIONES' },
        { id: 7, label: 'VIDEOS' }
      ]
    };
  },
  methods: {
    isActive(label) {
      return this.$route.path === `/${label.toLowerCase()}`;
    }
  }
};
</script>

<template>
    <div class="content">
  <div class="horizontal-nav">
    <div class="nav-buttons">
      <img class="imageLogo" src="../assets/images/danceStyleLogo.png" alt="Logo" />
      <router-link v-for="button in buttons" :key="button.id" :to="`/${button.label.toLowerCase()}`">
        <button :class="{ active: isActive(button.label) }">{{ button.label }}</button>
      </router-link>
    </div>
  </div>
</div>
</template>

<style scoped lang="scss">
@import "@/scss/colors";

.content {
  margin-top: 120px;
}
.horizontal-nav {
  position: fixed; 
  top: 0; 
  left: 0; 
  display: flex;
  justify-content: space-around;
  width: 100%;
  background-color: map-get($colors, "black");
  border-radius: 5px;
  border: none;
  outline: none;
  border-bottom: 2px solid #ED54C0;
  outline-offset: 5px;
  padding: 1px; /* Agrega un espaciado interno */
  box-sizing: border-box; /* Incluye el padding en el ancho total */
  z-index: 999; /* Asegura que el navegador esté por encima de otros elementos */
}

.imageLogo {
    margin: 5px;
  width: 8%;
}

.nav-buttons {
  display: flex;
  justify-content: space-around; /* Espacio igual entre los botones */
  align-items: center; /* Centra verticalmente */
  flex-wrap: wrap; /* Permite que los botones se envuelvan en múltiples líneas */
  width: 100%; /* Ocupa el 100% del ancho disponible */
  border-right: 5%;
}

.horizontal-nav button {
  margin: 2px; /* Ajusta el espaciado entre los botones */
  background-color: transparent;
  border: none;
  border-radius: 5px;
  font-size: 1.4rem;
  font-weight: bold;
  color: #8d8d8d;
  cursor: pointer;
  transition: 0.8s;
  transition-duration: 0.8s;
  transition-timing-function: 0.8s;
}

.horizontal-nav button.active {
  font-size: 1.4rem;
  color: #fff;
  text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
}

.horizontal-nav button:hover {
  font-size: 1.4rem;
  color: #fff;
  text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
}
</style>
