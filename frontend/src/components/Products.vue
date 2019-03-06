<template>
  <div>
    <h1>{{ pageTitle }}</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <div class="right">
          <ul class="navbar-nav right" style="width: 30%">
            <li class="nav-item right">
              <select v-model="filterValue" class="form-control nav-link">
                <option>all</option>
                <option>isSale</option>
                <option>Spirits</option>
                <option>Beer</option>
                <option>Cider</option>
                <option>Wine</option>
              </select>
            </li>
          </ul>
          <a class="navbar-brand right" href="#" style="width: 20%">Filter By:</a>
        </div>
      </div>
    </nav>
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row">
          <div v-for="product in products" class="col-md-3" v-if="canShowProduct(product)">

            <div class="card mb-4 shadow-sm">
              <i class="icon ion-md-heart salesIcon" v-if="product.isSale"> On Sale</i>
              <svg class="bd-placeholder-img card-img-top" width="100%" height="100" xmlns="http://www.w3.org/2000/svg"
                   preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
                   aria-label="Placeholder: Thumbnail"><title>{{product.productImage}}</title>
                <rect width="100%" height="100%" fill="#55595c"></rect>
                <text x="30%" y="50%" fill="#eceeef" dy=".3em">{{product.productImage}}</text>
              </svg>
              <div class="card-body">
                <p class="card-text">{{product.productName}}</p>
                <small class="text-muted">{{product.price}}</small>
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
  import ProductService from "@/services/ProductService";

  @Component
  export default class Products extends Vue {

    public products: any = null;
    public filterValue: string = "all";

    @Prop() private pageTitle!: string;

    /**
     * when the component is mounted (before rendering)
     * get all products via backend API
     */
    private mounted() {
      ApiService.getProducts().then((response: any) => {
        this.products = response.data;
      });
    }

    /**
     * calculate if the product should show on the page
     * based on the filter value set from dropdown values
     * @param product
     * @return true if filter level is all or filterValue is part of product type
     */
    canShowProduct(product: any) {
      return ProductService.canShowProduct(product, this.filterValue);
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

  .collapse:not(.show) {
    display: block;
  }

  .salesIcon {
    position: absolute;
    color: #f3ff5e;
    margin-left: 10px;
    font-weight: bold;
  }

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
