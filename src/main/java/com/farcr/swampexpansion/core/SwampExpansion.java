package com.farcr.swampexpansion.core;

import com.farcr.swampexpansion.core.proxy.ClientProxy;
import com.farcr.swampexpansion.core.proxy.ServerProxy;
import com.farcr.swampexpansion.core.registries.BlockRegistry;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("swampexpansion")
public class SwampExpansion {
	public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

	public SwampExpansion() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
	}

	private void setupCommon(final FMLCommonSetupEvent event) {
		proxy.init();
		BlockRegistry.registerBlockData();
	}
}