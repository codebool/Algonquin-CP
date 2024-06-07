package Week05_Practise;

public class CommissionEmployee extends Employee {
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    // five-argument constructor
    public CommissionEmployee(String first, String last, String ssn, double sales, double rate) {
        super(first, last, ssn);
        setGrossSales(sales);
        setCommissionRate(rate);
    }

    // set commission rate
    public void setCommissionRate(double rate) {
        commissionRate = (rate > 0.0 && rate < 1.0) ? rate : 0.0;
    }

    // return commission rate
    public double getCommissionRate() {
        return commissionRate;
    }

    // set gross sales amount
    public void setGrossSales(double sales) {
        grossSales = (sales < 0.0) ? 0.0 : sales;
    }

    // return gross sales amount
    public double getGrossSales() {
        return grossSales;
    }

    // calculate earnings; override abstract method getPaymentAmount in Employee
    @Override
    public double getPaymentAmount() {
        return getCommissionRate() * getGrossSales();
    }

    // return String representation of CommissionEmployee object
    @Override
    public String toString() {
        return String.format("%s: %s\n%s: $%,.2f; %s: %.2f",
                "commission employee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
    }
}
