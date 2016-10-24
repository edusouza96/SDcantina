package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Produto;

public class ProdutoDAO extends DaoDB<Cliente>{

    public Produto buscarPorCodigo(int codigoParam){
        String sql = "SELECT * FROM produto WHERE codigo = ? ";
        try{
            conectar(sql);
            comando.setInt(1, codigoParam);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                int codigo = resultado.getInt("codigo");
                String nomeProduto = resultado.getString("produto");
                int unidades = resultado.getInt("unidades");
                double valor = resultado.getDouble("valor");
                Produto produto = new Produto(nomeProduto, codigo, valor, unidades);
                return produto;
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
   
    public void adicionar(Produto produto) {
        try{
            String sql = "INSERT INTO produto (codigo, produto, valor, unidades)"
                    + "VALUES (?,?,?,?)";
            conectar(sql);
            comando.setInt(1, produto.getCodigo());
            comando.setString(2, produto.getProduto());
            comando.setDouble(3, produto.getValor());
            comando.setInt(4, produto.getUnidades());
            comando.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
    }

    public List<Produto> listar() {
        List<Produto> listProdutos = new ArrayList<>();
        String sql = "SELECT * FROM produto order by codigo";
        try{
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                int codigo = resultado.getInt("codigo");
                String nomeProduto = resultado.getString("produto");
                int unidades = resultado.getInt("unidades");
                double valor = resultado.getDouble("valor");
                Produto produto = new Produto(nomeProduto, codigo, valor, unidades);
                listProdutos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
        return (listProdutos);
    }

    public void atualizar(Produto produto) {
        try{
            String sql = "UPDATE produto  SET  valor=?, unidades=? WHERE codigo=?";
            conectar(sql);
            comando.setDouble(1, produto.getValor());
            comando.setInt(2, produto.getUnidades());
            comando.setInt(3, produto.getCodigo());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
    }

    
    
}
