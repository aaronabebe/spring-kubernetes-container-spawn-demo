package at.aaronabebe.kubernetesspawndemo.service;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpawningService {

    @Autowired
    private CoreV1Api coreV1Api;

    public void spawnWorker(String podName, String containerName, String imageTag) throws ApiException {
        System.out.println(String.format("Spawning pod with name %s from image %s", podName, imageTag));
        V1Pod v1Pod = new V1PodBuilder()
                .withNewMetadata()
                .withName(podName)
                .endMetadata()
                .withNewSpec()
                .addNewContainer()
                .withName(containerName)
                .withImage(imageTag)
                .endContainer()
                .endSpec()
                .build();
        coreV1Api.createNamespacedPod("default", v1Pod, null, null, null);
    }

    public List<String> getPodNames() throws ApiException {
        System.out.println("Getting pod names...");
        return coreV1Api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null)
                .getItems().stream()
                .map(item -> item.getMetadata().getName())
                .collect(Collectors.toList());
    }

}
