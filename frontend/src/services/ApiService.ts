import axios from 'axios';

export default class ApiService {

  /**
   * call the backend API and get a list of products via AJAX call
   */
  public static async getProducts() {
    return axios.get('/api/products');
  }
}
