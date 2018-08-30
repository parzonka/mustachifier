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
  public void shouldFillSimpleTemplateFromYaml() throws Exception {
    Mustachifier mustachifier = new Mustachifier();
    String template = "Hello {{name}}!";
    String yaml = "name: Alice\n";
    String result = mustachifier.fillFromYaml(template, yaml);
    assertEquals("Hello Alice!", result);
  }

  @Test
  public void shouldFillDeeperTemplateFromYaml() throws Exception {
    Mustachifier mustachifier = new Mustachifier();
    String template = "Hello {{some.name}}!";
    String yaml = "some:\n  name: Alice\n";
    String result = mustachifier.fillFromYaml(template, yaml);
    assertEquals("Hello Alice!", result);
  }

  @Test
  public void shouldFillDeeperTemplateFromYaml2() throws Exception {
    Mustachifier mustachifier = new Mustachifier();
    String template = "{{#names}}\n{{.}}\n{{/names}}";
    String yaml = "names:\n  - Foo\n  - Bar\n";
    String result = mustachifier.fillFromYaml(template, yaml);
    assertEquals("Foo\nBar\n", result);
  }

  @Value
  class Values {

    String name;

  }

}
