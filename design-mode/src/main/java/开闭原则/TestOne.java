package 开闭原则;

public class TestOne {
    public static void main(String[] args) {
        IBook iBook = new OFfNovelBook("book", 46.3, "lyp");

        System.out.println(iBook.getPrice());
        System.out.println(iBook.getName());
        System.out.println(iBook.getAuthor());
    }
}

interface IBook{
    String getName();
    double getPrice();
    String getAuthor();
}

class NovelBook implements IBook{
    private String name;

    private double price;

    private String author;

    public NovelBook(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}

class OFfNovelBook extends NovelBook{

    public OFfNovelBook(String name, double price, String author) {
        super(name, price, author);
    }

    @Override
    public double getPrice() {
        if(super.getPrice() > 40){
            return super.getPrice() * 0.5;
        }else{
            return super.getPrice() * 0.8;
        }

    }
}
