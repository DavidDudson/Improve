package nz.daved.stat

import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.stats.StatBase
import net.minecraft.util.text.TextComponentString
import nz.daved.player.PlayerImplicits._

object StatPrinter {

  def printStat(player: EntityPlayerMP, stat:StatBase) =
    player.addChatMessage(new TextComponentString(stat.getStatName.getUnformattedText + " : " + player.getStat(stat)))

  def printStats(player: EntityPlayerMP, stats: List[StatBase]) = stats.foreach(s => printStat(player, s))

  def printNonZeroStats(player: EntityPlayerMP, stats: List[StatBase]) = stats.filter(s => player.getStat(s) > 0).foreach(s => printStat(player, s))
}
