package devestoquefruteira.fruteira;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dani e João
 */

 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**

Classe NotaFiscal representa uma nota fiscal que contem informações sobre a compra realizada.
**/
public class NotaFiscal {
   private static int codNotaFiscalGeral = 0;
   private final int codNotaFiscal; 
   private Date data;
   private final List<Item> listaDeItem; 
   private Produto produto;
   private boolean excluido; 
   
   /**

Construtor da classe NotaFiscal que cria uma nova nota fiscal com data e lista de itens informados.
@param data Data da compra.
@param listaDeItem Lista de itens adquiridos na compra.
@param produto Produto relacionado a compra.
*/
    public NotaFiscal(Date data, List<Item> listaDeItem, Produto produto){
        this.codNotaFiscal = codNotaFiscalGeral ++;
        this.data = data;
        if(listaDeItem == null) {
    	this.listaDeItem = new ArrayList<>();
    } else {
    	this.listaDeItem = listaDeItem;
    }
        
        
        this.produto = produto;
    }

    /**

Construtor da classe NotaFiscal sem parametros, cria uma nova nota fiscal com o codigo gerado automaticamente.
*/
    NotaFiscal() {
        this.codNotaFiscal = codNotaFiscalGeral++;
        this.listaDeItem = new ArrayList<>();
     }
/**

Método que retorna o codigo da nota fiscal.
@return O codigo da nota fiscal.
*/
    public int getCodNotaFiscal(){
        return codNotaFiscal;
    }

/**

Método que retorna a data da compra.
@return A data
*/
    public Date getData(){
        return data;
    }
    /**

Método que seta a data da compra.
@param data Data 
*/
    public void setData(Date data){
        this.data = data;
    }
/**

Método que retorna o total gasto na compra.
@return O total gasto
@throws Exception Caso ocorra algum erro na hora de calcular o total.
*/

    public double getTotal() throws Exception{
       double total = 0;
       for(Item item : listaDeItem){
            total += item.getTotal();
        }
       return total;
    }
/**

Método que retorna o estado de exclusão da nota fiscal.
@return true se a nota fiscal estiver excluída, false caso contrário.
*/
    public boolean isExcluido() {//add
        return excluido;
    }
/**

Método que seta o estado de exclusão da nota fiscal.
@param excluido True para excluir a nota fiscal, false para mantê-la.
*/
    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
    
    /**

Método que adiciona um item na lista de itens da compra.
@param item Item a ser adicionado na lista.
@throws Exception Caso o item seja inválido.
*/
    public void adicionarItem(Item item) throws Exception{
        if(item != null){
            this.listaDeItem.add(item);
        }else{
            throw new Exception ("O item é inválido.");
        }

    }
/**

Método que remove um item da lista de itens da compra.
@param item Item a ser removido da lista.
@throws Exception Caso a lista de itens seja vazia ou o item seja inválido.
*/
    public void removerItem(Item item) throws Exception{
        if(this.listaDeItem.size() < 1 || item == null){
            throw new Exception("O item é inválido.");
        }else{
            this.listaDeItem.remove(item);
        }
    }
/**

Método que seta o produto relacionado a compra.
@param produto Produto relacionado a compra.
*/
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
  /**

Método que retorna o produto relacionado a compra.
@return O produto relacionado a compra.
*/
     public Produto getProduto(){
        return produto;
    }
    /**

Método que seta a lista de itens da compra.
@param listaDeItem Lista de itens da compra.
*/
     public void setListaDeItens(List<Item> listaDeItem) {
    this.listaDeItem.clear();
    this.listaDeItem.addAll(listaDeItem);  
}
  

     /**

Método que retorna a lista de itens da compra.
@return A lista de itens da compra.
*/
    public List<Item> getListaItem() {     
        return  listaDeItem;
        
        
    }
/**

Método para exibir informações básicas da Nota Fiscal em forma de string.
@return Uma string com o código e data da Nota Fiscal.
*/   @Override
    public String toString(){
        return "Código: "+ codNotaFiscal+"\nData: " + data;
    }
}