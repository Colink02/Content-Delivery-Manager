<script lang="ts">
import FileDetailsComponent from "@/components/FileDetailsComponent.vue";
import FileSystemView from "@/components/FileSystemView.vue";
import FileControls from "@/components/FileControls.vue";
import { useViewState } from "@/stores/view_state";
import FileExplorer from "@/components/FileExplorer.vue";

function allowDrop(e: DragEvent) {
  e.preventDefault();
  if(e.dataTransfer == null) return;
  e.dataTransfer.effectAllowed = "copy";
}
function removeSelectedItems() {
  console.log("Removing selected items");
  useViewState().clearSelection();
}

async function uploadFile(file: File) {}

export default {
  components: {
    FileExplorer,
    FileSystemView,
    FileDetailsComponent,
  },
  methods: {
    useViewState,
    allowDrop,
    uploadFile,
    removeSelectedItems
  },
};
</script>
<template>
  <div @dragenter="allowDrop" @drag="uploadFile"></div>
  <div id="main-content">
    <div id="content">
      <div id="header">
        <FileSystemView></FileSystemView>
      </div>
      <FileExplorer />
    </div>
    <Transition name="slide">
    <FileDetailsComponent
      id="file-details"
      file_type_icon="https://placehold.co/64"
      file_name="test.txt"
      v-if="useViewState().showDetails"
    ></FileDetailsComponent>
    </Transition>
  </div>
</template>
<style>
#app {
  background-color: #092333;
  width: 100%;
}
#main-content {
  flex-direction: row;
  flex: 1 0 content;
  display: flex;
  height: 100%;
  color: white;
}
#file-list {
  height: 100%;
}
#content {
  flex-direction: row;
  width: 100%;
}
#header {
  clear: right;
}

#file-details {
  transition-property: width;
  transition-timing-function: cubic-bezier(0.4,0,1,1);
  will-change: width;
  overflow: hidden;
  width: 375px;
  transition: width 0.5s ease-in-out;
}

#file-details.slide-enter-active, #file-details.slide-leave-active {
  transition: width 0.5s ease-in-out;
}
#file-details.slide-enter-from {
  width: 0;
}

#file-details.slide-enter-to {
  //transform: translateX(0);
  width: 375px;
}
#file-details.slide-leave-to {
  //transform: translateX(100%);
  width: 0;
}
</style>
