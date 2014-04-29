package eu.cqse.msdnscraper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mpdeimos.webscraper.ScraperException;

import eu.cqse.msdnscraper.rules.Rule;
import eu.cqse.msdnscraper.rules.RuleResolver;
import eu.cqse.msdnscraper.rules.fxcop.FxCopRuleResolver;
import eu.cqse.msdnscraper.rules.spcop.SpCopRuleResolver;
import eu.cqse.msdnscraper.rules.warnings.WarningRuleResolver;

/**
 * Executes the rule scraper for MSDN-like websites.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: FA9283261401ECD1031245183A703907
 */
public class Main {
	/** The Gson serializer. */
	private static Gson GSON = new GsonBuilder().setPrettyPrinting()
			.serializeNulls().create();

	/** Program entry point. */
	public static void main(String[] args) throws ScraperException, IOException {
		writeRuleFile(new SpCopRuleResolver(), "spcop-rules.json");
		writeRuleFile(new FxCopRuleResolver(), "fxcop-rules.json");
		writeRuleFile(new WarningRuleResolver(), "compiler-warnings.json");
	}

	/** Resolves the rules and writes a json file. */
	private static void writeRuleFile(RuleResolver ruleResolver, String filename)
			throws ScraperException, IOException {
		Rule[] rules = ruleResolver.resolve();

		// Re-packs the rules to have a consistent format.
		for (int i = 0; i < rules.length; i++) {
			rules[i] = new Rule.SerializedRule(rules[i]);
		}

		Files.write(Paths.get(filename), GSON.toJson(rules).getBytes());
	}
}
