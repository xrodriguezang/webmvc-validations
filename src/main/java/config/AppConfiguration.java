package config;

import model.Empleat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class AppConfiguration {

    @Bean
    Map<UUID, Empleat> empleats() {
        Map<UUID, Empleat> empleats = new HashMap<>();

        Empleat el = new Empleat(UUID.fromString("a5ecfa94-9535-4fb1-889e-aabbf66e9126"), "A1", "fef@fff.com", new BigDecimal(1000));
        Empleat e2 = new Empleat(UUID.fromString("a5ecfa14-9535-4fb1-889e-aabbf66e9126"), "A1", "fef@fff.com", new BigDecimal(1000));
        Empleat e3 = new Empleat(UUID.fromString("a5ecfa24-9535-4fb1-889e-aabbf66e9126"), "A1", "fef@fff.com", new BigDecimal(1000));

        empleats.put(el.getId(), el);
        empleats.put(e2.getId(), e2);
        empleats.put(e3.getId(), e3);

        return empleats;
    }
}
