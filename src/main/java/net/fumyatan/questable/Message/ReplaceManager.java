package net.fumyatan.questable.Message;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import net.fumyatan.questable.Questable;

public class ReplaceManager {

	private static File yml = new File("plugins/Questable/wordvariation.yml");
	private static FileConfiguration data = null;
	private static Map<String, String> keyset = new HashMap<>();
	private static boolean debug = Questable.debug;

	/**
	 * 置き換え辞書をMapに登録
	 * @category Boot Setup
	 */
	public static void setMap(){
		if (!yml.exists()){
			try {
				yml.createNewFile();
				return;
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				if (debug)
					e.printStackTrace();
			}
		}

		data = YamlConfiguration.loadConfiguration(yml);
		keyset.clear();
		for (String key : data.getStringList("variation")){
			String[] keys = key.split(":");
			keyset.put(keys[0], keys[1]);
		}
	}

	public static String setReplace(String message){
		return null;
	}
}
