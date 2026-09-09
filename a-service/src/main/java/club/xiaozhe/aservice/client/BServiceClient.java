package club.xiaozhe.aservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "b-service")
public interface BServiceClient {
    @GetMapping("/test")
    String test();
}
