<script setup lang="ts">
import { useViewState } from "@/stores/view_state";
import BreadCrumbLink from "@/components/BreadCrumbLink.vue";

const data = useViewState();

</script>

<template>
  <div class="breadcrumb">
    <BreadCrumbLink v-for="link in data.currentFolder" :link="link.link" :folder_name="link.folder_name" :key="link.folder_name" />
  </div>
</template>

<style scoped>
.breadcrumb {
  padding-left: 20px;
  background-color: transparent;
}

</style>