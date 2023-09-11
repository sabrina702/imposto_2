package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrice;
	private double profit;
	private List<Tax> taxes;
	private boolean imported;
	
	public Product(String name, double costPrice, double profit, boolean imported) throws Exception {
		SetName(name);
		SetCostPrice(costPrice);
		SetProfit(profit);
		setImported(imported);
		this.taxes = new ArrayList<Tax>();
	}
	
	public boolean addTax(Tax tax) throws Exception{
		if(tax == null)
			throw new Exception("Imposto não pode ser nulo");
		if(taxes.contains(tax))
			return false;
		else taxes.add(tax);
		return true;
	}
	
	public double calulaSalePrice(Product p) {
		double SalePrice;
		double taxTotal = 0;
		for(Tax tax : taxes ) {
			switch (tax.getAbbr()) {
            case "ICMS":
            	taxTotal += tax.calculateICMS(p);
                break;
            case "IPI":
            	taxTotal += tax.calculateIPI(p);
                break;
            case "ISS":
            	taxTotal += (getCostPrice() + calculateProfit()) * tax.getAliquit();
                break;
        }
	}
		SalePrice = taxTotal + calculateProfit() + costPrice;
	    return SalePrice;
	}
	
	public String nameTax() {
        List<String> nameTax = new ArrayList<>();

        for (Tax taxs : taxes) {
            nameTax.add(taxs.getAbbr());
        }

        return String.join(", ", nameTax);
    }
	
	public double getCostPrice() {
		return this.costPrice;
	}
	
	public String getName() {
		return name;
	}

	public double getProfit() {
		return profit;
	}
	
	public boolean getImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public List<Tax> getTaxes() {
		return taxes;
	}

	private void SetProfit(double profit) throws Exception {
		if(profit <= 0)
			throw new Exception("preço de custoMargem de lucro está inválido");
		this.profit = profit/100;
	}

	private void SetCostPrice(double costPrice) throws Exception {
		if(costPrice <= 0)
			throw new Exception("preço de custo está inválido");
		this.costPrice = costPrice;
	}

	private void SetName(String name) throws Exception {
		if(name == null ||name.equals("")) {
			throw new Exception("Nome inválido");
		}
		this.name = name;
	}

    private double calculateProfit() {
        return costPrice * profit;
    }
  
}
