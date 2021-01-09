import ProductCard from "./ProductCard";
import {Produto} from "./types";
import {checkIsSelected} from "./Helpers";

type Props = {

    produtos: Produto[];
    selectedProducts: Produto[];
    onSelectProduct: (produto: Produto) => void;

}


function ProductsList({produtos, selectedProducts, onSelectProduct}: Props) {

    return (
        <div className="orders-list-container">

            <div className="orders-list-items">
                {produtos.map(produto => (
                    <ProductCard key={produto.id} produto={produto} onSelectProduct={onSelectProduct}
                                 isSelected={checkIsSelected(selectedProducts, produto)}/>
                ))}

            </div>

        </div>

    );


}

export default ProductsList;
