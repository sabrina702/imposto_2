package view;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Tax;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Tax IPI = new Tax("IPI", "Imposto Prod.Industrializado", 8);
		Tax ISS = new Tax("ISS", "Imposto sobre Servicos", 5 );
		Tax ICMS = new Tax("ICMS", "Imposto sobre Circulação de Mercadorias e Serviços", 5);
		
		Product arroz = new Product("Arroz", 7.00, 20, true);
		arroz.addTax(ICMS);
		arroz.addTax(ISS);
		
		Product feijao = new Product("Feijão", 7.00, 25, true);
		feijao.addTax(ICMS);
		feijao.addTax(ISS);
		
		Product carne = new Product("Carne", 7.00, 30, true);
		carne.addTax(ICMS);
		carne.addTax(IPI);
		
		Product cerveja = new Product("Cerveja", 7.00, 35, true);
		cerveja.addTax(ICMS);
		cerveja.addTax(ISS);
		cerveja.addTax(IPI);
		
		Product gas = new Product("Gás", 7.00, 15, true);
		gas.addTax(ICMS);
		gas.addTax(IPI);
		
		Product gasolina = new Product("Gasolina", 7.00, 15, true);
		gasolina.addTax(ICMS);
		
		List<Product> produtos = new ArrayList<>();
		produtos.add(arroz);
		produtos.add(feijao);
		produtos.add(carne);
		produtos.add(cerveja);
		produtos.add(gas);
		produtos.add(gasolina);
		 
		 for (Product produto : produtos) {
	        	System.out.println(produto.getName()+": Preço Custo: "+produto.getCostPrice()+" Impostos: " +produto.nameTax() +" Margem Lucro: "+produto.getProfit()+"%");
	        }
	        System.out.println("\n");
	        for (Product produto : produtos) {
	            System.out.printf("Produto: %s - Preço de Venda: R$%.2f%n", produto.getName(), produto.calulaSalePrice(produto));
	        }
		
		
	}

}
