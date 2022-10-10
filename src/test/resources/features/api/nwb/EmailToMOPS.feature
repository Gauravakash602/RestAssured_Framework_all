Feature: MOPS Email API Service Scenarios
Verify different POST operations using REST-assured for Email Micro service to send an email to MOPS Team.
as required in various scenarios/STP or NON STP journey cases, for SOLO or JOINT borrowers
Channel Organic Brands RBS/NWB are also applicable and considered for evey journey.

Brand: NWB sass
@nwb @api-test @tempura
Scenario: Details provided are in valid format, request submitted successfully and an email is sent to the NWB_customer successfully.JOINT - Product Switch STP Exception -collection fee - Joint Borrower - NA - 83945207 - (LTV - 14.0%) - HPI
Given create a default request for MopsEmailRequest
And add account details to MopsEmailRequest
| accountNumber | addFeeToMortgage | buyToLet | channel | loanToValue | pendingUpfrontFee | paymentStatusUnknown |valuationAmount | valuationDate | valuationType | gmsFinalSubmissionFailed | requestedBy|
| 83945207       | true             | false   | ORGANIC | 14.0           | 995            | false                | 612830.18       | 25-08-2020      | HPI         |  false                   | CUSTOMER |
And add customer details to MopsEmailRequest
|email|firstName| lastName | dateOfBirth |isSignedBy|isRequestInitiatedBy|
|gaurav1@gmail.com| DFirstName | DLastName | 12-12-1978 |false|true|
|gaurav1@gmail.com | KFirstName | KLastName | 12-12-1979 |false|false|
And add document details to MopsEmailRequest
|name | url |
#| ESIS Document | www.google.com |
And add sub account details to MopsEmailRequest
| currentDealEndDate | initialRate | productCode | productFee | productFeePayable | productName | subAccountNumber | type | sequenceNumber|
| 31-10-2021 | 3.24 | 705067 | 995 | NO                                           | 2 year tracker rate | 1         | NA  |  1          |
When I submit the MopsEmailRequest to switch deal
Then The MopsEmailRequest should be successful

@nwb @api-test @tempura
Scenario:Repayment Strategy Changed- Details provided are in valid format, request submitted successfully and an email is sent to the NWB_customer successfully. JOINT - Product Switch STP Exception - Joint Borrower - NA - 83945207 - (LTV - 14.0%) - HPI
Given create a default request for MopsEmailRequest
And add account details to MopsEmailRequest 
| accountNumber | addFeeToMortgage | buyToLet | channel | loanToValue | pendingUpfrontFee | valuationAmount | valuationDate | valuationType | gmsFinalSubmissionFailed |requestedBy	|
| 83945207        |true            | false    | ORGANIC |14.0         |0                  |  612830.18      | 25-08-2020     | HPI           | false                   |CUSTOMER    |
And add customer details to MopsEmailRequest
|email|firstName| lastName | dateOfBirth |isSignedBy|isRequestInitiatedBy|
|gaurav1@gmail.com| DFirstName | DLastName | 12-12-1970 |false|true|
|gaurav1@gmail.com | KFirstName | KLastName | 12-12-1979 |false|false|
And add document details to MopsEmailRequest
|name | url |
# ESIS Document | www.google.com |
And add repayment strategy details to MopsEmailRequest
| repaymentStrategyChanged | repaymentStrategyConfident | selectedStdRepaymentElements | otherSelectedDesc |
| true | true | ED                                                                     | othersDescription |
And add sub account details to MopsEmailRequest
| currentDealEndDate | initialRate | productCode | productFee | productFeePayable | productName | subAccountNumber | type | sequenceNumber |
| 31-10-2021 | 3.24 | To5067 | 995 | YES                                          | 2 year tracker rate | 1        |	NA   | 1 |
And add exception flag details to MopsEmailRequest
| INTEREST_ONLY_SUBACCOUNT |
When I submit the MopsEmailRequest to switch deal
Then The MopsEmailRequest should be successful





