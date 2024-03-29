/** 
 *  @author:
 *  Nomes:  Guilherme Y. Nozawa        nº de matrícula: 3103116-1
 *          Vinicius Landi                              3102115-8
 */

package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex01.CarrinhoVazioExpected;
import br.calebe.exemplos.ex01.Produto;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<Produto> produtos;

	public Carrinho() {
		produtos = new ArrayList<>();
	}

	public void add(Produto produto) {
		produtos.add(produto);
	}
        
        public boolean remove(Produto produto) throws CarrinhoVazioExpected {
                if (produtos.isEmpty())
			throw new CarrinhoVazioExpected();
                else if(!buscarProduto(produto))
                        return false;
                else 
                        produtos.remove(produto);
               return true;
	}

	public Produto menorProduto() throws CarrinhoVazioExpected {
		if (produtos.isEmpty())
			throw new CarrinhoVazioExpected();
		Produto menor = produtos.get(0);
		for (Produto produto : produtos) {
			if (produto.getPreco() < menor.getPreco())
				menor = produto;
		}
		return menor;
	}
        
        public boolean buscarProduto(Produto p) throws CarrinhoVazioExpected {
                if (produtos.isEmpty())
			throw new CarrinhoVazioExpected();
		for (Produto produto : produtos) {
			if (p.equals(produto))
				return true;
		}
		return false;
        }
        
        public int numeroDeProdutos(){
                return produtos.size();
        }
        
        public void listarProdutos() throws CarrinhoVazioExpected{
                if (produtos.isEmpty())
			throw new CarrinhoVazioExpected();
                System.out.println("*********Lista de Produtos**********");
		for (Produto produto : produtos) 
			System.out.println("Produto: " + "\"" + produto.getNome() + "\"" +  "      Valor: " + produto.getPreco() + "\n");
        }
        
        public List<Produto> getList() throws CarrinhoVazioExpected{
            if (produtos.isEmpty())
			throw new CarrinhoVazioExpected();
            return produtos;
        }
        
        public double calcularTotalPedido(){
               double total = 0.0;
               if (produtos.isEmpty())
                    return 0.0;
               for (Produto produto : produtos) 
                    total += produto.getPreco();
               return total;
        } 
}
