/** 
 *  @author:
 *  Nomes:  Guilherme Y. Nozawa        nº de matrícula: 3103116-1
 *          Vinicius Landi                              3102115-8
 */

package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.CartaoCredito;
import br.calebe.exemplos.ex01.Pagamento;
import br.calebe.exemplos.ex02.controller.PagamentoController;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Pagamento.class})
public class PagamentoTest {

    @Test
    public void executandoClasseExemplo() throws Exception {
        
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
