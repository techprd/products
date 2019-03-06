import axios from 'axios';

export default class ApiService {

  public static async getProducts() {
    return axios.get('/api/products');
  }
}
