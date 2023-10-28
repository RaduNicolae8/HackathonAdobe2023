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


function App() {
 
  const Layout = () => {

    return (
      <div className="app">

        <Outlet>
          <Login/>
        </Outlet>

      </div>
    )
  }

  const router = createBrowserRouter([
    {
      path: "/",
      element: <Login />,
      children: [
      {
        path: "/login",
        element: <Login/>
      },
      {
        path: "/register",
        element: <Register/>
      },
      ]
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
