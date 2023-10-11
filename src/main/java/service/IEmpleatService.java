package service;

import model.Empleat;

import java.util.List;
import java.util.UUID;

public interface IEmpleatService {

    List<Empleat> findAll();

    Empleat create (Empleat emp);

    Empleat findById (UUID id);
}
