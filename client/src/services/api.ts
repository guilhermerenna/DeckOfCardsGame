import axios from "axios";

// TODO: import this from config file
const API_URL = 'http://localhost:8080';

// not using fetch because we will reuse the URL
const api = axios.create({
    baseURL: API_URL
});

export default api;