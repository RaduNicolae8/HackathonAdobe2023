import React from 'react'
import './AddRequest.scss'
import Navbar from '../../components/Navbar/Navbar'
import { Select, Input, Textarea, Button } from "@chakra-ui/react"
import { useState } from 'react';
import axios from 'axios';

function AddRequest() {

  const submit = async (e) => {
 
  };


  return (
    <>
        <Navbar/>
        <div className="addContainer">

          <div className="innerContainer">

            <h1 className="title">Request A New Donation</h1>

            <Select id='productType' placeholder='Product Type' className='input'>
              <option value='option1'>Consumables</option>
              <option value='option2'>Food</option>
              <option value='option3'>Kid Clothes</option>
              <option value='option4'>Baby Clothes</option>
              <option value='option5'>Adult Clothes</option>
              <option value='option6'>Materials</option>
              <option value='option7'>General Items</option>
            </Select>

            <Input id='title' placeholder='title' className='input'/>
            <Textarea id='description' placeholder='description' className='input'/>
            <Select id='state' placeholder='Condition' className='input'>
              <option value='option1'>New</option>
              <option value='option2'>Used</option>
            </Select>
            <Input id='location' placeholder='location' className='input'/>

            <Select id='severity' placeholder='Severity' className='input'>
              <option value='option1'>High Severity</option>
              <option value='option2'>Medium Severity</option>
              <option value='option3'>Low Severity</option>
            </Select>

            <Button colorScheme='green' variant='solid' onClick={()=>{submit()}}>Add</Button>

          </div>

        </div>    
    </>
  )
}

export default AddRequest