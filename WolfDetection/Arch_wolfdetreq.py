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
with Diagram('wolfdetreqArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxstation', graph_attr=nodeattr):
          station=Custom('station','./qakicons/symActorSmall.png')
     facadesmathasynch=Custom('facadesmathasynch','./qakicons/server.png')
     with Cluster('ctxsraspblu', graph_attr=nodeattr):
          ledblu=Custom('ledblu','./qakicons/symActorSmall.png')
          camera=Custom('camera','./qakicons/symActorSmall.png')
          sonarremote=Custom('sonarremote','./qakicons/symActorWithobjSmall.png')
     facadesmathasynch=Custom('facadesmathasynch','./qakicons/server.png')
     with Cluster('ctxsraspred', graph_attr=nodeattr):
          ledred=Custom('ledred','./qakicons/symActorSmall.png')
     facadesmathasynch=Custom('facadesmathasynch','./qakicons/server.png')
     facadesmathasynch >> Edge(color='blue', style='solid', decorate='true', label='< &harr; >',  fontcolor='blue') >> smathasynchfacade
     station >> Edge(color='blue', style='solid',  decorate='true', label='<startsonar &nbsp; stopsonar &nbsp; >',  fontcolor='blue') >> sonarremote
diag
