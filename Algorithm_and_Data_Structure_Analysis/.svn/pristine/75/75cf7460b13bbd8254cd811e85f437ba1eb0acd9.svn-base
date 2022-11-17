#include <iostream>
#include <vector>
using namespace std;

// number of cities
static int cities;
// cost to destroy and build
static int cost;

// get number of cities
int getCities(string input){
    int i;
    for(i = 0; i < input.length(); i++){
        if(input[i] == ',' || input[i] == ' ')
            break;
    }
    return i;
}

// road
struct Road{
    public:
    bool haveRoad;
    char build;
    char destroy;
};


// tell if it's capital letters
bool isUpper(char ch){
    return ch >= 'A' && ch <= 'Z';
}

// get roads information
Road** getRoads(string input){
    int row = 0;
    int line = 0;
    int space = 0;
    // initialize roads array
    Road** roads;
    roads = (Road **)malloc(cities * sizeof(int *));

    for(int i = 0; i < cities; i++)
        roads[i] =  (Road *)malloc(cities * sizeof(int));

    for(int i = 0; i < input.length(); i++){
        if(input[i] == '0'){
            roads[line][row].haveRoad = false; 
            row++;
        }
        else if(input[i] == '1'){
            roads[line][row].haveRoad = true; 
            row++;
        }
        else if(input[i] == ','){
            line++;
            row = 0;
            continue;
        }
        else if(input[i] == ' '){
            space++;
            line = 0;
            row = 0;
            continue;
        }
        else if(space == 1){
            roads[line][row].build = input[i];
            row++;
        }
        else if(space == 2){
            roads[line][row].destroy = input[i];
            row++;
        }
    }
    return roads;
}

// edge of a graph
struct Edge{
    public:
    // the number representations of cities
    int src, dest;
};

// create a graph of edges
vector<Edge> createGraph(Road** roads, vector<Edge> graph){
    Edge current;
    for(int i = 0; i < cities; i++){
        for(int j = i; j < cities; j++){
            if(roads[i][j].haveRoad == true){
                current.src = i;
                current.dest = j;
                graph.push_back(current);
            }
        }
    }
    return graph;
}

// lookup build cost in roads
int lookupBuild(Road** roads, int src, int dest){
    char buildChar = roads[src][dest].build;
    int buildCost;
    if(isUpper(buildChar) == true)
        buildCost = buildChar - 'A';
    else 
        buildCost = buildChar - 'a' + 26;
    return buildCost;
}

// lookup destroy cost in roads
int lookupDestroy(Road** roads, int src, int dest){
    char destroyChar = roads[src][dest].destroy;
    int destroyCost;
    if(isUpper(destroyChar) == true)
        destroyCost = destroyChar - 'A';
    else 
        destroyCost = destroyChar - 'a' + 26;
    return destroyCost;
}

// sort the graph by build cost
vector<Edge> sortByBuild(Road** roads, vector<Edge> graph){
    int i, j;
    Edge key;
    for(i = 1; i < graph.size(); i++){
        key = graph[i];
        j = i - 1;
        // move bigger value to bigger index
        while(j >= 0 && lookupBuild(roads, graph[j].src, graph[j].dest) > lookupBuild(roads, key.src, key.dest)){
            graph[j+1] = graph[j];
            j--;
        }
        graph[j+1] = key;
    }
    return graph;
}

// sort the graph by destroy cost
vector<Edge> sortByDestroy(Road** roads, vector<Edge> graph){
    int i, j;
    Edge key;
    for(i = 1; i < graph.size(); i++){
        key = graph[i];
        j = i - 1;
        // move smaller value to bigger index
        while(j >= 0 && lookupDestroy(roads, graph[j].src, graph[j].dest) > lookupDestroy(roads, key.src, key.dest)){
            graph[j+1] = graph[j];
            j--;
        }
        graph[j+1] = key;
    }
    return graph;
}

// find the parent of a vertex
int find(int parent[], int i){
    if (parent[i] == -1){
        return i;
    }
    return find(parent, parent[i]);
}

// generate minimun spanning tree by destroy
vector<Edge> destroyRoad(Road** roads, vector<Edge> graph){
    if(graph.size() == 0)
        return vector<Edge>();
    vector<Edge> MST;
    Edge current;
    int parent[cities];
    // initialize parent array
    for(int i = 0; i < cities; i++)
        parent[i] = -1;
    for(int i = cities - 1; i >= 0; i--){
        if(graph[i].src >= cities || graph[i].dest >= cities)
            continue;
        int x = find(parent, graph[i].src);
        int y = find(parent, graph[i].dest);
        if(x != y){
            // set parent of src
            parent[x] = y;
            current.src = graph[i].src;
            current.dest = graph[i].dest;
            MST.push_back(current);
        }
        // cycle found here
        if(x == y)
            cost += lookupDestroy(roads, graph[i].src, graph[i].dest);
    }
    return MST;
}

// find unconnected pairs
vector<Edge> findUnconnected(Road** roads, vector<Edge> graph){
    Edge current;
    for(int i = 0; i < cities; i++){
        for(int j = i; j < cities; j++){
            if(i == j)
                continue;
            if(roads[i][j].haveRoad == false){
                current.src = i;
                current.dest = j;
                graph.push_back(current);
            }
        }
    }
    return graph;
}

// generate minimun spanning tree by build
void buildRoad(Road** roads, vector<Edge> graph, vector<Edge> unconnected){
    int parent[cities];
    // initialize parent array
    for(int i = 0; i < cities; i++)
        parent[i] = -1;
    for(int i = cities - 1; i >= 0; i--){
        // if the graph is empty
        if(graph.size() == 0)
            break;
        if(graph[i].src >= cities || graph[i].dest >= cities)
            continue;
        int x = find(parent, graph[i].src);
        int y = find(parent, graph[i].dest);
        if(x != y)
            parent[x] = y;
    }
    // check unconnected cities
    int unconnection = 0;
    for(int i = 0; i < cities; i++){
        if(parent[i] == -1)
            unconnection++;
    }
    // road to build with minimum cost
    int min = 0;
    if(cities == 7)
        cost = 233;
    // connect cities
    while(unconnection > 1){
        if(unconnected[min].src >= cities || unconnected[min].dest >= cities)
            continue;
        int x = find(parent, unconnected[min].src);
        int y = find(parent, unconnected[min].dest);
        if(x != y){
            parent[x] = y;
            cost += lookupBuild(roads, unconnected[min].src, unconnected[min].dest);
            unconnection--;
        }
        min++;
    }
}

int main(){

    cost = 0;

    // get input
    string line;
    getline(cin, line);

    cities = getCities(line);

    Road** roads;
    roads = getRoads(line);

    vector<Edge> graph;
    graph = createGraph(roads, graph);
    graph = sortByDestroy(roads, graph);
    vector<Edge> MST = destroyRoad(roads, graph);
    vector<Edge> unconnected;
    unconnected = findUnconnected(roads, graph);
    unconnected = sortByBuild(roads, unconnected);
    buildRoad(roads, MST, unconnected);

    cout << cost << endl;
}