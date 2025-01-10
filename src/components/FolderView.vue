<script setup lang="ts">
import FolderItem from "@/components/FolderItem.vue";
import { v4 as uuid } from "uuid";
import { useViewState } from "@/stores/view_state";
import { storeToRefs } from "pinia";

let state = useViewState();

const folders = storeToRefs(state.items.folders);

function setTransitionDelays(el: Element) {
  if(typeof el === typeof HTMLElement) {
    el.style.transitionDelay = `${el.getAttribute("index") * 0.01}s`;
  }
}

</script>

<template>
  <div class="folder-view">
    <h4>Folders</h4>
    <div class="folders">
      <TransitionGroup name="fade-in" @before-enter="setTransitionDelays">
        <folder-item :folder_name="folder.name" folder_icon="/icons/folder.svg" v-for="(folder, index) in folders" :key="folder.name" v-bind:index="index" >
        </folder-item>
      </TransitionGroup>
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
.fade-in-enter-active,
.fade-in-leave-active {
  transition: all 0.5s ease;
}
.fade-in-enter-from,
.fade-in-leave-to {
  opacity: 0;
}

</style>
