package com.brianstars.rubymod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

//当右键红宝石的时候获得一个提升最大生命值的buff，物品消失
public class Ruby extends Item {
    public Ruby(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        ItemStack stack = player.getItemInHand(hand);
        player.addEffect(new EffectInstance(Effects.HEALTH_BOOST,1000));
        stack.hurtAndBreak(10,player,(player1) -> {
            player1.broadcastBreakEvent(hand);
        });
      return ActionResult.success(stack);
    }

}
