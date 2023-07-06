<script>
import { ref } from 'vue';
const categoryOptions = ['Baby', 'Infantil' , 'Duo-Infantil' ,'Junior', 'Duo-Junior' , 'Young', 'Duo-Young' , 'Premium', 'Mega-Crew'];

const category = ref('');

export default {
  data() {
    return {
      groupName: "",
      phoneNumber: "",
      category: "",
      file: null, // Variable para almacenar el archivo seleccionado
    };
  },
  computed: {
    categoryOptions() {
      return ['Baby', 'Infantil' , 'Duo-Infantil' ,'Junior', 'Duo-Junior' , 'Young', 'Duo-Young' , 'Premium', 'Mega-Crew'];
    },
  },
  mounted() {
    // Obtener el número de teléfono de la URL
    const phoneNumber = this.$route.params.academyId;
    if (phoneNumber) {
      this.phoneNumber = phoneNumber;
    }
  },
  methods: {
    handleFileUpload(event) {
      this.file = event.target.files[0];
    },
    async submitForm() {
      const formData = {
        groupName: this.groupName,
        phoneNumber: parseInt(this.phoneNumber),
        category: this.category,
      };

      try {
        const response = await fetch(
          "https://t3guk01jof.execute-api.us-east-1.amazonaws.com/groups",
          {
            method: "POST",
            body: JSON.stringify(formData),
            headers: {
              "Content-Type": "application/json",
            },
          }
        );

        if (response.ok) {
          // Procesar la respuesta exitosa de la función Lambda si es necesario
          console.log("Formulario enviado correctamente");
          alert("Formulario enviado correctamente");
          window.location.reload();
        } else {
          // Manejar el error en caso de que la respuesta no sea exitosa
          console.error("Error al enviar el formulario");
          alert("Error al enviar el formulario");
        }
      } catch (error) {
        // Manejar errores de conexión o de la función Lambda
        console.error("Error de conexión", error);
        alert("Error de conexión");
      }

    //   if (this.file) {
    //     const imageFormData = new FormData();
    //     imageFormData.append("image", this.file);

    //     try {
    //       const imageResponse = await fetch(
    //         "https://5bh85v126j.execute-api.us-east-1.amazonaws.com/addImage",
    //         {
    //           method: "POST",
    //           body: imageFormData,
    //         }
    //       );

    //       if (imageResponse.ok) {
    //         // Procesar la respuesta exitosa de la función Lambda si es necesario
    //         console.log("Imagen enviada correctamente");
    //       } else {
    //         // Manejar el error en caso de que la respuesta no sea exitosa
    //         console.error("Error al enviar la imagen");
    //       }
    //     } catch (error) {
    //       // Manejar errores de conexión o de la función Lambda
    //       console.error("Error de conexión", error);
    //     }
    //   }
    },
  },
};
</script>

<template>
  <div class="form-container">
    <br>
    <h1 class="title">Nuevo Grupo</h1>
    <br>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="groupName">Nombre:</label>
        <input type="text" id="groupName" v-model="groupName" required>
      </div>
    <div class="form-group">
        <label for="category">Categoría:</label>
        <select id="category" v-model="category" required>
          <option value="" disabled selected>Selecciona una categoría</option>
          <option v-for="option in categoryOptions" :value="option" :key="option">{{ option }}</option>
        </select>
      </div>
      <button type="submit">Enviar</button>
    </form>
  </div>
</template>

<style scoped lang="scss">
.form-container {
  max-width: 400px;
  margin: 0 auto;
  color:#fff;

  .title {
    font-size: 30px;
    text-shadow: 0 0 5px #00F6FF, 0 0 10px #00F6FF, 0 0 15px #00F6FF, 0 0 20px #00F6FF, 0 0 35px #00F6FF, 0 0 40px #00F6FF, 0 0 50px #00F6FF, 0 0 75px #00F6FF;
    font-family: 'Courier New', Courier, monospace;
  }
}

.form-group {
  margin-bottom: 20px;
  font-size: 20px;
  color: #fff;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 5px;
  border: 1px solid #ccc;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
}
</style>
