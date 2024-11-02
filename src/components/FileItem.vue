<script setup lang="ts">
import { useViewState } from "@/stores/view_state";

const props = defineProps(["file_type_icon", "file_name", "preview_image_url"]);
// const dragItem = useTemplateRef("draggableItem");
// //TODO cleanup and get drag and drop element to show up with correct info when the user drags a file
//
// function startDrag(e: DragEvent) {
//   e.dataTransfer?.setDragImage(new Image(), 0, 0);
//   dragging.value = true;
// }
// function removeDrag(e: DragEvent) {
//   console.log("removing drag");
//   dragging.value = false;
// }
// function ondrag(e: DragEvent) {
//   console.log("dragging: ", e.clientX, e.clientY);
// }

function handleSelect(e: MouseEvent) {
  useViewState().addSelectItem(props.file_name);
}
</script>

<template>
  <div
    class="file"
    :class="{selected: useViewState().selectedFiles.includes(props.file_name)}"
    ref="file-ref"
    @click="handleSelect"
    draggable="true"
  >
    <div>
      <img
        class="file-type-icon"
        :src="file_type_icon"
        height="32"
        alt="File type Icon"
      />
      <span class="file-name">{{ file_name }}</span>
    </div>
    <img class="file-preview" :src="preview_image_url" alt="Preview of file" />
  </div>
</template>

<style scoped>
.file {
  user-select: none;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  background-color: #244a68;
  width: 250px;
  height: 250px;
  filter: drop-shadow(0.35rem 0.35rem 0.4rem rgba(0, 0, 0, 0.25));
}

.file-type-icon {
  width: 24px;
  margin: 5px;
  display: inline-block;
  float: left;
}

.file-name {
  display: inline-block;
  text-align: left;
  margin-left: 10px;
  color: white;
  clear: left;
  font-size: 12pt;
  margin-top: 7px;
}

.selected {
  border: #b1e0e2 solid 1px;
}

</style>
