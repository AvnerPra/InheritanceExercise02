package entities;

public class CompanyTaxPayer extends TaxPayer{

    private Integer numberOfEmployees;


    public CompanyTaxPayer() {
        super();
    }
    public CompanyTaxPayer(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }


    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }
    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public final double tax (){
        double tax = 0;
        if(numberOfEmployees <= 10){
            tax = annualIncome * 0.16;
        }
        else{
            tax = annualIncome * 0.14;
        }return tax;
    }
}
