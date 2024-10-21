%====================================================================================
% gol description   
%====================================================================================
dispatch( guicmd, guicmd(C) ). %Commands sent by the GUI to the goldisplay
event( gameReady, gameReady(N) ). %Event that indicates that the game can be started
dispatch( gameStart, gameStart(N) ). %Event that simulates the beginning of the game
dispatch( gameStop, gameStop(N) ). %Event that simulates the end of the game
event( nextCellUpdate, nextCellUpdate(N) ). %Event that simulates the order from the controller to make a new update
event( clearCells, clearCells(N) ). %Event that allows to clear all the cells state
dispatch( cellUpdate, cellUpdate(C,S) ). %Message that simulates an update from cell C with status S
dispatch( cellReady, cellReady(M) ). %Message that indicates that a cell has been correctly initialized
dispatch( guidone, guidone(N) ). %Message that indicates that the GUI has successfully set up
dispatch( switchstate, switchstate(N) ). %Message that indicates that the cell must switch its state
%====================================================================================
context(ctx_gol, "localhost",  "TCP", "8050").
 qactor( goldisplay, ctx_gol, "it.unibo.goldisplay.Goldisplay").
 static(goldisplay).
  qactor( golinitializer, ctx_gol, "it.unibo.golinitializer.Golinitializer").
 static(golinitializer).
  qactor( golcontroller, ctx_gol, "it.unibo.golcontroller.Golcontroller").
 static(golcontroller).
  qactor( cell, ctx_gol, "it.unibo.cell.Cell").
dynamic(cell). %%Oct2023 
