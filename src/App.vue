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
  body {
    background-color: #b1e0e2;
  }
</style>
