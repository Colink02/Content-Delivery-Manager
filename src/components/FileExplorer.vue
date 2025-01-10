<script setup lang="ts">

import FileView from "@/components/FileView.vue";
import FolderView from "@/components/FolderView.vue";
import FileCrumb from "@/components/FileCrumb.vue";
import { useViewState } from "@/stores/view_state";
import Empty from "@/components/Empty.vue";
import FileControls from "@/components/FileControls.vue";
import { useRouter } from "vue-router";
import { onMounted } from "vue";

//TODO add explorer state
const state = useViewState();
const router = useRouter();
onMounted(async () => {
  if(state.currentPath === "") {
    console.log(router.currentRoute.value);
    state.currentPath = router.currentRoute.value;
  }
});
const filters = [];
</script>

<template>
  <div id="explorer-view">
    <RouterView>
    <div class="toolbar">
      <FileCrumb :path="state.currentPath" />
      <FileControls></FileControls>
    </div>
    <div class="file-system">
      <FolderView id="folder-list" v-if="state.items?.folders"></FolderView>
      <FileView id="file-list" v-if="state.items?.files"></FileView>
      <Empty />
    </div>
    </RouterView>
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