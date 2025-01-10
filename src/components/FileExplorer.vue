<script setup lang="ts">

import FileView from "@/components/FileView.vue";
import FolderView from "@/components/FolderView.vue";
import FileCrumb from "@/components/FileCrumb.vue";
import { useViewState } from "@/stores/view_state";
import Empty from "@/components/Empty.vue";
import FileControls from "@/components/FileControls.vue";

//TODO add explorer state
const state = useViewState();
const filters = [];
</script>

<template>
  <div id="explorer-view">
    <div class="toolbar">
      <FileCrumb :path="state.currentPath" />
      <FileControls></FileControls>
    </div>
    <div class="file-system">
      <FolderView id="folder-list" v-if="state.items?.folders"></FolderView>
      <FileView id="file-list" v-if="state.items?.files"></FileView>
      <Empty />
    </div>
  </div>
</template>

<style scoped>
.toolbar {
  display: flex;
  float: left;
}
.file-system {
  clear: right;
  overflow-y: scroll;
  height: 100%;
}
#explorer-view {
  height: 94%;
  flex-direction: column;
  display: flex;
}
</style>