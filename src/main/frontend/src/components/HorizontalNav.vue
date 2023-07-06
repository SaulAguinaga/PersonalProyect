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
        <button class="nav-button">
          <a href="http://localhost:5173">
            <img class="imageLogo" src="../assets/images/danceStyleLogo.png" alt="Logo" />
          </a>
        </button>
        <router-link v-for="button in buttons" :key="button.id" :to="`/${button.label.toLowerCase()}`">
          <button class="nav-button" :class="{ active: isActive(button.label) }">{{ button.label }}</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
@import "@/scss/colors";

.content {
  margin-top: 0px;
}

.horizontal-nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  background-color: map-get($colors, "black");
  border-radius: 5px;
  border: none;
  outline: none;
  border-bottom: 2px solid #ED54C0;
  outline-offset: 5px;
  padding: 1px;
  box-sizing: border-box;
  z-index: 999;
}

.imageLogo {
  width: 100%;
}

.nav-buttons {
  display: flex;
  align-items: center;
}

.nav-buttons button {
  width: 100%;
  margin: 2px;
  background-color: transparent;
  border: none;
  border-radius: 5px;
  font-size: 1.3rem;
  font-weight: bold;
  color: #8d8d8d;
  cursor: pointer;
  transition: 0.8s;
  transition-duration: 0.8s;
  transition-timing-function: 0.8s;
}
.nav-buttons a {
  width: 100%;
}

.nav-button.active {
  font-size: 1.3rem;
  color: #fff;
  text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
}

.nav-button:hover {
  font-size: 1.3rem;
  color: #fff;
  text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
}
</style>
