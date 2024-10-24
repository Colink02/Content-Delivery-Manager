<script lang="ts">
export default {};
</script>
<template>
  <nav class="navbar navbar-expand-lg bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Dashboard</a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/home">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/files">Files</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/users">Users</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div id="main-content">
    <div id="file-list">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">File Name</th>
            <th scope="col">Last Modified</th>
            <th scope="col">File Created</th>
            <th scope="col">Link</th>
          </tr>
          <!--TODO auto populate with all files from the setup folder-->
        </thead>
      </table>
    </div>
    <div id="file-details">
      <h1>File Details</h1>
    </div>
  </div>
</template>
<style>
#app {
  background-color: #d2e9fc;
  width: 100%;
}
#main-content {
  flex: 1 0 content;
  display: flex;
  height: 100%;
}
#file-details {
  display: flex-inline;
  background-color: #edffff;
  padding: 25px;
  height: 100%;
  width: 25%;
  box-shadow: inset 3px 0px rgba(0, 0, 0, 0.25);
}
#file-details h1 {
  text-align: center;
  color: #78909c;
}
#file-list {
  display: flex-inline;
  height: 100%;
  width: 75%;
}
</style>
