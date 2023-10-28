import axios from 'axios';

const newRequest = axios.create({
    baseURL: 'http://localhost:8090',
    withCredentials: true
})

export default newRequest;