@nwb @api-test @tempura
Scenario: Details provided are in valid format, request submitted successfully and an email is sent to the NWB_customer successfully. JOINT - Product Switch STP Exception -check fee status -Joint Borrower -NA - 83945207 - (LTV - 14.0%) - HPI
Given create a default request for MopsEmailRequest
And add account details to MopsEmailRequest
| accountNumber | addFeeToMortgage | buyToLet | channel | loanToValue | pendingUpfrontFee | paymentStatusUnknown |valuationAmount | valuationDate | valuationType | gmsFinalSubmissionFailed | requestedBy |
| 83945207       | true            | false    | ORGANIC | 14.0        | 0                 |true                  |612830.18        | 25-08-2020   |   HPI	        |   false                  | CUSTOMER     |
And add customer details to MopsEmailRequest
|email|firstName| LastName | dateOfBirth |isSignedBy|isRequestInitiatedBy|
|gaurav1@gmail.com| DFirstName | DLastName | 12-12-1970 |false|true|
|gaurav1@gmail.com | KFirstName | KLastName | 12-12-1979 |false|false|
And add document details to MopsEmailRequest
|name | url |
#| ESIS Document | www.google.com |
And add sub account details to MopsEmailRequest
| currentDealEndDate | initialRate | productCode | productFee | productFeePayable | productName | subAccountNumber | type | sequenceNumber|
| 31-10-2021          | 3.24         | 705067       | 995        | YES             | 2 year tracker rate | 1         |NA     | 1           |
When I submit the MopsEmailRequest to switch deal
Then The MopsEmailRequest should be successful

@nwb @api-test @tempura
Scenario: NON-STP-EXCEPTION - BTL - Product Switch Request - NA - 83945207 - (LTV - 70%) - HPI . NON-STP Exception identified: CIN marker identified AND Existing sub-accou!
Given create a default request for MopsEmailRequest
And add account details to MopsEmailRequest
| accountNumber | addFeeToMortgage | buyToLet | channel | loanToValue | pendingUpfrontFee | valuationAmount | valuationDate | valuationType | gmsFinalSubmissionFailed |requestedBy|
| 83945207        | false          | true     | ORGANIC | 14.0         |0                  | 612830.18       | 25-08-2020    | HPI          | false                    | CUSTOMER   |
And add customer details to MopsEmailRequest
|email|firstName] LastName | dateOfBirth |isSignedBy|isRequestInitiatedBy|
|gaurav1@gmail.com| DFirstName | DLastName | 12-12-1970 |false|true|
|gaurav1@gmail.com | KFirstName | KLastName | 12-12-1979 |false|false|
And add sub account details to MopsEmailRequest
| currentDealEndDate | initialRate | productCode | productFee | productFeePavable | productName | subAccountNumber | type | sequenceNumber |

| 31-10-2021 | 3.24 | 105067 | 995 | YES | 2 year tracker rate | 1 | NA | 1 |
And add exception flag details to MopsEmailRequest
| KYC_SANCTIONS_FRAUD_NOOPS |
| SPLIT_RATE_DATE|
When I submit the MopsEmailRequest to switch deal
Then The MopsEmailRequest should be successful

 

@nwb @api-test @tempura
Scenario: NON-STP-EXCEPTION - BTL - Product Switch Request - NA - 83945207 - (LTV - 70%) - HPI. NON-STP Exception identified: GMS online submission failed
Given create a default request for MopsEmailRequest
And add account details to MopsEmailRequest
| accountNumber | addFeeToMortgage | buyToLet | channel | loanToValue | pendingUpfrontFee | valuationAmount | valuationDate | valuationType | gmsFinalSubmissionFailed | requestedBy|
| 83945207      | false             | true    | ORGANIC | 70          |0                  | 612830.18       | 25-08-2020    | HPI           | true                     | CUSTOMER   |
And add customer details to MopsEmailRequest
|email|firstName| LastName | dateOfBirth |isSignedBy|isRequestinitiatedBy|
|gaurav1@gmail.com| DFirstName | DLastName | 12-12-1970 |false|true|
|gaurav1@gmail.com | KFirstName | KLastName | 12-12-1979 |false|false|
And add sub account details to MopsEmailRequest
| currentDealEndDate | initialRate | productCode | productFee | productFeePayable | productName | subAccountNumber | type | sequenceNumber|
| 31-10-2021         | 3.24        | 705067      | 995        | YES               | 2 year tracker rate | 1        |NA    |  1            |
And add exception flag details to MopsEmailRequest    
| GMS_EXCEPTION |
When I submit the MopsEmailRequest to switch deal
Then The MopsEmailRequest should be successful


