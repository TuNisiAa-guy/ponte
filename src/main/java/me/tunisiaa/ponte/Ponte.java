package me.tunisiaa.ponte;

import co.aikar.util.JSONUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Item;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.w3c.dom.ls.LSOutput;

public final class Ponte extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Hello, fellow player!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Discord.sendMessageToServer(event.getPlayer().toString().replace("CraftPlayer{name=", "").replace("}", ""), "è entrato nel server.");
    }

    @EventHandler
    public void onPlayerLeave(PlayerJoinEvent event){
        Discord.sendMessageToServer(event.getPlayer().toString().replace("CraftPlayer{name=", "").replace("}", ""), "è uscito dal server.");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDropItemEvent event){
        Player name = event.getPlayer();
        Item item = event.getItemDrop();
        System.out.println(item.toString());
        name.sendMessage(String.format("%s, remember to not waste food!", (name.toString().replace("CraftPlayer{name=", "").replace("}", ""))));
    }

    @EventHandler
    public void onPlayerMessage(AsyncPlayerChatEvent event){
        Discord.sendMessageToServer(event.getPlayer().toString().replace("CraftPlayer{name=", "").replace("}", ""), event.getMessage());
    }

    public static void sendInServer(String author, String message){
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage("[DS] <" + author + "> : " + message);
        }
    }
}
