package com.spandiar.spring;

import org.springframework.beans.factory.DisposableBean;

public class Rectangle implements DisposableBean{
	
	private double length;
	private double width;
	private double area;
	private String name;

	public Rectangle() {
		
	}
	
	public Rectangle(double len, double width, String name) {
		this.length = len;
		this.width = width;
		this.name = name;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}
	
	public double getArea() {
		return area;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void areaOfRectangle() {
		area = length * width;
	}

	public void destroy() throws Exception {
	
		System.out.println("Inside the disposableBean method of the Rectangle class");
		
	}
}
