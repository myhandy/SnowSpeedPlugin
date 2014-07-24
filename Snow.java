package com.myhandy.SnowSpeed;

//import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Snow extends JavaPlugin {
	public World WRLD = (World) getConfig().get("WORLD");
	public void onEnable(){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
	   	  	@Override
	   	  	public void run() {
	   	  		System.out.println("step one works fine"); {
	   	  			for(Player p : Bukkit.getOnlinePlayers()){
	   	  				if(p.getWorld().equals(WRLD)) {
	                	 System.out.println("World check is working for player: "+ p.getDisplayName());
	                 	}
	   	  				else{
	   	  					continue;
	   	  				}
	   	  			}
	   	  		}
	   	  	}
		}, 0L, 20L);
	}
}
