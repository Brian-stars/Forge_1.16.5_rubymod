package com.brianstars.rubymod;

import com.brianstars.rubymod.inits.Items;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.brianstars.rubymod.Units.MOD_ID;

@Mod(MOD_ID)
public class Main {
    public Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this.getClass());
        bus.addListener(this::CommonSetup);
        bus.addListener(this::ClientSetup);

        Items.ITEMS.register(bus);
    }

    private void CommonSetup(final FMLCommonSetupEvent event) {

    }
    private void ClientSetup(final FMLClientSetupEvent event) {

    }
}
