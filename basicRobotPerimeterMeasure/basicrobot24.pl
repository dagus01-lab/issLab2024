%====================================================================================
% basicrobot24 description   
%====================================================================================
dispatch( cmd, cmd(MOVE) ).
dispatch( end, end(ARG) ).
request( step, step(TIME) ).
reply( stepdone, stepdone(V) ).  %%for step
reply( stepfailed, stepfailed(DURATION,CAUSE) ).  %%for step
event( sonardata, sonar(DISTANCE) ).
event( obstacle, obstacle(X) ).
event( info, info(X) ).
request( doplan, doplan(PATH,STEPTIME) ).
reply( doplandone, doplandone(ARG) ).  %%for doplan
reply( doplanfailed, doplanfailed(ARG) ).  %%for doplan
dispatch( setrobotstate, setpos(X,Y,D) ).
request( engage, engage(OWNER,STEPTIME) ).
reply( engagedone, engagedone(ARG) ).  %%for engage
reply( engagerefused, engagerefused(ARG) ).  %%for engage
dispatch( disengage, disengage(ARG) ).
request( checkowner, checkowner(CALLER) ).
reply( checkownerok, checkownerok(ARG) ).  %%for checkowner
reply( checkownerfailed, checkownerfailed(ARG) ).  %%for checkowner
event( alarm, alarm(X) ).
dispatch( nextmove, nextmove(M) ).
dispatch( nomoremove, nomoremove(M) ).
dispatch( setdirection, dir(D) ).
request( moverobot, moverobot(TARGETX,TARGETY) ).
reply( moverobotdone, moverobotok(ARG) ).  %%for moverobot
reply( moverobotfailed, moverobotfailed(PLANDONE,PLANTODO) ).  %%for moverobot
dispatch( stepDone, stepDone(X) ).
dispatch( startMeasure, startMeasure(X) ).
request( getPerimeter, getPerimeter(N) ).
reply( perimeter, perimeter(N) ).  %%for getPerimeter
request( getrobotstate, getrobotstate(ARG) ).
reply( robotstate, robotstate(POS,DIR) ).  %%for getrobotstate
request( getenvmap, getenvmap(X) ).
reply( envmap, envmap(MAP) ).  %%for getenvmap
dispatch( pause, pause(N) ).
dispatch( brdata, brdata(N) ).
%====================================================================================
context(ctxbasicrobot, "localhost",  "TCP", "8020").
 qactor( engager, ctxbasicrobot, "it.unibo.engager.Engager").
 static(engager).
  qactor( basicrobot, ctxbasicrobot, "it.unibo.basicrobot.Basicrobot").
 static(basicrobot).
  qactor( planexec, ctxbasicrobot, "it.unibo.planexec.Planexec").
 static(planexec).
  qactor( robotpos, ctxbasicrobot, "it.unibo.robotpos.Robotpos").
 static(robotpos).
  qactor( perimetermeasure, ctxbasicrobot, "it.unibo.perimetermeasure.Perimetermeasure").
 static(perimetermeasure).
  qactor( sonarobs, ctxbasicrobot, "it.unibo.sonarobs.Sonarobs").
 static(sonarobs).
  qactor( basicrobotusage, ctxbasicrobot, "it.unibo.basicrobotusage.Basicrobotusage").
 static(basicrobotusage).
