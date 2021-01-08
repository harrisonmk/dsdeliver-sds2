import './styles.css';
import StepsHeader from "../StepsHeader";
import ProductsList from "./ProductsList";
import {useEffect, useState} from "react";
import {OrderLocationData, Produto} from './types';
import {fetchProdutos} from "../api";
import OrderLocation from "./OrderLocation";

function Orders() {

    const [produtos, setProdutos] = useState<Produto[]>([]);
    const [orderLocation,setOrderLocation] = useState<OrderLocationData>();

    useEffect(() => {
        fetchProdutos().then(response => setProdutos(response.data)).catch(error => console.log(error))
    }, []);


    return (

        <div className="orders-container">
            <StepsHeader/>
            <ProductsList produtos={produtos}/>
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
        </div>

    );


}

export default Orders;
