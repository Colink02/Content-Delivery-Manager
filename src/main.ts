import { createApp, markRaw } from "vue";
import { createPinia } from "pinia";
import App from "./App.vue";
import { useRouter } from "vue-router";

const app = createApp(App);


const pinia = createPinia();

// pinia.router = useRouter();

// pinia.use(({ store }) => {
//   store.router = markRaw(useRouter());
// });

app.use(pinia);

app.mount("#app");
