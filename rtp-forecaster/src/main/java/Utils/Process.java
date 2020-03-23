package Utils;

import Main.ActorSystem;
import Utils.Deserialization.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.w3c.dom.ls.LSOutput;

public class Process {
    String processName;

    public Process(String processName){
        this.processName = processName;
    }

    public boolean process(String message, int index) throws InterruptedException, JsonProcessingException {
        boolean worked = false;
        switch (this.processName){
            case "getSse":
                if(message.equals("start")) {
                    GetSse.listenSse();
                }

            case "map":
                ;// = new Event();
                Event result = MapJson.mapJson(message);
                if(result != null) {
                    System.out.println();
                    System.out.println(result.toString()); // THIS ONE PRINTS MAPPER
                    String forecastTemplate = Forecaster.doMoneyMagic(result, "1st location");
                    String forecastTemplate2 = Forecaster.doMoneyMagic(result, "2nd location");
                      ActorSystem.forecast.sendMessage(forecastTemplate);
                      ActorSystem.forecast.sendMessage(forecastTemplate2);
//                    System.out.println();
                }else{
                    System.out.println("It failed greatly");
                    ActorSystem.restartActor(this.processName,index);
                }
                break;
            case "forecast":
                    String tempForecast = Forecaster.undoMoneyMagic(message);
                    ActorSystem.print.sendMessage(tempForecast);
                break;
            case "print":
                System.out.println(message);
                break;
        }
        return worked;
    }


}
