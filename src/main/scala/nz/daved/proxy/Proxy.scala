package nz.daved.proxy

trait LoadingEvents {
  def serverStarting() = {}
  def preInit() = {}
  def init() = {}
  def postInit() = {}
}

trait IProxy extends LoadingEvents

case class ClientProxy() extends IProxy {
}

case class ServerProxy() extends IProxy {
}