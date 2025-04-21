# Payroll Calculator App

### As a payroll user, I need to be able to calculate my employee’s payroll.

A payroll calculation for an individual employee consists of:
    
* Worked hours
* Pay Rates
    * Regular Hourly Rate (Up to 40 hours/week)
    * Overtime Hourly Rate – 1.5x Regular Hourly Rate (Applies to hours worked over 40 hours/week)
*	Tax Rates
    *	Federal Tax Rate

## Formulas

```Regular_Pay = Regular_Hours * Regular_Pay_Rate

Overtime_Pay = Overtime_Hours * Regular_Pay_Rate * 1.5

Gross_Pay = Regular_Pay + Overtime_Pay

Tax_Amount = Gross_Pay * Tax_Rate

Net Pay = Gross_Pay - Tax_Amount
```

###  Edge Cases

The application should gracefully handle:

*	Employees that work less than 40 hours, 40 hours exactly or overtime.
*	Zero or negative hours
*	Too many hours (Week has 168 total hours except during time changes, for simplicity assume the employee can report up to 168 hours)
`
Bonus
*	Create a list of employees and calculate their payroll
*	Allow each employee to have its own pay rate


