import { defineStore } from "pinia";

export const useViewState = defineStore("AppState", {
  state: () => ({ showDetails: true, selectedItems: {} }),
  getters: {
    selectedFileNames: (state) => {
      console.log(typeof state.selectedFiles);
      console.log(state.selectedFiles);
      // return state.selectedItems.map(file => file.name).join(" ");
      return "NOT IMPLEMENTED";
    },
    selectedFilesAndFolders: (state) => {
      return state.selectedItems;
    }
  },
  actions: {
    toggleDetails() {
      this.showDetails = !this.showDetails;
    },
    addSelectedItem(id: string, type: string, allowMultiple: boolean = false) {
      if(!allowMultiple) {
        console.log("Not allowing multiple");
        const oldFolders = {};
        Object.assign(oldFolders, this.selectedItems);
        this.selectedItems = {};
        if(id in oldFolders) {
          console.log("Clearing and pushing");
        } else {
          console.log("Adding ", type);
          this.selectedItems[id] = { "type": type };
        }
      } else {
        if(this.selectedItems.includes(id)) {
          this.selectedItems = Object.entries(this.selectedItems).filter((itemId) => itemId !== id);
        } else {
          this.selectedItems[id] = { "type": type };
        }
      }
      console.log(this.selectedItems);
    },
    clearSelection() {
      this.selectedFiles = {};
    }
  },
});