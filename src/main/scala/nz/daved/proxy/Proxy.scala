package nz.daved.proxy

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.{FMLPreInitializationEvent, FMLServerStartingEvent}
import nz.daved.Improve
import nz.daved.command.Commands
import nz.daved.event.{EventDelegate, LoadingEvents}

trait IProxy extends LoadingEvents

case class ClientProxy() extends IProxy {
  override def preInit(evt: FMLPreInitializationEvent) = {
    Improve.logger = evt.getModLog
  }

  override def serverStarting(evt: FMLServerStartingEvent) = Commands(evt)
}

case class ServerProxy() extends IProxy {
  override def preInit(evt: FMLPreInitializationEvent) = {
    Improve.logger = evt.getModLog
    MinecraftForge.EVENT_BUS.register(EventDelegate())
  }
}