package eu.cqse.msdnscraper.rules;

/**
 * Describes a rule, as found on MSDN. Some fields are optional and may return
 * <code>null</code>.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 1A6650760DA7CB55CDDDB0E430199FF5
 */
public interface Rule {

	/** Returns the unique ID of a rule. Required. */
	public abstract String getId();

	/** Returns the message of a rule. Required. */
	public abstract String getMessage();

	/** Returns the category of a Rule. Required. */
	public abstract String getCategory();

	/** Returns the description of a Rule. Optional. */
	public abstract String getDescription();

	/** Returns the severity of a Rule. Optional. */
	public abstract String getSeverity();

	/**
	 * Returns the type name of the class that eimplements the rule in c#.
	 * Optional.
	 */
	public abstract String getTypeName();

	/** Canonical rule representation for serialization. */
	public static class SerializedRule implements Rule {

		/** @see #getId() */
		private final String id;

		/** @see #getMessage() */
		private final String message;

		/** @see #getDescription() */
		private final String description;

		/** @see #getCategory() */
		private final String category;

		/** @see #getSeverity() */
		private final String severity;

		/** @see #getTypeName() */
		private final String type;

		/** Constructor. */
		public SerializedRule(Rule rule) {
			id = rule.getId();
			message = rule.getMessage();
			description = rule.getDescription();
			category = rule.getCategory();
			severity = rule.getSeverity();
			type = rule.getTypeName();
		}

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
			return category;
		}

		/** {@inheritDoc} */
		@Override
		public String getSeverity() {
			return severity;
		}

		/** {@inheritDoc} */
		@Override
		public String getTypeName() {
			return type;
		}
	}
}
