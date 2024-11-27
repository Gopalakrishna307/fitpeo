

Feature: FitPeo Revenue Calculator
  
  Scenario: User interacts with revenue calculator and validates total reimbursement
  	Given Open the FitPeo HomePage
  	When Navigate to the Revenue Calculator page
  	And Adjust the slider to 820
  	And Update the text field to 560
  	And Select CPT codes CPT99091, CPT99453, CPT99454, CPT99474
  	Then The Total recurring reimbursement for all patients per month should be $110,700

 