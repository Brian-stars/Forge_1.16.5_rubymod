package com.brianstars.rubymod.inits;

import com.brianstars.rubymod.Units;
import com.brianstars.rubymod.items.Ruby;
import com.brianstars.rubymod.items.RubySword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class Items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Units.MOD_ID);

    private static <T extends Item>RegistryObject<T> register(final String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }

    //注册第一个物品
    public static final RegistryObject<Item> RUBY =
            register("ruby",() -> new Ruby(new Item.Properties().tab(ItemGroup.TAB_MATERIALS).defaultDurability(10)));
    public static final RegistryObject<Item> RUBY_SWROD =
            register("ruby_sword",() -> new RubySword(1,-3.2F,new Item.Properties().tab(ItemGroup.TAB_MATERIALS).stacksTo(1).defaultDurability(1024)));

}
