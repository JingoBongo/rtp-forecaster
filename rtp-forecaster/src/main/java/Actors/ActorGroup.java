package Actors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ActorGroup {
    public String groupName;
    public ConcurrentLinkedDeque<BasicActor> actorList;
    public ConcurrentLinkedDeque<String> actorGroupMailBox;



    public ActorGroup(String name){
        this.groupName = name;
        actorList = new ConcurrentLinkedDeque<>();
        actorGroupMailBox = new ConcurrentLinkedDeque<>();
    }

    public void deleteActor(int index){
        if(index >= this.actorList.size()-1)
            index = this.actorList.size()-1;
        this.actorList.remove(index);
    }

    public void restartAtIndex(int index) throws InterruptedException {
//        this.actorList.get(index).terminate();
//        this.actorList.remove(index);
        this.actorList.getFirst().state = "dead";
        deleteActor(index);
        this.actorList.add(addActor(this.groupName));
        System.out.println(this.groupName+" restarted after PANIC was met.");
        System.out.println();
    }

    public BasicActor addActor(String name){
        return new BasicActor(name);
    }

    public void sendMessage(String message){
            if(this.actorList.isEmpty()){
                this.actorList.add(addActor(this.groupName));
            }
            int ind = 0;
            boolean found = false;

            try {
                for (BasicActor ba : this.actorList) {
                    if (ba.state.equals("alive") && ba.mailbox.isEmpty()) {
                        ind = this.actorList.size()-1;// .indexOf(ba);
                        ba.index = ind;
                        ba.mailbox.add(message);
                        found = true;
//                    ba.mailbox.add(this.actorGroupMailBox.getLast());
//                    this.actorGroupMailBox.;
                        ba.start();
//                        ba.join();
                        continue;
                    }
                }
                if (!found) {
                    this.actorList.add(addActor(this.groupName));
                    ind = this.actorList.size() - 1;
                    this.actorList.getLast().index = this.actorList.size()-1;// .get(ind).index = ind;
                    this.actorList.getLast().mailbox.add(message);// .get(ind).index = ind;
                    this.actorList.getLast().start();// .get(ind).index = ind;
//                    this.actorList.get(ind).mailbox.add(message);
//                    this.actorList.get(ind).start();
//                    this.actorList.get(ind).join();

//            found = true;
                }
            }catch (Exception e ){e.printStackTrace();}
//            if(found)
//            this.actorList.remove(ind);

//            for(BasicActor ba : this.actorList){
//                if(ba.status.equals("dead")){
////                    this.actorList.indexOf(ba)
//                    this.actorList.remove(this.actorList.indexOf(ba));
//                }
//            }
//        }


//
//        if(this.actorList.isEmpty()){
//            this.actorList.add(addActor(groupName));
//        }
//
//        for(BasicActor ba : actorList){
//            if(ba.mailbox.isEmpty() && !"busy".equals(ba.status)) {
//                ba.mailbox.add(message);
//                ba.start();
//                continue;
//            }



        }
    }

