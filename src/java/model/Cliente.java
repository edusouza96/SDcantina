package model;

/**
 *
 * @author Edu
 */
public class Cliente {
    private String nome;
    private int matricula;
    private String senha;
    private double saldo;

    public Cliente() {
    }

    public Cliente(String nome, int matricula, String senha, double saldo) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", matricula=" + matricula + ", senha=" + senha + ", saldo=" + saldo + '}';
    }
    
    
}
