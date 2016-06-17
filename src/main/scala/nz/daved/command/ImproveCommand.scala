package nz.daved.command

import net.minecraft.command.{ICommand, ICommandSender}
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.server.MinecraftServer
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString

import scala.collection.JavaConversions._

abstract class ImproveCommand(val name: String) extends ICommand {
  val aliases: List[String] = Nil
  val subCommands: List[ImproveCommand]
  val parent: Option[ImproveCommand]

  lazy val parentList: String = parent.map(_.parentList).getOrElse("") + s"$name "

  lazy val usageString = s"Usage: $parentList[${subCommands.map(_.name).mkString("|")}]"

  def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]): Unit

  // ICommand Overriders

  def getCommandName = name

  def getCommandAliases = aliases

  def getCommandUsage(sender: ICommandSender) = usageString

  def compareTo(o: ICommand) = 0

  def checkPermission(server: MinecraftServer, sender: ICommandSender) = true

  override def isUsernameIndex(args: Array[String], index: Int) = false

  def getTabCompletionOptions(
    server: MinecraftServer,
    sender: ICommandSender,
    args: Array[String],
    pos: BlockPos) = {
    lazy val rootCommand = subCommands.find(_.name == args.head)
    if (args.length <= 1 || rootCommand.isEmpty) {
      if (args.last.nonEmpty) {
        subCommandNames
      } else {
        subCommandNames ++ childDynamicCommandTypes
      }
    } else {
      rootCommand.get.getTabCompletionOptions(server, sender, args.tail, pos)
    }
  }

  lazy val subCommandNames: List[String] =
    subCommands
      .filterNot(c => c.isInstanceOf[DynamicCommand])
      .map(_.name)

  lazy val childDynamicCommandTypes = subCommands collect {case c:DynamicCommand => s"[${c.commandType}]"} distinct
}

trait IntermediateCommand extends ImproveCommand {
  def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) = {
    lazy val nextCommand = subCommands.find(c => c.name == args.head)
    if (args.isEmpty || !super.checkPermission(server, sender) || nextCommand.isEmpty) {
      sender.addChatMessage(new TextComponentString(usageString))
    } else {
      nextCommand.get.execute(server, sender, args.tail)
    }
  }
}

trait RootCommand extends IntermediateCommand {
  val parent = None
}

trait PlayerCommand extends ImproveCommand {
  override def checkPermission(server: MinecraftServer, sender: ICommandSender) = sender.isInstanceOf[EntityPlayerMP]
}

abstract class TerminalCommand(override val name:String) extends ImproveCommand(name) {
  override val subCommands: List[ImproveCommand] = Nil
}


trait DynamicCommand extends IntermediateCommand {
  val commandType: String
}
