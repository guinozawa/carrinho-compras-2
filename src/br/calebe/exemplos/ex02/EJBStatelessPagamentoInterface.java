package br.calebe.exemplos.ex02;


import br.calebe.exemplos.ex01.CartaoCredito;
import javax.ejb.Remote;

@Remote
public interface EJBStatelessPagamentoInterface {

    String pagamentoRequisitado(CartaoCredito cartao, double totalPedido);
}
