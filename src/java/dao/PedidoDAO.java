package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Pedido;
import model.Produto;

public class PedidoDAO extends DaoDB<Cliente>{

    public Pedido buscarPorPerdido(int numeroPedidoParam){
        String sql = "SELECT * FROM pedido, cliente, produto WHERE numeroPedido = ? AND matricula = cliente AND pedido.produto =  codigo";
        try{
            conectar(sql);
            comando.setInt(1, numeroPedidoParam);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                //cliente
                int matricula = resultado.getInt("matricula");
                String nome = resultado.getString("nome");
                String senha = resultado.getString("senha");
                double saldo = resultado.getDouble("saldo");
                Cliente cliente = new Cliente(nome, matricula, senha, saldo);
                //produto
                int codigo = resultado.getInt("codigo");
                String nomeProduto = resultado.getString("produto");
                int unidades = resultado.getInt("unidades");
                double valor = resultado.getDouble("valor");
                Produto produto = new Produto(nomeProduto, codigo, valor, unidades);
                //pedio
                int numeroPedido = resultado.getInt("numeroPedido");
                int quantidade = resultado.getInt("quantidade");
                boolean pedidoConfirmado = resultado.getBoolean("pedidoConfirmado");
                Pedido pedido = new Pedido(cliente, produto, quantidade, pedidoConfirmado, numeroPedido);
                return pedido;
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
   
    public void adicionar(Pedido pedido) {
        try{
            String sql = "INSERT INTO pedido (numeroPedido, cliente, produto, quantidade, pedidoConfirmado)"
                    + "VALUES (?,?,?,?,?)";
            conectar(sql);
            comando.setInt(1, pedido.getNumeroPedido());
            comando.setInt(2, pedido.getCliente().getMatricula());
            comando.setInt(3, pedido.getProduto().getCodigo());
            comando.setInt(4, pedido.getQuantidade());
            comando.setBoolean(5, pedido.isPedidoConfirmado());
            comando.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
    }

    public Pedido pegarPedido() {
        List<Pedido> listPedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido, cliente, produto WHERE pedido.pedidoConfirmado = 0  AND cliente.matricula = pedido.cliente AND pedido.produto =  produto.codigo";
        try{
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                //cliente
                int matricula = resultado.getInt("matricula");
                String nome = resultado.getString("nome");
                String senha = resultado.getString("senha");
                double saldo = resultado.getDouble("saldo");
                Cliente cliente = new Cliente(nome, matricula, senha, saldo);
                //produto
                int codigo = resultado.getInt("codigo");
                String nomeProduto = resultado.getString("produto");
                int unidades = resultado.getInt("unidades");
                double valor = resultado.getDouble("valor");
                Produto produto = new Produto(nomeProduto, codigo, valor, unidades);
                //pedio
                int numeroPedido = resultado.getInt("numeroPedido");
                int quantidade = resultado.getInt("quantidade");
                boolean pedidoConfirmado = resultado.getBoolean("pedidoConfirmado");
                Pedido pedido = new Pedido(cliente, produto, quantidade, pedidoConfirmado, numeroPedido);
                listPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
        return (listPedidos.get(0));
    }

    public void atualizar(Pedido pedido) {
        try{
            String sql = "UPDATE pedido SET pedidoConfirmado=? WHERE numeroPedido=?";
            conectar(sql);
            comando.setBoolean(1, pedido.isPedidoConfirmado());
            comando.setInt(2, pedido.getNumeroPedido());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
    }
}
