package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import model.Cliente;
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
        Cliente cliente = new repositorio.repo().autenticar(matricula, senha);
        Gson g = new Gson();
        return g.toJson(cliente);
    }
    
    @GET
    @Produces("application/json")
    @Path("cardapio")
    public String cardapio() {
        List<Produto> lista = new repositorio.repo().popularProduto();
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("enviar_pedido")
    public String enviarPedido(@PathParam("clienteMatricula") int clienteMatricula,@PathParam("produtoCodigo") int produtoCodigo,@PathParam("quantidade") int quantidade,@PathParam("numeroPedido") int numeroPedido){
        Gson g = new Gson();
        return g.toJson(new repositorio.repo().enviarPedido(clienteMatricula, produtoCodigo, quantidade, numeroPedido));
        
    }
    
    @GET
    @Produces("application/json")
    @Path("saldo/{matricula}")
    public String saldo(@PathParam("matricula")int matricula){
        Gson g = new Gson();
        return g.toJson(new repositorio.repo().saldo(matricula));
    }
    
    @GET
    @Produces("application/json")
    @Path("pegar_pedido")
    public String pegarPedido(){
        Gson g = new Gson();
        return g.toJson(new repositorio.repo().pegarPedido());
    }
   
    @GET
    @Produces("application/json")
    @Path("confirmar_pedido/{numeroPedido}")
    public String confirmarPedido(@PathParam("numeroPedido") int numeroPedido){
        Gson g = new Gson();
        return g.toJson(new repositorio.repo().confirmarPedido(numeroPedido));
    }
}
