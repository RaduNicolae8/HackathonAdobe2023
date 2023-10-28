import React from 'react'
import './Donations.scss'
import Navbar from '../../components/Navbar/Navbar'
import DonationCard from '../../components/DonationCard/DonationCard'
import { Input, Select } from '@chakra-ui/react'

function Donations() {

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

    <div className="donationsContainer">

      <div className="header">
        <Input id="search" placeholder='Search'/>

        <div className="filters">
        
          <label htmlFor="LocationFilter">Location Filter</label>
          <Select id='LocationFilter' placeholder='Select Location' className='input'>
                <option value='option1'>Bucharest</option>
                <option value='option2'>Constanta</option>
          </Select>

          <label htmlFor="SeverityFilter">Severity Filter</label>
          <Select id='SeverityFilter' placeholder='Select Severity' className='input'>
                <option value='option1'>High</option>
                <option value='option2'>Medium</option>
                <option value='option3'>Low</option>
          </Select>

        </div>

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

export default Donations