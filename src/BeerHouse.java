import java.util.ArrayList;

public class BeerHouse {
    private ArrayList<Integer> stock;
    private static int beer;

    public BeerHouse() {
        this.stock = new ArrayList<>();
    }

    public ArrayList<Integer> getStock() { return stock; }

    public void setStock(ArrayList<Integer> stock) { this.stock = stock; }

    public synchronized void produce(int beerNumber){
        while(stock.size()>15){//tiene una capacidad maxima de 100 cervezas pero le puse 15 para probar
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {}
        }
        stock.add(beerNumber);
        notifyAll();
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
