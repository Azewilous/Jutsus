package pkg.leaves.jutsu;



import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Jutsu extends JavaPlugin implements Listener {
  
	public final Logger azewylogger =  Logger.getLogger("MineCraft");
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.azewylogger.info(pdfFile.getName() + "Version" + pdfFile.getVersion());
		 getServer().getPluginManager().registerEvents(this , this);
		 getConfig().options().copyDefaults(true);
		 saveConfig();
		 azewylogger.info("This is a really cool RPG Plugin"); 
	}
	 @EventHandler
	 public void onPlayerJoinEvent(PlayerJoinEvent event){
	 Player player = event.getPlayer();	 
	 player.sendMessage(getConfig().getString("MOTD"));
	 }
	@SuppressWarnings("unused")
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event){
		Player player = (Player) event.getPlayer();
		ItemStack flint = new ItemStack(Material.FLINT);
		if(player.getInventory().getItemInHand().equals(flint)){
		Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).toLocation(player.getWorld(), 
				player.getLocation().getYaw(), player.getLocation().getPitch());
		Fireball fireball = player.getWorld().spawn(loc, Fireball.class);
		}
	}
	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void onPlayerInteractEvent2(PlayerInteractEvent event){
		Player player = (Player) event.getPlayer();
		ItemStack water = new ItemStack(Material.WATER);
		if(player.getInventory().getItemInHand().equals(water)){
			Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(6)).toLocation(player.getWorld(),
					player.getLocation().getYaw(), player.getLocation().getPitch());
		    event.getPlayer().getWorld().spawnFallingBlock(loc, 9, (byte) 4);
		}
	}
	@EventHandler
	public void onPlayerInteractEvent3(PlayerInteractEvent event){
		
	}
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.azewylogger.info(pdfFile.getName() + "Version" + pdfFile.getVersion());
	}
}

