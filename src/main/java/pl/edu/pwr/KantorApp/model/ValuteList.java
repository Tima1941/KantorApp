package pl.edu.pwr.KantorApp.model;
//Klassa która zawiera w sobie list dostępnych valut
public class ValuteList {

	private static String[] valutes = { "CAD", "HKD", "ISK", "PHP", "DKK", "HUF", "CZK", "AUD", "RON", "SEK", "IDR",
			"INR", "BRL", "RUB", "HRK", "JPY", "THB", "CHF", "SGD", "PLN", "BGN", "TRY", "CNY", "NOK", "NZD", "ZAR",
			"USD", "MXN", "ILS", "GBP", "KRW", "MYR","EUR" };

	/**
	 * @return the valutes
	 */
	public static String[] getValutes() {
		return valutes;
	}

}
