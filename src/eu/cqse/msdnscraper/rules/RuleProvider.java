package eu.cqse.msdnscraper.rules;

import com.mpdeimos.webscraper.ScraperSource;

/**
 * Describes a website containing an overview of rules.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 7A0FD9A21333BCF6AB1DDE93C2CCC595
 */
public abstract class RuleProvider implements IRuleProvider {
	/** The url of the rule overview page. */
	private final String url;

	/** Constructor. */
	public RuleProvider(String url) {
		this.url = url;
	}

	/** {@inheritDoc} */
	@Override
	public ScraperSource getSource() {
		return ScraperSource.fromUrl(this.url);
	}
}
