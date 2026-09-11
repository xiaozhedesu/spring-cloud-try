package club.xiaozhe.bservice.controller;

import club.xiaozhe.common.core.utils.TestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/test")
    public String test() {
        log.info("这是一个info日志，用来记录b-service的/test接口被调用了。");
        log.debug("这是一个debug日志，用来记录b-service的/test接口被调用了。");
        return TestUtils.test() + "\nCiallo! by B-service";
    }

    @GetMapping("/port")
    public int port() {
        return port;
    }
}
