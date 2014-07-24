package com.myhandy.SnowSpeed;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public final class Snow extends JavaPlugin {
	public void onEnable(){
		getConfig().options().copyDefaults(true);
		saveConfig();
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
	   	  	@Override
	   	  	public void run() {
	   	  		for(Player p : Bukkit.getOnlinePlayers()){
	   	  				if(p.getWorld().getName().equals(getConfig().getString("WORLD"))) {
	   	  					p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 12000, 1));
	   	  					int radius = 5;
	   	  					for(int i = -radius; i <= radius; i++) {
	   	  							for(int j = -radius; j <= radius; j++) {
	   	  								for(int k = -radius; k <= radius; k++) {
	   	  									if(p.getLocation().getBlock().getRelative(i, j, k).getType() == Material.TORCH){
	   	  										if(p.getPlayer().hasPotionEffect(PotionEffectType.SLOW)){
	   	  											p.getPlayer().removePotionEffect(PotionEffectType.SLOW);
	   	  										}
	   	  									}else{
	   	  										if(p.getLocation().getBlock().getRelative(i, j, k).getType() == Material.FIRE){
	   	  											if(p.getPlayer().hasPotionEffect(PotionEffectType.SLOW)){
	   	  												p.getPlayer().removePotionEffect(PotionEffectType.SLOW);
	   	  											}
	   	  										}else{
	   	  											if(p.getLocation().getBlock().getRelative(i, j, k).getType() == Material.BURNING_FURNACE){
	   	  												if(p.getPlayer().hasPotionEffect(PotionEffectType.SLOW)){
	   	  													p.getPlayer().removePotionEffect(PotionEffectType.SLOW);
	   	  												}
	   	  											}else{
		   	  											if(p.getLocation().getBlock().getRelative(i, j, k).getType() == Material.LAVA){
		   	  												if(p.getPlayer().hasPotionEffect(PotionEffectType.SLOW)){
		   	  													p.getPlayer().removePotionEffect(PotionEffectType.SLOW);
		   	  												}
		   	  											}else{
			   	  											if(p.getLocation().getBlock().getRelative(i, j, k).getType() == Material.STATIONARY_LAVA){
			   	  												if(p.getPlayer().hasPotionEffect(PotionEffectType.SLOW)){
			   	  													p.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			   	  												}
			   	  											}
			   	  										}
	   	  											}
	   	  										}
	   	  									}
	   	  								}
	   	  							}
	   	  					}
	                 	}else{
	                 		if(p.getPlayer().hasPotionEffect(PotionEffectType.SLOW)){
								p.getPlayer().removePotionEffect(PotionEffectType.SLOW);
							}
	   	  					
	   	  				}
	   	  		}
	   	  	}
		}, 0L, 20L);
	}
}
