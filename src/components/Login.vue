<script lang="ts">
import { mapActions } from "pinia";
import { RouterLink, RouterView } from "vue-router";

export default {
  data: function () {
    return {
      isLoggedIn: false,
      form: {
        username: "",
        password: "",
      },
      invalid: false
    };
  },
  methods: {
    //...mapActions("LogIn"),
    async submit() {
      const user = new FormData();
      user.append("username", this.form.username);
      user.append("password", this.form.password);
      try {
        //await this.LogIn(user);
        this.$router.push("/manage");
        this.invalid = false;
      } catch(error) {
        this.invalid = true;
      }
    },
    login: function() {
      this.isLoggedIn = true;
    }
  }
};
</script>
<template>
  <div class="outer-login">
    <div v-if="!isLoggedIn" class="loginBox">
      <img src="https://via.placeholder.com/600x200?text=Content Manager" class="login-banner" />
      <div class="inner-login">
        <h2>Sign in</h2>
        <form @submit.prevent="submit">
          <input type="username" name="username" id="username" placeholder="Username" /><br />
          <input type="password" name="password" id="password" placeholder="Password" />
          <br />
          <div class="submit-container">
            <input type="submit" value="Login" v-on:click="login" />
          </div>
          <div v-if="invalid"><span>Invalid Username or Password</span></div>
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
  background-color: #dd6962;
  font-family: "Kanit", sans-serif;
  margin: auto auto;
  border-radius: 10px;
}
.inner-login {
  margin: auto 130px;
  color: white;
}
.loginBox label,
h2 {
  text-align: left;
  margin-bottom: 56px;
}
#password {
  margin-bottom: 20px;
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
input:focus {
    border: none;
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
