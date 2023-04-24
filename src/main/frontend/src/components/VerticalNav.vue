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
        { id: 6, label: 'PUNTUACIONES' }
      ]
    }
  }
}
</script>
<template>
  <div class="vertical-nav">
    <router-link v-for="button in buttons" :key="button.id" :to="`/${button.label.toLowerCase()}`">
      <button>{{ button.label }}</button>
    </router-link>
  </div>
</template>


<style>
.vertical-nav {
  z-index: 1;
  display: flex;
  margin-left: 10%;
  width: 100%;
  flex-direction: column;
  background-color: transparent;
  border-radius: 5px;
  border: none;
  outline: none;
  box-shadow: 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0, 0 0 10px #ED54C0;
  outline-offset: 5px;
}

.vertical-nav button {
  display: block;
  width: 100%;
  margin-bottom: 10%;
  margin-top: 10%;
  background-color: transparent;
  border: none;
  border-radius: 5px;
  font-size: 1.4rem;
  padding-bottom: 2%;
  font-weight: bold;
  color: #fff;
  cursor: pointer;
}

.vertical-nav button:hover {
  font-size: 1.4rem;
    text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
}
</style>
