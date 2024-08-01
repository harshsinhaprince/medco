import React from 'react';
import ProductList from '../components/ProductList';
import Footer from '../components/Footer';
import { Box } from '@chakra-ui/react';

const ProductPage = () => {
  return (
    <Box>
      <ProductList />
      <Footer />
    </Box>
  );
};

export default ProductPage;
