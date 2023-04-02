

public class Equipment {
    private String name;
    private int quantity;

    public Equipment(String name,int quantity) {
        
        this.name = name;
      
        this.quantity = quantity;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}