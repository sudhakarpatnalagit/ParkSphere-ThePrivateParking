package com.parksphere.daoInterfaces;



import java.util.List;

import com.parksphere.model.ParkingSlot;


public interface ParkingSlotDAO {

    List<ParkingSlot> getAvailableSlots(
            int locationId,
            String vehicleType);

    ParkingSlot getSlotById(int slotId);

    boolean reserveSlot(int slotId);

    boolean releaseSlot(int slotId);

    boolean addSlot(ParkingSlot slot);

    boolean deleteSlot(int slotId);
}