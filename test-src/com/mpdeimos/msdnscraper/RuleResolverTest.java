package com.mpdeimos.msdnscraper;

import com.mpdeimos.msdnscraper.rule.RuleResolver;
import com.mpdeimos.msdnscraper.rules.fxcop.FxCopRuleResolver;
import com.mpdeimos.msdnscraper.rules.spcop.SpCopRuleResolver;
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
		assertResolvedData("fxcop-rules.json", new FxCopRuleResolver());
	}

	@Test
	public void testSpCopRules() throws ScraperException
	{
		assertResolvedData("spcop-rules.json", new SpCopRuleResolver());
	}

	private void assertResolvedData(String rulesFile, RuleResolver resolver)
			throws ScraperException
	{
		String expected = readRulesFile(rulesFile);
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		Assert.assertEquals(readRulesFile(rulesFile),
				gson.toJson(resolver.resolve()));
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