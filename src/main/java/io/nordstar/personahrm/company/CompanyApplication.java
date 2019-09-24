package io.nordstar.personahrm.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CompanyApplication {
//public class CompanyApplication extends SpringBootServletInitializer {

    public static void main ( String[] args ) {
        SpringApplication.run ( CompanyApplication.class, args );
    }

}
