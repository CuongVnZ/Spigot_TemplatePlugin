package net.cuongvnz.example;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import net.cuongvnz.example.sql.SQLManager;
import net.cuongvnz.example.examples.ExampleManager;
import net.cuongvnz.example.commands.CommandManager;

public class ExamplePlugin extends JavaPlugin{

    public static final boolean MYSQL_ENABLE = true;

    public static ExamplePlugin plugin;
	
    @Override
    public void onEnable() {
        plugin = this;
        
        File f = getDataFolder();
        if (!f.exists())
            f.mkdirs();
        
        saveDefaultConfig();

        // Instantiate Managers here

        if(MYSQL_ENABLE) new SQLManager(this);
        new CommandManager(this);
        new ExampleManager(this);
        
//        System.out.println("Enabled ExamplePlugin.");
//        System.out.println("Connected MySQL server...");
//        System.out.println("Host: " + ExamplePlugin.host);
//        System.out.println("Port: " + ExamplePlugin.port);
//        System.out.println("Database: " + ExamplePlugin.database);
//        System.out.println("Username: " + ExamplePlugin.username);
//        System.out.println("Password: " + ExamplePlugin.password);
        
    }
    
    @Override
    public void onDisable() {
        try {
            SQLManager.disconnect();
            ManagerInstances.cleanup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
