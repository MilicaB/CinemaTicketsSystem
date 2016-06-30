package pojo;

public class Hall {
    private String name;
    private int    rows;
    private int    cols;
    private int    freeSeats;

    public Hall() {
    }

    public Hall(String name, int rows, int cols, int freeSeats) {
        this.name = name;
        this.cols = cols;
        this.rows = rows;
        this.freeSeats = freeSeats;
    }

    public Hall(String name, int rows, int cols) {
        this(name, rows, cols, cols * rows);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

}
