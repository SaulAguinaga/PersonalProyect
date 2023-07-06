<script>
export default {
  data() {
    return {
      academyName: "",
      phoneNumber: "",
      location: "",
      file: null, // Variable para almacenar el archivo seleccionado
    };
  },
  methods: {
    handleFileUpload(event) {
      this.file = event.target.files[0];
    },
    async submitForm() {
      const formData = {
        academyName: this.academyName,
        phoneNumber: this.phoneNumber,
        location: this.location,
      };

      try {
        const response = await fetch(
          "https://apj87rep7g.execute-api.us-east-1.amazonaws.com/newAcademy",
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
      }

      if (this.file) {
        const imageFormData = new FormData();
        imageFormData.append("image", this.file);

        try {
          const imageResponse = await fetch(
            "https://5bh85v126j.execute-api.us-east-1.amazonaws.com/addImage",
            {
              method: "POST",
              body: imageFormData,
            }
          );

          if (imageResponse.ok) {
            // Procesar la respuesta exitosa de la función Lambda si es necesario
            console.log("Imagen enviada correctamente");
          } else {
            // Manejar el error en caso de que la respuesta no sea exitosa
            console.error("Error al enviar la imagen");
          }
        } catch (error) {
          // Manejar errores de conexión o de la función Lambda
          console.error("Error de conexión", error);
        }
      }
    },
  },
};
</script>

<template>
  <div class="form-container">
    <br>
    <h1 class="title">Nueva Academia</h1>
    <br>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="academyName">Nombre:</label>
        <input type="text" id="academyName" v-model="academyName" required>
      </div>
      <div class="form-group">
        <label for="phoneNumber">Teléfono:</label>
        <input type="tel" id="phoneNumber" v-model="phoneNumber" required>
      </div>
      <div class="form-group">
        <label for="location">Localización:</label>
        <input type="text" id="location" v-model="location" required>
      </div>
      <!-- <div class="form-group">
        <label for="imageUpload">Imagen:</label>
        <input type="file" id="imageUpload" accept="image/*" @change="handleFileUpload" required>
      </div> -->
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
