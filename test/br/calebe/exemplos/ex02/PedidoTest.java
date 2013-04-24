/** 
 *  @author:
 *  Nomes:  Guilherme Y. Nozawa        nº de matrícula: 3103116-1
 *          Vinicius Landi                              3102115-8
 */

package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Pedido;
import br.calebe.exemplos.ex02.controller.PedidoController;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Pedido.class})
public class PedidoTest {
    
    @Test
    public void executandoClasseExemplo() throws Exception {
       
        // Cria o objeto Mock da classe PagamentoController
        PedidoController controllerMock = PowerMock.createMock(PedidoController.class);
        // Espera que toda instanciação dessa classe seja substituída pelo objeto mockado
        PowerMock.expectNew(PedidoController.class).andReturn(controllerMock);
        // E espera que a resposta pela chamada do método seja determinado
        EasyMock.expect(controllerMock.consultarStatus(13273)).andReturn("Aguardando");
        // "Executa" a configuração programada
        PowerMock.replay(controllerMock, PedidoController.class);
        
        // Chama a classe - internamente, a classe mockada será utilizada
        Pedido tested = new Pedido(13273, "23/04/2013");
        tested.run();
        
        // Faz a verificaçao agendada
        Assert.assertEquals("Aguardando", tested.getAnswer());
        // Executa todas as verificação
        PowerMock.verifyAll();
    }
}
    

