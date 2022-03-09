package br.com.alura.oobj.application;

import java.math.BigDecimal;

public class ProcessadorFonteDados {

  private final LeitorFonteDados leitor;

  public ProcessadorFonteDados(LeitorFonteDados leitor) {
    this.leitor = leitor;
  }

  public ResultadoProcessamento processa(String nomeArquivo) {
    Pedido pedido = leitor.recupera(nomeArquivo);

    BigDecimal totalPedido = pedido.getTotal();

    SubTotalPorClasseFiscal subTotalPorClasseFiscal = new SubTotalPorClasseFiscal();
    for (ItemPedido itemPedido : pedido.getItens()) {
      subTotalPorClasseFiscal.adicionaItemPedido(itemPedido);
    }

    return new ResultadoProcessamento(totalPedido, subTotalPorClasseFiscal);
  }

}
