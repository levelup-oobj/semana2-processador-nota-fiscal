package br.com.alura.oobj.application;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LeitorFonteDadosCSV implements  LeitorFonteDados {

  @Override
  public Pedido processa(String nomeArquivo) {
    try {
      Reader reader = new FileReader(nomeArquivo);
      CsvToBean<ItemPedido> csvToBean = new CsvToBeanBuilder<ItemPedido>(reader)
          .withSeparator(';')
          .withType(ItemPedido.class)
          .build();
      return new Pedido(csvToBean.parse());
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }

}
