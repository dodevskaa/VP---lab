package mk.finki.ukim.mk.lab_2_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lab2BApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab2BApplication.class, args);
    }

}
