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
with Diagram('wolfdetlogarchArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxwdtest', graph_attr=nodeattr):
          station=Custom('station','./qakicons/symActorSmall.png')
          ledred=Custom('ledred','./qakicons/symActorSmall.png')
          ledblu=Custom('ledblu','./qakicons/symActorSmall.png')
          camera=Custom('camera','./qakicons/symActorSmall.png')
          wolfdetector=Custom('wolfdetector','./qakicons/symActorSmall.png')
          sonarmock=Custom('sonarmock','./qakicons/symActorSmall.png')
          imagesender=Custom('imagesender','./qakicons/symActorSmall.png')
     facadesmathasynch=Custom('facadesmathasynch','./qakicons/server.png')
     sonarmock >> Edge( label='obstacle', **eventedgeattr, decorate='true', fontcolor='red') >> wolfdetector
     wolfdetector >> Edge(color='magenta', style='solid', decorate='true', label='<detectWolf<font color="darkgreen"> iswolf</font> &nbsp; >',  fontcolor='magenta') >> imagesender
     wolfdetector >> Edge(color='magenta', style='solid', decorate='true', label='<takePhoto<font color="darkgreen"> photo</font> &nbsp; >',  fontcolor='magenta') >> camera
     facadesmathasynch >> Edge(color='blue', style='solid', decorate='true', label='< &harr; >',  fontcolor='blue') >> smathasynchfacade
     wolfdetector >> Edge(color='blue', style='solid',  decorate='true', label='<ledCmd &nbsp; >',  fontcolor='blue') >> ledred
     station >> Edge(color='blue', style='solid',  decorate='true', label='<startsonar &nbsp; >',  fontcolor='blue') >> wolfdetector
     wolfdetector >> Edge(color='blue', style='solid',  decorate='true', label='<ledCmd &nbsp; >',  fontcolor='blue') >> ledblu
diag
