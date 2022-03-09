package br.com.alura.oobj.cli;

import br.com.alura.oobj.application.*;

public class Main {

  public static void main(String[] args) {
    String nomeArquivo = obtemNomeArquivo(args);

    LeitorFonteDados leitor = FonteDados.obtemLeitor(nomeArquivo);

    ProcessadorFonteDados processador = new ProcessadorFonteDados(leitor);
    ResultadoProcessamento resultadoProcessamento = processador.processa(nomeArquivo);

    System.out.println("## Total do pedido: " + resultadoProcessamento.getTotalPedido());
    System.out.println("\n## Subtotal por classe fiscal");
    for (SubTotalPorClasseFiscal.Item item : resultadoProcessamento.getSubTotalPorClasseFiscal()) {
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
