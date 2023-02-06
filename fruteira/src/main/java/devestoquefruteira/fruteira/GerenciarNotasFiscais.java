/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.fruteira;

import java.util.ArrayList;
import java.util.List;

/**

    Classe que implementa a interface INotasFiscais para gerenciar as notas fiscais.
 *
 * @author Dani
 */
public class GerenciarNotasFiscais implements INotasFiscais{
    private List<NotaFiscal> listaDeNotasFiscais;
    private List <Produto> listaProdutos; //add
    
    
  /**
 * Construtor que inicializa a lista de notas fiscais e a lista de produtos.
 * @param listaDeNotasFiscais lista de notas fiscais
 * @param listaProdutos lista de produtos
 */
    public GerenciarNotasFiscais(List<NotaFiscal> listaDeNotasFiscais, List<Produto> listaProdutos){
        this.listaDeNotasFiscais = listaDeNotasFiscais;
        this.listaProdutos = listaProdutos;
    }
/**
 * Construtor que inicializa a lista de notas fiscais.
 */
    public GerenciarNotasFiscais(){
     this.listaDeNotasFiscais = new ArrayList<NotaFiscal>();
    }
    
    /**
 * Método responsável por adicionar uma nota fiscal na lista de notas fiscais.
 * @param nf nota fiscal a ser adicionada
 * @throws Exception caso a nota fiscal seja inválida
 */
    @Override
   
    
        public void addNotaFiscal(NotaFiscal nf) throws Exception{
        if(listaDeNotasFiscais == null) {
            listaDeNotasFiscais = new ArrayList<NotaFiscal>();
        }
        if(nf != null){
            listaDeNotasFiscais.add(nf);
        } else {
            throw new Exception("Nota fiscal não pode ser adicionado!");
        }
    }

    
    
    
     /**
 * Método responsável por remover uma nota fiscal da lista de notas fiscais.
 * @param codigo código da nota fiscal a ser removida
 * @throws Exception caso a nota fiscal não seja encontrada
 */
    @Override
    public void removeNotaFiscal(int codigo) throws Exception{
        for(NotaFiscal nota : listaDeNotasFiscais){
            if(nota.getCodNotaFiscal() == codigo){
                listaDeNotasFiscais.remove(nota);
            }
        }
        throw new Exception("Nota fiscal não encontrada. Logo, não há como remover");
    }
    
    /**

Este método busca uma nota fiscal na lista de notas fiscais a partir do código informado.
@param codigo Código da nota fiscal a ser buscada.
@return Nota fiscal encontrada.
@throws Exception Caso a nota fiscal não seja encontrada, uma exceção é lançada com a mensagem "Nota fiscal não encontrada".
*/
    @Override
    public NotaFiscal getNotaFiscal(int codigo) throws Exception{
        for(NotaFiscal nota : listaDeNotasFiscais){
            if(nota.getCodNotaFiscal() == codigo){
                return nota;
            }
        }
        throw new Exception("Nota fiscal não encontrada.");
    }
    
    
   /**

Este método busca o valor total de uma nota fiscal a partir do código informado.
@param codigo Código da nota fiscal a ser buscada.
@return Valor total da nota fiscal encontrada.
**/
    @Override
    public double getTotal(int codigo) throws Exception{
        for(NotaFiscal nota : listaDeNotasFiscais){
            if(nota.getCodNotaFiscal() == codigo){
                return nota.getTotal();
            }
          
        }
        throw new Exception("Código inválido. Nota fiscal não pôde ser encontrada.");
    }

    
    /**

Este método adiciona um item à uma nota fiscal a partir do código informado.
@param codigo Código da nota fiscal à qual o item será adicionado.
@param item Item a ser adicionado na nota fiscal.
@throws Exception Caso o item informado seja inválido, uma exceção é lançada com a mensagem "Item inválido.".
*/
    @Override
    public void addItem(int codigo, Item item) throws Exception{
        if(item != null){
            for(NotaFiscal nota : listaDeNotasFiscais){
                if(nota.getCodNotaFiscal() == codigo){
                    nota.adicionarItem(item);
                }
            }
        }
        throw new Exception("Item inválido.");
    }
    
    
    /**

Remove um item de uma nota fiscal
@param codigo código da nota fiscal
@param item item a ser removido
@throws Exception item inválido
*/
    @Override
    public void removeItem(int codigo, Item item) throws Exception{
        if(item != null){
            for(NotaFiscal nota : listaDeNotasFiscais){
                if(nota.getCodNotaFiscal() == codigo){
                    nota.removerItem(item);
                }
            }
        }
        throw new Exception("Item inválido.");
    }
    
    /**

Retorna o total de vendas de um dia específico
@param data data a ser verificada
@return total de vendas do dia
@throws Exception data inválida
*/
    public double totalVendidoDia(String data) throws Exception{
        double total = 0;
        if(!data.equals("")){
            for(NotaFiscal nota : listaDeNotasFiscais){
                if(nota.getData().equals(data)){
                    total += nota.getTotal();
                }
            }
            return total;
        }

        throw new Exception("Data inválida.");
    }
    
    
    /**

Retorna a lista de notas fiscais
@return lista de notas fiscais
*/
    public List<NotaFiscal> getListaNota() {
           
        return listaDeNotasFiscais;
    }
    
   /**

Retorna a lista de produtos
@return a lista de produtos
*/
    public List<Produto> getListsProduto() {     
        return  listaProdutos;
        
        
    }
    /**

Retorna a Nota Fiscal de acordo com o índice fornecido
@param i índice da Nota Fiscal na lista
@return a Nota Fiscal correspondente ao índice fornecido
*/
     public NotaFiscal get(int i){
    return  listaDeNotasFiscais.get(i);
    }
    /**

Retorna o tamanho da lista de Notas Fiscais
@return o tamanho da lista de Notas Fiscais
*/
     public int size(){
        return listaDeNotasFiscais.size();
    
    }
    /**

Retorna o tamanho da lista de Produtos
@return o tamanho da lista de Produtos
*/
    public int getNProduto(){
    return listaProdutos.size();
    } 
   /**

Retorna a quantidade de elementos na lista de Notas Fiscais
**/         
    public int getQuantElementos() { 
        int quant = 0;
       for(int i=0;i<listaDeNotasFiscais.size();i++){
            quant++;
        }
        return quant;
    }
}
