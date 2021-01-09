import { toast } from "react-toastify";
import './styles.css';
import StepsHeader from "../StepsHeader";
import ProductsList from "./ProductsList";
import {useEffect, useState} from "react";
import {OrderLocationData, Produto} from './types';
import {fetchProdutos, saveOrder} from "../api";
import OrderLocation from "./OrderLocation";
import OrderSummary from "./OrderSummary";
import Footer from "../Footer";
import {checkIsSelected} from "./Helpers";

function Orders() {

    const [produtos, setProdutos] = useState<Produto[]>([]);
    const [selectedProducts, setSelectedProducts] = useState<Produto[]>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();
    const totalPrice = selectedProducts.reduce((sum,item) => {
        return sum + item.preco;
    },0);

    useEffect(() => {
        fetchProdutos().then(response => setProdutos(response.data)).catch(error => console.log(error))
    }, []);



    const handleSelectProduct = (product: Produto) => {
        const isAlreadySelected = checkIsSelected(selectedProducts,product);

        if (isAlreadySelected) {
            const selected = selectedProducts.filter(item => item.id !== product.id);
            setSelectedProducts(selected);
        } else {
            setSelectedProducts(previous => [...previous, product]);
        }
    }


    const handleSubmit = () => {
        const productsIds = selectedProducts.map(({ id }) => ({ id }));
        const payload = {
            ...orderLocation!,
            products: productsIds
        }

        saveOrder(payload).then((response) => {
            toast.error(`Pedido enviado com sucesso! Nº ${response.data.id}`);
            setSelectedProducts([]);
        })
            .catch(() => {
                toast.warning('Erro ao enviar pedido');
            })
    }


    return (
        <>
            <div className="orders-container">
                <StepsHeader/>
                <ProductsList produtos={produtos} onSelectProduct={handleSelectProduct} selectedProducts={selectedProducts}/>
                <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
                <OrderSummary amount={selectedProducts.length} totalPrice={totalPrice} onSubmit={handleSubmit}/>
            </div>
            <Footer/>
        </>
    );


}

export default Orders;
