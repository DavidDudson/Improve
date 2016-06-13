package nz.daved.command

import scala.collection.JavaConversions._
import net.minecraft.command.{ICommand, ICommandSender}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer
import net.minecraft.util.math.BlockPos

case class CommandImprove() extends ICommand {
  override def getCommandName = "improve"

  override def getCommandAliases = List("improve", "imp")

  override def isUsernameIndex(args: Array[String], index: Int) = false

  override def getCommandUsage(sender: ICommandSender): String = "Currently on \"improve\" is supported"

  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) = print("Huzzah")

  override def getTabCompletionOptions(
      server: MinecraftServer,
      sender: ICommandSender,
      args: Array[String],
      pos: BlockPos) = Nil

  override def checkPermission(server: MinecraftServer, sender: ICommandSender) = sender.isInstanceOf[EntityPlayer]

  override def compareTo(o: ICommand) = 0
}
