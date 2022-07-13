import axios from 'axios';
const Axios = axios.create({
  baseURL: "http://localhost:8080/restaurant/",
});
export default Axios;