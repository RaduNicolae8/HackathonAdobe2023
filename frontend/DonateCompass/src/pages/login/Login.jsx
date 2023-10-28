import React from 'react';
import './Login.scss';
import { Input, Button } from '@chakra-ui/react'
import { Link } from 'react-router-dom'

const Login = () => {

    return (
        <div className="login">
            <div className="center">

                <div className="left">
                    <div className="box">
                        <h1>Donate Compass</h1>
                        {/* <label htmlFor="email">Email</label> */}
                        <Input id="email" placeholder="Email" />
                        {/* <label htmlFor="password">Password</label> */}
                        <Input id="password" placeholder="Password" />
                        <Button colorScheme='green' variant='solid'>Login</Button>
                        <Link to="/register">
                            <Button colorScheme='green' variant='outline'>
                                Register
                            </Button>
                        </Link>

                    </div>
                </div>

                <div className="right">
                    <img src="../../donateBanner.png" alt="" />
                </div>

            </div>

        </div>
    )

}


export default Login;