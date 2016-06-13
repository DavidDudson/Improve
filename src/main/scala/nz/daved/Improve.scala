package nz.daved

import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.Mod.Instance
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import nz.daved.event.LoadingEventDelegate
import nz.daved.proxy.IProxy

@Mod(modid = "Improve", version = "0.1", modLanguage = "scala")
object Improve extends LoadingEventDelegate {

  FluidRegistry.enableUniversalBucket()

  @Instance
  val instance = this

  @SidedProxy(clientSide = "nz.daved.proxy.ClientProxy", serverSide = "nz.daved.proxy.ServerProxy")
  val proxy: IProxy = _

}
