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
    private int clienteId;
    private int produtoId;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Produto produto, int quantidade, boolean pedidoConfirmao, int numeroPedido) {
        this.cliente = cliente;
        this.produto = produto;
        this.pedidoConfirmado = pedidoConfirmao;
        this.quantidade = quantidade;
        this.numeroPedido = numeroPedido;
    }

    public Pedido(int cliente, int produto, int quantidade, int numeroPedido) {
        this.clienteId = cliente;
        this.produtoId = produto;
        this.quantidade = quantidade;
        this.numeroPedido = numeroPedido;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
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
