package br.com.alura.oobj.application;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SubTotalPorClasseFiscal implements Iterable<SubTotalPorClasseFiscal.Item> {

  public static class Item {
    private final String classeFiscal;
    private final BigDecimal subTotal;

    private Item(String classeFiscal, BigDecimal subTotal) {
      this.classeFiscal = classeFiscal;
      this.subTotal = subTotal;
    }

    public String getClasseFiscal() {
      return classeFiscal;
    }

    public BigDecimal getSubTotal() {
      return subTotal;
    }
  }

  private Map<String, BigDecimal> map = new TreeMap<>();

  public void adicionaItemPedido(ItemPedido itemPedido) {
    String classeFiscal = itemPedido.getClasseFiscal();
    BigDecimal novoSubTotal = itemPedido.getSubtotal();
    BigDecimal subTotalAnterior = map.get(classeFiscal);
    if (subTotalAnterior != null) {
      map.put(classeFiscal, subTotalAnterior.add(novoSubTotal));
    } else {
      map.put(classeFiscal, novoSubTotal);
    }
  }

  @Override
  public Iterator<Item> iterator() {
    Iterator<Map.Entry<String, BigDecimal>> mapIterator = map.entrySet().iterator();

    return new Iterator<Item>() {

      @Override
      public boolean hasNext() {
        return mapIterator.hasNext();
      }

      @Override
      public Item next() {
        Map.Entry<String, BigDecimal> entry = mapIterator.next();
        return new Item(entry.getKey(), entry.getValue());
      }
    };
  }
}
