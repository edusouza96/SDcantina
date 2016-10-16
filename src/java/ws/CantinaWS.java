package ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Cliente;
import model.Pedido;
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
    
    @WebMethod(operationName = "enviar_pedido")
    public boolean enviarPedido(@WebParam(name = "clienteMatricula") int clienteMatricula,@WebParam(name = "produtoCodigo") int produtoCodigo,@WebParam(name = "quantidade") int quantidade,@WebParam(name = "numeroPedido") int numeroPedido){
        return new repositorio.repo().enviarPedido(clienteMatricula, produtoCodigo, quantidade, numeroPedido);
    }
    
    @WebMethod(operationName = "saldo")
    public double saldo(@WebParam(name = "matricula")int matricula){
        return new repositorio.repo().saldo(matricula);
    }
    
    @WebMethod(operationName = "pegar_pedido")
    public Pedido pegarPedido(){
        return new repositorio.repo().pegarPedido();
    }
    
    @WebMethod(operationName = "confirmar_pedido")
    public boolean confirmarPedido(@WebParam(name = "numeroPedido") int numeroPedido){
        return new repositorio.repo().confirmarPedido(numeroPedido);
    }
}
