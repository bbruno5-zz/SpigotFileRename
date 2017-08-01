package com.b5team.spigotfilerename;

import java.io.File;
import java.util.logging.Level;
import org.bukkit.util.FileUtil;

public class Utils {
	
	public static void renameFile(String args[]) {
		
		String path = args[0];
		String file = args[1];
		String back = args[2];
		
		String filepath = "../" + path + "/" + file;
		String fileback = "../" + path + "/" + back;
		
		File dir = Main.getInstance().getDataFolder();
		
		File old = new File(dir, filepath);
		File niu = new File(dir, fileback);
		
		if (!dir.exists()) {
			
			dir.mkdirs();
			Main.getMainLogger().log(Level.INFO, "[SpigotFileRename] Generating structures...");
		} else if (dir.exists() && dir.isDirectory()) {
			Main.getMainLogger().log(Level.INFO, "[SpigotFileRename] Primary directory exists. Pass.");
		} else {
			Main.getMainLogger().log(Level.SEVERE, "[SpigotFileRename] The plugin directory can't be created!");
		}
		
		if (old.exists() && !old.isDirectory()) {
			old.delete();
			Main.getMainLogger().log(Level.INFO, "[SpigotFileRename] Old file deleted.");
			
		} else {
			Main.getMainLogger().log(Level.WARNING, "[SpigotFileRename] The old file or directory doesn't exists previously.");
			
		}
		
		if (niu.exists() && !niu.isDirectory()) {
			FileUtil.copy(niu, old);
			Main.getMainLogger().log(Level.INFO, "[SpigotFileRename] File replaced successfully!");
			
		} else {
			Main.getMainLogger().log(Level.SEVERE, "[SpigotFileRename] The new file or directory doesn't exists. Verify the correct path and try again.");
			
		}
	}
}
