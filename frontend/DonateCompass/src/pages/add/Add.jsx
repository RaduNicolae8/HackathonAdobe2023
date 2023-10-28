import React from 'react'
import './Add.scss'
import Navbar from '../../components/Navbar/Navbar'
import { Select, Input, Textarea, Button } from "@chakra-ui/react"
import { useState } from 'react';
import axios from 'axios';

function Add() {

  const [image, setImage] = useState("");

  const submit = async (e) => {
     const url = uploadFile(image);
    //  console.log(url);
    // console.log(image);
  
  };

  const uploadFile = async (file) => {
    const data = new FormData();
    data.append("file", file);
    data.append("upload_preset", "DonateCompass");

    try{
      const res = await axios.post(
        "https://api.cloudinary.com/v1_1/di0ub0hhl/image/upload",
        data
      );
      console.log(res.data.url);
      return res.data.url;
    }catch(err){
      console.log(err);
    }
  };

  return (
    <>
        <Navbar/>
        <div className="container">

          <div className="innerContainer">

            <h1 className="title">Add New Donation</h1>

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
            <Input id='image' type='file'  className='input' onChange={(e)=>{setImage(e.target.files[0])}}/>

            <Button colorScheme='green' variant='solid' onClick={()=>{submit()}}>Add</Button>

          </div>

        </div>    
    </>
  )
}

export default Add