package command;

import command.control.Command;
import command.control.NoCommand;

public class RemoteControl {

    private Command mUndoCommand;

    private Command[] mOnCommands = new Command[7];
    private Command[] mOffCommands = new Command[7];

    public RemoteControl() {
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            mOnCommands[i] = noCommand;
            mOffCommands[i] = noCommand;
        }
        mUndoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        mOnCommands[slot] = onCommand;
        mOffCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        mOnCommands[slot].execute();
        mUndoCommand = mOnCommands[slot];
    }

    public void offButtonPressed(int slot) {
        mOffCommands[slot].execute();
        mUndoCommand = mOffCommands[slot];
    }

    public void undoButtonPressed() {
        mUndoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----- Remote Control -----");
        for (int i = 0; i < 7; i++) {
            stringBuilder
                    .append("\n[slot ")
                    .append(i)
                    .append("] ")
                    .append(mOnCommands[i].getClass().getSimpleName())
                    .append(", ")
                    .append(mOffCommands[i].getClass().getSimpleName());
        }
        return stringBuilder.toString();
    }

}
