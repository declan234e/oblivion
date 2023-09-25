package dev.declan234e.oblivion.init;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.networking.packet.EnergySyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier ENERGY_SYNC = new Identifier(Oblivion.MOD_ID, "energy_sync");

    public static void registerC2SPackets() {

    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
    }
}
