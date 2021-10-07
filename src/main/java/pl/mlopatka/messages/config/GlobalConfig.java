package pl.mlopatka.messages.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class GlobalConfig {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
