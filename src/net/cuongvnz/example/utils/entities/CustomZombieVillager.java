package net.cuongvnz.example.utils.entities;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_12_R1.*;

import java.lang.reflect.Field;

public class CustomZombieVillager extends EntityZombieVillager implements Leashable {

    public CustomZombieVillager(World world) {
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
        this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 1.0D, 40));
        this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
        this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
    }

    @Override
    public void allowWalk(int leash) {
        this.goalSelector.a(5, new PathfinderGoalMobWander(this, 1.0D, 40, leash));
    }

    @Override
	public SoundEffect F() {
        return null;
    }

    @Override
	public SoundEffect d(DamageSource damagesource) {
        return SoundEffects.fF;
    }

    @Override
	public SoundEffect cf() {
        return SoundEffects.iE;
    }

    @Override
    protected void a(BlockPosition blockposition, Block block) {
        //makeSound("mob.skeleton.step", 0.15F, 1.0F);
    }

}