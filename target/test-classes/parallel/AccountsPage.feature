Feature: Home Loan calculator functionality


Scenario: Home loan calculator
Given user is on home loan calculator page
When user gets the title of the page
Then page title should be "Home loan borrowing power calculator"
When User selects "Application type" as "Single"
And User enters "Number of dependants" as "0"
And User selects "Property you would like to buy" as "Home to live in"
And User enters "Your annual income (before tax)" as "80000"
And User selects "Your annual other income (optional) Tooltip" as "10000"
And User selects "Monthly living expenses Tooltip" as "500"
And User selects "Current home loan monthly repayments Tooltip" as "0"
And User selects "Other loan monthly repayments" as "100"
And User selects "Other monthly commitments Tooltip" as "0"
And User selects "Total credit card limits" as "10000"
And User clicks "Work out how much I could borrow" button
Then User verifies borrowing estimates