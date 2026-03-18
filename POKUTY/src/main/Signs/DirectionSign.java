package main.Signs;

import main.Enums.Action;

public class DirectionSign implements TrafficSign {
    private Action allowedDirection;

    public DirectionSign(Action allowedDirection){
        setAllowedDirection(allowedDirection);
    }
    public Action getAllowedDirection(){return allowedDirection;}
    public void setAllowedDirection(Action allowedDirection){
        this.allowedDirection = allowedDirection;
    }
}
