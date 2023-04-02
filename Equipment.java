public class Equipment {
    private String equipmentId;
    private String name;
    private String description;
    private int quantity;

    public Equipment(String equipmentId, String name, String description, int quantity) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}