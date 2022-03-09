package br.com.alura.oobj.application;

import java.math.BigDecimal;

public class ResultadoProcessamento {

  private final BigDecimal totalPedido;
  private final SubTotalPorClasseFiscal subTotalPorClasseFiscal;

  public ResultadoProcessamento(BigDecimal totalPedido, SubTotalPorClasseFiscal subTotalPorClasseFiscal) {
    this.totalPedido = totalPedido;
    this.subTotalPorClasseFiscal = subTotalPorClasseFiscal;
  }

  public BigDecimal getTotalPedido() {
    return totalPedido;
  }

  public SubTotalPorClasseFiscal getSubTotalPorClasseFiscal() {
    return subTotalPorClasseFiscal;
  }

}
