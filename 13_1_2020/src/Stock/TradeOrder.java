package Stock;

import java.util.Date;

public class TradeOrder {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Date positionTime) {
        this.positionTime = positionTime;
    }

    public float getPositionedMoney() {
        return positionedMoney;
    }

    public void setPositionedMoney(float positionedMoney) {
        this.positionedMoney = positionedMoney;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "TradeOrder{" +
                "type='" + type + '\'' +
                ", symbol='" + symbol + '\'' +
                ", positionTime=" + positionTime +
                ", positionedMoney=" + positionedMoney +
                ", quantity=" + quantity +
                ", userName='" + userName + '\'' +
                ", priceUnit=" + priceUnit +
                '}';
    }

    String type;
    String symbol;
    Date positionTime;
    float positionedMoney;
    int quantity;
    String userName;
    float priceUnit;

    public float getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(float priceUnit) {
        this.priceUnit = priceUnit;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public TradeOrder(String type, String symbol, Date positionTime, float positionedMoney, int quantity, String userName) {
        this.type = type;
        this.symbol = symbol;
        this.positionTime = positionTime;
        this.positionedMoney = positionedMoney;
        this.quantity = quantity;
        this.userName = userName;
        this.priceUnit = positionedMoney / (float) quantity;
    }

    public TradeOrder(String type, String symbol, Date positionTime, int quantity, String userName) {
        this.type = type;
        this.symbol = symbol;
        this.positionTime = positionTime;
        this.quantity = quantity;
        this.userName = userName;
        this.priceUnit = positionedMoney / (float) quantity;
    }

    public void ProcessQueue() {
        if (type == "sell") {
            if (!TradingBase.BuyOrders.isEmpty()) {
                TradeOrder buyOrder =  TradingBase.BuyOrders.peek();
                if (buyOrder.priceUnit >= this.priceUnit) {
                    if (buyOrder.quantity > this.quantity) {
                        buyOrder.quantity -= this.quantity;
                        TradingBase.SellOrders.remove();
                        TradingBase.BuyOrders.remove();
                        TradingBase.BuyOrders.add(buyOrder);
                    } else if (buyOrder.quantity < this.quantity) {
                        this.quantity -= buyOrder.quantity;
                        TradingBase.BuyOrders.remove();
                        TradingBase.SellOrders.remove();
                        TradingBase.SellOrders.add(this);
                    } else {
                        TradingBase.BuyOrders.remove();
                        TradingBase.SellOrders.remove();
                    }
                }
            }
        } else if (type == "buy") {
            if (!TradingBase.SellOrders.isEmpty()) {
                TradeOrder sellOrder = TradingBase.SellOrders.peek();
                if (sellOrder.priceUnit <= this.priceUnit) {
                    if (sellOrder.quantity >= this.quantity) {
                        sellOrder.quantity -= this.quantity;
                        TradingBase.BuyOrders.remove();
                        TradingBase.SellOrders.remove();
                        TradingBase.SellOrders.add(sellOrder);
                    } else if (sellOrder.quantity < this.quantity) {
                        this.quantity -= sellOrder.quantity;
                        TradingBase.SellOrders.remove();
                        TradingBase.BuyOrders.remove();
                        TradingBase.BuyOrders.add(this);
                    } else {
                        TradingBase.BuyOrders.remove();
                        TradingBase.SellOrders.remove();
                    }
                }
            }
        }
    }

}
