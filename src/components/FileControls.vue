<script setup lang="ts">
  import { useViewState } from "@/stores/view_state";
  import { storeToRefs } from "pinia";
  defineProps(["selectedItems"]);

  const { selectedFilesAndFolders } = storeToRefs(useViewState());

  function toggleDetails() {
    useViewState().toggleDetails();
  }

  function getSelectedItemsCount() {
    return Object.keys(selectedFilesAndFolders.value).length;
  }

</script>

<template>
<div class="file-controls">
  <span class="file-controls-selection" v-if="getSelectedItemsCount() > 0">
    <span>{{ getSelectedItemsCount() }} selected</span>
  </span>
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
  width: 100%;
  display: inline-block;
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
.file-controls-selection {
  clear: right;
  line-height: 2em;
  font-weight: bold;
  display: inline-block;
}
.file-controls-right {
  float: right;
}
</style>