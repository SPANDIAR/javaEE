package com.spandiar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Shape {

	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
	/*	Triangle triangle = new Triangle();
		triangle.setType("Equilateral");
		System.out.print("Type of triangle is " + triangle.getType());*/
		/*BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle) factory.getBean("triangle");*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//context.registerShutdownHook();
		
		Triangle triangle = (Triangle)context.getBean("triangle");
		Circle circle = (Circle) context.getBean("circle");
		Rectangle rectangle = (Rectangle) context.getBean("rectangle");
		
		circle.areaOfCircle();
		circle.circumferenceOfCircle();
		rectangle.areaOfRectangle();
		
		System.out.println("Co-ordinates of the triangle");	
		System.out.println("A: " + triangle.getPointA().getxAxis() + "," + triangle.getPointA().getyAxis());
		System.out.println("B: " + triangle.getPointB().getxAxis() + "," + triangle.getPointB().getyAxis());
		System.out.println("C: " + triangle.getPointC().getxAxis() + "," + triangle.getPointC().getyAxis());
		System.out.println("");
		
		System.out.println("Area of circle is " + circle.getArea());
		System.out.println("Circumference of circle is " + circle.getCircumference());	
		System.out.println("Area of rectangle is " + rectangle.getArea());	
		System.out.println("Name of the rectange is " + rectangle.getName());

	}

}
