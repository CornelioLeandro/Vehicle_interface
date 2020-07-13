package model.services;

public interface TaxService {// com interface meu serviço RentalService não fica dependente de BrazilTaxService -- assim pode ser criada varios
	// imposto tipo CanadaTaxService FranceTaxService e isso não vai ter que ficar alterando em todas as outros servicos.

	double tax(double amount);
}
