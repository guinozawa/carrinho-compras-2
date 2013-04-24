package br.calebe.exemplos.ex02;


import br.calebe.exemplos.ex01.CartaoCredito;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EJBStatelessPagamentoInterface {

    String pagamentoRequisitado(CartaoCredito cartao, double totalPedido);
}
