package net.cuongvnz.example.utils.entities;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.World;

import java.util.UUID;

@SuppressWarnings("unused")
public class CustomNPC extends EntityHuman {
	private static GameProfile gameprofile = new GameProfile(UUID.randomUUID(), "FakePlayer");
	
    public CustomNPC(World world) {
        super(world, gameprofile);
        /*
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
        */
    }

	@Override
	public boolean isSpectator() {
		return false;
	}

	@Override
	public boolean z() {
		return false;
	}

}