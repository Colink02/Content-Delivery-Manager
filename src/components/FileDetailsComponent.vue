<script setup lang="ts">
import { useViewState } from "@/stores/view_state";
function closeDetails() {
  useViewState().toggleDetails();
}
defineProps(["file_name", "file_type_icon"]);
</script>

<template>
  <div class="file-details">
    <div class="detail-header">
      <span class="file-name"
        ><img :src="file_type_icon" alt="file icon" class="file-icon" />&nbsp;{{
          file_name
        }}</span
      >
      <button
        class="btn-close detail-close-btn"
        @click="closeDetails()"
      ></button>
    </div>
  </div>
</template>

<style scoped>
.file-details {
  display: inline-flex;
  height: 100%;
  width: 375px;
  background-color: #244a68;
  box-shadow: inset 3px 0 rgba(0, 0, 0, 0.25);
}
.detail-header {
  height: 55px;
  width: 100%;
  padding: 15px;
}
.file-name {
  text-align: left;
  font-size: 14pt;
  width: 75%;
  white-space: nowrap;
  overflow: hidden;
  display: block;
  text-overflow: ellipsis;
  float: left;
}
.file-icon {
  width: 25px;
}
.detail-close-btn {
  display: inline-block;
  float: right;
  vertical-align: middle;
}
</style>
