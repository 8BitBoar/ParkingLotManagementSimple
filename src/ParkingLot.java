import customExceptions.NoSlotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingLot {

    String parkingLotId;
    List<List<Slot>> slots;

    public ParkingLot (String parkingLotId, int nfloors, int noOfSlotsPerFlr) {
        this.parkingLotId = parkingLotId;
        for (int i = 0; i < nfloors; i++) {
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bike"));
            floorSlots.add(new Slot("bike"));

            for (int j = 3; j < noOfSlotsPerFlr ;j++) {
                slots.get(i).add(new Slot("car"));
            }

        }
    }

    public String parkVehicle(String type, String regNo, String color) throws NoSlotAvailableException {
        Vehicle vehicle = new Vehicle(type, regNo, color);

        for (int i = 0; i<slots.size() ;i++) {
            for (int j = 0; i<slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (Objects.equals(slot.type, type) && slot.vehicle==null) {
                    slot.vehicle = vehicle;
                    slot.ticketId=generateTicketId(i+1,j+1);
                    return slot.ticketId;
                }
            }
        }

        throw new NoSlotAvailableException("No slot available for given type");
    }


    public void unPark(String ticketId) {

    }

    public int getNoOfOpenSlots(String type) {
        return 0;
    }

    public void displayOpenSlots(String type) {

    }

    public void displayOccupiedSlots(String type) {

    }


    // private methods

    private String generateTicketId(int flr, int slNo) {
        return parkingLotId + "_" + flr + "_" + slNo;
    }
}
