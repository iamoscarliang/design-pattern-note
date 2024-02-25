package bridge;

import bridge.remote.AppleRemoteControl;
import bridge.remote.SonyRemoteControl;
import bridge.tv.AppleTV;
import bridge.tv.SonyLCDTV;
import bridge.tv.SonyLEDTV;
import bridge.tv.TV;

public class Main {

    public static void main(String[] args) {
        TV sonyLCDTV = new SonyLCDTV();
        TV sonyLEDTV = new SonyLEDTV();
        TV appleTV = new AppleTV();

        SonyRemoteControl sonyLCDTVRemoteControl = new SonyRemoteControl();
        sonyLCDTVRemoteControl.setTV(sonyLCDTV);

        SonyRemoteControl sonyLEDTVRemoteControl = new SonyRemoteControl();
        sonyLEDTVRemoteControl.setTV(sonyLEDTV);

        AppleRemoteControl appleRemoteControl = new AppleRemoteControl();
        appleRemoteControl.setTV(appleTV);

        sonyLCDTVRemoteControl.setChannel(30);
        sonyLEDTVRemoteControl.setChannel(20);
        sonyLEDTVRemoteControl.nextChannel();

        appleRemoteControl.setChannel(50);
        appleRemoteControl.setChannel(25);
        appleRemoteControl.setChannel(15);
        appleRemoteControl.undoChannel();
        appleRemoteControl.undoChannel();
    }

}
