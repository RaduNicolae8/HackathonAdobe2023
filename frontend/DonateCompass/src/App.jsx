import { useState } from 'react'
import './App.css'
import { ChakraProvider } from "@chakra-ui/react";
import Login from './pages/login/Login'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Register from './pages/register/Register';
import { Outlet } from 'react-router-dom';
import Home from './pages/home/Home';
import Add from './pages/add/Add';
import View from './pages/viewDonations/View';
import Requests from './pages/requests/Requests';
import AddRequest from './pages/addRequest/AddRequest';
import Donations from './pages/donations/Donations';


function App() {
 
  const Layout = () => {

    return (
      <div className="app">

          <Login/>
        
      </div>
    )
  }

  const router = createBrowserRouter([
    {
      path: "/",
      element: <Layout />
    },
    {
      path: "/login",
      element: <Login />
    },
    {
      path: "/register",
      element: <Register />
    },
    {
      path: "/home",
      element: <Home />
    },
    {
      path: "/add",
      element: <Add />
    },
    {
      path: "/view",
      element: <View />
    },
    {
      path: "/requests",
      element: <Requests />
    },
    {
      path: "/addRequest",
      element: <AddRequest />
    },
    {
      path: "/donations",
      element: <Donations />
    },
  ]);

  return (
    <div>
    <ChakraProvider>
      <RouterProvider router={router} />
    </ChakraProvider>
    </div>
  )

}

export default App
