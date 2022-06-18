package net.cuongvnz.example.examples;

import net.cuongvnz.example.AbstractManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import net.cuongvnz.example.ExamplePlugin;

public class ExampleManager extends AbstractManager {

	/**
	 * Contractor function.
	 * @param plugin plugin instance class
	 */
	public ExampleManager(ExamplePlugin plugin) {
		super(plugin);
	}

	/**
	 * This function run when the Class was registered.
	 */
	@Override
	public void initialize() {
		Bukkit.getLogger().info("Example class was activated!");
	}

	/**
	 * Example game event implement.
	 */
    @EventHandler
    public void onAsyncPrelogin(AsyncPlayerPreLoginEvent event) {

    }

}
