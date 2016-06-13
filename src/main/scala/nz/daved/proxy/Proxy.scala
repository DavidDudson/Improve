package nz.daved.proxy

trait IProxy {

  def preInit()
  def init()
  def postInit()
}

case class ClientProxy() extends IProxy {
  override def preInit(): Unit = {}

  override def init(): Unit = {}

  override def postInit(): Unit = {}
}

case class ServerProxy() extends IProxy {
  override def preInit(): Unit = {}

  override def init(): Unit = {}

  override def postInit(): Unit = {}
}