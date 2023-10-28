import React from 'react'
import './DonationCard.scss'
import { Link } from 'react-router-dom'
import { Stack } from "@chakra-ui/react"


function DonationCard({item}) {
 
    
    return (
        <div className='donationCard'>
            <Link to ={ "/home" }>
            <img src={item?.image} alt="" />
            <div className="info">
                <div className="user">
                    <div className="spans">
                        
                            <h1>{item?.title}</h1>
                            <span>{item?.firstName} {item?.lastName}</span>
                        

                    </div>
                </div>
                <p>{item.description}</p>
            </div>
            </Link>
            <hr />
            <div className="details">
            <img src="../../delete.png" alt="" className='delete'/>
                <div className="phone">
                    <Stack direction='column' className='innerPhone'>
                        <span>Phone Number</span>
                        <span>{item?.phone}</span>
                    </Stack>
                </div>
            </div>
        </div>
        
      )

}

export default DonationCard