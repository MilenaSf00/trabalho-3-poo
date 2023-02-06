package devestoquefruteira.fruteira;

/**
 *
 * @author Dani
 */
public class Item{
    double preco;
    int quantidade;
    Produto produto;
   
    
    
    /**

Construtor da classe Item
@param produto Produto que será adicionado na nota fiscal
@param quantidade Quantidade do produto adicionado
@param preco Preço do produto adicionado
*/
    public Item(Produto produto, int quantidade,double preco){
        this.produto = produto;
        this.preco = produto.getPreco();
        this.quantidade = quantidade;
        
    }
    /**

Construtor vazio da classe Item
*/
    public Item (){
    
    }
    
    
    
    /**

Retorna o preço do item
@return Preço do item
*/
    
    public double getPreco(){
        return this.preco;
    }

    /**

Define o preço do item
@param preco Preço a ser definido para o item
*/
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    /**

Retorna a quantidade de itens
@return Quantidade de itens
*/
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    /**

Define a quantidade de itens
@param quantidade Quantidade a ser definida para o item
*/
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    /**

Retorna o produto associado ao item
@return Produto associado ao item
*/
    public Produto getProduto(){
         return this.produto;
    }
    /**

Define o produto associado ao item
@param produto Produto a ser associado ao item
*/
    public void setProduto(Produto produto){
        this.produto = produto;
        this.preco = produto.getPreco();
    }
    /**

Retorna o total do item (preço x quantidade)
@return Total do item
*/
    public double getTotal(){
        return this.preco * this.quantidade;
    }
    /**

Calcula o preço do item de acordo com sua categoria
@return Preço do item
*/
   public double calcularPrecoDoItem(){
        if (this.produto instanceof ProdutoCategoriaPeso) {
            return this.preco * this.quantidade * this.produto.getQuantidade();
        } else {
            return this.preco * this.quantidade;
        }
       
        
    }
   /**

Método para calcular o preço total de um item.
@return O preço total do item (preço * quantidade).
*/
   public double calcular(){
     return this.preco * this.quantidade ;
   }
   
   
   /**

Método para calcular o preço por kg do item.
@return O preço por kg do item (preço por kg do produto * quantidade).
*/
   
   public double calcularPrecoPorKg(){
        //return this.preco * this.quantidade * this.produto.getQuantidade();
     return produto.getPrecoPorKg() * quantidade;
    }


/**

Método para calcular o preço por unidade do item.
@return O preço por unidade do item (preço por unidade do produto * quantidade).
*/
 public double calcularPrecoPorUnidade() {
    return produto.getPrecoPorUnidade() * quantidade;
  }


    /**

Método que retorna a representação em String de um item.
@return Uma String com informações sobre o produto, quantidade e preço do item.
*/
    @Override
    public String toString(){
        return "Prduto: "+this.produto+"\n Quantidade: "+this.quantidade+"\n Preço: "+this.preco;
    }
    
}