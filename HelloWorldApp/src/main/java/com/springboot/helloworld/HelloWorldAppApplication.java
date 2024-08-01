package com.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldAppApplication {

	/*
	 * @SpringBootApplication ==> Bootstrap class ===> Starting point of Execution
	 *
	 * Every Project should have only one bootstrap class
	 *
	 *
	 *Task1:
	 *It will create IOC Container ==> Inversion of Control Container
	 *
	 *IOC ==> Efficient Memory Management ==> IOC with DI
	 *					==> OrderService orderService=new OrderSerice(); //Normal java Code
	 *					==> OrderService ordserService=IOC.getOrderService() //Spring approach
	 *
	 *
	 *Task2:
	 * By default all java classes created in side our project ==> All classes will be pushed to
	 * IOC Container
	 *
	 *
	 *Task3:
	 *Component Scan:By default all java classes created in boot strap package and bootstrap subpackage
	 *are scanned by spring boot and they will be pushed to IOC Container.
	 *
	 *But if we want to override above definition ==> we can use one annotation  @ComponentScan
	 *@ComponentScan("com.*") ==> This annotation will scan all java files which are created under com.* package
	 *and com.* subpackage and it will push all those classes to IOC container.
	 *
	 *By default @Componentscan will have @Componentscan("boostrappackage.*");
	 *
	 *
	 *Task4:
	 *
	 *EnableAutoConfiguration: Bootstrap class identify all the jars inside class path and it will check which can
	 *be automatically started on their own and which can be configured on their own ==> It will run those sections
	 *
	 *Tomcat is running on their own   ==>automatically started on their own
	 *	In Memroy Database             ==>automatically started on their own
	 *
	 *DispatcherServletConfiguration & DataSource & FrontController
	 *									==>All our controllers are registered to ApplicationContext , so that these
	 *											controller will be loaded when we invoke an API
	 *
	 *In general, @SpringBootApplication ==> @Configuration + @ComponentScan + @EnableAutoConfiguration
	 *   @Configuration ==> Spring Behaviour like @Bean,@Component etc.
	 *   @ComponentScan ==> Scanning all Java classes and pushes them to IOC Container
	 *   @EnableAutoConfiguration ==> Automatically run and configuraition which are availale in bootstrap class.
	 *
	 *
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  We need to create Web Application Context ==> Entire our programe will be avaiable for execution
		 *
		 *    <bean class="com.nareshit.orderservice" id="orderservice"></bean> ==>spring.xml
		 *
		 *    ApplicationContext context=new WebApplicationContext("spring.xml");
		 *
		 *    SpringApplication.run ==> Willl create Web ApplicationContext
		 *    HelloWorldApplication.class ==>It will scan all java classes inside bootstrap class package
		 *                                     and bootstrap class subpackages
		 *
		 *                                     ==> These classes will be pushed to IOC Container
		 *
		 *
		 *           com.amazon.orderprocessing ==> main package
		 *                                      ==>  com.amazon.orderprocessing.product
		 *                                      ==>  com.amazon.orderprocessing.customer
		 *                                      ==>  com.amazon.orderprocessing.inventory
		 *                                      ==>  com.amazon.orderprocessing.cart
		 *                                      ==>  com.amazon.orderprocessing.payment
		 *                                      ==>  com.amazon.orderprocessing.discount
		 *                                      ==>  com.amazon.orderprocessing.shipping
		 *                                      ==>  com.amazon.orderprocessing.return
		 *
		 */
		SpringApplication.run(HelloWorldAppApplication.class, args);
	}

}
