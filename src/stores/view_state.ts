import { defineStore } from "pinia";

type ItemData = {
  type: string;
  id: string;
};
type FileSystem = {
  folders: {
    name: string;
    special_types: Array<string>;
  }[],
  files: {
     name: string;
  }[]
}
type StoreData = {
  showDetails: boolean;
  currentPath: string;
  selectedItems: ItemData[];
  items: FileSystem;
}

export const useViewState = defineStore("AppState", {
  state: () => ({
    showDetails: true,
    currentPath: "",
    selectedItems: {},
    items: {}
  } as StoreData),
  getters: {
    selectedFileNames: (state) => {
      return state.showDetails;
    },
    selectedFilesAndFolders: (state) => {
      return state.selectedItems;
    },
    currentPathString: (state) => {
      return state.currentPath;
    }
  },
  actions: {
    toggleDetails() {
      this.showDetails = !this.showDetails;
    },
    addSelectedItem(id: string, type: string, allowMultiple: boolean = false) {
      if(!allowMultiple) {
        this.selectedItems.length = 0;
        this.selectedItems.push({id, type });
      } else {
        this.selectedItems.push({id, type});
      }
      console.log(this.selectedItems);
    },
    clearSelection() {
      this.selectedItems.length = 0;
    },
    open(id: string) {
      this.selectedItems.filter(item => item.id == id).map((item: ItemData) => {
        //TODO open file / folder
        // Needs to select the appropriate function to view file/folder
        openItem(item.id, item.type);
      });
    },
    openFolder(folder: string) {
      fetch(`http://localhost:8080/files?directory=${folder}`).then(
        res => res.json()
      ).then(json => {
        console.log("data received: ", json);
        this.$state.items = json;
      });
    }
  },
});