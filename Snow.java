package com.myhandy.SnowSpeed;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Snow extends JavaPlugin {
	public void onEnable(){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
	   	  @Override
	   	  public void run() {
	                Player[] plry = Bukkit.getServer().getOnlinePlayers();
	                World world = Bukkit.getServer().getWorld(getConfig().getString("WORLD"));
	              
	      }
		}, 0L, 20L);
	}
}
