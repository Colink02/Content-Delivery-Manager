<script setup lang="ts">
import FolderItem from "@/components/FolderItem.vue";
import { ref } from "vue";
import { useViewState } from "@/stores/view_state";
import { v4 as uuid } from "uuid";

let folders = ref([]);

fetch("http://localhost:8080/files").then(
  res => res.json()
).then(json => {
  console.log("data recieved: ", json);
  folders.value = json.folders;
});

function updateSelection() {
  useViewState().clearSelection();
}

function generateId () {
  return uuid();
}

</script>

<template>
  <div class="folder-view">
    <h4>Folders</h4>
    <div class="folders">
      <folder-item :folder_name="folder.name" folder_icon="/icons/folder.svg" :id="generateId()" v-for="folder in folders" :key="folder.name" >
      </folder-item>
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
