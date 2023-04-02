import java.util.ArrayList;

public class EquipmentManager {
    private static ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    public static void addEquipment(Equipment equipment) throws EquipmentException {
        // Check if equipment already exists in the list
        for (Equipment e : equipmentList) {
            if (e.getName().equalsIgnoreCase(equipment.getName())) {
                // Equipment already exists, so throw an exception
                throw new EquipmentException("Equipment already exists.");
            }
        }

        // Add the equipment to the list
        equipmentList.add(equipment);
    }

    public static void editEquipment(Equipment equipment) throws EquipmentException {
        boolean found = false;
        for (Equipment e : equipmentList) {
            if (e.getName().equalsIgnoreCase(equipment.getName())) {
                e.setQuantity(equipment.getQuantity());
                found = true;
                break;
            }
        }
    
        if (!found) {
            throw new EquipmentException("Equipment not found.");
        }
    }
    
    public static void deleteEquipment(Equipment equipment) throws EquipmentException {
        if (!equipmentList.remove(equipment)) {
            throw new EquipmentException("Equipment not found.");
        }
    }
    

    public static ArrayList<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public static void setEquipmentList(ArrayList<Equipment> equipmentList) {
        EquipmentManager.equipmentList = equipmentList;
    }
}
