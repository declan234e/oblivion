package dev.declan234e.oblivion.networking.packet;

import dev.declan234e.oblivion.block.Entity.ElectricFurnaceBlockEntity;
import dev.declan234e.oblivion.block.Entity.TinyReactorBlockEntity;
import dev.declan234e.oblivion.screen.ElectricFurnaceScreenHandler;
import dev.declan234e.oblivion.screen.TinyReactorScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

public class EnergySyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        long energy = buf.readLong();
        BlockPos position = buf.readBlockPos();


        assert client.world != null;
        if(client.world.getBlockEntity(position) instanceof TinyReactorBlockEntity blockEntity) {
            blockEntity.setEnergyLevel(energy);

            if(client.player.currentScreenHandler instanceof TinyReactorScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setEnergyLevel(energy);
            }
        }

        if(client.world.getBlockEntity(position) instanceof ElectricFurnaceBlockEntity blockEntity) {
            blockEntity.setEnergyLevel(energy);

            if(client.player.currentScreenHandler instanceof ElectricFurnaceScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setEnergyLevel(energy);
            }
        }
    }
}