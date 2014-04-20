package com.mpdeimos.msdnscraper.rules.spcop;

import com.mpdeimos.msdnscraper.rule.RuleDetails;
import com.mpdeimos.webscraper.Scrape;

public class SpCopRuleDetails extends RuleDetails
{
	@Scrape("#mainBody .tableSection:first-of-type tr:has(td:first-child:contains(TypeName:)) td:nth-child(2)")
	public String typeName;

	@Scrape("#toc_parent > .OH_parentTocLinks > div:last-child")
	public String category;

	@Scrape("#mainBody .tableSection:first-of-type tr:has(td:first-child:contains(Type:)) td:nth-child(2)")
	public String type;

	@Scrape("#mainBody .tableSection:first-of-type tr:has(td:first-child:contains(Severity:)) td:nth-child(2)")
	public String severity;

	@Scrape(
			value = "#mainBody > .OH_CollapsibleAreaRegion:contains(Resolution)+div+p",
			lenient = true)
	public String resolution;

	@Scrape(
			value = "#mainBody > .OH_CollapsibleAreaRegion:contains(Resolution)+div+p",
			lenient = true)
	public String remarks;

	/** Constructor. */
	public SpCopRuleDetails(String url)
	{
		super(url);
	}
}
