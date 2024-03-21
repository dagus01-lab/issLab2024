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
with Diagram('prodcons01Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxprodcons', graph_attr=nodeattr):
          producer1=Custom('producer1','./qakicons/symActorSmall.png')
          producer2=Custom('producer2','./qakicons/symActorSmall.png')
          consumer=Custom('consumer','./qakicons/symActorSmall.png')
     producer1 >> Edge(color='magenta', style='solid', decorate='true', label='<msgRq &nbsp; >',  fontcolor='magenta') >> consumer
     producer2 >> Edge(color='magenta', style='solid', decorate='true', label='<msgRq &nbsp; >',  fontcolor='magenta') >> consumer
     producer1 >> Edge(color='blue', style='solid',  decorate='true', label='<msgFd &nbsp; >',  fontcolor='blue') >> consumer
     producer2 >> Edge(color='blue', style='solid',  decorate='true', label='<msgFd &nbsp; >',  fontcolor='blue') >> consumer
diag
