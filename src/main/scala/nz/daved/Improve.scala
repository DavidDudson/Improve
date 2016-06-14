package nz.daved

import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.Mod.Instance
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import nz.daved.event.LoadingEventDelegate
import nz.daved.proxy.IProxy
import org.apache.logging.log4j.Logger

@Mod(modid = MOD_ID, version = MOD_VERSION, modLanguage = "scala")
object Improve extends LoadingEventDelegate {
  var logger: Logger = null

  FluidRegistry.enableUniversalBucket()

  @Instance
  final val instance = this

  @SidedProxy(clientSide = "nz.daved.proxy.ClientProxy", serverSide = "nz.daved.proxy.ServerProxy")
  var proxy: IProxy = null
}
