<script setup lang="ts">
import { useViewState } from "@/stores/view_state";
import { storeToRefs } from "pinia";

const props = defineProps(["folder_icon", "folder_name", "id"]);

const state = useViewState();
const {
  selectedFilesAndFolders,
} = storeToRefs(state);

let isSelected = () => {
  return props.id in selectedFilesAndFolders.value;
};

function toggleSelect(event: MouseEvent) {
  if(event.detail == 1) {
    console.log("Selecting..", props.id);
    useViewState().addSelectedItem(props.id, "folder", false);
  } else if(event.detail == 2) {
    //TODO open the folder
    useViewState().open(props.id);
  }
}

</script>

<template>
  <div class="folder" @click="toggleSelect" :class="{selected: isSelected()}">
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
