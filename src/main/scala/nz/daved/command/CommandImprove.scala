package nz.daved.command

import net.minecraft.client.entity.EntityPlayerSP

import scala.collection.JavaConversions._
import net.minecraft.command.{ICommand, ICommandSender}
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}
import net.minecraft.server.MinecraftServer
import net.minecraft.stats.StatList
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString
import nz.daved.Improve

case class CommandImprove() extends ICommand {
  override def getCommandName = "improve"

  override def getCommandAliases = List("improve", "imp")

  override def isUsernameIndex(args: Array[String], index: Int) = false

  override def getCommandUsage(sender: ICommandSender): String = "Currently on \"improve\" is supported"

  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]) = {
    sender match {
      case player:EntityPlayerMP => player.getStatFile.readStat(StatList.MINE_BLOCK_STATS)
    }
    val player: EntityPlayerMP = sender.asInstanceOf[EntityPlayerMP]
    player.getSta
    player.addChatMessage(new TextComponentString("Executed Command"))
    Improve.logger.info("Executed Command")
  }

  override def getTabCompletionOptions(
      server: MinecraftServer,
      sender: ICommandSender,
      args: Array[String],
      pos: BlockPos) = Nil

  override def checkPermission(server: MinecraftServer, sender: ICommandSender) = sender.isInstanceOf[EntityPlayer]

  override def compareTo(o: ICommand) = 0
}
