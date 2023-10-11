package rest;

import model.Empleat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.IEmpleatService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")  // Es defineix un path en comú. Un root-path
public class EmpleatRestController {

    @Autowired
    IEmpleatService empleatService;

    @GetMapping(path = "/empleats")
    public List<Empleat> findAllByEmpleats() {
        return (empleatService.findAll());
    }

    @GetMapping(path = "/empleats/{idEmpleat}")
    public Empleat findEmpleatById(@PathVariable UUID idEmpleat) {
        return (empleatService.findById(idEmpleat));
    }

/*
    @PostMapping(path = "/empleats")
    public Empleat createEmpleat (@RequestBody Empleat empleat) {
        return (empleatService.create(empleat));
    }
*/

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/empleats", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Empleat createEmpleat (@Validated @RequestBody Empleat empleat) {
        return (empleatService.create(empleat));
    }
}
