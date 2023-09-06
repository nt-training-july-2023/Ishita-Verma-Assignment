package com.portal;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 *@Target(value={TYPE})
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan.
 */
@SpringBootApplication
public class EmployeeManagementPortalApplication {

/**
*Entry point of the program.
*@param args The command-line arguments passed to the program.
*/
final public static void main(final String[] args) {
     SpringApplication.run(EmployeeManagementPortalApplication.class, args);
}
/**.
 * model mapper method
 * @return instance of model mapper
 */
@Bean
public ModelMapper dtoToEntityMapper() {
    return new ModelMapper();
}

@Bean
public ModelMapper entityToDtoMapper() {
    return new ModelMapper();
}
@Bean
public ModelMapper modelMapper() {
    return new ModelMapper();
}
}

