package eu.cqse.msdnscraper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mpdeimos.webscraper.ScraperException;

import eu.cqse.msdnscraper.rules.Rule;
import eu.cqse.msdnscraper.rules.RuleResolver;
import eu.cqse.msdnscraper.rules.fxcop.FxCopRuleResolver;
import eu.cqse.msdnscraper.rules.spcop.SpCopRuleResolver;
import eu.cqse.msdnscraper.rules.warnings.WarningRuleResolver;

/**
 * Regression test for parsing tests MSDN rule files.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 59A5F8ABA6EEB02559A0D923B4996C05
 */
public class RuleResolverTest {
	/** Tests parsing FxCop rules. */
	@Test
	public void testFxCopManagedRules() throws ScraperException {
		assertResolvedData("fxcop-rules", new FxCopRuleResolver());
	}

	/** tests parsing SpCop rules. */
	@Test
	public void testSpCopRules() throws ScraperException {
		assertResolvedData("spcop-rules", new SpCopRuleResolver());
	}

	/** Tests parsing compiler warnings. */
	@Test
	public void testCompilerWarnings() throws ScraperException {
		assertResolvedData("compiler-warnings", new WarningRuleResolver());
	}

	/**
	 * Asserts that the resolved rules equal the ones specified by the provided
	 * rules file.
	 */
	private void assertResolvedData(String rulesFile, RuleResolver resolver)
			throws ScraperException {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
				.create();
		Rule[] rules = resolver.resolve();
		Assert.assertEquals(readRulesFile(rulesFile + ".json"),
				gson.toJson(rules));

		for (int i = 0; i < rules.length; i++) {
			rules[i] = new Rule.SerializedRule(rules[i]);
		}
		Assert.assertEquals(readRulesFile(rulesFile + ".simple.json"),
				gson.toJson(rules));
	}

	/** Reads a rules file and fails of reading is not possible. */
	private String readRulesFile(String filename) {
		try {
			return new String(Files.readAllBytes(Paths.get("rules", filename))); //$NON-NLS-1$
		} catch (IOException e) {
			Assert.fail("Could not read test file: " + e.getMessage()); //$NON-NLS-1$
			return null;
		}
	}
}