package com.mpdeimos.msdnscraper.rules.fxcop;

import com.mpdeimos.msdnscraper.rule.RuleDetails;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ChildTextSummarizer;

public class ManagedRuleDetails extends RuleDetails
{
	@Scrape("#mainBody .introduction tr:has(td:first-child:contains(TypeName)) td:nth-child(2)")
	public String typeName;

	@Scrape("#mainBody .introduction tr:has(td:first-child:contains(Category)) td:nth-child(2)")
	public String category;

	@Scrape("#mainBody .introduction tr:has(td:first-child:contains(Breaking Change)) td:nth-child(2)")
	public String breakingChange;

	@Scrape(
			value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(Cause)) > .sectionblock",
			converter = ChildTextSummarizer.class,
			lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String cause;

	@Scrape(
			value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(Rule Description)) > .sectionblock",
			converter = ChildTextSummarizer.class,
			lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String description;

	@Scrape(
			value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(How To Fix Violations)) > .sectionblock",
			converter = ChildTextSummarizer.class,
			lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String hotToFix;

	@Scrape(
			value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(When to Suppress Warnings)) > .sectionblock",
			converter = ChildTextSummarizer.class,
			lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String whenToSuppress;

	/** Constructor. */
	public ManagedRuleDetails(String url)
	{
		super(url);
	}
}
