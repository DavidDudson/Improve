package nz.daved.proxy

import nz.daved.event.{ClientLoadingEvents, LoadingEvents, ServerLoadingEvents}

trait IProxy extends LoadingEvents

case class ClientProxy() extends IProxy with ClientLoadingEvents

case class ServerProxy() extends IProxy with ServerLoadingEvents