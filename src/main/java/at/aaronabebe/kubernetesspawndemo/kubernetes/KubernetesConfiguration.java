package at.aaronabebe.kubernetesspawndemo.kubernetes;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class KubernetesConfiguration {

    @Bean
    public CoreV1Api coreV1Api() throws IOException {
        ApiClient client = Config.defaultClient();
        io.kubernetes.client.Configuration.setDefaultApiClient(client);
        return new CoreV1Api();
    }
}
