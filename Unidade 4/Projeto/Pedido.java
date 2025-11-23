package Projeto;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;
    private double distanciaEntrega;

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, double valorTotal){
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getDistanciaEntrega() {
        return distanciaEntrega;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDistanciaEntrega(double distanciaEntrega) {
        this.distanciaEntrega = distanciaEntrega;
    }
}
