package cat.udl.eps.softarch.fll;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.Suite;

@Suite
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cat.udl.eps.softarch.fll.steps")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
class CucumberTest {
	// Keep this class empty, it is used for triggering the Cucumber tests
}
