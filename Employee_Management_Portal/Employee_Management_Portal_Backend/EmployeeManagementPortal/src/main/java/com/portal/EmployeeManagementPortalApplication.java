package com.portal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
}

