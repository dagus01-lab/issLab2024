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
with Diagram('sonarqakArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxsonar', graph_attr=nodeattr):
          sonar=Custom('sonar','./qakicons/symActorSmall.png')
          sonarusage=Custom('sonarusage','./qakicons/symActorSmall.png')
          dataCleaner=Custom('dataCleaner(coded)','./qakicons/codedQActor.png')
          distanceFilter=Custom('distanceFilter(coded)','./qakicons/codedQActor.png')
     sonarusage >> Edge(color='blue', style='solid',  decorate='true', label='<sonarstart &nbsp; sonarstop &nbsp; >',  fontcolor='blue') >> sonar
diag
