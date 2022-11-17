#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <cmath>
#include <iomanip>

using namespace std;

// Network packets are stored here
struct NetworkPacket{
        public:
        string src_addr;
        int src_port;
        string dst_addr;
        int dst_port;
 
        int protocol;
        int arrivalTime;
        int packetLength;
};
 
// Flows are stored here for easy access to thier averages
struct NetworkFlow{
        public:
        int index;
        double averageLength;
        double averageTransferTime;
        vector<int> time;
        vector<int> length;
        // for removing the medoids
        int repeat;
};
 
// Clusters are stored here
struct Cluster{
        public:
        int index;
        NetworkFlow center;
        vector<NetworkFlow> flows;
        double totalCost;
};
 
// Read packets in from an input file through a string stream
vector<NetworkPacket> readPackets(string inputFile){
        vector<NetworkPacket> output;
        stringstream ss;
 
        ifstream file(inputFile);
        string line;
 
        if (file.is_open()){
                getline(file, line);
                while(getline(file, line)){
                        // read the attributes
                        NetworkPacket current;
                        ss << line;
                        ss >> current.src_addr;
                        ss >> current.src_port;
                        ss >> current.dst_addr;
                        ss >> current.dst_port;
                        ss >> current.protocol;
                        ss >> current.arrivalTime;
                        ss >> current.packetLength;
                        ss.clear();
 
                        output.push_back(current);
                }
                file.close();
        }
        return output;
}

// Read the medoids input file and assign them to a vector
vector<int> readMedoids(string inputFile){
        vector<int> output;
 
        ifstream file(inputFile);
        string segment;
 
        if(file.is_open()){
                file >> segment;
 
                while(file >> segment){
                        output.push_back(stoi(segment));
                }
        }
 
        file.close();
 
        return output;
}

// function to add a flow
NetworkFlow addFlow(int n){
    NetworkFlow flow;
    flow.index = n;
    return flow;
}
 
// calculate the distance between two flows
double calculateDistance(NetworkFlow flow1, NetworkFlow flow2){
        double n1 = fabs(flow1.averageTransferTime - flow2.averageTransferTime);
        double n2 = fabs(flow1.averageLength - flow2.averageLength);
        return (n1+n2);
}

// function to add a cluster
Cluster addCluster(int n){
    Cluster cluster;
    cluster.index = n;
    return cluster;
}

// function to build clusters and put medoids in
vector <Cluster> buildClusters(vector <NetworkFlow> flows, vector <int> medoids){
    vector <Cluster> clusters;
    // create clusters
    int clusterIndex = 0;
    for(int j = 0; j < medoids.size(); j++){
        clusters.push_back(addCluster(clusterIndex));
        clusters.at(clusterIndex).center = flows[medoids[j]];
        clusterIndex++;
    }
    return clusters;
}

// remove medoids from flows
vector <NetworkFlow> removeMedoids(vector <NetworkFlow> flows, vector <int> medoids){
    for(int i = 0; i < flows.size(); i++){
        flows.at(i).repeat = 0;
        for(int j = 0; j < medoids.size(); j++){
            if( i == medoids[j]){
                flows.at(i).repeat = 1;
                break;
            }
        }
    }
    return flows;
}

// calculate the sum of distance from all flows to their medoids
double sumDistances(NetworkFlow medoid, Cluster cluster){
    double distancesSum;
    for(int i = 0; i < cluster.flows.size(); i++){
        // exclude the medoid
        if(cluster.flows.at(i).repeat != 1)
            distancesSum += calculateDistance(medoid, cluster.flows[i]);
    }
    return distancesSum;
}

// output the flow.txt file
void outputFlow(string fileName, vector<NetworkFlow> flows){
    ofstream outFile(fileName);
    for(int i = 0; i < flows.size(); i++){
        outFile << flows.at(i).index << " ";
        outFile << fixed << setprecision(2) << flows.at(i).averageTransferTime << " ";
        outFile << fixed << setprecision(2) << flows.at(i).averageLength << " ";
        outFile << endl;
    }
}

// print out the clusters
void outputClusters(double absoluteError, vector<int> medoids, vector<NetworkFlow> flows, vector<Cluster> clusters){
    // output file 
    ofstream outputFile("KMedoidsClusters.txt");
    outputFile << fixed << setprecision(2) << absoluteError << endl;
    for(int i = 0; i < medoids.size(); i++)
        outputFile << medoids[i] << " ";
    outputFile << endl;
    for(int i = 0; i < clusters.size(); i++){
        for(int j = 0; j < clusters.at(i).flows.size(); j++){
            outputFile << clusters.at(i).flows.at(j).index << " ";
        }
        outputFile << endl;
    }
}

vector <Cluster> flowsToClusters(vector<NetworkFlow> flows, vector<Cluster> clusters, vector <int> medoids){
    
    //flows = removeMedoids(flows, medoids);

    // assign flows to clusters
    for(int i = 0; i < flows.size(); i++){
        // min is the index of smallest distance
        int min = 0;
        double minDistance = calculateDistance(flows[i],clusters.at(0).center);
        for(int j = 1; j < clusters.size(); j++){
            if(calculateDistance(flows[i],clusters.at(j).center) < minDistance){
                minDistance = calculateDistance(flows[i],clusters.at(j).center);
                min = j;
            }

        }
        // put flows[i] in cluster[k]
        clusters.at(min).flows.push_back(flows[i]);
    }
    return clusters;
}

