package at.aaronabebe.kubernetesspawndemo;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.util.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class KubernetesSpawnDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubernetesSpawnDemoApplication.class, args);
	}

	@Bean
	public CoreV1Api coreV1Api() throws IOException {
		ApiClient client = Config.defaultClient();
		Configuration.setDefaultApiClient(client);
		return new CoreV1Api();
	}

}
