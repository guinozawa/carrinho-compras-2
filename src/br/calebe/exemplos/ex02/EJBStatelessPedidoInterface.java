package br.calebe.exemplos.ex02;

import javax.ejb.Remote;

@Remote
public interface EJBStatelessPedidoInterface {
    
    String consultarStatus(int idPedido);
}
