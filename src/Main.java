public class Main {
    public static void main(String[] args) {
        BeerHouse bh = new BeerHouse();

        BeerConsumer bc = new BeerConsumer("juan",bh);
        BeerConsumer bc2 = new BeerConsumer("pedro",bh);
        BeerConsumer bc3 = new BeerConsumer("rama",bh);

        BeerProducer bp = new BeerProducer(bh,"productor1");
        BeerProducer bp2 = new BeerProducer(bh,"productor2");

        bp.start();
        bp2.start();

        bc.start();
        bc2.start();
        bc3.start();
    }
}
