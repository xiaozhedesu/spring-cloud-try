# spring-cloud-try

## 任务

构建一个 Spring Cloud 项目，其中包含 **Gateway + Nacos + OpenFeign + LoadBalancer** 四个技术栈。

部署两个微服务（`a-service` 和 `b-service`），各自提供一个 `/test` 接口。二者可以独立访问，但请求 `a-service` 时，它会通过 OpenFeign 同步调用 `b-service`，形成一个完整的调用链路。

## 版本

- **Spring Boot**: 4.0.6
- **Spring Cloud**: 2025.1.0
- **Spring Cloud Alibaba**: 2025.1.0.0
- **Nacos Server**: 3.1.1 (Docker 部署)
- **JDK**: 17

## 实践历程

1. **创建微服务**：创建两个微服务`a-service`和`b-service`，单独测试接口`/test`。
2. **部署 Nacos**：使用Docker在本机部署Nacos，并配置两个微服务注册到 Nacos。
3. **搭建 Gateway**：新建`gateway`服务，并进行配置，让`gateway`可以访问到两个服务（花时间最多）。
4. **引入 LoadBalancer**：为`gateway`引入`LoadBalancer`依赖，测试`Nacos + LoadBalancer`的服务发现 + 负载均衡方案。
5. **引入 OpenFeign**：修改`a-service`的行为：a的`/test`接口会携带b的`/test`信息，以尝试在项目中引入`OpenFeign`。
6. **验证负载均衡**：在`b-service`中新增`/port`接口，启动两个`b-service`实例，测试`LoadBalancer`的负载均衡功能。
7.  **创建公共模块**：创建 `common-core` 模块，编写静态工具类 `TestUtils.test()`，让 `a-service` 和 `b-service` 分别引入依赖并调用，验证跨模块工具类的编译与运行。

## 关于Gateway

虽然 Nacos 的配置也遇到了一些问题，但真正耗费时间最多的还是 Gateway，感觉更值得记下来。

由于我使用的版本较新，上网搜到的社区答案大多数都是基于Spring Boot 2.x和3.x的结果，这让我在解决配置问题时走了不少弯路。

- `spring-cloud-starter-gateway`无法使用，需要`spring-cloud-starter-gateway-server-webflux`
- 进行配置的时候遇到问题，一开始我用的是`spring.cloud.gateway.router:`，并没起效。后来改为`spring.cloud.gateway.server.webflux.router:`且配置了`spring.main.web-application-type: reactive`后变得正常。
