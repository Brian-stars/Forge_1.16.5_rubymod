package com.brianstars.rubymod.items;

import jdk.nashorn.internal.ir.Block;
import net.minecraft.client.renderer.entity.model.RabbitModel;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

public class RubySword extends SwordItem {
    public RubySword(int attack_damage,float attack_speed,Properties properties){
        super(ItemTier.NETHERITE,attack_damage,attack_speed,properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(world instanceof ServerWorld){
            BlockPos pos = player.blockPosition();
            BlockPos pos1 = new BlockPos(pos.getX()-5D,pos.getY()-2D,pos.getZ()-5D);
            BlockPos pos2 = new BlockPos(pos.getX()+5D,pos.getY()+2D,pos.getZ()+5D);
            AxisAlignedBB aabb = new AxisAlignedBB(pos1,pos2);
            List<LivingEntity> list  = world.getNearbyEntities(LivingEntity.class, EntityPredicate.DEFAULT,player,aabb);
            Random random = new Random();
            if(!list.isEmpty()){
                LivingEntity entity = list.get(random.nextInt(list.size()));
                entity.die(DamageSource.MAGIC);
                entity.remove();
            }
            return ActionResult.consume(stack);
        }else
            return ActionResult.success(stack);
    }
}
