package net.cuongvnz.example.utils.entities;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_12_R1.*;

import java.lang.reflect.Field;

public class CustomWolf extends EntityWolf implements Leashable {

    public CustomWolf(World world) {
        super(world);
        try {
            Field gsa = PathfinderGoalSelector.class.getDeclaredField("b");
            gsa.setAccessible(true);
            gsa.set(this.goalSelector, Sets.newLinkedHashSet());
            gsa.set(this.targetSelector, Sets.newLinkedHashSet());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
        this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
    }

    @Override
    public void allowWalk(int leash) {
        this.goalSelector.a(5, new PathfinderGoalMobWander(this, 1.0D, 40, leash));
    }

    @Override
    public void setAngry(boolean flag) {

    }

    public void makeRedEyes(boolean state) {
        byte b0 = ((Byte) this.datawatcher.get(bx)).byteValue();
        if (state) {
            this.datawatcher.set(bx, Byte.valueOf((byte) (b0 | 0x2)));
        } else {
            this.datawatcher.set(bx, Byte.valueOf((byte) (b0 & 0xFFFFFFFD)));
        }
    }

}