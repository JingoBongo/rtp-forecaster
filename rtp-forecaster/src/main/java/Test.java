

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.InboundSseEvent;
import javax.ws.rs.sse.SseEventSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    static List<String> ttt = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("hello");
//        List<String> ttt = new ArrayList<>();


        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:4000/iot");

        try (SseEventSource source = SseEventSource
                .target(target)
//                .reconnectingEvery(5, TimeUnit.SECONDS)
                .build()) {
            source.register(inboundSseEvent -> {
                        doMagic(inboundSseEvent);
                    }
            );
            source.open();
            Thread.sleep(10);
        }
//        System.out.println();


//        try (SseEventSource source = SseEventSource.target(target).build()) {
//            source.register((inboundSseEvent) -> System.out.println((String)inboundSseEvent.readData()));
//            source.open();
//
////            String data = inboundSseEvent.readData();
////            System.out.println(data);
////            Stock stock = inboundSseEvent.readData(Stock.class, MediaType.Application_Json);
//        }ttt


    }

    public static void doMagic(InboundSseEvent inboundSseEvent){
        String data = inboundSseEvent.readData();
        System.out.println(data);
        if(data != null)
            Test.ttt.add(data);
    }
}
