<script setup lang="ts">
import FolderItem from "@/components/FolderItem.vue";
</script>

<template>
  <div class="folder-view">
    <h4>Folders</h4>
    <div class="folders">
      <FolderItem
        folder_icon="/icons/folder.svg"
        folder_name="Test"
      ></FolderItem>
      <FolderItem
        folder_icon="https://placehold.co/64"
        folder_name="Test"
      ></FolderItem>
      <FolderItem
        folder_icon="https://placehold.co/64"
        folder_name="Test"
      ></FolderItem>
      <FolderItem
        folder_icon="https://placehold.co/64"
        folder_name="Test"
      ></FolderItem>
      <FolderItem
        folder_icon="https://placehold.co/64"
        folder_name="Test"
      ></FolderItem>
      <FolderItem
        folder_icon="https://placehold.co/64"
        folder_name="Test"
      ></FolderItem>
    </div>
  </div>
</template>

<style scoped>
.folders {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 10px;
}
.folder-view {
  margin: 16px;
}
</style>
