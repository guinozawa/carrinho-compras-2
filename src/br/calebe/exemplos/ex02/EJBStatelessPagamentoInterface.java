/** 
 *  @author:
 *  Nomes:  Guilherme Y. Nozawa        nº de matrícula: 3103116-1
 *          Vinicius Landi                              3102115-8
 */

package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.CartaoCredito;
import javax.ejb.Remote;

@Remote
public interface EJBStatelessPagamentoInterface {

    String pagamentoRequisitado(CartaoCredito cartao, double totalPedido);
}
