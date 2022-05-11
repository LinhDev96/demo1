package com.example.demo1.database;

import com.example.demo1.Models.Product;
import com.example.demo1.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
docker run -d --rm --name mysql-spring-boot-tutorial \ -d diamond chạy ở chế độ ngầm background --rm tắt container là xoá luôn lần sau tạo lại
        -e MYSQL_ROOT_PASSWORD=123456 \ -e environment variable

        -e MYSQL_USER=linhdev \ user va mật khẩu
        -e MYSQL_PASSWORD=123456 \

        -e MYSQL_DATABASE=test \ tên db
        -p 3309:3306 \ ánh xạ cổng 3309 là Pc 3306 là container ,khi gọi 3309 hiểu laf gọi 3306 của container
        --volume mysql-spring-boot-tutorial-volume:/var/lib/mysql \ volume trên máy tính sẽ đc map với container
        mysql:latest  \ mysql version

        mysql -h localhost -P 3309 --protocol=tcp -u linhdev -p  \connect trong csdl
*/




@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("fedcv",2020,2500,"");
                Product productB = new Product("efvdfeff",2021,250,"");
                logger.info("insert data: " + productRepository.save(productA));
                logger.info("insert data: " + productRepository.save(productB));
            }
        };
    }
}
