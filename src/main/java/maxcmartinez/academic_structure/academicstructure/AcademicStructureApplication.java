package maxcmartinez.academic_structure.academicstructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AcademicStructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicStructureApplication.class, args);
	}

}
