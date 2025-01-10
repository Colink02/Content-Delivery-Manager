<script setup lang="ts">
  const filters = defineProps(["filters"]);
</script>

<template>
  <div class="filters">
    <select class="filter-select file-type" name="File Type">
      <option>All Files</option>
      <option>Text Files</option>
      <option>Spreadsheets</option>
    </select>
  </div>
</template>

<style scoped>
.filters {
  width: 100%;
  display: inline;
  padding-left: 20px;
}
.filters select {
}
</style>