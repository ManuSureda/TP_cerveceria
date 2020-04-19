import java.util.Random;

public class BeerConsumer extends Thread{
    private String consumerName;
    private BeerHouse beerHouse;

    public BeerConsumer(String consumerName, BeerHouse beerHouse) {
        this.consumerName = consumerName;
        this.beerHouse = beerHouse;
    }


    public String getConsumerName() {
        return consumerName;
    }


    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public BeerHouse getBeerHouse() {
        return beerHouse;
    }

    public void setBeerHouse(BeerHouse beerHouse) {
        this.beerHouse = beerHouse;
    }

    public int random ()
    {
        Random ran = new Random();
        int val = ran.nextInt()%10;

        if (val<0)
        {
            val = val* (-1);
        }
        return val;
    }

    @Override
    public void run() {
        /*try{
            int aux = -1;
            for (int i=0;i<300;i++){
                aux = beerHouse.consume();
                System.out.println("El Consumidor: "+this.getConsumerName()+" consumio la cerveza: "+aux);
                System.out.println("stock: "+beerHouse.getStock().size());
                BeerConsumer.sleep((long)random());
            }
        } catch (InterruptedException e) { }*/

        int aux = -1;
        while (!beerHouse.getStock().isEmpty()){
            aux = beerHouse.consume();
            System.out.println("El Consumidor: "+this.getConsumerName()+" consumio la cerveza: "+aux);
            System.out.println("stock: "+beerHouse.getStock().size());
        }

    }
}
