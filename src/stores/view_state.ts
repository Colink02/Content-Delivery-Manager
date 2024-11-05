import { defineStore } from "pinia";

export const useViewState = defineStore("AppState", {
  state: () => ({ showDetails: true, files: [], selectedFiles: [] }),
  getters: {
    selectedFileNames: (state) => {
      console.log(typeof state.selectedFiles);
      console.log(state.selectedFiles);
      return state.selectedFiles.map(file => file.name).join(" ");
    }
  },
  actions: {
    toggleDetails() {
      this.showDetails = !this.showDetails;
    },
    addSelectItem(item: string) {
      if(this.selectedFiles.length > 0) {
        this.selectedFiles = [];
      }
      this.selectedFiles.push(item);
    },
    clearSelection() {
      this.selectedFiles = [];
    }
  },
});