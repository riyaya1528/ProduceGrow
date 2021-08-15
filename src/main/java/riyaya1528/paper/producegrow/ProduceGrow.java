package riyaya1528.paper.producegrow;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ProduceGrow extends JavaPlugin {
    public static Logger log;

    public static int cooldown;
    public static boolean enableSaplings;
    public static boolean enableCrops;
    public static boolean showParticles = true;
    public static boolean rainGrow = true;
    public static int rainGrowSpeed;

    @Override
    public void onEnable() {
        System.out.println("[ProduceGrow]プラグインが有効になりました");

        log = getLogger();

        Configuration config = getConfig();
        cooldown = config.getInt("Tweaks.cooldownTicks", 5);
        enableSaplings = config.getBoolean("Tweaks.growSaplings", true);
        enableCrops = config.getBoolean("Tweaks.growCrops", true);
        showParticles = config.getBoolean("Tweaks.showParticles", true);
        rainGrow = config.getBoolean("rainGrow", true);
        rainGrowSpeed = config.getInt("rainGrowSpeed", 2);
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new SneakHandler(), this);
        getServer().getPluginManager().registerEvents(new GrowWhenRainy(),this);
    }

    @Override
    public void onDisable() {
        System.out.println("[ProduceGrow]プラグインが有効になりました");
    }
}
