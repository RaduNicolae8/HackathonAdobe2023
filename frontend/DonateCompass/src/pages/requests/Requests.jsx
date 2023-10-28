import React from 'react'
import './Requests.scss'
import Navbar from '../../components/Navbar/Navbar'
import DonationCard from '../../components/DonationCard/DonationCard'
import { Input, Select } from '@chakra-ui/react'

function Requests() {

  const item1 ={
    "image" : "https://i.imgur.com/G3YDkr3.jpeg",
    "title" : "Donating my old baby clothes",
    "firstName" : "Edi",
    "lastName" : "Radu",
    "description" : "These are some Baby clothes for 0-3 months",
    "phone" : "0748406221"
  }

  const item2 ={
    "image" : "https://i.imgur.com/dtqaTRD.jpeg",
    "title" : "Donating old sofa",
    "firstName" : "Vlad",
    "lastName" : "Oancea",
    "description" : "In very good shape",
    "phone" : "0798783511"
  }

  return (
    <>
    <Navbar/>    

    <div className="requestsContainer">

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
        <DonationCard item={item1}/>
        <DonationCard item={item2}/>
        {/*<DonationCard item={item}/>*/}
        {/*<DonationCard item={item}/>*/}
        {/*<DonationCard item={item}/>*/}
        {/*<DonationCard item={item}/>*/}
        {/*<DonationCard item={item}/>*/}
        {/*<DonationCard item={item}/>*/}
        {/*<DonationCard item={item}/>*/}
        {/*<DonationCard item={item}/>*/}
      </div>

    </div>
    
    </>
  )
}

export default Requests