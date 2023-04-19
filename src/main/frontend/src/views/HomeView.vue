<script setup>
import VerticalNav from '../components/VerticalNav.vue';
import Title from '../components/Title.vue';
import AcademyCard from '../components/AcademyCard.vue';



</script>
<template>
  <div class="header">
    <div class="logoDanceStyle">
      <div class="logoAndVerticalNav">
        <img class="imageLogo" src="../assets/images/danceStyleLogo.png" alt="Logo" />
        <!-- <VerticalNav /> -->
        <VerticalNav/>
      </div>
      
      <div class="pointsUp">
        <img class="imagePointsUp" src="../assets/images/puntos.png" alt="Points Up" />
      </div>

      <div class="imageBottomRight">
        <img class="imagePointsDown" src="../assets/images/puntos.png" alt="Points Down" />
      </div>
    </div>
  </div>
    <div class="title">
        <Title />
      </div>
      <div class="divCard">
      <AcademyCard />
    </div>

</template>
<style scoped lang="scss">
.header {
  margin: 0.5%;
  width: 100%;
  height: 20vh;
  display: flex;
  flex-direction: row;
  justify-content: left;
  z-index: 0;
  .logoDanceStyle {
    width: 30%;
    display: flex;
      .logoAndVerticalNav{
        width: 40%;
        display: flex;
        flex-direction: column;
        .imageLogo {
          width: 100%;
          object-fit: contain;
        }
        }
      .pointsUp {
        display: flex;
        .imagePointsUp {
          height: 50vh;
        }
      }

    .pointsDown {
      position: absolute;
      bottom: 0;
      right: 0;
      display: flex;
      flex-direction: column;
      transform: rotate(90deg);
      width: 10%;
      height: 100%;

      .imagePointsDown {
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
    }

    .imageBottomRight {
      position: absolute;
      bottom: 0;
      right: 0;
      margin-right: 10%;
      transform: rotate(90deg);

      img {
        width: 150%;
        height: auto;
        object-fit: cover;
      }
    }
  }
}
.title{
  width: 100%;
  display: flex;
  align-items: start;
  justify-content: flex-end;
  padding-right: 5%;
  z-index: 1;
}

.divCard{
  background-color: red;
  display: flex;
  justify-content: center;
  width: 100%;

}
</style>