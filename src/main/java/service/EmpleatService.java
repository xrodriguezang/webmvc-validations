package service;

import exceptions.ElementNotFoundException;
import lombok.extern.slf4j.Slf4j;
import model.Empleat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class EmpleatService implements IEmpleatService {

    @Autowired
    Map<UUID, Empleat> empleats;

    @Override
    public List<Empleat> findAll() {
        return empleats.values().stream().toList();
    }

    @Override
    public Empleat create(Empleat emp) {
        emp.setId(UUID.randomUUID());

        empleats.put(emp.getId(), emp);

        return emp;
    }

    @Override
    public Empleat findById(UUID id) {
        Empleat empleat = empleats.get(id);

        if (empleat==null) {
            throw new ElementNotFoundException("Empleat inexistent");
        }

        return empleat;
    }

}
