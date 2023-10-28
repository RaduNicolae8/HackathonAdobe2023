import React from 'react'
import './Home.scss'
import Navbar from '../../components/Navbar/Navbar'
import { Stack } from "@chakra-ui/react"

function Home() {
  return (
    <>
    <Navbar/>    
    <div className="container">

        <Stack direction='row' className='section'>
            <div className="image">
                <img src="../../who.jpg" alt="DonateCompass"/>
            </div>
            <div className="text">
                <h1 className="title">Who We Are</h1>
                <p className="subtitle">
                DonateCompass is your compass for making a difference. 
                We are dedicated to connecting compassionate individuals with the causes they care about most.
                Our mission is simple yet powerful: we facilitate the journey of those who wish to give by helping them find the perfect destination for their donations.
                Whether it's your gently used clothes finding a new home at a local orphanage, or your time and resources benefiting a community in need, DonateCompass empowers you to make a positive impact.
                Join us in making giving back a seamless and rewarding experience for all. Together, we can navigate the path to a more compassionate world.
                </p>
            </div>
        </Stack>
        
        <Stack direction='row' className='section'>
          <div className="image">
                  <img src="../../involved.jpg" alt="DonateCompass"/>
              </div>
              <div className="text">
                  <h1 className="title">Get Involved!</h1>
                  <p className="subtitle">
                  We believe in the power of collective action, and we invite you to join us in making a difference.
                  Whether you're looking to volunteer your time, organize a fundraising event, or advocate for a cause close to your heart,
                  there are numerous ways to contribute beyond traditional donations. At DonateCompass, we're committed to fostering a sense
                  of purpose and connection through meaningful engagement. Together, we can amplify the impact of our collective efforts and 
                  create a world where giving back knows no bounds. 
                  Explore the various opportunities to get involved, and let's inspire positive change together.
                  </p>
          </div>
        </Stack>

    </div>
    
    </>
  )
}

export default Home