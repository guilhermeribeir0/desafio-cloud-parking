package me.guilhermeribeiro.cloudparking.service;

import me.guilhermeribeiro.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = getUUID();
        var id_two = getUUID();
        Parking parking = new Parking(id, "DGH-2456", "PB", "VW GOL", "CINZA");
        Parking parking_two = new Parking(id_two, "FGJ-6238", "PE", "GM ONIX", "BRANCO");
        parkingMap.put(id, parking);
        parkingMap.put(id_two, parking_two);
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }


    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }
}
