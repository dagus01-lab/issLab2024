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
with Diagram('ledqakArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxled', graph_attr=nodeattr):
          led=Custom('led','./qakicons/symActorSmall.png')
          ledusage=Custom('ledusage','./qakicons/symActorSmall.png')
     facadesmathasynch=Custom('facadesmathasynch','./qakicons/server.png')
     facadesmathasynch >> Edge(color='blue', style='solid', decorate='true', label='< &harr; >',  fontcolor='blue') >> smathasynchfacade
     ledusage >> Edge(color='blue', style='solid',  decorate='true', label='<led_on &nbsp; led_off &nbsp; >',  fontcolor='blue') >> led
diag
