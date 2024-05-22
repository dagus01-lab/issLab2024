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
with Diagram('bw24Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxbw24', graph_attr=nodeattr):
          bw24core=Custom('bw24core','./qakicons/symActorWithobjSmall.png')
          sonar24mock=Custom('sonar24mock','./qakicons/symActorSmall.png')
          bwobserver=Custom('bwobserver','./qakicons/symActorSmall.png')
     facadesmathasynch=Custom('facadesmathasynch','./qakicons/server.png')
     sonar24mock >> Edge( label='wolf', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     facadesmathasynch >> Edge(color='blue', style='solid', decorate='true', label='< &harr; >',  fontcolor='blue') >> smathasynchfacade
diag
