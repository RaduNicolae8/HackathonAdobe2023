import React, { useEffect } from 'react'
import './Navbar.scss'
import { Link } from 'react-router-dom'
import { Stack } from "@chakra-ui/react"
import { useNavigate } from 'react-router-dom'

function Navbar() {

  const navigate = useNavigate();

  const user ={
    "isDonor" : true
  }

  const loggedin = sessionStorage.getItem("jwt");

  useEffect(() => {
    loggedin ? console.log("logged in") : navigate("/login")
  }, [loggedin])

  return (
   
    <Stack direction='row' className="navbar">
        <Link to="/home" className='link'>
            <p className='title'>DonateCompass</p>
        </Link>
        <div className="links">

          {user.isDonor &&
          <>
            <Link to="/add" className='link'>Add Donation</Link>
            <Link to="/view" className='link'>My Donations</Link>
            <Link to="/requests" className='link red'>Donation Requests</Link>
          </>
          }

          {!user.isDonor &&
          <>
            <Link to="/addRequest" className='link'>Add Donation Request</Link>
            <Link to="/donations" className='link red'>Donations</Link>
          </>
          }

        </div>
    </Stack>

  )
}

export default Navbar