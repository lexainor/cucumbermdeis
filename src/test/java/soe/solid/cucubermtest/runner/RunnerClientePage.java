package soe.solid.cucubermtest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cliente.feature",
        glue = {"soe.solid.cucubermtest.steps"},
        snippets = CucumberOptions.SnippetType.UNDERSCORE)
public class RunnerClientePage {
}
