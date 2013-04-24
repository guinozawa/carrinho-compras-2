/** 
 *  @author:
 *  Nomes:  Guilherme Y. Nozawa        nº de matrícula: 3103116-1
 *          Vinicius Landi                              3102115-8
 */

package br.calebe.exemplos.ex01;

public class ItemPedido {
    
    private Produto produto;
    private int quantidadeProduto;
    
    public ItemPedido(Produto produto, int quantidadeProduto){
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorUnitario() {
        return produto.getPreco();
    }

    public void setValorUnitario(double valorUnitario) {
        produto.setPreco(valorUnitario);
    }

}
