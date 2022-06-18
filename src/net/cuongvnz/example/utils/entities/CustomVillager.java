package net.cuongvnz.example.utils.entities;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_12_R1.*;

import java.lang.reflect.Field;

public class CustomVillager extends EntityVillager implements Leashable {

    public CustomVillager(World world) {
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
        this.goalSelector.a(1, new PathfinderGoalRandomLookaround(this));
        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(30.0d);
    }

    public String toString() {
        return this.getCustomName() + " " + this.getUniqueID();
    }

    @Override
    public void allowWalk(int leash) {
        this.goalSelector.a(3, new PathfinderGoalNPCWander(this, 0.45D, 20, leash)); //the last param is time between moves, 120 is default
    }
    
    @Override
    protected void C(Entity entity) {
        
    }
    
    @Override
    public void collide(Entity entity) {

    }
    
    public boolean a(EntityHuman entityhuman) {
        return true;
    }

    @Override
    protected SoundEffect F() {
        return null;
    }

    @Override
    protected SoundEffect d(DamageSource damagesource) {
        return SoundEffects.fF;
    }

    @Override
    protected SoundEffect cf() {
        return SoundEffects.iE;
    }

}