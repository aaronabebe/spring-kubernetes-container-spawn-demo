package at.aaronabebe.kubernetesspawndemo.queue;

import com.rabbitmq.client.impl.MicrometerMetricsCollector;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Autowired
    private MeterRegistry meterRegistry;

    @Bean
    public MicrometerMetricsCollector micrometerMetricsCollector() {
        return new MicrometerMetricsCollector(meterRegistry);
    }
}
