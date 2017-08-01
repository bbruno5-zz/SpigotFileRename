package com.b5team.spigotfilerename;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	private static Logger logger;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		logger = this.getLogger();
	}
	
	@Override
	public void onDisable() {
		logger.info("SpigotFileRename is now disabled. You will no longer capable to send HTTP/HTTPS POST requests.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender,
			Command cmd,
			String label,
			String[] args) {
		
		if (!this.isEnabled()) {
			logger.log(Level.SEVERE, "SpigotFileRename is disabled. Restart the server to run commands.");
		} else if (cmd.getName().equalsIgnoreCase("sfr")) {
			String[] arg = args;
			
			try {
				
				if (sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender || sender instanceof BlockCommandSender) {
	        		
					Utils.renameFile(arg);
					
	        	} else if (sender instanceof Player) {
	        		
	        		Player plsender = (Player) sender;
	        		plsender.sendMessage("You are not allowed to use this command.");
	        	}
			} catch (Exception e) {
				logger.log(Level.SEVERE, "[SpigotFileRename] Impossible to make utils request.");
			}
		}
		return false;
	}
	
	public static Main getInstance() {
		return plugin;
	}
	
	public static Logger getMainLogger() {
		return logger;
	}
}
