<script setup lang="ts">
import FileItem from "@/components/FileItem.vue";
import { ref } from "vue";
import { useViewState } from "@/stores/view_state";
import { v4 as uuid } from "uuid";

const files = ref([]);

fetch("http://localhost:8080/files").then((res) => res.json()).then((data) => {
  files.value = data.files;
})
function removeSelectedItems() {
  useViewState().clearSelection();
}

function generateId () {
  return uuid();
}

function setTransitionDelays(el: Element) {
  el.style.transitionDelay = `${el.getAttribute("index") * 0.01}s`;
}
</script>

<template>
  <div class="file-view" @mouseup="removeSelectedItems">
    <h4>Files</h4>
    <div class="files">
      <TransitionGroup @beforeEnter="setTransitionDelays" name="fade-in">
        <file-item :file_name="file.name" file_type_icon="/icons/file.svg" v-for="file in files" :key="file.name" :id="generateId()">
        </file-item>
      </TransitionGroup>
    </div>
  </div>
</template>

<style scoped>
.file-view {
  margin: 16px;
  width: 100%;
}
.files {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 10px;
  width: 100%;
  padding-bottom: 50px;
}

.fade-in-enter-active,
.fade-in-leave-active {
  transition: all 0.5s ease;
}
.fade-in-enter-from,
.fade-in-leave-to {
  opacity: 0;
}
</style>
