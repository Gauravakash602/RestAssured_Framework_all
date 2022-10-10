@geteExcelData
Feature: Organic STP/NONSTP submission Product Switcher and the validations related for the complete journey

@UI @Regression
Scenario Outline: <SNO>Sole/Joint - Cancel PS Application < SVR or 5 days before switch
Given I generate the token with journey as "Product switch",channel as "Organic", Brand as "NatWest", Environment as "UAT" with account "<AccountNum>" and cin "<CIN>" with S1S2 validation "" with updated field ""
Then user is on Welcome page of product switcher and accept the cookies
Then User verify the page message "You've already applied"
Then User click on the button cancel "btnCancelyourswitch"
Then User verify the page message "To cancel your mortgage switch now, you need to call us."
Then User verify the page message "Or get in touch to cancel:"
Examples:
| SNO | AccountNum | CIN |
|1 | 32330146 | 1537846133 |
