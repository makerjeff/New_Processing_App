package com.makerjeff.new_processing_app;

import processing.core.*;
import processing.serial.*;
//import processing.video.*;

public class HalloWerld extends PApplet {
	
	//global vars ==========
	public Serial myPort;

	public static void main(String[] args) {
		PApplet.main("com.makerjeff.new_processing_app.HalloWerld");
	}
	
	public void settings(){
		size(800, 400);
	}
	public void setup() {
		smooth();
		frameRate(5.0f);
		background(255,255,255);
		
		//print array to console
		printArray(Serial.list());
				
		fill(50,50,50);
		textAlign(LEFT);
		
		//print serial ports on screen
		for(int i = 0; i < Serial.list().length; i++) {
			text("[" + i + "] " + Serial.list()[i], 10, 20 * i + 20);
		}
		

	}
	public void draw() {
		//connect_the_dots();
		

	}
	
	public void mousePressed() {
		//background(255);
	}
	
	//CUSTOM FUNCTIONS
	public void connect_the_dots() {
		noStroke();
		fill(220,0,0);
		ellipse(mouseX, mouseY, 10, 10);
		fill(120,120,120);
		ellipse(pmouseX, pmouseY, 10,10);
		stroke(120,120,120);
		line(mouseX, mouseY, pmouseX, pmouseY);
	}

}
