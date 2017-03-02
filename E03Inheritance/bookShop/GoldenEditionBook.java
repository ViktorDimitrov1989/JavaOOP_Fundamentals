package E03Inheritance.bookShop;

public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String author, String title, double price){
        super(author,title,price);
    }

    @Override
    protected void setPrice(double price){
        double higherPrice = price + (price * 0.3);
        super.setPrice(higherPrice);
    }

}
