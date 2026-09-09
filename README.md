# spring-cloud-try

## 任务

构建一个Spring Cloud项目，其中包含 Gateway + Nacos + OpenFeign + LoadBalancer 四个技术栈。

其中部署两个服务，分别叫A和B，包含一个`test`API。二者可以单独被请求，不过对A进行请求时，A也对B进行请求。