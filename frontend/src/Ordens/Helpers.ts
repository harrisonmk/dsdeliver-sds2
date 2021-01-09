import { Produto } from "./types";

export function checkIsSelected(selectedProducts:Produto[],product:Produto){

 return selectedProducts.some(item => item.id === product.id);

}

export function formataPreco(preco:number){

 const formata = new Intl.NumberFormat('pt-BR', {
  style:'currency',
  currency:'BRL',
  minimumFractionDigits: 2

 });

 return formata.format(preco);

}
