// src/components/Register.js
import React from 'react';
import { Box, Button, FormControl, FormLabel, Input, Heading, VStack, useToast } from '@chakra-ui/react';

const Register = () => {
  const toast = useToast();

  const handleRegister = () => {
    // Handle registration logic here
    toast({
      title: "Registered successfully",
      status: "success",
      duration: 3000,
      isClosable: true,
    });
  };

  return (
    <Box p={8} maxWidth="500px" mx="auto">
      <Heading mb={6}>Register</Heading>
      <VStack spacing={4}>
        <FormControl id="name" isRequired>
          <FormLabel>Full Name</FormLabel>
          <Input type="text" />
        </FormControl>
        <FormControl id="email" isRequired>
          <FormLabel>Email address</FormLabel>
          <Input type="email" />
        </FormControl>
        <FormControl id="password" isRequired>
          <FormLabel>Password</FormLabel>
          <Input type="password" />
        </FormControl>
        <Button colorScheme="teal" width="full" onClick={handleRegister}>
          Register
        </Button>
      </VStack>
    </Box>
  );
};

export default Register;
