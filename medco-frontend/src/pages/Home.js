import React from 'react';
import Banner from '../components/Banner';
import Categories from '../components/Categories';
import FeaturedProducts from '../components/FeaturedProducts';
import Footer from '../components/Footer';
import { Box } from '@chakra-ui/react';

const Home = () => {
  return (
    <Box>
      <Banner />
      <Categories />
      <FeaturedProducts />
      <Footer />
    </Box>
  );
};

export default Home;
