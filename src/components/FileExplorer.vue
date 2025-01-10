<script setup lang="ts">

import FileView from "@/components/FileView.vue";
import FolderView from "@/components/FolderView.vue";
import FileCrumb from "@/components/FileCrumb.vue";
import { useViewState } from "@/stores/view_state";

//TODO add explorer state
const state = useViewState();
</script>

<template>
  <div id="explorer-view">
    <FileCrumb :path="state.currentPath" />
    <FolderView id="folder-list"></FolderView>
    <FileView id="file-list"></FileView>
  </div>
</template>

<style scoped>

</style>