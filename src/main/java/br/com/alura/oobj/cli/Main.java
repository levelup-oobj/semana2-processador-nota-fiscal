package br.com.alura.oobj.cli;

import br.com.alura.oobj.application.*;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    String nomeArquivo = obtemNomeArquivo(args);

    LeitorFonteDados leitor = FonteDados.obtemLeitor(nomeArquivo);
    Pedido pedido = leitor.processa(nomeArquivo);


    BigDecimal totalPedido = pedido.getTotal();

    SubTotalPorClasseFiscal subTotalPorClasseFiscal = new SubTotalPorClasseFiscal();
    for (ItemPedido itemPedido : pedido.getItens()) {
      subTotalPorClasseFiscal.adicionaItemPedido(itemPedido);
    }

    System.out.println("## Total do pedido: " + totalPedido);
    System.out.println("\n## Subtotal por classe fiscal");
    for (SubTotalPorClasseFiscal.Item item : subTotalPorClasseFiscal) {
      System.out.println("\n\tClasse fiscal: " + item.getClasseFiscal());
      System.out.println("\tSubtotal: " + item.getSubTotal());
    }


  }

  private static String obtemNomeArquivo(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }
    return args[0];
  }

}
