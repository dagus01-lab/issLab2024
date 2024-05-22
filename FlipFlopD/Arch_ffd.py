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
with Diagram('ffdArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxffd', graph_attr=nodeattr):
          norset=Custom('norset','./qakicons/symActorSmall.png')
          norreset=Custom('norreset','./qakicons/symActorSmall.png')
          ffdcircuit=Custom('ffdcircuit','./qakicons/symActorSmall.png')
          observer=Custom('observer','./qakicons/symActorSmall.png')
          clientmock=Custom('clientmock','./qakicons/symActorSmall.png')
     norreset >> Edge( label='output', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     clientmock >> Edge(color='blue', style='solid',  decorate='true', label='<set1 &nbsp; set0 &nbsp; reset1 &nbsp; reset0 &nbsp; >',  fontcolor='blue') >> ffdcircuit
     ffdcircuit >> Edge(color='blue', style='solid',  decorate='true', label='<oni2 &nbsp; offi2 &nbsp; >',  fontcolor='blue') >> norset
     ffdcircuit >> Edge(color='blue', style='solid',  decorate='true', label='<oni1 &nbsp; offi1 &nbsp; >',  fontcolor='blue') >> norreset
     norset >> Edge(color='blue', style='solid',  decorate='true', label='<oni2 &nbsp; offi2 &nbsp; >',  fontcolor='blue') >> norreset
     norreset >> Edge(color='blue', style='solid',  decorate='true', label='<oni1 &nbsp; offi1 &nbsp; >',  fontcolor='blue') >> norset
diag
