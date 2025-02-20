### conda install diagrams
from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
evattr = {
    'color': 'darkgreen',
    'style': 'dotted'
}
with Diagram('pingpong24Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxtest', graph_attr=nodeattr):
          ping=Custom('ping','./qakicons/symActorSmall.png')
          pong=Custom('pong','./qakicons/symActorSmall.png')
          referee=Custom('referee','./qakicons/symActorSmall.png')
     sys >> Edge( label='startgame', **evattr, decorate='true', fontcolor='darkgreen') >> ping
     sys >> Edge( label='stopgame', **evattr, decorate='true', fontcolor='darkgreen') >> ping
     sys >> Edge( label='stopgame', **evattr, decorate='true', fontcolor='darkgreen') >> pong
     referee >> Edge( label='startgame', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     referee >> Edge( label='stopgame', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     pong >> Edge(color='blue', style='solid',  decorate='true', label='<ball &nbsp; >',  fontcolor='blue') >> ping
     ping >> Edge(color='blue', style='solid',  decorate='true', label='<ball &nbsp; >',  fontcolor='blue') >> pong
     pong >> Edge(color='blue', style='solid',  decorate='true', label='<ballview &nbsp; >',  fontcolor='blue') >> referee
     ping >> Edge(color='blue', style='solid',  decorate='true', label='<ballview &nbsp; >',  fontcolor='blue') >> referee
diag
