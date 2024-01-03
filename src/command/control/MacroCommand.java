package command.control;

public class MacroCommand implements Command {

    private Command[] mCommands;

    public MacroCommand(Command[] commands) {
        mCommands = commands;
    }


    @Override
    public void execute() {
        for (int i = 0; i < mCommands.length; i++) {
            mCommands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = mCommands.length - 1; i >= 0; i--) {
            mCommands[i].undo();
        }
    }

}
