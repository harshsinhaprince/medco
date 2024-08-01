import React from 'react';
import { Box, Image, Text } from '@chakra-ui/react';

const ProductCard = ({ product }) => {
  return (
    <Box bg="white" p={4} borderRadius="md" boxShadow="md">
      <Image src={product.image} alt={product.name} mb={4} />
      <Text fontWeight="bold">{product.name}</Text>
      <Text>{product.price}</Text>
    </Box>
  );
};

export default ProductCard;
