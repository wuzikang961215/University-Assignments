#include <iostream>
#include <vector>
using namespace std;

// hash slot
struct Slot{
    public:
    string value;
    char hashValue;
    string status;
};

// search key
int search(string key, Slot *table){
    char hashValue = key[key.length() - 1];
    std::vector<float>::size_type location = hashValue - 'a';
    int returnValue = -1;

    if(table[location].status == "never used" || table[location].value == key || table[location].status == "tombstone")
        returnValue = location;

    if(table[location].value != key && table[location].status != "never used"){

        for(std::vector<float>::size_type i = location; i < 26; i++){
            if(table[i].status == "never used" || table[i].value == key || table[i].status == "tombstone"){
                returnValue = i;
                break;
            }
        }
        
        if(returnValue == -1){
            for(std::vector<float>::size_type i = 0; i < location; i++){
                if(table[i].status == "never used" || table[i].value == key || table[i].status == "tombstone"){
                    returnValue = i;
                    break;
                }
            }
        }      
    }

    return returnValue;
}

// insert key
Slot* insert(string key, Slot *table){
    int location = search(key, table);

    // if already in the table
    if(table[location].value == key && table[location].status == "occupied")
        return table;

    else
    {
        table[location].value = key;
        table[location].status = "occupied";
    }
    
    return table;
}

Slot* remove(string key, Slot *table){
    int location = search(key, table);

    if(table[location].status == "never used")
        return table;
    
    else
        table[location].status = "tombstone";

    return table;
}

void print(Slot *table){
    for(std::vector<float>::size_type i = 0; i < 26; i++){
        if(table[i].status == "occupied")
            cout << table[i].value << " ";
    }
}


int main(){

    // declare a table
    Slot *table = new Slot[26];

    // initialize the table
    for(std::vector<float>::size_type i = 0; i < 26; i++){
        table[i].status = "never used";
        table[i].value = "";
    }
    
    table[0].hashValue = 'a';
    table[1].hashValue = 'b';
    table[2].hashValue = 'c';
    table[3].hashValue = 'd';
    table[4].hashValue = 'e';
    table[5].hashValue = 'f'; 
    table[6].hashValue = 'g';
    table[7].hashValue = 'h';
    table[8].hashValue = 'i';
    table[9].hashValue = 'j';
    table[10].hashValue = 'k';
    table[11].hashValue = 'l';
    table[12].hashValue = 'm';
    table[13].hashValue = 'n';
    table[14].hashValue = 'o';
    table[15].hashValue = 'p';
    table[16].hashValue = 'q';
    table[17].hashValue = 'r';
    table[18].hashValue = 's';
    table[19].hashValue = 't';
    table[20].hashValue = 'u';
    table[21].hashValue = 'v';
    table[22].hashValue = 'w';
    table[23].hashValue = 'x';
    table[24].hashValue = 'y';
    table[25].hashValue = 'z';


    // get the input
    string line;
    getline(cin, line);

    // insert now
    for(std::vector<float>::size_type i = 0; i < line.length(); i++){
        if(line[i] == 'A'){
            string current = "";
            for(std::vector<float>::size_type j = i+1; j < line.length(); j++){
                if(line[j] != ' ')
                    current += line[j]; // push the keys of insertion
                else if(line[j] == ' ')
                    break;
            }
            insert(current, table);
        }

        else if(line[i] == 'D'){
            string current = "";
            for(std::vector<float>::size_type j = i+1; j < line.length(); j++){
                if(line[j] != ' ')
                    current += line[j]; // push the keys of deletion
                else if(line[j] == ' ')
                    break;
            }
            remove(current, table);
        }
    }

    print(table);

    return 0;
}