vector <NetworkFlow> createFlows(vector<NetworkPacket> networkPacket){
// vector for saving the flows
    vector<NetworkFlow> flows;

    int flowIndex = 0;
    // searching for flows in packets vector and create flows
    for(int i = 0; i < networkPacket.size()-1; i++){
        int j = i + 1;
        int k = i + 1;
        int count = 0;
        // if find the same src_port and others, creat a new flow
        while(j < networkPacket.size()){
            if(networkPacket.at(j).src_addr == networkPacket.at(i).src_addr 
            && networkPacket.at(j).dst_addr == networkPacket.at(i).dst_addr
            && networkPacket.at(j).src_port == networkPacket.at(i).src_port
            && networkPacket.at(j).dst_port == networkPacket.at(i).dst_port
            && networkPacket.at(j).protocol == networkPacket.at(i).protocol){
                // see if there are same flows to avoid repeating

                for(int k = 0; k < i; k++){
                    if(networkPacket.at(k).src_addr == networkPacket.at(i).src_addr 
                    && networkPacket.at(k).dst_addr == networkPacket.at(i).dst_addr
                    && networkPacket.at(k).src_port == networkPacket.at(i).src_port
                    && networkPacket.at(k).dst_port == networkPacket.at(i).dst_port
                    && networkPacket.at(k).protocol == networkPacket.at(i).protocol)
                        count++;   
                }
                //cout << count << endl;
                if(count == 0){
                    // if there is no same flows before, creat a new flow and put times and lengths in
                    flows.push_back(addFlow(flowIndex));
                    for(int n = i; n < networkPacket.size(); n++){
                        if(networkPacket.at(n).src_addr == networkPacket.at(i).src_addr
                        && networkPacket.at(n).dst_addr == networkPacket.at(i).dst_addr
                        && networkPacket.at(n).src_port == networkPacket.at(i).src_port
                        && networkPacket.at(n).dst_port == networkPacket.at(i).dst_port
                        && networkPacket.at(n).protocol == networkPacket.at(i).protocol
                        ){
                            flows[flowIndex].time.push_back(networkPacket.at(n).arrivalTime);
                            flows[flowIndex].length.push_back(networkPacket.at(n).packetLength);
                        }
                    }
                    // calculate average transfer time and average length here
                    int timeSum = 0;
                    for(int a = flows[flowIndex].time.size()-1; a > 0; a--)
                        timeSum += flows[flowIndex].time[a] - flows[flowIndex].time[a-1];
                    flows[flowIndex].averageTransferTime = (double)timeSum/(double)(flows[flowIndex].time.size()-1);

                    int lengthSum = 0;
                    for(int b = 0; b < flows[flowIndex].length.size(); b++)
                        lengthSum += flows[flowIndex].length[b];
                    flows[flowIndex].averageLength = (double)lengthSum/(double)(flows[flowIndex].length.size());

                    flowIndex++;
                        
                    break;
                }
                
            }
            j++;
        }
    }
    return flows;
}

double getAbsoluteError(vector <Cluster> clusters){
    // sum up the distances
    double sum = 0;
    for(int i = 0; i < clusters.size() ; i++)
        sum += sumDistances(clusters.at(i).center, clusters[i]);
    return sum;
}

// update the clusters
void updateClusters(vector <NetworkFlow> flows, vector <Cluster> clusters, vector <int> medoids, double absoluteError){
    // build clusters and put medoids in
    clusters = buildClusters(flows, medoids);
    // put flows in clusters
    clusters = flowsToClusters(flows, clusters, medoids);
    // get total cost
    absoluteError = getAbsoluteError(clusters);
    // remove medoids
    flows = removeMedoids(flows, medoids);
}

int main(int argc, char* argv[]){ //int argc, char* argv[]

    vector<NetworkPacket> networkPacket = readPackets(argv[1]);//argv[1]
    vector<int> medoids = readMedoids(argv[2]);//argv[2]
    vector<NetworkFlow> flows = createFlows(networkPacket);

    // print out the flows
    outputFlow("Flow.txt", flows);

    // these four ones may go in a while loop
        // remove the medoids in a flow
        flows = removeMedoids(flows, medoids);
        // build clusters and put medoids in
        vector <Cluster> clusters = buildClusters(flows, medoids);
        // put flows in clusters
        clusters = flowsToClusters(flows, clusters, medoids);
        // get the absolute error
        double absoluteError = getAbsoluteError(clusters);

    while(true){
        
        absoluteError = getAbsoluteError(clusters);
        // to end the outer loop
        int swaps = 0;
        for(int i = 0; i < flows.size(); i++){
            if(flows.at(i).repeat != 1){
                for(int j = 0; j < medoids.size(); j++){
                    double totalCost = 0; // may change position
                    vector <int> medoidsCopy = medoids;
                    medoidsCopy[j] = i;
                    vector <NetworkFlow> flowsChanged = removeMedoids(flows, medoidsCopy);
                    vector <Cluster> clusterChanged = buildClusters(flowsChanged, medoidsCopy);
                    clusterChanged = flowsToClusters(flowsChanged, clusterChanged, medoidsCopy);
                    double newError = getAbsoluteError(clusterChanged);
                    totalCost = newError - absoluteError;
                    // swap here
                    if(totalCost < 0){
                        // update medoids and clusters
                        medoids[j] = i;
                        // remove medoids
                        flows = removeMedoids(flows, medoids);
                        // build clusters and put medoids in
                        clusters = buildClusters(flows, medoids);
                        // put flows in clusters
                        clusters = flowsToClusters(flows, clusters, medoids);
                        // get absolute error
                        absoluteError = getAbsoluteError(clusters);
                        
                        swaps++;
                        break;
                    }
                }   
            }
            if(swaps != 0)
                break; 
        }
        if(swaps == 0)
            break;
        
    }

    // now kmedoid method is finished, print out the clusters
    outputClusters(absoluteError, medoids, flows, clusters);
    

    return 0;

}