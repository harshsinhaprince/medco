import React from 'react';
import { Box, Heading, SimpleGrid, Text } from '@chakra-ui/react';

const FeaturedProducts = () => {
  return (
    <Box p={4}>
      <Heading mb={4}>Featured Products</Heading>
      <SimpleGrid columns={[2, null, 4]} spacing="40px">
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Product 1</Text>
        </Box>
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Product 2</Text>
        </Box>
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Product 3</Text>
        </Box>
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Product 4</Text>
        </Box>
      </SimpleGrid>
    </Box>
  );
};

export default FeaturedProducts;
