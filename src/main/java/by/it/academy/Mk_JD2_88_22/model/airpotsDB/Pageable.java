package by.it.academy.Mk_JD2_88_22.model.airpotsDB;

public class Pageable {
    private int page;
    private int size;

    public Pageable() {
    }

    public Pageable(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
