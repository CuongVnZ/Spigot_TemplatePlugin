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
import net.minecraft.server.v1_12_R1.EntityArmorStand;
import net.minecraft.server.v1_12_R1.World;

public class CustomArmorStand extends EntityArmorStand {

    public CustomArmorStand(World world) {
        super(world);
    }

    @Override
    // was K() in 1.8, now U 1.10, now Y 1.12
    public void Y() {

    }
    
    @Override
    protected void cw() {
        
    }
    
    @Override
    protected void C(Entity entity) {
        
    }
    
    @Override
    public void collide(Entity entity) {
        
    }

}