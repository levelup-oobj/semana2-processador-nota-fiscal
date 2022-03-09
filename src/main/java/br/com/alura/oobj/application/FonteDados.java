package br.com.alura.oobj.application;

public enum FonteDados {

  CSV(".csv", new LeitorFonteDadosCSV()),
  XML(".xml", new LeitorFonteDadosXML());

  private String extensao;
  private LeitorFonteDados leitorFonteDados;

  FonteDados(String extensao, LeitorFonteDados leitorFonteDados) {
    this.extensao = extensao;
    this.leitorFonteDados = leitorFonteDados;
  }

  public static LeitorFonteDados obtemLeitor(String nomeArquivo) {
    for (FonteDados fonteDados : values()) {
      if (nomeArquivo.endsWith(fonteDados.extensao)) {
        return fonteDados.leitorFonteDados;
      }
    }
    throw new IllegalArgumentException("Formato de arquivo inválido: " + nomeArquivo);
  }

}
