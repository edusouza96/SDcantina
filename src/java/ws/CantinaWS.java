package ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Cliente;
import model.Produto;

/**
 *
 * @author Edu
 */
@WebService(serviceName = "CantinaWS")
public class CantinaWS {

    @WebMethod(operationName = "autenticar")
    public Cliente autenticar(@WebParam(name = "matricula") int matricula, @WebParam(name = "senha") String senha) {
        Cliente cliente = new repositorio.repo().autenticar(matricula, senha);
        return cliente;
    }
    
    @WebMethod(operationName = "cardapio")
    public List<Produto> cardapio(){
        return new repositorio.repo().popularProduto();
    }
}
