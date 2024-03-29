/**
 * @author Florian Schulz
 */
package com.getflourish.stt;

import java.io.File;
import ddf.minim.AudioRecorder;
import ddf.minim.Minim;

import processing.core.PApplet;

public class LibTest extends PApplet {
	
	STT stt;
	String dataPath;
	Minim minim;
	
	public void setup () 
	{
		// Init STT automatically starts listening. Check getVolume() and use setThreshold() to fit your enviroment.
		minim = new Minim(this);
		stt = new STT(this, false, minim);
		
		stt.setLanguage("en-IN");
		stt.enableDebug();
		stt.transcribeFile("hindi.wav");
		//stt.enableAutoRecord();
	}
	
	public void draw() 
	{
		background(0);
	}
	
	public void transcribe (String utterance, float confidence) 
	{
		println(utterance);	
	}
	public void keyPressed () {
		stt.begin();
	}
	public void keyReleased () {
		stt.end();
	}
}

