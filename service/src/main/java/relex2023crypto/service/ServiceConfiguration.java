package relex2023crypto.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
        "relex2023crypto.service"
})
@EnableAspectJAutoProxy
public class ServiceConfiguration {
}
