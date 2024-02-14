package ioevent.samples.ioeventuserTask;

import com.ioevent.ioeventusertaskhandlerstarter.annotation.EnableIOEventUserTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableIOEventUserTask
public class IoeventUserTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoeventUserTaskApplication.class, args);
	}

}
