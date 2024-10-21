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
with Diagram('golArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctx_gol', graph_attr=nodeattr):
          goldisplay=Custom('goldisplay','./qakicons/symActorWithobjSmall.png')
          golinitializer=Custom('golinitializer','./qakicons/symActorSmall.png')
          golcontroller=Custom('golcontroller','./qakicons/symActorSmall.png')
          cell=Custom('cell','./qakicons/symActorDynamic.png')
     sys >> Edge( label='gameReady', **evattr, decorate='true', fontcolor='darkgreen') >> goldisplay
     goldisplay >> Edge( label='clearCells', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     golinitializer >> Edge( label='gameReady', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     sys >> Edge( label='gameReady', **evattr, decorate='true', fontcolor='darkgreen') >> golcontroller
     golcontroller >> Edge( label='nextCellUpdate', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     sys >> Edge( label='gameReady', **evattr, decorate='true', fontcolor='darkgreen') >> cell
     sys >> Edge( label='nextCellUpdate', **evattr, decorate='true', fontcolor='darkgreen') >> cell
     goldisplay >> Edge(color='blue', style='solid',  decorate='true', label='<guidone &nbsp; >',  fontcolor='blue') >> golinitializer
     cell >> Edge(color='blue', style='solid',  decorate='true', label='<cellReady &nbsp; >',  fontcolor='blue') >> golinitializer
     goldisplay >> Edge(color='blue', style='solid',  decorate='true', label='<gameStart &nbsp; gameStop &nbsp; >',  fontcolor='blue') >> golcontroller
diag
