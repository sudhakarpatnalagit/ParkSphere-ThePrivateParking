package com.parksphere.daoInterfaces;


import java.util.List;

import com.parksphere.model.Location;

public interface LocationDAO {

    boolean addLocation(Location location);

    boolean updateLocation(Location location);

    boolean deleteLocation(int locationId);

    Location getLocationById(int locationId);

    List<Location> getAllLocations();
}
