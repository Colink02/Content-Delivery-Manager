<script setup lang="ts">
const props = defineProps(['file_name', 'file_preview_img', "handleDrag"]);

// TODO make it so you can drag and drop files onto folders and it shows a little thing following your cursor

</script>

<template>
  <div class="draggable" >
    <span>{{ file_name }}</span>
  </div>
</template>

<style scoped>
.draggable {
  width: 100px;
  height: 100px;
  background-color: #244a68;
  border: 1px solid #ccc;
  cursor: move;
  position: absolute;
}
</style>