package com.github.parzonka.mustachifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.parzonka.mustachifier.Mustachifier;

import lombok.Value;

public class MustachifierTest {

  @Test
  public void shouldFillSimpleTemplate() throws Exception {
    String template = "Hello {{name}}!";
    Values values = new Values("Alice");
    String result = Mustachifier.fillFromObject(template, values);
    assertEquals("Hello Alice!", result);
  }

  @Test
  public void shouldFillSimpleTemplateFromYaml() throws Exception {
    String template = "Hello {{name}}!";
    String yaml = "name: Alice\n";
    String result = Mustachifier.fillFromYaml(template, yaml);
    assertEquals("Hello Alice!", result);
  }

  @Test
  public void shouldFillDeeperTemplateFromYaml() throws Exception {
    String template = "Hello {{some.name}}!";
    String yaml = "some:\n  name: Alice\n";
    String result = Mustachifier.fillFromYaml(template, yaml);
    assertEquals("Hello Alice!", result);
  }

  @Test
  public void shouldFillDeeperTemplateFromYamlWithList() throws Exception {
    String template = "{{#names}}\n{{.}}\n{{/names}}";
    String yaml = "names:\n  - Foo\n  - Bar\n";
    String result = Mustachifier.fillFromYaml(template, yaml);
    assertEquals("Foo\nBar\n", result);
  }

  @Value
  class Values {

    String name;

  }

}
