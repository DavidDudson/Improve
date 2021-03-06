package nz.daved.player

import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.stats.StatBase

object PlayerImplicits {

  implicit class EntityPlayerMPImplicits(player: EntityPlayerMP) {
    def getStat(stat: StatBase) = player.getStatFile.readStat(stat)
  }
}
