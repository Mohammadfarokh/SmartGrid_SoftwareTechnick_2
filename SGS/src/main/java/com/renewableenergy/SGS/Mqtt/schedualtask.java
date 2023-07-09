package com.renewableenergy.SGS.Mqtt;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

public class schedualtask {
	@Autowired
    MqttPublisherImpl publisher;
	    Timer timer;
	    public schedualtask(long seconds) {
	        timer = new Timer();
	        timer.schedule(new RemindTask(), seconds*1000);
	    }

	   

	    class RemindTask extends TimerTask {
	        public void run() {
	            System.out.format("Time's up!%n");
	            publisher.publishMessage("weather", "hello weather");
	            timer.cancel(); //Terminate the timer thread
	        }
	    }



	    
}
