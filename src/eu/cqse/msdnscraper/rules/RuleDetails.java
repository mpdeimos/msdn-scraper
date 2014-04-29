package eu.cqse.msdnscraper.rules;

import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;

/**
 * Describes a site containing rule details.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 3C9BD5CB23969C231D6C9392EB1388F5
 */
public abstract class RuleDetails implements ScraperSourceProvider {
	/** The URL of the details site. */
	private final String url;

	/** Constructor. */
	public RuleDetails(String url) {
		this.url = url;
	}

	/** {@inheritDoc} */
	@Override
	public ScraperSource getSource() {
		return ScraperSource.fromUrl(this.url);
	}
}
