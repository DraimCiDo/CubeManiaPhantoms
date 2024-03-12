package me.draimgoose.cubemaniaphantoms;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cmphantoms") && args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("help");

            if (sender.hasPermission("cmphantoms.disablespawn.self")) {
                list.add("togglespawn");
            }

            if (sender.hasPermission("cmphantoms.reload")) {
                list.add("reload");
            }

            if (sender.hasPermission("cmphantoms.kill")) {
                list.add("kill");
            }

            return list;
        }
        List<String> list = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            list.add(p.getName());
        }
        return list;
    }
}
