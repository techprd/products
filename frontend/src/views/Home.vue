<template>
  <div class="home">
    <Products pageTitle="Product List"/>
  </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator';
  import Products from '@/components/Products.vue'; // @ is an alias to /src

  @Component({
    components: {
      Products,
    },
  })
  export default class Home extends Vue {
  }
</script>
