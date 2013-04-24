package br.calebe.exemplos.ex02.controller;

import br.calebe.exemplos.ex01.CartaoCredito;
import br.calebe.exemplos.ex02.EJBStatelessPagamentoInterface;
import java.io.FileInputStream;
import java.util.Properties;
import javax.naming.InitialContext;

public class PagamentoController implements EJBStatelessPagamentoInterface {

    private EJBStatelessPagamentoInterface ejb;

    public PagamentoController() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        ejb = (EJBStatelessPagamentoInterface) ctx.lookup("ejb/EJBStatelessExemplo");
    }

    @Override
    public String pagamentoRequisitado(CartaoCredito cartao, double totalPedido) {
        return ejb.pagamentoRequisitado(cartao, totalPedido);
    }
}
