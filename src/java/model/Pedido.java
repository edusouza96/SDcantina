package model;

/**
 *
 * @author Edu
 */
public class Pedido {
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private boolean pedidoConfirmado;
    private int numeroPedido;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Produto produto, int quantidade, boolean pedidoConfirmado, int numeroPedido) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedidoConfirmado = pedidoConfirmado;
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPedidoConfirmado() {
        return pedidoConfirmado;
    }

    public void setPedidoConfirmado(boolean pedidoConfirmado) {
        this.pedidoConfirmado = pedidoConfirmado;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cliente=" + cliente + ", produto=" + produto + ", quantidade=" + quantidade + ", pedidoConfirmado=" + pedidoConfirmado + ", numeroPedido=" + numeroPedido + '}';
    }
    
}
