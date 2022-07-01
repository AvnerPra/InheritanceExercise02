package entities;

public class IndividualTaxPayer extends TaxPayer{

    private Double healthExpenditures;

    public IndividualTaxPayer() {
        super();
    }
    public IndividualTaxPayer(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }


    public Double getHealthExpenditures() {
        return healthExpenditures;
    }
    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public final double tax(){
        double tax = 0;
        if(annualIncome < 20000){
            tax = annualIncome * 0.15;
        }
        else {
            tax = annualIncome * 0.25;
        }
        return tax - (healthExpenditures/2);
    }
}
