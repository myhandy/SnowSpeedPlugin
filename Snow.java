package com.myhandy.SnowSpeed;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Snow extends JavaPlugin {
	public void onEnable(){
		System.out.println(Bukkit.getServer().getWorlds());
		this.saveDefaultConfig();
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
	   	  	@Override
	   	  	public void run() {
	   	  		for(Player p : Bukkit.getOnlinePlayers()){
	   	  			if(p.getWorld().getName().equals(Snow.this.getConfig().getString("WORLD"))) {
	                	 	System.out.println("World check is working for player: "+ p.getName());
	                 		}else{
	   	  			continue;
	   	  			}
	   	  		}
	   	  	}
		}, 0L, 20L);
	}
}
