package club.xiaozhe.aservice.controller;

import club.xiaozhe.aservice.client.BServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final BServiceClient bServiceClient;

    @GetMapping("/test")
    public String test() {
        return "Hello, World! by A-service\n" + bServiceClient.test();
    }
}
