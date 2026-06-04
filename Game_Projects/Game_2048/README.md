# README #

## Group Information ##

**Team Members**
Sanika Thatte
Ziya Ahmad
Irene Yang

**Group Number:** 1

**Period:**	5

**Game Title:** 2048 Game

## Game Proposal ##

We are planning to develop the game 2048. In the game, the user will slide numbered tiles around a 4x4 grid using the arrow keys (keyboard commands). When two tiles with the same number bump into each other, they combine into one, with the value of the sum. The goal is to reach the 2048 tile. We will include original features from the game like a working grid, smooth tile movement, keeping track of score, and a restart button. To add extra features, we will add sound effects, different modes, and potential powerups including "bombs," which is when, instead of a number, a bomb graphic slides down from the top and removes any values from the nearby vicinity. The game can end if the grid is entirely full and no more moves can be made.

Game Controls:
Keyboard actions: Left, Right, Up, Down arrows

Game Elements:
+ grid based system (entire game occcurs on a 4x4 grid)
+ numbered tiles (all tiles are powers of 2)
	+ if two tiles w/ same number value merge, they are replaced with one tile of the value of their sums
+ mechanics: 
	+ every move adds 1 new tile (usually 2 or 4) to an empty cell
	+ ONLY easy mode has undo function (potentially, if we have time)
	+ merging can only occur once per move

How to Win:
+ reach 2048
+ lose: fill the entire grid with no playable moves left

## Link Examples ##
+ (https://www.mathsisfun.com/games/2048.html)

## Teacher Response ##

This looks like a good plan.

## Class Design and Brainstorm ##

+ Text class
+ MyWorld class (world must be grid)
+ Tile class (parameters w/ color + number)
+ Bomb class (or whatever we change the special feature to)
+ Button class
+ MenuWorld
	+ WinWorld??
	+ LoseWorld??
	+ Something for instructions??