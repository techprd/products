import ProductService from "@/services/ProductService";

describe('data driven test for ProductsService.ts', () => {
  it('test canShowProduct filter logic for single product', () => {

    let product = {
      "index": 4,
      "isSale": true,
      "price": "$25.99",
      "productImage": "Product_5.jpeg",
      "productName": "Aquila Spark SauvB Bottle",
      "type": "Wine"
    };

    [
      {filter: "Wine", outcome: true},
      {filter: "isSale", outcome: true},
      {filter: "Beer", outcome: false},
    ].forEach(function (filterState) {
      let outcome = ProductService.canShowProduct(product, filterState.filter);
      expect(outcome).toBe(filterState.outcome);
    })
  });
});
