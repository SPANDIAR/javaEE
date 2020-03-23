package com.spandiar.spring;

public class Circle {
	
	private static final double PI=3.14;
	private int radius;
	private double circumference;
	private double area;

	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getCircumference() {
		return circumference;
	}

	public double getArea() {
		return area;
	}
	
	public void areaOfCircle() {
	this.area = (PI * radius * radius);
	}
	
	public void circumferenceOfCircle() {
		this.circumference = (2 * PI * radius);
	}
	
	public void initCircle() {
		System.out.println("Inside the Init method of the Circle class");
	}
	
	public void destroyCircle() {
		System.out.println("Inside the destroy method of the Circle class");
	}

}
