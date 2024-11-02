<script setup lang="ts">
  import { useViewState } from "@/stores/view_state";
  defineProps(["selectedItems"]);
  function toggleDetails() {
    useViewState().toggleDetails();
  }
</script>

<template>
<div class="file-controls">
  <div class="file-controls-selection" v-if="selectedItems.length > 0">
    <span>{{ selectedItems }} selected</span>
  </div>
  <div class="file-controls-right">
    <a href="#" @click="toggleDetails()">
      <img src="/icons/info.svg" alt="details" :class='["icon", useViewState().showDetails && "icon-active"]'>
    </a>
  </div>
</div>
</template>

<style scoped>
.file-controls {
  height: 65px;
  padding: 15px 25px;
}
.icon {
  padding: 5px;
}
.icon-active {
  background-color: rgba(225, 245, 254, 0.56);
  border-radius: 50%;
  color: black;
}
.file-controls-right {
  text-align: right;
  display: block;
}
</style>