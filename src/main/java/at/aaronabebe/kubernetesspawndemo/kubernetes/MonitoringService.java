package at.aaronabebe.kubernetesspawndemo.kubernetes;

import com.rabbitmq.client.impl.MicrometerMetricsCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    @Autowired
    private MicrometerMetricsCollector micrometerMetricsCollector;

    public long getNumberOfConnections() {
        System.out.println("Getting number of channels...");
        return micrometerMetricsCollector.getConnections().get();
    }
}
