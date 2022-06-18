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

import net.cuongvnz.core.NeoRPGCore;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class RTags {

    public static ArmorStand makeFloatingText(String name, Location loc, double xzOffset, double yMin, double yMax, double durationSec) {
        loc.add(-xzOffset / 2 + (Math.random() * (xzOffset)), (Math.random() * (yMax - yMin)) + yMin, -xzOffset / 2 + (Math.random() * (xzOffset)));
        final ArmorStand as = (ArmorStand) REntities.createLivingEntity(CustomArmorStand.class, loc);
        as.setVisible(false);
        as.setSmall(true);
        as.setMarker(true);
        as.setGravity(false);
        as.setArms(false);
        as.setBasePlate(false);
        as.setCanPickupItems(false);
        as.setCustomName(name);
        as.setBasePlate(false);
        as.setCustomNameVisible(true);
        as.setRemoveWhenFarAway(false);
        RScheduler.schedule(NeoRPGCore.plugin, new Runnable() {
            public void run() {
                if (as != null && as.isValid())
                    as.remove();
            }
        }, RTicks.seconds(durationSec));
        return as;
    }
    
    public static EntityArmorStand makeFloatingTextByPacket(Player p, String name, Location loc, double xzOffset, double yMin, double yMax, double durationSec) {
        loc.add(-xzOffset / 2 + (Math.random() * (xzOffset)), (Math.random() * (yMax - yMin)) + yMin, -xzOffset / 2 + (Math.random() * (xzOffset)));
        net.minecraft.server.v1_12_R1.WorldServer world = ((CraftWorld) (loc.getWorld())).getHandle();
        EntityArmorStand as = new EntityArmorStand(world);        
        as.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        as.setInvisible(true);
        as.setSmall(true);
        as.setMarker(true);
        as.setNoGravity(false);
        as.setArms(false);
        as.setBasePlate(false);
        as.setCustomName(name);
        as.setBasePlate(false);
        as.setCustomNameVisible(true);
        
        PacketPlayOutSpawnEntityLiving entityPacket = new PacketPlayOutSpawnEntityLiving((EntityLiving) as);
        PacketPlayOutEntityTeleport teleportPacket = new PacketPlayOutEntityTeleport(as);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(entityPacket);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(teleportPacket);
        
        RScheduler.schedule(NeoRPGCore.plugin, new Runnable() {
            public void run() {
                if (as != null && as.isAlive()) {
                    as.die();
                    PacketPlayOutEntityDestroy entityDespawnPacket = new PacketPlayOutEntityDestroy(as.getId());
                    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(entityDespawnPacket);
                }
            }
        }, RTicks.seconds(durationSec));
        
        return as;
    }

    public static ArmorStand makeStand(String name, Location loc, boolean marker) {
        ArmorStand as = (ArmorStand) REntities.createLivingEntity(CustomArmorStand.class, loc);
        as.setVisible(false);
        as.setSmall(true);
        if (marker)
            as.setMarker(true);
        as.setGravity(false);
        as.setArms(false);
        as.setBasePlate(false);
        as.setCanPickupItems(false);
        as.setCustomName(name);
        as.setCustomNameVisible(true);
        as.setRemoveWhenFarAway(false);
        return as;
    }
    //
    //    public static Slime makeSlime(Location loc) {
    //        return makeSlime(1, loc);
    //    }
    //
    //    public static Slime makeSlime(int size, Location loc) {
    //        Slime slime = (Slime) REntities.createLivingEntity(CustomSlime.class, loc);
    //        ((CustomSlime) ((CraftSlime) slime).getHandle()).isTag = true;
    //        slime.setSize(size);
    //        ((CustomSlime) ((CraftSlime) slime).getHandle()).setInvisible(true);
    //        slime.setRemoveWhenFarAway(false);
    //        return slime;
    //    }
}
