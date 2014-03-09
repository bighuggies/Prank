Prank
=====
#### Author
Andrew "SpikeMeister" Hughson
#### Release Version
3.1 [2014-03-09]

Description
-----------
Prank is a Bukkit plugin for Minecraft which encompasses a number of pranks which can be applied to players on a server. Have fun with your users by scaring the crap out of them, frustrating them, and just generally trolling like a boss.

Installation
------------
Simply extract prank.jar to your CraftBukkit plugins folder and you are done.

Commands
--------
* /prank [pranktype] [player] - Start pranking [player] with [pranktype] prank. Player can be offline or online.
* /unprank [pranktype] [player] - Stop pranking [player] with [pranktype] prank. Player can be offline or online.

Pranks
------
### Creeper (/prank creeper [player])
Randomly spawn creepers around a player! Make them wonder why god hates them so much, as they mine or build and are plagued with a stream of creepers.

### Tool Switch (/prank toolswitch [player])
Switch the player's currently equipped item into the first empty slot of their inventory whenever they try to use it! Frustrate the hell out of players who can't accomplish anything!

### Shocking Fall (/prank shockingfall [player])
Whenever a player takes fall damage, strike them down with lightning! This prank can lay in wait for hours before it finally strikes... a player is innocently building or exploring when they make a jump that's just a little too high and - BAM, they are either dead or burning to death. They had better pray for water!

Permissions
-----------
* prank.*
* prank.creeper
* prank.toolswitch
* prank.shockingfall

Changelog
---------
* Version 2.1
	* Compatibility update
* Version 2.0
	* Re-released as "Prank"
	* Added tool switch prank
	* Added shocking fall prank
* Version 1.1
	* Added Bukkit permissions support
    * Removed the concept of a probability (unnecessary)
    * Added the ability to stop pranking all users at once (/stoppranking all)
* Version 1.0.1
	* Made the default probability a property
* Version 1.0
	* Initial release
