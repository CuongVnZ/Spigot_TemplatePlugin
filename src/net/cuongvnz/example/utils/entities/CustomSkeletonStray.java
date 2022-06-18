package net.cuongvnz.example.utils.entities;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.Field;

public class CustomSkeletonStray extends EntitySkeletonStray implements Leashable {

    public CustomSkeletonStray(World world) {
        super(world);
        try {
            Field gsa = PathfinderGoalSelector.class.getDeclaredField("b");
            gsa.setAccessible(true);
            gsa.set(this.goalSelector, Sets.newLinkedHashSet());
            gsa.set(this.targetSelector, Sets.newLinkedHashSet());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.goalSelector.a(1, new PathfinderGoalFloat(this));
        this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
    }

    @Override
    public void allowWalk(int leash) {
        this.goalSelector.a(5, new PathfinderGoalMobWander(this, 1.0D, 40, leash));
    }

    @Override
    public boolean a(Material material) {
        return false;
    }

    @Override
    public void stopRiding() {
        return;
    }

    @Override
    public boolean B(Entity entity) {
        boolean r = super.B(entity);
            if (entity.getBukkitEntity() instanceof Player) {
                ((Player) (entity.getBukkitEntity())).removePotionEffect(PotionEffectType.WITHER);
            }
        return r;
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

    @Override
    protected void a(BlockPosition blockposition, Block block) {
        //makeSound("mob.skeleton.step", 0.15F, 1.0F);
    }

}