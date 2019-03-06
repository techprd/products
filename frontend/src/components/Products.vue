<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div class="album py-5 bg-light">
      <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <div class="right">
              <ul class="navbar-nav right" style="width: 20%">
                <li class="nav-item right">
                  <select class="form-control nav-link">
                    <option>all</option>
                    <option>isSale</option>
                    <option>Spirits</option>
                    <option>Beer</option>
                    <option>Cider</option>
                    <option>Wine</option>
                  </select>
                </li>
              </ul>
              <a class="navbar-brand right" href="#" style="width: 10%">Filter By</a>
            </div>
          </div>
        </nav>
        <div class="row">
          <div v-for="product in products" class="col-md-3">
            <div class="card mb-4 shadow-sm">
              <svg class="bd-placeholder-img card-img-top" width="100%" height="100" xmlns="http://www.w3.org/2000/svg"
                   preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
                   aria-label="Placeholder: Thumbnail"><title>{{product.productImage}}</title>
                <rect width="100%" height="100%" fill="#55595c"></rect>
                <text x="30%" y="50%" fill="#eceeef" dy=".3em">{{product.productImage}}</text>
              </svg>
              <div class="card-body">
                <p class="card-text">Product Name: {{product.productName}}</p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted">{{product.price}}</small>
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
  import {Component, Prop, Vue} from 'vue-property-decorator';
  import ApiService from "@/services/ApiService";

  @Component
  export default class Products extends Vue {
    @Prop() private msg!: string;

    public products: any = null;

    private mounted() {
      ApiService.getProducts().then((response: any) => {
        this.products = response.data;
      });
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

  .right {
    float: right;
    width: 100%;
  }

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
