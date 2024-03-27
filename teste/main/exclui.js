import axios from 'axios';

async function fetchOrders() {
  try {
    const response = await axios.get('https://api2.ploomes.com/Orders');
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
}

fetchOrders();