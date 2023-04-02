package me.tunisiaa.ponte;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;

public class Tpa implements CommandExecutor {
    static JSONObject players = new JSONObject();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayer(args[0]);
            if (player==target) {
                player.sendMessage("Non puoi usare il comando su te stesso, la sintassi corretta è : /tpa <giocatore> .");
            } else {
                target.sendMessage(sender.getName() + " chiede di potersi teletrasportare da te.\nPer accettare la richiesta digitare /tpaccept " + sender.getName());
            }
            if (players.get(player.getName()).toString()=="false")
                players.put(player.getName(), "true");
            return true;
            // Here we need to give items to our player
        } else if (sender instanceof Server) {
            System.out.println("You cant tp my bro :skull:");
            return false;
        }
        return false;
    }

    public static boolean didPlayerAsk(String name){
        if (players.get(name).toString() == "true"){
            players.replace(name, true, false);
            return true;
        } else {
            return false;
        }
    }
}
