<script setup lang="ts">

const props = defineProps(["currentPath"]);

</script>

<template>
  <div class="breadcrumb">
    {{ props.currentPath }}
  </div>
</template>

<style scoped>

</style>