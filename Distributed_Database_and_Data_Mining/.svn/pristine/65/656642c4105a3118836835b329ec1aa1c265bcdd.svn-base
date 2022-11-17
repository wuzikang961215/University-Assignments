#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <cmath>

using namespace std;

/* 
    Student ID: a1816094
    Student name: Zikang, Wu
                            */

int main(int argc,char*argv[]){
    // reading aa matrix
    ifstream readMatrix(argv[1]);

    // calculating attributes
    fstream calculateAtts(argv[1],ios::in);
    char changeLine;
    int atts = 0;
    while(calculateAtts.get(changeLine)){
        if(changeLine=='\n')
        atts++;
    }

    int rows[atts];
    int lines[atts];
    // aa matrix stored in array
    int aaMatrix[atts][atts];
    for(int i = 0; i < atts; i++){
        for(int j = 0; j < atts; j++){
            readMatrix >> aaMatrix[i][j];
            rows[i] = i+1;
            lines[j] = j+1;
        }
    }

    // initializing cont array inside loop
    for(int i = 1; i < atts; i++){
        int cont[i+1];
        int j;
        for(j = 0; j < i+1; j++){
            int bond1 = 0, bond2 = 0, bond3 = 0;
            for(int n = 0; n < atts; n++){
                // at the beginning of the matrix
                if(j == 0){
                    bond1 = bond3 = 0;
                    bond2 += aaMatrix[n][i]*aaMatrix[n][j];
                }
                // where aaMatrix[j] is at just the same position before
                else if(j == i){
                    bond2 = bond3 = 0;
                    bond1 += aaMatrix[n][j-1]*aaMatrix[n][i];
                }
                else{
                    bond1 += aaMatrix[n][j-1]*aaMatrix[n][i];
                    bond2 += aaMatrix[n][i]*aaMatrix[n][j];
                    bond3 += aaMatrix[n][j-1]*aaMatrix[n][j];
                }
            }
            cont[j] = 2*bond1 + 2*bond2 - 2*bond3;
        }
        // comparing values of cont[j]
        int contMax = 0;
        int maxValue = cont[0];
        for(int x = 1; x < j; x++){
            if(cont[x]>=maxValue){
                maxValue = cont[x];
                contMax = x;
            }
            for(int k = 0; k <x; k++){
                if(cont[contMax] == cont[k])contMax = k;
            }
        }
        if(contMax < i){
            int rowChanged[atts];
            // saving the ith row
            for(int k = 0; k < atts; k++){
                rowChanged[k] = aaMatrix[k][i]; 
            }
            int r = rows[i];
            // moving rows backwards
            for(int row = i; row >contMax; row--){
                for(int z = 0; z < atts; z++){
                    aaMatrix[z][row] = aaMatrix[z][row-1];
                }
                rows[row] = rows[row-1];
            }
            // moving the ith row to expected position
            for(int l = 0; l < atts; l++){
                aaMatrix[l][contMax] = rowChanged[l];
            }
            rows[contMax] = r;
            // saving the ith line
            for(int k = 0; k < atts; k++){
                rowChanged[k] = aaMatrix[i][k]; 
            }
            int l = lines[i];
            // moving lines backwards
            for(int line = i; line > contMax; line--){
                for(int z = 0; z < atts; z++){
                    aaMatrix[line][z] = aaMatrix[line-1][z];
                }
                lines[line] = lines[line-1];
            }
            // moving the ith line to expected position
            for(int l = 0; l < atts; l++){
                aaMatrix[contMax][l] = rowChanged[l];
            }
            lines[contMax] = l;

        }
    }
    
    // printing the CA matrix
    for(int i = atts-1; i >=0; i--)
        printf(" A%d",rows[i]);
        printf("\n");

    for(int i = atts-1; i >=0; i--){
        printf("A%d ",lines[i]);
        for(int j = atts-1; j >=0; j--){
            printf("%d ", aaMatrix[i][j]);
            if(j ==0){
                printf("\n");
            }
        }
    }
    return 0;
}