package com.github.parzonka;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UncheckedIOException;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class Mustachifier {

  public <T> String fillFromObject(String template, T values) {
    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache m = mf.compile(new StringReader(template), "");
    StringWriter writer = new StringWriter();
    try {
      m.execute(writer, values)
          .flush();
      return writer.toString();
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}