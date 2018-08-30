package com.github.parzonka;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lombok.Value;

public class MustachifierTest {

  @Test
  public void shouldFillSimpleTemplate() throws Exception {
    Mustachifier mustachifier = new Mustachifier();
    String template = "Hello {{name}}!";
    Values values = new Values("Alice");
    String result = mustachifier.fillFromObject(template, values);
    assertEquals("Hello Alice!", result);
  }

  @Test
  public void shouldFillTemplateFromYaml() throws Exception {
    Mustachifier mustachifier = new Mustachifier();
    String template = "Hello {{name}}!";
    String yaml = "name: Alice\n";
    String result = mustachifier.fillFromYaml(template, yaml);
    assertEquals("Hello Alice!", result);
  }

  @Value
  class Values {

    String name;

  }

}
