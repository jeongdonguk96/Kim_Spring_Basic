package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = context.getBean(NetworkClient.class);
        context.close();
    }

    @Configuration
    static class LifeCycleConfig {
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://www.gogo.com");
            return networkClient;
        }
    }
}
