package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;
	
	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {// Lembrando CarRental possui a data Start e data finish
		long t1 = carRental.getStart().getTime(); //getTime pega o valor em milliseguons da data;
		long t2 = carRental.getFinish().getTime();
		double hours = (double)(t2 - t1)/1000 / 60 /60;// /1000 esta passando para segundos /60 em minutos e / 60 horas
		
		double basicPayment;
		
		if(hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;//Math.ceil Arredonda o valor para cima
		}else {
			basicPayment = Math.ceil(hours) * pricePerDay;
		}
		
	
		double tax = taxService.tax(basicPayment);// o Imposto é cobrado segundo a regra do BrazilTaxService que esta em TaxService.tax
		
		carRental.setInvoice(new Invoice(basicPayment,tax));// Invoice espera o basicPayment e a taxa porém é carRental que controla
		
	}
	
	
}
