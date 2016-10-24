package ws;

import com.google.gson.Gson;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import model.Cliente;
import model.Pedido;
import model.Produto;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("cantina")
public class CantinaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CantinaWS
     */
    public CantinaWS() {
    }

    /**
     * Retrieves representation of an instance of ws.CantinaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        return "hello world";
    }

    @GET
    @Produces("application/json")
    @Path("autenticar/{matricula}/{senha}")
    public String autenticar(@PathParam("matricula") int matricula, @PathParam("senha") String senha) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.login(matricula, senha);
        Gson g = new Gson();
        if(cliente == null){
            return  g.toJson("Login Invalido!");
        }else{
            return g.toJson(cliente);
        }        
    }
    
    @GET
    @Produces("application/json")
    @Path("cardapio")
    public String cardapio() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> lista = produtoDAO.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @POST
    @Consumes("application/json")
    @Path("enviar_pedido")
    public String enviarPedido(String content){
        Gson g = new Gson();
        Pedido pedido = g.fromJson(content, Pedido.class);
 
        PedidoDAO pedidoDAO = new PedidoDAO();
        ClienteDAO clienteDAO =  new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Cliente cliente = clienteDAO.buscarPorMatricula(pedido.getClienteId());
        Produto produto = produtoDAO.buscarPorCodigo(pedido.getProdutoId());
 
        if(cliente != null && produto != null){
            pedido.setCliente(cliente);
            pedido.setProduto(produto);
            pedidoDAO.adicionar(pedido);
            return g.toJson("Pedido Realizado, aguarde a confirmação para retirada");
        }else{
            return  g.toJson("Não foi possivel realizar o pedido");
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("saldo/{matricula}")
    public String saldo(@PathParam("matricula")int matricula){
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarPorMatricula(matricula);
        Gson g = new Gson();
        if(cliente == null){
            return g.toJson("Aluno/Professor não encontrado");
        }else{
            return g.toJson(cliente.getSaldo());
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("pegar_pedido")
    public String pegarPedido(){
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedido = pedidoDAO.pegarPedido();
        Gson g = new Gson();
        if(pedido == null){
            return g.toJson("Sem pedido na fila");
        }else{
            return g.toJson(pedido);
        }
        
    }
   
    
    @PUT
    @Consumes("application/json")
    @Path("confirmar_pedido")
    public String confirmarPedido(String content){
        PedidoDAO pedidoDAO = new PedidoDAO();
        Gson g = new Gson();
        Pedido ped = g.fromJson(content, Pedido.class);
        Pedido pedido = pedidoDAO.buscarPorPerdido(ped.getNumeroPedido());
        pedido.setPedidoConfirmado(true);
        pedidoDAO.atualizar(pedido);
        
        return g.toJson("Pedido Pronto!");
    }
}
