import { defineStore } from "pinia";

export const useViewState = defineStore("AppState", {
  state: () => ({ showDetails: true, files: [], selectedFiles: [] }),
  getters: {
  },
  actions: {
    toggleDetails() {
      this.showDetails = !this.showDetails;
    },
    addSelectItem(item: string) {
      this.selectedFiles += item;
    }
  },
});