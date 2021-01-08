import ProductCard from "./ProductCard";
import {Produto} from "./types";

type Props = {

    produtos: Produto[];

}


function ProductsList({produtos}: Props) {

    return (
        <div className="orders-list-container">

            <div className="orders-list-items">
                {produtos.map(produto => (
                    <ProductCard key={produto.id} produto={produto}/>
                ))}

            </div>

        </div>

    );


}

export default ProductsList;
