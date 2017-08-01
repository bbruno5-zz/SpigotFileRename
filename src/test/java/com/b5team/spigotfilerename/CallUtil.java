package com.b5team.spigotfilerename;

import org.junit.Test;

public class CallUtil {
	
	@Test
	public void callUtils() {
		String path = "teste";
		String file = "test.yml";
		String back = "test.yml.bak";
		String[] arg = {path, file, back};
		
		Utils.renameFile(arg);
	}
}
