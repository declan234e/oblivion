package tas.atlas.procedures;

import tas.atlas.item.UrandiaIngotItem;
import tas.atlas.AtlasMultiMod;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.state.IntegerProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockState;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class CheckForIngotProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency blockstate for procedure CheckForIngot!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency x for procedure CheckForIngot!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency y for procedure CheckForIngot!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency z for procedure CheckForIngot!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency world for procedure CheckForIngot!");
			return;
		}
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == UrandiaIngotItem.block)) {
			if (((new Object() {
				public int get(BlockState _bs, String property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
					return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
				}
			}.get(blockstate, "age")) < 4)) {
				{
					int _value = (int) ((new Object() {
						public int get(BlockState _bs, String property) {
							Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
							return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
						}
					}.get(blockstate, "age")) + 1);
					BlockPos _pos = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateContainer().getProperty("age");
					if (_property instanceof IntegerProperty && _property.getAllowedValues().contains(_value))
						world.setBlockState(_pos, _bs.with((IntegerProperty) _property, _value), 3);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final int _amount = (int) 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_sltid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
							}
						});
					}
				}
			}
		}
	}
}
