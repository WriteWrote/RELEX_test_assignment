package relex2023crypto.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "relex2023crypto.rest.api"
})
public class RestConfiguration {
}
