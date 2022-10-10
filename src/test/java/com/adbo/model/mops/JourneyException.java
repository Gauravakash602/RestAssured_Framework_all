package com.adbo.model.mops;

public enum JourneyException {

	KYC_SANCTIONS_FRAUD_NOOPS("CIN marker identified."),
	KYC_SANCTIONS_FRAUD_NOOPS_DATA_ISSUE("CIN marker not retrievable."),
	INFLIGHT_ADBO_APPLICATION("Inflight ADBO application."),
	INFLIGHT_SWITCH_APPLICATION("Inflight Switch Application."),
	INTEREST_ONLY_SUBACCOUNT("Interest only - repayment strategy review."),
	INTEREST_ONLY_STRATEGY_NOT_RETRIEVABLE("Interest only - repayment strategy not retrievable."),
	TERM_REMAINING_LESS_THAN_EQUAL_TO_30("Amortisation issue."),
	SPLIT_RATE_DATE("Existing sub-account - different dates/rates."),
	GMS_PRODUCT_CODE_NOT_RETRIEVABLE("GMS product code not retrievable."),
	STRING_BUFFFER_FORFEITURE_OF_LEASE("GMS error identified"), GMS_EXCEPTION("GMS online submission failed.");

	private String message;

	private JourneyException(String message) {

		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}