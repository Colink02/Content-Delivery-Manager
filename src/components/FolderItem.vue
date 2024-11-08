<script setup lang="ts">
import { ref } from "vue";

defineProps(["folder_icon", "folder_name"]);

let isSelected = ref(false);

function toggleSelect(event: MouseEvent) {
  if(event.detail == 1) {
    console.log("Selecting..");
    isSelected.value = !isSelected.value;
    console.log("Selected: ", isSelected.value);
  } else if(event.detail == 2) {
    //TODO open the folder
    useViewState()
  }
}

</script>

<template>
  <div class="folder" @click="toggleSelect" :class="{selected: isSelected}">
    <img :src="folder_icon" alt="Folder" class="folder-icon" />
    {{ folder_name }}
  </div>
</template>

<style scoped>
.folder {
  background-color: #666666;
  width: 250px;
  border-radius: 5px;
  filter: drop-shadow(0.35rem 0.35rem 0.4rem rgba(0, 0, 0, 0.25));
  height: 50px;
  padding: 10px;
  color: white;
  display: flex;
  flex-direction: row;
  user-select: none;
  align-items: center;
  border: transparent solid 2px;
}

.folder-icon {
  height: 100%;
  width: 24px;
  margin: 5px;
}

.selected {
  border: #b1e0e2 solid 2px;
}

</style>
