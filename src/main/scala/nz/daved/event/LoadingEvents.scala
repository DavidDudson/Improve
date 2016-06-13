package nz.daved.event

import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event._
import nz.daved.command.CommandImprove
import nz.daved.proxy.IProxy

trait LoadingEvents {
  def serverStarting() = {}
  def preInit() = {}
  def init() = {}
  def postInit() = {}
}

trait LoadingEventDelegate extends LoadingEvents {

  var proxy: IProxy

  @EventHandler
  def init(evt: FMLInitializationEvent) = proxy.init()

  @EventHandler
  def preInit(evt: FMLPreInitializationEvent) = proxy.preInit()

  @EventHandler
  def postInit(evt: FMLPostInitializationEvent) = proxy.postInit()

  @EventHandler
  def serverStarting(evt: FMLServerStartingEvent) = {
    evt.registerServerCommand(CommandImprove())
    proxy.serverStarting()
  }
}
