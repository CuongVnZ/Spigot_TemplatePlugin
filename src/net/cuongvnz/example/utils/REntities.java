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

import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityLiving;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class REntities {

    public static LivingEntity createLivingEntity(Class<? extends Entity> type, Location loc) {
    	if(!(loc.getChunk().isLoaded())) {
    		loc.getChunk().load();
    	}
        net.minecraft.server.v1_12_R1.World world = ((CraftWorld) (loc.getWorld())).getHandle();
        EntityLiving e = null;
        try {
            e = (EntityLiving) (type.getDeclaredConstructor(net.minecraft.server.v1_12_R1.World.class).newInstance(world));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e.P = 2.5f;
        e.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        world.addEntity(e, SpawnReason.CUSTOM);
        LivingEntity le = (LivingEntity) (((Entity) e).getBukkitEntity());
        le.setRemoveWhenFarAway(false);
        return le;
    }

}
