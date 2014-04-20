package com.mpdeimos.msdnscraper;

import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.msdnscraper.rules.spcop.SpCopRuleResolver;
import com.mpdeimos.webscraper.ScraperException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main
{
	public static void main(String[] args) throws ScraperException, IOException
	{
		// Document doc = getDoc(ManagedRules.URL);
		//
		// ManagedRules site = new ManagedRules();
		// Builder builder = new Scraper.Builder(doc, site);
		// builder.build().scrape();
		//
		// int count = 0;
		// for (Rule rule : site.rules)
		// {
		// System.out.println("(" + (++count) + "/" + site.rules.length + ") "
		// + rule.id + ": " + rule.details.url);
		// doc = getDoc(rule.details.url);
		// builder = new Scraper.Builder(doc, rule.details);
		// builder.build().scrape();
		// }

		SpCopRuleResolver ruleResolver = new SpCopRuleResolver();
		Rule[] rules = ruleResolver.resolve();

		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
				.create();
		System.out.println(gson.toJson(rules));

		Files.write(Paths.get("spcop-rules.json"),
				gson.toJson(rules).getBytes());
	}

	private static Document getDoc(String url) throws IOException
	{
		return getDoc(url, 10);
	}

	private static Document getDoc(String url, int retries) throws IOException
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
				throw e;
			}
			return getDoc(url, retries--);
		}
		return doc;
	}
}
