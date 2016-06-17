package nz.daved.command

import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.server.MinecraftServer
import net.minecraft.stats.{StatBase, StatList}
import nz.daved.stat.StatPrinter

import scala.collection.JavaConversions._

case class CommandStat(parent: Option[ImproveCommand]) extends ImproveCommand("stat") with IntermediateCommand {

  override val subCommands = List(CommandStatShow(parent))
}

case class CommandStatShow(parent: Option[ImproveCommand]) extends ImproveCommand("show") with IntermediateCommand  {
  override val subCommands =
    List(CommandStatAll(Some(this)), CommandStatAllNonZero(Some(this))) ++ generateStatCommands(parent)

  def generateStatCommands(parent: Option[ImproveCommand]) =
    StatList.ALL_STATS.map(s => CommandStatSpecific(parent, s))
}


case class CommandStatSpecific(parent: Option[ImproveCommand], stat: StatBase) extends TerminalCommand(stat.getStatName.getUnformattedText.replaceAll("\\s", "")) {
  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) =
    StatPrinter.printStat(sender.asInstanceOf[EntityPlayerMP], stat)
}

case class CommandStatAll(parent: Option[ImproveCommand]) extends TerminalCommand("all") {
  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) =
    StatPrinter.printStats(sender.asInstanceOf[EntityPlayerMP], StatList.ALL_STATS.toList)
}

case class CommandStatAllNonZero(parent: Option[ImproveCommand]) extends TerminalCommand("nonzero") {
  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) =
    StatPrinter.printNonZeroStats(sender.asInstanceOf[EntityPlayerMP], StatList.ALL_STATS.toList)
}
