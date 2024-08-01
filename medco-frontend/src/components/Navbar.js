// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';
import { Box, Flex, Text, Button } from '@chakra-ui/react';

const Navbar = () => {
  return (
    <Box bg="teal.500" px={4}>
      <Flex h={16} alignItems="center" justifyContent="space-between">
        <Text fontSize="2xl" fontWeight="bold" color="white">Netmeds Clone</Text>
        <Flex>
          <Link to="/">
            <Button variant="ghost" color="white">Home</Button>
          </Link>
          <Link to="/products">
            <Button variant="ghost" color="white">Products</Button>
          </Link>
          <Link to="/login">
            <Button variant="ghost" color="white">Login</Button>
          </Link>
          <Link to="/register">
            <Button variant="ghost" color="white">Register</Button>
          </Link>
        </Flex>
      </Flex>
    </Box>
  );
};

export default Navbar;
