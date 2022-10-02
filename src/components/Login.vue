<script lang="ts">
import { RouterLink, RouterView } from "vue-router";

export default {
  data: function () {
    return {
      isLoggedIn: false,
    };
  },
};
</script>
<template>
  <div class="outer-login">
    <div v-if="!isLoggedIn" class="loginBox">
      <img src="https://via.placeholder.com/600x200" class="login-banner" />
      <div class="inner-login">
        <h2>Sign in</h2>
        <form>
          <label for="username">Username</label><br />
          <input type="username" name="username" id="username" /><br />
          <label for="username">Password</label><br />
          <input type="password" name="password" id="password" />
          <br />
          <div class="submit-container">
            <input type="submit" value="Login" />
          </div>
        </form>
      </div>
    </div>
    <div v-else>
      <p>Your already logged in!</p>
    </div>
  </div>
</template>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Kanit&display=swap");
.outer-login {
  display: flex;
  text-align: center;
  justify-content: center;
  height: 100%;
  width: 100%;
}
p {
  color: white;
}

.loginBox {
  width: 600px;
  height: 550px;
  text-align: center;
  background-color: #00b6ff;
  font-family: "Kanit", sans-serif;
}
.inner-login {
  margin: auto 130px;
  color: white;
}
.loginBox label,
h2 {
  text-align: left;
}
#password {
  margin-bottom: 50px;
}
input {
  border: none;
}
input[type="username"],
input[type="password"] {
  padding: 5px 10px;
  width: 200px;
  font-family: "Kanit", sans-serif;
  margin-bottom: 10px;
}
input[type="submit"] {
    display: flex;
  background-color: #e1f5fe;
  padding: 10px 20px;
  border-radius: 5px;
  margin-right: 60px;
}
.login-banner {
  margin: 0;
  padding: 0;
  width: 600px;
  height: 200px;
}
.submit-container {
    display: flex;
    width: 100%;
    text-align: right;
    justify-content: right;
}
</style>
