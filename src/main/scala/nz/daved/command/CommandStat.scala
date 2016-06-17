package nz.daved.command

import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.server.MinecraftServer
import net.minecraft.stats.StatList
import nz.daved.stat.StatPrinter

import scala.collection.JavaConversions._

case class CommandStat(parent: Option[ImproveCommand])
  extends ImproveCommand("stat")
  with IntermediateCommand
  with PlayerCommand {

  override val subCommands: List[ImproveCommand] = List(CommandStatAll(Some(this)), CommandStatAllNonZero(Some(this)))
}

case class CommandStatAll(parent: Option[ImproveCommand]) extends TerminalCommand("all") {
  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) =
    StatPrinter.printStats(sender.asInstanceOf[EntityPlayerMP], StatList.ALL_STATS.toList)
}

case class CommandStatAllNonZero(parent: Option[ImproveCommand]) extends TerminalCommand("nonzero") {
  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) =
    StatPrinter.printNonZeroStats(sender.asInstanceOf[EntityPlayerMP], StatList.ALL_STATS.toList)
}
