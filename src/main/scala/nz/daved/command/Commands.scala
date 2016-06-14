package nz.daved.command

import net.minecraftforge.fml.common.event.FMLServerStartingEvent

object Commands {
  def apply(evt: FMLServerStartingEvent) = evt.registerServerCommand(CommandImprove())
}
