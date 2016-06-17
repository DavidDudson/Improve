package nz.daved.command

case class CommandImprove() extends ImproveCommand("improve") with RootCommand {

  override val subCommands: List[ImproveCommand] = List(CommandStat(Some(this)))
}
