package eu.cqse.msdnscraper.rules.spcop;

import com.mpdeimos.webscraper.Scrape;

import eu.cqse.msdnscraper.rules.RuleDetails;

/**
 * Site containing details for SpCop rules.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 6A457B2C4A2BBE820E7DF2D15A636749
 */
public class SpCopRuleDetails extends RuleDetails {
	/** The name of the type that implements the rule in c# . */
	@Scrape("#mainBody .tableSection:first-of-type tr:has(td:first-child:contains(TypeName:)) td:nth-child(2)")
	public String typeName;

	/** The rule category. */
	@Scrape("#toc_parent > .OH_parentTocLinks > div:last-child")
	public String category;

	/** The type of this rule. */
	@Scrape("#mainBody .tableSection:first-of-type tr:has(td:first-child:contains(Type:)) td:nth-child(2)")
	public String type;

	/** the severity of this rule. */
	@Scrape("#mainBody .tableSection:first-of-type tr:has(td:first-child:contains(Severity:)) td:nth-child(2)")
	public String severity;

	/** Hints of how to resolve a finding. */
	@Scrape(value = "#mainBody > .OH_CollapsibleAreaRegion:contains(Resolution)+div+p", lenient = true)
	public String resolution;

	/** Further rule remarks. */
	@Scrape(value = "#mainBody > .OH_CollapsibleAreaRegion:contains(Resolution)+div+p", lenient = true)
	public String remarks;

	/** Constructor. */
	public SpCopRuleDetails(String url) {
		super(url);
	}
}
