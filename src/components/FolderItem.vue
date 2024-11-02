<script setup lang="ts">
defineProps(["folder_icon", "folder_name"]);
</script>

<template>
  <div class="folder">
    <img :src="folder_icon" alt="Folder" class="folder-icon" />
    {{ folder_name }}
  </div>
</template>

<style scoped>
.folder {
  background-color: #244a68;
  width: 250px;
  border-radius: 5px;
  filter: drop-shadow(0.35rem 0.35rem 0.4rem rgba(0, 0, 0, 0.25));
  height: 50px;
  padding: 10px;
  color: white;
  display: flex;
  flex-direction: row;
  align-items: center;
}

.folder-icon {
  height: 100%;
  width: 24px;
  margin: 5px;
}
</style>
