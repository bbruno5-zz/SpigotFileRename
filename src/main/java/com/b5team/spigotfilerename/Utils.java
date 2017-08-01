package com.b5team.spigotfilerename;

import java.io.File;

import org.bukkit.util.FileUtil;

public class Utils {
	
	public static void renameFile(String args[]) {
		
		String path = args[0];
		String file = args[1];
		String back = args[2];
		
		String filepath = "../" + path + "/" + file;
		String fileback = "../" + path + "/" + back;
		
		try {
			
			File old = new File(filepath);
			old.delete();
			
			FileUtil.copy(new File(fileback), new File(filepath));
			
		} catch (Exception e) {
			System.out.println("[SpigotFileRename] Some error occurred when trying to replace file.");
		}
	}
}
