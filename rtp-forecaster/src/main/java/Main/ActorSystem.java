package Main;

import Actors.ActorGroup;
import Utils.Deserialization.Event;
import Utils.GetSse;
import Utils.MapJson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class ActorSystem {
    public static ActorGroup getSse = new ActorGroup("getSse");
    public static ActorGroup map = new ActorGroup("map");
    public static ActorGroup forecast = new ActorGroup("forecast");
    public static ActorGroup print = new ActorGroup("print");

    public static void main(String[] args) throws InterruptedException {
        int pauseTime = 1;

//        ActorGroup getSse = new ActorGroup("getSse");
//        ActorGroup map = new ActorGroup("map");
//        ActorGroup forecast = new ActorGroup("forecast");
//        ActorGroup print = new ActorGroup("print");

        getSse.sendMessage("start");

//        ConcurrentLinkedDeque<String> currentList = new ConcurrentLinkedDeque<>();
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:4000/iot");
//
//        try (SseEventSource source = SseEventSource
//                .target(target)
//                .reconnectingEvery(5, TimeUnit.SECONDS)
//                .build()) {
//            source.register(inboundSseEvent -> {
//                        String data = inboundSseEvent.readData();
//                        if(data != null && currentList.size()==0)
////                            currentList.add(data);
//                            print.sendMessage(data);
//                        try {
//                            Thread.sleep(2000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//            );
//            source.open();
////            Thread.sleep(10);
//            while(true){}
//        }


//        while(true) {
//            getSse.sendMessage("start");
//            Thread.sleep(pauseTime*1000);
//        }
    }

    public static void doPrint(String data){
        print.sendMessage(data);
    }

    public static void doMap(String data){
        map.sendMessage(data);
    }

    public static void restartActor(String actorName, int index) throws InterruptedException {
        switch (actorName){
            case "getSse":
                getSse.restartAtIndex(index);
               break;
            case "map":
                map.restartAtIndex(index);
                break;
            case "forecast":
                forecast.restartAtIndex(index);
                break;
            case "print":
                print.restartAtIndex(index);
                break;
        }
    }


}
