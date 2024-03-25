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
with Diagram('pingpong01Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxpingpong', graph_attr=nodeattr):
          a=Custom('a','./qakicons/symActorSmall.png')
          b=Custom('b','./qakicons/symActorSmall.png')
     b >> Edge(color='blue', style='solid',  decorate='true', label='<msg &nbsp; >',  fontcolor='blue') >> a
     a >> Edge(color='blue', style='solid',  decorate='true', label='<msg &nbsp; >',  fontcolor='blue') >> b
diag
