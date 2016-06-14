package nz.daved.event

import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event._
import nz.daved.proxy.IProxy

trait LoadingEvents {
  def serverStarting(evt: FMLServerStartingEvent) = {}
  def preInit(evt: FMLPreInitializationEvent) = {}
  def init() = {}
  def postInit() = {}
}

trait LoadingEventDelegate extends LoadingEvents {

  var proxy: IProxy

  @EventHandler
  def init(evt: FMLInitializationEvent) = proxy.init()

  @EventHandler
  override def preInit(evt: FMLPreInitializationEvent) = proxy.preInit(evt)

  @EventHandler
  def postInit(evt: FMLPostInitializationEvent) = proxy.postInit()

  @EventHandler
  override def serverStarting(evt: FMLServerStartingEvent) = proxy.serverStarting(evt)
}
