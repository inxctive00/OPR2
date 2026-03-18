package main.Signs;
import main.Enums.Action;

public class ProhibitionSign implements TrafficSign {
    private Action forbiddenAction;

    public ProhibitionSign(Action forbiddenAction){
        setForbiddenAction(forbiddenAction);
    }
    public Action getForbiddenAction(){return forbiddenAction;}
    public void setForbiddenAction(Action forbiddenAction){
       this.forbiddenAction = forbiddenAction;
    }

}
