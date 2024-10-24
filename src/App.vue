<script lang="ts">
import Login from "./components/Login.vue";
import Dashboard from "./views/Dashboard.vue";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

export default {
  components: {
    Login,
    Dashboard,
  },
};
</script>

<template>
  <Dashboard />
</template>

<style>
html,
body {
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
