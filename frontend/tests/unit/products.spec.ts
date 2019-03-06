import {shallowMount} from '@vue/test-utils';
import Products from '@/components/Products.vue';

describe('Products.vue', () => {
  it('renders props.pageTitle when passed', () => {
    const pageTitle = 'Product List';
    const wrapper = shallowMount(Products, {
      propsData: {pageTitle},
    });
    expect(wrapper.text()).toMatch(pageTitle);
  });
});
