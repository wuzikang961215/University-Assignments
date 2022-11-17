#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <cmath>

/* 
    Student ID: a1816094
    Student name: Zikang, Wu
                            */

using namespace std;

int main(int argc, char* argv[]){
    // reading three text files
    ifstream attributes(argv[1]);
    ifstream query(argv[2]);
    ifstream accessFrequency(argv[3]);

    // calculating lines of att file
    fstream readAttLine(argv[1],ios::in);
    char changeLine;
    int atts = 0;
    while(readAttLine.get(changeLine)){
        if(changeLine=='\n')
        atts++;
    }
    readAttLine.close();
    // calculating lines of query file
    fstream readQueryLine(argv[2],ios::in);
    int queries = 0;
    while(readQueryLine.get(changeLine)){
        if(changeLine=='\n')
        queries++;
    }
    readQueryLine.close();

    // calculating rows of acc file
    fstream readAccRow(argv[3],ios::in);
    char space;
    int sites = 0;
    while(readAccRow.get(space)){
        if(space=='S')
        sites++;
        if(space=='\n')
        break;
    }
    readAccRow.close();

    string attribute[atts][2];
    string accStr[queries+1][sites+1];
    string accF[queries+1][sites+1];
    int accFre[queries][sites];
    string querys[queries];
    int use[queries][atts-1];

    // attributes stored
    for(int i = 0; i < atts; i++){
        for(int j = 0; j < 2; j++){
            attributes >> attribute[i][j];
        }
    }

    // access frequency stored
    for(int i = 0; i < queries+1; i++){
        for(int j = 0; j < sites+1; j++){
            accessFrequency >> accF[i][j+1];
        }
    }
    // transferring strings into int
    for(int i = 1; i < queries+1; i++){
        int x = 0;
        for(int j = 1; j < sites+1; j++){
            stringstream transfer;
            transfer << accF[i][j];
            transfer >> accFre[i-1][j-1];
        }
    }
    // storing queries line by line 
    string q;
    int x = 0;
    while(getline(query, q) && x < queries){
        string qNo = "q";
        if(q.find(qNo) == 0){
            querys[x] = q;
        }
        x++;
    }
    // finding key words in queries
    string::size_type position;
    string::size_type findStr;
    for(int i = 0; i<queries; i++){
        for(int m = 1; m < atts; m++){
            position = querys[i].find(attribute[m][1]);
            int findAtt = querys[i].find(attribute[m][1]);
            const char * query = querys[i].c_str();
            char space[] = " ";
            char comma[] = ",";
            char equal[] = "=";
            char bracket[] = "(";
            // distinguishing from the coincidence of strings
            if(position != querys[i].npos){
                if(query[findAtt-1] == space[0] || query[findAtt-1] == comma[0] || query[findAtt-1] == equal[0] || query[findAtt-1] == bracket[0])
                use[i][m-1] = 1;
            }
            else{
                use[i][m-1] = 0;
            }
        }
    }
    attributes.close();
    query.close();
    accessFrequency.close();
    // calculating AA matrix array
    int aaMatrix[atts-1][atts-1];
    for(int i = 0; i < atts-1 ; i++){
        for(int j = 0; j < atts-1; j++){
            int sumAjk = 0;
            int sumAik = 0;
            int mul = 0;
            int Aik[queries];
            int Ajk[queries];
            for(int k = 0; k < queries; k++){
                int sumAcc = 0;
                for(int c = 0; c < sites; c++){
                    sumAcc += accFre[k][c];
                }
                Aik[k] = use[k][i]*sumAcc;
                Ajk[k] = use[k][j]*sumAcc;
                sumAjk = sumAjk + Ajk[k];
                sumAik = sumAik + Aik[k];
                mul = mul + Ajk[k]*Aik[k];
            }
            aaMatrix[i][j] = ceil(mul/sqrt(sumAik*sumAjk));
        }
    }
    // printing aa matrix out
    for(int i = 0; i < atts-1; i++){
        for(int j = 0; j < atts-1; j++){
            printf("%d ",aaMatrix[i][j]);
            if(j == atts-2){
                printf("\n");
            }
        }
    }

    return 0;
}


