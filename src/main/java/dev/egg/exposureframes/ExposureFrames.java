package dev.egg.exposureframes;

import com.mojang.logging.LogUtils;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.function.Supplier;

@Mod(ExposureFrames.MODID)
public class ExposureFrames {
    public static final String MODID = "exposureframes";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> VIDEO_CAMERA_ITEM = ITEMS.registerSimpleItem("video_camera", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    public ExposureFrames(IEventBus modEventBus, ModContainer modContainer) {
        CREATIVE_MODE_TABS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> VIDEO_CAMERA_CREATIVE_TAB = CREATIVE_MODE_TABS.register("exposureframes", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("itemGroup.exposureframes.exposureframes")).icon(() -> new ItemStack((ItemLike)VIDEO_CAMERA_ITEM)).displayItems((params, output) -> {
        output.accept((ItemLike)VIDEO_CAMERA_ITEM);
    }).build());
}
