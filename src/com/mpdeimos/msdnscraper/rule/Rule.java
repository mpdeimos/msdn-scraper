package com.mpdeimos.msdnscraper.rule;

public abstract class Rule
{
	public abstract RuleDetails getDetails();

	public abstract String getId();

	public abstract String getMessage();

	public abstract String getDescription();

	public abstract String getCategory();

	public abstract String getSeverity();

	public abstract String getTypeName();

	public static class SerializedRule extends Rule
	{
		private final String id;
		private final String message;
		private final String description;
		private final String category;
		private final String severity;
		private final String type;

		public SerializedRule(Rule rule)
		{
			id = rule.getId();
			message = rule.getMessage();
			description = rule.getDescription();
			category = rule.getCategory();
			severity = rule.getSeverity();
			type = rule.getTypeName();
		}

		@Override
		public RuleDetails getDetails()
		{
			return null;
		}

		@Override
		public String getId()
		{
			return id;
		}

		@Override
		public String getMessage()
		{
			return message;
		}

		@Override
		public String getDescription()
		{
			return description;
		}

		@Override
		public String getCategory()
		{
			return category;
		}

		@Override
		public String getSeverity()
		{
			return severity;
		}

		@Override
		public String getTypeName()
		{
			return type;
		}
	}
}
