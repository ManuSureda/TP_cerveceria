import java.util.Random;

public class BeerProducer extends Thread{
    private BeerHouse beerHouse;
    private String producerName;
    private static int beerNumber = 0;

    public BeerProducer(BeerHouse beerHouse, String producerName) {
        this.beerHouse = beerHouse;
        this.producerName = producerName;
    }

    public BeerHouse getBeerHouse() { return beerHouse; }

    public void setBeerHouse(BeerHouse beerHouse) { this.beerHouse = beerHouse; }

    public String getProducerName() { return producerName; }

    public void setProducerName(String producerName) { this.producerName = producerName; }

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
        try
        {
            for (int i=0;i<25;i++){
                beerHouse.produce(beerNumber);
                System.out.println("El productor: "+this.getProducerName()+" produjo la cerveza: "+beerNumber);
                beerNumber++;
                BeerProducer.sleep((long)random());
            }
        }catch (InterruptedException e)
        {
        }
    }
}
