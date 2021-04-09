package com.spyro.spyrosvillagers;

import com.spyro.spyrosvillagers.setup.Registration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VillagerMod.MOD_ID)
public class VillagerMod {
    public static final String MOD_ID = "spyrosvillagers";
    private static final Logger LOGGER = LogManager.getLogger();


    public VillagerMod() {

        Registration.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    }

    private void setup(final FMLCommonSetupEvent event) {

    }


}
