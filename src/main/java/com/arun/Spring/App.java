package com.arun.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arun.Spring.MessagePrinter;
import com.arun.Spring.MessageService;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
public class App 
{
	@Bean
	MessageService mockMessageService(){
		return new MessageService(){
			public String getMessage(){
				return "Hello World from MEssage SErvie";
			}
		};
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
        
        //using Spring-Module.xml
        ApplicationContext contextXml = new ClassPathXmlApplicationContext("Spring-Module.xml");
        HelloWorld helloObj = (HelloWorld)contextXml.getBean("helloBean");
        helloObj.printHello();
        
    }
}
