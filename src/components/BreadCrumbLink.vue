<script setup lang="ts">
const props = defineProps(["link", "folder_name"])

</script>

<template>
  <span>
    <a :href="props.link">{{ props.folder_name }}</a>
    /
  </span>
</template>

<style scoped>

</style>