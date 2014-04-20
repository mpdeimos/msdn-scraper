package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.Scraper;
import com.mpdeimos.webscraper.Scraper.Builder;
import com.mpdeimos.webscraper.ScraperException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class RuleResolver
{
	private final ExecutorService executor = Executors.newFixedThreadPool(16);

	public final Rule[] resolve() throws ScraperException
	{
		// ExecutorCompletionService<?> ecs = new ExecutorCompletionService<>(
		// executor);
		//
		// CountDownLatch cdl;

		ArrayList<Rule> rules = new ArrayList<Rule>();
		for (RuleOverview overview : getRuleOverviewSites())
		{
			scrape(overview.getUrl(), overview);

			for (Rule rule : overview.getRules())
			{
				RuleDetails details = rule.getDetails();
				if (details != null)
				{
					scrape(details.getUrl(), details);
				}
			}

			rules.addAll(overview.getRules());
		}

		try
		{
			executor.shutdown();
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace(); // FIXME
		}

		return rules.toArray(new Rule[rules.size()]);
	}

	protected abstract RuleOverview[] getRuleOverviewSites()
			throws ScraperException;

	protected void scrape(String url, Object object)
			throws ScraperException
	{
		Document doc = getDoc(url);
		Builder builder = new Scraper.Builder(doc, object);
		builder.build().scrape();
	}

	private Document getDoc(String url) throws ScraperException
	{
		return getDoc(url, 10);
	}

	private Document getDoc(String url, int retries)
			throws ScraperException
	{
		Document doc;
		try
		{
			doc = Jsoup.connect(url).get();
		}
		catch (IOException e)
		{
			if (retries == 0)
			{
				throw new ScraperException("Could not connect to website", e);
			}
			return getDoc(url, retries--);
		}
		return doc;
	}
}
