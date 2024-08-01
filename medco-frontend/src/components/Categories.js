import React from 'react';
import { Box, Heading, SimpleGrid, Text } from '@chakra-ui/react';

const Categories = () => {
  return (
    <Box p={4}>
      <Heading mb={4}>Categories</Heading>
      <SimpleGrid columns={[2, null, 4]} spacing="40px">
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Category 1</Text>
        </Box>
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Category 2</Text>
        </Box>
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Category 3</Text>
        </Box>
        <Box bg="gray.100" p={4} borderRadius="md">
          <Text>Category 4</Text>
        </Box>
      </SimpleGrid>
    </Box>
  );
};

export default Categories;
