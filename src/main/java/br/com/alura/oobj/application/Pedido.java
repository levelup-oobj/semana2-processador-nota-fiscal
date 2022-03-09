package br.com.alura.oobj.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

  private List<ItemPedido> itens = new ArrayList<>();

  public Pedido() {
  }

  public Pedido(List<ItemPedido> itens) {
    this.itens = itens;
  }

  public List<ItemPedido> getItens() {
    return itens;
  }

  public void setItens(List<ItemPedido> itens) {
    this.itens = itens;
  }

  public BigDecimal getTotal() {
    return itens.stream().map(ItemPedido::getSubtotal)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  @Override
  public String toString() {
    return "Pedido{" +
        "itens=" + itens +
        '}';
  }
}
