package eu.cqse.msdnscraper.rules.fxcop;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import eu.cqse.msdnscraper.rules.Rule;

/**
 * Describes a FxCop rule for managed (C#) code.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 88F9DCECFB4BA471EDC5EA7D3AB2860E
 */
public class ManagedRule implements Rule {

	/** @see #getId() */
	@Scrape("td:nth-child(1)")
	public String id;

	/** @see #getMessage() */
	@Scrape(value = "td:nth-child(2)", regex = ".*:\\s(.*)")
	public String message;

	/** @see #getDescription() */
	@Scrape("td:nth-child(3)")
	public String description;

	/** The details site containing further rule information. */
	@Scrape(value = "td:nth-child(2) a", attribute = "href", converter = ConstructConverter.class)
	public ManagedRuleDetails details;

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
		return details.category;
	}

	/** {@inheritDoc} */
	@Override
	public String getSeverity() {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public String getTypeName() {
		return details.typeName;
	}

}
