
export type Produto = {

  id: number;
  nome: string;
  preco: number;
  descricao: string
  imagemUri: string;


}

export type OrderLocationData = {

 latitude: number;
 longitude: number;
 address: string;

}

type ProdutoId = {

  id: number;

}

export type OrderPayload = {

 products: ProdutoId[];

} & OrderLocationData;
