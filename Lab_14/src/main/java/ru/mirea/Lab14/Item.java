package ru.mirea.Lab14;

public class Item {
    private String name;
    private String creationDate;
    private int price;

    public Item(String name, String creationDate, int price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Item) obj).getName()) &&
                this.creationDate.equals(((Item) obj).getCreationDate()) &&
                this.price == ((Item) obj).getPrice();
    }
}
