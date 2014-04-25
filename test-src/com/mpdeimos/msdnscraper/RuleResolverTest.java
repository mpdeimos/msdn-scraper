package com.mpdeimos.msdnscraper;

import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.msdnscraper.rule.RuleResolver;
import com.mpdeimos.msdnscraper.rules.fxcop.FxCopRuleResolver;
import com.mpdeimos.msdnscraper.rules.spcop.SpCopRuleResolver;
import com.mpdeimos.msdnscraper.rules.warnings.WarningResolver;
import com.mpdeimos.webscraper.ScraperException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Test case for parsing tests msdn rule files.
 * 
 * @author mpdeimos
 */
public class RuleResolverTest
{
	@Test
	public void testFxCopManagedRules() throws ScraperException
	{
		assertResolvedData("fxcop-rules", new FxCopRuleResolver());
	}

	@Test
	public void testSpCopRules() throws ScraperException
	{
		assertResolvedData("spcop-rules", new SpCopRuleResolver());
	}

	@Test
	public void testCompilerWarnings() throws ScraperException
	{
		assertResolvedData("compiler-warnings", new WarningResolver());
	}

	private void assertResolvedData(String rulesFile, RuleResolver resolver)
			throws ScraperException
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		Rule[] rules = resolver.resolve();
		Assert.assertEquals(readRulesFile(rulesFile + ".json"),
				gson.toJson(rules));

		for (int i = 0; i < rules.length; i++)
		{
			rules[i] = new Rule.SerializedRule(rules[i]);
		}
		Assert.assertEquals(readRulesFile(rulesFile + ".simple.json"),
				gson.toJson(rules));
	}

	/** Reads a rules file and fails of reading is not possible. */
	private String readRulesFile(String filename)
	{
		try
		{
			return new String(
					Files.readAllBytes(Paths.get("rules", filename))); //$NON-NLS-1$
		}
		catch (IOException e)
		{
			Assert.fail("Could not read test file: " + e.getMessage()); //$NON-NLS-1$
			return null;
		}
	}
}