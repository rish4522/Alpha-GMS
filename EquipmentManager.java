public class EquipmentManager {
    private static ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    public static void addEquipment(Equipment equipment) throws EquipmentException {
        // Check if the equipment with same equipment ID already exists
        for (Equipment existingEquipment : equipmentList) {
            if (existingEquipment.getEquipmentId().equals(equipment.getEquipmentId())) {
                throw new EquipmentException("Equipment with ID " + equipment.getEquipmentId() + " already exists");
            }
        }

        equipmentList.add(equipment);
    }

    public static Equipment getEquipmentById(String equipmentId) throws EquipmentException {
        for (Equipment equipment : equipmentList) {
            if (equipment.getEquipmentId().equals(equipmentId)) {
                return equipment;
            }
        }

        throw new EquipmentException("Equipment with ID " + equipmentId + " not found");
    }

    public static void updateEquipment(Equipment equipment) throws EquipmentException {
        boolean found = false;

        // Find the equipment with the same equipment ID and update its details
        for (int i = 0; i < equipmentList.size(); i++) {
            if (equipmentList.get(i).getEquipmentId().equals(equipment.getEquipmentId())) {
                equipmentList.set(i, equipment);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new EquipmentException("Equipment with ID " + equipment.getEquipmentId() + " not found");
        }
    }

    public static boolean deleteEquipment(String equipmentId) throws EquipmentException {
        boolean found = false;

        // Find the equipment with the same equipment ID and remove it from the list
        for (int i = 0; i < equipmentList.size(); i++) {
            if (equipmentList.get(i).getEquipmentId().equals(equipmentId)) {
                equipmentList.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new EquipmentException("Equipment with ID " + equipmentId + " not found");
        }

        return true;
    }
}