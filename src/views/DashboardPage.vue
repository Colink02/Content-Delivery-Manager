<script lang="ts">
import FileView from "@/components/FileView.vue";
import FolderView from "@/components/FolderView.vue";
import FileDetailsComponent from "@/components/FileDetailsComponent.vue";
import FileSystemView from "@/components/FileSystemView.vue";
import FileControls from "@/components/FileControls.vue";
import { useViewState } from "@/stores/view_state";

function allowDrop(e) {
  e.preventDefault();
  e.dataTransfer.effectAllowed = "copy";
}
function removeSelectedItems() {
  console.log("Removing selected items");
  useViewState().clearSelection();
}

async function uploadFile(file: File) {}

export default {
  components: {
    FileControls,
    FileSystemView,
    FileDetailsComponent,
    FolderView,
    FileView,
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
        <FileControls :selected-items="useViewState().selectedFiles" />
      </div>
      <div id="explorer-view">
        <FolderView id="folder-list"></FolderView>
        <FileView id="file-list"></FileView>
      </div>
    </div>
    <FileDetailsComponent
      id="file-details"
      file_type_icon="https://placehold.co/64"
      file_name="test.txt"
      v-if="useViewState().showDetails"
    ></FileDetailsComponent>
    <!--    <div id="file-details">-->
    <!--      <h1>File Details</h1>-->
    <!--    </div>-->
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
#explorer-view {
  height: 86%;
  flex-direction: column;
  display: flex;
  overflow-y: scroll;
  overflow-x: hidden;
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
</style>
