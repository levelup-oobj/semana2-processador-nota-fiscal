package br.com.alura.oobj.application;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LeitorFonteDadosXML implements LeitorFonteDados {

  @Override
  public Pedido processa(String nomeArquivo) {
    try {
      Reader reader = new FileReader(nomeArquivo);
      XmlMapper mapper = new XmlMapper();

      return mapper.readValue(reader, Pedido.class);
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }

}
