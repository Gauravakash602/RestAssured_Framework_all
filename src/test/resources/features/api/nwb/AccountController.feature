@nwb @api-test @tempura
Feature: Retrieve Addtional Brower Account Summary Based On Account Number

@account
Scenario Outline: To Verify That Happy Path Contains All Expected Fields
Given user has account number <accountNumber> of the product switcher customer
When user accesses the adbo sit end-point in accounts coordinator
Then user should get a response code of 200 in the response
And user should get a response containing the accountNumber key with value of <accountNumber>
And user should get a response containing the totalOutstandingBalance key with value of <totalOutstandingBalance>
And user should get a response containing the monthlyPayment key with value of <monthlyPayment>
And user should get a response containing the buyToLet key with value of <buyToLet>
And user should get a response containing the monthlyPaymentDueDate key with value of <monthlyPaymentDueDate>
And user should get a response containing the lastValuationDate key with value of <lastValuationDate>
And user should get a response containing the lastValuationAmount key with value of <lastValuationAmount>
And user should get a response containing the hpiValuationAmount key with value of <hpiValuationAmount>
And user should get a response containing the loanToValueValuated key with value of <loanToValueValuated>
And user should get a response containing the hpiValuationDate key with value of <hpiValuationDate>
And user should get a response containing the loanToValue key with value of <loanToValue>
And user should get a response containing the sysDate key with value of <sysDate>
And user should get a response containing the customStatusCode key with value of <customStatusCode>
And user should verify the response details against database records with <interestType> interest type

Examples: Main

 |accountNumber | interestType |  totalOutstandingBalance | monthlyPayment |  buyToLet | monthlyPaymentDueDate|  lastValuationDate |  lastValuationAmount|  hpiValuationAmount |  loanToValueValuated | hpiValuationDate | loanToValue | sysDate    | customStatusCode | 
 
 | 33295565     |  Fixed       |  47327.89                |  316.07        | false     | 16-07-2021           | 30-09-2021         |  95441              |    146648.95        |    HPI               | 01-06-2021       | 32          | 28-06-2021 |  2113            |