package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.CartaoCredito;
import br.calebe.exemplos.ex01.ItemPedido;
import br.calebe.exemplos.ex01.Pagamento;
import br.calebe.exemplos.ex01.Pedido;
import br.calebe.exemplos.ex01.Produto;
import br.calebe.exemplos.ex02.controller.PagamentoController;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Pagamento.class})
public class PagamentoTest {

    @Test
    public void executandoClasseExemplo() throws Exception {
        
        //ItemPedido ip1 = new ItemPedido(new Produto("Touch Mouse Microsoft", 319.0), 1);
        //ItemPedido ip2 = new ItemPedido(new Produto("Monitor 3D LED TA950 Samsung", 2.299), 2);
        //Pedido p = new Pedido(27, "22/04/2013");
        //p.addProdutoPedido(ip1);
        //p.addProdutoPedido(ip2);
        CartaoCredito cartao = new CartaoCredito(1256251441, "TPY297", "Alex Rodriguez", "13", "12/15/2015", "MasterCard");
        
        // Cria o objeto Mock da classe PagamentoController
        PagamentoController controllerMock = PowerMock.createMock(PagamentoController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(PagamentoController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMock.pagamentoRequisitado(cartao, 125)).andReturn("Operação Realizada com Sucesso!");
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, PagamentoController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        Pagamento tested = new Pagamento(cartao);
        tested.run(125);
        
        // Faz a verificaçao agendada
        Assert.assertEquals("Operação Realizada com Sucesso!", tested.getAnswer());
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
}
