package model;

public class Tax {
	private String name;
	private String abbr;
	private double aliquot;
	
	public Tax(String abbr, String name, double aliquot) {
		this.abbr = abbr;
		this.name = name;
		setAliquit(aliquot);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof Tax))
			return false;
		Tax tax = (Tax)obj;
		return this.abbr.equals(tax.abbr);
	}
	
	private double calculate(Product p) {
		return p.getCostPrice() * aliquot;
	}
	
	private void setAliquit(double aliquot) {
		this.aliquot = aliquot/100;
	}
	
	public double calculateICMS(Product p) {
        if (getAbbr().equals("IPI")) {
            return calculate(p);
        } else {
            return p.getCostPrice() * 0.07;
        }
    }
	
	public double calculateIPI(Product p) {
        if (p.getImported()== true) {
        	return p.getCostPrice() * 0.10;
        } else {
        	 return calculate(p);
        }
    }

	public String getName() {
		return name;
	}

	public String getAbbr() {
		return abbr;
	}
	public double getAliquit() {
		return aliquot;
	}
}
