package business.commandsService;

import business.commands.Exit;
import business.commands.Help;
import business.commands.record.*;

import java.util.HashMap;
import java.util.Map;

public class CommandsMap {
    private static Map<String, ILibraryCommand> commands = new HashMap<String, ILibraryCommand>();

    static {
        commands.put(IAvailableCommands.exit, new Exit());
        commands.put(IAvailableCommands.addRecord, new AddRecord());
        commands.put(IAvailableCommands.edit, new EditRecord());
        commands.put(IAvailableCommands.auth, new Auth());
        commands.put(IAvailableCommands.deleteRecord, new DeleteRecord());
        commands.put(IAvailableCommands.viewRecords, new ViewRecords());
        commands.put(IAvailableCommands.help, new Help());
        commands.put(IAvailableCommands.register, new Register());
        commands.put(IAvailableCommands.deleteAcc, new RemoveAcc());
        commands.put(IAvailableCommands.search, new SearchRecord());
        commands.put(IAvailableCommands.logout, new Logout());
        commands.put(IAvailableCommands.authInfo, new AuthInfo());
    }
    public static Map<String, ILibraryCommand> getCommands() {
        return commands;
    }
}
