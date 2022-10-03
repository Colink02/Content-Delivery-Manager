<script lang="ts">
import { RouterLink, RouterView } from "vue-router";
import Login from "./components/Login.vue";

  export default {
    components: {
      Login
    }
  }

</script>

<template>
  <div id="login-page">
    <Login />
  </div>
</template>

<style>
  html, body {
    background-color: #b1e0e2;
    height: 100%;
    width: 100%;
    margin: 0;
  }
  #login-page {
    align-items: center;
    display: flex;
    justify-content: center;
    height: 100%;
    width: 100%;
  }
  #app {
    height: 100%;
  }
</style>
