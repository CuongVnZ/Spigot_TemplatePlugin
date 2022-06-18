/*
 *	  ___  _   _                     ____________ _____
 *	 / _ \| | | |                    | ___ \ ___ \  __ \
 *	/ /_\ \ |_| |__   ___ _ __   __ _| |_/ / |_/ / |  \/
 *	|  _  | __| '_ \ / _ \ '_ \ / _` |    /|  __/| | __
 *	| | | | |_| | | |  __/ | | | (_| | |\ \| |   | |_\ \
 *	\_| |_/\__|_| |_|\___|_| |_|\__,_\_| \_\_|    \____/
 *
 */
package net.cuongvnz.example.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class RSound {
    public static void playSound(Player p, Sound s) {
        p.playSound(p.getLocation(), s, 10, 1);
    }

    public static void playSound(Player p, Sound s, float pitch) {
        p.playSound(p.getLocation(), s, 10, pitch);
    }

    public static void playSound(Player p, Sound s, float volume, float pitch) {
        p.playSound(p.getLocation(), s, volume, pitch);
    }
}