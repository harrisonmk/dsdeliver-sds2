import { formataPreco } from "./Helpers";
import {Produto} from "./types";

type Props = {

    produto: Produto;
    onSelectProduct: (produto: Produto) => void;
    isSelected: boolean;

}




function ProductCard({produto,onSelectProduct,isSelected}: Props) {

    return (

        <div className={`order-card-container ${isSelected ? 'selected' : ''}`} onClick={() => onSelectProduct(produto)}>
            <h3 className="order-card-title">
                {produto.nome}
            </h3>
            <img src={produto.imagemUri} className="order-card-image" alt={produto.nome}/>
            <h3 className="order-card-price">
                {formataPreco(produto.preco)}
            </h3>
            <div className="order-card-description">
                <h3>
                    Descrição
                </h3>
                <p>
                    {produto.descricao}
                </p>
            </div>
        </div>

    );


}

export default ProductCard;
