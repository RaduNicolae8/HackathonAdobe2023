import React from 'react';
import './Register.scss';
import { Input, Button } from '@chakra-ui/react'
import { Link } from 'react-router-dom'
import { Switch, Stack } from "@chakra-ui/react"

const Register = () => {

    const [isDonator, setIsDonator] = React.useState(true)

    return (
        <div className="register">
            <div className="center">

                <div className="left">
                    <div className="box">
                        <h1>Donate Compass</h1>

                        <Stack direction='row' className='option'>
                            <p>Donator</p>
                            <Switch colorScheme='green' onChange={()=>{setIsDonator(!isDonator)}}/>
                            <p>ONG</p>
                        </Stack>

                        {isDonator &&
                            <>
                                <Input id="email" placeholder="Email" />
                                <br />
                                <Input id="password" placeholder="Password" />
                                <br />
                                <Input id="confirm password" placeholder="Confirm Password" />
                                <br />
                                <Input id="first name" placeholder="First Name" />
                                <br />
                                <Input id="last name" placeholder="Last Name" />
                                <br />
                                <Input id="phone" placeholder="Phone Number" />
                                <br />
                                <Input id="city" placeholder="City" />
                                <br />

                            </>
                        }

                        {!isDonator &&
                            <>
                                <Input id="email" placeholder="Email" />
                                <br />
                                <Input id="password" placeholder="Password" />
                                <br />
                                <Input id="confirm password" placeholder="Confirm Password" />
                                <br />
                                <Input id="name" placeholder="Name" />
                                <br />
                                <Input id="phone" placeholder="Phone Number" />
                                <br />
                                <Input id="city" placeholder="City" />
                                <br />
                                <Input id="activity" placeholder="Activity" />
                                <br />
                            </>
                        }
                        
                        <Button colorScheme='green' variant='solid'>Register</Button>
                        <Link to="/login">
                            <Button colorScheme='green' variant='outline'>
                                Go to login
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


export default Register;