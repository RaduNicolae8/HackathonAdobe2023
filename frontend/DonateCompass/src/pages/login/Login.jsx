import React from 'react';
import './Login.scss';
import { Input, Button } from '@chakra-ui/react'
import { Link } from 'react-router-dom'
import newRequest from '../../utils/newRequest';
import { useNavigate } from 'react-router-dom'

const Login = () => {

    const [email, setEmail] = React.useState('');
    const [password, setPassword] = React.useState('');
    const navigate = useNavigate();


    const submit = () => {
        const user = {
            "email": email,
            "password": password
        }

        newRequest.post('/api/users/login' , user).then((res)=>{
            console.log(res.data);
            sessionStorage.setItem("jwt", "Bearer " + res.data);
            navigate("/home");
        }).catch((err)=>{
            console.log(err);
        })


    }

    return (
        
        <div className="login">
            <div className="center">

                <div className="left">
                    <div className="box">
                        <h1>Donate Compass</h1>
                        {/* <label htmlFor="email">Email</label> */}
                        <Input id="email" placeholder="Email"  onChange={(e)=>{setEmail(e.target.value)}}/>
                        {/* <label htmlFor="password">Password</label> */}
                        <Input id="password" placeholder="Password" onChange={(e)=>{setPassword(e.target.value)}}/>
                        <br />
                        <Link>
                            <Button colorScheme='green' variant='solid'  onClick={()=>{submit()}}>Login</Button>
                        </Link>

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