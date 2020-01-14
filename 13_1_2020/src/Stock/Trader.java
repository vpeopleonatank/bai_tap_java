package Stock;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Trader implements Comparable<Trader> {
    public Trader(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getAvailableStock(String symbol) {
        if (holdingStocks.containsKey(symbol)) {
            return holdingStocks.get(symbol);
        }
        return -1;
    }
    public void setStock(String symbol, int quantity) {
        if (holdingStocks.containsKey(symbol)) {
            holdingStocks.replace(symbol, quantity);
        } else {
            holdingStocks.put(symbol, quantity);
        }
    }


    public Trader(int id, String userName, float balance) {
        this.id = id;
        this.userName = userName;
        this.balance = balance;
        mailBox = new LinkedList<String>();
        holdingStocks = new TreeMap<>();
    }

    int id;
    String userName;
    float balance;
    Queue<String> mailBox;
    Map<String, Integer> holdingStocks;

    @Override
    public int compareTo(Trader trader) {
        return userName.compareTo(trader.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
}
