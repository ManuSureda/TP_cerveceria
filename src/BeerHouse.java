import java.util.ArrayList;

public class BeerHouse {
    private ArrayList<Integer> stock;
    private final int MAX_CAPACITY = 100;
    private static int beerNumber = 0;

    public BeerHouse() {
        this.stock = new ArrayList<>();
    }

    public ArrayList<Integer> getStock() { return stock; }

    public void setStock(ArrayList<Integer> stock) { this.stock = stock; }

    public synchronized int produce(){
        while(stock.size() == MAX_CAPACITY){
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {}
        }
        int ans = beerNumber;
        stock.add(beerNumber);
        ++beerNumber;//es nada mas para diferenciar las beer
        notifyAll();
        return ans;
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public static int getBeerNumber() {
        return beerNumber;
    }

    public static void setBeerNumber(int beerNumber) {
        BeerHouse.beerNumber = beerNumber;
    }

    public synchronized int consume(){

        while(stock.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e)
            {}
        }
        int ans = stock.get(stock.size()-1);
        stock.remove(stock.size()-1);
        notifyAll();
        return ans;
    }
}
