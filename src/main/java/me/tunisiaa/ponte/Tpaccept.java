package me.tunisiaa.ponte;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class Tpaccept implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label == "tpaccept"){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                // Here we need to give items to our player
            }
            Player target = Bukkit.getPlayer(args[0]);

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
        }
        return true;
    }
}