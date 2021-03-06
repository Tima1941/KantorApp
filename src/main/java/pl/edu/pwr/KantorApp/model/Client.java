package pl.edu.pwr.KantorApp.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
//Client dziedzici od klassy user dodatkowo ma w sobie balances i trades
//balances jest wykorzystane dla przehowywania balansu klienta
//trades dla zapisywania trajdów czyli transakji klientów  
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Client extends User {
	protected Map<String, Double> balances;
	protected List<Trade> trades;

	public Client(String login, String name, String surname, String emailAddress, String password,
			Map<String, Double> balances, List<Trade> trades) {
		super(login, name, surname, emailAddress, password);
		this.balances = balances;
		this.trades = trades;
	}

	public Client(UUID id, LocalDateTime createdDate, String login, String name, String surname, String emailAddress,
			String password, Map<String, Double> balances, List<Trade> trades) {
		super(id, createdDate, login, name, surname, emailAddress, password);
		this.balances = balances;
		this.trades = trades;
	}

	public Client() {
		super();
	}

	
	//dodaje trade
	public boolean addTrade(Trade trade) {
		trades.add(trade);
		updateBalance(trade.currency1, -trade.amount1);
		updateBalance(trade.currency2, trade.getAmount2());

		return true;
	}

	/**
	 * @return the trades
	 */
	public List<Trade> getTrades() {
		return trades;
	}

	/**
	 * @param trades the trades to set
	 */
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
//Przeciązanie 
	
	@Override
	public String toString() {
		return "Client [login=" + login + ", name=" + name + ", surname=" + surname + ", emailAddress=" + emailAddress
				+ ", password=" + password + ", id=" + id + ", createdDate=" + createdDate + "]";
	}

//
	public double getBalance(String currency) {
		Double amount = balances.get(currency);
		if (amount != null) {
			return amount.doubleValue();
		} else {
			return 0;
		}

	}
// funckjia sprawdza ballans i zmienia go gdy client cos robil
	public double updateBalance(String currency, double deltaAmount) {
		Double oldBalance = balances.get(currency);
		if (oldBalance == null) {
			balances.put(currency, deltaAmount);
			return deltaAmount;
		}
		double newBalance = oldBalance + deltaAmount;

		balances.put(currency, newBalance);
		return newBalance;
	}

}
