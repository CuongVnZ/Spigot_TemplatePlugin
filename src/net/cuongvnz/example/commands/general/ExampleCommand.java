package net.cuongvnz.example.commands.general;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.cuongvnz.example.commands.AbstractCommand;

public class ExampleCommand extends AbstractCommand {

    public ExampleCommand(String... commandNames) {
        super(commandNames);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("Hello");
    }
    
    @Override
    public void executeConsole(CommandSender sender, String[] args) {
    	
    }

	@Override
	public void executePlayer(Player p, String[] args) {

	}
}
