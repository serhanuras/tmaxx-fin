package com.xinerji.tmaxxfinrest;
import com.xinerji.tmaxxfinrest.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xinerji"})
@EnableJpaRepositories("com.xinerji")
@EntityScan("com.xinerji")
public class TmaxxFinRestApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(TmaxxFinRestApplication.class, args);

        ApplicationConfig config =  (ApplicationConfig) context.getBean("applicationConfig");
        System.out.println("Database Name : " + config.getDatabaseConfig().url);
    }

}
