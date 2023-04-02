package me.tunisiaa.ponte;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import me.tunisiaa.ponte.Tpa;

import static org.bukkit.Bukkit.getServer;

public class Tpaccept implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayer(args[0]);

            if (Tpa.didPlayerAsk(target.getName()) || target == null) {
                target.sendMessage(sender.getName() + " ha accettato la richiesta di tpa, preparati!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                target.sendMessage("5");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                target.sendMessage("4");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                target.sendMessage("3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                target.sendMessage("2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                target.sendMessage("1");

                getServer().dispatchCommand(getServer().getConsoleSender(), "/tp " + target + " " + player);
                return true;
            } else {
                player.sendMessage(target.getName() + " non è nel server in questo momento, oppure non ti ha mandato una richiesta di tpa.");
                return false;
            }

        }
        return false;
    }
}