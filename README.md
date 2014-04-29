eu.cqse.msdnscraper
===================

Scrapes MSDN for various information like a summary of all FxCop rules, C# compiler warinigs.

Usage
-----

* Execute class eu.cqse.msdnscraper.Main on the commandline. The rules should be written to json files in the working directory.
* The test suite (test-src) can also be used to see if rules have been altered and the json needs an update.
* If scraping fails, use the test suite to debug the failure.
