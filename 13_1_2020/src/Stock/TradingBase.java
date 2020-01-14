package Stock;

import java.util.*;

public class TradingBase {
    public static Map<String, Trader> RegisteredTraders = new TreeMap<String, Trader>();
    public static Set<Trader> LoggedInTraders = new TreeSet<Trader>();
    public static Map<String, Stock> ListedStocks = new HashMap<String, Stock>();
    public static Queue<TradeOrder> SellOrders = new PriorityQueue<TradeOrder>
            (Comparator.comparingDouble(TradeOrder::getPriceUnit));
    public static Queue<TradeOrder> BuyOrders = new PriorityQueue<TradeOrder>
            (Comparator.comparingDouble(TradeOrder::getPriceUnit).reversed());
    public static Queue<Double> testQ = new PriorityQueue<Double>(new Comparator<Double>() {
        @Override
        public int compare(Double t1, Double t2) {
//            return t1 < t2 ? 1 : -1;
            return Double.compare(t2, t1);
        }
    });

    Comparator<TradeOrder> sellOrderCmp = (TradeOrder t1, TradeOrder t2) -> Float.compare(t1.positionedMoney, t2.positionedMoney);
    Comparator<TradeOrder> buyOrderCmp = (TradeOrder t1, TradeOrder t2) -> Float.compare(t2.positionedMoney, t1.positionedMoney);

    public static void main(String[] args) {
        InitBase();
        System.out.println("Cac loai ma chung khoan duoc niem yet");
        for (Map.Entry<String, Stock> entry:ListedStocks.entrySet()) {
            System.out.println("Ma " + entry.getKey() + " cua " + entry.getValue().nameOfStock);
        }
//        while (true) {
//            System.out.println("Nhap lenh buy/sell");
//            System.out.println("1 la buy, 2 la sell");
//            Scanner sc = new Scanner(System.in);
//            int pos = sc.nextInt();
//            System.out.println("Nhap ma chung khoan");
//            String symbol = sc.nextLine();
//            System.out.println("Nhap so luong");
//            int quantity = sc.nextInt();
//
//        }


        RegisteredTraders.get("hoang").setStock("VNP", 80);
        RegisteredTraders.get("thanh").setStock("VNP", 90);
        RegisteredTraders.get("quang").setStock("VNP", 80);

        SetOrder(1,"VNP",150,50, "huy");    // priceUnit 3.0
        SetOrder(1,"VNP",160,43, "huynh");  // priceUnit 3.7
        SetOrder(1,"VNP",155,50, "dan");    // priceUnit 3.1

        SetOrder(2,"VNP", 180, 50,"hoang"); // 3.6
        SetOrder(2,"VNP", 190, 50,"thanh"); // 3.8
        SetOrder(2,"VNP", 200, 50,"quang"); // 4.0
        while(!SellOrders.isEmpty()) {
            System.out.println(SellOrders.remove());
        }
        System.out.println();
        while (!BuyOrders.isEmpty()) {
            System.out.println(BuyOrders.remove());
        }

    }

    public static void SetOrder(int type, String symbol, float positionedMoney, int quantity, String usr) {
        Trader trader = RegisteredTraders.get(usr);
        if (type == 1) {
            TradeOrder to = new TradeOrder("buy", symbol, new Date(), positionedMoney, quantity, usr);
            BuyOrders.add(to);
            if (trader.getBalance() >= positionedMoney)
                RegisteredTraders.get(usr).setBalance(trader.getBalance() - positionedMoney);
            to.ProcessQueue();
        } else if (type == 2) {
            int qtn = trader.getAvailableStock(symbol);
            if (qtn != -1) {
                if (qtn >= quantity) {
                    RegisteredTraders.get(usr).setStock(symbol, qtn - quantity);
                    TradeOrder to = new TradeOrder("sell", symbol, new Date(), positionedMoney,quantity, usr);
                    SellOrders.add(to);
                    to.ProcessQueue();
                }
            } else {
                System.out.println("Tai khoan khong con co phieu " + symbol);
                return;
            }
        }
    }

    public static void InitBase() {
        Trader t1 = new Trader(1, "khai", 100);
        Trader t2 = new Trader(2, "huy", 400);
        Trader t3 = new Trader(3, "huynh", 300);
        Trader t4 = new Trader(4, "dan", 500);
        Trader t5 = new Trader(5, "dat", 80);
        Trader t6 = new Trader(6, "dong", 49);
        Trader t7 = new Trader(7, "toan", 150);
        Trader t8 = new Trader(8, "thanh", 95);
        Trader t9 = new Trader(9, "hoang", 440);
        Trader t10 = new Trader(10, "quang", 390);

        Stock s1 = new Stock(1,"mbbank");
        Stock s2 = new Stock(2,"vingroup");
        Stock s3 = new Stock(3,"achau");
        Stock s4 = new Stock(4,"vietcombank");
        Stock s5 = new Stock(5,"flcgroup");
        Stock s6 = new Stock(6,"vinagame");
        Stock s7 = new Stock(7,"viettel");
        Stock s8 = new Stock(8,"vinaphone");
        Stock s9 = new Stock(9,"mobiphone");
        Stock s10 = new Stock(10,"vietnammobile");

        ListedStocks.put("MB", s1);
        ListedStocks.put("VG", s2);
        ListedStocks.put("AC", s3);
        ListedStocks.put("VCB", s4);
        ListedStocks.put("FLC", s5);
        ListedStocks.put("VNG", s6);
        ListedStocks.put("VT", s7);
        ListedStocks.put("VNP", s8);
        ListedStocks.put("MBP", s9);
        ListedStocks.put("VNM", s10);

        RegisteredTraders.put("khai", t1);
        RegisteredTraders.put("huy" , t2);
        RegisteredTraders.put("huynh", t3);
        RegisteredTraders.put("dan" , t4);
        RegisteredTraders.put("dat" , t5);
        RegisteredTraders.put("dong", t6);
        RegisteredTraders.put("toan", t7);
        RegisteredTraders.put("thanh", t8);
        RegisteredTraders.put("hoang", t9);
        RegisteredTraders.put("quang", t10);

        LoggedInTraders.add(t1);
        LoggedInTraders.add(t2);
        LoggedInTraders.add(t3);
        LoggedInTraders.add(t4);
        LoggedInTraders.add(t5);
    }
}
