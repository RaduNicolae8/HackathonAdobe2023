import React from 'react'
import './Add.scss'
import Navbar from '../../components/Navbar/Navbar'
import { Select, Input, Textarea, Button } from "@chakra-ui/react"
import { useState } from 'react';
import axios from 'axios';
import newRequest from '../../utils/newRequest';

function Add() {

  const [productType, setProductType] = useState("");
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [state, setState] = useState("");
  const [location, setLocation] = useState("");
  const [image, setImage] = useState("");

  function timeout(delay) {
    return new Promise( res => setTimeout(res, delay) );
}

const submit = async () => {
  const imageUrl = await uploadFile(image);
  const userId = await getAuthUser();
  const postEntity = {
    "productType": productType,
    "title": title,
    "description": description,
    "state": state,
    "location": location,
    "imageUrl": imageUrl,
    "userId": userId.id
  };

  console.log(postEntity);
  console.log("test:" + userId);
  console.log("testing");

  try {
    const response = await newRequest.post('/post/', postEntity, {
      headers: {
        'Authorization': sessionStorage.getItem("jwt")
      }
    });
    // You can access the response data here if needed: response.data
  } catch (error) {
    // Handle errors here
  }

  // Code after the asynchronous operations here
};

  const getAuthUser = async  (e) => {
  
       newRequest.get('/users/findByEmail/'+sessionStorage.getItem("email"), {
        headers: {
          'Authorization': sessionStorage.getItem("jwt")
        }
      }).then((res)=>{
       // console.log(res.data);
        return res.data;
      }).catch((err)=>{
      //  console.log(err);
      })
  };

  const uploadFile =  (file) => {
    const data = new FormData();
    data.append("file", file);
    data.append("upload_preset", "DonateCompass");

    try{
      const res =  axios.post(
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

            <Select id='productType' placeholder='Product Type' className='input' onChange={(e)=>{setProductType(e.target.value)}}>
              <option value='Consumables'>Consumables</option>
              <option value='Food'>Food</option>
              <option value='Kid Clothes'>Kid Clothes</option>
              <option value='Baby Clothes'>Baby Clothes</option>
              <option value='Adult Clothes'>Adult Clothes</option>
              <option value='Materials'>Materials</option>
              <option value='General Items'>General Items</option>
            </Select>

            <Input id='title' placeholder='title' className='input' onChange={(e)=>{setTitle(e.target.value)}}/>
            <Textarea id='description' placeholder='description' className='input' onChange={(e)=>{setDescription(e.target.value)}}/>
            <Select id='state' placeholder='Condition' className='input' onChange={(e)=>{setState(e.target.value)}}>
              <option value='New'>New</option>
              <option value='Used'>Used</option>
            </Select>
            <Input id='location' placeholder='location' className='input' onChange={(e)=>{setLocation(e.target.value)}}/>
            <Input id='image' type='file'  className='input' onChange={(e)=>{setImage(e.target.files[0])}}/>

            <Button colorScheme='green' variant='solid' onClick={()=>{submit()}}>Add</Button>

          </div>

        </div>    
    </>
  )
}

export default Add