/** 
 *  @author:
 *  Nomes:  Guilherme Y. Nozawa        nº de matrícula: 3103116-1
 *          Vinicius Landi                              3102115-8
 */

package br.calebe.exemplos.ex01;

public class CartaoCredito{
    
    private int numeroDoCartao;
    private String senha;
    private String nomeTitular;
    private String codigoSeguranca;
    private String validade;
    private String bandeira;
    
    public CartaoCredito(int numeroDoCartao, String senha, String nomeTitular, String codigoSeguranca, String validade, String bandeira){
        this.numeroDoCartao = numeroDoCartao;
        this.senha = senha;
        this.nomeTitular = nomeTitular;
        this.codigoSeguranca = codigoSeguranca;
        this.validade = validade;
        this.bandeira = bandeira;
    }
}
