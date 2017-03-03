package net.fumyatan.questable;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import net.fumyatan.questable.Listener.PlayerDeathEventListener;
import net.fumyatan.questable.Message.PrefixAdder;

public class Questable extends JavaPlugin {
	public static Plugin plugin;
	public static boolean debug;
	public static WorldGuardPlugin worldguard = null;

	@Override
	public void onEnable(){
		plugin = this;
		getServer().getPluginManager().registerEvents(new PlayerDeathEventListener(), plugin);
		getConfig().getBoolean("debug");

		// WorldGuardのセットアップ
		if (!(Bukkit.getPluginManager().getPlugin("WorldGuard") == null)){
			worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
		} else {
			PrefixAdder.setLoggerWarn("[前提プラグイン] WorldGuardが足りません！");
		}
	}

	@Override
	public void onDisable(){

	}

}
