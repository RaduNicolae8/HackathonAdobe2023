import React from 'react'
import './Navbar.scss'
import { Link } from 'react-router-dom'
import { Stack } from "@chakra-ui/react"

function Navbar() {
  return (

    <Stack direction='row' className="navbar">
        <Link to="/home" className='link'>
            <p className='title'>DonateCompass</p>
        </Link>
        <div className="links">
            <Link to="/add" className='link'>Add Donation</Link>
            <Link to="/view" className='link'>View Donations</Link>
            <Link to="/requests" className='link red'>Donation Requests</Link>

        </div>
    </Stack>

  )
}

export default Navbar