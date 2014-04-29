package eu.cqse.msdnscraper.rules.fxcop;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ChildTextSummarizer;

import eu.cqse.msdnscraper.rules.RuleDetails;

/**
 * Details site for FxCop rules for managed code.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 8D959EA5EA944BD2B2C50B6E7593BCAE
 */
public class ManagedRuleDetails extends RuleDetails {
	/** The type name the c# class that implements the rule. */
	@Scrape("#mainBody .introduction tr:has(td:first-child:contains(TypeName)) td:nth-child(2)")
	public String typeName;

	/** The rule category. */
	@Scrape("#mainBody .introduction tr:has(td:first-child:contains(Category)) td:nth-child(2)")
	public String category;

	/** Indicates whether fixing the finding will be a breaking change. */
	@Scrape("#mainBody .introduction tr:has(td:first-child:contains(Breaking Change)) td:nth-child(2)")
	public String breakingChange;

	/** The cause of the finding. */
	@Scrape(value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(Cause)) > .sectionblock", converter = ChildTextSummarizer.class, lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String cause;

	/** The description of the rule. */
	@Scrape(value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(Rule Description)) > .sectionblock", converter = ChildTextSummarizer.class, lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String description;

	/** Hints for how to fix the finding. */
	@Scrape(value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(How To Fix Violations)) > .sectionblock", converter = ChildTextSummarizer.class, lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String hotToFix;

	/** Hints for suppressing the finding. */
	@Scrape(value = "#mainBody > div:has(.LW_CollapsibleArea_TitleDiv:contains(When to Suppress Warnings)) > .sectionblock", converter = ChildTextSummarizer.class, lenient = true)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String whenToSuppress;

	/** Constructor. */
	public ManagedRuleDetails(String url) {
		super(url);
	}
}
