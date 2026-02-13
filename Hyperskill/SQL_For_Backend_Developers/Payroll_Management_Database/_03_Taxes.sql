/* Paying taxes is an important responsibility. Income taxes are progressive.
The amount of taxes each employee pays varies based on their hourly rate, overtime pay, and income.
The progressive tax structure is shown in the following table:
┌───────────┬────────────────────────────┬───────────────────────────────────────────────┐
│ Tax rate  │ Taxable income bracket     │ Tax owed                                      │
├───────────┼────────────────────────────┼───────────────────────────────────────────────┤
│ 10%       │ $0 — 11,000                │ 10% of taxable income                         │
├───────────┼────────────────────────────┼───────────────────────────────────────────────┤
│ 12%       │ $11,001 — 44,725           │ $1,100 + 12% of the amount over 11,000        │
├───────────┼────────────────────────────┼───────────────────────────────────────────────┤
│ 22%       │ $44,726 — 95,375           │ $5,147 + 22% of the amount over 44,725        │
├───────────┼────────────────────────────┼───────────────────────────────────────────────┤
│ 24%       │ $95,376 — 182,100          │ $16,290 + 24% of the amount over 95,375       │
├───────────┼────────────────────────────┼───────────────────────────────────────────────┤
│ 32%       │ $182,101 — 231,250         │ $37,104 + 32% of the amount over 182,100      │
├───────────┼────────────────────────────┼───────────────────────────────────────────────┤
│ 35%       │ $231,251 — 578,125         │ $52,832 + 35% of the amount over 231,250      │
├───────────┼────────────────────────────┼───────────────────────────────────────────────┤
│ 37%       │ $578,126 or more           │ $174,238.25 + 37% of the amount over 578,125  │
└───────────┴────────────────────────────┴───────────────────────────────────────────────┘
To calculate an employee's tax owed, determine their total pay, which is also their taxable income assuming no other deductibles.
Identify the applicable tax bracket and calculate the tax owed.
Develop an efficient method for determining tax owed by any employee.

Objectives:
• Create the function called TaxOwed that takes an employee's taxable income of an employee and outputs the tax owed.
• Output the tax owed by Philip Wilson and Daisy Diamond. */

CALL EmployeeTotalPay('Philip', 'Wilson', 2160, 260 * 8, 0, 6000, @resultA);
CALL EmployeeTotalPay('Daisy', 'Diamond', 2100, 260 * 8, 0, 6000, @resultB);
SELECT ROUND(@resultA, 1) AS "Philip Wilson", ROUND(@resultB, 1) AS "Daisy Diamond";

DELIMITER $$
CREATE FUNCTION TaxOwed(taxable_income FLOAT) RETURNS FLOAT(10, 2)
    DETERMINISTIC
BEGIN
    DECLARE total_tax FLOAT(19, 1) DEFAULT 0;

    IF taxable_income BETWEEN 11001 AND 44725 THEN
        SET total_tax = taxable_income * 0.1;
    ELSEIF taxable_income BETWEEN 11001 AND 44725 THEN
        SET total_tax = 1100 + (taxable_income - 11000) * 0.12;
    ELSEIF taxable_income BETWEEN 44726 AND 95375 THEN
        SET total_tax = 5147 + (taxable_income - 44725) * 0.22;
    ELSEIF taxable_income BETWEEN 95376 AND 182100 THEN
        SET total_tax = 16290 + (taxable_income - 95375) * 0.24;
    ELSEIF taxable_income BETWEEN 182101 AND 231250 THEN
        SET total_tax = 37104 + (taxable_income - 182100) * 0.32;
    ELSEIF taxable_income BETWEEN 231251 AND 578125 THEN
        SET total_tax = 52832 + (taxable_income - 231250) * 0.35;
    ELSE
        SET total_tax = 174238.25 + (taxable_income - 578185) * 0.37;
    END IF;
    RETURN ROUND(total_tax, 1);
END$$
DELIMITER ;

SELECT TaxOwed(137164.8) AS 'Philip Wilson', TaxOwed(89232) AS 'Daisy Diamond';