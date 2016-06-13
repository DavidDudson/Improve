package nz.daved

import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.Mod.{EventHandler, Instance}
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import nz.daved.proxy.IProxy

@Mod(modid = "Improve", version = "0.1", modLanguage = "scala")
object Improve {

  FluidRegistry.enableUniversalBucket()

  @Instance
  val instance = this

  @SidedProxy(clientSide = "nz.daved.proxy.ClientProxy", serverSide = "nz.daved.proxy.ServerProxy")
  val proxy: IProxy = _

  @EventHandler
  def init(evt: FMLInitializationEvent) = proxy.init()

  @EventHandler
  def preInit(evt: FMLPreInitializationEvent) = proxy.preInit()

  @EventHandler
  def postInit(evt: FMLPostInitializationEvent) = proxy.postInit()

  print("Test")
}
