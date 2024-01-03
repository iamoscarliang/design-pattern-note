package command;

import command.device.Fan;
import command.device.Light;
import command.control.*;

public class Main {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        Fan ceilingFan = new Fan("Ceiling");

        FanOffCommand ceilingFanOff = new FanOffCommand(ceilingFan);
        FanLowCommand ceilingFanLow = new FanLowCommand(ceilingFan);
        FanMediumCommand ceilingFanMedium = new FanMediumCommand(ceilingFan);
        FanHighCommand ceilingFanHigh = new FanHighCommand(ceilingFan);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanLow, ceilingFanOff);
        remoteControl.setCommand(3, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(4, ceilingFanHigh, ceilingFanOff);

        Command[] partyOn = {livingRoomLightOn, ceilingFanHigh};
        Command[] partyOff = {livingRoomLightOff, ceilingFanOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommand(5, partyOnMacro, partyOffMacro);

        System.out.println(remoteControl);

        System.out.println();

        System.out.println("----- Living Room Light -----");
        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);

        System.out.println("----- Kitchen Light -----");
        remoteControl.onButtonPressed(1);
        remoteControl.offButtonPressed(1);
        remoteControl.undoButtonPressed();

        System.out.println("----- Ceiling Fan -----");
        remoteControl.onButtonPressed(2);
        remoteControl.offButtonPressed(2);
        remoteControl.undoButtonPressed();
        remoteControl.onButtonPressed(3);
        remoteControl.undoButtonPressed();

        System.out.println("----- Party Marco -----");
        remoteControl.onButtonPressed(5);
        remoteControl.offButtonPressed(5);
    }

}
