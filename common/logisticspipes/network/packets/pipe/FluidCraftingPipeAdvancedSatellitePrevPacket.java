package logisticspipes.network.packets.pipe;

import logisticspipes.network.abstractpackets.IntegerCoordinatesPacket;
import logisticspipes.network.abstractpackets.ModernPacket;
import logisticspipes.pipes.PipeItemsCraftingLogistics;
import net.minecraft.entity.player.EntityPlayer;
import buildcraft.transport.TileGenericPipe;

public class FluidCraftingPipeAdvancedSatellitePrevPacket extends IntegerCoordinatesPacket {

	public FluidCraftingPipeAdvancedSatellitePrevPacket(int id) {
		super(id);
	}

	@Override
	public ModernPacket template() {
		return new FluidCraftingPipeAdvancedSatellitePrevPacket(getId());
	}

	@Override
	public void processPacket(EntityPlayer player) {
		final TileGenericPipe pipe = this.getPipe(player.worldObj);
		if (pipe == null) {
			return;
		}
		if (!(pipe.pipe instanceof PipeItemsCraftingLogistics)) {
			return;
		}
		((PipeItemsCraftingLogistics) pipe.pipe).setPrevFluidSatellite(player, getInteger());
	}
}

