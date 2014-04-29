package eu.cqse.msdnscraper.rules.warnings;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;
import com.mpdeimos.webscraper.conversion.ChildTextSummarizer;

import eu.cqse.msdnscraper.rules.Rule;

/**
 * A C# Compiler warning rule. Compiler warnings have no type name or severity.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: FAA8F415296EC33B6D2D3471A49B6E28
 */
public class WarningRule implements ScraperSourceProvider, Rule {
	/** @see #getId() */
	@Scrape(value = "#content h1.title", regex = ".*(CS\\d*).*")
	public String id;

	/** @see #getMessage() */
	@Scrape(value = "#mainBody #errorTitleSection, #mainBody > p:matchesOwn(.+)", resultIndex = 0)
	public String message;

	/** @see #getDescription() */
	@Scrape(value = "#mainBody .introduction", resultIndex = 0, converter = ChildTextSummarizer.class)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String description;

	/** @see #getCategory() */
	@Scrape(value = "#content h1.title", regex = ".*\\((.*)\\).*")
	public String category;

	/** The last Visual Studio version that contains this warning. */
	@Scrape("#curversion")
	public String version;

	/** Returns the url that contains further information regarding this rule. */
	private final String url;

	/** Construct. */
	public WarningRule(String url) {
		this.url = url;
	}

	/** {@inheritDoc} */
	@Override
	public ScraperSource getSource() {
		return ScraperSource.fromUrl(url);
	}

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public String getMessage() {
		return message;
	}

	/** {@inheritDoc} */
	@Override
	public String getDescription() {
		return description;
	}

	/** {@inheritDoc} */
	@Override
	public String getCategory() {
		return category;
	}

	/** {@inheritDoc} */
	@Override
	public String getSeverity() {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public String getTypeName() {
		return null;
	}

}
