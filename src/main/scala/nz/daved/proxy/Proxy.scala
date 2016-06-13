package nz.daved.proxy

import net.minecraftforge.common.MinecraftForge
import nz.daved.event.LoadingEvents

trait IProxy extends LoadingEvents

case class ClientProxy() extends IProxy

case class ServerProxy() extends IProxy {
  override def preInit() = {
    MinecraftForge.EVENT_BUS.register()
  }
}