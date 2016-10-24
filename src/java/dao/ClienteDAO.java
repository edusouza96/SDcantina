package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO extends DaoDB<Cliente>{

    public Cliente login(int matriculaParam, String senhaParam){
        String sql = "SELECT * FROM cliente WHERE matricula = ? AND senha = ? ";
        try{
            conectar(sql);
            comando.setInt(1, matriculaParam);
            comando.setString(2, senhaParam);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                int matricula = resultado.getInt("matricula");
                String nome = resultado.getString("nome");
                String senha = resultado.getString("senha");
                double saldo = resultado.getDouble("saldo");
                Cliente cliente = new Cliente(nome, matricula, senha, saldo);
                return cliente;
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
        return null;
    }

    public Cliente buscarPorMatricula(int matriculaParam){
        String sql = "SELECT * FROM cliente WHERE matricula = ? ";
        try{
            conectar(sql);
            comando.setInt(1, matriculaParam);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                int matricula = resultado.getInt("matricula");
                String nome = resultado.getString("nome");
                String senha = resultado.getString("senha");
                double saldo = resultado.getDouble("saldo");
                Cliente cliente = new Cliente(nome, matricula, senha, saldo);
                return cliente;
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
        return null;
    }
   
    public void adicionar(Cliente cliente) {
        try{
            String sql = "INSERT INTO cliente (matricula, nome, senha, saldo)"
                    + "VALUES (?,?,?,?)";
            conectar(sql);
            comando.setInt(1, cliente.getMatricula());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getSenha());
            comando.setDouble(4, cliente.getSaldo());
            comando.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
    }

    public List<Cliente> listar() {
        List<Cliente> listClientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente order by matricula";
        try{
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            
            while(resultado.next()){
                int matricula = resultado.getInt("matricula");
                String nome = resultado.getString("nome");
                String senha = resultado.getString("senha");
                double saldo = resultado.getDouble("saldo");
                Cliente cliente = new Cliente(nome, matricula, senha, saldo);
                listClientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
        return (listClientes);
    }

    public void atualizar(Cliente cliente) {
        try{
            String sql = "UPDATE cliente  SET  saldo=? WHERE matricula=?";
            conectar(sql);
            comando.setDouble(1, cliente.getSaldo());
            comando.setInt(2, cliente.getMatricula());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            fecharConexao();
        }
    }

    
    
}
