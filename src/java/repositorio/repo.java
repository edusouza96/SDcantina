package repositorio;

import java.util.ArrayList;
import model.Cliente;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Edu
 */
public class repo {
    Cliente cliente1 = new Cliente("aluno1", 631420001, "senha01", 100.00);
    Cliente cliente2 = new Cliente("aluno2", 631420002, "senha02", 200.00);
    Cliente cliente3 = new Cliente("aluno3", 631420003, "senha03", 300.00);
    Cliente cliente4 = new Cliente("aluno4", 631420004, "senha04", 400.00);
    Cliente cliente5 = new Cliente("aluno5", 631420005, "senha05", 500.00);
    
    Produto produto1 = new Produto("café", 10, 2.00, 100);
    Produto produto2 = new Produto("refri", 20, 4.00, 200);
    Produto produto3 = new Produto("Salgado", 30, 3.50, 300);
    Produto produto4 = new Produto("barra de cereal", 40, 1.00, 400);
    
    Pedido pedido1 = new Pedido(cliente1, produto1, 2, false,100);
    Pedido pedido2 = new Pedido(cliente1, produto2, 2, false, 100);
    
    ArrayList<Cliente> aCliente = new ArrayList<>();
    ArrayList<Produto> aProduto = new ArrayList<>();
    ArrayList<Pedido> aPedido = new ArrayList<>();

    public ArrayList<Cliente> popularCliente(){
        aCliente.add(cliente1);
        aCliente.add(cliente2);
        aCliente.add(cliente3);
        aCliente.add(cliente4);
        aCliente.add(cliente5);
        return aCliente;
    }
    
    public ArrayList<Produto> popularProduto(){
        aProduto.add(produto1);
        aProduto.add(produto2);
        aProduto.add(produto3);
        aProduto.add(produto4);
        return aProduto;
    }
    
    public ArrayList<Pedido> popularPedido(){
        aPedido.add(pedido1);
        aPedido.add(pedido2);
        return aPedido;
    }
    
    public Cliente autenticar(int matricula, String senha){
        for (Cliente cliente : popularCliente()) {
            if((cliente.getMatricula() == matricula)&&(cliente.getSenha().equals(senha))){
                return cliente;
            }
        }
        return null;
    }
}
