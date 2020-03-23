package Utils;

import Main.ActorSystem;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class GetSse {

    public static void listenSse(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:4000/iot");

        SseEventSource source = SseEventSource
                .target(target)
                .reconnectingEvery(5, TimeUnit.SECONDS)
                .build();
        source.register(inboundSseEvent -> {
                    String data = inboundSseEvent.readData();
                    if (data != null) {
//                        Main.doPrint(data);
//                        System.out.println(data);
                        ActorSystem.doMap(data);
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        source.open();
        while (true) {
        }
    }


    public static String getSse() throws InterruptedException {
        ConcurrentLinkedDeque<String> currentList = new ConcurrentLinkedDeque<>();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:4000/iot");

        try (SseEventSource source = SseEventSource
                .target(target)
//                .reconnectingEvery(5, TimeUnit.SECONDS)
                .build()) {
            source.register(inboundSseEvent -> {
                        String data = inboundSseEvent.readData();
                        if(data != null && currentList.size()==0)
                        currentList.add(data);
                    }
            );
            source.open();
//            Thread.sleep(10);
            while(true){}
        }

//        return currentList.getLast();
    }
}
