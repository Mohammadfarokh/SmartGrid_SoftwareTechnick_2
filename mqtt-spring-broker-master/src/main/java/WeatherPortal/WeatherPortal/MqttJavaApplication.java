package WeatherPortal.WeatherPortal;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;

import WeatherPortal.WeatherPortal.Config.Scheduler;
import WeatherPortal.WeatherPortal.MqttConnection.MqttPublisherImpl;
import WeatherPortal.WeatherPortal.MqttConnection.MqttSubscriberImpl;
import jakarta.websocket.MessageHandler;

@SpringBootApplication
public class MqttJavaApplication extends SpringBootServletInitializer {
	 static Timer timer;
	 static Scheduler s;
	 
	@Autowired
	static MqttSubscriberImpl subscriber;
    @Autowired
    Runnable MessageListener;


    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MqttJavaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MqttJavaApplication.class, args);
        s = new Scheduler();
        subscriber = new MqttSubscriberImpl();
        while(true) {
				subscriber.subscribeMessage("weather");
        }
    }

}