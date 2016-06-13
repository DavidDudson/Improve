package nz.daved.event

import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent, FMLServerStartedEvent}
import nz.daved.proxy.{IProxy, LoadingEvents}

trait LoadingEventDelegate extends LoadingEvents {

  val proxy: IProxy

  @EventHandler
  def init(evt: FMLInitializationEvent) = proxy.init()

  @EventHandler
  def preInit(evt: FMLPreInitializationEvent) = proxy.preInit()

  @EventHandler
  def postInit(evt: FMLPostInitializationEvent) = proxy.postInit()

  @EventHandler
  def serverStarting(evt: FMLServerStartedEvent) = proxy.serverStarting()
}
