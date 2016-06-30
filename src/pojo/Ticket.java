package pojo;

public class Ticket {
    private String movieName;
    private double price;
    private String userName;
    private int    row;
    private int    col;

    public Ticket() {
    }

    public Ticket(String movieName, double price, String userName, int row, int col) {
        this.movieName = movieName;
        this.price = price;
        this.userName = userName;
        this.row = row;
        this.col = col;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

}
