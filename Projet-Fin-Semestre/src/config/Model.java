package config;

import java.io.Serializable;

public class Model implements Serializable{
	// TODO java doc

	private String name;
	private final int LOAN_DURATION_LIMIT;
	private final int LOAN_QUANTITY_LIMIT;

	public Model(String name, int quantity_limit, int duration_limit) {
		this.name = name;
		LOAN_DURATION_LIMIT = duration_limit;
		LOAN_QUANTITY_LIMIT = quantity_limit;
	}

	public String toString() {
		return "name: " + name + ", loan duration limit: "
				+ LOAN_DURATION_LIMIT + ", loan quantity limit: "
				+ LOAN_QUANTITY_LIMIT;
	}

	public String getName() {
		return name;
	}

	public int getLoanDurationLimit() {
		return LOAN_DURATION_LIMIT;
	}

	public int getLoanQuantityLimit() {
		return LOAN_QUANTITY_LIMIT;
	}
}
