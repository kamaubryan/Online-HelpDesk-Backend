package Online.Help.Desk.Model;

public enum Stage {

    OPEN("Open"),
    ASSIGNED("Assigned"),
    WORKING("Working"),
    HOLD("On Hold"),
    PENDING_INPUT("Pending Input"),
    CLOSED("Closed");


    private final String name;

    Stage (String name){
        this.name = name;
    }


    private String getName(){
        return name;
    }

}
