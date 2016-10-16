package model;

/**
 *
 * @author Edu
 */
public class Produto {
    private String produto;
    private int codigo;
    private double valor;
    private int unidades;

    public Produto() {
    }

    public Produto(String produto, int codigo, double valor, int unidades) {
        this.produto = produto;
        this.codigo = codigo;
        this.valor = valor;
        this.unidades = unidades;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Cardapio{" + "produto=" + produto + ", codigo=" + codigo + ", valor=" + valor + ", unidades=" + unidades + '}';
    }
    
    
}
