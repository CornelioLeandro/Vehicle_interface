package model.services;

public interface TaxService {// com interface meu servi�o RentalService n�o fica dependente de BrazilTaxService -- assim pode ser criada varios
	// imposto tipo CanadaTaxService FranceTaxService e isso n�o vai ter que ficar alterando em todas as outros servicos.

	double tax(double amount);
}
