<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div class="album py-5 bg-light">
      <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="#">Filter By</a>
          <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
              <li class="nav-item">
                <select class="form-control nav-link">
                  <option>Default select</option>
                </select>
              </li>
            </ul>
          </div>
        </nav>
        <div class="row">
          <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg"
                   preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
                   aria-label="Placeholder: Thumbnail"><title>Placeholder</title>
                <rect width="100%" height="100%" fill="#55595c"></rect>
                <text x="50%" y="50%" fill="#eceeef" dy=".3em">Product Image</text>
              </svg>
              <div class="card-body">
                <p class="card-text">Product Name: </p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted">$ Price</small>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
  import {Component, Prop, Vue} from 'vue-property-decorator'

  @Component
  export default class Products extends Vue {
    @Prop() private msg!: string;
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
  h3 {
    margin: 40px 0 0;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
