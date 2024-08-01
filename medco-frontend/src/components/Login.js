// src/components/Login.js
import React from 'react';
import { Box, Button, FormControl, FormLabel, Input, Heading, VStack, useToast } from '@chakra-ui/react';
import FacebookLogin from 'react-facebook-login';
import { GoogleLogin } from '@react-oauth/google';

const Login = () => {
  const toast = useToast();

  const handleLogin = () => {
    // Handle login logic here
    toast({
      title: "Logged in successfully",
      status: "success",
      duration: 3000,
      isClosable: true,
    });
  };

  const responseFacebook = (response) => {
    console.log(response);
    toast({
      title: "Facebook login successful",
      status: "success",
      duration: 3000,
      isClosable: true,
    });
  };

  const responseGoogle = (response) => {
    console.log(response);
    toast({
      title: "Google login successful",
      status: "success",
      duration: 3000,
      isClosable: true,
    });
  };

  return (
    <Box p={8} maxWidth="500px" mx="auto">
      <Heading mb={6}>Login</Heading>
      <VStack spacing={4}>
        <FormControl id="email" isRequired>
          <FormLabel>Email address</FormLabel>
          <Input type="email" />
        </FormControl>
        <FormControl id="password" isRequired>
          <FormLabel>Password</FormLabel>
          <Input type="password" />
        </FormControl>
        <Button colorScheme="teal" width="full" onClick={handleLogin}>
          Login
        </Button>
        <FacebookLogin
          appId="your-facebook-app-id" // Replace with your Facebook app ID
          autoLoad={false}
          fields="name,email,picture"
          callback={responseFacebook}
        />
        <GoogleLogin
          onSuccess={responseGoogle}
          onFailure={(error) => console.log('Login Error:', error)}
        />
      </VStack>
    </Box>
  );
};

export default Login;
