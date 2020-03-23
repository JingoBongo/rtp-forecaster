package Actors;

import Main.ActorSystem;
import Utils.Deserialization.Event;
import Utils.GetSse;
import Utils.MapJson;
import Utils.Process;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ConcurrentLinkedDeque;

public class BasicActor extends Thread {
    public String actorName;
    public volatile ConcurrentLinkedDeque<String> mailbox;
    public Process process;
    public String state;
    public String status;
    public int index;

    public BasicActor(String actorName){
        this.actorName = actorName;
        this.process = new Process(actorName);
        this.mailbox = new ConcurrentLinkedDeque<>();
        this.state = "alive";
        this.status = "ready";
//        this.start();
    }
    public BasicActor getActor(){
        return this;
    }

    public void terminate(int index) throws InterruptedException {
        switch (this.actorName){
            case "getSse":
                ActorSystem.getSse.deleteActor(index);
               break;
            case "map":
                ActorSystem.map.deleteActor(index);
                break;
            case "forecast":
                ActorSystem.forecast.deleteActor(index);
                break;
            case "print":
                ActorSystem.print.deleteActor(index);
                break;
        }
        this.state = "dead";
        this.join();
    }


    public void run(){
        while(this.state.equals("alive")) {
                if (mailbox.size() != 0) {
//                    status = "busy";
                    try {
                        process.process(mailbox.getLast(), index);
                        mailbox.removeLast();
                        if(!this.actorName.equals("getSse"))
                         this.terminate(index);
                    } catch (InterruptedException | JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
        }
    }


}
