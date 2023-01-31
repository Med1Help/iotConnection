package Iot.project.iotconnection.configuration;

import Iot.project.iotconnection.models.HutempTopic;
import Iot.project.iotconnection.models.Links;
import Iot.project.iotconnection.repositories.LinksRepo;
import Iot.project.iotconnection.service.FcmService;
import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class MqttConfiguration {
    private LinksRepo repo;
    @Autowired
    FcmService fcmService;

    public MqttConfiguration(LinksRepo repo) {
        this.repo = repo;
    }

    public MqttPahoClientFactory mqttClientFactory(){
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{"tcp://localhost:1883"});
        options.setCleanSession(true);
        factory.setConnectionOptions(options);
        return factory;
    }
    @Bean
    public MessageChannel mqttMsgChannel(){
        return new DirectChannel();
    }
    @Bean
    public MessageProducer mqttMsgProd(){
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("serverIn",mqttClientFactory(),"#");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttMsgChannel());
        return adapter;
    }
    @Bean
    @ServiceActivator(inputChannel = "mqttMsgChannel")
    public MessageHandler handler(){
        return new MessageHandler() {
            @SneakyThrows
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
               String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
               Links link = (Links) repo.findLinksBytopic(topic).get(0);
               String humidity="8",temperature="9";
                try{
                    String[] arrOfStr = message.getPayload().toString().split(" : ", 4);
                    humidity = arrOfStr[3];
                    temperature = arrOfStr[1];
                }catch(Exception e){
                    System.out.println(e);
                }
                HutempTopic note = new HutempTopic(humidity,temperature,topic.toString());
                fcmService.sendNoti(note, link.getToken());

               //setup firebase server to send notification to user's token
               System.out.println("humidity : "+humidity+" temperature : "+temperature+" from topic : "+topic+" after that test we will send it to "+link.getToken());

            }
        };
    }
    @Bean
    public MessageChannel mqttOutboundChannel(){
        return new DirectChannel();
    }
    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler outBound(){
        MqttPahoMessageHandler msgHandler = new MqttPahoMessageHandler("serverOut",mqttClientFactory());
        msgHandler.setAsync(true);
        msgHandler.setDefaultTopic("#");
        return msgHandler;
    }
}
