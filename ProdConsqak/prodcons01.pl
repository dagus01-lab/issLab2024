%====================================================================================
% prodcons01 description   
%====================================================================================
dispatch( msgFd, msgFd(N) ). %Dispatch inviata dal producer al consumer
request( msgRq, msgRq(N) ). %Request inviata dal producer al consumer
%====================================================================================
context(ctxprodcons, "localhost",  "TCP", "8000").
 qactor( producer1, ctxprodcons, "it.unibo.producer1.Producer1").
 static(producer1).
  qactor( producer2, ctxprodcons, "it.unibo.producer2.Producer2").
 static(producer2).
  qactor( consumer, ctxprodcons, "it.unibo.consumer.Consumer").
 static(consumer).
