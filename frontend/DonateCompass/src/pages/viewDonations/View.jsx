import React from 'react'
import './View.scss'
import Navbar from '../../components/Navbar/Navbar'
import DonationCard from '../../components/DonationCard/DonationCard'
import { Input, Button } from '@chakra-ui/react'

function View() {

  const item ={
    "image" : "http://res.cloudinary.com/di0ub0hhl/image/upload/v1698496362/DonateCompass/rfgtdne02o7kndg3gzwk.jpg",
    "title" : "Donating my old baby clothes",
    "firstName" : "John",
    "lastName" : "Doe",
    "description" : "These are some Baby clothes for 0-3 months lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
    "phone" : "0748406221"
  }

  return (
    <>
    <Navbar/>    

    <div className="viewContainer">

      <div className="header">
        <Input id="search" placeholder='Search'/>
      </div>

      <div className="cards">
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
        <DonationCard item={item}/>
      </div>

    </div>
    
    </>
  )
}

export default View