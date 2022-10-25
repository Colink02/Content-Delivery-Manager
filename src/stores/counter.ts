import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useCounterStore = defineStore("LogIn", {
  actions: {
    login: async (user: FormData) => {
      console.log("Log in called: with " + user.get("username") + " and " + user.get("password"));
    },
    logout: async () => {

    }
  }
});
