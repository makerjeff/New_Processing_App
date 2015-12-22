package com.makerjeff.new_processing_app;

import processing.core.*;
import processing.serial.*;
//import processing.video.*;

// CLASS DEFINITION =====================
public class HalloWerld extends PApplet {
	
	//global vars ==========
	public Serial myPort;
	float xPos = 0.0f;
	float yPos = 0.0f;
	float lineWidth = 2f;
	float refresh = 30f;
	int appWidth = 1920;
	int appHeight = 400;

	// JAVA PROCESSING BOILER ====================
	public static void main(String[] args) {
		PApplet.main("com.makerjeff.new_processing_app.HalloWerld");
	}
	
	// SETTINGS ======================
	public void settings(){
		size(appWidth, appHeight);
	}
	
	// SETUP ====================
	public void setup() {
		
		smooth();
		frameRate(refresh);
		background(255,210,0);
		
		//setup text styles
		fill(0,0,0);
		textSize(16);
		textAlign(LEFT);
		
		//setup line styles
		stroke(255, 230,0);
		
		//spit out info to terminal + screen
		debugSerial();

		//setup serial port objects
		String portName = Serial.list()[5];	// dev/tty.usbmodem1a1321
		myPort = new Serial(this, portName, 9600);
		

	}
	// DRAW =======================
	public void draw() {
		//connect_the_dots();
		//stroke(255,230,0);
		strokeWeight(lineWidth);
		strokeCap(SQUARE);
		line(xPos, height, xPos, yPos);
		
		//if line reaches end
		if (xPos >= width) {
			xPos = 0;	//reset back to beginning
			background(255,210,0); //clear frame
			//randomize colors for the next pass
			stroke(round(random(0,255)), round(random(0,255)), round(random(0,255)));
		}
		else{
			xPos = xPos + lineWidth;
		}
	}
	
	// MOUSEPRESSED <event> ===================
	public void mousePressed() {
		//background(255);
	}
	
	// SERIAL EVENT <event> ===================
	public void serialEvent(Serial myPort) {
		//grab a byte
		int inByte = myPort.read();
		//print the byte
		println(inByte);
		
		yPos = height - inByte;	//determine line height
	}
	
	//CUSTOM FUNCTIONS ===================
	
	//print stuff to screen + console
	public void debugSerial(){
		//print array to console
		printArray(Serial.list());
		
		//print serial ports on screen
		for(int i = 0; i < Serial.list().length; i++) {
			text("[" + i + "] " + Serial.list()[i], 10, 20 * i + 20);
		}
	} 

}
