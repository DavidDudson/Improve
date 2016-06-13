package nz.daved.event

import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event._
import nz.daved.proxy.IProxy

trait LoadingEvents {
  def serverStarting(evt: FMLServerStartingEvent) = {}
  def preInit() = {}
  def init() = {}
  def postInit() = {}
}

trait LoadingEventDelegate extends LoadingEvents {

  val proxy: IProxy

  @EventHandler
  def init(evt: FMLInitializationEvent) = proxy.init()

  @EventHandler
  def preInit(evt: FMLPreInitializationEvent) = proxy.preInit()

  @EventHandler
  def postInit(evt: FMLPostInitializationEvent) = proxy.postInit()

  @EventHandler
  def serverStarting(evt: FMLServerStartedEvent) = proxy.serverStarting(evt)
}
