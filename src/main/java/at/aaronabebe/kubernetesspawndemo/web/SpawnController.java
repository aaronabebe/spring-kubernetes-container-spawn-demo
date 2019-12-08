package at.aaronabebe.kubernetesspawndemo.web;

import at.aaronabebe.kubernetesspawndemo.service.SpawningService;
import io.kubernetes.client.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpawnController {


    @Autowired
    private SpawningService spawningService;

    @PostMapping("/pods/{podName}/{containerName}/{imageTag}")
    public void spawnContainer(@PathVariable String podName,
                               @PathVariable String containerName,
                               @PathVariable String imageTag) throws ApiException {
        try {
            spawningService.spawnWorker(podName, containerName, imageTag);
        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
            throw e;
        }
    }

    @GetMapping("/pods/names")
    public List<String> getPodNames() throws ApiException {
        try {
            return spawningService.getPodNames();
        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
            throw e;
        }
    }
}
