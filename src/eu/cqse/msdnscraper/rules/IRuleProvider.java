package eu.cqse.msdnscraper.rules;

import java.util.Collection;

import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;

/**
 * Provides a collection of rules. The rules are gained by scraping the document
 * provided by {@link ScraperSourceProvider}.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: E2A314B3518EBAF17F5D2B3D1B0E27D5
 */
public interface IRuleProvider extends ScraperSourceProvider {

	/** Returns the rules found in the document(s). */
	public Collection<? extends Rule> getRules();
}
