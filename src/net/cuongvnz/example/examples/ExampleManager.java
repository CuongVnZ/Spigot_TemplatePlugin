package net.cuongvnz.example.examples;

import net.cuongvnz.example.AbstractManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import net.cuongvnz.example.ExamplePlugin;

public class ExampleManager extends AbstractManager {

	public ExampleManager(ExamplePlugin pl) {
		super(pl);
	}

	@Override
	public void initialize() {
		
	}
	
    @EventHandler
    public void onAsyncPrelogin(AsyncPlayerPreLoginEvent event) {

    }

}
